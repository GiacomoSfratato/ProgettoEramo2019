package DAO.implementations;

import java.util.*;
import java.sql.*;

import DAO.MySQLDAOFactory;
import DAO.interfaces.PubblicazioneDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;
public class MySQLPubblicazioneDAOImpl implements PubblicazioneDAO {
	private static String ultime_pubblicazioni = "CALL ultime_pubblicazioni";
	private static String update_recente = "CALL update_recente";
	private static String pubblicazione_utente = "CALL pubblicazioni_utente(?)";
	private static String catalogo = "CALL catalogo";
	private static String estrazione_dati = "CALL estrazione_dati(?)";
	private static String cerca = "CALL cerca_pubblicazione(?,?,?,?,?)";
	private static String catalogo_ristampa="CALL catalogo_ristampa";
	private static String inserimento_like="CALL inserimento_like"; // forse va nel utenteDAOImpl
	private static String estrazione_modifiche_pubblicazione = "CALL estrazione_modifiche_pubblicazione(?)";
	private static String likes_totali="CALL likes_totali";
	private static String elenco_download="CALL elenco_download";
	
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
	public ObservableList<Pubblicazione> get_catalogo(){
		ObservableList<Pubblicazione> pubblicazioni = FXCollections.observableArrayList();
		
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
		System.out.print("Qualcosa � andato storto!"); }
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
	public ArrayList<Pubblicazione> get_cerca_pubblicazione(Pubblicazione pubblicazione, Parola_chiave parola) {
		ArrayList<Pubblicazione> pubblicazioni = new ArrayList<Pubblicazione>();
		PreparedStatement ps = null;
		ResultSet result = null;
		Connection conn = null;
		try {
			conn = MySQLDAOFactory.createConnection();
			ps = conn.prepareStatement(cerca);
			ps.setString(1,pubblicazione.getTitolo());
			ps.setString(2,(pubblicazione.getAutori()).get(0).getNome());
			ps.setString(3,(pubblicazione.getAutori()).get(0).getCognome());
			ps.setString(4,(pubblicazione.getMetadati().getIsbn()));
			ps.setString(5,(parola.getParola()));
			ps.execute();
			result = ps.getResultSet();
			  while (result.next()) {     
				  	ArrayList<Autore> autori = new ArrayList<Autore>();
				  	autori.add(new Autore(result.getString(3),result.getString(4)));
			   		pubblicazioni.add(new Pubblicazione.Builder()
			   				.withid(result.getInt(1))
			   				.withtitolo(result.getString(2))
			   				.withautori(autori)
			   				.withmetadati(new Metadati(result.getString(5), ""))
			   				.build());
	        }  
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
		return pubblicazioni;
	}

	@Override
	public ArrayList<Pubblicazione> get_catalogo_ristampa() {
	ArrayList<Pubblicazione> pubblicazioni = new ArrayList<Pubblicazione>();
		
		PreparedStatement ps = null;
		ResultSet result = null;
		Connection conn = null;
		try {
			conn = MySQLDAOFactory.createConnection();
			ps = conn.prepareStatement(catalogo_ristampa);
			ps.execute();
			result = ps.getResultSet();
			  while (result.next()) { 
				  pubblicazioni.add(new Pubblicazione.Builder().withid(result.getInt(1)).withtitolo(result.getString(2)).withdescrizione(result.getString(3)).witheditore(result.getString(4)).withdata(result.getString(5)).build());
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
	public ArrayList<Pubblicazione> get_catalogo_stessi_autori(Pubblicazione pubblicazione) {
		ArrayList<Pubblicazione> pubblicazioni = new ArrayList<Pubblicazione>();
		PreparedStatement ps = null;
		ResultSet result = null;
		Connection conn = null;
		try {
			conn = MySQLDAOFactory.createConnection();
			ps = conn.prepareStatement(cerca);
			ps.setInt(1,pubblicazione.getId());
			ps.execute();
			result = ps.getResultSet();
			  while (result.next()) {     
			   		pubblicazioni.add(new Pubblicazione.Builder()
			   				.withid(result.getInt(1))
			   				.withtitolo(result.getString(2))
			   				.withdescrizione(result.getString(3))
			   				.witheditore(result.getString(4))
			   				.build());
	        }  
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
		return pubblicazioni;
	}
	
	@Override
	public boolean set_inserimento_like(Pubblicazione pubblicazione) {
		boolean fatto = false;
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = MySQLDAOFactory.createConnection();
			ps = conn.prepareStatement(inserimento_like);
			ps.setString(1,LibraryUser.getEmail());
			ps.setString(2,LibraryUser.getPassword());
			ps.setInt(3,pubblicazione.getId());
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
	public Pubblicazione get_likes_totali(Pubblicazione pubblicazione) {
		PreparedStatement ps = null;
		ResultSet result = null;
		Connection conn = null;
		Pubblicazione pubblicazioni = null;
		try {
			conn = MySQLDAOFactory.createConnection();
			ps = conn.prepareStatement(likes_totali);
			ps.setInt(1,pubblicazione.getId());
			ps.execute();
			result = ps.getResultSet();
			pubblicazioni = new Pubblicazione.Builder()
			   				.withid(result.getInt(1))
			   				.withtitolo(result.getString(2))
			   				.withlikes_totali(result.getInt(3))
			   				.build();    
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
		return pubblicazioni;
		
	}
	
	@Override
	public ArrayList<Storico> get_estrazione_modifiche_pubblicazione(Pubblicazione pubblicazione) {
		ArrayList<Storico> storico = new ArrayList<Storico>();
		PreparedStatement ps = null;
		ResultSet result = null;
		Connection conn = null;
		try {
			conn = MySQLDAOFactory.createConnection();
			ps = conn.prepareStatement(estrazione_modifiche_pubblicazione);
			ps.setInt(1,pubblicazione.getId());
			ps.execute();
			result = ps.getResultSet();
			  while (result.next()) {            	
				  storico.add(new Storico(result.getString(3),result.getString(4),result.getInt(1),result.getInt(2)));
	        }  
		}
		catch(Exception exc) {
		System.out.print("Qualcosa � andato storto!"); }
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
		return storico;
	}

	@Override
	public ArrayList<Pubblicazione> get_elenco_download() {
		ArrayList<Pubblicazione> pubblicazioni = new ArrayList<Pubblicazione>();
		PreparedStatement ps = null;
		ResultSet result = null;
		Connection conn = null;
		try {
			conn = MySQLDAOFactory.createConnection();
			ps = conn.prepareStatement(elenco_download);
			ps.execute();
			result = ps.getResultSet();
			  while (result.next()) {            	
				  ArrayList<Sorgente> sorg = new ArrayList<Sorgente>();
				  sorg.add(new Sorgente(result.getString(4)));
			   		pubblicazioni.add(new Pubblicazione.Builder()
			   				.withtitolo(result.getString(1))
			   				.withdescrizione(result.getString(2))
			   				.witheditore(result.getString(3))
			   				.withsorgenti(sorg)
			   				.build());
	        }  
		}
		catch(Exception exc) {
		System.out.print("Qualcosa � andato storto!"); }
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

}


