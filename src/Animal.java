public class Animal {

    private String nom;
    private String regimeAlimentaire;

    private double poids;

    private Classe classe;

    private String espece;

    private double besoinAlimentaire;


    /**
     * consctructeur de la classe Animal
     * @param nom
     * @param regimeAlimentaire
     * @param poids
     * @param classe
     * @param espece
     */
    public Animal(String nom, String regimeAlimentaire, double poids, Classe classe, String espece){
        this.nom = nom;
        this.regimeAlimentaire = regimeAlimentaire;
        this.poids = poids;
        this.classe = classe;
        this.espece = espece;
    }

    /**
     * accesseurs et mutateurs de la classe Animal
     * @param
     */

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRegimeAlimentaire() {
        return regimeAlimentaire;
    }

    public void setRegimeAlimentaire(String regimeAlimentaire) {
        this.regimeAlimentaire = regimeAlimentaire;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

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

    public void setBesoinAlimentaire(double besoinAlimentaire) {
        this.besoinAlimentaire = besoinAlimentaire;
    }


    public String toString(){
        return "Le " + espece + " nommé " + nom + " pèse " + poids + " kg et son besoin alimentaire " + regimeAlimentaire + " de " + besoinAlimentaire + " kg";
    }
}
