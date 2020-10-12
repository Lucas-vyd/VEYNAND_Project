import static org.junit.Assert.*;

import org.junit.Test;

public class TestMonstreImmo {


	/**
	 * Test d un monstre immobile bien place
	 */


	@Test
	public void testMonstreImoValide() {
		Jeu j = new Jeu();
		Labyrinthe l= new Labyrinthe();
		MonstreImmobile m = new MonstreImmobile(l);
		int x = m.getX();
		int y = m.getY();
		Case c =l.getCase(x, y);
		boolean test = c.isTaken();
		assertEquals("le monstre est bien place sur le terrain", test, true);
	}


	/**
	 * Test d un monstre immobile mal place
	 */


	@Test
	public void testMonstreImoNonValide() {
		Jeu j = new Jeu();
		Labyrinthe l= new Labyrinthe();
		MonstreImmobile m = new MonstreImmobile(l);
		Case c1 =l.getCase(1, 1);
		boolean test = c1.isTaken();
		assertEquals("le monstre est bien place sur le terrain", test, false);
	}

	/**
	 * test l'attaque d'un monstre sur un aventurier vers la droite
	 */
	@Test
	public void testAttaqueMonstreDroite() {
		Jeu j = new Jeu();
		Labyrinthe l= new Labyrinthe();
		int x=j.tabMonstre[0].getX()+1;
		int y=j.tabMonstre[0].getY();
		j.perso.setPosX(x);
		j.perso.setPosY(y);
		j.terrain.lab[x][y].setTaken(true);
		j.tabMonstre[0].attaquer(j);
		assertEquals("le joueur devrait avoir 4 de vie",j.perso.getVie(),4);
	}


	/**
	 * test l'attaque d'un monstre sur un aventurier vers la gauche
	 */
	@Test
	public void testAttaqueMonstreGauche() {
		Jeu j = new Jeu();
		Labyrinthe l= new Labyrinthe();
		int x=j.tabMonstre[0].getX()-1;
		int y=j.tabMonstre[0].getY();
		j.perso.setPosX(x);
		j.perso.setPosY(y);
		j.terrain.lab[x][y].setTaken(true);
		j.tabMonstre[0].attaquer(j);
		assertEquals("le joueur devrait avoir 4 de vie",j.perso.getVie(),4);
	}

	/**
	 * test l'attaque d'un monstre sur un aventurier vers le haut
	 */
	@Test
	public void testAttaqueMonstreHaut() {
		Jeu j = new Jeu();
		Labyrinthe l= new Labyrinthe();
		int x=j.tabMonstre[0].getX();
		int y=j.tabMonstre[0].getY()-1;
		j.perso.setPosX(x);
		j.perso.setPosY(y);
		j.terrain.lab[x][y].setTaken(true);
		j.tabMonstre[0].attaquer(j);
		assertEquals("le joueur devrait avoir 4 de vie",j.perso.getVie(),4);
	}

	/**
	 * test l'attaque d'un monstre sur un aventurier vers le bas
	 */
	@Test
	public void testAttaqueMonstreBas() {
		Jeu j = new Jeu();
		Labyrinthe l= new Labyrinthe();
		int x=j.tabMonstre[0].getX();
		int y=j.tabMonstre[0].getY()+1;
		j.perso.setPosX(x);
		j.perso.setPosY(y);
		j.terrain.lab[x][y].setTaken(true);
		j.tabMonstre[0].attaquer(j);
		assertEquals("le joueur devrait avoir 4 de vie",j.perso.getVie(),4);
	}
}
