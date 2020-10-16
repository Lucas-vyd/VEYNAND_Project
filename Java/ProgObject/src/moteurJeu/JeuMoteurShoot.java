package moteurJeu;

import application.JeuShoot;

public class JeuMoteurShoot implements JeuMoteur {

	JeuShoot jeu;

	public JeuMoteurShoot(JeuShoot j) {
		this.jeu = j;
	}

	@Override
	public void evoluer(Commande commandeUser) {
		this.jeu.evoluer(getEntier(commandeUser));
	}

	private int getEntier(Commande commandeUser) {
		if (commandeUser.bas)
			return(2);
		if (commandeUser.haut)
			return(8);
		if (commandeUser.gauche)
			return(4);
		if (commandeUser.droite)
			return(6);
		if (commandeUser.espace)
			return(5);		
		//par defaut on fait rien
		return 0;
	}

	@Override
	public boolean etreFini() {
		return this.jeu.getPerdu();
	}

}
