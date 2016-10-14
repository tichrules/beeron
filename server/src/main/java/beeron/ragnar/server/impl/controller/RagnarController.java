package beeron.ragnar.server.impl.controller;

import javax.ejb.EJB;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import beeron.ragnar.common.RagnarDao;
import beeron.ragnar.server.impl.form.PersonForm;

@Component
@RequestMapping("/ragnar")
public class RagnarController {

	@EJB
	private RagnarDao ragnarDao;

	public RagnarController(RagnarDao ragnarDao) {
		this.ragnarDao = ragnarDao;
	}

	@RequestMapping(path = "/people", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("people", ragnarDao.getPeople());
		return "people";
	}

	@RequestMapping(path = "/person/{name}", method = RequestMethod.GET)
	public String get(@PathVariable String name, Model model) {
		model.addAttribute("person", ragnarDao.getPerson(name));
		return "person";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("personForm", new PersonForm());
		return "create";
	}

	@RequestMapping(path = "/people", method = RequestMethod.POST)
	public String add(@ModelAttribute PersonForm personForm, Model model) {
		try {
			ragnarDao.insertPerson(personForm);
			return "redirect:/ragnar/person/" + personForm.getName();
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			return "error";
		}
	}

	@RequestMapping(path = "/people/delete", method = RequestMethod.POST)
	public String delete(@RequestParam String name, Model model) {
		try {
			ragnarDao.deletePerson(name);
			return "redirect:/ragnar/people";
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			return "error";
		}
	}

}
