
package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	
	
	public static Stage stage;
	@Override
	public void start(Stage stage) throws Exception {
	        this.stage = stage; // initialize value of stage.
	    Parent root = FXMLLoader.load(getClass().getResource("/view/HomePage.fxml"));
	    Scene scene = new Scene(root);
	    stage.setTitle("Benvenuto nella Biblioteca!");
	    
	    stage.setScene(scene);
	    stage.show();
	}
}



/*package application;
	
import DAO.implementations.MySQLPubblicazioneDAOImpl;
import DAO.implementations.MySQLUtenteDAOImpl;
import model.Utente;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("Registration.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/*@Override
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
	Utente utente = new Utente.Builder().withmail("ciao@cia.ex").withpassword("marks124").build(); // example of utente
		System.out.println(utente.toString()); 
		MySQLUtenteDAOImpl x = new MySQLUtenteDAOImpl();
		System.out.println(x.get_utenti_attivi()); 
	//	System.out.println(x.set_inserimento_utente(utente)); 
	//	System.out.println(x.set_rimovere_utente(utente));
		System.out.println(x.get_mostra_nome_utente(6));  
		
		MySQLPubblicazioneDAOImpl y = new MySQLPubblicazioneDAOImpl();
		/*System.out.print(y.get_ultime_publicazioni());
		System.out.print(y.get_update_recente()); 
		
		System.out.println(y.get_pubblicazione_utente(new Utente.Builder().withmail("fulviolapenna@gmail.com").build()));
	}
}
*/