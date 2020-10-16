package test;

import application.*;
import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

/**
 * test classe Tir
 *
 * A COMPLETER
 */

public class TestTir {

	/**
	 * test initial pour verifier le bon appel des methodes
	 */
	public void test_initial() {
		Tir t = new Tir(5, 6);
		assertEquals("test X", 5, t.getX());
		assertEquals("test Y", 6, t.getY());
		t.evoluer();
	}



	// test Evoluer Reste Dans Arene
	public void test_Evoluer_ResteDansArene() {
		// preparation des donnees
		Tir t = new Tir(6, 5);

		// methode testee
		boolean res = t.evoluer();

		// verifie retour false
		assertEquals("tir devrait rester dans arene", false, res);
		// verifie position apres evolution
		assertEquals("tir devrait evoluer en X", 7, t.getX());
		assertEquals("tir devrait rester en Y", 5, t.getY());
	}

	// test Evoluer Sortir Arene
	public void test_Evoluer_SortirArene() {
		// preparation des donnees
		Tir t = new Tir(10, 5);

		// methode testee
		boolean res = t.evoluer();

		// verifie retour true car sortie de l arene
		assertEquals("tir devrait rester dans arene", true, res);
		// verifie position apres evolution
		assertEquals("tir devrait evoluer en X", 11, t.getX());
		assertEquals("tir devrait rester en Y", 5, t.getY());
	}

	// test toString
	public void test_toString() {
		// preparation des donnees
		Tir t = new Tir(6, 5);

		// methode testee
		String res = t.toString();

		// verifie retour true car sortie de l arene
		assertEquals("il devrais retourner", "T(6,5)", res);
		// verifie position apres evolution
		assertEquals("valeur X", 6, t.getX());
		assertEquals("valeur Y", 5, t.getY());

	}

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestTir(), args);
	}

}
