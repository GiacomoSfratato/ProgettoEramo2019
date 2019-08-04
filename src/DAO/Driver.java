package DAO;
import java.sql.*;
import java.util.*;
public class Driver{

	private static String PUBLIC_DNS = "dbunivaq2019.cgrpp6xc53dw.eu-west-3.rds.amazonaws.com";
	private static String PORT = "3306";
	private static String DATABASE = "dbunivaq2019";
	private static String REMOTE_DATABASE_USERNAME = "dbunivaq2019";
	private static String DATABASE_USER_PASSWORD = "dbunivaq2019";
	
	public static void createConnection() {

	    System.out.println("----MySQL JDBC Connection Testing -------");
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        System.out.println("Where is your MySQL JDBC Driver?");
	        e.printStackTrace();
	        return;
	    }

	    System.out.println("MySQL JDBC Driver Registered!");
	    Connection connection = null;

	    try {
	        connection = DriverManager.
	                getConnection("jdbc:mysql://" + PUBLIC_DNS + ":" + PORT + "/" + DATABASE, REMOTE_DATABASE_USERNAME, DATABASE_USER_PASSWORD);
	    } catch (SQLException e) {
	        System.out.println("Connection Failed!:\n" + e.getMessage());
	    }

	    if (connection != null) {
	        System.out.println("SUCCESS!!!! You made it, take control     your database now!");
	    } else {
	        System.out.println("FAILURE! Failed to make connection!");
	    }

	}
}