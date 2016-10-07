package beeron.ragnar.server.impl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import beeron.ragnar.common.RagnarDao;

public class RagnarDaoImpl implements RagnarDao {

	private JdbcOperations jdbcOperations;

	public RagnarDaoImpl() throws NamingException {
		InitialContext ctx = new InitialContext();
		Context envContext = (Context) ctx.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/ragnarDS");
		jdbcOperations = new JdbcTemplate(ds);
	}

	/**
	 * 
	 * @see beeron.ragnar.common.RagnarDao#getRagnar()
	 */
	@Override
	public int getRagnar() {
		int count = jdbcOperations.queryForObject("SELECT COUNT(*) FROM TEST", Integer.class);
		return count;
	}
}
