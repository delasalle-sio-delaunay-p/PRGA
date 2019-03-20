package annales;

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
		
		return (this.livresEcrits == null) ? this.livresEcrits = ServicesDB.getLivresEcritsPar(this) : this.livresEcrits; 
		
	}
}
