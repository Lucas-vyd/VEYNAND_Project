/******************
* classe Vaisseau
*******************/

/*Je met la classe en package*/
package application;

/*je crée la classe Vaisseau*/
public class Vaisseau {
  /**
  * @param x l'abscisse
  * @param y l'ordonnee
  * @param tirCourant les coordonnees du tir
  */

  /*attribut entier de l'abscisses*/
  private int x;
  /*attribut entier de l'ordonnée*/
  private int y;
  /*attribut Tir correspondant à tirCourant*/
  private Tir tirCourant = null;

  /**
  * Vaisseau sans parametre auquel j'attribut à x 5; à y 5 et au tirCourant null
  */
  public Vaisseau(){
    this.x = 5;
    this.y = 5;
    this.tirCourant = null;
  }

  /**
  * Vaisseau avec parametre px, py, auquel j'attribut a x px; a y py si px et py ne sortent pas de l'arene et au tirCourant null
  @param px abscisse du vaisseau
  @param py ordonnee du vaisseau
  */
  public Vaisseau(int px, int py){
    if (px>=0 && px<=10 && py>=0 && py<= 10){
           this.x = px;
           this.y = py;
           this.tirCourant = null;
    }
    else{
      this.x = 5;
      this.y = 5;
    }
    tirCourant = null;
   }

   /**
   * accesseurs de l'abscisse
   @return abscisse du vaisseau
   */
   public int getX(){
     return (this.x);
   }
   /**
   * accesseurs de l'ordonne
   @return ordonnee du vaisseau
   */
   public int getY(){
     return (this.y);
   }
   /**
   * accesseurs du tir
   @return coordonnee du tir
   */
   public Tir getTirCourant(){
     return (tirCourant);
   }

   /**
   * deplacer avec parametre dx, dy, auquel j'ajoute a x dx; a y dy si x+dx et y+dy ne sortent pas de l'arene
   @param dx abscisse a ajouter au vaisseau
   @param dy ordonnee a ajouter au vaisseau
   */
    private void deplacer(int dx, int dy){
      if (this.x+dx<=10 && this.x+dx>=0 && this.y+dy<= 10 && this.y+dy>= 0){
             this.x = this.x+dx;
             this.y = this.y+dy;
      }else {

      }
    }

    /**
    * tirer sans parametre,si tirCourant null alors creer un tirCourant puis fais avancer le tir grace a la meth
    */
    public void tirer(){
      if (this.tirCourant == null){
        int a = this.x;
        int o = this.y;
        tirCourant = new Tir(a, o);
      }
    }

    /**
    * faireAction sans parametre,qui d'apres la valeur de pad fais une action differente
    @param Pad touche du pave numerque
    */
    public void faireAction(int Pad){
      if (Pad == 0){
      }
      if (Pad == 4){
        this.deplacer(-1, 0);
      }
      if (Pad == 6){
        this.deplacer(1, 0);
      }
      if (Pad == 8){
        this.deplacer(0, -1);
      }
      if (Pad == 2){
        this.deplacer(0, 1);;
      }
      if (Pad == 5){
        this.tirer();
      }
    }

    /**
    * detruireTir sans parametre,qui detruis le tir
    */
    public void detruireTir(){
      this.tirCourant = null;
    }

    /**
    * evoluerTir sans parametre,qui augmente la valeur de tir
    */
    public void evoluerTir(){
      if (tirCourant != null && tirCourant.evoluer() == true){
        detruireTir();
      }
    }

    /**
    * toString de type String sans parametre, qui retourne un chaine de charactere sous la forme "Vaisseau(x,y)" ou "Vaisseau(x,y)-T(a,o)" en fonction de si tirCourant est nul ou non
    @return La chaine de caractere de vaisseau et du tir
    */
    public String toString(){
      String vaiss;
      if (this.tirCourant != null){
        vaiss = "Vaisseau(" + this.x + "," + this.y + ")-"+ this.getTirCourant();
      }
      else{
        vaiss = "Vaisseau(" + this.x + "," + this.y + ")";
      }
      return vaiss;
    }

}
