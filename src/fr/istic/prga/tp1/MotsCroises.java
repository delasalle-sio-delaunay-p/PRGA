package fr.istic.prga.tp1;

/**
 * PRGA - TP1
 * @author Pierre
 * @since 2019-01-14
 * @version 1.0.1
 *
 */
public class MotsCroises {

	private Grille solution;
	private Grille proposition;
	private Grille horizontal;
	private Grille vertical;
	
	private int hauteur;
	private int largeur;
	
	public MotsCroises(int hauteur, int largeur) {
		
		assert(hauteur >= 0 && largeur >= 0) : "Hauteur ou largeur nulle";
		this.hauteur = hauteur;
		this.largeur = largeur;	
		
		this.solution = new Grille(hauteur, largeur);
		this.proposition = new Grille(hauteur, largeur);
		this.horizontal = new Grille(hauteur, largeur);
		this.vertical = new Grille(hauteur, largeur);
	}
	
	public int getHauteur() {
		return this.hauteur;
	}
	
	public int getLargeur() {
		return this.largeur;
	}
	
	public boolean coordCorrectes(int lig, int col) {
		return this.solution.coordCorrectes(lig, col);
	}
	
	public boolean estCaseNoire(int lig, int col) {
		assert(coordCorrectes(lig,col)) : "Coordonnées incorrectes";
		return this.solution.getCellule(lig, col) == null;
	}
	
	public void setSolution(int lig, int col, char sol) {
		assert(coordCorrectes(lig,col) && !estCaseNoire(lig,col)) : "Coordonnées incorrectes ou case noire";
		
		this.solution.setCellule(lig, col, String.valueOf(sol));
	}
	
	public char getSolution(int lig, int col) {
		assert(coordCorrectes(lig,col) && !estCaseNoire(lig,col)) : "Coordonnées incorrectes ou case noire";
		
		return this.solution.getCellule(lig, col).charAt(0);
	}
	
	public String getDefinition(int lig, int col, boolean horiz) {
		assert(coordCorrectes(lig,col) && !estCaseNoire(lig,col)) : "Coordonnées incorrectes ou case noire";
		
		return horiz ? this.horizontal.getCellule(lig, col) : this.vertical.getCellule(lig, col);
	}
	
	public void setDefinition(int lig, int col, boolean horiz, String def) {
		assert(coordCorrectes(lig,col) && !estCaseNoire(lig,col)) : "Coordonnées incorrectes ou case noire";
		
		if (horiz) {
			this.horizontal.setCellule(lig, col, def);
		} else {
			this.vertical.setCellule(lig, col, def);
		}
	}
}
