package annales;

public class Livre
{
	private String isbn, titre;

	public String getIsbn() { return isbn; }
	
	public void setIsbn(String iSBN) { isbn = iSBN; }
	
	public String getTitre() { return titre; }
	
	public void setTitre(String titre) { this.titre = titre; }
	
	public Livre(String isbn, String titre)
	{
		this.isbn = isbn;
		this.titre = titre;
	}
}