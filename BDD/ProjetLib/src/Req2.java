import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe Req2 qui correspont a la requête de la question 2
 * @author lucas
 * 
 */

public class Req2 {

	Identifiant i = new Identifiant();

	/*
	 * On stock les informations à afficher dans un String
	 */

	private String res="";

	/**
	 * Requête effectué lors du clic sur le boutton "continuer" dans la classe Q2
	 * @param param
	 * @throws Exception
	 */

	public Req2(String param) throws Exception{

		/**
		 * Connection a la base de donnée grace aux identifiants
		 */

		Connection cnt = i.connect();

		/**
		 * Selectionne les titres quand le nom du chercheur correspond au paramètre "param"
		 */

		PreparedStatement ps = cnt.prepareStatement("select titre from Ecrire inner join Chercheur on Ecrire.Email = Chercheur.email where nomchercheur=?");
		
		/**
		 * Selectionne les noms des chercheurs quand l'auteur ne correpond pas à "param" et que le titre correspond au titre de la requête précédente
		 */
		
		PreparedStatement ps2 = cnt.prepareStatement("select distinct nomchercheur from Chercheur inner join Ecrire on Chercheur.email = Ecrire.Email where Titre = ? and nomchercheur != ?");
		ps.setString(1,param);
		ResultSet rs = ps.executeQuery();
		res+= "Liste des auteur ayant travaillé avec " + param + " :\n";
		while(rs.next()){
			ps2.setString(1,rs.getString("Titre"));
			ps2.setString(2,param);
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()){
				res+="-"+rs2.getString("nomchercheur")+"\n";
			}
			rs2.close();
		}
		ps.close();
		ps2.close();
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
