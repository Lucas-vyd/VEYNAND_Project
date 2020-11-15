
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAventurier {

	/**
	 * Deplacement de l'aventurier à droite sans collision
	 */

	@Test
	public void test_AventurierDeplacementDroite() {
		Jeu j = new Jeu();
		j.terrain.lab[j.tabMonstre[0].getX()][j.tabMonstre[0].getY()].setTaken(false);
		j.terrain.lab[j.tabMonstre[1].getX()][j.tabMonstre[1].getY()].setTaken(false);
		j.terrain.lab[j.tabMonstre[2].getX()][j.tabMonstre[2].getY()].setTaken(false);
		j.terrain.lab[j.tabMonstre[3].getX()][j.tabMonstre[3].getY()].setTaken(false);
		j.deplacement("z");
		j.deplacement("d");
		assertEquals("Probleme de deplacement",j.perso.getX(),5);		
	}

	/**
	 * Deplacement de l'aventurier à gauche sans collision
	 */

	@Test
	public void test_AventurierDeplacementGauche() {
		Jeu j = new Jeu();
		j.terrain.lab[j.tabMonstre[0].getX()][j.tabMonstre[0].getY()].setTaken(false);
		j.terrain.lab[j.tabMonstre[1].getX()][j.tabMonstre[1].getY()].setTaken(false);
		j.terrain.lab[j.tabMonstre[2].getX()][j.tabMonstre[2].getY()].setTaken(false);
		j.terrain.lab[j.tabMonstre[3].getX()][j.tabMonstre[3].getY()].setTaken(false);
		j.deplacement("z");//pour passer au dessus du mur
		j.deplacement("q");
		assertEquals("Probleme de deplacement",j.perso.getX(),4);	
	}

	/**
	 * Deplacement de l'aventurier en haut sans collision
	 */

	@Test
	public void test_AventurierDeplacementHaut() {
		Jeu j = new Jeu();
		j.terrain.lab[j.tabMonstre[0].getX()][j.tabMonstre[0].getY()].setTaken(false);
		j.terrain.lab[j.tabMonstre[1].getX()][j.tabMonstre[1].getY()].setTaken(false);
		j.terrain.lab[j.tabMonstre[2].getX()][j.tabMonstre[2].getY()].setTaken(false);
		j.terrain.lab[j.tabMonstre[3].getX()][j.tabMonstre[3].getY()].setTaken(false);
		j.deplacement("z");
		assertEquals("Probleme de deplacement",j.perso.getY(),3);
	}

	/**
	 * Deplacement de l'aventurier en bas sans collision
	 */

	@Test
	public void test_AventurierDeplacementBas() {
		Jeu j = new Jeu();
		j.terrain.lab[j.tabMonstre[0].getX()][j.tabMonstre[0].getY()].setTaken(false);
		j.terrain.lab[j.tabMonstre[1].getX()][j.tabMonstre[1].getY()].setTaken(false);
		j.terrain.lab[j.tabMonstre[2].getX()][j.tabMonstre[2].getY()].setTaken(false);
		j.terrain.lab[j.tabMonstre[3].getX()][j.tabMonstre[3].getY()].setTaken(false);
		j.deplacement("d");//on se deplace à droite pour passer a coté du mur
		j.deplacement("s");
		assertEquals("Probleme de deplacement",j.perso.getY(),5);	
	}

	/**
	 * Deplacement de l'aventurier à droite avec collision
	 */

	@Test
	public void test_AventurierDeplacementDroiteCollision() {
		Jeu j = new Jeu();
		j.deplacement("d");
		assertEquals("Collision mal gérer à droite",j.perso.getX(),4);	
	}


	/**
	 * Deplacement de l'aventurier à gauche avec collision
	 */

	@Test
	public void test_AventurierDeplacementGaucheCollision() {
		Jeu j = new Jeu();
		j.deplacement("q");
		assertEquals("Collision mal gérer à gauche",j.perso.getX(),4);	
	}

	/**
	 * Deplacement de l'aventurier en bas avec collision
	 */

	@Test
	public void test_AventurierDeplacementBasCollision() {
		Jeu j = new Jeu();
		j.perso.setPosY(8);
		j.deplacement("s");
		assertEquals("Collision mal gérer vers le bas",j.perso.getY(),8);
	}

	/**
	 * Deplacement de l'aventurier en haut avec collision
	 */

	@Test
	public void test_AventurierDeplacementHautCollision() {
		Jeu j = new Jeu();
		j.perso.setPosY(3);
		j.deplacement("z");
		assertEquals("Collision mal gérer vers le haut",j.perso.getY(),3);	
	}


	/**
	 * test l'attaque d'un aventurier sur un monstre vers la droite
	 */
	@Test
	public void testAttaqueAventurierDroite() {
		Jeu j = new Jeu();
		if(j.tabMonstre[0].getX()==9) {
			j.tabMonstre[0].setPosX(j.tabMonstre[0].getX()-1);
		}else if(j.tabMonstre[0].getX()==0) {
			j.tabMonstre[0].setPosX(j.tabMonstre[0].getX()+1);
		}
		j.terrain.lab[j.tabMonstre[0].getX()][j.tabMonstre[0].getY()].setTaken(true);
		int x=j.tabMonstre[0].getX()-1;
		int y=j.tabMonstre[0].getY();
		j.perso.setPosX(x);
		j.perso.setPosY(y);
		j.perso.attaquer(j);
		assertEquals("le monstre devrait avoir 1 de vie",j.tabMonstre[0].getVie(),1);
	}

	/**
	 * test l'attaque d'un aventurier sur un monstre vers la gauche
	 */
	@Test
	public void testAttaqueAventurierGauche() {
		Jeu j = new Jeu();
		if(j.tabMonstre[0].getX()==0) {
			j.tabMonstre[0].setPosX(j.tabMonstre[0].getX()+1);
		}else if(j.tabMonstre[0].getX()==9) {
			j.tabMonstre[0].setPosX(j.tabMonstre[0].getX()-1);
		}
		j.terrain.lab[j.tabMonstre[0].getX()][j.tabMonstre[0].getY()].setTaken(true);
		int x=j.tabMonstre[0].getX()+1;
		int y=j.tabMonstre[0].getY();
		j.perso.setPosX(x);
		j.perso.setPosY(y);
		j.perso.attaquer(j);
		assertEquals("le monstre devrait avoir 1 de vie",j.tabMonstre[0].getVie(),1);
	}


	/**
	 * test l'attaque d'un aventurier sur un monstre vers le haut
	 */
	@Test
	public void testAttaqueAventurierHaut() {
		Jeu j = new Jeu();
		if(j.tabMonstre[0].getY()==0) {
			j.tabMonstre[0].setPosY(j.tabMonstre[0].getY()+1);
		}else if(j.tabMonstre[0].getY()==9) {
			j.tabMonstre[0].setPosY(j.tabMonstre[0].getY()-1);
		}
		j.terrain.lab[j.tabMonstre[0].getX()][j.tabMonstre[0].getY()].setTaken(true);
		int x=j.tabMonstre[0].getX();
		int y=j.tabMonstre[0].getY()+1;
		j.perso.setPosX(x);
		j.perso.setPosY(y);
		j.perso.attaquer(j);
		assertEquals("le monstre devrait avoir 1 de vie",j.tabMonstre[0].getVie(),1);
	}


	/**
	 * test l'attaque d'un aventurier sur un monstre vers le bas
	 */
	@Test
	public void testAttaqueAventurierBas() {
		Jeu j = new Jeu();
		if(j.tabMonstre[0].getY()==9) {
			j.tabMonstre[0].setPosY(j.tabMonstre[0].getY()-1);
		}else if(j.tabMonstre[0].getY()==0) {
			j.tabMonstre[0].setPosY(j.tabMonstre[0].getY()+1);
		}
		j.terrain.lab[j.tabMonstre[0].getX()][j.tabMonstre[0].getY()].setTaken(true);
		int x=j.tabMonstre[0].getX();
		int y=j.tabMonstre[0].getY()-1;
		j.perso.setPosX(x);
		j.perso.setPosY(y);
		j.perso.attaquer(j);
		assertEquals("le monstre devrait avoir 1 de vie",j.tabMonstre[0].getVie(),1);
	}
	
	
	/**
	 * test si la case special a bien été initialiser
	 */
	@Test
	public void testAventurierEpee() {
		Jeu g = new Jeu();
		boolean epee=false;
		for(int i=0;i<=9;i++) {
			for(int j=0;j<=9;j++) {
				if(g.terrain.lab[i][j].isSpecial()) {
					epee=true;
				}
			}
		}
		
		assertEquals("il n'y a pas de case special",epee,true);
	}
	
	/**
	 * test si la case special a bien été initialiser
	 */
	@Test
	public void testAventurierPotion() {
		Jeu g = new Jeu();
		boolean popo=false;
		for(int i=0;i<=9;i++) {
			for(int j=0;j<=9;j++) {
				if(g.terrain.lab[i][j].isPotion()) {
					popo=true;
				}
			}
		}
		
		assertEquals("il n'y a pas de potion",popo,true);
	}
}
