/**
 * La classe Noeud représente un élément de la file contenant un visiteur et une référence vers le prochain noeud.
 */
public class Noeud {

    // Visiteur contenu dans le noeud
    private Visiteur valeur;
    // Référence vers le prochain noeud dans la file
    private Noeud suivant;

    /**
     * Constructeur de la classe Noeud.
     * @param valeur Le visiteur contenu dans le noeud.
     * @param suivant Le prochain noeud dans la file.
     */
    public Noeud(Visiteur valeur, Noeud suivant) {
        this.suivant = suivant;
        this.valeur = valeur;
    }

    // Accesseurs et mutateurs pour les variables membres

    /**
     * Accesseur pour le visiteur contenu dans le noeud.
     * @return Le visiteur contenu dans le noeud.
     */
    public Visiteur getValeur() {
        return valeur;
    }

    /**
     * Mutateur pour le visiteur contenu dans le noeud.
     * @param valeur Le nouveau visiteur contenu dans le noeud.
     */
    public void setValeur(Visiteur valeur) {
        this.valeur = valeur;
    }

    /**
     * Accesseur pour le prochain noeud dans la file.
     * @return Le prochain noeud dans la file.
     */
    public Noeud getProchain() {
        return suivant;
    }

    /**
     * Mutateur pour le prochain noeud dans la file.
     * @param suivant Le nouveau prochain noeud dans la file.
     */
    public void setProchain(Noeud suivant){
        this.suivant = suivant;
    }

    /**
     * Méthode pour obtenir un noeud sous forme de String.
     * @return La représentation textuelle du noeud.
     */
    public String toString(){
        String visiteur = "";
        if(valeur != null){
            visiteur = "[" + valeur.getNom() + ", " + valeur.getAge() + "]";
        }
        else {
            visiteur = "[null]";
        }
        return visiteur;
    }
}
