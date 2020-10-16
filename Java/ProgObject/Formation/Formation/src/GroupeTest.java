import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GroupeTest {
	
	Groupe g;
	Formation f1,f2;
	Etudiant e1,e2,e3;
	Identite i1,i2,i3;
	
	@Before
	public void init() {
		this.f1= new Formation("2nd");
		this.f2= new Formation("1ere");
		this.i1 = new Identite("01","VEYNAND","Lucas");
		this.i2 = new Identite("02","CARRIER","Liza");
		this.i3 = new Identite("03","TESTER","Test");
		this.e1 = new Etudiant(i1,f1);
		this.e2 = new Etudiant(i2,f1);
		this.g = new Groupe(f1);
		this.g.ajouterEtudiant(e1);
		this.g.ajouterEtudiant(e2);
	}
	
	@Test
	public void ajouterEtudiantReussi() {
		this.e3 = new Etudiant(i3,f1);
		this.g.ajouterEtudiant(e3);

		assertEquals("attendu true car 3 etudiant",g.getEtudiants().size()==3,true);
	}
	
	@Test
	public void ajouterEtudiantEchecEtudiantExiste() {
		this.g.ajouterEtudiant(e2);

		assertTrue("attendu true car 3eme etudiant existe deja",g.getEtudiants().size()==2);
	}
	
	@Test
	public void ajouterEtudiantEchecMauvaiseFormation() {
		this.e3 = new Etudiant(i3,f2);
		this.g.ajouterEtudiant(e3);

		assertTrue("attendu true car 2 etudiant n'as pas la bonne formation",g.getEtudiants().size()==2);
	}
	
	@Test
	public void supprimerEtudiantReussi() {
		assertTrue("attendu true ",this.g.supprimerEtudiant(e2));
		assertTrue("attendu true car 1 etudiant a été supprimé",g.getEtudiants().size()==1);
	}
	
	@Test
	public void supprimerEtudiantEchec() {
		assertFalse("attendu true ",this.g.supprimerEtudiant(e3));
		assertTrue("attendu true car aucun etudiant a été supprimé",g.getEtudiants().size()==2);
	}
	
	@Test
	public void calculerMoyenneMatiere() {
		f1.ajouterMatiere("Maths", 4);
		e1.ajouterNote("Maths", 10);
		e1.ajouterNote("Maths", 12);
		e2.ajouterNote("Maths", 8);
		assertTrue("La moyenne pour la matiere Math est de 9,5",g.calculerMoyenneMatiere("Maths")==9.5);
	}
	
	@Test
	public void calculerMoyenneGen() {
		f1.ajouterMatiere("Maths", 4);
		f1.ajouterMatiere("Francais", 2);
		e1.ajouterNote("Maths", 10);
		e1.ajouterNote("Maths", 12);
		e1.ajouterNote("Francais", 8);
		e2.ajouterNote("Maths", 12);
		e2.ajouterNote("Francais", 14);
		e2.ajouterNote("Francais", 16);
		assertTrue("La moyenne générale est de 11.5",g.calculerMoyenneGen()==11.5);
	}
	
	@Test
	public void trieAlpha() {
		this.e3 = new Etudiant(i3,f1);
		g.ajouterEtudiant(e3);
		g.triAlpha();
		assertTrue("attendu true car C avant T et V",g.getEtudiants().get(0)==e2);
		assertTrue("attendu true car T avant V",g.getEtudiants().get(1)==e3);
		assertTrue("attendu true car V en dernier",g.getEtudiants().get(2)==e1);
	}
	
	@Test
	public void trieParMerite() {
		this.e3 = new Etudiant(i3,f1);
		g.ajouterEtudiant(e3);
		f1.ajouterMatiere("Maths", 4);
		f1.ajouterMatiere("Francais", 2);
		e1.ajouterNote("Maths", 10);
		e1.ajouterNote("Maths", 12);
		e1.ajouterNote("Francais", 8);
		e2.ajouterNote("Maths", 12);
		e2.ajouterNote("Francais", 14);
		e2.ajouterNote("Francais", 16);
		e3.ajouterNote("Maths", 10);
		e3.ajouterNote("Francais", 18);
		e3.ajouterNote("Francais", 10);
		g.triParMerite();
		assertTrue("attendu true car 10 plus petit que 11.3 et 13",g.getEtudiants().get(0)==e1);
		assertTrue("attendu true car 11.3 plus petit que 13",g.getEtudiants().get(1)==e3);
		assertTrue("attendu true car 13 plus grand",g.getEtudiants().get(2)==e2);
	}
}
