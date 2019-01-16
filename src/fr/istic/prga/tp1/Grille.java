package fr.istic.prga.tp1;


public class Grille {

	private int hauteur;
	private int largeur;
	private String tab[][];
	private int taille;
	
	public Grille (int hauteur, int largeur) {
		
		assert(hauteur >= 0 || largeur >= 0) : "Hauteur ou largeur nulle";
		
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.taille = hauteur * largeur;
		this.tab = new String[hauteur][largeur];
	}
	
	public int getHauteur() {
		return this.hauteur;
	}
	
	public int getLargeur() {
		return this.largeur;
	}
	
	public boolean coordCorrectes(int lig, int col) {
		return (lig <= this.largeur && col <= this.hauteur && lig > 0 && col > 0);
	}
	
	public String getCellule(int lig, int col) {
		return this.tab[lig-1][col-1];
	}
	
	public void setCellule(int lig, int col, String ch) {
		this.tab[lig-1][col-1] = String.valueOf(ch);
	}
	
	@Override
	public String toString() {
		
		String msg = "";
		
		for (int i = 0; i <= this.largeur; ++i) {
			
			for (int j = 0; j <= this.hauteur; ++j) {
				
			}
		}
		
		return msg;
	}
}
