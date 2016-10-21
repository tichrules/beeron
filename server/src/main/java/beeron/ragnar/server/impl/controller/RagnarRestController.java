package beeron.ragnar.server.impl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarService;

@RestController
@RequestMapping("/ragnarrest")
public class RagnarRestController {

	private RagnarService ragnarService;

	public RagnarRestController(RagnarService ragnarService) {
		this.ragnarService = ragnarService;
	}

	@RequestMapping(path = "/person", method = RequestMethod.GET)
	public @ResponseBody Person getPerson(@RequestParam(value = "id") int id) {
		Person person = ragnarService.getPerson(id);
		return person;
		// PersonDto personDto = new PersonDto();
		// personDto.setId(person.getId());
		// personDto.setName(person.getName());
		// personDto.setActing(person.getActing());
		// return personDto;
	}
}
