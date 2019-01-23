package delaunay.diabat.tp2;

/**
 * PRGA - TP2
 * @author Pierre D. , Alexis D.
 * @since 2019-01-21
 * @version 1.0.1
 *
 */
public class Case {

	private Character solution;
	private Character proposition;
	private Grille horizontal;
	private Grille vertical;
	private boolean caseNoire;
	
	public Case(Character solution, Character proposition, Grille horizontal, Grille vertical, boolean caseNoire) {
		
		this.solution = solution;
		this.proposition = proposition;
		this.horizontal = horizontal;
		this.vertical = vertical;
		this.caseNoire = caseNoire;
	
	}
}
