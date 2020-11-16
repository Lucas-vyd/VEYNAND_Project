import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe Req5 qui correspont a la requête de la question 5
 * @author lucas
 * 
 */

public class Req5 {

	Identifiant i = new Identifiant();

	/*
	 * On stock les informations à afficher dans un String
	 */

	private String res="";

	/**
	 * Requête effectué lors du clic sur le boutton "continuer" dans la classe Q5
	 * @param param
	 * @throws Exception
	 */

	public Req5(String param) throws Exception{

		/**
		 * Connection a la base de donnée grace aux identifiants
		 */

		Connection cnt = i.connect();

		/**
		 * Selectionne la moyenne des notes que le chercheur "param" à attribué
		 */

		PreparedStatement ps = cnt.prepareStatement("select avg(note) as moy from Noter inner join Chercheur on Noter.email = Chercheur.email where nomchercheur= ?");
		ps.setString(1,param);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			res+="La moyenne des notes qui ont été attibué par "+param+" est de :\n"+rs.getDouble("moy")+"\n";
		}
		ps.close();
		rs.close();
		cnt.close();	
	}

	/**
	 * Méthode qui retourne le résultat de la requête
	 * @return
	 */

	public String getRes() {
		return res;
	}

}
