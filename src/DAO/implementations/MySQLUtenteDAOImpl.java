package DAO.implementations;

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
    private static final String inserimento_utente = "call inserimento_utente(?,?,?,?,?,?,?,?)";
    private static final String rimuovere_utente = "call rimuovere_utente(?,?)";
	
    public boolean set_modifica_tipo_utente(Utente utente, String tipo) {
    	boolean fine = false;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = MySQLDAOFactory.createConnection();
			ps = conn.prepareStatement(modifica_tipo_utente);
			ps.setString(1,utente.getEmail());
			ps.setString(2,tipo);
			ps.execute();
			fine=true;
		}
		catch(Exception exc) {
		System.out.print("something goes wrong!"); }
		finally { 
		try {
             ps.close();
         } catch (Exception sse) {
          	System.out.println("preparedStatement.close();"); 
         }
         try {
             conn.close();
         } catch (Exception cse) {
         	System.out.println("conn.close();");
         }  }
		return fine;
	}
	
	
	public HashMap<String,Integer> get_utenti_attivi() {
		HashMap <String,Integer> utenti = new HashMap<>();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
        try {
        	conn = MySQLDAOFactory.createConnection();            
    		preparedStatement = conn.prepareStatement(utenti_attivi);
        	preparedStatement.execute();
            result = preparedStatement.getResultSet();
        	while (result.next()) {            
        		utenti.put(result.getString("email"), result.getInt("libri inseriti"));
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

/////////////////////////////////////////////////////////////////////////////////////
	//metodo che non serve nella query get_utenti_attivi
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
//////////////////////////////////////////////////////////////////////////////////////
	
	public boolean set_inserimento_utente(Utente utente) {
		boolean fine = false;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn= MySQLDAOFactory.createConnection();          
			preparedStatement = conn.prepareStatement(inserimento_utente);
			preparedStatement.setString(1,utente.getEmail());
			preparedStatement.setString(2,utente.getPassword());
			preparedStatement.setString(3,utente.getNome());
			preparedStatement.setString(4,utente.getCognome());
			preparedStatement.setString(5,utente.getSesso());
			preparedStatement.setString(6,utente.getData_di_nascita());
			preparedStatement.setString(7,utente.getLuogo_di_nascita());
			preparedStatement.setString(8,utente.getLivello());
			preparedStatement.execute();
			fine = true;
		}
		 catch (SQLException e) {
         	System.out.println("qualcosa"); 
         } finally {
             
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
             }return fine;}
	
	public boolean set_rimuovere_utente(Utente utente) {
		boolean fine = false;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = MySQLDAOFactory.createConnection();
			ps = conn.prepareStatement(rimuovere_utente);
			ps.setString(1,utente.getEmail());
			ps.setString(2, utente.getPassword());
			ps.execute();
			fine=true;
		}
		catch(Exception exc) {
		System.out.print("somethink goes wrong!"); }
		finally { 
		try {
             ps.close();
         } catch (Exception sse) {
          	System.out.println("preparedStatement.close();"); 
         }
         try {
             conn.close();
         } catch (Exception cse) {
         	System.out.println("conn.close();");
         }  }
		return fine;
	}
	
}