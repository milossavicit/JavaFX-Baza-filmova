package application;

import model.Tvtime;
import model.Zanr;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class UbaciFilm {

	@FXML
	private TextField naziv;
	@FXML
	private ComboBox<String> zanr;
	@FXML
	private TextField godina;
	@FXML
	private TextField trajanje;
	@FXML
	private TextArea opis;
	@FXML
	private TextField ocena;
        
        private ArrayList<Zanr> tvtime;
	
        //Učitava podatke za ComboBox.
        public void initialize() {
        tvtime = (ArrayList<Zanr>) DBInfo.getZanr();
        List<String> zanrString = tvtime.stream().map(zanr -> (zanr.getNaziv())).collect(Collectors.toList());
        zanr.setItems(FXCollections.observableArrayList(zanrString));
        }
	
        //Podatke unete u formu čuva u bazu.
	public void ubaciPodatke(ActionEvent e) throws IOException{
            	
            String Naziv = naziv.getText();
            String Zanr = zanr.getValue();
            String Godina = godina.getText();
            String Trajanje = trajanje.getText();
            String Opis = opis.getText();
            String Ocena = ocena.getText();


	
	int iGodina = Integer.parseInt(Godina);
	int iOcena = Integer.parseInt(Ocena);

	Tvtime tv = new Tvtime();  
	
	tv.setNaziv(Naziv);
	tv.setZanr(Zanr);
	tv.setGodina(iGodina);
	tv.setTrajanje(Trajanje);
	tv.setOpis(Opis);
	tv.setOcena(iOcena);

	int status = DBInfo.ubaci(tv);
	  
	if(status>0){  
		  		  
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ubacivanje podataka");
            alert.setHeaderText("Information Dialog");
            alert.setContentText("Film je uspešno sačuvan!");

            alert.showAndWait();	  
		             
        }
        else{  
    	      	  
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Ubacivanje podataka");
            alert.setHeaderText("ERROR Dialog");
            alert.setContentText("Greška! Film nije sačuvan.");

            alert.showAndWait();

        }  
		
        }
			
}
