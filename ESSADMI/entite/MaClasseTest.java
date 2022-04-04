import junit.framework.*;

public static void main (string[] args){

public class MaClasseTest extends TestCase {
    
    private Personne personne ;


    public PersonneTest(String name) {
      this.name =name;

    }

    protected void setUp() throws Exception {
        super.setUp();
        personne = new Personne("nom1", "prenom1");
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        personne = null;
    }

    public void testPersonne() {
        assertNotNull("L'instance n'est pas créée", personne);
    }

    public void testGetNom() {
        assertEquals("Le nom est incorrect", "nom1", personne.getNom());
    }

    public void testGetPrenom() {
        assertEquals("Le prenom est incorrect", "prenom1", personne.getPrenom());
    }
}
}