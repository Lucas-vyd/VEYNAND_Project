
public class Case {


	/**
	 * Attributs de la classe Case
	 * un boolean determiannt si la case est un sol ou un mur
	 * un boolean determinant si la case est deja prise ou non
	 */


	private boolean sol;
	private boolean placePrise;
	private boolean special=false;
	private boolean potion = false;

	public boolean isSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
	}

	public boolean isPotion() {
		return potion;
	}

	public void setPotion(boolean special) {
		this.potion = special;
	}
	/**
	 * Contructeur de la classe Case
	 * @param x : entier determinant l abscisse de la case
	 * @param y : entoer determinant l ordonnee de la case
	 * @param vide : boolean initiant la case a l etat de sol ou de mur
	 * La case cree n est pas prise pas une entite a l initiation
	 */
	public Case(boolean vide) {
		this.sol = vide;
		this.placePrise = false;
	}


	/**
	 * Methode verifiant si la case est un sol ou non
	 * @return un boolean
	 * true si la case est un sol
	 * false si la case est un mur
	 */


	public boolean isEmpty() {
		return this.sol;
	}


	/**
	 * Methode verifiant si la case est deja prise ou non
	 * @return un boolean
	 * true si la case est prise
	 * false si la case n est pas prise
	 */


	public boolean isTaken() {
		return this.placePrise;
	}


	/**
	 * Methode permettant de modifier l etat du sol (mur ou sol)
	 * @param vide true si sol, false si mur
	 */


	public void setSol(boolean vide) {
		this.sol = vide;
	}


	/**
	 * Methode permettant de modifier l etat de la place (prise ou non)
	 * @param vide true si prise, false si non prise
	 */


	public void setTaken(boolean vide) {
		this.placePrise = vide;
	}
}
