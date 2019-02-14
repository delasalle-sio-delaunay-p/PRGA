package delaunay.diabat.tp3.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import delaunay.diabat.tp3.ModeleMorpions;
import morpions.kit.test.*;

public class MorpionsTest
{
	//SpecifModeleMorpions morpions ;
	ModeleMorpions morpions;
	public static final int TAILLE = 3 ;
	public static final int NB_CASES = 9 ;


	@Before
	public void setUp() throws Exception
	{
		//morpions = new MorpionsReference() ;
		// morpions = new Bogue1() ;
		// morpions = new Bogue2() ;
		// morpions = new Bogue3() ;
		// morpions = new Bogue4() ;
		//morpions = new Bogue5() ;
		morpions = new ModeleMorpions() ;
	}

	
	@Test
	public void testInit()
	{
		// Scénario(s) vérifiant l'état du jeu avant le premier coup :
		//  * non­fin de partie
		
		assertTrue("Partie pas finie après initialisation", ! morpions.estFinie()) ;
		
		//  * cases accessibles

		assertNotNull("L'objet n'a pas été initialisé", true);
		
		// Test de l'invariant de la classe
		testInvariant() ;
	}

	@Test
	public void testPremierCoup()
	{
		morpions.jouerCoup(1, 1) ;
		
		// ----------------------
		// SÉQUENCE 2 À COMPLÉTER
		// ----------------------

		// Scénario vérifiant le premier coup joué, notamment :
		//  * position correcte ou non
		assertTrue("Position non correcte, le joueur 1 a déjà joué cette case", ! morpions.estCoupAutorise(1, 1));
		//  * non­fin de partie
		assertTrue("Partie pas finie après premier coup", ! morpions.estFinie());
		//  * identité du premier joueur
		assertTrue("Au tour du joueur 2", morpions.getJoueur() == 2) ;
		
		// On reteste l'invariant
		testInvariant() ;
	}

	private void testInvariant()
	{
		// Le nombre de coups est positif ou nul, et inférieur ou égal au nombre de cases
		assertTrue("Nombre de coups >= 0", morpions.getNombreCoups() >= 0) ;
		assertTrue("Nombre de coups <= " + NB_CASES,
					morpions.getNombreCoups() <= NB_CASES) ;
		// ----------------------
		// SÉQUENCE 3 À COMPLÉTER
		// ----------------------
	}
	@Test
	public void testCoupDejaJoue()
	{
		morpions.jouerCoup(1, 1);
		assertTrue("La case (1,1) ne peut être jouée", ! morpions.estCoupAutorise(1,1)) ;
	}

	@Test
	public void testPartiePasFinie()
	{
		// ----------------------
		// SÉQUENCE 4 À COMPLÉTER
		// ----------------------
		
		// Scénario explorant les situations de non­fin de partie,
		// avec vérification systématique de estFinie() == false
		
		morpions.jouerCoup(1, 3);
		assertTrue("Partie pas finie après premier coup", ! morpions.estFinie());
		morpions.jouerCoup(1, 2);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(2, 1);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(1, 1);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(2, 2);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(3, 1);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(3, 2);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(2, 3);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(3, 3);
		assertEquals("Après 9 coups sans gagnant, la partie est un match nul", delaunay.diabat.tp3.SpecifModeleMorpions.Etat.MATCH_NUL, morpions.getEtatJeu() );
		assertTrue("Après 9 coups la partie est forcément terminée", morpions.estFinie());
		
	}

	@Test
	public void testJoueur1gagnant()
	{
		// ----------------------
		// Scénario 1 : Joueur 1 gagne en 3 coups
		// ----------------------
		
		morpions.jouerCoup(1, 1); // J1
		assertTrue("Partie pas finie après premier coup", ! morpions.estFinie());
		morpions.jouerCoup(2, 1); // J2
		assertTrue("Partie pas finie après 2 coups", ! morpions.estFinie());
		morpions.jouerCoup(1, 2); // J1
		assertTrue("Partie pas finie après 3 coups", ! morpions.estFinie());
		morpions.jouerCoup(2, 2); // J2
		assertTrue("Partie pas finie après 4 coups", ! morpions.estFinie());
		morpions.jouerCoup(1, 3); // J1 gagne en 3 coups
		assertTrue("Partie terminée, remportée par joueur 1", morpions.estFinie());
		assertTrue("Joueur 1 non vainqueur", morpions.getVainqueur() == 1);

	}
	
