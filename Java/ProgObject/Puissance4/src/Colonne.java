package Puissance4;

import java.io.Serializable;
import java.util.ArrayList;

public class Colonne implements Serializable{
	/**
	 * attributs de la classe colonne
	 * une Arraylist de Jeton et un String nom
	 */
	private ArrayList<Jeton> tab;
	private String nom;
	
	
	/**
	 * Constructeur d'une colonne
	 * @param n
	 */
	public Colonne(String n) {
		this.nom=n;
		ArrayList<Jeton> Col;
		Col = new ArrayList<Jeton>();
		Col.add(new Jeton(0));
		tab=Col;
	}
	
	
	/**
	 * permet de connaitre le nombre d'element dans la colonne
	 * @return int
	 */
	public int getNbrElem() {
        int i =0;
        boolean dedans=true;
        while((tab.get(i).getNbr() != 0)&&(dedans)) {
            if(i+1==tab.size()) {
                dedans=false;
            }else {
                i++;
            }
        }
        if(!dedans) {
            i++;
        }
        return i;
    }
	
	/**
	 * getter du nom
	 * @return String
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * getter de l'arraylist
	 * @return ArrayList<Jeton>
	 */
	public ArrayList<Jeton> getTab() {
		return tab;
	}


	/**
	 * get l'element a la position i dans la liste
	 * @param i
	 * @return Jeton
	 */
	public Jeton getElem(int i) {
		return tab.get(i);
	}
} 
