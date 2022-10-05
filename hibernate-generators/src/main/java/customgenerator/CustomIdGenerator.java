package customgenerator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class CustomIdGenerator implements IdentifierGenerator {

	//You can give any name to sequence be sure that you know how to use it.
	private final String DEFAULT_SEQUENCE_NAME = "hibernate_sequence";
	//private final String DEFAULT_SEQUENCE_NAME = "hib_sequence";

	/*
	 * This method will generate custom id based on String followed by id
	 * e.g. emp0001, emp0002, emp0003 and so on..
	 * */
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Serializable result = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		String prefix = "PRODUCT";
		try {
			connection = session.getJdbcConnectionAccess().obtainConnection();
			statement = connection.createStatement();
			try {
				resultSet = statement.executeQuery("select count(productId ) as Id from hibernateyt.Product_Using_Custom_Generator");

				if (resultSet.next()) {
					int id = resultSet.getInt(1) + 1001;
					String generatedId = prefix + new Integer(id).toString();
					System.out.println("Generated Id: " + generatedId);
					return generatedId;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
