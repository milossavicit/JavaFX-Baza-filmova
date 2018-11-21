package application;

import model.Tvtime;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.mysql.jdbc.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrikazFilmova implements Initializable{
	
	@FXML 
	private TableView<Tvtime> table;
	@FXML 
	private TableColumn<Tvtime,Integer> id;
	@FXML 
	private TableColumn<Tvtime,String> naziv;
	@FXML 
	private TableColumn<Tvtime,String> zanr;
	@FXML 
	private TableColumn<Tvtime,Integer> godina;
	@FXML 
	private TableColumn<Tvtime,String> trajanje;
	@FXML 
	private TableColumn<Tvtime,String> opis;
	@FXML 
	private TableColumn<Tvtime,Integer> ocena;
  
//Učitava filmove iz baze i prikazuje u tabeli.	
public ObservableList<Tvtime> data = FXCollections.observableArrayList();
	  
	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		
            try {               
		String sql = "SELECT * FROM `tvtime`";
		Connection con = DBInfo.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			
		ResultSet rs = preparedStatement.executeQuery();
			
		while (rs.next()) {
				 		
                    data.add(new Tvtime(rs.getInt(1), rs.getString(2), rs.getString(3), 
			rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7)));				 	
		}			
		con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 			
	id.setCellValueFactory(new PropertyValueFactory<Tvtime,Integer>("id"));
	naziv.setCellValueFactory(new PropertyValueFactory<Tvtime,String>("naziv"));
	zanr.setCellValueFactory(new PropertyValueFactory<Tvtime,String>("zanr"));
	godina.setCellValueFactory(new PropertyValueFactory<Tvtime,Integer>("godina"));
	trajanje.setCellValueFactory(new PropertyValueFactory<Tvtime,String>("trajanje"));
	opis.setCellValueFactory(new PropertyValueFactory<Tvtime,String>("opis"));
	ocena.setCellValueFactory(new PropertyValueFactory<Tvtime,Integer>("ocena"));
 				
 	table.setItems(data);		
	}
 	
}
