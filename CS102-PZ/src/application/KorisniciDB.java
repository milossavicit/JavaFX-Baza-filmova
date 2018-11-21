package application;

import model.Korisnici;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
 
public class KorisniciDB {

    static Connection con = null;
	
	public static Connection getConnection(){
		
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
	
//Proverava da li se korisnik nalazi u bazi.
        
public static List<Korisnici>  getKorisnici(){
	
	List<Korisnici> list = new ArrayList<Korisnici>();
	
	try {
		String sql = "SELECT * FROM korisnici";
		Connection con = KorisniciDB.getConnection();
		PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			Korisnici kor = new Korisnici();
			
			kor.setId(resultSet.getInt(1));
			kor.setUsername(resultSet.getString(2));
			kor.setPassword(resultSet.getString(3));
			 
			list.add(kor);
		}

		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
}	
	
}