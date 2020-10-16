import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Formation {
	
	/**
	 * 
	 */
	private String id;
	private Map<String, Integer> matieres;
	
	/**
	 * constructeur 1 paramètres
	 * @param p_id
	 */
	public Formation (String p_id) {
        this.id = p_id;
        this.matieres = new HashMap<String, Integer>();
    }
	
	/**
	 * methode d'ajout d'une matiere dans la formation
	 * @param p_matiere
	 * @param p_coeff
	 */
	public void ajouterMatiere(String p_matiere, int p_coeff) {
		if (!(this.matieres.containsKey(p_matiere)))
			matieres.put(p_matiere,p_coeff);
	}
	
	/**
	 * methode de supression d'une matiere dans la formation
	 * @param p_matiere
	 */
	public void supprimerMatiere(String p_matiere) {
		this.matieres.remove(p_matiere);
	}
	
	/**
	 * getter
	 * @param p_matiere
	 * @return le coefficient
	 */
	public int getCoeff(String p_matiere) {
		if (this.matieres.containsKey(p_matiere))
			return matieres.get(p_matiere);
		return 0;
	}
	/**
	 * getter
	 * @return les matieres avec leurs coeffs
	 */
	public Map<String, Integer> getMatieres() {
		return this.matieres;
	}
}
