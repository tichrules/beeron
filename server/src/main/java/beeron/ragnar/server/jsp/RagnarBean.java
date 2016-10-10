package beeron.ragnar.server.jsp;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarDao;

public class RagnarBean {

	private RagnarDao ragnarDao;

	public RagnarBean() throws NamingException {
		InitialContext context = new InitialContext();
		ragnarDao = (RagnarDao) context.lookup("java:module/RagnarDaoImpl");
	}

	public List<Person> getPeople() {
		return ragnarDao.getPeople();
	}

}
