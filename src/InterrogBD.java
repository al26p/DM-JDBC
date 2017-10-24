import java.sql.*;
import java.util.Scanner;

public class InterrogBD{
    private Connection conn;    //attribut qui memorise la connexion a la base

            
    /**
     * Le constructeur de la classe etablit la connexion.
     * parametres : l'adresse de la base de donnees,
     *  le login et le mot de passe
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

    public void population(int nbPays) {
        try {
            //Creation de la requete
            // nom des etudiante-s ayant validé plus de 1 cours (on compte le nombre de notes definies)
            // et nombre de cours valides
            String sqlStr = "SELECT Country,Population FROM countries ORDER BY Population DESC LIMIT "+nbPays+";";
            Statement stmt = conn.createStatement();

            //execution de la requete
            ResultSet res = stmt.executeQuery(sqlStr);
            System.out.println("requête exécutée ....");

            //affichage des resultats
            System.out.println("Affichage de la population par pays, ordonne par ordre decroissant ");
            //System.out.println("Nom     Nombre de cours validés");
            //parcours du resultat
            //res.next() permet de passer d'une ligne du resultat a la suivante.
            //res.next() renvoie false si toutes les lignes ont ete parcourues.
            while (res.next()) {
                String pays = res.getString(1);
                int pop = res.getInt(2);
                LibelleValeur histo = new LibelleValeur(pays, (float)(pop));
                System.out.println(histo.ligne('+',10000000));
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);

        }
    }

    public void vieContinent() {
        try {
            //Creation de la requete
            // nom des etudiante-s ayant validé plus de 1 cours (on compte le nombre de notes definies)
            // et nombre de cours valides
            String sqlStr = "SELECT Continent,avg(Life_expect) FROM countries WHERE Life_expect IS NOT NULL GROUP BY Continent ORDER BY avg(Life_expect) DESC ";
            Statement stmt = conn.createStatement();

            //execution de la requete
            ResultSet res = stmt.executeQuery(sqlStr);
            System.out.println("requête exécutée ....");

            //affichage des resultats
            System.out.println("Affichage de l'espérance de vie par continent ");
            //System.out.println("Nom     Nombre de cours validés");
            //parcours du resultat
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
 
