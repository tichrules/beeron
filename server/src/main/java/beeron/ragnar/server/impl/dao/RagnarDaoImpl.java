package beeron.ragnar.server.impl.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import beeron.ragnar.common.Location;
import beeron.ragnar.common.Person;
import beeron.ragnar.server.RagnarDao;
import beeron.ragnar.server.impl.entity.LocationEntity;
import beeron.ragnar.server.impl.entity.PersonEntity;

@Repository
public class RagnarDaoImpl implements RagnarDao {

	@PersistenceContext(unitName = "Ragnar")
	private EntityManager entityManager;

	private static <T> T getSingleResult(List<T> list) {
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * @see beeron.ragnar.server.RagnarDao#getPeople()
	 */
	@Override
	public List<Person> getPeople() {
		return Collections.unmodifiableList(entityManager.createQuery("FROM PERSON", PersonEntity.class).getResultList());
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#getPerson(int)
	 */
	@Override
	public Person getPerson(int id) {
		return entityManager.find(PersonEntity.class, id);
	}

	/**
	 * @see beeron.ragnar.server.RagnarDao#insertPerson(beeron.ragnar.common.Person)
	 */
	@Override
	public int insertPerson(Person person) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setName(person.getName());
		personEntity.setActing(person.getActing());
		personEntity.setLocations(person.getLocations());
		entityManager.persist(personEntity);
		return personEntity.getId();
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#deletePerson(int)
	 */
	@Override
	public void deletePerson(int id) {
		PersonEntity personEntity = entityManager.find(PersonEntity.class, id);
		entityManager.remove(personEntity);
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#deletePerson(java.lang.String)
	 */
	@Override
	public void deletePerson(String name) {
		PersonEntity personEntity = getSingleResult(entityManager.createNamedQuery("Person.findByName", PersonEntity.class).setParameter("NAME", name).getResultList());
		if (personEntity != null) {
			entityManager.remove(personEntity);
		}
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#getMostPopularLocation()
	 */
	@Override
	public Location getMostPopularLocation() {
		LocationEntity locationEntity = (LocationEntity) entityManager.createNamedQuery("Location.findMostPopular").getSingleResult();
		return locationEntity;
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#deleteLocation(java.lang.String)
	 */
	@Override
	public void deleteLocation(String name) {
		LocationEntity locationEntity = getSingleResult(entityManager.createNamedQuery("Location.findByName", LocationEntity.class).setParameter("NAME", name).getResultList());
		if (locationEntity != null) {
			entityManager.remove(locationEntity);
		}
	}
}
