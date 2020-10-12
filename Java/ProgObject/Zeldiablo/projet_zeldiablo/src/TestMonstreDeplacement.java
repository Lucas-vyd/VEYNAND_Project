import static org.junit.Assert.*;

import org.junit.Test;

public class TestMonstreDeplacement {


	/**
	 * Test verifiant si le monstre se deplace bien
	 */
	@Test
	public void testMonstreDeplacementAlea() {
		Jeu j = new Jeu();
		Labyrinthe l= new Labyrinthe();
		MonstreDeplacementAleat m = new MonstreDeplacementAleat(l);
		int x=4;
		int y=8;
		boolean deplace=false;

		//on met la position à 4 8 car il n'y a aucun mur autour donc le monstre se 
		//deplacera forcement dans une direction aléatoire

		m.setPosX(4);
		m.setPosY(8);
		((MonstreDeplacementAleat) m).deplacement(l);
		if(( (x!=m.getX()) && (y==m.getY() ) || ( (x==m.getX()) && (y!=m.getY())) )){
			deplace=true;
		}
		assertEquals("le monstre ne s'est pas deplacer correctement",deplace,true);
	}
	
	/**
	 * test l'attaque d'un monstre sur un aventurier vers la droite
	 */
	@Test
	public void testAttaqueMonstreDroite() {
		Jeu j = new Jeu();
		Labyrinthe l= new Labyrinthe();
		int x=j.tabMonstre[2].getX()+1;
		int y=j.tabMonstre[2].getY();
		j.perso.setPosX(x);
		j.perso.setPosY(y);
		j.terrain.lab[x][y].setTaken(true);
		j.tabMonstre[2].attaquer(j);
		assertEquals("le joueur devrait avoir 4 de vie",j.perso.getVie(),4);
	}


	/**
	 * test l'attaque d'un monstre sur un aventurier vers la gauche
	 */
	@Test
	public void testAttaqueMonstreGauche() {
		Jeu j = new Jeu();
		Labyrinthe l= new Labyrinthe();
		int x=j.tabMonstre[2].getX()-1;
		int y=j.tabMonstre[2].getY();
		j.perso.setPosX(x);
		j.perso.setPosY(y);
		j.terrain.lab[x][y].setTaken(true);
		j.tabMonstre[2].attaquer(j);
		assertEquals("le joueur devrait avoir 4 de vie",j.perso.getVie(),4);
	}

	/**
	 * test l'attaque d'un monstre sur un aventurier vers le haut
	 */
	@Test
	public void testAttaqueMonstreHaut() {
		Jeu j = new Jeu();
		Labyrinthe l= new Labyrinthe();
		int x=j.tabMonstre[2].getX();
		int y=j.tabMonstre[2].getY()-1;
		j.perso.setPosX(x);
		j.perso.setPosY(y);
		j.terrain.lab[x][y].setTaken(true);
		j.tabMonstre[2].attaquer(j);
		assertEquals("le joueur devrait avoir 4 de vie",j.perso.getVie(),4);
	}

	/**
	 * test l'attaque d'un monstre sur un aventurier vers le bas
	 */
	@Test
	public void testAttaqueMonstreBas() {
		Jeu j = new Jeu();
		Labyrinthe l= new Labyrinthe();
		int x=j.tabMonstre[2].getX();
		int y=j.tabMonstre[2].getY()+1;
		j.perso.setPosX(x);
		j.perso.setPosY(y);
		j.terrain.lab[x][y].setTaken(true);
		j.tabMonstre[2].attaquer(j);
		assertEquals("le joueur devrait avoir 4 de vie",j.perso.getVie(),4);
	}
}
