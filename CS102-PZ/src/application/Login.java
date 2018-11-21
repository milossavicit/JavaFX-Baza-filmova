package application;

import model.Korisnici;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login {

    @FXML
    Label dbCon;
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    Label check;
	
//Proverava da li je otvorena sesija baze.
public void statusDB(ActionEvent e) throws IOException, SQLException{    
dbCon.setText("Nije konektovano");
    if(! KorisniciDB.getConnection().isClosed()){
	dbCon.setText("Konektovano");
    }
    else{
	dbCon.setText("Nije konektovano");
    }

}
	
//Učitava korisnike iz baze, proverava da li su uneti podaci korektni, ako jesu otvara Control Panel, ako nisu ispisuje grešku.
public void unosKorisnika(ActionEvent e) throws IOException, SQLException{

	 List<Korisnici> list=KorisniciDB.getKorisnici();
	 
	 Map<String, String> map = new HashMap<String, String>();
	 
	 for(Korisnici k:list){
	 
		 map.put(k.getUsername(), k.getPassword());
	 }
	 

if (map.containsKey(username.getText())) {
	
	String str1 = map.get(username.getText());
	
	if( str1.equals(password.getText()) ){
		
		check.setText("Log in uspešan.");
				 
		KorisniciDB.getConnection();
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("ControlPanel.fxml"));
		
		Scene scene = new Scene(root,730,452);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	 
		primaryStage.setScene(scene);
		primaryStage.show();	 		
	}
        else{
            check.setText("Greška! Pokušajte ponovo.");
	}	
}
else{
    check.setText("Greška! Pokušajte ponovo.");
}
			 	
}

}