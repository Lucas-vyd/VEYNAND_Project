package Puissance4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Joueur extends Jeton implements Serializable{
	/**
	 * attribut de la classe Joueur
	 * un String représentant le nom du joueur
	 */
	private String nom;

	/**
	 * constructeur d'un joueur avec un super vers Jeton pour nbr
	 * et on initialise le nom
	 * @param nbr
	 * @param nom
	 */
	public Joueur(int nbr, String nom) {
		super(nbr);
		this.nom=nom;
	}

	
	/**
	 * methode qui return un string contenant le nom du joueur
	 * et le nombre du jeton du joueur
	 * @return String
	 */
	public String toString() {
		return "Joueur [nom=" + nom + "]"+"Nombre [nbr="+this.getNbr()+"]";
	}


	/**
	 * methode qui permet de sauvegarder le Joueur
	 * dans un fichier s'appelant p au format .bin
	 * @param p
	 */
	public void sauvegarder(String p) {
		ObjectOutputStream J4;
		try {
			J4 = new ObjectOutputStream(new FileOutputStream(p+".bin"));
			J4.writeObject(this);
			J4.close();
		} catch (IOException e) {
			System.out.println("|---PROBLEME rien à sauvegarder");
		}		
	}

	/**
	 * methode qui permet de restaurer un joueur contenue dans un
	 * fichier au format .bin avec un String p comme nom
	 * @param p
	 * @return	Joueur
	 */
	public static Joueur restaurer(String p){
		Joueur J4 = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(p+".bin"));
			J4=(Joueur)(ois.readObject());
			ois.close();
		}catch (IOException e) {
			System.out.println("|---PROBLEME fichier "+p+".bin inexistant");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return J4;	
	}


	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}




}
