package Puissance4;

import java.io.Serializable;

public class Jeton implements Serializable{
	
	/**
	 * attribut de la classe Jeton
	 * un entier nombre
	 */
	int nbr;
	
	/**
	 * constructeur d'un jeton qui initialise
	 * le nombre avec le nombre en parametre
	 * @param nbr
	 */
	public Jeton(int nbr) {
		this.nbr=nbr;
	}
	
	/**
	 * methode qui renvoie le nombre sous forme d'un String
	 * @return String
	 */
	public String toString(){
		String n = String.valueOf(this.nbr);
		return n;	
	}
	
	/**
	 * methode get du nombre
	 * @return int
	 */
	public int getNbr() {
		return nbr;
	}
}
