/**
 * La classe Visiteur représente un visiteur du zoo avec un nom, un âge et les espèces qu'il souhaite visiter.
 */
public class Visiteur {

    // Nom du visiteur
    private String nom;
    // Âge du visiteur
    private int age;
    // Liste des espèces que le visiteur souhaite visiter
    private String[] especes;

    /**
     * Constructeur de la classe Visiteur.
     * @param nom Le nom du visiteur.
     * @param age L'âge du visiteur.
     * @param especes Les espèces que le visiteur souhaite visiter.
     */
    public Visiteur(String nom, int age, String[] especes){
        this.nom = nom;
        this.age = age;
        this.especes = especes;
    }

    // Accesseurs et mutateurs pour les variables membres

    /**
     * Accesseur pour le nom du visiteur.
     * @return Le nom du visiteur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Mutateur pour le nom du visiteur.
     * @param nom Le nouveau nom du visiteur.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Accesseur pour l'âge du visiteur.
     * @return L'âge du visiteur.
     */
    public int getAge() {
        return age;
    }

    /**
     * Mutateur pour l'âge du visiteur.
     * @param age Le nouvel âge du visiteur.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Accesseur pour les espèces que le visiteur souhaite visiter.
     * @return Les espèces que le visiteur souhaite visiter.
     */
    public String[] getEspeces() {
        return especes;
    }

    /**
     * Mutateur pour les espèces que le visiteur souhaite visiter.
     * @param especes Les nouvelles espèces que le visiteur souhaite visiter.
     */
    public void setEspeces(String[] especes) {
        this.especes = especes;
    }

    // Méthodes de la classe Visiteur

    /**
     * Méthode appelée lorsque le visiteur entre dans le zoo.
     * @param zoo Le zoo dans lequel le visiteur entre.
     */
    public void entrerDansZoo(Zoo zoo){
        System.out.println(this.toString() + " entre dans le zoo " + "'" + zoo.getNom() + "'");
    }

    /**
     * Méthode appelée lorsque le visiteur entre dans un enclos spécifique.
     * @param enclo L'enclos dans lequel le visiteur entre.
     */
    public void entrerDansEnclo(Enclos enclo){
        System.out.println("[" + nom + ", " + age + "]" + " entre  dans l'enclos " + "'" + enclo.getNom() + "'");
    }

    /**
     * Méthode appelée lorsque le visiteur quitte le zoo.
     */
    public void quitterZoo(){
        System.out.println("[" + nom + ", " + age + "]" + " quitte le zoo.");
    }

    /**
     * Méthode appelée lorsque le visiteur quitte un enclos spécifique.
     * @param enclo L'enclos que le visiteur quitte.
     */
    public void quitterEnclo(Enclos enclo){
        System.out.println("[" + nom + ", " + age + "]" + " quitte l'enclos " + "'" + enclo.getNom() + "'");
    }

    /**
     * Méthode pour obtenir une représentation textuelle du visiteur.
     * @return La représentation textuelle du visiteur.
     */
    public String toString(){
        return "[" + nom + ", " + age + "]";
    }
}
