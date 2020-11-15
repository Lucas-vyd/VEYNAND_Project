
public abstract class Entite {


	/**
	 * attributs de la classe abstraite Entite
	 * Position en x
	 * Position en y
	 * entier d attaque
	 * entier point de vie
	 * Nom de lentite
	 * boolean determiannt si la dite entite est en vie ou non
	 */


	private int posX= (int)Math.round(Math.random()*9);
	private int posY= (int)Math.round(Math.random()*9);
	private int attaque=1;
	private int vie=2;
	private String nom;
	private boolean enVie=true;




	/**
	 *
	 * @param terrain : labyrinthe
	 * l entite est placee sur le labyrinthe
	 */


	public Entite(Labyrinthe terrain) {
		while (!(terrain.isEmpty(posX, posY)&&(!terrain.isTaken(posX, posY)&&(!((posX==5)&&(posY==4)))))) {
			posX = (int)Math.round(Math.random()*9);
			posY= (int)Math.round(Math.random()*9);
		}
		terrain.getCase(posX,posY).setTaken(true);
	}


	/**
	 *
	 * @param terrain
	 * deplacement dune entite sur le terrain
	 */
	public void deplacement(Labyrinthe terrain) {

	}


	/**
	 *
	 * @return la postion de l entite en x
	 */


	public int getX() {
		return this.posX;

	}


	/**
	 *
	 * @return la position de l entite en y
	 */


	public int getY() {
		return this.posY;

	}


	/**
	 * modifie la position de l entite en x
	 * @param posX
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}


	/**
	 * modifie la posiiton de l entite en y
	 * @param posY
	 */


	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * methode qui passe l entite a l etat de mort si ses pv sont en dessous ou egal a 0
	 */
	public void etreEnVie() {
		if(vie<=0) {
			enVie=false;
		}
	}


	/**
	 * @return si l etat de l entite (mort ou vivant)
	 */


	public boolean getEnVie() {
		return enVie;
	}

	/**
	 * @return l attaque
	 */


	public int getAttaque() {
		return attaque;
	}


	/**
	 * @param att
	 * modifier la puissance de l'attaque
	 */


	public void setAttaque(int att) {
		this.attaque = att;
	}


	/**
	 * @return la vie
	 */


	public int getVie() {
		return vie;
	}


	/**
	 * @param vie
	 * modifier la vie de l entite
	 */


	public void setVie(int vie) {
		this.vie = vie;
		etreEnVie();
	}


	/**
	 * @return le nom de l entite
	 */


	public String getNom() {
		return nom;
	}


	/**
	 * @param nom
	 * permet de modifier le nom
	 */


	public void setNom(String nom) {
		this.nom = nom;
	}




	/**
	 * methode permettant a l entite d attaquer
	 * @param j : Jeu sur lequel l attaque est lancee
	 */
	public void attaquer(Jeu j) {

	}




	public boolean aCoter(Jeu j) {
		return false;
	}


}
