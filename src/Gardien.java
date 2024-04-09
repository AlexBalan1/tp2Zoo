/**
 * La classe Gardien représente un gardien travaillant dans le zoo.
 */
public class Gardien {

    private int prochainId = 1000; // ID utilisé pour attribuer un identifiant unique à chaque gardien.

    private String nom; // Le nom du gardien.
    private int competence; // Le niveau de compétence du gardien.
    private int id; // L'identifiant unique du gardien.

    /**
     * Constructeur de la classe Gardien.
     *
     * @param nom         Le nom du gardien.
     * @param competence  Le niveau de compétence du gardien.
     */
    public Gardien(String nom, int competence) {
        this.nom = nom;
        this.competence = competence;
        this.id = prochainId++; // Attribution d'un nouvel identifiant unique à chaque instance de Gardien.
    }

    /**
     * Accesseur pour le nom du gardien.
     *
     * @return Le nom du gardien.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Mutateur pour définir le nom du gardien.
     *
     * @param nom Le nouveau nom du gardien.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Accesseur pour le niveau de compétence du gardien.
     *
     * @return Le niveau de compétence du gardien.
     */
    public int getCompetence() {
        return competence;
    }

    /**
     * Mutateur pour définir le niveau de compétence du gardien.
     *
     * @param competence Le nouveau niveau de compétence du gardien.
     */
    public void setCompetence(int competence) {
        this.competence = competence;
    }

    /**
     * Accesseur pour l'id unique du gardien.
     *
     * @return L'id unique du gardien.
     */
    public int getId() {
        return id;
    }

    /**
     * Mutateur pour définir l'id du gardien.
     *
     * @param id Le nouvel id du gardien.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Méthode pour entraîner un animal.
     *
     * @param animal L'animal à entraîner.
     * @param temps  Le temps d'entraînement en minutes.
     */
    public void entrainerAnimal(Animal animal, double temps) {
        if (temps < 10) {
            double nouveauPoids = animal.getPoids() * (1 + 0.01);
            animal.setPoids(nouveauPoids);
        } else if (temps >= 10 && temps < 30) {
            double nouveauPoids = animal.getPoids() * -0.02;
            animal.setPoids(nouveauPoids);
        } else {
            double nouveauPoids = animal.getPoids() * -0.05;
            animal.setPoids(nouveauPoids);
        }
    }

    /**
     * Méthode pour obtenir une représentation textuelle du gardien.
     *
     * @return Une chaîne représentant le gardien.
     */
    public String toString() {
        return "[" + nom + "  (" + id + ") " + competence + "]";
    }
}
