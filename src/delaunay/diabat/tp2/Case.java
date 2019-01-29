package delaunay.diabat.tp2;

/**
 * PRGA - TP2
 * @author Pierre D. , Alexis D.
 * @since 2019-01-21
 * @version 1.0.1
 *
 */
public class Case {

	private char solution; 
	private char proposition; 
	private char horizontal; 
	private char vertical;
	private boolean estNoire;
	
	/**
	 * Constructeur Case
	 * @param solution
	 * @param proposition
	 * @param horizontal
	 * @param vertical
	 * @param estNoire
	 */
	public Case(Character solution, Character proposition, Character horizontal, Character vertical, boolean estNoire) {
		
		this.solution = solution;
		this.proposition = proposition;
		this.horizontal = horizontal;
		this.vertical = vertical;
		this.estNoire = estNoire;
	
	}
	
	/**
	 * Getters/Setters
	 */
	
	public char getSolution() {
		return this.solution;
	}
	
	public void setSolution(char solution) {
		this.solution = solution;
	}
	
	public char getProposition() {
		return this.proposition;
	}
	
	public void setProposition(char proposition) {
		this.proposition = proposition;
	}
}
