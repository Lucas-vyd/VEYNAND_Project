import moteurJeu.MoteurGraphique;

/**
 * 
 * Classe permettant de lancer le jeu (contient le main)
 *
 */
public class MainZeldiablo {

	public static void main(String[]args) throws InterruptedException{

		JeuPerso jeu=new JeuPerso(4,5);
		DessinPerso dessin=new DessinPerso(jeu);

		MoteurGraphique moteur = new MoteurGraphique(jeu, dessin);

		moteur.lancerJeu(500, 500);
	}
}
