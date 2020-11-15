import moteurJeu.Commande;

public class JeuPerso implements moteurJeu.Jeu{


	private Jeu j=new Jeu();
	private boolean tape=false;
	private boolean victoire=false;
	private boolean defaite=false;
	




	public JeuPerso(int a,int b) {
		Jeu j=new Jeu();
		((Aventurier) j.perso).setPosX(b);
		((Aventurier) j.perso).setPosY(b);
	}
	
	public void evoluer(Commande c) {
		if((!victoire)&&(!defaite)) {
			for(int i=0;i<j.tabMonstre.length;i++) {
				if(j.tabMonstre[i].getEnVie()) {
					if(j.tabMonstre[i].getNom().equals("MDeplacement")) {
						if(!j.tabMonstre[i].aCoter(j)) {
							j.tabMonstre[i].deplacement(j.terrain);
						}
					}
					j.tabMonstre[i].attaquer(j);
				}
			}
			
			if(c.gauche) {
				j.deplacement("q");
			}else if(c.droite) {
				j.deplacement("d");
			}else if(c.haut) {
				j.deplacement("z");
			}else if(c.bas) {
				j.deplacement("s");
			}else if(c.espace) {
				j.perso.attaquer(j);
				tape=true;
			}
			
			if(j.terrain.isSpecial(j.perso.getX(),j.perso.getY())) {
				j.terrain.lab[j.perso.getX()][j.perso.getY()].setSpecial(false);
				j.perso.setEpee(true);
				j.perso.setAttaque(2);
			}
			if(j.terrain.isPotion(j.perso.getX(),j.perso.getY())) {
				j.terrain.lab[j.perso.getX()][j.perso.getY()].setPotion(false);
				j.perso.setVie(5);;
			}
		}
	}
	
	public boolean etreFini() {
		return false;
	}
	
	public Jeu getJeu() {
		return j;
	}
	
	public Jeu getJ() {
		return j;
	}
	
	public boolean getTape() {
		return tape;
	}
	
	public void setTape(boolean a) {
		tape=a;
	}
	
	/**
	 * @return the victoire
	 */
	public boolean getVictoire() {
		return victoire;
	}

	/**
	 * @param victoire the victoire to set
	 */
	public void setVictoire(boolean victoire) {
		this.victoire = victoire;
	}
	
	/**
	 * @return the defaite
	 */
	public boolean isDefaite() {
		return defaite;
	}

	/**
	 * @param defaite the defaite to set
	 */
	public void setDefaite(boolean defaite) {
		this.defaite = defaite;
	}
}
