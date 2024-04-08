public class Enclos {

    private String nom;
    private int nombreAnimaux;
    private int capaciteMax;
    private Animal[] tableauxAnimal;

    private Veterinaire veterinaire;
    private Gardien gardien;


    /**
     * Constructeur de la classe enclos
     * @param nom
     * @param capaciteMax
     * @param veterinaire
     * @param gardien
     */
    public Enclos(String nom, int capaciteMax, Veterinaire veterinaire, Gardien gardien){
            this.nom = nom;
            this.tableauxAnimal = new Animal[capaciteMax];
            this.veterinaire = veterinaire;
            this.gardien = gardien;
    }

    /**
     * accesseurs et mutateurs de la classe Enclos
     * @param
     */

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public int getNombreAnimaux() {
        return nombreAnimaux;
    }

    public void setNombreAnimaux(int nombreAnimaux) {
        this.nombreAnimaux = nombreAnimaux;
    }

    public Animal[] getAnimaux() {
        return tableauxAnimal;
    }

    public void setAnimaux(Animal[] tableauxAnimal) {
        for(int i =0; i < tableauxAnimal.length; i++){
            this.tableauxAnimal[i] = tableauxAnimal[i];
        }

    }

    public Veterinaire getVeterinaire() {
        return veterinaire;
    }

    public Gardien getGardien(){

        return gardien;
    }

    public void setGardien(Gardien gardien){
        this.gardien = gardien;
    }
    /**
     * methodes de la classe Enclos
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

    public String toString(){
        String animaux = "L'enclos " + "'" + nom + "' " + "est peuplé avec " + nombreAnimaux + "." + " Sa capacité est de " + capaciteMax +
                ". Le vétérinaire assigné est " + veterinaire.toString() + ". Le gardien actuel est " + gardien.toString() + ". \nLes animaux dans cet enclos:\n";

        for(int i = 0; i < tableauxAnimal.length; i++){
            animaux += tableauxAnimal[i].toString();
        }

        return animaux;
    }




}
