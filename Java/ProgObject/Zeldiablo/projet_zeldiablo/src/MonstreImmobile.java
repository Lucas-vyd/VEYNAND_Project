public class MonstreImmobile extends Entite {


	/**
	 * @param terrain : labyrinthe en parametre qui place le monstre creer
	 * Constructeur d'un monstre immobile
	 */


	public MonstreImmobile(Labyrinthe terrain) {
		super(terrain);
		super.setNom("MImmo");
	}


	/**
	 * @param j : labyrinthe sur lequel se passe l attaque
	 * methode qui permet aux entites d attaquer
	 */


	public void attaquer(Jeu j) {
		if(getX()!=9) {
			if(j.terrain.isTaken(getX()+1, getY())) {
				if((j.perso.getX()-1==getX())&&(j.perso.getY()==getY())) {
					j.perso.setVie(j.perso.getVie()-1);
					j.perso.etreEnVie();
				}
			}
		}
		if(getX()!=0) {
			if(j.terrain.isTaken(getX()-1, getY())) {
				if((j.perso.getX()+1==getX())&&(j.perso.getY()==getY())) {
					j.perso.setVie(j.perso.getVie()-1);
					j.perso.etreEnVie();
				}
			}
		}
		if(getY()!=9) {
			if(j.terrain.isTaken(getX(), getY()+1)) {
				if((j.perso.getX()==getX())&&(j.perso.getY()-1==getY())) {
					j.perso.setVie(j.perso.getVie()-1);
					j.perso.etreEnVie();
				}
			}
		}
		if(getY()!=0) {
			if(j.terrain.isTaken(getX(), getY()-1)) {
				if((j.perso.getX()==getX())&&(j.perso.getY()+1==getY())) {
					j.perso.setVie(j.perso.getVie()-1);
					j.perso.etreEnVie();
				}
			}
		}
	}


	/**
	 * @param j labyrinthe analise pour savoir si deux entites se croisent et faire en sorte qu ils ne se passent pas au travers
	 */


	public boolean aCoter(Jeu j) {
		boolean cote=false;
		if(((j.perso.getX()-1==getX())&&(j.perso.getY()==getY()))||((j.perso.getX()+1==getX())&&(j.perso.getY()==getY()))||(((j.perso.getX()-1==getX())&&(j.perso.getY()-1==getY())))||(((j.perso.getX()-1==getX())&&(j.perso.getY()+1==getY())))) {
			cote=true;
		}
		return cote;
	}

}