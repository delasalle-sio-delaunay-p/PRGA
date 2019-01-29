package delaunay.diabat.tp2;

/**
 * PRGA - TP2
 * @author Pierre D. , Alexis D.
 * @since 2019-01-21
 * @version 1.0.1
 *
 */
public class GrilleGen <T> {

	private int hauteur;
	private int largeur; 
	private Object tab[][] ; 
	
	
	public GrilleGen(int hauteur, int largeur) {
		 this.hauteur= hauteur; 
		 this.largeur = largeur; 
		 this.tab = new Object [hauteur][largeur]; 
		
	 }
	
	public IterateurMots iterateurMots (boolean horizontal, int num) {
		
		 if(horizontal) { 
			 IterateurMots itCol = new IterateurMots(tab[num]);
			 return itCol;
		 }
		 else 
		 { 	 
			 IterateurMots itLig = new IterateurMots(tab);
			 return itLig;
		 }	
	}
	
}
