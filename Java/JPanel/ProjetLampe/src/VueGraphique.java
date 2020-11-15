package ProjetLampe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputAdapter;



public class VueGraphique {
	
	//Déclaration des differentes varibles du jeu
	JPanel g,d;
	JPanel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25;
	JPanel tabl []=new JPanel[25];
	JButton b1,b2,b3,b4;
	JTextArea txt;
	int nb=0;
	boolean jouer = false;
	boolean config = false;
	
	//crée la vue graphique qui crée le jeu
	public VueGraphique() {
		//crée les différentes lumières
		l1=new Lumiere(1);
		l1.setPreferredSize(new Dimension(90,110));
		l2=new Lumiere(2);
		l2.setPreferredSize(new Dimension(90,110));
		l3=new Lumiere(3);
		l3.setPreferredSize(new Dimension(90,110));
		l4=new Lumiere(4);
		l4.setPreferredSize(new Dimension(90,110));
		l5=new Lumiere(5);
		l5.setPreferredSize(new Dimension(90,110));
		l6=new Lumiere(6);
		l6.setPreferredSize(new Dimension(90,110));
		l7=new Lumiere(7);
		l7.setPreferredSize(new Dimension(90,110));
		l8=new Lumiere(8);
		l8.setPreferredSize(new Dimension(90,110));
		l9=new Lumiere(9);
		l9.setPreferredSize(new Dimension(90,110));
		l10=new Lumiere(10);
		l10.setPreferredSize(new Dimension(90,110));
		l11=new Lumiere(11);
		l11.setPreferredSize(new Dimension(90,110));
		l12=new Lumiere(12);
		l12.setPreferredSize(new Dimension(90,110));
		l13=new Lumiere(13);
		l13.setPreferredSize(new Dimension(90,110));
		l14=new Lumiere(14);
		l14.setPreferredSize(new Dimension(90,110));
		l15=new Lumiere(15);
		l15.setPreferredSize(new Dimension(90,110));
		l16=new Lumiere(16);
		l16.setPreferredSize(new Dimension(90,110));
		l17=new Lumiere(17);
		l17.setPreferredSize(new Dimension(90,110));
		l18=new Lumiere(18);
		l18.setPreferredSize(new Dimension(90,110));
		l19=new Lumiere(19);
		l19.setPreferredSize(new Dimension(90,110));
		l20=new Lumiere(20);
		l20.setPreferredSize(new Dimension(90,110));
		l21=new Lumiere(21);
		l21.setPreferredSize(new Dimension(90,110));
		l22=new Lumiere(22);
		l22.setPreferredSize(new Dimension(90,110));
		l23=new Lumiere(23);
		l23.setPreferredSize(new Dimension(90,110));
		l24=new Lumiere(24);
		l24.setPreferredSize(new Dimension(90,110));
		l25=new Lumiere(25);
		l25.setPreferredSize(new Dimension(90,110));

		//crée les écouteur pour gérer le clique ou la pression des boutons 
		EcouteurBouton ecouteur = new EcouteurBouton();
		EcouteurSouris souris = new EcouteurSouris();

		//crée le bouton configurer
		b1=new JButton("Configurer");
		b1.setPreferredSize(new Dimension(290,100));
		b1.addActionListener(ecouteur);
		
		//crée le bouton random
		b2=new JButton("Random");
		b2.setPreferredSize(new Dimension(290,100));
		b2.addActionListener(ecouteur);
		
		//crée le bouton jouer
		b3=new JButton("Jouer");
		b3.setPreferredSize(new Dimension(290,100));
		b3.addActionListener(ecouteur);
		
		//crée le bouton quitter
		b4=new JButton("Quitter");
		b4.setPreferredSize(new Dimension(290,100));
		b4.addActionListener(ecouteur);
		
		//crée le texte indiquand le nombre de clique
		txt=new JTextArea("Nb de déplacement\n"+nb);
		this.txt.setFont(new Font(Font.SERIF, Font.BOLD, 35));
		txt.setPreferredSize(new Dimension(290,100));
		
		//ajoute toute les lampes dans un tableau
		tabl[0]=l1;
		tabl[1]=l2;
		tabl[2]=l3;
		tabl[3]=l4;
		tabl[4]=l5;
		tabl[5]=l6;
		tabl[6]=l7;
		tabl[7]=l8;
		tabl[8]=l9;
		tabl[9]=l10;
		tabl[10]=l11;
		tabl[11]=l12;
		tabl[12]=l13;
		tabl[13]=l14;
		tabl[14]=l15;
		tabl[15]=l16;
		tabl[16]=l17;
		tabl[17]=l18;
		tabl[18]=l19;
		tabl[19]=l20;
		tabl[20]=l21;
		tabl[21]=l22;
		tabl[22]=l23;
		tabl[23]=l24;
		tabl[24]=l25;
		
		KeyListener kl1 = new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				System.out.println("ok");
			}
		};
		
		//Et ajoute l'écouteur de clique sur ces lampes
		for (int i=0;i<25;i++) {
			tabl[i].addMouseListener(souris);
		}
	}
	//gere l'allumage des lampes en forme de croix
	public void croix(Lumiere l) {
		int pos = l.getNum()-1;
		if(jouer) {
			((Lumiere) tabl[pos]).changeEtat();
			if(pos-5>-1) {
				((Lumiere) tabl[pos-5]).changeEtat();
			}
			if(pos+5<25) {
				((Lumiere) tabl[pos+5]).changeEtat();
			}
			if (pos!=0 && pos!=5 && pos!=10 && pos!=15 && pos!=20) {
				((Lumiere) tabl[pos-1]).changeEtat();
			}
			if (pos!=4 && pos!=9 && pos!=14 && pos!=19 && pos!=24) {
				((Lumiere) tabl[pos+1]).changeEtat();
			}
			nb++;
			txt.setText("Nb de déplacement\n"+nb);
			if(!PasVide()) {
				gagner();
			}
		}else if(config) {
			((Lumiere) tabl[pos]).changeEtat();
		}
	}
	
	//crée un G en vert
	public void gagner() {
		System.out.println("Gagné en " + nb + " coups");
		quitter();
		((Lumiere) tabl[1]).gagner();
		((Lumiere) tabl[2]).gagner();
		((Lumiere) tabl[3]).gagner();
		((Lumiere) tabl[4]).gagner();
		((Lumiere) tabl[5]).gagner();
		((Lumiere) tabl[10]).gagner();
		((Lumiere) tabl[15]).gagner();
		((Lumiere) tabl[21]).gagner();
		((Lumiere) tabl[22]).gagner();
		((Lumiere) tabl[23]).gagner();
		((Lumiere) tabl[19]).gagner();
		((Lumiere) tabl[13]).gagner();
		((Lumiere) tabl[12]).gagner();	
		TimerTask task = new TimerTask() {
			public void run() {
				quitter();			
			}		
		};
		
		Timer t = new Timer();
		t.schedule(task, 1500);
	}
	
	public void conf() {
		if (!jouer) {
			config = true;
			b1.setEnabled(false);
		}
	}
	
	//gère le bouton random en éteignant toute les lumière et en alumant 8 lumières différentes à des endroits aléatoire
	public void random() {
		int i =0;
		int pos;
		if(jouer==false) {
			for (int j=0;j<24;j++) {
				if (((Lumiere) tabl[j]).getEtat()) {
					((Lumiere) tabl[j]).changeEtat();
				}
			}
			while(i<8) {
				pos  = (int)(Math.random()*24);
				while (((Lumiere) tabl[pos]).getEtat()){
					pos  = (int)(Math.random()*24);
				}
				((Lumiere) tabl[pos]).changeEtat();
				i++;
			}
		}	
	}
	
	//gère le bouton jouer qui lance le jeu et permet de cliquer sur le JPanel
	public void jouer() {
		if(PasVide()) {
			jouer= true;
			b1.setEnabled(false);
			b2.setEnabled(false);
		}else System.out.println("|ERREUR|");
	}
	
	//permet de remettre la partie à 0 en éteignant les lampes et en remettant le compteur de déplacement à 0
	public void quitter() {
		nb=0;
		txt.setText("Nb de déplacement\n"+nb);
		for (int j=0;j<24;j++) {
			if (((Lumiere) tabl[j]).getEtat()) {
				((Lumiere) tabl[j]).changeEtat();
			}
			if (((Lumiere) tabl[j]).getCoul()==Color.green) {
				((Lumiere) tabl[j]).setCoul(Color.gray);
			}
		}
		jouer=false;
		config=false;
		b1.setEnabled(true);
		b2.setEnabled(true);
	}
	
	//verifie qu'il y a au moins une lampe allumer
	public boolean PasVide() {
		boolean v=false;
		int i=0;
		while (v == false && i<25) {
			if (((Lumiere) tabl[i]).getEtat()) {
				v = true;
			}
			i++;
		}
		return v;
	}
	
	

	//classe ecouteur bouton qui permet de gérer le clique sur un des 4 boutons
	private class EcouteurBouton implements ActionListener{
		public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		//Si on clique sur configurer
		if(source.equals(b1)) {
			try {
				conf();
			}catch(NumberFormatException m) {
				System.out.println("|ERREUR|");
			}
		}
		//Si on clique sur random
		if(source.equals(b2)) {
			try {
				random();
			}catch(NumberFormatException m) {
				System.out.println("|ERREUR|");
			}
		}
		//Si on clique sur jouer
		if(source.equals(b3)) {
			try {
				jouer();
			}catch(NumberFormatException m) {
				System.out.println("|ERREUR|");
			}
		}
		//Si on clique sur quitter
		if(source.equals(b4)) {
			try {
				quitter();
			}catch(NumberFormatException m) {
				System.out.println("|ERREUR|");
			}
		}
		}
	}
	
	//gere les clique sur les lampes
	public class EcouteurSouris extends MouseInputAdapter{
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);
			croix((Lumiere) e.getSource());
		}
	}

}