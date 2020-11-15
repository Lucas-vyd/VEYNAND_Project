import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe Req4 qui correspont a la requête de la question 4
 * @author lucas
 * 
 */

public class Req4 {

	Identifiant i = new Identifiant();

	/*
	 * On stock les informations à afficher dans un String
	 */

	private String res="";

	/**
	 * Requête effectué lors du clic sur le boutton "continuer" dans la classe Q4
	 * @param param
	 * @throws Exception
	 */

	public Req4(Integer param) throws Exception{

		/**
		 * Connection a la base de donnée grace aux identifiants
		 */

		Connection cnt = i.connect();

		/**
		 * Selectionne les chercheurs qui ont écrit au moins "param" titre
		 */

		PreparedStatement ps = cnt.prepareStatement("select nomchercheur from Chercheur inner join Annoter on Chercheur.email = Annoter.email group by nomchercheur having count(Annoter.email)>= ?");
		ps.setInt(1,param);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			res+=rs.getString("NomChercheur")+"\n";
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