package moteurJeu;

import graphisme.PrimitiveDessin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import application.JeuShoot;

public class DessinJeuShoot implements DessinJeu {

	JeuShoot j;

	public DessinJeuShoot(JeuShoot j2) {
		this.j = j2;
	}

	@Override
	public void dessiner(BufferedImage image) {
		int decal = 50;
		//si en jeu
		int taille = PrimitiveDessin.TAILLE;
		if (!this.j.getPerdu()) {
			// on dessine
			Graphics graphics = image.getGraphics();
			graphics.setColor(Color.BLACK);
			graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
			graphics.setColor(Color.WHITE);
			graphics.fillRect(decal, 0, 11 * taille, 11 * taille);
			PrimitiveDessin pDessin = new PrimitiveDessin(graphics, decal);
			pDessin.dessinerScore(j);
			pDessin.dessinerCadre();
			pDessin.dessinerVaisseau(j);
			pDessin.dessinerMonstre(j);
			graphics.dispose();
		} else {
			//fin de partie
			Graphics graphics = image.getGraphics();
			graphics.setColor(Color.BLACK);
			graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
			int t = taille;
			graphics.setColor(Color.RED);
			graphics.drawString("PERDU", decal + t * 5, t * 5);
		}
	}

}
