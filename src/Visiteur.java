public class Visiteur {

    private String nom;

    private int age;

    private String[] especes;

    /**
     * Constructeur de la classe Visiteur
     * @param nom
     * @param age
     * @param especes
     */

    public Visiteur(String nom, int age, String[] especes){
        this.nom = nom;
        this.age = age;
        this.especes = especes;

        }



    /**
     * accesseurs et commutateurs de la classe Visiteur
     */

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getEspeces() {
        return especes;
    }

    public void setEspeces(String[] especes) {

        for(int i = 0; i < especes.length; i++){
            this.especes[i] = especes[i];
        }
    }

    /**
     * methodes de la classe Visiteur
     */

    public void entrerDansZoo(Zoo zoo){
        System.out.println(this.toString() + " entre dans le zoo " + "'" + zoo.getNom() + "'");
    }

    public void entrerDansEnclo(Enclos enclo){
        System.out.println(this.toString() + " entre  dans l'enclos " + "'" + enclo.getNom() + "'");
    }

    public void quitterZoo(){
        System.out.println(this.toString() + " quitte le zoo.");
    }

    public void quitterEnclo(Enclos enclo){
        System.out.println(this.toString() + " quitte l'enclos " + "'" + enclo.getNom() + "'");
    }

    public String toString(){
        return "[" + nom + ", " + age + "]";
    }



}
