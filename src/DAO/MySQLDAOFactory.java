package DAO;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

import DAO.implementations.MySQLUtenteDAOImpl;
import DAO.interfaces.UtenteDAO;

	// TODO: Auto-generated Javadoc
/**
	 * A factory for creating MySQLDAO objects.
	 */
	public class MySQLDAOFactory extends DAOFactory {
		
		
		/** The public dns. */
		private static String PUBLIC_DNS = "dbunivaq2019.cgrpp6xc53dw.eu-west-3.rds.amazonaws.com";
		
		/** The port. */
		private static String PORT = "3306";
		
		/** The database. */
		private static String DATABASE = "dbunivaq2019";
		
		/** The remote database username. */
		private static String REMOTE_DATABASE_USERNAME = "dbunivaq2019";
		
		/** The database user password. */
		private static String DATABASE_USER_PASSWORD = "dbunivaq2019";
		
		/**
		 * Creates a new MySQLDAO object.
		 *
		 * @return the connection
		 */
		public static Connection createConnection() {
		    
		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		    } catch (ClassNotFoundException e) {
		        System.out.println("Where is your MySQL JDBC Driver?");
		        e.printStackTrace();
		        return null;
		    }

		    Connection connection = null;

		    try {
		        connection = DriverManager.
		                getConnection("jdbc:mysql://" + PUBLIC_DNS + ":" + PORT + "/" + DATABASE, REMOTE_DATABASE_USERNAME, DATABASE_USER_PASSWORD);
		    } catch (SQLException e) {
		        System.out.println("Connection Failed!:\n" + e.getMessage());
		    }

		    if (connection != null) {
		        return connection;
		    } else {
		        return connection;
		    }

		}
	
	    
		/**
		 * Gets the customer DAO.
		 *
		 * @return the customer DAO
		 */
		@Override
		public UtenteDAO getCustomerDAO() {
			return new MySQLUtenteDAOImpl();
		}
	

}