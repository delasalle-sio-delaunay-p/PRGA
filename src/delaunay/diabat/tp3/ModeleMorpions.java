package delaunay.diabat.tp3;

public class ModeleMorpions implements SpecifModeleMorpions {

	private int[][] tab;
	private int nbCoupsJoues;
	private SpecifModeleMorpions.Etat etatJeu;

	private void setValue(int ligne, int colonne, int val)
	{
	  tab[(ligne - 1)][(colonne - 1)] = val;
	}
	  
	private int getValue(int ligne, int colonne) {
	   return tab[(ligne - 1)][(colonne - 1)];
	}
	  
	/**
	 * Constructeur sans paramètres
	 * @return une grille de Morpions (matrice 3x3) avec les cases initialisées à 0
	 */
	public ModeleMorpions() {
	
	    nbCoupsJoues = 0;
	    etatJeu = SpecifModeleMorpions.Etat.J1_JOUE;
	    
	    tab = new int[3][3];
	    for (int lig = 1; lig <= 3; lig++)
	    {
	      for (int col = 1; col <= 3; col++)
	        setValue(lig, col, 0);
	    }

	}
	
	/**
	 * 
	 * @param mode : 1 = ligne, 2 = col, 3 = diag
	 * @return
	 */
	public int scanTab(int mode) {
		
		int produit = 0;
		
		switch(mode) 
		{
			case 1:
				// Scan des lignes
				for(int i = 1; i <= tab.length; ++i) 
				{
					for(int j = 1; j <= tab.length; ++j) 
					{
						produit *= tab[i][j];
					}
					
					if (produit == 1)  { return 1; }
					if (produit == 8) { return 2; }
				}
				
				break;
				
			case 2:
				// Scan des colonnes
				for(int i = 1; i <= tab.length; ++i) 
				{
					for(int j = 1; j <= tab.length; ++j) 
					{
						produit *= tab[j][i];
					}
					
					if (produit == 1)  { return 1; }
					if (produit == 8) { return 2; }
				}					
				break;
				
			case 3:
				// Scan des diagonales
				
				int diag1 = tab[1][1] * tab[2][2] * tab[3][3];
				int diag2 = tab[1][3] * tab[2][2] * tab[1][3]; 
				
				if (diag1 == 1) { return 1; }
				if (diag1 == 8) { return 2; }
				if (diag2 == 1) { return 1; }
				if (diag2 == 8) { return 2; }
				
				break;
		}
		
		return 0;
	
	}
	
	public int fullScan() {
		
		int produit = 0;
		
		// Scan des lignes
		for(int i = 1; i < tab.length; ++i) 
		{
			for(int j = 1; j < tab.length; ++j) 
			{
				produit *= tab[i][j];
			}
			
			if (produit == 1)  { return 1; }
			if (produit == 8) { return 2; }
		}
		
		// Scan des colonnes
		for(int i = 1; i < tab.length; ++i) 
		{
			for(int j = 1; j < tab.length; ++j) 
			{
				produit *= tab[j][i];
			}
			
			if (produit == 1)  { return 1; }
			if (produit == 8) { return 2; }
		}	
		
		// Scan des diagonales
		
		int diag1 = tab[1][1] * tab[2][2] * tab[3][3];
		int diag2 = tab[1][3] * tab[2][2] * tab[1][3]; 
		
		if (diag1 == 1) { return 1; }
		if (diag1 == 8) { return 2; }
		if (diag2 == 1) { return 1; }
		if (diag2 == 8) { return 2; }
		
		
		return 0;
		
	}
	
	public boolean estPleine() {
		
		for(int i = 1; i < tab.length; ++i) 
		{
			for(int j = 1; j < tab.length; ++j) 
			{
				if (tab[i][j] == 0) { return false; }
			}
		}
		
		return true;
	}
	
	
	/* SpecifMorpions.Etat : type énuméré des états possibles du jeu :
	 * J1_JOUE      : le joueur 1 est le prochain à jouer
	 * J2_JOUE      : le joueur 2 est le prochain à jouer
	 * MATCH_NUL    : jeu fini, pas de vainqueur
	 * J1_VAINQUEUR : jeu fini, le  vainqueur est 1e joueur 1
	 * J2_VAINQUEUR : jeu fini, le  vainqueur est 1e joueur 2
	*/
	@Override
	public Etat getEtatJeu() {
		
		if (this.estFinie() && this.getVainqueur() != 0) return Etat.MATCH_NUL;
		if (this.getVainqueur() == 1) return Etat.J1_VAINQUEUR;
		if (this.getVainqueur() == 2) return Etat.J2_VAINQUEUR;
		
		if (!this.estFinie() && this.getJoueur() == 1) return Etat.J1_JOUE;
		if (!this.estFinie() && this.getJoueur() == 1) return Etat.J2_JOUE;
		
		return null;
	}

	@Override
	public int getJoueur() {

		if (this.estFinie()) { return 0; }
		else {
			
			int count1 = 0;
			int count2 = 0;
			
			for(int i = 1; i < tab.length; ++i) 
			{
				for(int j = 1; j < tab.length; ++j) 
				{
					if (tab[i][j] == 1) { count1++; }
					else if (tab[i][j] == 2) { count2++; }
					
				}
			}
			return (count1 > count2) ? 2 : 1; 
		}
	}

	@Override
	public int getVainqueur() {
		
		if (!this.estFinie() || this.fullScan() == 0) { return 0; }
		else {
			
			return (this.fullScan() == 1)? 1 : 2; 
			
		}
	}

	@Override
	public int getNombreCoups() {
		
		int count = 0;
		
		for(int i = 1; i < tab.length; ++i) 
		{
			for(int j = 0; j < tab.length; ++j) 
			{
				if (tab[i][j] > 0) {
					++count;
				}
			}
		}	
		return count;
	}

	@Override
	public boolean estFinie() {

		//return (this.estPleine() && this.getVainqueur() != 0);
		return (this.getEtatJeu() == Etat.MATCH_NUL || this.getEtatJeu() == Etat.J1_VAINQUEUR || this.getEtatJeu() == Etat.J2_VAINQUEUR);
	}

	@Override
	public boolean estCoupAutorise(int ligne, int colonne) {

		return tab[ligne][colonne] == 0;
	}

	@Override
	public void jouerCoup(int ligne, int colonne) {
		
		assert(this.estCoupAutorise(ligne, colonne)) : "Le coup n'est pas autorisé";
		assert(this.estFinie())  : "La partie est finie";
		
		tab[ligne][colonne] = this.getJoueur();
	}
	
	public void afficherTab() {
		
		StringBuilder str = new StringBuilder("");
		
		for(int i = 1; i < this.tab.length; ++i) 
		{
			for(int j = 1; j < this.tab.length; ++j) 
			{
				str.append(" " + tab[i][j] );
			}
			
			str.append("\r\n");
		}		
		
		System.out.println(str);
	}
}
