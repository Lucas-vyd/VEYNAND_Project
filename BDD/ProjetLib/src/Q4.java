/*
 * Exemple d'utilisation
 * 
 * A entrer dans le JTextField : 
 * 
 * 2
 * 
 * 
 * Résultat attendu avec les tables non modifié:
 * 
 * Lynch
 * Guerraoui
 * Buneman
 * 
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Classe Q4 qui correspont a l'affichage de la réponse à la question 4
 * @author lucas
 * 
 */

public class Q4 implements ActionListener{

	/**
	 * La question est stocké dans deux JLabel
	 */

	JLabel l= new JLabel("Affichage de la liste des chercheurs ayant annoté",JLabel.CENTER);
	JLabel l2= new JLabel("au moins un nombre donné d'articles.",JLabel.CENTER);

	/**
	 * Un JTextField est créé afin de pouvoir ecrire un nombre d'article
	 */

	JTextField j = new JTextField(50);
	JFrame frame=new JFrame("Q4");

	/**
	 * Deux JButton sont créés:
	 * "continuer" pour afficher la réponse
	 * "retour" pour afficher le menu
	 */

	JButton b = new JButton("continuer");
	JButton r = new JButton("retour");

	/**
	 *  Un JTextArea est créé afin d'y afficher le resultat
	 */

	String var="Réponse à la question 4: \n";
	JTextArea rep = new JTextArea(var);

	boolean bool;

	/**
	 * action effectué lors du clic sur le JButton "Q4"
	 */

	public void actionPerformed(ActionEvent e) {

		/**
		 * création des différents JPanel pour une interface plus ergonomique
		 */

		JPanel panneauDeControle= new JPanel(new GridLayout(4,1));
		JPanel panneauDeControle2= new JPanel(new GridLayout(1,2));

		panneauDeControle2.add(new JLabel("Donner un nombre d'article "+"    ",JLabel.CENTER));
		panneauDeControle2.add(j);

		panneauDeControle.add(l);
		panneauDeControle.add(l2);
		panneauDeControle.add(panneauDeControle2);
		panneauDeControle.add(b);

		rep.setEditable(false);

		/**
		 * action effectué lors du clic sur le JButton "continuer"
		 * appelle la classe Req4
		 */

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var = "Réponse à la question 4: \n\n";

				try {				
					Integer.parseInt(j.getText());
					bool = true;
				} catch (NumberFormatException e1){
					var+= "ERREUR Ce n'est pas un nombre";
					bool = false;
				}

				if (bool) {
					try {
						Req4 s = new Req4(Integer.parseInt(j.getText()));
						if (s.getRes().equals("")) {
							var += "Aucune réponse";
						}else {
							var += s.getRes();
						}		
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}

				rep.setText(var);
			}		
		});

		/**
		 * action effectué lors du clic sur le JButton "retour"
		 */

		r.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Menu();
				frame.dispose();
			}		
		});

		//Construction de l'IG dans une JFrame		 

		frame.getContentPane().add(panneauDeControle,BorderLayout.NORTH);
		frame.getContentPane().add(new JScrollPane(rep),BorderLayout.CENTER);
		frame.getContentPane().add(r,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(400,400));
		frame.setVisible(true);

	}
}
