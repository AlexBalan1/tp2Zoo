public class Entree {

    private int nombreEnclos;

    private Enclos[] enclos;

    private double prix;

    private Visiteur visiteur;
    private Zoo zoo;

    private int lesEnclos;


    /**
     * Constructeur de la classe Entree
     * @param
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
     * accesseurs et mutateurs de la classe Entree
     *
     */

    public int getNombreEnclos() {
        return nombreEnclos;
    }

    public void setNombreEnclos(int nombreEnclos) {
        this.nombreEnclos = nombreEnclos;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Enclos[] getEnclos() {
        return enclos;
    }

    public void setLesEnclos(int lesEnclos) {
        this.lesEnclos = lesEnclos;
    }

    /**
     * methodes de la classe Entree
     */

   public void afficherEnclos(){

       System.out.print("Ce billet permettra de visiter les " + zoo.getNombreEnclos() + " enclos suivants: ");

       for (Enclos i : enclos) {
               System.out.print(i.getNom() + ", ");
           }
       }


   }


