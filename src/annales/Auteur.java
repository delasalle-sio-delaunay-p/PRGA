package annales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Auteur
{
	private String nom, prenom;
	private List<Livre> livresEcrits;
	
	public String getNom() { return nom; }
	
	public void setNom(String nom) { this.nom = nom; }
	
	public String getPrenom() { return prenom; }
	
	public void setPrenom(String prenom) { this.prenom = prenom; }
	
	public Auteur(String nom, String prenom)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.livresEcrits = null;
	}
	
	public List<Livre> getLivres() throws SQLException {
				
		if (this.livresEcrits == null) {
			List<Livre> l = ServicesDB.getLivresEcritsPar(this);
			this.livresEcrits = l;
		}

		return this.livresEcrits;
	}
	
	public boolean existeAuteur(String isbn) throws SQLException {
		Connection cnx = ServicesDB.connectionMySQL();
		
		return false;
	}
	
	public boolean addLivre(Livre livre) throws SQLException {
		
		if (this.existeAuteur(livre.getIsbn())) {
			return false;
		}
		
		Connection cnx = ServicesDB.connectionMySQL();
		
		String insert = "INSERT INTO auteur_livre VALUES(?, ?, ?)";
    	PreparedStatement pstmt = cnx.prepareStatement(insert);
    	
    	pstmt.setString(1, livre.getIsbn());
    	pstmt.setString(2, this.getNom());
    	pstmt.setString(3, this.getPrenom());
    	
    	pstmt.executeUpdate(insert);
		
		this.livresEcrits.add(livre);
		
		cnx.close();
		
		return true;
	}
}
