/**
 * La classe Enclos représente un enclos dans un zoo, contenant des animaux et assigné à un vétérinaire et un gardien.
 */
public class Enclos {

    // Nom de l'enclos
    private String nom;
    // Nombre d'animaux dans l'enclos
    private int nombreAnimaux;
    // Capacité maximale de l'enclos
    private int capaciteMax;
    // Tableau des animaux dans l'enclos
    private Animal[] tableauxAnimal;
    // Vétérinaire assigné à l'enclos
    private Veterinaire veterinaire;
    // Gardien assigné à l'enclos
    private Gardien gardien;

    /**
     * Constructeur de la classe Enclos.
     * @param nom Le nom de l'enclos.
     * @param capaciteMax La capacité maximale de l'enclos.
     * @param veterinaire Le vétérinaire assigné à l'enclos.
     * @param gardien Le gardien assigné à l'enclos.
     */
    public Enclos(String nom, int capaciteMax, Veterinaire veterinaire, Gardien gardien){
        this.nom = nom;
        this.tableauxAnimal = new Animal[capaciteMax];
        this.veterinaire = veterinaire;
        this.gardien = gardien;
    }

    // Accesseurs et mutateurs pour les variables membres

    /**
     * Accesseur pour le nom de l'enclos.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Mutateur pour le nom de l'enclos.
     * @param nom Le nouveau nom de l'enclos.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Accesseur pour la capacité maximale de l'enclos.
     */
    public int getCapaciteMax() {
        return capaciteMax;
    }

    /**
     * Mutateur pour la capacité maximale de l'enclos.
     * @param capaciteMax La nouvelle capacité maximale de l'enclos.
     */
    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    /**
     * Accesseur pour le nombre d'animaux dans l'enclos.
     */
    public int getNombreAnimaux() {
        return nombreAnimaux;
    }

    /**
     * Mutateur pour le nombre d'animaux dans l'enclos.
     * @param nombreAnimaux Le nouveau nombre d'animaux dans l'enclos.
     */
    public void setNombreAnimaux(int nombreAnimaux) {
        this.nombreAnimaux = nombreAnimaux;
    }

    /**
     * Accesseur pour les animaux dans l'enclos.
     */
    public Animal[] getAnimaux() {
        return tableauxAnimal;
    }

    /**
     * Mutateur pour les animaux dans l'enclos.
     * @param tableauxAnimal Le nouveau tableau des animaux dans l'enclos.
     */
    public void setAnimaux(Animal[] tableauxAnimal) {
        for(int i =0; i < tableauxAnimal.length; i++){
            this.tableauxAnimal[i] = tableauxAnimal[i];
        }
    }

    /**
     * Accesseur pour le vétérinaire assigné à l'enclos.
     */
    public Veterinaire getVeterinaire() {
        return veterinaire;
    }

    /**
     * Accesseur pour le gardien assigné à l'enclos.
     */
    public Gardien getGardien(){
        return gardien;
    }

    /**
     * Mutateur pour le gardien assigné à l'enclos.
     * @param gardien Le nouveau gardien assigné à l'enclos.
     */
    public void setGardien(Gardien gardien){
        this.gardien = gardien;
    }

    // Méthodes de la classe Enclos

    /**
     * Méthode pour ajouter des animaux à l'enclos.
     * @param lesAnimaux Les animaux à ajouter.
     */
    public void ajouterAnimaux(Animal[] lesAnimaux) {
        for (int i = 0; i < lesAnimaux.length; i++) {
            if (nombreAnimaux < capaciteMax) {
                tableauxAnimal[nombreAnimaux++] = lesAnimaux[i];
            } else {
                System.out.println("La capacité maximale de l'enclos est atteinte.");
                break;
            }
        }
    }

    /**
     * Méthode pour obtenir une représentation en String de l'enclos.
     */
    public String toString(){
        String animaux = "L'enclos " + "'" + nom + "' " + "est peuplé avec " + nombreAnimaux + "." + " Sa capacité est de " + capaciteMax +
                ". Le vétérinaire assigné est " + veterinaire.toString() + ". Le gardien actuel est " + gardien.toString() + ". \nLes animaux dans cet enclos:\n";

        for(int i = 0; i < tableauxAnimal.length; i++){
            animaux += tableauxAnimal[i].toString();
        }

        return animaux;
    }
}
