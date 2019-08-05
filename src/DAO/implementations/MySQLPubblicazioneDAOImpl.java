package DAO.implementations;

import java.util.*;
import java.sql.*;

import DAO.MySQLDAOFactory;
import DAO.interfaces.PubblicazioneDAO;
import model.*;
public class MySQLPubblicazioneDAOImpl implements PubblicazioneDAO {
	private static String ultime_pubblicazioni = "CALL ultime_pubblicazioni";
	private static String update_recente = "CALL update_recente";
	private static String pubblicazione_utente = "CALL pubblicazioni_utente(?)";
	private static String catalogo = "CALL catalogo";
	private static String estrazione_dati = "CALL estrazione_dati(?)";
	
	
	@Override
	public ArrayList<Pubblicazione> get_ultime_pubblicazioni(){
		ArrayList <Pubblicazione> pubblicazioni = new ArrayList<Pubblicazione>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
        	conn = MySQLDAOFactory.createConnection();            
    		ps = conn.prepareStatement(ultime_pubblicazioni);
    		ps.execute();
    		result = ps.getResultSet();
    		  while (result.next()) {            	
    		   		pubblicazioni.add(new Pubblicazione.Builder().withid(result.getInt(1)).withtitolo(result.getString(2)).withmetadati(new Metadati(result.getString(3),result.getString(4))).build());
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
                    ps.close();
                } catch (Exception sse) {
                 	System.out.println("preparedStatement.close();"); 
                }
                try {
                    conn.close();
                } catch (Exception cse) {
                	System.out.println("conn.close();");
                }
            }
	return pubblicazioni;}
	
	@Override
	public ArrayList<Pubblicazione> get_update_recente(){	
	ArrayList <Pubblicazione> pubblicazioni = new ArrayList<Pubblicazione>();
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet result = null;
	try {
    	conn = MySQLDAOFactory.createConnection();            
		ps = conn.prepareStatement(update_recente);
		ps.execute();
		result = ps.getResultSet();
		  while (result.next()) {            	
		   		pubblicazioni.add(new Pubblicazione.Builder().withid(result.getInt(1)).withtitolo(result.getString(2)).build());
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
                ps.close();
            } catch (Exception sse) {
             	System.out.println("preparedStatement.close();"); 
            }
            try {
                conn.close();
            } catch (Exception cse) {
            	System.out.println("conn.close();");
            }
        }
return pubblicazioni;}
	
	@Override
	public ArrayList<Pubblicazione> get_pubblicazione_utente(Utente utente){ 
	ArrayList<Pubblicazione> pubblicazioni = new ArrayList<Pubblicazione>();
	PreparedStatement ps = null;
	ResultSet result = null;
	Connection conn = null;
	try {
		conn = MySQLDAOFactory.createConnection();
		ps = conn.prepareStatement(pubblicazione_utente);
		ps.setString(1,utente.getEmail());
		ps.execute();
		result = ps.getResultSet();
		  while (result.next()) {            	
		   		pubblicazioni.add(new Pubblicazione.Builder().withid(result.getInt(1)).withtitolo(result.getString(2)).build());
        }  
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
	return pubblicazioni;
}
	
	@Override
	public ArrayList<Pubblicazione> get_catalogo(){
		ArrayList<Pubblicazione> pubblicazioni = new ArrayList<Pubblicazione>();
		
		PreparedStatement ps = null;
		ResultSet result = null;
		Connection conn = null;
		try {
			conn = MySQLDAOFactory.createConnection();
			ps = conn.prepareStatement(catalogo);
			ps.execute();
			result = ps.getResultSet();
			  while (result.next()) { 
				  ArrayList<Autore> autori = new ArrayList<Autore>();
				  autori.add(new Autore(result.getString(3),result.getString(4)));
				  pubblicazioni.add(new Pubblicazione.Builder().withid(result.getInt(1)).withtitolo(result.getString(2)).withautori(autori).witheditore(result.getString(5)).withdata(result.getString(6)).build());
	        }  
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
		return pubblicazioni;
	}

	



	@Override
	public Pubblicazione get_estrazione_dati(Pubblicazione pubblicazione) {
		Pubblicazione pubbl = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		Connection conn = null;
		try {
			conn = MySQLDAOFactory.createConnection();
			ps = conn.prepareStatement(estrazione_dati);
			ps.setInt(1,pubblicazione.getId());
			ps.execute();
			result = ps.getResultSet();
			  while (result.next()) {            	
				  Metadati meta = new Metadati(result.getInt(6),result.getString(5), result.getString(7), result.getString(8));
			   		pubbl = new Pubblicazione.Builder()
			   				.withid(result.getInt(1))
			   				.withtitolo(result.getString(2))
			   				.withdescrizione(result.getString(3))
			   				.witheditore(result.getString(4))
			   				.withmetadati(meta)
			   				.withpubblicatore(result.getString(9))
			   				.build();
	        }  
		}
		catch(Exception exc) {
		System.out.print("Qualcosa è andato storto!"); }
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
		return pubbl;
	}

	
	@Override
	public ArrayList<Pubblicazione> get_cerca_pubblicazione(Pubblicazione pubblicazione) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ArrayList<Pubblicazione> get_catalogo_ristampa() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ArrayList<Pubblicazione> get_catalogo_stessi_autori(Pubblicazione pubblicazione) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public boolean set_inserimento_like(String email, String password, int id_pubblicazione) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public Pubblicazione get_likes_totali(Pubblicazione pubblicazione) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ArrayList<Storico> get_estrazione_modifiche_pubblicazione(Pubblicazione pubblicazione) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ArrayList<Pubblicazione> get_elenco_download() {
		// TODO Auto-generated method stub
		return null;
	}

}


