package beeron.ragnar.server.impl;

import java.util.Collections;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.transaction.annotation.Transactional;

import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarDao;

@Transactional
public class RagnarDaoImpl implements RagnarDao {

	// @PersistenceContext(unitName = "Ragnar")
	private EntityManager entityManager;

	public RagnarDaoImpl() throws NamingException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ragnar");
		entityManager = entityManagerFactory.createEntityManager();

	}

	/**
	 * @see beeron.ragnar.common.RagnarDao#getPeople()
	 */
	@Override
	public List<Person> getPeople() {
		List<Person> people = Collections.unmodifiableList(entityManager.createQuery("FROM PERSON", PersonImpl.class).getResultList());
		return people;
	}
}
