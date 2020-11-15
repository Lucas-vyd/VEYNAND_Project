
public class Jeu {


	/**
	 * attributs de la classe Jeu
	 * Tableau de commande de deplacement 
	 * Labyrynthe 
	 * Le personnage 
	 * Tableau de monstre
	 */

	private String[] tabDepAleat= {"z","q","s","d"};
	Labyrinthe terrain;
	Aventurier perso;
	Entite[] tabMonstre=new Entite[4];


	/**
	 * Constructeur du Jeu
	 * creer deux monstres immobiles
	 * deux monstres aux deplacements aleatoires
	 * un terrain
	 * un personnage
	 */


	public Jeu() {

		terrain = new Labyrinthe();
		perso=new Aventurier(terrain);
		terrain.lab[perso.getX()][perso.getY()].setTaken(true);
		tabMonstre[0]=new MonstreImmobile(terrain);
		tabMonstre[1]=new MonstreImmobile(terrain);
		tabMonstre[2]=new MonstreDeplacementAleat(terrain);
		tabMonstre[3]=new MonstreDeplacementAleat(terrain);
	}


	/**
	 * methode permettant de deplacer le personnage
	 * @param direction : String correspondant aux touches de deplacement choisies par le joueur
	 */


	public void deplacement(String direction) {

		/**
		 * On verifie le deplacement a gauche
		 */

		if(direction.equals("q")&&(perso.getX()!=0)&&(terrain.isEmpty(perso.getX()-1, perso.getY()))&&(!terrain.isTaken(perso.getX()-1, perso.getY()))) {
			terrain.lab[perso.getX()][perso.getY()].setTaken(false);
			((Aventurier) perso).setPosX(perso.getX()-1);
			terrain.lab[perso.getX()][perso.getY()].setTaken(true);

			/**
			 * On verifie le deplacement a droite
			 */

		}else if(direction.equals("d")&&(perso.getX()!=9)&&(terrain.isEmpty(perso.getX()+1, perso.getY()))&&(!terrain.isTaken(perso.getX()+1, perso.getY()))) {
			terrain.lab[perso.getX()][perso.getY()].setTaken(false);
			((Aventurier) perso).setPosX(perso.getX()+1);
			terrain.lab[perso.getX()][perso.getY()].setTaken(true);

			/**
			 * On verifie le deplacement vers le haut
			 */

		}else if(direction.equals("z")&&(perso.getY()!=0)&&(terrain.isEmpty(perso.getX(), perso.getY()-1))&&(!terrain.isTaken(perso.getX(), perso.getY()-1))) {
			terrain.lab[perso.getX()][perso.getY()].setTaken(false);
			((Aventurier) perso).setPosY(perso.getY()-1);
			terrain.lab[perso.getX()][perso.getY()].setTaken(true);

			/**
			 * On verifie le deplacement vers le bas
			 */

		}else if(direction.equals("s")&&(perso.getY()!=9)&&(terrain.isEmpty(perso.getX(), perso.getY()+1))&&(!terrain.isTaken(perso.getX(), perso.getY()+1))) {
			terrain.lab[perso.getX()][perso.getY()].setTaken(false);
			((Aventurier) perso).setPosY(perso.getY()+1);
			terrain.lab[perso.getX()][perso.getY()].setTaken(true);
		}
	}



}