	@Test
	public void testVainqueur1() throws Exception
	{
		// ----------------------
		// Scénario 1  getVainqueur1 : Joueur 1 gagne en 3 coups
		// ----------------------
		
		morpions.jouerCoup(1, 1); // J1
		assertTrue("Partie pas finie après premier coup", ! morpions.estFinie());
		morpions.jouerCoup(2, 1); // J2
		assertTrue("Partie pas finie après 2 coups", ! morpions.estFinie());
		morpions.jouerCoup(1, 2); // J1
		assertTrue("Partie pas finie après 3 coups", ! morpions.estFinie());
		morpions.jouerCoup(2, 2); // J2
		assertTrue("Partie pas finie après 4 coups", ! morpions.estFinie());
		morpions.jouerCoup(1, 3); // J1 gagne en 3 coups
		assertTrue("Partie terminée, remportée par joueur 1", morpions.estFinie());
		assertTrue("Joueur 1 non vainqueur", morpions.getVainqueur() == 1);	
	}
	
	@Test
	public void testVainqueur2()
	{
		// ----------------------
		// Scénario getVainqueur 2 : Match nul entre les 2 joueurs (9 coups total)
		// ----------------------	
			
		morpions.jouerCoup(1, 3);
		assertTrue("Partie pas finie après premier coup", ! morpions.estFinie());
		morpions.jouerCoup(1, 2);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(2, 1);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(1, 1);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(2, 2);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(3, 1);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(3, 2);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(2, 3);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(3, 3);
		assertEquals("Après 9 coups sans gagnant, la partie est un match nul", delaunay.diabat.tp3.SpecifModeleMorpions.Etat.MATCH_NUL, morpions.getEtatJeu() );
		assertTrue("Personne n'a gagné", morpions.getVainqueur() == 0);	
	}

	@Test
	public void testVainqueur3()
	{
		// ----------------------
		// Scénario getVainqueur 3 : Joueur 2 gagne en 3 coups
		// ----------------------
		
		morpions.jouerCoup(1, 1); // J1
		assertTrue("Partie pas finie après premier coup", ! morpions.estFinie());
		morpions.jouerCoup(1, 2); // J2
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(2, 1); // J1
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(2, 2); // J2
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(3, 3); // J1
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(3, 2); // J2		
		assertTrue("Partie terminée, remportée par joueur 2", morpions.estFinie());
		assertTrue("Joueur 2 non vainqueur", morpions.getVainqueur() == 2);
	}
	
	@Test
	public void testControle() 
	{
		// Scénario tentant divers coups non autorisés,
		// avec vérification systématique de estCoupAutorise() 
	
		morpions.jouerCoup(1, 1); // J1
		assertTrue("Coup au même endroit que précédent", !morpions.estCoupAutorise(1, 1));
		
		assertTrue("Coup hors de la grille", !morpions.estCoupAutorise(4, 4));
		
		morpions.jouerCoup(2, 1); // J2
		assertTrue("Coup au même endroit que précédent", !morpions.estCoupAutorise(2, 1));
	
		assertTrue("Case occupée", !morpions.estCoupAutorise(1, 1)); // J1 rejoue le même coup que son premier
		
	}
	
	@Test
	public void testNombreCoups1()
	{
		// ----------------------
		// Scénario 1  getNombreCoups : Joueur 1 gagne en 3 coups
		// ----------------------
		
		morpions.jouerCoup(1, 1); // J1
		assertTrue("Partie pas finie après premier coup", ! morpions.estFinie());
		assertTrue("1 coup au total", morpions.getNombreCoups() == 1);
		morpions.jouerCoup(2, 1); // J2
		assertTrue("Partie pas finie après 2 coups", ! morpions.estFinie());
		assertTrue("2 coups au total", morpions.getNombreCoups() == 2);
		morpions.jouerCoup(1, 2); // J1
		assertTrue("Partie pas finie après 3 coups", ! morpions.estFinie());
		assertTrue("3 coups au total", morpions.getNombreCoups() == 3);
		morpions.jouerCoup(2, 2); // J2
		assertTrue("Partie pas finie après 4 coups", ! morpions.estFinie());
		assertTrue("4 coups au total", morpions.getNombreCoups() == 4);
		morpions.jouerCoup(1, 3); // J1 gagne en 3 coups
		assertTrue("5 coups au total", morpions.getNombreCoups() == 5);
		assertTrue("Partie terminée, remportée par joueur 1", morpions.estFinie());
		assertTrue("Joueur 1 non vainqueur", morpions.getVainqueur() == 1);			
	}
	
