package beeron.ragnar.client.service;

import java.util.List;

import javax.ws.rs.WebApplicationException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import beeron.ragnar.client.bo.PersonBO;
import beeron.ragnar.common.Location;
import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarService;

public class RagnarServiceRest implements RagnarService {

	private Client client;

	public RagnarServiceRest() {
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		client = Client.create(clientConfig);
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#getPeople()
	 */
	@Override
	public List<Person> getPeople() {
		return null;
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#getPerson(int)
	 */
	@Override
	public Person getPerson(int id) {
		String getPersonUrl = "http://localhost/RagnarWebApp/ragnarrest/person";
		WebResource webResourceGet = client.resource(getPersonUrl).queryParam("id", String.valueOf(id));
		ClientResponse response = webResourceGet.get(ClientResponse.class);
		PersonBO person = response.getEntity(PersonBO.class);
		if (response.getStatus() != 200) {
			throw new WebApplicationException();
		}
		return person;
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#insertPerson(beeron.ragnar.common.Person)
	 */
	@Override
	public int insertPerson(Person person) {
		return 0;
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#deletePerson(int)
	 */
	@Override
	public void deletePerson(int id) {
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#deletePerson(java.lang.String)
	 */
	@Override
	public void deletePerson(String name) {
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#getMostPopularLocation()
	 */
	@Override
	public Location getMostPopularLocation() {
		return null;
	}

	/**
	 * @see beeron.ragnar.common.RagnarService#deleteLocation(java.lang.String)
	 */
	@Override
	public void deleteLocation(String name) {
	}

}
