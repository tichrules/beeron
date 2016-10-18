package beeron.ragnar.common;

import java.util.List;

public interface RagnarService {

	List<Person> getPeople();

	Person getPerson(int id);

	int insertPerson(Person person);

	void deletePerson(int id);

}
