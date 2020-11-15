
public class Aventurier extends Entite{


	private boolean epee=false;

	/**
	 *
	 * @param terrain : labytrinthe en parametre
	 * placement de l aventurier sur le terrain
	 * un pseudo lui est donne
	 */	


	public Aventurier(Labyrinthe terrain){
		super(terrain);
		super.setPosX(4);
		super.setPosY(4);
		super.setNom("Hero");
		super.setVie(5);
	}


	/**
	 * @param j : Jeu mis en parametre afin de transmettre l'attaque
	 */


	public void attaquer(Jeu j) {

		if(getX()!=9) {
			if(j.terrain.isTaken(getX()+1, getY())) {
				int i=0;
				while(i<j.tabMonstre.length) {
					if(((j.tabMonstre[i].getX()-1)==j.perso.getX())&&((j.tabMonstre[i].getY())==j.perso.getY())) {
						j.tabMonstre[i].setVie(j.tabMonstre[i].getVie()-super.getAttaque());
						j.tabMonstre[i].etreEnVie();
					}
					i++;
				}
			}
		}
		if(getX()!=0) {
			if(j.terrain.isTaken(getX()-1, getY())) {
				int i=0;
				while(i<j.tabMonstre.length) {
					if(((j.tabMonstre[i].getX()+1)==j.perso.getX())&&((j.tabMonstre[i].getY())==j.perso.getY())) {
						j.tabMonstre[i].setVie(j.tabMonstre[i].getVie()-super.getAttaque());
						j.tabMonstre[i].etreEnVie();
					}
					i++;
				}
			}
		}
		if(getY()!=9) {
			if(j.terrain.isTaken(getX(), getY()+1)) {
				int i=0;
				while(i<j.tabMonstre.length) {
					if(((j.tabMonstre[i].getX())==j.perso.getX())&&((j.tabMonstre[i].getY()-1)==j.perso.getY())) {
						j.tabMonstre[i].setVie(j.tabMonstre[i].getVie()-super.getAttaque());
						j.tabMonstre[i].etreEnVie();
					}
					i++;
				}
			}
		}
		if(getY()!=0) {
			if(j.terrain.isTaken(getX(), getY()-1)) {
				int i=0;
				while(i<j.tabMonstre.length) {
					if(((j.tabMonstre[i].getX())==j.perso.getX())&&((j.tabMonstre[i].getY()+1)==j.perso.getY())) {
						j.tabMonstre[i].setVie(j.tabMonstre[i].getVie()-super.getAttaque());
						j.tabMonstre[i].etreEnVie();
					}
					i++;
				}
			}
		}
	}


	/**
	 * 
	 * @return boolean epee qui permet de verifier si l aventurier a une epee ou non
	 */


	public boolean getEpee() {
		return this.epee;
	}


	/**
	 * methode permettant de modifier la possesion ou non d une epee
	 * @param bool
	 */


	public void setEpee(boolean bool) {
		this.epee = bool;
	}

}
