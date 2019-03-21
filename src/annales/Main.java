package annales;

import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		/* ANNALES 2015 */
		
		/* Question 2 */
		
		/*
		Auteur author = new Auteur("Roux", "Charles");
		List<Livre> liste = ServicesDB.getLivresEcritsPar(author);
		System.out.println("Q2 : " + liste.toString());
		*/
		/* Question 3 */
		//System.out.println(author.getLivres().toString());
		
		/* Question 4 */
		
		
		/* ANNALES 2019 */
		Compteur x = new Compteur();
		Compteur y = new Compteur();
		Compteur z = x;
		y = new Compteur();
		System.out.println(z.i + " + " + z.j);
	}

}
