package beeron.ragnar.client;

import beeron.ragnar.client.service.RagnarServiceRest;
import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarService;

public class Launch {

	public static void main(String[] args) {
		RagnarService ragnarService = new RagnarServiceRest();
		Person person = ragnarService.getPerson(116);
		System.out.println(person);
	}

}
