import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestGroupe {

    Groupe g;
    Formation f1, f2;
    Identite i1, i2, i3;
    Etudiant e1, e2, e3;
    boolean reussi;

    @Before
    public void init () {
        // formations
        this.f1 = new Formation("informatique");
        this.f2 = new Formation("Gestion");
        f1.ajouterMatiere("Maths", 1);
        f1.ajouterMatiere("Programmation", 1);

        // groupe
        this.g = new Groupe(f1);

        // etudiants
        this.i1 = new Identite("0001","Doe", "Jane");
        this.e1 = new Etudiant(i1, f1);

        this.i2 = new Identite("0002","Doe", "John");
        this.e2 = new Etudiant(i2, f1);

        this.i3 = new Identite("0003","Arlt", "Nathalie");
        this.e3 = new Etudiant(i3, f1);

        // notes
        this.e1.ajouterNote("Maths", 20);
        this.e3.ajouterNote("Programmation", 10);

        //
        this.reussi = this.g.ajouterEtudiant(e1);
        this.g.ajouterEtudiant(e3);
    }

    @Test
    /**
     * on ajoute un etudiant de formation f1 au groupe de formation f1 :l'ajout doit etre reussi
     */
    public void ajouterEtudiant () {
        assertTrue("le retour doit être vrai, l'ajout doit avoir été effectué", reussi);
        assertTrue("l'etudiant doit être dans la liste", g.getEtudiants().contains(e1) );
    }

    @Test
    /**
     * on ajoute un etudiant de formation f2 au groupe de formation f1 :l'ajout doit echouer
     */
    public void ajouterEtudiantEchec () {
        e2.setFormation(f2);
        this.reussi = this.g.ajouterEtudiant(e2);

        assertFalse("le retour doit etre faux, l'ajout ne doit pas avoir ete effectué", reussi);
        assertFalse("l'etudiant ne doit pas etre dans la liste", g.getEtudiants().contains(e2));
    }

    @Test
    /**
     * on supprime un etudiant de son groupe
     */
    public void supprimerEtudiant () {
        this.reussi = this.g.supprimerEtudiant(e1);

        assertTrue("le retour doit être vrai, la suppression doit avoir été effectué", reussi);
        assertFalse("l'etudiant ne doit plus être dans la liste", g.getEtudiants().contains(e1) );
    }

    @Test
    /**
     * on supprime un etudiant d'un groupe auquel il n'appartient pas
     */
    public void supprimerEtudiantEchec () {
        this.reussi = this.g.supprimerEtudiant(e2);

        assertFalse("le retour doit etre faux, la suppression ne doit pas avoir ete effectué", reussi);
    }

    @Test
    /**
     * on calcul la moyenne du groupe pour une matiere
     */
    public void calculerMoyenneMatiere () {
        e2.ajouterNote("Maths", 14);
        e2.ajouterNote("Maths", 18);
        // e2 a une moyenne de 16
        g.ajouterEtudiant(e2);
        float moy = g.calculerMoyenneMatiere("Maths");

        assertEquals("la moyenne doit être à 18: moyenne de 20 et 16", 18, moy, 0.01);
    }

    @Test
    /**
     * on calcul la moyenne générale du groupe
     */
    public void calculerMoyenneGen () {
        float moy = g.calculerMoyenneGen();

        // g comprend les étudiants e1 et e3
        // e1 a une moyenne de 20 en Maths -> moyenne gen = 20
        // e3 a une moyenne de 10 en programmation -> moyenne gen = 10

        assertEquals("la moyenne doit être égale à 15: moyenne de 20 et 10", 15, moy, 0.01);
    }

    @Test
    public void triAlpha () {
        g.ajouterEtudiant(e2);
        g.triAlpha();
        // 1 ere position Arlt Nathalie
        assertEquals(g.getEtudiants().get(0).getId().getNom(),e3.getId().getNom());
        // 2eme position Doe Jane
        assertEquals(g.getEtudiants().get(1).getId().getNom(),e1.getId().getNom());
        // 3eme position Doe John
        assertEquals(g.getEtudiants().get(2).getId().getNom(),e2.getId().getNom());
    }

    @Test
    public void triParMerite () {
        e2.ajouterNote("Maths", 0);
        e3.ajouterNote("Maths", 12);
        e2.ajouterNote("Programmation", 10);
        e1.ajouterNote("Programmation", 14);
        g.ajouterEtudiant(e2);
        g.triParMerite();
        // 1 ere position Doe Jane: moyenne gen de 17 (20 et 14)
        assertEquals(g.getEtudiants().get(0).getId().getNom(),e1.getId().getNom());
        // 2eme position Doe Jane: moyenne gen de 11 (10 et 12)
        assertEquals(g.getEtudiants().get(1).getId().getNom(),e3.getId().getNom());
        // 3eme position Doe John: moyenne gen de 5 (0 et 10)
        assertEquals(g.getEtudiants().get(2).getId().getNom(),e2.getId().getNom());
    }


}
