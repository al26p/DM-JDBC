
public class TestInterrogBD {
    
    public static void main(String [] args) {
        
        //appel du constructeur avec l'adresse de la base, vos propres login mot de passe MySQL
        InterrogBD monInterroBD = new InterrogBD("jdbc:mysql://PC-TP-MYSQL.insa-lyon.fr:3306/TPBD","CELV_80","TPSQL_2017");
        
        //appel d'une methode 
        monInterroBD.afficheEtudiantsDeGrenoble();
               
        //appel d'une autre methode sur l'instance monInterroBD
        monInterroBD.afficheNbCoursValides();

        monInterroBD.afficheNbCoursValidesHisto();
        }
}
