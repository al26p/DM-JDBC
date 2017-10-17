public class Main {
    public static void main(String ... args){
        System.out.println("Début initialisation");
        LibelleValeur test1 = new LibelleValeur("France",20);
        LibelleValeur test2 = new LibelleValeur("Espagne",52);

        System.out.println("Initialisation finie");
        System.out.println(test1);
        System.out.println(test2);
    }
}
