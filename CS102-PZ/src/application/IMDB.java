/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Imdb;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Milos
 */
public class IMDB implements Initializable{
    	@FXML 
	private TableView<Imdb> table;
	@FXML 
	private TableColumn<Imdb,Integer> id;
	@FXML 
	private TableColumn<Imdb,String> naziv;
	@FXML 
	private TableColumn<Imdb,String> ocena;
  	
	  
	@Override
	public void initialize(URL location, ResourceBundle resources) {
            List<Imdb> data = new ArrayList<>();
            //Preuzima informacije o Top 250 filmova sa IMDB sajta.
            try {               		
                final Document document = Jsoup.connect("http://www.imdb.com/chart/top").get();
                int id = 1;
                
                //Prva iteracija se preskače jer nema nikakvih podataka verovatno zbog strukture na web sajtu.
                for (Element row : document.select("table.chart.full-width tr").subList(1, 251)) {
                    Imdb top250 = new Imdb();
                    top250.setId(id);
                    id++;
                    top250.setNaziv(row.select(".titleColumn a").text());
                    top250.setOcena(row.select(".imdbRating").text());
                    data.add(top250);
                }
			
		} 
            catch (Exception e) {
            System.out.println(e);
            }
            
        //Podaci se stavljaju u ObservableList-u zatim se učitavaju u tabelu.
        ObservableList<Imdb> data1 = FXCollections.observableArrayList(data);
			 			
	id.setCellValueFactory(new PropertyValueFactory<Imdb,Integer>("id"));
	naziv.setCellValueFactory(new PropertyValueFactory<Imdb,String>("naziv"));
	ocena.setCellValueFactory(new PropertyValueFactory<Imdb,String>("ocena"));
 				
 	table.setItems(data1);		
	}
}
