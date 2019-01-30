package delaunay.diabat.tp2;

/**
 * PRGA - TP2
 * @author Pierre D. , Alexis D.
 * @since 2019-01-30
 * @version 1.0.1
 *
 */
public class MotsCroisesAvecGen <T> implements SpecifMotsCroisesAvecGen <T> {

	private GrilleGen<T> solution;
	private GrilleGen<T> proposition;
	private GrilleGen<T> horizontal;
	private GrilleGen<T> vertical;
	
	private int hauteur;
	private int largeur;	

	public MotsCroisesAvecGen(int hauteur, int largeur) {
		
		assert(hauteur >= 0 && largeur >= 0) : "Hauteur ou largeur nulle";
		this.hauteur = hauteur;
		this.largeur = largeur;	
		
		this.solution = new GrilleGen<T> (hauteur, largeur);
		this.proposition = new GrilleGen<T> (hauteur, largeur);
		this.horizontal = new GrilleGen<T> (hauteur, largeur);
		this.vertical = new GrilleGen<T> (hauteur, largeur);
	}
	
	public String solutions() {
		return solution.toString();
	}
	
	private String toString(char type, boolean horiz) {
		
		String resultat = "";
		IterateurMots it;
		
		switch (type) {
		
			case 'S':
				it = solution.iterateurMots(horiz, 1);
			break;
			case 'P':
				it = proposition.iterateurMots(horiz, 1);
			break;	
			case 'D':
				if (horiz) {
					it = horizontal.iterateurMots(horiz, 1);
				}
				else {
					it = vertical.iterateurMots(!horiz, 1);
				}
			break;
			
			
		}
		
		return resultat;
	}

}
