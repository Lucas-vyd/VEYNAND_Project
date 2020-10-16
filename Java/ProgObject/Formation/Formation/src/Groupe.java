import java.util.*;

public class Groupe {

    /**
     * collection des etudiants du groupe
     */
	private List<Etudiant> etudiants;

    /**
     * formation du groupe
     */
	private Formation formation;

    /**
     * constructeur groupe 1 parametre
     * @param p_f formation a associer au groupe
     */
	public Groupe (Formation p_f) {
		this.etudiants = new ArrayList<Etudiant>();
		this.formation = p_f;
		}

    /**
     * méthode qui permet d'ajouter un etudiant si il est dans la meme formation que le groupe
     * @param p_etudiant  etudiant a ajouter
     * @return true si l'ajout est effectué
     */
	public boolean ajouterEtudiant(Etudiant p_etudiant) {
		if (!(this.etudiants.contains(p_etudiant))) {
			if(this.formation.equals(p_etudiant.getFormation())) {
                etudiants.add(p_etudiant);
                return true;
			} else {
                System.out.println("Etudiant invalide: l'etudiant n'a pas la meme formation que le groupe");
                return false;
            }
		} else {
            System.out.println("Etudiant invalide: l'etudiant existe deja dans le groupe");
		    return false;
        }
	}

    /**
     * méthode qui permet de supprimer un etudiant du groupe
     * @param p_etudiant etudiant à supprimer
     * @return true si la suppression est effectuée
     */
	public boolean supprimerEtudiant(Etudiant p_etudiant) {
	    if (this.etudiants.contains(p_etudiant)) {
            this.etudiants.remove(p_etudiant);
            return true;
        } else {
            System.out.println("Etudiant invalide: l'etudiant n'appartient pas au groupe");
            return false;
        }
	}

    /**
     * méthode qui calcule la moyenne de tous les étudiants dans une matière
     * @param p_matiere matiere dont on calcul la moyenne
     * @return moyenne
     */
	public float calculerMoyenneMatiere(String p_matiere) {
		float moyenne=0;
		int nbEtudiants=0;
		float note = 0;
		for (Etudiant e : etudiants) {
			if((note = e.calculerMoyenneMatiere(p_matiere)) != -1) {
				moyenne+= note;
				nbEtudiants++;
			}
		}
		return moyenne/nbEtudiants;
	}

    /**
     * methode qui calcul la moyenne generale du groupe
     * @return moyenne générale du groupe
     */
	public float calculerMoyenneGen() {
		float moyenne=0;
		for (Etudiant e : etudiants) {
			moyenne+= e.calculerMoyenneGen();
		}
		return moyenne/this.etudiants.size();
	}

	public void triAlpha () {
		Collections.sort(etudiants, new Comparator<Etudiant>() {
			@Override
			public int compare(Etudiant e1, Etudiant e2) {
				return e1.compareToAlpha(e2);
			}
		});
	}

	public void triParMerite () {
		Collections.sort(etudiants, new Comparator<Etudiant>() {
			@Override
			public int compare(Etudiant e1, Etudiant e2) {
				return e1.compareToMerite(e2);
			}
		});
	}

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }
}
