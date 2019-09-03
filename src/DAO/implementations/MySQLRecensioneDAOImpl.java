package DAO.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.*;
import DAO.MySQLDAOFactory;
import DAO.interfaces.RecensioneDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// TODO: Auto-generated Javadoc
/**
 * The Class MySQLRecensioneDAOImpl.
 */
public class MySQLRecensioneDAOImpl implements RecensioneDAO {

	 	/** The Constant elenco_recensioni. */
	 	private static final String elenco_recensioni = "CALL elenco_recensioni(?)";
	    
    	/** The Constant elenco_recensioni_attesa. */
    	private static final String elenco_recensioni_attesa = "CALL elenco_recensioni_attesa()";
	    
    	/** The Constant inserimento_recensione. */
    	private static final String	inserimento_recensione = "CALL inserimento_recensione(?,?,?,?)";
	    
    	/** The Constant rimuovere_recensione. */
    	private static final String rimuovere_recensione = "call inserimento_utente(?,?,?,?,?,?,?,?)";
	    
    	/** The Constant verifica_recensione. */
    	private static final String verifica_recensione = "call verifica_recensione(?,?,?,?,?)";
	    
    	/** The recensione utente pubblicazione. */
    	private static String recensione_utente_pubblicazione = "SELECT * FROM recensione WHERE ID_utente = ? AND ID_pubblicazione = ?";
	    
    	/**
    	 * Estrazione elenco delle recensioni approvate per una pubblicazione.
    	 *
    	 * @param pubblicazione the pubblicazione
    	 * @return the elenco recensioni
    	 */
    	@Override
		public ObservableList<Recensione> get_elenco_recensioni(Pubblicazione pubblicazione) {
	    	ObservableList<Recensione> recensioni = FXCollections.observableArrayList();
	    	Connection conn = null;
			PreparedStatement preparedStatement = null;
			ResultSet result = null; 
	        try {
	        	conn = MySQLDAOFactory.createConnection();            
	    		preparedStatement = conn.prepareStatement(elenco_recensioni);
	    		preparedStatement.setInt(1,pubblicazione.getId());
	        	preparedStatement.execute();
	            result = preparedStatement.getResultSet();
	        	while (result.next()) {    
	        		//System.out.println(result.getString("contenuto"));
	        		recensioni.add(new Recensione(result.getString("email"), result.getString("contenuto"), result.getString("approvazione"), result.getDate("data")));
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
		return recensioni;
		
		}
		
    	/**
    	 * Estrazione elenco delle recensioni in attesa di approvazione.
    	 *
    	 * @return the elenco recensioni attesa
    	 */
		@Override
		public ObservableList get_elenco_recensioni_attesa() {
			ObservableList<Recensione> recensioni_attesa = FXCollections.observableArrayList();
	    	Connection conn = null;
			PreparedStatement preparedStatement = null;
			ResultSet result = null;
	        try {
	        	conn = MySQLDAOFactory.createConnection();            
	    		preparedStatement = conn.prepareStatement(elenco_recensioni_attesa);
	        	preparedStatement.execute();
	            result = preparedStatement.getResultSet();
	        	while (result.next()) {            
	        		recensioni_attesa.add(new Recensione(result.getInt(1), 
	        				result.getInt(2), 
	        				result.getString(3), 
	        				result.getString(4), 
	        				result.getString(5), 
	        				result.getDate(6)));
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
		return recensioni_attesa;
		
		}
		
		/**
		 * Inserimento di una recensione relativa a una pubblicazione.
		 *
		 * @param pubblicazione the pubblicazione
		 * @param recensione the recensione
		 * @return true, if successful
		 */
		@Override
		public boolean set_inserimento_recensione(Pubblicazione pubblicazione, Recensione recensione) {
			boolean fatto = false;
			PreparedStatement ps = null;
			Connection conn = null;
			try {
				conn = MySQLDAOFactory.createConnection();
				ps = conn.prepareStatement(inserimento_recensione);
				ps.setString(1,LibraryUser.getEmail());
				ps.setString(2,LibraryUser.getPassword());
				ps.setString(3, recensione.getContenuto());
				ps.setInt(4,pubblicazione.getId());
				ps.execute();
				fatto = true;
			}
			catch(SQLException exc) {
			System.out.print(exc.getMessage()); }
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
			return fatto;
		
		}
		
		/**
		 * Approvazione o di una recensione (da parte del moderatore).
		 *
		 * @param recensione the recensione
		 * @param giudizio the giudizio
		 * @return true, if successful
		 */
		@Override
		public boolean set_verifica_recensione(Recensione recensione, String giudizio) {
			boolean fatto = false;
			PreparedStatement ps = null;
			Connection conn = null;
			try {
				conn = MySQLDAOFactory.createConnection();
				ps = conn.prepareStatement(verifica_recensione);
				ps.setString(1,LibraryUser.getEmail());
				ps.setString(2,LibraryUser.getPassword());
				ps.setInt(3, recensione.getId_utente());
				ps.setInt(4, recensione.getId_pubblicazione());
				ps.setString(5, giudizio);
				ps.execute();
				fatto = true;
			}
			catch(SQLException exc) {
			System.out.print(exc.getMessage()); }
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
			return fatto;
		
		}
		
		/**
		 * Rimuovere la recensione
		 *
		 * @param recensione Recensione
		 * @return true, se va a buon fine
		 */
		@Override
		public boolean set_rimuovere_recensione(Recensione recensione) {
			// TODO Auto-generated method stub
			return false;
		}
		
		/**
		 * Check che l'utente abbia o non abbia inserito già la recensione
		 *
		 * @param pubblicazione Pubblicazione
		 * @return true, se va a buon fine
		 */
		public boolean check_recensione(Pubblicazione pubblicazione) {
			boolean esiste = false;
			PreparedStatement ps = null;
			ResultSet result = null;
			Connection conn = null;
			try {
				conn = MySQLDAOFactory.createConnection();
				ps = conn.prepareStatement(recensione_utente_pubblicazione);
				ps.setInt(1,LibraryUser.getId());
				ps.setInt(2, pubblicazione.getId());
				ps.execute();
				result = ps.getResultSet();
				  while (result.next()) {            	
					  esiste = true;
		        }  
			}
			catch(Exception exc) {
			System.out.print("Qualcosa ï¿½ andato storto!"); }
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
			return esiste;
		
		}
}
