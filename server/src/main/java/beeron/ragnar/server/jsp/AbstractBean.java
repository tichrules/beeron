package beeron.ragnar.server.jsp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AbstractBean {

	protected ClassPathXmlApplicationContext context;

	public AbstractBean() {
		context = new ClassPathXmlApplicationContext(new String[] { "spring/dao.xml" });
	}
}
