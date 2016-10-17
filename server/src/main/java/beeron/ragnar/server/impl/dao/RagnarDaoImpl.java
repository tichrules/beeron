package beeron.ragnar.server.impl.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beeron.ragnar.common.DaoException;
import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarDao;
import beeron.ragnar.server.impl.entity.PersonEntity;

@Repository
@Transactional
public class RagnarDaoImpl implements RagnarDao {

	@PersistenceContext
	private EntityManager entityManager;

	public RagnarDaoImpl(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}

	/**
	 * @see beeron.ragnar.common.RagnarDao#getPeople()
	 */
	@Override
	public List<Person> getPeople() {
		return Collections.unmodifiableList(entityManager.createQuery("FROM PERSON", PersonEntity.class).getResultList());
	}

	/**
	 * @see beeron.ragnar.common.RagnarDao#getPerson(java.lang.String)
	 */
	@Override
	public Person getPerson(String name) {
		return entityManager.find(PersonEntity.class, name);
	}

	/**
	 * @see beeron.ragnar.common.RagnarDao#insertPerson(beeron.ragnar.common.Person)
	 */
	@Override
	public void insertPerson(Person person) throws DaoException {
		try {
			PersonEntity personEntity = new PersonEntity();
			personEntity.setName(person.getName());
			personEntity.setActing(person.getActing());
			entityManager.persist(personEntity);
			entityManager.flush();
		} catch (PersistenceException e) {
			throw new DaoException(e.getCause());
		}
	}

	/**
	 * @see beeron.ragnar.common.RagnarDao#deletePerson(java.lang.String)
	 */
	@Override
	public void deletePerson(String name) throws DaoException {
		try {
			PersonEntity personEntity = entityManager.find(PersonEntity.class, name);
			entityManager.remove(personEntity);
			entityManager.flush();
		} catch (PersistenceException e) {
			throw new DaoException(e.getCause());
		}
	}
}
