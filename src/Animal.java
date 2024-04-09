/**
 * La classe Animal représente un animal dans un zoo.
 */
public class Animal {

    private String nom;
    private String regimeAlimentaire;
    private double poids;
    private Classe classe;
    private String espece;
    private double besoinAlimentaire;

    /**
     * Constructeur de la classe Animal.
     * @param nom Le nom de l'animal.
     * @param regimeAlimentaire Le régime alimentaire de l'animal.
     * @param poids Le poids de l'animal.
     * @param classe La classe de l'animal.
     * @param espece L'espèce de l'animal.
     */
    public Animal(String nom, String regimeAlimentaire, double poids, Classe classe, String espece) {
        this.nom = nom;
        this.regimeAlimentaire = regimeAlimentaire;
        this.poids = poids;
        this.classe = classe;
        this.espece = espece;
    }

    /**
     * Méthode pour obtenir le nom de l'animal.
     * @return Le nom de l'animal.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode pour définir le nom de l'animal.
     * @param nom Le nom à définir.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Méthode pour obtenir le régime alimentaire de l'animal.
     */
    public String getRegimeAlimentaire() {
        return regimeAlimentaire;
    }

    /**
     * Méthode pour définir le régime alimentaire de l'animal.
     * @param regimeAlimentaire Le régime alimentaire à définir.
     */
    public void setRegimeAlimentaire(String regimeAlimentaire) {
        this.regimeAlimentaire = regimeAlimentaire;
    }

    /**
     * Méthode pour obtenir le poids de l'animal.
     */
    public double getPoids() {
        return poids;
    }

    /**
     * Méthode pour définir le poids de l'animal.
     * @param poids Le poids à définir.
     */
    public void setPoids(double poids) {
        this.poids = poids;
    }

    /**
     * Méthode pour obtenir l'espèce de l'animal.
     */
    public String getEspece() {
        return espece;
    }

    /**
     * Méthode pour définir l'espèce de l'animal.
     * @param espece L'espèce à définir.
     */
    public void setEspece(String espece) {
        this.espece = espece;
    }

    /**
     * Méthode pour obtenir le besoin alimentaire de l'animal en fonction de son régime alimentaire.
     */
    public double getBesoinAlimentaire() {
        switch (regimeAlimentaire) {
            case "carnivore":
                return poids * 0.05;
            case "herbivore":
                return poids * 0.03;
            case "omnivore":
                return poids * 0.02;
            case "piscivore":
                return poids * 0.01;
            default:
                return 0;
        }
    }

    /**
     * Méthode pour définir le besoin alimentaire de l'animal.
     * @param besoinAlimentaire Le besoin alimentaire à définir.
     */
    public void setBesoinAlimentaire(double besoinAlimentaire) {
        this.besoinAlimentaire = besoinAlimentaire;
    }

    /**
     * Méthode pour obtenir une représentation en String de l'animal.
     */
    public String toString() {
        return "Le " + espece + " nommé " + nom + " pèse " + poids + " kg et son besoin alimentaire " + regimeAlimentaire + " de " + besoinAlimentaire + " kg";
    }
}
