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
		// Sc�nario(s) v�rifiant l'�tat du jeu avant le premier coup :
		//  * non�fin de partie
		
		assertTrue("Partie pas finie apr�s initialisation", ! morpions.estFinie()) ;
		
		//  * cases accessibles

		assertNotNull("L'objet n'a pas �t� initialis�", true);
		
		// Test de l'invariant de la classe
		testInvariant() ;
	}

	@Test
	public void testPremierCoup()
	{
		morpions.jouerCoup(1, 1) ;
		
		// ----------------------
		// S�QUENCE 2 � COMPL�TER
		// ----------------------

		// Sc�nario v�rifiant le premier coup jou�, notamment :
		//  * position correcte ou non
		assertTrue("Position non correcte, le joueur 1 a d�j� jou� cette case", ! morpions.estCoupAutorise(1, 1));
		//  * non�fin de partie
		assertTrue("Partie pas finie apr�s premier coup", ! morpions.estFinie());
		//  * identit� du premier joueur
		assertTrue(" ", morpions.getJoueur() == 2) ;
		
		// On reteste l'invariant
		testInvariant() ;
	}

	private void testInvariant()
	{
		// Le nombre de coups est positif ou nul, et inf�rieur ou �gal au nombre de cases
		assertTrue("Nombre de coups >= 0", morpions.getNombreCoups() >= 0) ;
		assertTrue("Nombre de coups <= " + NB_CASES,
					morpions.getNombreCoups() <= NB_CASES) ;
		// ----------------------
		// S�QUENCE 3 � COMPL�TER
		// ----------------------
	}
	@Test
	public void testCoupDejaJoue()
	{
		morpions.jouerCoup(1, 1);
		assertTrue("La case (1,1) ne peut �tre jou�e", ! morpions.estCoupAutorise(1,1)) ;
	}

	@Test
	public void testPartiePasFinie()
	{
		// ----------------------
		// S�QUENCE 4 � COMPL�TER
		// ----------------------
		
		// Sc�nario explorant les situations de non�fin de partie,
		// avec v�rification syst�matique de estFinie() == false
		
		morpions.jouerCoup(1, 3);
		assertTrue("Partie pas finie apr�s premier coup", ! morpions.estFinie());
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
		("Apr�s 9 coups sans gagnant, la partie est un match nul", SpecifModeleMorpions.Etat.MATCH_NUL, morpions.getEtatJeu() );
		assertTrue
		("Apr�s 9 coups la partie est forc�ment termin�e", morpions.estFinie());
		
	}

	@Test
	public void testJoueur1gagnant()
	{
		// ----------------------
		// S�QUENCE 5 � COMPL�TER
		// ----------------------
		fail("Test � �crire") ;
	}

	// ------------------------------
	// S�QUENCE � COMPL�TER
	// avec d'autres m�thodes de test
	// (une m�thode par sc�nario)
	// ------------------------------
}

