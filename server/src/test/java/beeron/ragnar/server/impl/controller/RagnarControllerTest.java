package beeron.ragnar.server.impl.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import beeron.ragnar.common.RagnarService;

public class RagnarControllerTest {

	private RagnarController ragnarController;

	private RagnarService ragnarService;
	private Model model;

	@Before
	public void setup() {
		ragnarService = Mockito.mock(RagnarService.class);
		model = Mockito.mock(Model.class);
		ragnarController = new RagnarController(ragnarService);
	}

	@Test
	public void testRagnar() {
		ragnarController.getAll(model);
	}
}
