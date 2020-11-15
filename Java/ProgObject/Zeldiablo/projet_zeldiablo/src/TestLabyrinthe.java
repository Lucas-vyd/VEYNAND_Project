import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestLabyrinthe {


	/**
	 * test pour verifier s'il n'y a pas de mur
	 */


	@Test
	public void test_LabyrintheVide() {
		Jeu j = new Jeu();
		assertEquals("Il n'y a normalement pas de mur ici",j.terrain.isEmpty(1, 1),true);

	}


	/**
	 * test pour verifier s'il y a bien un mur
	 */


	@Test
	public void test_LabyrintheMur() {
		Jeu j = new Jeu();
		assertEquals("Il n'y a normalement un mur ici",j.terrain.isEmpty(2, 2),false);

	}
}
