public class File {

    private Noeud premier;
    private int nbElements;

    // Constructeur
    public File() {
        premier = null;
        nbElements = 0;
    }

    // Accesseurs
    public Noeud getPremier() {
        return premier;
    }

    public void setPremier(Noeud premier) {
        this.premier = premier;
    }

    public int getNbElements() {
        return nbElements;
    }

    public void setNbElements(int nbElements) {
        this.nbElements = nbElements;
    }


    public boolean estVide() {
        return premier == null;
    }

    public void enfiler(Visiteur visiteur, int position) {
        if (position < 0 || position > nbElements) {
            System.out.println("Position invalide.");
            return;
        }

        Noeud nouveau = new Noeud(visiteur, null);

        if (position == 0) {
            nouveau.setProchain(premier);
            premier = nouveau;
        } else {

            Noeud precedent = null;
            Noeud courant = premier;
            int index = 0;

            while (index < position) {
                precedent = courant;
                courant = courant.getProchain();
                index++;
            }

            precedent.setProchain(nouveau);
            nouveau.setProchain(courant);
        }

        nbElements++;
    }

    public Visiteur defiler() {
        if (estVide()) {
            System.out.println("La file est vide.");
            return null;
        }

        Visiteur visiteur = premier.getValeur();
        premier = premier.getProchain();
        nbElements--;
        return visiteur;
    }
    public String toString(){
        if(estVide()){
            return "[]";
        }
        String file = nbElements + " visiteurs ";
        Noeud courant = premier;
        while(courant != null){
           file += courant.toString();
           courant = courant.getProchain();
           if(courant != null){
               file += " -> ";
           }
        }

        return file;
    }
}
