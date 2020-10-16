package graphisme;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import application.JeuShoot;

/**
 * un JPanel qui contient le rendu du jeu
 * utilise principalement les primitives d'affichage
 * 
 * @author vthomas
 * 
 */
public class Dessin extends JPanel {

	/**
	 * le jeu a afficher
	 */
	JeuShoot j;

	/**
	 * le decalage a l'ecran
	 */
	int decal = 0;

	/**
	 * constructeur qui utilise un jeu
	 * 
	 * @param jeu
	 *            jeu qu'on souhaite afficher
	 */
	public Dessin(JeuShoot jeu) {
		this.j = jeu;
		int t = PrimitiveDessin.TAILLE;
		this.setPreferredSize(new Dimension(t * 11, t * 11));
	}

	/**
	 * surcharge de la methode d'affichage
	 */
	public void paint(Graphics g) {
		super.paint(g);
		// on met a jour pour centrer la fenetre
		this.decal = (this.getWidth() - 11 * PrimitiveDessin.TAILLE) / 2;

		// on dessine
		PrimitiveDessin pDessin = new PrimitiveDessin(g,decal);
		pDessin.effacer();
		pDessin.dessinerVaisseau(j);
		pDessin.dessinerMonstre(j);
		pDessin.dessinerCadre();

	}

}
