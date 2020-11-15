/*
 * Exemple d'utilisation
 * 
 * A entrer dans le JTextField : 
 * 
 * Laboratory for Foundations of Computer Science
 * 
 * 
 * Résultat attendu avec les tables non modifié:
 * 
 * Laboratoire :
 * Laboratory for Foundations of Computer Science
 * 
 * Buneman
 * -nombre d'articles publiés : 1
 * -nombre de notes attribuées aux articles : 2
 * -moyenne des notes attribuées : 2.5
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
 * Classe Q6 qui correspont a l'affichage de la réponse à la question 6
 * @author lucas
 * 
 */

public class Q6 implements ActionListener{

	/**
	 * La question est stocké dans deux JLabel
	 */

	JLabel l= new JLabel("Affiche pour chaque chercheur le nombre d'articles publiés,",JLabel.CENTER);
	JLabel l2= new JLabel(" le nombre et la moyenne des notes obtenues.",JLabel.CENTER);

	/**
	 * Un JTextField est créé afin de pouvoir ecrire un nom de laboratoire
	 */

	JTextField j = new JTextField(50);
	JFrame frame=new JFrame("Q6");

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

	String var="Réponse à la question 6: \n";
	JTextArea rep = new JTextArea(var);

	/**
	 * action effectué lors du clic sur le JButton "Q6"
	 */

	public void actionPerformed(ActionEvent e) {

		/**
		 * création des différents JPanel pour une interface plus ergonomique
		 */

		JPanel panneauDeControle= new JPanel(new GridLayout(4,1));
		JPanel panneauDeControle2= new JPanel(new GridLayout(1,2));

		panneauDeControle2.add(new JLabel("Donner un laboratoire "+"    ",JLabel.CENTER));
		panneauDeControle2.add(j);

		panneauDeControle.add(l);
		panneauDeControle.add(l2);
		panneauDeControle.add(panneauDeControle2);
		panneauDeControle.add(b);

		rep.setEditable(false);

		/**
		 * action effectué lors du clic sur le JButton "continuer"
		 * appelle la classe Req6
		 */

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var = "Réponse à la question 6: \n\n";

				try {
					Req6 s = new Req6(j.getText());
					if (s.getRes().equals("Laboratoire :\n" + j.getText() + "\n\n")) {
						var += "Aucune réponse";
					}else {
						var += s.getRes();
					}		
				} catch (Exception e1) {
					e1.printStackTrace();
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

