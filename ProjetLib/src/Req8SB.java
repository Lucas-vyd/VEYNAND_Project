import java.sql.Connection;
import java.sql.Statement;

/**
 * Classe Req8SB qui correspont a une des requêtes de la question 8
 * @author lucas
 * 
 */

public class Req8SB {
	
	Identifiant i = new Identifiant();

	/**
	 * Requête effectué lors du clic sur le boutton "Supprimer B" dans la classe Q8
	 * @throws Exception
	 */
	
	public Req8SB() throws Exception{

		/**
		 * Connection à la base de donnée grace aux identifiants
		 */

		Connection cnt = i.connect();

		/**
		 * Supprime le trigger "enr_log"
		 */
		
		Statement stmt = cnt.createStatement();
	    stmt.execute("drop trigger enr_log");
	    cnt.close();

	}
	
}
