import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etudiant {

    /**
     * identité de l'étudiant
     */
    private Identite id;

    /**
     * Collection qui associe une matière(clé) à une liste de notes(valeur)
     */
    private Map<String, List<Float>> resultats;

    /**
     * formation de l'étudiant
     */
    private Formation formation;

    /**
     * constructeur etudiant 2 paramètres
     * @param p_id identité
     * @param p_f formation
     */
    public Etudiant (Identite p_id, Formation p_f) {
        this.formation = p_f;
        this.id = p_id;
        this.resultats = new HashMap<String, List<Float>>();
    }

    /**
     * méthode qui permet d'ajouter une note à un étudiant
     * @param p_matiere matière à laquelle la note est associée
     * @param p_note note de l'étudiant
     * @return vrai si l'opération s'est correctement effectuée, sinon faux
     */
    public boolean ajouterNote(String p_matiere, float p_note) {
        // on gere les 2 cas d'erreur
        if (p_note < 0 || p_note > 20) {
            System.out.println("Note incorrecte: doit être comprise entre 0 et 20 inclus");
            return false;
        } else if (!this.formation.getMatieres().containsKey(p_matiere)) {
            System.out.println("Matiere incorrecte: la matière n'est pas dans la formation de l'étudiant");
            return false;
        } else {
            // on gere les 2 cas ou les paramètres sont cohérents
            List lNotes = new ArrayList<Float>();
            if ( this.resultats.containsKey(p_matiere)) {
                // si la matière existe deja dans la collection de résultats, on ajoute la note à la liste de notes qui correspond à la matière
                lNotes = this.resultats.get(p_matiere);
                lNotes.add(p_note);
            } else {
                // sinon on créé la liste de notes et on l'ajoute à la collection de résultats
                lNotes.add(p_note);
                this.resultats.put(p_matiere, lNotes);
            }
        }
        return true;
    }

    /**
     * méthode qui permet de calculer la moyenne par matière
     * @param p_matiere matière dont on souhaite calculer la moyenne
     * @return moyenne, -1 si erreur
     */
    public float calculerMoyenneMatiere (String p_matiere) {
        float moyenne = 0;
        // on gere les 2 cas d'erreur
        if (!this.resultats.containsKey(p_matiere)) {
            System.out.println("Matière incorrecte: l'étudiant ne possède aucune note pour cette matière");
            return -1;
        } else if (!this.formation.getMatieres().containsKey(p_matiere)) {
            System.out.println("Matière incorrecte: l'étudiant ne possède pas cette matière");
            return -1;
        } else {
            // sinon on calcul la moyenne de la matière
            int nbNotes = this.resultats.get(p_matiere).size();
            for (Float note : this.resultats.get(p_matiere)) {
                moyenne += note;
            }
            moyenne = moyenne/nbNotes;
        }
        return moyenne;
    }

    /**
     * méthode qui permet de calculer la moyenne générale de l'étudiant
     * @return moyenne générale
     */
    public float calculerMoyenneGen () {
        int coeffTotal = 0, coeff = 0;
        float moyenne = 0;
        for (String matiere : this.resultats.keySet()) {
            coeff = this.formation.getCoeff(matiere);
            coeffTotal += coeff;
            moyenne += calculerMoyenneMatiere(matiere) * coeff;
        }
        moyenne = moyenne / coeffTotal;
        return moyenne;
    }

    /**
     * méthode qui compare les noms prénoms des etudiants:
     * @param o etudiant à comparer
     * @return
     * positif si cette instance est supérieure à l'argument
     * negatif si cette instance est inferieure à l'argument
     * 0 si noms et prenoms egaux
     */
    public int compareToAlpha (Object o) {
        Etudiant e1 = (Etudiant) this;
        Etudiant e2 = (Etudiant) o;
        String nom1 = e1.id.getNom();
        String nom2 = e2.id.getNom();
        String prenom1 = e1.id.getPrenom();
        String prenom2 = e2.id.getPrenom();
        // si les noms sont pareils on compare les prénoms
        if (nom1.equals(nom2)) {
            return prenom1.compareTo(prenom2);
        } else {
            // sinon on compare les noms
            return nom1.compareTo(nom2);
        }
    }

    /**
     * méthode qui compare les moyennes générales des etudiants
     * @param o etudiant a comparer
     * @return
     * positif si cette instance est supérieure à l'argument
     * negatif si cette instance est inferieure à l'argument
     * 0 si noms et prenoms egaux
     */
    public int compareToMerite (Object o ) {
        Etudiant e1 = (Etudiant) this;
        Etudiant e2 = (Etudiant) o;
        float moy1 = e1.calculerMoyenneGen();
        float moy2 = e2.calculerMoyenneGen();
        if (moy1 > moy2) {
            return 1;
        } else if (moy1 < moy2) {
            return -1;
        } else {
            return 0;
        }
    }
    
    /**
     * getter
     * @return la liste de note par matiere
     */
    public Map<String, List<Float>> getResultats() {
    	return resultats;
    }

    public Formation getFormation() {
        return formation;
    }

    public Identite getId() {
        return id;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
