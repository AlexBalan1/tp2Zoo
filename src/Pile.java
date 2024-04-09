/**
 * La classe Pile représente une structure de données de type pile utilisée pour stocker des gardiens.
 */
public class Pile {
    // Taille initiale de la pile
    private static final int TAILLE_INITIALE = 4;
    // Ratio d'agrandissement de la pile lorsqu'elle atteint sa capacité maximale
    private static final int RATIO_AGRANDISSEMENT = 2;

    // Tableau contenant les gardiens de la pile
    private Gardien[] tableauGardiens;
    // Nombre d'éléments actuellement présents dans la pile
    private int nbElements;
    // Capacité maximale de la pile
    private int capacite;

    /**
     * Constructeur de la classe Pile.
     * Initialise la pile avec une taille initiale prédéfinie.
     */
    public Pile() {
        tableauGardiens = new Gardien[TAILLE_INITIALE];
        nbElements = 0;
        capacite = TAILLE_INITIALE;
    }

    // Accesseurs et mutateurs pour les variables membres

    /**
     * Accesseur pour le tableau de gardiens.
     * @return Le tableau de gardiens.
     */
    public Gardien[] getTableauGardiens() {
        return tableauGardiens;
    }

    /**
     * Mutateur pour le tableau de gardiens.
     * @param tableauGardiens Le nouveau tableau de gardiens.
     */
    public void setTableauGardiens(Gardien[] tableauGardiens) {
        this.tableauGardiens = tableauGardiens;
    }

    /**
     * Accesseur pour le nombre d'éléments dans la pile.
     * @return Le nombre d'éléments dans la pile.
     */
    public int getNbElements() {
        return nbElements;
    }

    /**
     * Mutateur pour le nombre d'éléments dans la pile.
     * @param nbElements Le nouveau nombre d'éléments dans la pile.
     */
    public void setNbElements(int nbElements) {
        this.nbElements = nbElements;
    }

    /**
     * Accesseur pour la capacité maximale de la pile.
     * @return La capacité maximale de la pile.
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     * Mutateur pour la capacité maximale de la pile.
     * @param capacite La nouvelle capacité maximale de la pile.
     */
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    // Méthodes de la classe Pile

    /**
     * Méthode pour empiler un gardien dans la pile.
     * @param gardien Le gardien à empiler.
     */
    public void empiler(Gardien gardien) {
        // Si la pile est pleine, agrandir le tableau
        if (nbElements == capacite) {
            capacite *= RATIO_AGRANDISSEMENT;
            // Création d'un nouveau tableau de gardiens avec la nouvelle capacité
            Gardien[] nouveauTableau = new Gardien[capacite];
            // Copie des éléments du tableau actuel vers le nouveau tableau
            for (int i = 0; i < tableauGardiens.length; i++) {
                nouveauTableau[i] = tableauGardiens[i];
            }
            // Remplacement du tableau actuel par le nouveau tableau
            tableauGardiens = nouveauTableau;
        }
        // Ajout du gardien à la pile
        tableauGardiens[nbElements++] = gardien;
    }

    /**
     * Méthode pour dépiler un gardien de la pile.
     * @return Le gardien dépilé, ou null si la pile est vide.
     */
    public Gardien depiler() {
        // Vérifier si la pile est vide
        if (nbElements == 0) {
            System.out.println("La pile est vide.");
            return null;
        }
        // Retirer et renvoyer le gardien au sommet de la pile
        Gardien gardienDepile = tableauGardiens[--nbElements];
        tableauGardiens[nbElements] = null; // Libérer la référence au gardien dépilé
        return gardienDepile;
    }

    /**
     * Méthode pour représenter la pile sous forme de String.
     * @return La représentation de la pile sous forme de chaîne de caractères.
     */
    public String toString() {
        // Initialisation de la représentation de la pile
        String laPile = nbElements + " gardiens " + "(capacité " + capacite + "): ";
        // Parcourir le tableau de gardiens et ajouter chaque gardien
        for (int i = 0; i < tableauGardiens.length; i++) {
            if (tableauGardiens[i] != null) {
                laPile += "[" + tableauGardiens[i].getNom() + "  (" + tableauGardiens[i].getId() + ") "
                        + tableauGardiens[i].getCompetence() + "]";
            }
        }
        return laPile;
    }
}
