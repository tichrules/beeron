package beeron.ragnar.server.impl.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beeron.ragnar.common.Location;
import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarService;
import beeron.ragnar.server.RagnarDao;

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

	/**
	 * @see beeron.ragnar.common.RagnarService#deletePerson(java.lang.String)
	 */
	@Override
	public void deletePerson(String name) {
		ragnarDao.deletePerson(name);
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#getMostPopularLocation()
	 */
	@Override
	public Location getMostPopularLocation() {
		return ragnarDao.getMostPopularLocation();
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#deleteLocation(java.lang.String)
	 */
	@Override
	public void deleteLocation(String name) {
		ragnarDao.deleteLocation(name);
	}

}
