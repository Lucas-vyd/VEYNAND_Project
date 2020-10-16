package moteurJeu;

import application.JeuShoot;

public class MoteurShoot {

	public MoteurShoot(JeuShoot j) throws InterruptedException
	{
		DessinJeuShoot dj=new DessinJeuShoot(j);
		JeuMoteurShoot mj=new JeuMoteurShoot(j);
		MoteurGraphique mg=new MoteurGraphique(mj, dj);
		mg.lancerJeu(400, 400);
	}
	
}
