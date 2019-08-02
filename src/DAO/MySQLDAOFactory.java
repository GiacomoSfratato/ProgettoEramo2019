package DAO;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

import DAO.implementations.MySQLUtenteDAOImpl;
import DAO.interfaces.UtenteDAO;

	public class MySQLDAOFactory extends DAOFactory {

		/** la classe driver */
	    public static final String DRIVER = "com.mysql.jdbc.Driver";
	    /** L'url al database */
	    public static final String DBURL = "jdbc:mysql://localhost/dbunivaq2019";
	    /** Lo username per le operazioni sul DB  */
	    public static final String USER = "dbunivaq2019";
	    /** La password per le operazioni sul DB */
	    public static final String PASS = "dbunivaq2019";
	    
	    /**
	     * Metodo per creare una connessione sul DB MySQL
	     * 
	     * @return l'oggetto Connection.
	     */
	    public static Connection createConnection() {
	        Connection conn = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(DBURL, USER, PASS);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	        	e.printStackTrace();
	        }
	        return conn;
	    }
	    
		@Override
		public UtenteDAO getCustomerDAO() {
			return new MySQLUtenteDAOImpl();
		}
	

}