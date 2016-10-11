package beeron.ragnar.server.impl.controller;

import javax.ejb.EJB;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import beeron.ragnar.common.RagnarDao;

@Component
public class RagnarController {

	@EJB
	private RagnarDao ragnarDao;

	public RagnarController(RagnarDao ragnarDao) {
		this.ragnarDao = ragnarDao;
	}

	@RequestMapping("/person")
	public String ragnar(Model model) {
		model.addAttribute("people", ragnarDao.getPeople());
		return "ragnar";
	}

}
