package delaunay.diabat.tp1;

/**
 * PRGA - TP1
 * @author Pierre D. , Alexis D.
 * @since 2019-01-14
 * @version 1.0.1
 *
 */
public class Grille {

	private int hauteur;
	private int largeur;
	private String tab[][];
	private int taille;
	
	public Grille (int hauteur, int largeur) {
		
		assert(hauteur >= 0 && largeur >= 0) : "Hauteur ou largeur nulle";
		
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
		return (lig <= this.hauteur && col <= this.largeur && lig > 0 && col > 0);
	}
	
	public String getCellule(int lig, int col) {
		assert(coordCorrectes(lig,col)) : "Coordonnées incorrectes";
		
		return this.tab[lig-1][col-1];
	}
	
	public void setCellule(int lig, int col, String ch) {
		
		assert(coordCorrectes(lig,col)) : "Coordonnées incorrectes";
		this.tab[lig-1][col-1] = String.valueOf(ch);
	}
	
	@Override
	public String toString() {
		
		StringBuffer resultat = new StringBuffer();
		
		for (int i = 1; i <= this.hauteur; ++i) {
			
			for (int j = 1; j <= this.largeur; ++j) {
				if (j > 1) {
					resultat.append("|");
				}
				resultat.append(this.getCellule(i,j));
			}
			resultat.append("\n");
		}
		
		return resultat.toString();
	}
}
