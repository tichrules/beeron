package beeron.ragnar.server.jsp;

import javax.naming.NamingException;

import beeron.ragnar.common.RagnarDao;

public class RagnarBean extends AbstractBean {

	private RagnarDao ragnarDao;

	public RagnarBean() throws NamingException {
		ragnarDao = context.getBean(RagnarDao.class);
	}

	public String getRagnar() {
		return "Ragnar " + ragnarDao.getRagnar();
	}

}
