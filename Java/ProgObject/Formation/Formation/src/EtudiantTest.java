import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class EtudiantTest {
	
	Identite i;
	Formation f;
	Etudiant etu;
	
	/**
	 * initalisation en vue de faire les tests
	 */
	@Before
	public void init() {
		i = new Identite("001","Lucas","Veynand");
		f = new Formation("2nd");
		f.ajouterMatiere("Maths", 4);
		f.ajouterMatiere("Francais", 2);
		etu = new Etudiant(i,f);
		etu.ajouterNote("Maths", 10);
	}
	
	/**
	 * test de l'ajout d'une note qui reussi
	 */
	@Test
	public void AjoutNoteReussi() {
		List test = new ArrayList<Float>();
		test.add((float)8);

		assertTrue("attendu true car ajout reussi",etu.ajouterNote("Francais", (float)8));
		assertEquals("Probleme d'ajout",etu.getResultats().get("Francais"),test);
	}
	
	/**
	 * test de l'ajout d'une note dans une matiere qui existe deja
	 */
	@Test
	public void AjoutNoteReussiAvecNoteExistante() {
		List test = new ArrayList<Float>();
		test.add((float)10);
		test.add((float)18);

		assertTrue("attendu true car ajout reussi",etu.ajouterNote("Maths", (float)18));
		assertEquals("Probleme d'ajout",etu.getResultats().get("Maths"),test);
	}
	
	/**
	 * test ajout d'une note qui sort de la limite 20
	 */
	@Test
	public void AjoutNoteErreurLimite() {
		assertFalse("Attendu false pour ajout note > 20", etu.ajouterNote("Francais", 28));
	}
	
	/**
	 * test de l'ajout d'une note qui echoue car la matiere n'existe pas
	 */
	@Test
	public void AjoutNoteErreurMatiere() {
		assertFalse("Attendu false pour ajout a une matiere inexistante", etu.ajouterNote("SVT", 14));
	}
	
	/**
	 * test du calcul de la moyenne qui reussi
	 */
	@Test
	public void CalculerMoyenneMatiereReussi() {
		etu.ajouterNote("Maths", 5);
		float moy = etu.calculerMoyenneMatiere("Maths");

		assertEquals("Attendu moyenne 7.5 car 2 notes (5 et 10)", moy,7.5, 0.01);
	}
	
	/**
	 * test du calcul de la moyenne qui echoue car la matiere n'existe pas 
	 */
	@Test
	public void CalculerMoyenneMatiereErreurMatiere() {
		float moy = etu.calculerMoyenneMatiere("SVT");

		assertEquals("Attendu -1 car moyenne inexistante", moy,-1.0, 0.01);
	}
	
	/**
	 * test du calcul de la moyenne qui echoue car il n'y a pas de notes
	 */
	@Test
	public void CalculerMoyenneMatiereErreurNote() {
		float moy = etu.calculerMoyenneMatiere("Francais");

		assertEquals("Attendu -1 car pas de notes pour cette matière", moy,-1.0, 0.01);
	}
	
	/**
	 * test le calcul de la moyenne general
	 */
	@Test
	public void CalculerMoyenneGeneral() {
		etu.ajouterNote("Maths", 5);
		etu.ajouterNote("Francais", 15);
		float moy = etu.calculerMoyenneGen();

		assertEquals("Attendu moyenne 10: 7.5 coeff 4 en Maths et 15 coeff 2 en Fr", moy,10.0, 0.01);
	}



}
