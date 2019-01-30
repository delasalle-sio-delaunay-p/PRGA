package delaunay.diabat.tp3;

public class Morpions {

	private int[][] tab;
	private int hauteur;
	private int largeur;
	
	public Morpions (int largeur, int hauteur) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.tab = new int[hauteur][largeur];
	}
	
}
