import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe Req3 qui correspont a la requête de la question 3
 * @author lucas
 * 
 */

public class Req3 {

	Identifiant i = new Identifiant();

	/*
	 * On stock les informations à afficher dans un String
	 */

	private String res="";

	/**
	 * Requête effectué lors du clic sur le boutton "continuer" dans la classe Q3
	 * @throws Exception
	 */

	public Req3() throws Exception{

		/**
		 * Connection a la base de donnée grace aux identifiants
		 */

		Connection cnt = i.connect();

		/**
		 * Selectionne les nom des chercheurs
		 */

		PreparedStatement ps = cnt.prepareStatement("SELECT nomchercheur from Chercheur ");

		/**
		 * Selectionne par chercheur de la requête précédente, les laboratoire dans lequel le chercheur travail
		 */

		PreparedStatement ps2 = cnt.prepareStatement("Select Laboratoire.nomlabo from Laboratoire inner join Travailler on Laboratoire.nomlabo = Travailler.NomLabo inner join Chercheur on Travailler.Email = Chercheur.email where nomchercheur = ?");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			res+=rs.getString("nomchercheur")+":\n";
			ps2.setString(1,rs.getString("nomchercheur"));
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()){
				res+="-"+rs2.getString("nomlabo")+"\n";
			}
			res+="\n";
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

