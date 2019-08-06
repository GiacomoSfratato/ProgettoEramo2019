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

public class MySQLRecensioneDAOImpl implements RecensioneDAO {

	 	private static final String elenco_recensioni = "CALL elenco_recensioni(?)";
	    private static final String elenco_recensioni_attesa = "CALL elenco_recensioni_attesa()";
	    private static final String	inserimento_recensione = "CALL inserimento_recensione(?,?,?,?)";
	    private static final String rimuovere_recensione = "call inserimento_utente(?,?,?,?,?,?,?,?)";
	    private static final String verifica_recensione = "call verifica_recensione(?,?,?,?,?)";
		
	    @Override
		public ArrayList<Recensione> get_elenco_recensioni(Pubblicazione pubblicazione) {
	    	ArrayList<Recensione> recensioni = new ArrayList<>();
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
		
		@Override
		public ArrayList<Recensione> get_elenco_recensioni_attesa() {
			ArrayList<Recensione> recensioni_attesa = new ArrayList<>();
	    	Connection conn = null;
			PreparedStatement preparedStatement = null;
			ResultSet result = null;
	        try {
	        	conn = MySQLDAOFactory.createConnection();            
	    		preparedStatement = conn.prepareStatement(elenco_recensioni_attesa);
	        	preparedStatement.execute();
	            result = preparedStatement.getResultSet();
	        	while (result.next()) {            
	        		recensioni_attesa.add(new Recensione(result.getString("titolo"), result.getString("email"), result.getString("contenuto"), result.getString("approvazione"), result.getDate("data")));
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
		
		@Override
		public boolean set_rimuovere_recensione(Recensione recensione) {
			// TODO Auto-generated method stub
			return false;
		}
	
}
