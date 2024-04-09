import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TesterPile {
    @Test
    public void testAjouterGardien_AjoutGardienDansEnclosSansGardien() {
        // Création d'un zoo
        Zoo zoo = new Zoo("Mon Zoo");

        // Création de gardiens
        Gardien gardien1 = new Gardien("a", 30);
        Gardien gardien2 = new Gardien("b", 25);

        // Création d'enclos avec et sans gardien
        Enclos enclos1 = new Enclos("a", 5, null, null);
        Enclos enclos2 = new Enclos("b", 5, null, null);
        Enclos enclos3 = new Enclos("c", 5, null, null);

        // Ajout des enclos au zoo
        zoo.ajouterEnclos(new Enclos[]{enclos1, enclos2, enclos3});


        zoo.ajouterGardien(gardien2);
        zoo.ajouterGardien(gardien1);


        assertEquals(gardien1, enclos1.getGardien());
    }


}
