/**
 * La classe Zoo représente un zoo contenant des enclos, des gardiens, des visiteurs et une file d'attente pour les visiteurs.
 */
public class Zoo {

    // Nom du zoo
    private String nom;
    // Pile des gardiens du zoo
    private Pile pileGardiens;
    // File des visiteurs en attente
    private File fileVisiteurs;
    // Nombre d'enclos dans le zoo
    private int nombreEnclos;
    // Nombre total d'animaux dans le zoo
    private int nombreTotalAnimaux;
    // Tableau des enclos du zoo
    private Enclos[] lesEnclos;

    /**
     * Constructeur de la classe Zoo.
     * @param nom Le nom du zoo.
     */
    public Zoo(String nom){
        this.nom = nom;
        this.pileGardiens = new Pile();
        this.fileVisiteurs = new File();
        this.lesEnclos = new  Enclos[5];
    }

    // Accesseurs et mutateurs pour les variables membres

    /**
     * Accesseur pour le nom du zoo.
     * @return Le nom du zoo.
     */
    public String getNom() {return nom;}

    /**
     * Accesseur pour le nombre d'enclos dans le zoo.
     * @return Le nombre d'enclos dans le zoo.
     */
    public int  getNombreEnclos() {return nombreEnclos;}

    /**
     * Accesseur pour le nombre total d'animaux dans le zoo.
     * @return Le nombre total d'animaux dans le zoo.
     */
    public int getNombreTotalAnimaux() {return nombreTotalAnimaux;}

    /**
     * Mutateur pour le nom du zoo.
     * @param nom Le nouveau nom du zoo.
     */
    public void setNom(String nom) {this.nom = nom;}

    /**
     * Mutateur pour le nombre d'enclos dans le zoo.
     * @param nombreEnclos Le nouveau nombre d'enclos dans le zoo.
     */
    public void setNombreEnclos(int nombreEnclos) {this.nombreEnclos = nombreEnclos;}

    /**
     * Mutateur pour le nombre total d'animaux dans le zoo.
     * @param nombreTotalAnimaux Le nouveau nombre total d'animaux dans le zoo.
     */
    public void setNombreTotalAnimaux(int nombreTotalAnimaux) {
        this.nombreTotalAnimaux = nombreTotalAnimaux;
    }

    /**
     * Accesseur pour la pile des gardiens du zoo.
     * @return La pile des gardiens du zoo.
     */
    public Pile getPileGardiens() {
        return pileGardiens;
    }

    /**
     * Mutateur pour la pile des gardiens du zoo.
     * @param pileGardiens La nouvelle pile des gardiens du zoo.
     */
    public void setPileGardiens(Pile pileGardiens) {
        this.pileGardiens = pileGardiens;
    }

    /**
     * Accesseur pour la file des visiteurs en attente.
     */
    public File getFileVisiteurs() {
        return fileVisiteurs;
    }

    /**
     * Mutateur pour la file des visiteurs en attente.
     * @param fileVisiteurs La nouvelle file des visiteurs en attente.
     */
    public void setFileVisiteurs(File fileVisiteurs) {
        this.fileVisiteurs = fileVisiteurs;
    }

    /**
     * Accesseur pour le tableau des enclos du zoo.
     * @return Le tableau des enclos du zoo.
     */
    public Enclos[] getLesEnclos() {
        return lesEnclos;
    }

    /**
     * Mutateur pour le tableau des enclos du zoo.
     * @param lesEnclos Le nouveau tableau des enclos du zoo.
     */
    public void setLesEnclos(Enclos[] lesEnclos) {
        this.lesEnclos = lesEnclos;
    }

    // Méthodes de la classe Zoo

