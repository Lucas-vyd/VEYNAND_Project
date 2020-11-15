import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;



public class DessinPerso implements moteurJeu.DessinJeu{
	private JeuPerso jeu;
	
	public DessinPerso(JeuPerso j) {
		jeu=j;
	}
	public void dessiner(BufferedImage image) {
	// recupere un objet graphics sur l'image
		// c'est l'equivalent d'un crayon avec lequel on peut dessiner
		Graphics2D g = (Graphics2D) image.getGraphics();

		// dessine l'image a afficher avec les primitives de graphics2D
		
		
				Jeu game=jeu.getJeu();

				//dessine le labyrinthe
				g.setColor(Color.black);
				for (int i=0;i<10;i++) {
					for (int y=0;y<10;y++) {
						if (jeu.getJeu().terrain.isEmpty(i,y)==false) {
							g.fillRect(i*50, y*50, 50, 50);
						};
					}
				}
				
				// dessine l'aventurier
				g.setColor(Color.blue);
				g.fillOval(game.perso.getX()* 50,game.perso.getY()* 50, 50, 50);
				
				//dessin d'une épée
				if(game.perso.getEpee()) {
					g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
					g.fillOval((game.perso.getX()* 50)+60,game.perso.getY()* 50, 10, 35);
					g.fillOval((game.perso.getX()* 50)+50,(game.perso.getY()* 50)+25, 30, 10);
					g.fillOval((game.perso.getX()* 50)+60,(game.perso.getY()* 50)+30, 10, 20);
				}		
				
				
				//dessin case special
				g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				for (int i=0;i<10;i++) {
					for (int y=0;y<10;y++) {
						if (jeu.getJeu().terrain.isSpecial(i,y)==true) {
							g.fill3DRect(i*50, y*50, 50, 50,true);
						};
					}
				}
				
				//dessin case potion
				g.setColor(new Color(50,205,50));
				for (int i=0;i<10;i++) {
					for (int y=0;y<10;y++) {
						if (jeu.getJeu().terrain.isPotion(i,y)==true) {
							g.fill3DRect(i*50, y*50, 50, 50,true);
						};
					}
				}
				
				//dessin monstre
				g.setColor(Color.red);
				if(game.tabMonstre[0].getEnVie()) {
					g.fillOval(game.tabMonstre[0].getX()*50,game.tabMonstre[0].getY()*50, 50, 50);
				}else {
					game.terrain.getCase(game.tabMonstre[0].getX(), game.tabMonstre[0].getY()).setTaken(false);
				}
				if(game.tabMonstre[1].getEnVie()) {
					g.fillOval(game.tabMonstre[1].getX()*50,game.tabMonstre[1].getY()*50, 50, 50);
				}else {
					game.terrain.getCase(game.tabMonstre[1].getX(), game.tabMonstre[1].getY()).setTaken(false);
				}
				
				g.setColor(Color.green);
				if(game.tabMonstre[2].getEnVie()) {
					g.fillOval(game.tabMonstre[2].getX()*50,game.tabMonstre[2].getY()*50, 50, 50);
				}else {
					game.terrain.getCase(game.tabMonstre[2].getX(), game.tabMonstre[2].getY()).setTaken(false);
				}
				if(game.tabMonstre[3].getEnVie()) {
					g.fillOval(game.tabMonstre[3].getX()*50,game.tabMonstre[3].getY()*50, 50, 50);
				}else {
					game.terrain.getCase(game.tabMonstre[3].getX(), game.tabMonstre[3].getY()).setTaken(false);
				}
				
				
				//changement de couleur en tapant
				if(jeu.getTape()) {
					g.setColor(Color.cyan);
					g.fillOval(game.perso.getX()* 50,game.perso.getY()* 50, 50, 50);
					jeu.setTape(false);
				}
				
				g.setColor(Color.red);
				if(game.perso.getVie()>=1) {
					g.fillRect(20, 470, 20, 20);
				}
				if(game.perso.getVie()>=2) {
					g.fillRect(45, 470, 20, 20);
				}
				if(game.perso.getVie()>=3) {
					g.fillRect(70, 470, 20, 20);
				}
				if(game.perso.getVie()>=4) {
					g.fillRect(95, 470, 20, 20);
				}
				if(game.perso.getVie()==5) {
					g.fillRect(120, 470, 20, 20);
				}
				
				//Victoire et defaite
				if((!game.tabMonstre[0].getEnVie())&&(!game.tabMonstre[1].getEnVie())&&(!game.tabMonstre[2].getEnVie())&&(!game.tabMonstre[3].getEnVie())) {
					g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
					Font myFont = new Font ("Courier New", 1, 50);
					g.setFont(myFont);
					g.drawString("WIN", 210, 260);
					jeu.setVictoire(true);
				}else if(!game.perso.getEnVie()) {
					g.setColor(Color.red);
					Font myFont = new Font ("Courier New", 1, 50);
					g.setFont(myFont);
					g.drawString("LOSE", 210, 260);
					jeu.setDefaite(true);
				}
				
				// rend le graphics
				g.dispose();
		
	}

}
