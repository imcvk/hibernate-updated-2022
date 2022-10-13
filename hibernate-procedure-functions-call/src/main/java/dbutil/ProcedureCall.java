package dbutil;

import org.hibernate.jdbc.Work;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ProcedureCall implements Work {

	public void execute(Connection connection) throws SQLException {
		CallableStatement callableStatement = connection.prepareCall("{call getAllEmployees()}");
		callableStatement.execute();
	}
}
