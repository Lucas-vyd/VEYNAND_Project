package graphisme;

import application.JeuShoot;

public class Principale {

	/**
	 * lance le jeu avec une interface graphique et des boutons
	 * 
	 * @param args
	 *            inutile
	 */
	public static void main(String[] args) {
		JeuShoot j = new JeuShoot();
		new GUI(j);
	}
}
