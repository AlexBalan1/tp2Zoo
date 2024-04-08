public class Gardien {

    private int prochainId = 1000;

    private String nom;

    private int competence;

    private int id;


    /**
     * Constructeur de la classe Gardien
     * @param nom
     * @param competence
     */

    public Gardien(String nom, int competence){

        this.nom = nom;
        this.competence = competence;
        this.id = prochainId++;
    }

    /**
     * accesseurs et commutateurs de la classe Gardien
     * @param
     */

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCompetence() {
        return competence;
    }

    public void setCompetence(int competence) {
        this.competence = competence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * methodes de la classe Gardien
     */

    public void entrainerAnimal(Animal animal, double temps){


        if(temps < 10){
            double nouveauPoids = animal.getPoids() * (1 + 0.01);
            animal.setPoids(nouveauPoids);
        }

        else if(temps > 10 && temps < 30){
            double nouveauPoids = animal.getPoids() * -0.02;
            animal.setPoids(nouveauPoids);
        }

        else {
            double nouveauPoids = animal.getPoids() * -0.05;
            animal.setPoids(nouveauPoids);
        }
    }

    public String toString(){

        return "[" + nom + "  (" + id + ") " + competence + "]";
    }
}
