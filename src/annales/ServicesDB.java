package annales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicesDB {
	
	private Connection cnx;
	
	public ServicesDB () {
		try { cnx = connectionMySQL() ; }
		catch (SQLException e) { e.printStackTrace(); }
	}
	   
    public static Connection connectionMySQL() throws SQLException {

        String url = "jdbc:mysql://localhost/base_bousse";
  
        try {
        	Class.forName ("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) { e.printStackTrace(); }
        return DriverManager.getConnection(url, "root", "");
    }
    
    public static List<Livre> getLivresEcritsPar(Auteur auteur) throws SQLException {
		
    	List<Livre> liste = new ArrayList<Livre>();
    	Connection cnx = connectionMySQL();
    	
    	String sql = "SELECT isbn, titre FROM livre WHERE nom_auteur = ? " + "AND prenom_auteur = ?";
    	PreparedStatement pstmt = cnx.prepareStatement(sql);
    	
    	pstmt.setString(1, auteur.getNom());
    	pstmt.setString(2, auteur.getPrenom());
    	
    	ResultSet rs = pstmt.executeQuery();
    	
    	while (rs.next()) {
    		Livre livre = new Livre (rs.getString("ISBN"), rs.getString("titre"));
    		liste.add(livre);
    	}
    	
    	cnx.close();
    	
    	return liste;
    }
    
}
