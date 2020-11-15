package ProjetLampe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class VueTexte extends JPanel implements Observer{

	//Declaration des attributs
	private JTextArea txt;
	private int nb=0;
	JButton b1,b2,b3,b4;
	
	//constructeur de la vue texte
	public VueTexte() {
		
		txt=new JTextArea("Nb de déplacement\n"+String.valueOf(nb));
		this.txt.setFont(new Font(Font.SERIF, Font.BOLD, 35));
		txt.setPreferredSize(new Dimension(290,100));
		
		EcouteurBouton ecouteur = new EcouteurBouton();
		b1=new JButton("Configurer");
		b1.setPreferredSize(new Dimension(290,100));
		b1.addActionListener(ecouteur);
			
		b2=new JButton("Random");
		b2.setPreferredSize(new Dimension(290,100));
		b2.addActionListener(ecouteur);
			
		b3=new JButton("Jouer");
		b3.setPreferredSize(new Dimension(290,100));
		b3.addActionListener(ecouteur);
			
		b4=new JButton("Quitter");
		b4.setPreferredSize(new Dimension(290,100));
		b4.addActionListener(ecouteur);
	}
	
	
	private class EcouteurBouton implements ActionListener{
		public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		if(source.equals(b1)) {
			try {
				System.out.println("Configurer");
				nb++;
			}catch(NumberFormatException m) {
				System.out.println("|ERREUR|");
			}
		}
		if(source.equals(b2)) {
			try {
				System.out.println("Random");
			}catch(NumberFormatException m) {
				System.out.println("|ERREUR|");
			}
		}
		if(source.equals(b3)) {
			try {
				System.out.println("Jouer");
			}catch(NumberFormatException m) {
				System.out.println("|ERREUR|");
			}
		}
		if(source.equals(b4)) {
			try {
				System.out.println("Quitter");
			}catch(NumberFormatException m) {
				System.out.println("|ERREUR|");
			}
		}
	 }
	}
	@Override
	public void update(Observable o, Object arg) {
		nb++;
		
	}
}
