package delaunay.diabat.tp2;

public class MotsCroisesAvecHeritage extends Grille<Case> {

	private Grille<Case> solution;
	private Grille<Case> proposition;
	private Grille<Case> horizontal;
	private Grille<Case> vertical;
	
	private int hauteur;
	private int largeur;
	
	public MotsCroisesAvecHeritage(int hauteur, int largeur) {
		
		super(hauteur,largeur);
		this.solution = new Grille<Case> (hauteur,largeur);
		this.proposition = new Grille<Case> (hauteur,largeur);
		this.horizontal = new Grille<Case> (hauteur,largeur);
		this.vertical = new Grille<Case> (hauteur,largeur);
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
		assert(coordCorrectes(lig,col)) : "Coordonn�es incorrectes";
		return this.solution.getCellule(lig, col) == "*";
	}

	public void setCaseNoire(int lig, int col, boolean noire) {
		assert(coordCorrectes(lig,col)) : "Coordonn�es incorrectes";

		if (noire) {
			this.solution.setCellule(lig, col, "*");
		}
		else {
			this.solution.setCellule(lig, col, " ");
		}
	}
	
	public void setSolution(int lig, int col, char sol) {
		assert(coordCorrectes(lig,col) && !estCaseNoire(lig,col)) : "Coordonn�es incorrectes ou case noire";
		
		this.solution.setCellule(lig, col, String.valueOf(sol));
	}
	
	public char getSolution(int lig, int col) {
		assert(coordCorrectes(lig,col) && !estCaseNoire(lig,col)) : "Coordonn�es incorrectes ou case noire";
		
		return ((String) this.solution.getCellule(lig, col)).charAt(0);
	}
	
	public void setProposition(int lig, int col, char sol) {
		assert(coordCorrectes(lig,col) && !estCaseNoire(lig,col)) : "Coordonn�es incorrectes ou case noire";
		
		this.proposition.setCellule(lig, col, String.valueOf(sol));
	}
	
	public char getProposition(int lig, int col) {
		assert(coordCorrectes(lig,col) && !estCaseNoire(lig,col)) : "Coordonn�es incorrectes ou case noire";
		
		return ((String) this.proposition.getCellule(lig, col)).charAt(0);
	}
	
	public Object getDefinition(int lig, int col, boolean horiz) {
		assert(coordCorrectes(lig,col) && !estCaseNoire(lig,col)) : "Coordonn�es incorrectes ou case noire";
		
		return horiz ? this.horizontal.getCellule(lig, col) : this.vertical.getCellule(lig, col);
	}
	
	public void setDefinition(int lig, int col, boolean horiz, String def) {
		assert(coordCorrectes(lig,col) && !estCaseNoire(lig,col)) : "Coordonn�es incorrectes ou case noire";
		
		if (horiz) {
			this.horizontal.setCellule(lig, col, def);
		} else {
			this.vertical.setCellule(lig, col, def);
		}
	}
}
