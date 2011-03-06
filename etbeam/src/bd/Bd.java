package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bd {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
		
	public void connect() throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://r33099.ovh.net/etbeam?"+
							"user="+bd.Login.getLogin()+"&password="+bd.Login.getPassword());

		} catch (Exception e) {
			throw e;
		}
	}
	
	public ResultSet execute(String query) throws SQLException{
		ResultSet res = null;
		
		statement = connect.createStatement();
		
		// Result set get the result of the SQL query
		resultSet = statement.executeQuery(query);
		
		return res;
	}

	// You need to close the resultSet
	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}
}
