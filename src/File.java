/**
 * La classe File représente une structure de données de type file utilisée pour stocker les visiteurs.
 */
public class File {

    // Première référence dans la file
    private Noeud premier;
    // Nombre d'éléments dans la file
    private int nbElements;

    /**
     * Constructeur de la classe File.
     * Initialise la file en tant que vide.
     */
    public File() {
        premier = null;
        nbElements = 0;
    }

    // Accesseurs et mutateurs pour les variables membres

    /**
     * Accesseur pour le premier élément de la file.
     * @return Le premier élément de la file.
     */
    public Noeud getPremier() {
        return premier;
    }

    /**
     * Mutateur pour le premier élément de la file.
     * @param premier Le nouveau premier élément de la file.
     */
    public void setPremier(Noeud premier) {
        this.premier = premier;
    }

    /**
     * Accesseur pour le nombre d'éléments dans la file.
     * @return Le nombre d'éléments dans la file.
     */
    public int getNbElements() {
        return nbElements;
    }

    /**
     * Mutateur pour le nombre d'éléments dans la file.
     * @param nbElements Le nouveau nombre d'éléments dans la file.
     */
    public void setNbElements(int nbElements) {
        this.nbElements = nbElements;
    }

    // Méthodes de la classe File

    /**
     * Vérifie si la file est vide.
     * @return true si la file est vide, sinon false.
     */
    public boolean estVide() {
        return premier == null;
    }

    /**
     * Ajoute un visiteur à la file à la position spécifiée.
     * @param visiteur Le visiteur à ajouter.
     * @param position La position à laquelle ajouter le visiteur.
     */
    public void enfiler(Visiteur visiteur, int position) {
        // Vérifier si la position est valide
        if (position < 0 || position > nbElements) {
            System.out.println("Position invalide.");
            return;
        }

        // Création d'un nouveau nœud contenant le visiteur
        Noeud nouveau = new Noeud(visiteur, null);

        // Cas où la file est vide ou la position est 0
        if (position == 0) {
            nouveau.setProchain(premier);
            premier = nouveau;
        } else {
            // Parcourir la file jusqu'à la position spécifiée
            Noeud precedent = null;
            Noeud courant = premier;
            int index = 0;

            while (index < position) {
                precedent = courant;
                courant = courant.getProchain();
                index++;
            }

            // Insérer le nouveau nœud entre le nœud précédent et le nœud courant
            precedent.setProchain(nouveau);
            nouveau.setProchain(courant);
        }

        // Incrémenter le nombre d'éléments dans la file
        nbElements++;
    }

    /**
     * Retire et renvoie le premier visiteur de la file.
     * @return Le premier visiteur de la file, ou null si la file est vide.
     */
    public Visiteur defiler() {
        // Vérifier si la file est vide
        if (estVide()) {
            System.out.println("La file est vide.");
            return null;
        }

        // Retirer et renvoyer le premier visiteur de la file
        Visiteur visiteur = premier.getValeur();
        premier = premier.getProchain();
        nbElements--;
        return visiteur;
    }

    /**
     * Méthode pour représenter la file sous forme de chaîne de caractères.
     * @return La représentation de la file sous forme de chaîne de caractères.
     */
    public String toString() {
        // Vérifier si la file est vide
        if (estVide()) {
            return "[]";
        }

        // Initialisation de la représentation de la file
        String file = nbElements + " visiteurs ";
        Noeud courant = premier;

        // Parcourir la file et ajouter chaque visiteur
        while (courant != null) {
            file += courant.toString();
            courant = courant.getProchain();
            if (courant != null) {
                file += " -> ";
            }
        }

        return file;
    }
}
