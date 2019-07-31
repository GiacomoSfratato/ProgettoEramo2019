package application;
	
import DAO.inplementations.MySQLUtenteDAOImpl;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Utente;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//launch(args);
	/*	Utente utente = new Utente.Builder().withid(1).withmail("ciao@cia.ex").build(); // example of utente
		System.out.println(utente.toString()); */
		MySQLUtenteDAOImpl x = new MySQLUtenteDAOImpl();
		System.out.println(x.get_utenti_attivi()); 
		System.out.println(x.get_mostra_nome_utente(6)); 
	}
}
