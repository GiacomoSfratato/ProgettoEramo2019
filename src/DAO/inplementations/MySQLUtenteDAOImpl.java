package DAO.inplementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Utente;
import DAO.MySQLDAOFactory;
import DAO.interfaces.UtenteDAO;
 
/**
 * Implementazione dell'interfaccia CustomerDAO per il database MySQL.
 */
public class MySQLUtenteDAOImpl implements UtenteDAO {
	/*basic query declaration */
    private static final String modifica_tipo_utente = "CALL modifica_tipo_utente(?,?)";
    private static final String utenti_attivi = "CALL utenti_attivi()";
    private static final String	mostra_email_utente = "SELECT email from utente where id= ?";
    private static final String inserimerto_utente = "call_inserimento_utente(?,?,?,?,?,?,?,?)";
    private static final String rimuovere_utente = "call rimuovere_utente(?,?)";
	@Override
	public boolean set_modifica_tipo_utente(String email, String tipo) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public  HashMap<String,Integer> get_utenti_attivi() {
		HashMap <String,Integer> utenti = new HashMap<String,Integer>();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
        try {
        	conn = MySQLDAOFactory.createConnection();            
    		preparedStatement = conn.prepareStatement(utenti_attivi);
        	preparedStatement.execute();
            result = preparedStatement.getResultSet();
        	while (result.next()) {            
        		utenti.put(get_mostra_nome_utente(result.getInt(1)),result.getInt(2));
	}
        }
            catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    result.close();
                } catch (Exception rse) {
                    rse.printStackTrace();
                }
                try {
                    preparedStatement.close();
                } catch (Exception sse) {
                    sse.printStackTrace();
                }
                try {
                    conn.close();
                } catch (Exception cse) {
                    cse.printStackTrace();
                }
            }
	return utenti;
	
	}
	
	@Override
	public String get_mostra_nome_utente(int id) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
        String utente="";
        try {
        	conn = MySQLDAOFactory.createConnection();            
    		preparedStatement = conn.prepareStatement(mostra_email_utente);
    		 preparedStatement.setInt(1,id);
    		preparedStatement.execute();
    		result = preparedStatement.getResultSet();
    		  while (result.next()) {            	
    			  utente = result.getString(1);
              }  
           
	}
        
            catch (SQLException e) {
            	System.out.println("qualcosa"); 
            } finally {
                try {
                    result.close();
                } catch (Exception rse) {
                 	System.out.println("result non chiude"); 
                }
                try {
                    preparedStatement.close();
                } catch (Exception sse) {
                 	System.out.println("preparedStatement.close();"); 
                }
                try {
                    conn.close();
                } catch (Exception cse) {
                	System.out.println("conn.close();");
                }
            }
	return utente;
	
	}

	@Override
	public boolean set_inserimento_utente(Utente utente) {
		boolean fine = false;
		Connection con = null;
		
		
				return fine;
	}
	@Override
	public boolean set_rimovere_utente(Utente utente) {
		// TODO Auto-generated method stub
		return false;
	}
 

    
    
    /*
    public List getAllCustomers() {
 
		List Utenti = new ArrayList();
		Utente customer = null;
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();            
            preparedStatement = conn.prepareStatement(READ_ALL_QUERY);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            while (result.next()) {            	
            	customer = new Customer(result.getInt(1), result.getString(2), result.getString(3));
            	customers.add(customer);
            }     
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        
        return customers;
	}
 
	public Customer getCustomer(int id) {
		
		Customer customer= null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(READ_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            if (result.next() && result != null) {
                customer = new Customer(result.getInt(1), result.getString(2), result.getString(3));
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
 
        return customer;
	}
	
	public int createCustomer(Customer customer) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.execute();
            result = preparedStatement.getGeneratedKeys();
 
            if (result.next() && result != null) {
                return result.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
 
        return -1;
    }
		
 
	public boolean updateCustomer(Customer customer) {
		
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setInt(3, customer.getId());
            
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return false;
	}
 
	public boolean deleteCustomer(Customer customer) {
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MySQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return false;
	}  */
 
}