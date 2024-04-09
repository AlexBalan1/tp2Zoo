import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TesterFile {
    @Test
    public void testArriveeVisiteur() {

        Zoo zoo = new Zoo("zoo");


        Visiteur jeune = new Visiteur("a", 20, new String[]{"a", "a"});
        Visiteur age = new Visiteur("b", 70, new String[]{"a", "a"});


        zoo.arriveeVisiteur(jeune);
        zoo.arriveeVisiteur(age);


        assertEquals(age, zoo.getFileVisiteurs().getPremier().getValeur());
    }


}