    /**
     * Méthode pour ajouter des enclos au zoo.
     * @param lesEnclos Les enclos à ajouter.
     */
    public boolean ajouterEnclos(Enclos[] lesEnclos) {
        // Calcul de la somme des points d'expérience des gardiens du zoo
        int sommePointsExperience = 0;
        for (Gardien gardien : pileGardiens.getTableauGardiens()) {
            if (gardien != null) {
                sommePointsExperience += gardien.getCompetence();
            }
        }

        // Vérification de la somme des points d'expérience des gardiens
        if (sommePointsExperience < 20) {
            System.out.println("Échec de l'ajout d'enclos : la somme des points d'expérience des gardiens est inférieure à 20.");
            return false;
        }

        // Vérification de la présence d'enclos à ajouter
        if (lesEnclos.length == 0) {
            System.out.println("Aucun enclos à ajouter.");
            return false;
        }

        // Ajout des enclos au zoo
        for (Enclos enclos : lesEnclos) {
            lesEnclos[nombreEnclos++] = enclos;
        }

        System.out.println("Enclos ajoutés avec succès.");
        return true;
    }

    /**
     * Méthode pour retirer un visiteur de la file d'attente.
     * @return Le visiteur retiré de la file d'attente, ou null si la file est vide.
     */
    public Visiteur retirerVisiteur(){
        if (fileVisiteurs.estVide()) {
            System.out.println("Il n'y a aucun visiteur en attente.");
            return null;
        }

        Visiteur visiteur = fileVisiteurs.defiler();

        return visiteur;
    }

    /**
     * Méthode pour faire entrer un visiteur dans le zoo.
     * @param visiteur Le visiteur à faire entrer.
     */
    public void arriveeVisiteur(Visiteur visiteur){
        // Si le visiteur est âgé de 65 ans ou plus, l'ajouter en tête de la file
        if(visiteur.getAge() >= 65){
            fileVisiteurs.enfiler(visiteur, 0);
        }
        // Sinon, l'ajouter en fin de file
        else {
            fileVisiteurs.enfiler(visiteur, fileVisiteurs.getNbElements() - 1);
        }
    }

    /**
     * Méthode pour ajouter un gardien à un enclos.
     * @param gardien Le gardien à ajouter.
     */
    public void ajouterGardien(Gardien gardien) {
        // Parcours des enclos pour trouver un enclos sans gardien
        for (int i = 0; i < lesEnclos.length; i++) {
            if (lesEnclos[i] != null && lesEnclos[i].getGardien() == null) {
                // Empilage du gardien dans la pile
                pileGardiens.empiler(gardien);
                // Affectation du gardien à l'enclos
                lesEnclos[i].setGardien(gardien);
                return;
            }
        }
        System.out.println("Aucun enclos disponible pour ajouter un gardien.");
    }

    /**
     * Méthode pour retirer un gardien du zoo.
     */
    public Gardien retirerGardien() {
        // Dépile le dernier gardien arrivé au zoo
        Gardien gardien = pileGardiens.depiler();

        // Vérifie s'il y a un gardien à retirer
        if (gardien != null) {
            System.out.println("On retire le dernier gardien arrivé au zoo : " + gardien.toString());
            // Vérifie la compétence du gardien
            if (gardien.getCompetence() < 20) {
                System.out.println("Le gardien ne peut pas être congédié.");
                /* pileGardiens.empiler(gardien);
                return null; */
            }
        } else {
            System.out.println("Il n'y a aucun gardien à retirer.");
        }

        return gardien;
    }

    /**
     * Méthode pour obtenir une le zoo sous forme de String.
     */
    public String toString(){
        // Création de la chaîne de caractères représentant les enclos du zoo
        String enclos = "Le zoo est peuplé avec " + nombreTotalAnimaux + " animaux. " + "Il y a " + nombreEnclos + " enclos." ;
        for(int i = 0; i < lesEnclos.length; i++){
            if(lesEnclos[i] != null) {
                enclos += lesEnclos[i].toString();
            }
        }

        // Concaténation des informations sur la pile des gardiens, la file des visiteurs et les enclos
        return "Voici la pile des gardiens : " + "\n" +  pileGardiens.toString() + "\n" + "Et la file des Visiteurs: " + "\n" + fileVisiteurs.toString() + "\n" + enclos;
    }
}
