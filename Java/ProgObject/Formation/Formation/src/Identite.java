public class Identite {

    /**
     * Numéro d'identification personnel, nom et prénom de l'etudiant
     */
    private String nip, nom, prenom;

    /**
     * constructeur 3 paramètres
     * @param nip
     * @param nom
     * @param prenom
     */
    public Identite (String nip, String nom, String prenom) {
        this.nip = nip;
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * getter
     * @return attribut nip
     */
    public String getNip() {
        return nip;
    }

    /**
     * getter
     * @return attribut nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * getter
     * @return attribut prénom
     */
    public String getPrenom() {
        return prenom;
    }
}
