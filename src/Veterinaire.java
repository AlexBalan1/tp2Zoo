public class Veterinaire {

    private String nom;

    private Classe specialite;

    /**
     * Constructeur de la classe Veterinaire
     * @param nom
     * @param specialite
     */


    public Veterinaire(String nom, Classe specialite){

            this.nom = nom;

            this.specialite = specialite;
    }

    /**
     * methodes de la classe Veterinaire
     */

    public void soignerAnimal(Animal animal){

         double sonRegime = animal.getBesoinAlimentaire();

        if(animal.getRegimeAlimentaire().equals("carnivore")){
             sonRegime = 0.05 * animal.getPoids();
        }
        else if(animal.getRegimeAlimentaire().equals("herbivore")){
            sonRegime = 0.03 * animal.getPoids();
        }
        else if(animal.getRegimeAlimentaire().equals("omnivore")) {
                sonRegime = 0.02 * animal.getPoids();
        }
        else if(animal.getRegimeAlimentaire().equals("piscivore")){
            sonRegime = 0.01 * animal.getPoids();
        }

        animal.setBesoinAlimentaire(sonRegime);
    }

    public String toString(){
        return "[" + nom + ", " + specialite + "]";
    }




}
