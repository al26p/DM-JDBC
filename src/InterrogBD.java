import java.sql.*;
import java.util.Scanner;

public class InterrogBD{
    private Connection conn;    //attribut qui memorise la connexion a la base


    /**
     * Le constructeur de la classe etablit la connexion.
     *
     * @param adresseBD Adresse de la Base de Données
     * @param nomLogin Login de la BdD
     * @param mdp Mot de Passe de la BdD
     */
    public InterrogBD(String adresseBD, String nomLogin, String mdp) {
        try {           
            //Enregistrement de la classe du driver par le driverManager
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver trouve...");
            //Creation d'une connexion à la base de donnees
            conn = DriverManager.getConnection(adresseBD, nomLogin, mdp);
            System.out.println("Connexion etablie...");
            System.out.println("");


        } catch(Exception e){
            //Affiche le message d'erreur si une erreur se produit durant la connexion
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    //exercice 2
    public void afficheValeursHisto() {
        try {
            //Creation de la requete
            // nom des etudiante-s ayant validé plus de 1 cours (on compte le nombre de notes definies)
            // et nombre de cours valides
            String sqlStr = "select Nom, count(*) FROM notes, etudiants where notes.NumEtudiant = etudiants.Numero and valeur is not null group by Numero having count(*)>1";
            Statement stmt = conn.createStatement();

            //execution de la requete
            ResultSet res = stmt.executeQuery(sqlStr);
            System.out.println("requête exécutée ....");

            //affichage des resultats
            System.out.println("Affichage du nombre de cours validés par etudiant (>1) ");
            //System.out.println("Nom     Nombre de cours validés");
            //parcours du resultat
            //res.next() permet de passer d'une ligne du resultat a la suivante.
            //res.next() renvoie false si toutes les lignes ont ete parcourues.
            while (res.next()) {
                String nom = res.getString(1);
                int nbcours = res.getInt(2);
                LibelleValeur histo = new LibelleValeur(nom, (float)(nbcours));
                System.out.println(histo.ligne('+',1));
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);

        }
    }
    //exercice 3

    /**
     * Affichage de la population par pays
     * @param nbPays nombre de pays a afficher
     */
    public void population(int nbPays) {
        try {
            //Creation de la requete
            // affichage de la popultaion par pays par ordre croissant
            String sqlStr = "SELECT Country,Population FROM countries ORDER BY Population DESC LIMIT "+nbPays+";";
            Statement stmt = conn.createStatement();

            //execution de la requete
            ResultSet res = stmt.executeQuery(sqlStr);
            System.out.println("requête exécutée ....");

            //affichage des resultats
            System.out.println("Affichage de la population par pays, ordonne par ordre decroissant ");

            //res.next() permet de passer d'une ligne du resultat a la suivante.
            //res.next() renvoie false si toutes les lignes ont ete parcourues.
            while (res.next()) {
                String pays = res.getString(1);
                int pop = res.getInt(2);
                LibelleValeur histo = new LibelleValeur(pays, (float)(pop)); //On utilise la classe LibelleValeur pour afficher le resultat
                System.out.println(histo.ligne('+',10000000));
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);

        }
    }

    /**
     * Affiche l'espérance de vie par continent
     */
    public void vieContinent() {
        try {
            //Creation de la requete
            // affichage de l'espérance de vie par continent
            String sqlStr = "SELECT Continent,avg(Life_expect) FROM countries WHERE Life_expect IS NOT NULL GROUP BY Continent ";
            Statement stmt = conn.createStatement();

            //execution de la requete
            ResultSet res = stmt.executeQuery(sqlStr);
            System.out.println("requête exécutée ....");

            //affichage des resultats
            System.out.println("Affichage de l'espérance de vie par continent ");

            //res.next() permet de passer d'une ligne du resultat a la suivante.
            //res.next() renvoie false si toutes les lignes ont ete parcourues.
            while (res.next()) {
                String continent = res.getString(1);
                double dureeVie = res.getDouble(2);
                LibelleValeur histo = new LibelleValeur(continent, (float)(dureeVie));
                System.out.println(histo.ligne('+',1));
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

}
 
