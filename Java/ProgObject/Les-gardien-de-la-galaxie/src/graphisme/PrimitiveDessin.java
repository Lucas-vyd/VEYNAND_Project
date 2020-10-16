package graphisme;

import java.awt.*;

import application.*;

/**
 * classe qui contient les primitives de dessin
 * 
 * @author vthomas
 * 
 */
public class PrimitiveDessin {

	/**
	 * la taille des cases
	 */
	public static int TAILLE = 24;

	/**
	 * le crayon avec lequel dessiner
	 */
	Graphics g;

	/**
	 * attribut pour decaler en X
	 */
	int decalX;

	/**
	 * construction d'une primitive
	 * 
	 * @param grap
	 *            crayon ou dessiner
	 * @param decal
	 *            decalage en X
	 */
	public PrimitiveDessin(Graphics grap, int decal) {
		this.g = grap;
		this.decalX = decal;
	}

	/**
	 * permet de dessiner le score
	 * 
	 * @param j
	 *            jeu correspondant
	 * @param decal
	 *            decalage a donner
	 */
	public void dessinerScore(JeuShoot j) {
		g.setColor(Color.RED);
		String message = "score :" + j.getScore();
		g.drawString(message, decalX, 20);
	}

	/**
	 * dessine un cadre vide
	 * 
	 * @param decal
	 *            decalage a donner
	 */
	public void dessinerCadre() {
		g.drawRect(decalX, 0, TAILLE * 11, TAILLE * 11);
	}

	/**
	 * permet de dessiner un monstre
	 * 
	 * @param j
	 *            jeu contenant le monstre
	 */
	public void dessinerMonstre(JeuShoot j) {
		Monstre m = j.getEnnemi();
		int x = m.getX();
		int y = m.getY();
		if (m.getEtreMort())
			g.setColor(Color.RED);
		else
			g.setColor(Color.BLUE);
		g.drawImage(Sprite.getAlien(), x * TAILLE+decalX, y * TAILLE, TAILLE, TAILLE, null);
	}

	/**
	 * permet de dessiner un vaisseau
	 * 
	 * @param j
	 *            jeu contenant le vaisseau
	 */
	public void dessinerVaisseau(JeuShoot j) {
		Vaisseau v = j.getJoueur();
		int x = v.getX();
		int y = v.getY();
		g.drawImage(Sprite.getVaisseau(), x * TAILLE+decalX, y * TAILLE, TAILLE, TAILLE, null);

		Tir t = v.getTirCourant();
		if (t != null) {
			x = t.getX();
			y = t.getY();
			g.drawImage(Sprite.getTir(), x * TAILLE+decalX, y * TAILLE, TAILLE, TAILLE, null);
		}

	}

	public void effacer() {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, TAILLE*14, TAILLE * 14);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, decalX, TAILLE * 11);
		g.fillRect(TAILLE * 11 + decalX, 0, decalX, TAILLE * 11);
		
	}
}
