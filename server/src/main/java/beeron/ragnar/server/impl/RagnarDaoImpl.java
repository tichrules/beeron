package beeron.ragnar.server.impl;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarDao;

public class RagnarDaoImpl implements RagnarDao {

	private EntityManager entityManager;

	public RagnarDaoImpl() throws NamingException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ragnar");
		entityManager = entityManagerFactory.createEntityManager();

	}

	/**
	 * 
	 * @see beeron.ragnar.common.RagnarDao#getRagnar()
	 */
	@Override
	public String getRagnar() {
		Person person = entityManager.find(PersonImpl.class, "Ragnar");
		return person.getName();
	}
}
