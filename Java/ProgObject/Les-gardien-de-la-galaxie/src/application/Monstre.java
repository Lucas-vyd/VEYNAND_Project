/******************
* classe Monstre
*******************/

/*Je met la classe en package*/
package application;

/*je crée la classe Monstre*/
public class Monstre {
  /**
  * @param x l'abscisse
  * @param y l'ordonnee
  * @param deplacerHaut Booleen pour savoir si le monstre se deplace vers le haut ou le bas
  * @param etreMort L'etat du monstre
  */

  /*attribut entier de l'abscisses*/
  private int x;
  /*attribut entier de l'ordonnée*/
  private int y;
  /*attribut booleen correspondant à deplacerHaut*/
  private boolean deplacerHaut;
  /*attribut booleen correspondant à etreMort*/
  private boolean etreMort;

  /**
  * Monstre avec parametre px, py, auquel j'attribut a x px; a y py si px et py ne sortent pas de l'arene sinon 10 a x et 5 a y. J'attribue aussi vraie a deplacerHaut et faux à  etreMort
  @param px l'abscisse du monstre
  @param py l'ordonnee du monstre
  */
  public Monstre(int px, int py){
    if (px>=0 && px<=10 && py>=0 && py<= 10){
      this.x = px;
      this.y = py;
    }else{
      this.x = 10;
      this.y = 5;
    }
    this.deplacerHaut = true;
    this.etreMort = false;
  }

  /**
  * accesseurs de x
  @return l'abscisse du monstre
  */
  public int getX(){
    return (this.x);
  }
  /**
  * accesseurs de y
  @return l'ordonnee du monstre
  */
  public int getY(){
    return (this.y);
  }
  /**
  * accesseurs de tirCourant
  @return l'etat du monstre
  */
  public boolean getEtreMort(){
    return (this.etreMort);
  }

  /**
  * evoluer qui change les coordonnee du monstre
  */
  public void evoluer(){
    if (etreMort == false){
      if (deplacerHaut == true){
        if(this.y-1 >= 0){
          this.y += -1;
        }else {
          this.x += -1;
          deplacerHaut = false;
        }
      }else{
        if(this.y+1 <= 10){
          this.y += +1;
        }else {
          this.x += -1;
          deplacerHaut = true;
        }
      }
    }
  }

  /**
  * avoirTraverse qui regarde si le monstre a traverser le terrain
  @return Vrai si le montre a traverse et faux si le monstre n'as pas traverse
  */
  public boolean avoirTraverse(){
    boolean traverse = false;
    if (this.x == 0){
      traverse = true;
    }
    return(traverse);
  }

  /**
  * avoirCollision qui regarde si le monstre a une collision avec le tirer et actualise l'etat du monstre
  @param t coordonnee du tir
  @return Vrai si le montre a une collsion avec le tir et faux si le monstre n'a pas eu une collsion avec le tir
  */
  public boolean avoirCollision(Tir t){
    boolean Collision = false;
    if (t != null && t.getX() == this.x && t.getY() == this.y){
      Collision = true;
      this.etreMort = true;
    }
    return (Collision);
  }

  /**
  * toString de type String sans parametre, qui retourne un chaine de charactere sous la forme "Monstre(x,y)"
  @return La chaine de caractere de monstre
  */
  public String toString(){
    String Mstr;
    Mstr = "Monstre(" + this.x + "," + this.y + ")";
    return Mstr;
  }

}
