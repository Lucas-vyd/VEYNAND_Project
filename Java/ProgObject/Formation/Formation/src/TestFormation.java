import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class TestFormation {

    HashMap<String, Integer> matieres;
    Formation form;

    @Before
    public void init () {
        form = new Formation("informatique");
        form.ajouterMatiere("Maths", 4);
    }

    @Test
    public void ajouterMatiere () {
        matieres = (HashMap) form.getMatieres();
        assertTrue("la matiere Maths doit être ajoutée à la formation", matieres.containsKey("Maths") );
    }

    @Test
    public void supprimerMatiere () {
        form.supprimerMatiere("Maths");
        matieres = (HashMap) form.getMatieres();
        assertFalse("la matiere Maths ne doit plus être dans la formation", matieres.containsKey("Maths"));
    }

    @Test
    public void getCoeffMatiereExistante () {
        assertEquals("la matiere Maths a un coeff de 4", form.getCoeff("Maths"), 4);
    }

    @Test
    public void getCoeffMatiereInexistante () {
        assertEquals("La matière Francais n'existe pas: coeff 0", form.getCoeff("Francais"), 0);
    }


}
