/*
 * 
 */
package application;

import DAO.interfaces.UtenteDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import DAO.MySQLDAOFactory;
import DAO.implementations.*;
import model.*;
import controller.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main extends Application{
	
	/** The stage. */
	public static Stage stage;
	
	/**
	 * Start.
	 *
	 * @param stage the stage
	 * @throws Exception the exception
	 */
	@Override
	public void start(Stage stage) throws Exception {
	        this.stage = stage; // initialize value of stage.
	        ViewPublicationController.setId(6);
	    Parent root = FXMLLoader.load(getClass().getResource("/view/LoginPage.fxml"));
	    Scene scene = new Scene(root);
	    stage.initStyle(StageStyle.UNDECORATED);
	    stage.setTitle("Biblioteca Online");
	    
	    stage.setScene(scene);
	    stage.show();
	    
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
	launch(args);
	
	/*Utente utente = new Utente.Builder().withmail("ciao@cia.ex").withpassword("marks124").build(); // example of utente
	//System.out.println(utente.toString()); 
	MySQLUtenteDAOImpl x = new MySQLUtenteDAOImpl();
	//System.out.println(x.set_inserimento_utente(utente)); 
	//System.out.println(x.set_rimuovere_utente(utente));
	//System.out.println(x.get_mostra_nome_utente(6));  
	
	MySQLPubblicazioneDAOImpl y = new MySQLPubblicazioneDAOImpl();
	ArrayList<Autore> autore = new ArrayList<>();
	autore.add(new Autore("",""));
	Metadati meta = new Metadati("","");
	System.out.println(y.get_cerca_pubblicazione(new Pubblicazione.Builder().withtitolo("").withautori(autore).withmetadati(meta).build(), new Parola_chiave("bambini") ));
	
	
	System.out.println(y.get_pubblicazione_utente(new Utente.Builder().withmail("fulviolapenna@gmail.com").build()));
	System.out.println(y.get_catalogo());
	*/
 /* credo che si dovrebbe fare una classe apparte o package per questo
    Regions clientRegion = Regions.EU_WEST_1;
    String bucketName = "bibliotecaesame";
    String stringObjKeyName = "txt";	// non so se è neccessario
    String fileObjKeyName = "foto.jpg"; // sarebbe meglio creare un generatore di nomi di almeno 16 carratteri cosi da avvere nomi unici
    String fileName = "/home/dawpad/Desktop/objprova.jpg"; // si sostituisce con una variabile che sara' data dal utente
    // URL dove verra sara la foto è String URL = "https://bibliotecaesame.s3-eu-west-1.amazonaws.com/" + fileObjKeyName;
    try {
        //This code expects that you have AWS credentials set up per:
        // https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/setup-credentials.html
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(clientRegion)
                .build();

        // Upload a text string as a new object.
        s3Client.putObject(bucketName, stringObjKeyName, "Uploaded String Object");

        // Upload a file as a new object with ContentType and title specified.
        PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(fileName));
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("plain/text");
        metadata.addUserMetadata("x-amz-meta-title", "someTitle");
        request.setMetadata(metadata);
        s3Client.putObject(request);
    } catch (AmazonServiceException e) {
        // The call was transmitted successfully, but Amazon S3 couldn't process 
        // it, so it returned an error response.
        e.printStackTrace();
    } catch (SdkClientException e) {
        // Amazon S3 couldn't be contacted for a response, or the client
        // couldn't parse the response from Amazon S3.
        e.printStackTrace();
    }
*/
}
}