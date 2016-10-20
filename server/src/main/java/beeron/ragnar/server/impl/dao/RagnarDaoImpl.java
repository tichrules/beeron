package beeron.ragnar.server.impl.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarDao;
import beeron.ragnar.server.impl.entity.PersonEntity;

@Repository
public class RagnarDaoImpl implements RagnarDao {

	@PersistenceContext(unitName = "Ragnar")
	private EntityManager entityManager;

	/**
	 * @see beeron.ragnar.common.RagnarDao#getPeople()
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
	 * @see beeron.ragnar.common.RagnarDao#insertPerson(beeron.ragnar.common.Person)
	 */
	@Override
	public int insertPerson(Person person) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setName(person.getName());
		personEntity.setActing(person.getActing());
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
}
