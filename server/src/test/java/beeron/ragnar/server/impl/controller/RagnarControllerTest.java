package beeron.ragnar.server.impl.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import beeron.ragnar.common.RagnarDao;

public class RagnarControllerTest {

	private RagnarController ragnarController;

	private RagnarDao ragnarDao;
	private Model model;

	@Before
	public void setup() {
		ragnarDao = Mockito.mock(RagnarDao.class);
		model = Mockito.mock(Model.class);
		ragnarController = new RagnarController(ragnarDao);
	}

	@Test
	public void testRagnar() {
		ragnarController.ragnar(model);
	}
}
