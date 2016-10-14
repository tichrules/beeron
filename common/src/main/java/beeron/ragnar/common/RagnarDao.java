package beeron.ragnar.common;

import java.util.List;

public interface RagnarDao {

	List<Person> getPeople();

	Person getPerson(String name);

	void insertPerson(Person person) throws DaoException;

	void deletePerson(String name) throws DaoException;

}
