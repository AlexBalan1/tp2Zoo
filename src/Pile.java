public class Pile {
    private static final int TAILLE_INITIALE = 4;
    private static final int RATIO_AGRANDISSEMENT = 2;

    private Gardien[] tableauGardiens;
    private int nbElements;
    private int capacite;

    // Constructeur
    public Pile() {
        tableauGardiens = new Gardien[TAILLE_INITIALE];
        nbElements = 0;
        capacite = TAILLE_INITIALE;
    }

    // Accesseurs
    public Gardien[] getTableauGardiens() {
        return tableauGardiens;
    }

    public void setTableauGardiens(Gardien[] tableauGardiens) {
        this.tableauGardiens = tableauGardiens;
    }

    public int getNbElements() {
        return nbElements;
    }

    public void setNbElements(int nbElements) {
        this.nbElements = nbElements;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    // Méthode pour empiler un gardien dans la pile
    public void empiler(Gardien gardien) {

        if (nbElements == capacite) {

            capacite *= RATIO_AGRANDISSEMENT;
            Gardien[] nouveauTableau = new Gardien[capacite];

            for(int i = 0; i < nbElements; i++) {
                nouveauTableau[i] = tableauGardiens[i];
            }
            tableauGardiens = nouveauTableau;
        }


        tableauGardiens[nbElements++] = gardien;
    }

    // Méthode pour dépiler un gardien de la pile
    public Gardien depiler() {
        if (nbElements == 0) {
            System.out.println("La pile est vide.");
            return null;
        }

        Gardien gardienDepile = tableauGardiens[--nbElements];
        tableauGardiens[nbElements] = null;
        return gardienDepile;
    }
}