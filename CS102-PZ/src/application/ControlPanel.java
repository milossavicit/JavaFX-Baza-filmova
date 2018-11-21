package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControlPanel {
    
        //Pravi scenu i preko FXMLLoader-a pravi prikaz, CSS fajl se koristi za stilizovanje.
		
	public void prikazFilma(ActionEvent e) throws IOException  {
	 
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("PrikazFilmova.fxml"));
		
		Scene scene = new Scene(root,947,496);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	 
		primaryStage.setScene(scene);
		primaryStage.show();			 			
	}
	
	public void ubaciFilm(ActionEvent e) throws IOException  {
		 
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("UbaciFilm.fxml"));
		
		Scene scene = new Scene(root,699,571);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	 
		primaryStage.setScene(scene);
		primaryStage.show();			 			
	}
	
	public void azurirajObrisiFilm(ActionEvent e) throws IOException  {
		 
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("AzuriranjeBrisanje.fxml"));
		
		Scene scene = new Scene(root,820,528);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	 
		primaryStage.setScene(scene);
		primaryStage.show();			 			
	}
        
        public void WebPrikaz(ActionEvent e) throws IOException  {
            WebPrikaz wb = new WebPrikaz();
            wb.IMDB();
        }
        
        public void prikazIMDB(ActionEvent e) throws IOException  {
	 
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("IMDB.fxml"));
		
		Scene scene = new Scene(root,947,496);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	 
		primaryStage.setScene(scene);
		primaryStage.show();			 			
	}
}
