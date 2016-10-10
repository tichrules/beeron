package beeron.ragnar.server.impl;

import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarDao;

@Repository
@Stateless
@Component
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RagnarDaoImpl implements RagnarDao {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * @see beeron.ragnar.common.RagnarDao#getPeople()
	 */
	@Override
	public List<Person> getPeople() {
		return Collections.unmodifiableList(entityManager.createQuery("FROM PERSON", PersonImpl.class).getResultList());
	}
}
