public class MonstreDeplacementAleat extends Entite{


	/**
	 * Constructeur d un monstre a deplacement aleatoire
	 * @param terrain labyrinthe sur lequel est cree le monstre
	 */


	public MonstreDeplacementAleat(Labyrinthe terrain) {
		super(terrain);
		super.setNom("MDeplacement");
	}



	/**
	 * methode permettant au monstre de se deplacer
	 * @param terrain labyrinthe sur lequel s effectue le deplacement
	 */

	public void deplacement(Labyrinthe terrain) {
		if(super.getEnVie()) {
			int rand=(int)Math.round(Math.random()*3);
			if((rand==0)&&(getX()!=0)) {
				if((terrain.isEmpty(getX()-1, getY()))&&(!terrain.isTaken(getX()-1, getY()))) {
					terrain.lab[getX()][getY()].setTaken(false);
					setPosX(getX()-1);
					terrain.lab[getX()][getY()].setTaken(true);
				}
			}else if((rand==1)&&getX()!=9) {
				if((terrain.isEmpty(getX()+1, getY()))&&(!terrain.isTaken(getX()+1, getY()))) {
					terrain.lab[getX()][getY()].setTaken(false);
					setPosX(getX()+1);
					terrain.lab[getX()][getY()].setTaken(true);
				}

			}else if((rand==2)&&getY()!=0) {
				if((terrain.isEmpty(getX(), getY()-1))&&(!terrain.isTaken(getX(), getY()-1))) {
					terrain.lab[getX()][getY()].setTaken(false);
					setPosY(getY()-1);
					terrain.lab[getX()][getY()].setTaken(true);

				}

			}else if((rand==3)&&getY()!=9) {
				if((terrain.isEmpty(getX(), getY()+1))&&(!terrain.isTaken(getX(), getY()+1))) {
					terrain.lab[getX()][getY()].setTaken(false);
					setPosY(getY()+1);
					terrain.lab[getX()][getY()].setTaken(true);
				}

			}


		}
	}


	/**
	 * methode permettant au monstre d attaquer
	 * @param j jeu sur lequel l attaque est effectuee
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
		if(( (j.perso.getX()-1==getX()) && (j.perso.getY()==getY()) ) || ( (j.perso.getX()+1==getX()) && (j.perso.getY()==getY()) ) || ( (j.perso.getX()==getX()) && (j.perso.getY()-1==getY()) ) || ( (j.perso.getX()==getX()) && (j.perso.getY()+1==getY()) )) {
			cote=true;
		}
		return cote;
	}
}
