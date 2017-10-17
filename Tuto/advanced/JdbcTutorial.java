import java.sql.*;

public class JdbcTutorial{
    private Connection conn;
            
    /**
     * Methode pour se connecter à la base ; prend en paramètre l'adresse de la base de données,
	   le login et le mot de passe
     */
    public JdbcTutorial(String AdresseBD, String nomLogin, String mdp) {
		try { 			
			//Enregistrement de la classe du driver par le driverManager
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver trouve...");
			//Création d'une connexion sur la base de donnée
			conn = DriverManager.getConnection(AdresseBD, nomLogin, mdp);
			System.out.println("Connexion etablie...");
			System.out.println("");
		} catch(Exception e){
			//Affiche le message d'erreur si une se produit durant la connection
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	
	/**
		Exemple de requête
	*/
	public void requeteExemple() {
		try {   
			//Création de la requête
			String sqlStr ="select count(*) as compte_lignes from pesticides where geo='UK'";
			System.out.println(sqlStr);//Affiche la requete
			  
			//execution de la requête
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sqlStr);
			System.out.println("requete executee ....");
			
			//Affichage des résultats
			affichageResultats(res);
		
		} catch(Exception e){
			//Affiche le message d'erreur si une se produit
			System.out.println(e.getMessage());
			System.exit(0);
		}
		  
	}
	
	/**
		Cette fonction gère l'affichage des résultats des requêtes
		pour connaitre les fonction disponibles sur le ResultSet:
		https://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
	*/
	public void affichageResultats(ResultSet res)  throws Exception{
		
		///Affiche le nombre de résultats
		//on se positionne sur la dernière ligne
		res.last(); 
		//on récupère le numéro de la ligne 
		int nombreLignes = res.getRow(); 
		//on replace le curseur avant la première ligne 
		res.beforeFirst();
		
		System.out.println("Nombre de resultats: "+nombreLignes+"\n");
		
		//Permet de connaitre le nombre de colonnes
		int nbColonnes=res.getMetaData().getColumnCount();
		
		///Affiche le label (nom) de chaque collone
		String ligneNomColonnes="";
		for (int i=0;i<nbColonnes;i++){
			//récupère le nom de la colonne
			String labelColonne=res.getMetaData().getColumnLabel(i+1); ;
				
			//fait en sorte que toutes les colonnes fassent la même largeur
			labelColonne=formateCollone(labelColonne);
			
			//ajoute la colonne au texte de la ligne;
			ligneNomColonnes+=labelColonne;	
		}
		System.out.println(ligneNomColonnes);
		
		///Affiche les lignes de résultat
		//res.next() permet de passer d'une ligne de résultats à la suivante et renvoie false si
		//toutes les lignes ont été parcourues
		while (res.next()) {
			//créé la ligne à afficher
			String ligneAffichage="";
			for (int i=0;i<nbColonnes;i++){
				String texteColonne=res.getString(i+1);
				
				//fait en sorte que toutes les colonnes fassent la même largeur
				texteColonne=formateCollone(texteColonne);
				
				//ajoute la colonne au texte de la ligne;
				ligneAffichage+=texteColonne;					
			}
			System.out.println(ligneAffichage);
		}
	}
	
	/**
		Cette fonction modifie la string donnée en entrée pour quelle contienne
		un nombre de caractères définit à l'avance.
		Si un pointeur null est donné en paramêtre cette fonction retour "null".
		!!! si la string contient plus de caractères que le nombre désiré, rien n'est fait !!!
	*/
	public String formateCollone(String valeur){
		//gère le cas du pointeur null
        if (valeur==null){
            valeur= "null";
        }	
		
		//Ajoute des espace jusqu'à obtenir la longeur désirée en ajoutant des espaces
        int longueur_cible= 21;
        while(valeur.length()<longueur_cible){
            valeur= valeur+ " ";
        }
        return valeur;
    } 
		  
	
	public static void main(String [] args) {
		//Récupère l'adresse de la base de données, le login et le password passés en arguments du programme
		String AdresseBD=args[0];
		String login=args[1];
		String password=args[2];
		
		//Appel du constructeur de notre classe
		JdbcTutorial maBd = new JdbcTutorial(AdresseBD,login,password);
		
		
		//Execution d'une requête
		maBd.requeteExemple();
	}
             
             
}
            
            
