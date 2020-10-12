

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principal {
	
	//permet de lancer le jeu
	public static void main(String[] args) {
		
		//on crée les 2 JPanel g à gauche qui contiendra les boutons et le nombre de coup et d à droite qui contient les lampes
		JPanel g = new JPanel();
		JPanel d = new JPanel();
		
		g.setPreferredSize(new Dimension(300,580));
		d.setPreferredSize(new Dimension(480,580));
		d.setBackground(Color.black);
		JFrame fenetre = new JFrame("Grille");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VueGraphique vg=new VueGraphique();
		//on insère toute les lampes dans le JPanel d
		for(int i=0;i<25;i++) {
			d.add(vg.tabl[i]);
		}
		
		//on ajoute les boutons dans le JPanel à gauche
		g.add(vg.b1);
		g.add(vg.b2);
		g.add(vg.b3);
		g.add(vg.txt);
		g.add(vg.b4);
		
		//on ajoute les JPanel dans la fenetre (Le JFrame)
		fenetre.add(g, BorderLayout.WEST);
		fenetre.add(d, BorderLayout.EAST);
		fenetre.pack();
		fenetre.setVisible(true);
	}
}