	@Test
	public void testNombreCoups2()
	{
		// ----------------------
		// Scénario 2 getNombreCoups : Match nul entre les 2 joueurs (9 coups total)
		// ----------------------	
			
		morpions.jouerCoup(1, 3);
		assertTrue("Partie pas finie après premier coup", ! morpions.estFinie());
		assertTrue("1 coup au total", morpions.getNombreCoups() == 1);
		morpions.jouerCoup(1, 2);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		assertTrue("1 coup au total", morpions.getNombreCoups() == 2);
		morpions.jouerCoup(2, 1);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		assertTrue("1 coup au total", morpions.getNombreCoups() == 3);
		morpions.jouerCoup(1, 1);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		assertTrue("1 coup au total", morpions.getNombreCoups() == 4);
		morpions.jouerCoup(2, 2);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		assertTrue("1 coup au total", morpions.getNombreCoups() == 5);
		morpions.jouerCoup(3, 1);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		assertTrue("1 coup au total", morpions.getNombreCoups() == 6);
		morpions.jouerCoup(3, 2);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		assertTrue("1 coup au total", morpions.getNombreCoups() == 7);
		morpions.jouerCoup(2, 3);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		assertTrue("1 coup au total", morpions.getNombreCoups() == 8);
		morpions.jouerCoup(3, 3);
		assertTrue("1 coup au total", morpions.getNombreCoups() == 9);
		//assertTrue("Personne n'a gagné", morpions.getVainqueur() == 0);			
	}	
	
	@Test
	public void testFinPartie1()
	{
		// Scénarios explorant les situations de fin de partie,
		// avec vérification systématique de estFinie() et de
		// getVainqueur() :
		//  * alignement horizontal (grille pleine ou non)	
	
		morpions.jouerCoup(1, 1); // J1
		assertTrue("Partie pas finie après premier coup", ! morpions.estFinie());
		assertTrue("Joueur 1 non vainqueur", morpions.getVainqueur() == 0);
		morpions.jouerCoup(2, 1); // J2
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(1, 2); // J1
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(2, 2); // J2
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(1, 3); // J1
		assertTrue("Partie terminée, remportée par joueur 1", morpions.estFinie());
		assertTrue("Joueur 2 non vainqueur", morpions.getVainqueur() == 1);
	}
	
	@Test
	public void testFinPartie2()
	{
	
		//  * alignement vertical (grille pleine ou non)
		
		morpions.jouerCoup(1, 1); // J1
		assertTrue("Partie pas finie après premier coup", ! morpions.estFinie());
		assertTrue("Joueur 1 non vainqueur", morpions.getVainqueur() == 0);
		morpions.jouerCoup(1, 2); // J2
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(2, 1); // J1
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(1, 3); // J2
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(3, 1); // J1
		assertTrue("Partie terminée, remportée par joueur 1", morpions.estFinie());
		assertTrue("Joueur 2 non vainqueur", morpions.getVainqueur() == 1);
	}
	
	@Test
	public void testFinPartie3()
	{
		
		//  * alignement diagonal : 1ère diagonale (grille pleine ou non)
		
		morpions.jouerCoup(1, 1); // J1
		assertTrue("Partie pas finie après premier coup", ! morpions.estFinie());
		assertTrue("Joueur 1 non vainqueur", morpions.getVainqueur() == 0);
		morpions.jouerCoup(1, 2); // J2
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(2, 2); // J1
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(1, 3); // J2
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(3, 3); // J1
		assertTrue("Partie terminée, remportée par joueur 1", morpions.estFinie());
		assertTrue("Joueur 2 non vainqueur", morpions.getVainqueur() == 1);
	}

	@Test
	public void testFinPartie4()
	{
		
		//  * alignement diagonal : 2ème diagonale (grille pleine ou non)
		
		morpions.jouerCoup(3, 1); // J1
		assertTrue("Partie pas finie après premier coup", ! morpions.estFinie());
		assertTrue("Joueur 1 non vainqueur", morpions.getVainqueur() == 0);
		morpions.jouerCoup(1, 2); // J2
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(2, 2); // J1
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(2, 1); // J2
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(1, 3); // J1
		assertTrue("Partie terminée, remportée par joueur 1", morpions.estFinie());
		assertTrue("Joueur 2 non vainqueur", morpions.getVainqueur() == 1);
	}
	
}

