

public class LibelleValeur {
    private String libelle;
    private float valeur;

    public LibelleValeur(String lib, float val) {
        String libelle = lib;
        float valeur = val;

    }

    public String toString() {
        String retour = libelle + " : " + valeur;
        return retour;

    }

    public String ligne(char c, int unite){
        String out = "";
        for(int i=0;i<unite;i++){
            out = out + c;
        }
        out = out + "(" + libelle+" - "+valeur+")";
        return out;
    }

}
