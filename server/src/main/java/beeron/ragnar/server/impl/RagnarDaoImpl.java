package beeron.ragnar.server.impl;

import org.springframework.jdbc.core.JdbcOperations;

import beeron.ragnar.common.RagnarDao;

public class RagnarDaoImpl implements RagnarDao {

	private JdbcOperations jdbcOperations;

	public RagnarDaoImpl(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}
}
