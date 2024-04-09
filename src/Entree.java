/**
 * La classe Entree représente un billet d'entrée pour un visiteur dans un zoo.
 */
public class Entree {

    private int nombreEnclos;
    private Enclos[] enclos;
    private double prix;
    private Visiteur visiteur;
    private Zoo zoo;
    private int lesEnclos;

    /**
     * Constructeur de la classe Entree.
     * @param visiteur Le visiteur pour lequel le billet d'entrée est créé.
     * @param zoo Le zoo où le visiteur se rend.
     */
    public Entree(Visiteur visiteur, Zoo zoo) {
        this.visiteur = visiteur;
        this.zoo = zoo;
        this.enclos = new Enclos[zoo.getNombreEnclos()];

        double prixBase = 10; // Prix de base par enclos
        double surchargeAnimal = 1; // Surcharge par animal

        int indexEnclos = 0;
        for (Enclos enclo : zoo.getLesEnclos()) {
            if (enclo != null) {
                boolean encloVisite = false;
                for (String espece : visiteur.getEspeces()) {
                    for (Animal animal : enclo.getAnimaux()) {
                        if (animal.getEspece().equalsIgnoreCase(espece) && enclo.getGardien() != null) {
                            encloVisite = true;
                            break;
                        }
                    }
                }
                if (encloVisite) {
                    enclos[indexEnclos++] = enclo;
                }
            }
        }
        this.nombreEnclos = indexEnclos;

        // Calcul du prix en fonction de l'âge du visiteur
        if (visiteur.getAge() < 12) {
            this.prix = 0; // Gratuit pour les moins de 12 ans
        } else if (visiteur.getAge() >= 65) {
            // Prix de base par enclos + surcharge par animal * nombre total d'animaux dans le zoo
            this.prix = prixBase * this.nombreEnclos + surchargeAnimal * zoo.getNombreTotalAnimaux();
        } else if (visiteur.getAge() >= 13 && visiteur.getAge() <= 17) {
            // 50% de rabais pour les visiteurs entre 13 et 17 ans
            this.prix = (prixBase * this.nombreEnclos + surchargeAnimal * zoo.getNombreTotalAnimaux()) * 0.5;
        } else {
            // Plein tarif pour les autres visiteurs
            this.prix = prixBase * this.nombreEnclos + surchargeAnimal * zoo.getNombreTotalAnimaux();
        }
    }

    /**
     * Méthode pour obtenir le nombre d'enclos inclus dans le billet.
     */
    public int getNombreEnclos() {
        return nombreEnclos;
    }

    /**
     * Méthode pour définir le nombre d'enclos inclus dans le billet.
     * @param nombreEnclos Le nombre d'enclos à définir.
     */
    public void setNombreEnclos(int nombreEnclos) {
        this.nombreEnclos = nombreEnclos;
    }

    /**
     * Méthode pour obtenir le prix du billet.
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Méthode pour définir le prix du billet.
     * @param prix Le prix à définir.
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * Méthode pour obtenir les enclos inclus dans le billet.
     */
    public Enclos[] getEnclos() {
        return enclos;
    }

    /**
     * Méthode pour définir les enclos inclus dans le billet.
     * @param lesEnclos Les enclos à définir.
     */
    public void setLesEnclos(int lesEnclos) {
        this.lesEnclos = lesEnclos;
    }

    /**
     * Méthode pour afficher les enclos inclus dans le billet.
     */
    public void afficherEnclos() {
        System.out.print("Ce billet permettra de visiter les " + zoo.getNombreEnclos() + " enclos suivants: ");
        for (Enclos i : enclos) {
            System.out.print(i.getNom() + ", ");
        }
    }
}
