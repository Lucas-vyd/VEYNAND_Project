import java.sql.Connection;
import java.sql.Statement;

/**
 * Classe Req8CA qui correspont a une des requêtes de la question 8
 * @author lucas
 * 
 */

public class Req8CA {

	Identifiant i = new Identifiant();

	/**
	 * Requête effectué lors du clic sur le boutton "Créer A" dans la classe Q8
	 * @throws Exception
	 */

	public Req8CA() throws Exception{

		/**
		 * Connection à la base de donnée grace aux identifiants
		 */

		Connection cnt = i.connect();

		/**
		 * Créer un trigger "ver_ins_note" qui vérifie que lors de l'insertion d'une note, pour un certain article, la note n'est pas donné par un co-auteur de cet article
		 */
		Statement stmt = cnt.createStatement();
		stmt.execute("CREATE or replace TRIGGER ver_ins_note BEFORE " + 
				"Insert ON Noter " + 
				"for each row " + 
				"DECLARE " + 
				"    bool boolean; " + 
				"    V_Email Ecrire.email%type; " + 
				" " + 
				"    CURSOR Emailcherch IS " + 
				"        select email from Ecrire where titre =:new.titre; " + 
				" " + 
				"BEGIN " + 
				"    bool := false; " + 
				"OPEN Emailcherch ; " + 
				" " + 
				"LOOP " + 
				"FETCH Emailcherch INTO V_Email; " + 
				"EXIT WHEN NOT Emailcherch%FOUND; " + 
				" " + 
				"if (V_Email =:new.email) then " + 
				"    bool := true; " + 
				"end if; " + 
				" " + 
				"END LOOP; " + 
				"CLOSE Emailcherch ; " + 
				" " + 
				"    if(bool) then " + 
				"       dbms_output.put_line('Le chercheur qui veut inserer une note est un co-auteur de l''article'); " + 
				"       else dbms_output.put_line('Le chercheur qui veut inserer une note n''est pas un co-auteur de l''article'); " + 
				"    end if; " + 
				" " + 
				"END;");
		cnt.close();

	}

}
