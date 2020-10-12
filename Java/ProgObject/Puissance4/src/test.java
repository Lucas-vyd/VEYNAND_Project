package Puissance4;


public class test{
	
	public static void main(String args[]) {
		Grille c = new Grille();
		Colonne Col0=new Colonne("Col0");
		Colonne Col1=new Colonne("Col1");
		Colonne Col2=new Colonne("Col2");
		Colonne Col3=new Colonne("Col3");
		Colonne Col4=new Colonne("Col4");
		Colonne Col5=new Colonne("Col5");
		Colonne Col12=new Colonne("Col12");
		Colonne Col6=new Colonne("Col6");
		Colonne Col7=new Colonne("Col7");
		c.set(0, Col0);
		c.set(1, Col1);
		c.set(2, Col2);
		c.set(3, Col3);
		c.set(4, Col4);
		c.set(12, Col12);
		c.set(6, Col6);
		c.set(7, Col7);
		c.set(5, Col5);
		Jeton e = new Jeton(1);
		c.ajouter(5,e);
		Jeton ef = new Jeton(2);
		c.ajouter(1,ef);
		Jeton efk = new Jeton(1);
		c.ajouter(1,efk);
		Jeton efky = new Jeton(1);
		c.ajouter(5,efky);
		Jeton efkyi = new Jeton(2);
		c.ajouter(0,efkyi);
		Jeton ekyi = new Jeton(2);
		c.ajouter(5,ekyi);
		Jeton fkyi = new Jeton(1);
		c.ajouter(0,fkyi);
		Jeton fyi = new Jeton(1);
		c.ajouter(4,fyi);
		Jeton ppatat = new Jeton(1);
		c.ajouter(3,ppatat);
		Jeton aat = new Jeton(1);
		c.ajouter(7,aat);
		Jeton zaat = new Jeton(1);
		c.ajouter(7,zaat);
		Jeton ppaat = new Jeton(2);
		c.ajouter(7,ppaat);
		
		Jeton pazt = new Jeton(2);
		c.ajouter(6,pazt);
		Jeton pat = new Jeton(1);
		c.ajouter(6,pat);
		Jeton ppat = new Jeton(1);
		c.ajouter(6,ppat);
		Jeton ppt = new Jeton(2);
		c.ajouter(6,ppt);
		
		Jeton pzt = new Jeton(1);
		c.ajouter(5,pzt);
		Jeton pa = new Jeton(2);
		c.ajouter(5,pa);
		
		Jeton y = new Jeton(2);
		c.ajouter(8,y);
		Jeton ya = new Jeton(2);
		c.ajouter(8,ya);


		
		System.out.println("elem 1 col0 : " +Col0.getElem(0));
		System.out.println("nbr elem col0 : " +Col0.getNbrElem());
		System.out.println("nbr elem col1 : " +Col1.getNbrElem());
		System.out.println("nbr elem col2 : " +Col2.getNbrElem());
		System.out.println("col max : "+c.getNbrMax());
		System.out.println(c.retCol(2).getElem(1));
		System.out.println(c);
		c.sauvegarder();
		System.out.println(c.restaurer());
		if(c.victoire()==true) {
			System.out.println("gagne");
		}else {
			System.out.println("pas encore");
		}
		
		
	}
}
