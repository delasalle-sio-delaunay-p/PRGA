package delaunay.diabat.tp3.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import morpions.kit.test.*;

public class MorpionsTest
{
	SpecifModeleMorpions morpions ;
	public static final int TAILLE = 3 ;
	public static final int NB_CASES = 9 ;


	@Before
	public void setUp() throws Exception
	{
		morpions = new MorpionsReference() ;
		// morpions = new Bogue1() ;
		// morpions = new Bogue2() ;
		// morpions = new Bogue3() ;
		// morpions = new Bogue4() ;
		//morpions = new Bogue5() ;
		// morpions = new x.y.morpions.ModeleMorpions() ;
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
		assertTrue(" ", morpions.getJoueur() == 2) ;
		
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
		morpions.jouerCoup(2, 1);
		morpions.jouerCoup(1, 1);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(2, 2);
		morpions.jouerCoup(3, 1);
		morpions.jouerCoup(3, 2);
		assertTrue("Partie pas finie", ! morpions.estFinie());
		morpions.jouerCoup(3, 3);
		assertEquals
		("Après 9 coups sans gagnant, la partie est un match nul", SpecifModeleMorpions.Etat.MATCH_NUL, morpions.getEtatJeu() );
		assertTrue
		("Après 9 coups la partie est forcément terminée", morpions.estFinie());
		
	}

	@Test
	public void testJoueur1gagnant()
	{
		// ----------------------
		// SÉQUENCE 5 À COMPLÉTER
		// ----------------------
		fail("Test à écrire") ;
	}

	// ------------------------------
	// SÉQUENCE À COMPLÉTER
	// avec d'autres méthodes de test
	// (une méthode par scénario)
	// ------------------------------
}

