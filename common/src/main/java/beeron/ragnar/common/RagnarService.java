package beeron.ragnar.common;

import java.util.List;

public interface RagnarService {

	List<Person> getPeople();

	// List<Person> getPeopleInMostPopularLocation();

	Person getPerson(int id);

	int insertPerson(Person person);

	void deletePerson(int id);

	void deletePerson(String name);

	Location getMostPopularLocation();

	void deleteLocation(String name);

}
