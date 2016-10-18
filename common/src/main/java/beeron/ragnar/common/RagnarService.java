package beeron.ragnar.common;

import java.util.List;

public interface RagnarService {

	List<Person> getPeople();

	Person getPerson(String name);

	void insertPerson(Person person);

	void deletePerson(String name);

}
