import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe Req1 qui correspont a la requête de la question 1
 * @author lucas
 * 
 */

public class Req1 {
	
	Identifiant i = new Identifiant();
	
	/*
	 * On stock les informations à afficher dans un String
	 */
	
	private String res="";
	
	/**
	 * Requête effectué lors du clic sur le boutton "continuer" dans la classe Q1
	 * @param param
	 * @throws Exception
	 */
	
	public Req1(String param) throws Exception{
		
		/**
		 * Connection a la base de donnée grace aux identifiants
		 */
		
		Connection cnt = i.connect();
		
		/**
		 * Selectionne les titres quand le nom du chercheur correspond au paramètre "param"
		 */
		
		PreparedStatement ps = cnt.prepareStatement("select titre from ecrire inner join Chercheur on Ecrire.Email = Chercheur.email where nomchercheur = ?");
		ps.setString(1,param);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			res+=rs.getString("Titre")+"\n";
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
