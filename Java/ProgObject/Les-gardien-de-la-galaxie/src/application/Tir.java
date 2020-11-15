/******************
* classe Tir
*******************/

/*Je met la classe en package*/
package application;

/*je crée la classe tir*/
public class Tir {
  /**
  * @param x l'abscisse
  * @param y l'ordonnee
  */

  /*attribut entier de l'abscisses*/
  private int x;
  /*attribut entier de l'ordonnée*/
  private int y;

  /**
  * Tir avec les valeurs px et py
  @param px abscisse du tir
  @param py ordonnee du tir
  */
  public Tir(int px, int py){
    this.x = px;
    this.y = py;
  }

  /**
  * accesseurs de l'abscisse
  @return abscisse du tir
  */
  public int getX(){
    return (this.x);
  }

  /**
  * accesseurs de l'ordonnee
  @return ordonnee du tir
  */
  public int getY(){
    return (this.y);
  }

  /**
  * evoluer qui augmente la valeur de x de 1 et qui retourne un boolean, true si x est superieur ou egale a 11, false sinon
  @return ordonnee du tir
  */
  public boolean evoluer(){
    boolean res;
    this.x = this.x + 1;
    if (this.x >= 11){
      res = true;
    }
    else {
      res = false;
    }
    return (res);
  }

  /**
  * toString qui retourne un chaine de charactere sous la forme "T(x,y)"
  @return La chaine de caractere de tir
  */
  public String toString(){
    String tir;
    tir = "T" + "(" + this.x + "," + this.y + ")";
    return tir;
  }

}
