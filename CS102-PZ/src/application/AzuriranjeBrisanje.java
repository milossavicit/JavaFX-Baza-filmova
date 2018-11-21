package application;

import model.Tvtime;
import java.io.IOException;
import java.text.ParseException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;

public class AzuriranjeBrisanje {
	//Povezivanje sa FXML fajlom.
    
	@FXML	
	TextField id;
	@FXML	
	private TextField naziv;
	@FXML
	private TextField zanr;
	@FXML
	private TextField godina;
	@FXML
	private TextField trajanje;
	@FXML
	private TextArea opis;
	@FXML
	private TextField ocena;
	
        //Učitava podatke preko ID
        
	public void getTvtimeID(ActionEvent e) throws IOException, ParseException{
				
            String sid = id.getText();  
	    int id=Integer.parseInt(sid);   
		
	    Tvtime tv = DBInfo.getTvtimeID(id); 
 	    
	    naziv.setText(tv.getNaziv());
	    zanr.setText(tv.getZanr());
	    godina.setText(String.valueOf(tv.getGodina()));
	    trajanje.setText(tv.getTrajanje());
	    opis.setText(tv.getOpis());
	    ocena.setText(String.valueOf(tv.getOcena()));	  		
	}
	
	
	
	public void azuriraj(ActionEvent e) throws IOException, ParseException{
				
            String sid = id.getText();  
	    int id=Integer.parseInt(sid);  
	    
	    String Naziv = naziv.getText();
	    String Zanr = zanr.getText();
	    int Godina = Integer.parseInt(godina.getText());
	    String Trajanje = trajanje.getText();
	    String Opis = opis.getText();
	    int Ocena = Integer.parseInt(ocena.getText());
   
	    Tvtime tv = new Tvtime();  
	    
            tv.setId(id);
            tv.setNaziv(Naziv);
            tv.setZanr(Zanr);
            tv.setGodina(Godina);
            tv.setTrajanje(Trajanje);
            tv.setOpis(Opis);
            tv.setOcena(Ocena);

	    int status=DBInfo.azuriraj(tv);
            
            //Alert dijalozi sa informacijama.
            
            if(status>0){  
        	
  		Alert alert = new Alert(AlertType.INFORMATION);
  		alert.setTitle("Ažuriranje");
  		alert.setHeaderText("Information Dialog");
  		alert.setContentText("Podaci su uspešno ažurirani!");

  		alert.showAndWait();
            }
            else{ 
        	
  		Alert alert = new Alert(AlertType.ERROR);
  		alert.setTitle("Ažuriranje");
  		alert.setHeaderText("ERROR Dialog");
  		alert.setContentText("Greška! Podaci nisu ažurirani.");

  		alert.showAndWait();	 
            }           	
	}	
	
	
	public void brisanje(ActionEvent e) throws IOException, ParseException{
				
            String sid = id.getText();  
	    int id=Integer.parseInt(sid);   
 	     
	    int status = DBInfo.obrisi(id) ;
	    if(status>0){  
	        	
	  	Alert alert = new Alert(AlertType.INFORMATION);
	  	alert.setTitle("Brisanje");
	  	alert.setHeaderText("Information Dialog");
	  	alert.setContentText("Podaci su uspešno obrisani!");

	  	alert.showAndWait();
	    }
            else{ 	        	
	  	Alert alert = new Alert(AlertType.ERROR);
	  	alert.setTitle("Brisanje");
	  	alert.setHeaderText("ERROR Dialog");
	  	alert.setContentText("Greška! Podaci nisu obrisani.");

	  	alert.showAndWait();
	
	        }  	          
		
	}		
}