package Puissance4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Jeu {
	private static Grille g;
	
	public static void main(String args[]) throws InterruptedException {
		Jeu j=new Jeu();
		boolean joueur=false;
		int jeton1;
		int jeton2;
		String joueur1;
		String joueur2;
		Joueur j1 = null;
		Joueur j2 = null;
		boolean trouverGrille=false;
		String etat;
		boolean partie=true;
		int position=0;
		while(partie) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Sauvegarder reprendre ou jouer?(S/R/J)");
			etat=sc.nextLine();
			if(!etat.equals("S") && !etat.equals("s") && !etat.equals("R") && !etat.equals("r") && !etat.equals("J") && !etat.equals("j")) {
				System.out.println("|---PROBLEME lettre |"+etat+"| ne correspond ni a: S,R,J");
			}
			if(etat.equals("S")||etat.equals("s")) {
				try {
					g.sauvegarder();
					j1.sauvegarder("a");
					j2.sauvegarder("b");
				}catch(NullPointerException e){
					System.out.println("|---PROBLEME rien à sauvegarder");
				}
			}else if(etat.equals("R")||etat.equals("r")){
				if(g.restaurer()!=null) {
					g=g.restaurer();
					j1=j1.restaurer("a");
					j2=j2.restaurer("b");
					System.out.print(Grille.restaurer());
					joueur=true;
				}
				etat="J";
			}
			if(etat.equals("J")||etat.equals("j")){
				while((!joueur)) {
					if(!trouverGrille) {
						g=new Grille();
						for(int i=0;i<g.getL();i++) {
							Colonne Col=new Colonne("Col"+i);
							g.set(i,Col);
						}
						trouverGrille=true;
					}
					sc=new Scanner(System.in);
					System.out.println("Entrer le jeton du joueur 1(entre 1 et 9):");
					jeton1=sc.nextInt();
					System.out.println("Entrer le jeton du joueur 2(entre 1 et 9) mais different de "+jeton1+" :");
					jeton2=sc.nextInt();
					if(jeton1==jeton2) {
						System.out.println("vous avez choisi les même jeton veuillez choisir d'autres jeton");
					}else if(((jeton1<1)||(jeton1>9))&&((jeton2<1)||(jeton2>9))) {
						System.out.println("les jetons 1 et 2 sont supérieur a 9 ou inferieur a 1 veuillez les resaisir");
					}else if ((jeton1<1)||(jeton1>9)) {
						System.out.println("les jetons 1 est supérieur a 9 ou inferieur a 1 veuillez le resaisir");
					}else if((jeton2<1)||(jeton2>9)) {
						System.out.println("les jetons 2 est supérieur a 9 ou inferieur a 1 veuillez le resaisir");
					}else {
						sc=new Scanner(System.in);
						System.out.println("Tout est bon pour les jeton! Joueur 1 choisit ton nom:");
						joueur1=sc.nextLine();
						System.out.println("Maintenant Joueur 2 choisit ton nom:");
						joueur2=sc.nextLine();
						while(joueur1.equals(joueur2)) {
							System.out.println("Joueur 2 change de nom tu as le meme que celui du joueur 11");
							joueur2=sc.nextLine();
						}
						j1=new Joueur(jeton1,joueur1);
						j2=new Joueur(jeton2,joueur2);
						System.out.println("Tout est bon vous êtes pret la partie va commencer dans \n3");
						Thread.sleep(1000);
						System.out.println("2");
						Thread.sleep(1000);
						System.out.println("1");
						Thread.sleep(1000);
						System.out.println("0"+"\n"+"c'est partie");
						joueur=true;
					}
					
				}
				sc=new Scanner(System.in);
				if(Grille.tour==1) {
					System.out.println(j1.getNom()+" choisis une colonne (entre 0 et "+(g.getL()-1)+")");
					position=sc.nextInt();
					g.ajouter(position,new Jeton(j1.getNbr()));
					Grille.tour=2;
				}else {
					System.out.println(j2.getNom()+" choisis une colonne (entre 0 et "+(g.getL()-1)+")");
					position=sc.nextInt();
					g.ajouter(position,new Jeton(j2.getNbr()));
					Grille.tour=1;
				}
				System.out.println(g);
				if (g.victoire()) {
					partie=false; 
					if(Grille.tour==2) {
						System.out.println("|--Victoire de "+j1.getNom()+"! Bravo!--|");
					}else {
						System.out.println("|--Victoire de "+j2.getNom()+"! Bravo!--|");
					}
				}
			}
			
		}
		
	}
}
