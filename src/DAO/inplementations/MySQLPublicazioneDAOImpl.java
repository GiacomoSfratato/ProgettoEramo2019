package DAO.inplementations;

import java.util.ArrayList;
import java.sql.*;

import DAO.MySQLDAOFactory;
import DAO.interfaces.PublicazioneDAO;
import model.Pubblicazione;
import model.Utente;
import model.Metadati;
public class MySQLPublicazioneDAOImpl implements PublicazioneDAO {
	private static String ultime_pubblicazioni = "CALL ultime_pubblicazioni";
	
	
	public static ArrayList<Pubblicazione> get_ultime_publicazioni(){
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
	
	
	/*public static ArrayList<Publicazione> get_update_recente(){return null;}
	public static ArrayList<Publicazione> get_publicazione_utente(Utente utente){return null;}
	public static ArrayList<Publicazione> get_catalogo(){return null;}
	public static Publicazione get_estrazione_dati(Publicazione publicazione){return null;} //
	public static Publicazione get_cerca_publicazione(Publicazione publicazione){return null;}
	public static ArrayList<Publicazione> get_catalogo_ristampa(){return null;} //
	public static ArrayList<Publicazione> get_catalogo_stessi_autori(Publicazione publicazione){return null;} //
	public static boolean set_inserimento_like(String email, String password,int id_publicazione){return false;} //
	public static Publicazione get_likes_totiali(){return null;} //
	public static Publicazione get_estrazione_modifiche_pubblicazione(Publicazione publicazione){return null;} //
	*/
}

