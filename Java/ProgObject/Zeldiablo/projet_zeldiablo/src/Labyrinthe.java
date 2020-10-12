

public class Labyrinthe {

	/*
	 * attribut lab : tableau de cases
	 */


	Case[][] lab= new Case[10][10];


	/*
	 * creer un labyrinthe en initiant les cases vides puis grace a placerMur placer les murs
	 */


	public Labyrinthe() {

		int[] murX= {2,3,4,5,7,3,1,3,5,6,7,3,1,2,5,6,7,8,2,3,5,7,3,7,0,0,0,0,0,0,0,9,9,9,9,9,9,9,0,1,5,6,7,8,9,0,1,2,3,4,5,9};
		int[] murY= {2,2,2,2,2,3,4,4,4,4,4,5,6,6,6,6,6,6,7,7,7,7,1,8,0,1,2,3,4,8,9,0,1,2,3,4,8,9,0,0,0,0,0,0,0,9,9,9,9,9,9,9};
		for (int i=0;i<10;i++) {
			for (int y=0;y<10;y++) {
				lab[i][y] = new Case(true);
			}
		}
		for (int i=0;i<murX.length;i++) {
			placerMur(murX[i],murY[i]);
		}

		int speX = (int)Math.round(Math.random()*9);
		int speY = (int)Math.round(Math.random()*9);
		while (!(lab[speX][speY].isEmpty())) {
			speX = (int)Math.round(Math.random()*9);
			speY = (int)Math.round(Math.random()*9);
		}
		lab[speX][speY].setSpecial(true);

		speX = (int)Math.round(Math.random()*9);
		speY = (int)Math.round(Math.random()*9);
		while (!(lab[speX][speY].isEmpty())) {
			speX = (int)Math.round(Math.random()*9);
			speY = (int)Math.round(Math.random()*9);
		}
		lab[speX][speY].setPotion(true);
	}


	/**
	 * @param x : entier x donne pour placer le mur a une telle abscisse
	 * @param y : entier y donne pour placer le mur a une telle ordonnee
	 * methode de placement de mur
	 */


	public void placerMur(int x,int y) {
		lab[x][y].setSol(false);
	}


	/**
	 * @return un boolean qui verifie depuis le labyrinthe si la case visee est vide ou non
	 * @param x : position x de la case
	 * @param y : position y de la case
	 */


	public boolean isEmpty(int x,int y) {
		return this.lab[x][y].isEmpty();
	}



	/**
	 * verifie si la case est special (si elle donne une epee ou non)
	 * @param x position en x de la case a verifie
	 * @param y position en y de la case a verifie
	 * @return boolean 
	 */


	public boolean isSpecial(int x, int y) {
		return this.lab[x][y].isSpecial();

	}


	/**
	 * verifie si la case donne une potion ou non
	 * @param x position en x de la case a verifie
	 * @param y position en y de la case a verifie
	 * @return boolean
	 */


	public boolean isPotion(int x, int y) {
		return this.lab[x][y].isPotion();

	}


	/**
	 * verifie si la case est prise (si il y a une entite dessus ou non)
	 * @param x position en x de la case a verifie
	 * @param y position en y de la case a verifie
	 * @return boolean
	 */


	public boolean isTaken(int x,int y) {
		return this.lab[x][y].isTaken();
	}


	/**
	 *
	 * @param x : entier x, abscisse de la case demandee
	 * @param y : entier y, ordonnee de la case demandee
	 * @return la case de coordonnees x y
	 */


	public Case getCase(int x, int y){
		return lab[x][y];
	}
}
