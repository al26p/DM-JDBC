import java.util.Scanner;
public class Main {
    /**
     * Méthode principale
     * @param args non utilisé
     */
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        boolean go = true;

        //appel du constructeur avec l'adresse de la base, vos propres login mot de passe MySQL
        String DB ="jdbc:mysql://";
        System.out.println("Entre l'adresse du serveur sql (ex: PC-TP-MYSQL.insa-lyon.fr");
        DB += sc.nextLine()+":";
        System.out.println("Port (ex:3306)");
        DB += sc.nextLine()+"/";
        System.out.println("Nom de la Base (ex:EUROSTATS_EXTR)");
        DB += sc.nextLine();


        System.out.println("Entrez votre login");
        String login = sc.nextLine();

        System.out.println("Entrez votre pwd");
        String pwd = sc.nextLine();

        System.out.println(DB);
        InterrogBD monInterroBD = new InterrogBD(DB,login,pwd);


        while(go==true){
            System.out.println("Que souhaitez vous afficher ?");
            System.out.println("1. Population par pays");
            System.out.println("2. Esperance de vie par continent");
            int choice = sc.nextInt();
            if (choice==1){
                System.out.println("Combien de pays souhaitez vous afficher ?");
                int nbPays = sc.nextInt();
                monInterroBD.population(nbPays);
    
            }else if (choice==2){
                monInterroBD.vieContinent();
    
            }else{
                System.out.println("Choix non autorise");
    
            }
            System.out.println("Voulez-vous effectuer une autre requete ? (true/false)");
            go = sc.nextBoolean();
        }

    }
}
