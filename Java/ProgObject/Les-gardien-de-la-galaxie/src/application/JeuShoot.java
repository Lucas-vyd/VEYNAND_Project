/******************
* classe JeuShoot
*******************/

/*Je met la classe en package*/
package application;

import java.util.Scanner;

/*je crée la classe Monstre*/
public class JeuShoot {
  /**
  * @param joueur le vaisseau
  * @param ennemi le monstre
  * @param score le score
  * @param perdu l'etat du jeu
  */

  /*attribut Vaisseau joueur*/
  private Vaisseau joueur;
  /*attribut Monstre ennemi*/
  private Monstre ennemi;
  /*attribut entier score*/
  private int score;
  /*attribut booléen*/
  private boolean perdu;

  /**
  * JeuShoot sans parametre auquel j'attribut a vaisseau 0,5 a monstre 10,5 a score 0 et false a perdu
  */
  public JeuShoot(){
    this.joueur = new Vaisseau(0,5);
    this.ennemi = new Monstre(10,5);
    this.score = 0;
    this.perdu = false;
  }

  /**
  * accesseurs de joueur
  @return les coordonnee de joueur
  */
  public Vaisseau getJoueur(){
    return (this.joueur);
  }
  /**
  * accesseurs de ennemi
  @return les coordonnee de l'ennemi
  */
  public Monstre getEnnemi(){
    return (this.ennemi);
  }
  /**
  * accesseurs de score
  @return le score
  */
  public int getScore(){
    return (this.score);
  }
  /**
  * accesseurs de perdu
  @return l'etat du jeu
  */
  public boolean getPerdu(){
    return (this.perdu);
  }

  /**
  * setEnnemi avec parametre un monstre m pour placer un monstre
  @param m le monstre
  */
  public void setEnnemi(Monstre m){
    this.ennemi = m;
  }

  /**
  * setJoueur avec parametre un vaisseau v pour placer un vaisseau
  @param v le vaisseau
  */
  public void setJoueur(Vaisseau v){
    this.joueur = v;
  }


  /**
  * gererCollision qui augmente le score si le monstre subit une collision
  */
  public void gererCollision(){
    if (joueur.getTirCourant() != null){
      if (ennemi.avoirCollision(joueur.getTirCourant()) == true){
        this.score += +1;
        joueur.detruireTir();
        this.ennemi = new Monstre(10,5);
      }
    }
  }

  /**
  * evoluer avec parametre un entier demanderJoueur qui regroupe les differentes action du jeu
  @param demanderJoueur l'action du joueur sur le pave numerique
  */
  public void evoluer(int demanderJoueur){
    if (demanderJoueur == 0 || demanderJoueur == 2 || demanderJoueur == 4 || demanderJoueur == 5 || demanderJoueur == 6 || demanderJoueur == 8){
      joueur.faireAction(demanderJoueur);
      joueur.evoluerTir();
      this.gererCollision();
      ennemi.evoluer();
      this.gererCollision();
      if (ennemi.avoirTraverse() == true){
        this.perdu = true;
      }
    }
  }

  /**
  * demanderJoueur sans parametre pour demander la toucher du pave numerique
  @return la touche du pave numerique sur laquel on a appuiye
  */
  public int demanderJoueur(){
    Scanner sc = new Scanner(System.in);
    int touche = sc.nextInt();
    return(touche);
  }

  /**
  * poursuivre sans parametre qui fais tourner le jeu
  */
  public void poursuivre(){
    int Commande =this.demanderJoueur();
    this.evoluer(Commande);
    System.out.println(this.toString());
  }

  /**
  * toString de type String sans parametre, qui retourne un chaine de charactere sous la forme "Vaisseau(3,4)" \n "Monstre(10,5)" \n "1"
  @return La chaine de caractere de joueur, de ennemi et de score
  */
  public String toString(){
    String Jeu = joueur.toString() + "\n" + ennemi.toString() + "\n" + this.score;
    return (Jeu);
  }

  /**
  * methode de lancement du jeu
  @param args pour lancement du jeu
  */
  public static void main(String[] args) {
		JeuShoot Jeu = new JeuShoot();
    while (Jeu.perdu == false){
      Jeu.poursuivre();
    }
	}



}
