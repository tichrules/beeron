package beeron.ragnar.server.impl.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarDao;
import beeron.ragnar.common.RagnarService;

@Service
@Transactional
public class RagnarServiceImpl implements RagnarService {

	private RagnarDao ragnarDao;

	public RagnarServiceImpl(RagnarDao ragnarDao) {
		this.ragnarDao = ragnarDao;
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#getPeople()
	 */
	@Override
	public List<Person> getPeople() {
		return ragnarDao.getPeople();
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#getPerson(java.lang.String)
	 */
	@Override
	public Person getPerson(String name) {
		return ragnarDao.getPerson(name);
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#deletePerson(java.lang.String)
	 */
	@Override
	public void deletePerson(String name) {
		ragnarDao.deletePerson(name);
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#insertPerson(beeron.ragnar.common.Person)
	 */
	@Override
	public void insertPerson(Person person) {
		ragnarDao.insertPerson(person);
	}

}
