package graphisme;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Sprite {

	/**
	 * stocke images (Singleton)
	 */
	private static BufferedImage alien;
	private static BufferedImage vaisseau;
	private static BufferedImage tir;

	/**
	 * demande l'image alien (Singleton). La creer si besoin
	 * 
	 * @return image alien
	 */
	public static BufferedImage getAlien() {
		if (alien == null) {
			int[][] sp = getDonneesAlien();
			alien = creerImage(sp, Color.RED);
		}
		return (alien);
	}

	/**
	 * demande l'image tir (Singleton). La creer si besoin
	 * 
	 * @return image tir
	 */
	public static BufferedImage getTir() {
		if (tir == null) {
			int[][] sp = getDonneesTir();
			tir = creerImage(sp, Color.BLACK);
		}
		return (tir);
	}

	/**
	 * demande l'image vaisseau (Singleton). La creer si besoin
	 * 
	 * @return image vaisseau
	 */
	public static BufferedImage getVaisseau() {
		if (vaisseau == null) {
			int[][] sp = getDonneesVaisseau();
			vaisseau = creerImage(sp, Color.BLUE);
		}
		return (vaisseau);
	}

	/**
	 * creer une image a partir d'un tableau d'int
	 * 
	 * @param sprite
	 *            le tab d'int decrivant l'image
	 * @return image affichant le tableau
	 */
	private static BufferedImage creerImage(int[][] sprite, Color r) {
		int Ximage = sprite[0].length * 2;
		int YImage = sprite.length;
		BufferedImage image = new BufferedImage(Ximage, YImage, BufferedImage.TYPE_3BYTE_BGR);
		for (int i = 0; i < YImage; i++) {
			for (int j = 0; j < sprite[0].length; j++) {
				if (sprite[i][j] == 1) {
					image.setRGB(i, j, r.getRGB());
					image.setRGB(i, YImage - j - 1, r.getRGB());
				} else {
					image.setRGB(i, j, Color.WHITE.getRGB());
					image.setRGB(i, YImage - j - 1, Color.WHITE.getRGB());
				}
			}
		}
		return image;
	}

	/**
	 * @return les donnees decrivant un alien
	 */
	private static int[][] getDonneesAlien() {
		int[] l1 = { 0, 0, 0, 1 };
		int[] l2 = { 0, 0, 1, 1 };
		int[] l3 = { 0, 1, 1, 1 };
		int[] l4 = { 1, 1, 0, 1 };
		int[] l5 = { 1, 1, 1, 1 };
		int[] l6 = { 0, 1, 0, 1 };
		int[] l7 = { 1, 0, 0, 0 };
		int[] l8 = { 0, 1, 0, 0 };

		int[][] sp = { l1, l2, l3, l4, l5, l6, l7, l8 };
		return sp;
	}

	/**
	 * @return les donnees decrivant un vaisseau
	 */
	private static int[][] getDonneesVaisseau() {
		int[] l1 = { 0, 0, 0, 1 };
		int[] l2 = { 0, 0, 1, 1 };
		int[] l3 = { 0, 1, 1, 1 };
		int[] l4 = { 0, 1, 1, 0 };
		int[] l5 = { 1, 1, 1, 1 };
		int[] l6 = { 1, 1, 0, 1 };
		int[] l7 = { 1, 0, 0, 0 };
		int[] l8 = { 1, 0, 0, 0 };

		int[][] sp = { l8, l7, l6, l5, l4, l3, l2, l1 };
		return sp;
	}

	/**
	 * @return donnees pour dessiner de tir
	 */
	private static int[][] getDonneesTir() {
		int[] l1 = { 0, 0, 0, 1 };
		int[] l2 = { 0, 0, 0, 1 };
		int[] l3 = { 0, 0, 0, 1 };
		int[] l4 = { 0, 0, 0, 1 };
		int[] l5 = { 0, 0, 0, 1 };
		int[] l6 = { 0, 0, 1, 0 };
		int[] l7 = { 0, 0, 0, 0 };
		int[] l8 = { 0, 0, 0, 0 };

		int[][] sp = { l8, l7, l6, l5, l4, l3, l2, l1 };
		return sp;
	}

}
