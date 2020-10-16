package moteurJeu;
import application.JeuShoot;
import moteurJeu.MoteurShoot;

public class Principale {

	/**
	 * lance le jeu avec un moteur graphique
	 * <ul>
	 * <li>touches pour guider ==> QZSD
	 * <li>pour tirer ==> espace
	 * </ul>
	 * 
	 * @param args
	 *            inutile
	 * @throws InterruptedException
	 *             si pas de temps
	 */
	public static void main(String[] args) throws InterruptedException {
		JeuShoot js = new JeuShoot();
		new MoteurShoot(js);
	}

}
