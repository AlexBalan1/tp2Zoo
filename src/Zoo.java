public class Zoo {

    private String nom;
    private Pile pileGardiens;
    private File fileVisiteurs;
    private int nombreEnclos;
    private int nombreTotalAnimaux;

    private Enclos[] lesEnclos;


    /**
     * Constructeur de la classe Zoo.
     * @param
     */
    public Zoo(String nom){
        this.nom = nom;
        this.pileGardiens = new Pile();
        this.fileVisiteurs = new File();
        this.lesEnclos = new  Enclos[5];
    }

    /**
     *  accesseurs et mutateurs de la classe Zoo
     * @param
     */
    public String getNom() {return nom;}

    public int  getNombreEnclos() {return nombreEnclos;}

    public int getNombreTotalAnimaux() {return nombreTotalAnimaux;}

    public void setNom(String nom) {this.nom = nom;}

    public void setNombreEnclos(int nombreEnclos) {this.nombreEnclos = nombreEnclos;}

    public void setNombreTotalAnimaux(int nombreTotalAnimaux) {
        this.nombreTotalAnimaux = nombreTotalAnimaux;
    }

    public Pile getPileGardiens() {
        return pileGardiens;
    }

    public void setPileGardiens(Pile pileGardiens) {
        this.pileGardiens = pileGardiens;
    }

    public File getFileVisiteurs() {
        return fileVisiteurs;
    }

    public void setFileVisiteurs(File fileVisiteurs) {
        this.fileVisiteurs = fileVisiteurs;
    }

    public Enclos[] getLesEnclos() {
        return lesEnclos;
    }

    public void setLesEnclos(Enclos[] lesEnclos) {
        this.lesEnclos = lesEnclos;
    }

    /**
     * methodes de la classe Zoo
     */

    public boolean ajouterEnclos(Enclos[] lesEnclos) {

        int sommePointsExperience = 0;
        for (Gardien gardien : pileGardiens.getTableauGardiens()) {
            if (gardien != null) {
                sommePointsExperience += gardien.getCompetence();
            }
        }


        if (sommePointsExperience < 20) {
            System.out.println("Échec de l'ajout d'enclos : la somme des points d'expérience des gardiens est inférieure à 20.");
            return false;
        }


        if (lesEnclos.length == 0) {
            System.out.println("Aucun enclos à ajouter.");
            return false;
        }


        for (Enclos enclos : lesEnclos) {
            lesEnclos[nombreEnclos++] = enclos;
        }

        System.out.println("Enclos ajoutés avec succès.");
        return true;
    }

    public Visiteur retirerVisiteur(){
        if (fileVisiteurs.estVide()) {
            System.out.println("Il n'y a aucun visiteur en attente.");
            return null;
        }

        Visiteur visiteur = fileVisiteurs.defiler();

        return visiteur;
    }

    public void arriveeVisiteur(Visiteur visiteur){

        if(visiteur.getAge() >= 65){
            fileVisiteurs.enfiler(visiteur, 0);
        }
        else {
            fileVisiteurs.enfiler(visiteur, fileVisiteurs.getNbElements() - 1);
        }
    }

    public void ajouterGardien(Gardien gardien) {
        for (int i = 0; i < lesEnclos.length; i++) {

            if (lesEnclos[i] != null && lesEnclos[i].getGardien() == null) {

                pileGardiens.empiler(gardien);

                lesEnclos[i].setGardien(gardien);

                return;
            }
        }
        System.out.println("Aucun enclos disponible pour ajouter un gardien.");
    }

    public Gardien retirerGardien() {

        Gardien gardien = pileGardiens.depiler();

        if (gardien != null) {
            System.out.println("On retire le dernier gardien arrivé au zoo : " + gardien.toString());

            // Vérifie la compétence du gardien
            if (gardien.getCompetence() < 20) {
                System.out.println("Le gardien ne peut pas être congédié.");

                pileGardiens.empiler(gardien);
                return null;
            }
        } else {
            System.out.println("Il n'y a aucun gardien à retirer.");
        }

        return gardien;
    }




    public String toString(){

        String enclos = "";


        for(int i = 0; i < lesEnclos.length; i++){
            if(lesEnclos[i] != null) {
                enclos += lesEnclos[i].toString();
            }
        }

       return pileGardiens.toString() + "\n" + fileVisiteurs.toString() + "\n" + enclos;

    }





}
