package application;

import model.Zanr;
import model.Tvtime;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
 
public class DBInfo {
    
//Uspostavlja konekciju sa bazom.
	
public static Connection getConnection(){
    Connection con = null;
				
    try {
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost/CS102-PZ";
	con = DriverManager.getConnection(url, "root","");						
	} 
    catch (ClassNotFoundException | SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
	}
    return con;
}
		
//Čuva podatke u bazu preuzete iz forme za unos.

public static int ubaci(Tvtime tv){
		
    int st = 0;
		
    try {
	String sql = "INSERT INTO `tvtime`( `naziv`, `zanr`, `godina`, `trajanje`, `opis`, `ocena`) VALUES (?,?,?,?,?,?)";
	Connection con = DBInfo.getConnection();
	PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
	preparedStatement.setString(1, tv.getNaziv());
	preparedStatement.setString(2, tv.getZanr());
	preparedStatement.setInt(3, tv.getGodina());
	preparedStatement.setString(4, tv.getTrajanje());
	preparedStatement.setString(5, tv.getOpis());
	preparedStatement.setInt(6, tv.getOcena());
			
	st = preparedStatement.executeUpdate();
			
	con.close();
			
	} 
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
		
	return st;		
}
		
	
public static int azuriraj(Tvtime tv){
		
    int st = 0;
		
    try {
	String sql = "UPDATE `tvtime` SET `naziv`=?,`zanr`=?,`godina`=?,`trajanje`=?,`opis`=?,`ocena`=? WHERE id=?";
	Connection con = DBInfo.getConnection();
	PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
	preparedStatement.setString(1, tv.getNaziv());
	preparedStatement.setString(2, tv.getZanr());
	preparedStatement.setInt(3, tv.getGodina());
	preparedStatement.setString(4, tv.getTrajanje());
	preparedStatement.setString(5, tv.getOpis());
	preparedStatement.setInt(6, tv.getOcena());

	preparedStatement.setInt(7, tv.getId());
			
	st = preparedStatement.executeUpdate();
			
	con.close();
			
	} 
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
		
	return st;		
}
	
	
public static int obrisi(int id){
	
    int st = 0;
	
    try {
	String sql = "DELETE FROM `tvtime` WHERE id=?";
	Connection con = DBInfo.getConnection();
	PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
		 
	preparedStatement.setInt(1, id);
		
	st = preparedStatement.executeUpdate();
		
	con.close();		
    } 
    catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
    }
	
    return st;	
}
	
		
public static Tvtime  getTvtimeID(int id){
	
    Tvtime tv = new Tvtime();
	
    try {
	String sql = "SELECT * FROM `tvtime` WHERE id=?";
	Connection con = DBInfo.getConnection();
	PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
		
	preparedStatement.setInt(1, id);
	ResultSet resultSet = preparedStatement.executeQuery();
		
	if (resultSet.next()) {
  			
            tv.setId(resultSet.getInt(1));
            tv.setNaziv(resultSet.getString(2));
            tv.setZanr(resultSet.getString(3));
            tv.setGodina(resultSet.getInt(4));
            tv.setTrajanje(resultSet.getString(5));
            tv.setOpis(resultSet.getString(6));
            tv.setOcena(resultSet.getInt(7));	
	}
	con.close();
		
	}
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
	
	return tv;	
}
	
//Preuzima listu žanrova iz baze koja se prikazuje u ComboBox-u.

public static List<Zanr>  getZanr(){
	
    List<Zanr> list = new ArrayList<Zanr>();
 	
    try {
	String sql = "SELECT * FROM `zanr`";
	Connection con = DBInfo.getConnection();
	PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
		
	ResultSet resultSet = preparedStatement.executeQuery();
		
	while (resultSet.next()) {
		Zanr zanr = new Zanr();
			
		zanr.setId(resultSet.getInt(1));
		zanr.setNaziv(resultSet.getString(2));
		list.add(zanr);		
	}
	con.close();
		
	} 
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
	
	return list;
}	

}