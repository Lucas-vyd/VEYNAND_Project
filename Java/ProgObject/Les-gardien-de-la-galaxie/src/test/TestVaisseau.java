package test;

import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import application.*;

/**
 * test classe Vaisseau
 *
 * A COMPLETER
 */

public class TestVaisseau {

	/**
	 * test initial
	 * A NE PAS MODIFIER
	 */
	public void test_initial() {
		Vaisseau v = new Vaisseau();
		v = new Vaisseau(1, 2);
		v.evoluerTir();
		v.faireAction(0);
		Tir t = v.getTirCourant();
		v.getX();
		v.getY();
		v.tirer();
	}


	// test condition Vraie
	public void test_parametre_conditionVraie(){
		// constructeur teste
		Vaisseau v = new Vaisseau(3, 6);

		// verifie retour 3
		assertEquals("test X", 3, v.getX());
		// verifie retour 6
		assertEquals("test Y", 6, v.getY());
		// verifie retour null
		assertEquals("test tirCourant", null, v.getTirCourant());
	}

	// test condition Fausse
	public void test_parametre_conditionFausse() {
		// constructeur teste
		Vaisseau v = new Vaisseau(12, -2);

		// verifie retour 5 car sortie des conditions
		assertEquals("test X", 5, v.getX());
		// verifie retour 5 car sortie des conditions
		assertEquals("test Y", 5, v.getY());
		// verifie retour null
		assertEquals("test tirCourant", null, v.getTirCourant());
	}

	// test deplacer condition Vraie
	public void test_deplacer_conditionVraie(){
		// preparation des donnees
		Vaisseau v = new Vaisseau(4, 7);
		// methode testee
		v.faireAction(6);

		// verifie retour 5 car sortie des conditions
		assertEquals("test X", 5, v.getX());
		// verifie retour 5 car sortie des conditions
		assertEquals("test Y", 7, v.getY());
	}

	// test deplacer condition Fausse
	public void test_deplacer_conditionFausse(){
		// preparation des donnees
		Vaisseau v = new Vaisseau(10, 7);
		// methode testee
		v.faireAction(6);

		// verifie retour 5 car sortie des conditions
		assertEquals("test X", 10, v.getX());
		// verifie retour 5 car sortie des conditions
		assertEquals("test Y", 7, v.getY());
	}

	// test tirer
	public void test_tirer(){
		// preparation des donnees
		Tir t = new Tir(4,7);
		Vaisseau v = new Vaisseau(4, 7);
		// methode testee
		v.tirer();

		// verifie retour T(4,7)
		assertEquals("test tirer", t.toString(), v.getTirCourant().toString());
	}

	// test faire Action 0
	public void test_faireAction_0(){
		// preparation des donnees
		Vaisseau v = new Vaisseau(5, 5);
		// methode testee
		v.faireAction(0);

		// verifie retour 5
		assertEquals("test X", 5, v.getX());
		// verifie retour 5
		assertEquals("test Y", 5, v.getY());
	}

	// test faire Action 4
	public void test_faireAction_4(){
		// preparation des donnees
		Vaisseau v = new Vaisseau(5, 5);
		// methode testee
		v.faireAction(4);

		// verifie retour 4
		assertEquals("test X", 4, v.getX());
		// verifie retour 5
		assertEquals("test Y", 5, v.getY());
	}

	// test faire Action 6
	public void test_faireAction_6(){
		// preparation des donnees
		Vaisseau v = new Vaisseau(5, 5);
		// methode testee
		v.faireAction(6);

		// verifie retour 6
		assertEquals("test X", 6, v.getX());
		// verifie retour 5
		assertEquals("test Y", 5, v.getY());
	}

	// test faire Action 8
	public void test_faireAction_8(){
		// preparation des donnees
		Vaisseau v = new Vaisseau(5, 5);
		// methode testee
		v.faireAction(8);

		// verifie retour 5
		assertEquals("test X", 5, v.getX());
		// verifie retour 4
		assertEquals("test Y", 4, v.getY());
	}

	// test faire Action 2
	public void test_faireAction_2(){
		// preparation des donnees
		Vaisseau v = new Vaisseau(5, 5);
		// methode testee
		v.faireAction(2);

		// verifie retour 5
		assertEquals("test X", 5, v.getX());
		// verifie retour 6
		assertEquals("test Y", 6, v.getY());
	}

	// test faire Action 5
	public void test_faireAction_5(){
		// preparation des donnees
		Tir t = new Tir(5,5);
		Vaisseau v = new Vaisseau(5, 5);
		// methode testee
		v.faireAction(5);

		// verifie retour T(5,5)
		assertEquals("test faireAction_5", t.toString(), v.getTirCourant().toString());
	}

	// test detruire Tir
	public void test_detruireTir(){
		// preparation des donnees
		Vaisseau v = new Vaisseau(4, 7);
		v.tirer();
		// methode testee
		v.detruireTir();

		// verifie retour null
		assertEquals("test detruireTir", null, v.getTirCourant());
	}

	// test evoluer Tir
	public void test_evoluerTirFalse(){
		// preparation des donnees
		Tir t = new Tir(5,7);
		Vaisseau v = new Vaisseau(4, 7);
		v.tirer();
		// methode testee
		v.evoluerTir();

		// verifie retour T(5,7)
		assertEquals("test evoluer", t.toString(), v.getTirCourant().toString());
	}

	// test evoluer Tir
	public void test_evoluerTirTrue(){
		// preparation des donnees
		Vaisseau v = new Vaisseau(10, 7);
		v.tirer();
		// methode testee
		v.evoluerTir();

		// verifie retour T(5,7)
		assertEquals("test evoluer", null, v.getTirCourant());
	}

	// test toString tir Null
	public void test_toString_tirNull() {
		// preparation des donnees
		Vaisseau v = new Vaisseau(4, 7);
		Tir tirCourant = null;
		// methode testee
		String vaiss = v.toString();

		// verifie retour true car sortie de l arene
		assertEquals("il devrais retourner", "Vaisseau(4,7)", vaiss);
	}

	// test toString tir Non Null
	public void test_toString_tirNonNull() {
		// preparation des donnees
		Vaisseau v = new Vaisseau(4, 7);
		v.tirer();
		// methode testee
		String vaiss = v.toString();

		// verifie retour true car sortie de l arene
		assertEquals("il devrais retourner", "Vaisseau(4,7)-T(4,7)", vaiss);
	}


	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestVaisseau(), args);
	}

}
