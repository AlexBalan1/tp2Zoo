public class Noeud {

   private Visiteur valeur;

   private Noeud suivant;


    public Noeud(Visiteur valeur, Noeud suivant) {

        this.suivant = suivant;
        this.valeur = valeur;
    }


    /**
     * accesseurs et commutateurs de la classe noeud
     */

    public Visiteur getValeur() {
        return valeur;
    }

    public void setValeur(Visiteur valeur) {
        this.valeur = valeur;
    }

    public Noeud getProchain() {
        return suivant;
    }

    public void setProchain(Noeud suivant){
        this.suivant = suivant;
    }

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
