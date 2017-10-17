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
			///Création de la requête
			String sqlStr ="select pesticid, A2012 from pesticides where geo='UK'";
			System.out.println(sqlStr);//Affiche la requete
			  
			///execution de la requête
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sqlStr);
			System.out.println("requete executee ....");
			
			///Affichage des résultats
			System.out.println("pesticid          A2012");
			
			//res.next() permet de passer d'une ligne de résultats à la suivante et renvoie false si
			//toutes les lignes ont été parcourues
			while (res.next()) {
				//les élements sont triés suivant l'ordre demandé dans le "select" de la requête
				String pesticid = res.getString(1);
				String A2012 = res.getString(2);
				System.out.println(pesticid+"              "+A2012);
			}
		
		} catch(Exception e){
			//Affiche le message d'erruer si une se produit
			System.out.println(e.getMessage());
			System.exit(0);
		}
		  
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
            
            

	
 
            
