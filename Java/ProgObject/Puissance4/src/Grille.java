package Puissance4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Grille  implements Serializable{
	/**
	 * attribut de la clase Grille
	 * un int l representant la largeur de la grille
	 * un tableau de colonne Gri
	 * et un entier static tour pour gerer le tour du jour qui joue
	 */
	private int l;
	Colonne Gri[];
	static int tour=1;
	
	/**
	 * le constructeur de la classe Grille qui
	 * créer une grille d'une largeur demander par l'utilisateur
	 */
	public Grille() {
		int lar;
		boolean oui=false;		
		while(!oui) {
			try{
				Scanner sc = new Scanner(System.in);
				System.out.println("Nombre de colonne : ");
				lar=sc.nextInt();
				this.l=lar;
				this.Gri = new Colonne[l];
				Colonne a = new Colonne("");
				for(int i=0;i<lar;i++) {
					this.Gri[i]=a;
				}
				oui=true;
			}catch(InputMismatchException e) {
				System.out.println("|---PROBLEME ce n'est pas un entier qui a été entrée");
			}
		}
		
			
	}
	
	/**
	 * methode toString permettant de creer l'affichage du tableau
	 * representant la grille avec les jeton en plus des colonnes
	 * tries par remplissages et du remplissage moyen
	 * @return String
	 */
	public String toString() {
		String res="Jeu Puissance4 de |"+l+"| colonnes\n";
		for (int p=0;p<l;p++) {
			res+="'"+p;
		}
		res+="'\n";
		for (int p=0;p<l;p++) {
			res+="+-";
		}
		res+="+\n";
		for (int j=this.getNbrMax(); j>0; j--) {
			res+="|";
			for (int i=0;i<l;i++) {

				if(this.retCol(i).getElem((j-1)).getNbr()==0) {
					res+= " |" ;
				}else {
					res+= this.retCol(i).getElem((j-1)) + "|" ;
				}
				
			}
			res+="\n";
			for (int p=0;p<l;p++) {
				res+="+-";
			}
			res+="+\n";
		}
		for (int p=0;p<l;p++) {
			res+="'"+p;
		}
		res+="'\n";
		res+="N° colonnes triées par remplissage: "+ this.TrieRemp() +"\n";
		res+="Remplissage moyen: " +this.RemplissageMoy() +"\n";
		return res;
		
	}
	
	/**
	 * permet de savoir quel est le nombre max de jeton dans les colonnes
	 * @return int
	 */
	public int getNbrMax() {
		int Max = 0;
		int tmp;
		for (int i =0;i<l;i++) {
			tmp = Gri[i].getNbrElem();
			if (tmp>Max) {
				Max=tmp;
			}
		}
		return Max;
	}
	public void set(int i,Colonne c) {
		try {
			Gri[i]=c;
		} catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("|---PROBLEME a l'ajout de la colonne |" +c.getNom()+"| a l'index |"+i+"|");
		}
	}
	
	/**
	 * methode qui sert a savoir si on depasse la grille et qui 
	 * sinon retourne la colonne a une position i
	 * @param i
	 * @return colonne
	 */
	public Colonne retCol(int i) {
		Colonne j =null;
		if((i>(l-1))||(i<0)) {
			i=0;
		}else {
			j = this.Gri[i];
		}
		return j;
		
	}
	
	/**
	 * methode qui permet d'ajouter un jeton dans une colonne
	 * donner par le nombre i
	 * si on depasse le nombre max d'element alors tout les jeton
	 * de la meme ligne valent 0 (0 etant la valeur donnée pour representer le vide)
	 * @param i
	 * @param j
	 */
	public void ajouter(int i,Jeton j) {
		boolean dep=false;
		try {
			 if (this.getNbrMax()==Gri[i].getNbrElem()) {
		        	dep=true;
		        }
		        if( Gri[i].getTab().size()==Gri[i].getNbrElem()+1) {
		        	Gri[i].getTab().add(new Jeton(0));
		        }
		        	Gri[i].getTab().set(Gri[i].getNbrElem(),j);
		        
		        if (dep) {
		        	for (int r=0;r<l;r++) {
		        		if(r!=i ) {
		        			Gri[r].getTab().add(new Jeton(0));		
		        		}
		        	}
		        }
		} catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("|---PROBLEME a l'ajout du jeton |"+j+"| dans la colonne |" + i+"|");
		}
	       
    	}
	
	/**
	 * methode qui permet de calculer le remplissage moyen
	 * arrondies a la 2eme decimal
	 * @return double
	 */
	public double RemplissageMoy() {
		double moy=0;
		for (int i=0;i<l;i++) {
			moy+=Gri[i].getNbrElem();
    	}
		return (double)Math.round((moy/l) * 100) / 100 ;
	}
	
	/**
	 * methode qui permet de faire le trie des remplissage
	 * affichant le numero des colonnes des plus remplies au moins
	 * remplis ainsi que le nombre de jeton present dans la dite colonne
	 * @return String
	 */
	public String TrieRemp() {
		String res="";
		int i=0;
		while (i!=this.getNbrMax()+1) {
			for (int j=0;j<l;j++) {
				if(Gri[j].getNbrElem()==this.getNbrMax()-i) {
					res+=j+"("+Gri[j].getNbrElem()+") ";
				}					
			}
			i++;

		}
		return res;	
	}
	
	/**
	 * methode qui permet de sauvegarder Grille
	 * dans un fichier bin nommé Puissance4.bin en 
	 * le créant s'il n'existe pas
	 */
	public void sauvegarder() {
		ObjectOutputStream P4;
		try {
			P4 = new ObjectOutputStream(new FileOutputStream("Puissance4.bin"));
			P4.writeObject(this);
			P4.close();
		} catch (IOException e) {
			System.out.println("|---PROBLEME rien à sauvegarder");
		}		
	}
	
	/**
	 * methode qui permet de restaurer l'etat de grille
	 * a partir d'un fichier bin nommé Puissance4.bin
	 * @return Grille
	 */
	public static Grille restaurer(){
		Grille P4 = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Puissance4.bin"));
			P4=(Grille)(ois.readObject());
			ois.close();
		}catch (IOException e) {
			System.out.println("|---PROBLEME fichier Puissance4.bin inexistant");
			System.out.println("On demarre donc une nouvelle partie");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return P4;	
	}
	
	/**
	 * méthode qui gere la victoire du puissance 4
	 * @return boolean
	 */
	public boolean victoire() {
		boolean res=false;
		int i=0;
		int j=0;
		int n=0;
		for (int k=0;k<l;k++) {
			j+=Gri[k].getNbrElem();
		}
		/**
		 * victoire pour colonne
		 */
		for(int m=0;m<l;m++) {
			for(int o=0;o<(this.getNbrMax()-1);o++) {
				if(Gri[m].getElem(o).getNbr()==Gri[m].getElem(o+1).getNbr() && Gri[m].getElem(o).getNbr()!=0) {
					i++;
				}else {
					i=0;
				}
				if(i==3) {
					res=true;
					o=this.getNbrMax();
					m=l;
				}
			}
			i=0;
		}
		/**
		 * victoire pour ligne
		 */
		i=0;
		for(int o=0;o<(this.getNbrMax());o++) {
			for(int m=0;m<l-1;m++) {
				if(Gri[m].getElem(o).getNbr()==Gri[m+1].getElem(o).getNbr() && Gri[m].getElem(o).getNbr()!=0) {
					i++;
				}else {
					i=0;
				}
				if(i==3) {
					res=true;
					o=this.getNbrMax();
					m=l;
				}
			}
			i=0;
		}
		/**
		 * victoire pour diagonale droite
		 */
		i=0;
		int o=0;
		int q=0;
		int m=0;
		int a=0;
		boolean fin=false;
		while(!fin) {
			for(m=q;m<l-1;m++) {
				if(Gri[m].getElem(o).getNbr()==Gri[m+1].getElem(o+1).getNbr() && Gri[m].getElem(o).getNbr()!=0) {
					i++;
				}else {
					i=0;
				}
				if(o<(this.getNbrMax()-1)) {
				o++;
				}
				if(i==3) {
					res=true;
					m=l;
				}
			}
			if(q!=l-1) {
				o=0;
				q++;
				i=0;
			}else {
				if(a!=(this.getNbrMax()-1)) {
					q=0;
					a++;
					o=a;
					i=0;
				}else {
					fin=true;
				}				
			}
		}
		/**
		 * victoire pour diagonale gauche
		 */
		i=0;
		o=0;
		q=l-1;
		m=0;
		a=0;
		fin=false;
		while(!fin) {
			for(m=q;m>0;m--) {
				if(Gri[m].getElem(o).getNbr()==Gri[m-1].getElem(o+1).getNbr() && Gri[m].getElem(o).getNbr()!=0) {
					i++;
				}else {
					i=0;
				}
				if(o<(this.getNbrMax()-1)) {
				o++;
				}
				if(i==3) {
					res=true;
					m=l;
				}
			}
			if(q!=0) {
				o=0;
				q--;
				i=0;
			}else {
				if(a!=(this.getNbrMax()-1)) {
					q=l-1;
					a++;
					o=a;
					i=0;
				}else {
					fin=true;
				}				
			}
		}
	return res;	
	}

	/**
	 * @return the l
	 */
	public int getL() {
		return l;
	}

	/**
	 * @return the gri
	 */
	public Colonne[] getGri() {
		return Gri;
	}
	
}
