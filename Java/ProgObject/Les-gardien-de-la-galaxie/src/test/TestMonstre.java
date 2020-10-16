package test;

import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import application.*;

/**
 * test classe Monstre
 *
 * A COMPLETER
 */

public class TestMonstre {

	/**
	 * test initial
	 * A NE PAS MODIFIER
	 */
	public void test_initial() {
		Monstre m = new Monstre(2, 3);
		boolean b = m.avoirCollision(new Tir(2, 2));
		b = m.avoirTraverse();
		m.evoluer();
		b = m.getEtreMort();
		int x = m.getX();
		int y = m.getY();
	}


	// test condition Vraie
	public void test_parametre_conditionVraie(){
		// constructeur teste
		Monstre m = new Monstre(3, 6);

		// verifie retour 3
		assertEquals("test X", 3, m.getX());
		// verifie retour 6
		assertEquals("test Y", 6, m.getY());
		// verifie retour false
		assertEquals("test etreMort", false, m.getEtreMort());
	}

	// test condition Fausse
	public void test_parametre_conditionFausse(){
		// constructeur teste
		Monstre m = new Monstre(-2, 16);

		// verifie retour 10
		assertEquals("test X", 10, m.getX());
		// verifie retour 5
		assertEquals("test Y", 5, m.getY());
		// verifie retour false
		assertEquals("test etreMort", false, m.getEtreMort());
	}

	// test evoluer deplacer True non Changement
	public void test_evoluer_deplacerTrue_nonChangement(){
		// preparation des donnees
		Monstre m = new Monstre(3,6);
		// constructeur teste
		m.evoluer();

		// verifie retour 3
		assertEquals("test X", 3, m.getX());
		// verifie retour 5
		assertEquals("test Y", 5, m.getY());
	}

	// test evoluer deplacer True Changement
	public void test_evoluer_deplacerTrue_Changement(){
		// preparation des donnees
		Monstre m = new Monstre(3,0);
		// constructeur teste
		m.evoluer();

		// verifie retour 2
		assertEquals("test X", 2, m.getX());
		// verifie retour 0
		assertEquals("test Y", 0, m.getY());
	}

	// test evoluer deplacer False non Changement
	public void test_evoluer_deplacerFalse_nonChangement(){
		// preparation des donnees
		Monstre m = new Monstre(3,0);
		m.evoluer();
		// constructeur teste
		m.evoluer();

		// verifie retour 3
		assertEquals("test X", 2, m.getX());
		// verifie retour 7
		assertEquals("test Y", 1, m.getY());
	}

	// test evoluer deplacer False non Changement
	public void test_evoluer_deplacerFalse_Changement(){
		// preparation des donnees
		Monstre m = new Monstre(3,0);
		m.evoluer();
		m.evoluer();
		m.evoluer();
		m.evoluer();
		m.evoluer();
		m.evoluer();
		m.evoluer();
		m.evoluer();
		m.evoluer();
		m.evoluer();
		m.evoluer();
		// constructeur teste
		m.evoluer();

		// verifie retour 3
		assertEquals("test X", 1, m.getX());
		// verifie retour 7
		assertEquals("test Y", 10, m.getY());
	}

	// test avoir Traverse True
	public void test_avoirTraverseTrue(){
		// preparation des donnees
		Monstre m = new Monstre(0,6);
		// constructeur teste
		m.avoirTraverse();

		// verifie retour 3
		assertEquals("test X", 0, m.getX());
		// verifie retour 7
		assertEquals("test Y", 6, m.getY());
		// verifie retour true
		assertEquals("test avoirTraverse", true, m.avoirTraverse());
	}

	// test avoir Traverse False
	public void test_avoirTraverseFalse(){
		// preparation des donnees
		Monstre m = new Monstre(3,6);
		// constructeur teste
		m.avoirTraverse();

		// verifie retour 3
		assertEquals("test X", 3, m.getX());
		// verifie retour 7
		assertEquals("test Y", 6, m.getY());
		// verifie retour false
		assertEquals("test avoirTraverse", false, m.avoirTraverse());
	}

	// test avoir Collision True
		public void test_avoirCollisionTrue(){
			// preparation des donnees
			Monstre m = new Monstre(3,6);
			Tir t = new Tir(3,6);
			// constructeur teste
			m.avoirCollision(t);

			// verifie retour 3
			assertEquals("test X", 3, m.getX());
			// verifie retour 7
			assertEquals("test Y", 6, m.getY());
			// verifie retour 3
			assertEquals("test X", 3, t.getX());
			// verifie retour 6
			assertEquals("test Y", 6, t.getY());
			// verifie retour true
			assertEquals("test avoirCollision", true, m.avoirCollision(t));
		}

	// test avoir Collision False
		public void test_avoirCollisionFalse(){
			// preparation des donnees
			Monstre m = new Monstre(3,6);
			Tir t = new Tir(7,4);
			// constructeur teste
			m.avoirCollision(t);

			// verifie retour 3
			assertEquals("test X", 3, m.getX());
			// verifie retour 7
			assertEquals("test Y", 6, m.getY());
			// verifie retour 7
			assertEquals("test X", 7, t.getX());
			// verifie retour 4
			assertEquals("test Y", 4, t.getY());
			// verifie retour false
			assertEquals("test avoirCollision", false, m.avoirCollision(t));
		}

	// test avoir Collision Null False
		public void test_avoirCollisionNullFalse(){
			// preparation des donnees
			Monstre m = new Monstre(3,6);
			Tir t = null;
			// constructeur teste
			m.avoirCollision(t);

			// verifie retour 3
			assertEquals("test X", 3, m.getX());
			// verifie retour 7
			assertEquals("test Y", 6, m.getY());
			// verifie retour null
			assertEquals("test X", null, t);
			// verifie retour false
			assertEquals("test avoirCollision", false, m.avoirCollision(t));
		}

	// test toString
		public void test_toString() {
			// preparation des donnees
			Monstre m = new Monstre(3,6);
			// methode testee
			String Mstr = m.toString();

			// verifie retour true car sortie de l arene
			assertEquals("il devrais retourner", "Monstre(3,6)", Mstr);
		}


	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestMonstre(), args);
	}

}
