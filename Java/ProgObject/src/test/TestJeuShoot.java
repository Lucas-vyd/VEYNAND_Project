package test;

import libtest.*;
import application.*;
import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

/**
 * classe de test de JeuShoot
 *
 * A COMPLETER
 */
public class TestJeuShoot {

	/**
	 * test initial
	 * A NE PAS MODIFIER
	 */
	public void test_initial() {
		JeuShoot j = new JeuShoot();
		Monstre monstre = j.getEnnemi();
		Vaisseau v = j.getJoueur();
		int s = j.getScore();
		boolean b=j.getPerdu();
		j.evoluer(0);
		j.setEnnemi(new Monstre(2,2));
		j.setJoueur(new Vaisseau(2,2));
		assertEquals("score nul au depart",s,0);
	}

	// test creation
	public void test_creation(){
		// preparation des donnees
		Vaisseau v = new Vaisseau(0,5);
		Monstre m = new Monstre(10,5);
		// constructeur teste
		JeuShoot j = new JeuShoot();

		// verifie retour Vaisseau(0,5)
		assertEquals("test Vaisseau", v.toString(), j.getJoueur().toString());
		// verifie retour Monstre(10,5)
		assertEquals("test Monstre", m.toString(), j.getEnnemi().toString());
		// verifie retour 0
		assertEquals("test score", 0, j.getScore());
		// verifie retour false
		assertEquals("test perdu", false, j.getPerdu());
	}

	// test gererCollision vrai
	public void test_gererCollisionTrue(){
		// preparation des donnees
		JeuShoot j = new JeuShoot();
		Vaisseau v = new Vaisseau(6,5);
		Monstre m = new Monstre(7,5);
		j.setEnnemi(m);
		j.setJoueur(v);
		v.tirer();
		v.evoluerTir();
		// constructeur teste
		j.gererCollision();

		// verifie retour Vaisseau(6,5)
		assertEquals("test Vaisseau", v.toString(), j.getJoueur().toString());
		// verifie retour Monstre(10,5)
		assertEquals("test Monstre", "Monstre(10,5)", j.getEnnemi().toString());
		// verifie retour Tir null
		assertEquals("test Tir", null, v.getTirCourant());
		// verifie retour 1
		assertEquals("test score", 1, j.getScore());
		// verifie retour false
		assertEquals("test perdu", false, j.getPerdu());

	}

	// test gererCollision faux
	public void test_gererCollisionFalse(){
		// preparation des donnees
		JeuShoot j = new JeuShoot();
		Vaisseau v = new Vaisseau(3,7);
		Monstre m = new Monstre(7,5);
		j.setEnnemi(m);
		j.setJoueur(v);
		v.tirer();
		v.evoluerTir();
		// constructeur teste
		j.gererCollision();

		// verifie retour Vaisseau(0,5)
		assertEquals("test Vaisseau", v.toString(), j.getJoueur().toString());
		// verifie retour Monstre(10,5)
		assertEquals("test Monstre", "Monstre(7,5)", j.getEnnemi().toString());
		// verifie retour T(4,7)
		assertEquals("test Tir", "T(4,7)", v.getTirCourant().toString());
		// verifie retour 0
		assertEquals("test score", 0, j.getScore());
		// verifie retour false
		assertEquals("test perdu", false, j.getPerdu());
	}

		// test evoluer tir null perdu faux collision faux
		public void test_evoluer_tirNull_perduFalse_CollisionFalse(){
			// preparation des donnees
			JeuShoot j = new JeuShoot();
			// constructeur teste
			j.evoluer(2);

			// verifie retour Vaisseau(0,6)
			assertEquals("test Vaisseau", "Vaisseau(0,6)", j.getJoueur().toString());
			// verifie retour null
			assertEquals("test Tir", null, j.getJoueur().getTirCourant());
			// verifie retour 0
			assertEquals("test score", 0, j.getScore());
			// verifie retour Monstre(10,4)
			assertEquals("test Monstre", "Monstre(10,4)", j.getEnnemi().toString());
			// verifie retour false
			assertEquals("test perdu", false, j.getPerdu());
	}

	// test evoluer tir non null perdu faux collision faux
	public void test_evoluer_tirNonNull_perduFalse_CollisionFalse(){
		// preparation des donnees
		JeuShoot j = new JeuShoot();
		// constructeur teste
		j.evoluer(5);

		// verifie retour Vaisseau(0,5)-T(1,5)
		assertEquals("test Vaisseau", "Vaisseau(0,5)-T(1,5)", j.getJoueur().toString());
		// verifie retour null
		assertEquals("test Tir", "T(1,5)", j.getJoueur().getTirCourant().toString());
		// verifie retour 0
		assertEquals("test score", 0, j.getScore());
		// verifie retour Monstre(10,4)
		assertEquals("test Monstre", "Monstre(10,4)", j.getEnnemi().toString());
		// verifie retour false
		assertEquals("test perdu", false, j.getPerdu());
}

	// test evoluer perdu vrai collision faux
	public void test_evoluer_tirNull_perduTrue_CollisionFalse(){
		// preparation des donnees
		Monstre m = new Monstre(1,0);
		JeuShoot j = new JeuShoot();
		j.setEnnemi(m);
		// constructeur teste
		j.evoluer(2);

		// verifie retour Vaisseau(0,6)
		assertEquals("test Vaisseau", "Vaisseau(0,6)", j.getJoueur().toString());
		// verifie retour null
		assertEquals("test Tir", null, j.getJoueur().getTirCourant());
		// verifie retour 0
		assertEquals("test score", 0, j.getScore());
		// verifie retour Monstre(0,0)
		assertEquals("test Monstre", "Monstre(0,0)", j.getEnnemi().toString());
		// verifie retour true
		assertEquals("test perdu", true, j.getPerdu());
	}

	// test evoluer perdu faux collision vrai
	public void test_evoluer_tirNull_perduFalse_CollisionTrue(){
		// preparation des donnees
		Monstre m = new Monstre(1,6);
		JeuShoot j = new JeuShoot();
		j.setEnnemi(m);
		// constructeur teste
		j.evoluer(5);

		// verifie retour Vaisseau(0,5)
		assertEquals("test Vaisseau", "Vaisseau(0,5)", j.getJoueur().toString());
		// verifie retour null
		assertEquals("test Tir", null, j.getJoueur().getTirCourant());
		// verifie retour 1
		assertEquals("test score", 1, j.getScore());
		// verifie retour Monstre(10,5)
		assertEquals("test Monstre", "Monstre(10,5)", j.getEnnemi().toString());
		// verifie retour false
		assertEquals("test perdu", false, j.getPerdu());
	}


	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestJeuShoot(), args);
	}

}
