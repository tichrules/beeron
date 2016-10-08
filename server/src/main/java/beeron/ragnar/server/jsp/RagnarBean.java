package beeron.ragnar.server.jsp;

import java.util.List;

import javax.naming.NamingException;

import beeron.ragnar.common.Person;
import beeron.ragnar.common.RagnarDao;

public class RagnarBean extends AbstractBean {

	private RagnarDao ragnarDao;

	public RagnarBean() throws NamingException {
		ragnarDao = context.getBean(RagnarDao.class);
	}

	public List<Person> getPeople() {
		return ragnarDao.getPeople();
	}

}
