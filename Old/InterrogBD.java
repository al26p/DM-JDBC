import java.sql.*;

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
    
    /**
     * Methode qui affiche les etudiants de Grenoble
     */
    public void afficheEtudiantsDeGrenoble() {
        try {   
            //Creation de la requete
            // nom et prenom des etudiante-s de Grenoble
            String sqlStr = "select Nom, Prenom from etudiants Where Ville = 'Grenoble'";
            Statement stmt = conn.createStatement();
            
            //execution de la requete
            ResultSet res = stmt.executeQuery(sqlStr);
            System.out.println("requete executee ....");
            
            //affichage des resultats
            System.out.println("Etudiant-e-s de Grenoble");
      
            System.out.println("Nom      Prenom");
            
            //parcours du resultat
            //res.next() permet de passer d'une ligne du resultat a la suivante.
            //res.next() renvoie false si toutes les lignes ont ete parcourues.
            while (res.next()) {
                String nom = res.getString(1);
                String prenom = res.getString(2);
                System.out.println(nom+"       "+prenom);
                }
            }
        catch(Exception e){
            //si une erreur se produit, affichage du message correspondant
            System.out.println(e.getMessage());
            System.exit(0);
            }
        }
    
    public void afficheNbCoursValides() {
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
            System.out.println("Nom     Nombre de cours validés");
            //parcours du resultat
            //res.next() permet de passer d'une ligne du resultat a la suivante.
            //res.next() renvoie false si toutes les lignes ont ete parcourues.
            while (res.next()) {
                String nom = res.getString(1);
                int nbcours = res.getInt(2);
                System.out.println(nom+"        "+nbcours);
                }
            }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
            }
        }

    public void afficheNbCoursValidesHisto() {
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
}
 