package beeron.ragnar.server.impl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarDao;
import beeron.ragnar.common.RagnarService;

@Service
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
	 * @see beeron.ragnar.common.RagnarService#getPerson(int)
	 */
	@Override
	public Person getPerson(int id) {
		return ragnarDao.getPerson(id);
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#deletePerson(int)
	 */
	@Override
	public void deletePerson(int id) {
		ragnarDao.deletePerson(id);
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#insertPerson(beeron.ragnar.common.Person)
	 */
	@Override
	public int insertPerson(Person person) {
		return ragnarDao.insertPerson(person);
	}

}
