import java.sql.Connection;
import java.sql.Statement;

/**
 * Classe Req8CB qui correspont a une des requêtes de la question 8
 * @author lucas
 * 
 */

public class Req8CB {

	Identifiant i = new Identifiant();

	/**
	 * Requête effectué lors du clic sur le boutton "Créer B" dans la classe Q8
	 * @throws Exception
	 */

	public Req8CB() throws Exception{

		/**
		 * Connection à la base de donnée grace aux identifiants
		 */

		Connection cnt = i.connect();

		/**
		 * Créer un trigger "enr_log" qui enregistre dans la table "log_chercheurs" l'utilisateur, la date du systeme 
		 * ainsi que le type de l'action effectué lors d'une insertion ou une mise-à-jour de la table annoter
		 */

		Statement stmt = cnt.createStatement();
		stmt.execute("CREATE or replace TRIGGER enr_log BEFORE " + 
				"Insert or update ON Annoter " + 
				"for each row " + 
				" " + 
				"BEGIN " + 
				"    if inserting then " + 
				"        insert into log_chercheur values (:new.email,SYSDATE, 'Inserer'); " + 
				"    end if; " + 
				"    if updating then " + 
				"        insert into log_chercheur values (:new.email,SYSDATE, 'Modifier'); " + 
				"    end if; " + 
				"END;");
		cnt.close();

	}

}