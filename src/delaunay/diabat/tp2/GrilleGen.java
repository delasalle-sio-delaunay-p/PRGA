package delaunay.diabat.tp2;

public class GrilleGen <T> implements SpecifGrilleGen <T> {

	private int hauteur;
	private int largeur; 
	private Object tab[][] ; 
	
	
	public GrilleGen(int hauteur, int largeur) {
		 this.hauteur= hauteur; 
		 this.largeur = largeur; 
		 this.tab = new Object [hauteur][largeur]; 
		
	 }
	
	public Object getTab () {
		return this.tab;
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
