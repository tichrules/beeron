package beeron.ragnar.server.impl.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import beeron.ragnar.common.RagnarDao;
import beeron.ragnar.common.RagnarService;
import beeron.ragnar.server.impl.entity.PersonEntity;
import beeron.ragnar.server.impl.service.RagnarServiceImpl;

public class RagnarServiceTest {

	private RagnarService ragnarService;

	private RagnarDao ragnarDao;

	@Before
	public void setup() {
		ragnarDao = Mockito.mock(RagnarDao.class);
		ragnarService = new RagnarServiceImpl(ragnarDao);
	}

	@Test
	public void testRagnar() {
		ragnarService.deletePerson(1);
		ragnarService.insertPerson(new PersonEntity());
		ragnarService.getPeople();
		ragnarService.getPerson(1);
	}
}
