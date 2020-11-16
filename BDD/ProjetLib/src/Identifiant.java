import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classe pour se connecter à la base de donnée
 * @author lucas
 *
 */

public class Identifiant {
	
	/**
	 * on stock l'url, le login et le mot de passe sous forme de String afin de se connecter
	 */
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String Login="";
	private static String MDP="";
	
	/**
	 * Methode pour se connecter à la base de donnée
	 * @return
	 * @throws SQLException
	 */
	
	public Connection connect() throws SQLException {
		Connection cnt = DriverManager.getConnection(url,this.getLogin(), this.getMDP());
		return cnt;
	}
	
	/**
	 * Méthode pour récuperer le login
	 * @return
	 */
	
	public String getLogin() {
		return Identifiant.Login;
	}
	
	/**
	 * Méthode pour récuperer le mot de passe
	 * @return
	 */
	
	public String getMDP() {
		return Identifiant.MDP;
	}
	
	/**
	 * Méthode pour stocker le login
	 * @param l
	 */
	
	public void setLogin(String l) {
		Identifiant.Login = l;
	}
	
	/**
	 * Méthode pour stocker le mot de passe
	 * @param m
	 */
	
	public void setMDP(String m) {
		Identifiant.MDP=m;
	}
}
