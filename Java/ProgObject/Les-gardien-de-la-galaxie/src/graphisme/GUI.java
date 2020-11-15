package graphisme;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import application.JeuShoot;

public class GUI extends JFrame {

	/**
	 * le jeu a controler
	 */
	JeuShoot jeu;

	/**
	 * creation de l'interface graphique
	 * 
	 * @param j
	 *            jeu correspondant
	 */
	public GUI(JeuShoot j) {
		super("Shoot");
		this.jeu = j;

		// creation des boutons
		JPanel controle = getControle();
		// creation afficheur
		JPanel dessin = new Dessin(j);

		// ajoute a la frame
		JPanel global = new JPanel();
		global.setLayout(new BorderLayout());
		global.add(controle, BorderLayout.SOUTH);
		global.add(dessin, BorderLayout.CENTER);
		this.setContentPane(global);

		// decouvre la frame
		this.setVisible(true);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * creation du panneau contenant les boutons de controle
	 * 
	 * @return panneau avec les boutons
	 */
	private JPanel getControle() {
		JPanel controle = new JPanel();
		controle.setLayout(new BorderLayout());

		// creation et ajout des boutons
		controle.add(creerBouton("bas", 2), BorderLayout.SOUTH);
		controle.add(creerBouton("haut", 8), BorderLayout.NORTH);
		controle.add(creerBouton("gauche", 4), BorderLayout.WEST);
		controle.add(creerBouton("droite", 6), BorderLayout.EAST);
		JPanel centre = new JPanel();
		centre.add(creerBouton("Tir", 5), BorderLayout.CENTER);
		centre.add(creerBouton("Rien", 0), BorderLayout.CENTER);

		controle.add(centre, BorderLayout.CENTER);
		return controle;
	}

	/**
	 * methode interne pour creer un bouton
	 * 
	 * @param s
	 *            la chaine decrivant la commande
	 * @param a
	 *            la commande correspondante
	 * @return le bouton cree
	 */
	private JButton creerBouton(String s, int a) {
		JButton bas = new JButton(s + " (" + a + ")");
		final int choix = a;
		bas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jeu.evoluer(choix);

				repaint();
			}
		});
		return bas;
	}

}
