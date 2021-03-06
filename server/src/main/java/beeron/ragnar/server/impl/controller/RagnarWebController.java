package beeron.ragnar.server.impl.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarService;
import beeron.ragnar.server.impl.form.PersonForm;

@Component
@RequestMapping("/ragnar")
public class RagnarWebController {

	private RagnarService ragnarService;

	public RagnarWebController(RagnarService ragnarService) {
		this.ragnarService = ragnarService;
	}

	@RequestMapping(path = "/people", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("people", ragnarService.getPeople());
		return "people";
	}

	@RequestMapping(path = "/person/{id}", method = RequestMethod.GET)
	public String get(@PathVariable int id, Model model) {
		Person person = ragnarService.getPerson(id);
		model.addAttribute("person", person);
		model.addAttribute("locations", person.getLocations());
		return "person";
	}

	@RequestMapping(path = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("personForm", new PersonForm());
		return "create";
	}

	@RequestMapping(path = "/people", method = RequestMethod.POST)
	public String add(@ModelAttribute PersonForm personForm, Model model) {
		int id = ragnarService.insertPerson(personForm);
		return "redirect:/ragnar/person/" + id;
	}

	@RequestMapping(path = "/people/delete", method = RequestMethod.POST)
	public String delete(@RequestParam int id, Model model) {
		ragnarService.deletePerson(id);
		return "redirect:/ragnar/people";
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", e.getMessage());
		mav.setViewName("error");
		return mav;
	}

}
