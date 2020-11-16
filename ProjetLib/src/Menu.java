import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe Menu, elle sert a rentrer ses identifiants ainsi qu'à contenir tous les boutons qui permettrons d'acceder aux differents questions
 * @author lucas
 * 
 */

public class Menu {

	Identifiant i = new Identifiant();

	/**
	 * Constructeur dans lequel on va gerer l'interface
	 */

	public Menu() {

		/**
		 * si l'utilisateur ne s'est pas identifié, on demande le login et le mot de passe
		 */

		if (i.getLogin().equals("") || i.getMDP().equals("")) {

			/**
			 * La consigne est stocké dans un JLabel
			 */

			JLabel l= new JLabel("Veuillez rentrez vos identifiants",JLabel.CENTER);

			/**
			 * Deux JTextField sont créés afin de pouvoir ecrire son login et son mot de passe
			 */

			JTextField j1 = new JTextField(50);
			JTextField j2 = new JTextField(50);
			JFrame frame=new JFrame("Identifiant");

			/**
			 * Un JButton est créé:
			 * "continuer" pour essayer de se connecter
			 */

			JButton b = new JButton("continuer");

			/**
			 * création des différents JPanel pour une interface plus ergonomique
			 */

			JPanel panneauDeControle= new JPanel(new GridLayout(5,1));
			JPanel panneauDeControle2= new JPanel(new GridLayout(1,2));
			JPanel panneauDeControle3= new JPanel(new GridLayout(1,2));
			JPanel panneauDeControle4= new JPanel(new GridLayout(1,1));

			panneauDeControle2.add(new JLabel("Login :"+"    ",JLabel.CENTER));
			panneauDeControle2.add(j1);

			panneauDeControle3.add(new JLabel("Mot de passe :"+"    ",JLabel.CENTER));
			panneauDeControle3.add(j2);
			
			panneauDeControle4.add(new JLabel("Login ou Mot de passe incorrect",JLabel.CENTER));

			panneauDeControle.add(l);
			panneauDeControle.add(panneauDeControle2);
			panneauDeControle.add(panneauDeControle3);
			panneauDeControle.add(b);
			panneauDeControle.add(panneauDeControle4);

			panneauDeControle4.setVisible(false);

			/**
			 * action effectué lors du clic sur le JButton "continuer"
			 * va tenter de se connecter a la base de donnée
			 */

			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					i.setLogin(j1.getText());
					i.setMDP(j2.getText());

					try {

						/**
						 * Si la connection reussi, l'interface donnant accés aux questions apparait
						 */

						i.connect();
						frame.dispose();
						new Menu();

					} catch (SQLException e1) {

						/**
						 * Si la connection échoue, un message d'erreur apparait
						 */

						panneauDeControle4.setVisible(true);
						i.setLogin("");
						i.setMDP("");
					}		
				}		
			});

			frame.getContentPane().add(panneauDeControle,BorderLayout.NORTH);		
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(new Dimension(400,170));
			frame.setVisible(true);

		}else {

			/**
			 * si l'utilisateur s'est identifié, on affiche l'interface avec 8 JButton affin d'acceder aux différentes questions
			 */

			JButton Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8;
			JFrame frame=new JFrame("MENU");
			//Zone centrale	
			JPanel panneauDeControle= new JPanel(new GridLayout(4,2));
			Q1 = new JButton("Q1");
			Q2 = new JButton("Q2");
			Q3 = new JButton("Q3");
			Q4 = new JButton("Q4");
			Q5 = new JButton("Q5");
			Q6 = new JButton("Q6");
			Q7 = new JButton("Q7");
			Q8 = new JButton("Q8");

			panneauDeControle.add(Q1);
			panneauDeControle.add(Q2);
			panneauDeControle.add(Q3);
			panneauDeControle.add(Q4);
			panneauDeControle.add(Q5);
			panneauDeControle.add(Q6);
			panneauDeControle.add(Q7);
			panneauDeControle.add(Q8);


			Q1.addActionListener(e -> {
				frame.dispose();
			});
			Q2.addActionListener(e -> {
				frame.dispose();
			});
			Q3.addActionListener(e -> {
				frame.dispose();
			});
			Q4.addActionListener(e -> {
				frame.dispose();
			});
			Q5.addActionListener(e -> {
				frame.dispose();
			});
			Q6.addActionListener(e -> {
				frame.dispose();
			});
			Q7.addActionListener(e -> {
				frame.dispose();
			});
			Q8.addActionListener(e -> {
				frame.dispose();
			});

			Q1.addActionListener(new Q1());
			Q2.addActionListener(new Q2());
			Q3.addActionListener(new Q3());
			Q4.addActionListener(new Q4());
			Q5.addActionListener(new Q5());
			Q6.addActionListener(new Q6());
			Q7.addActionListener(new Q7());
			Q8.addActionListener(new Q8());

			//Construction de l'IG dans une JFrame		 

			frame.getContentPane().add(panneauDeControle,BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(new Dimension(400,400));
			frame.setVisible(true);
		}
	}
}
