

public class LibelleValeur {
    private String libelle;
    private float valeur;
    private int n=0;

    public LibelleValeur(String lib, float val) {
        libelle = lib;
        valeur = val;

    }

    public String toString() {
        String retour = libelle + " : " + valeur;
        return retour;

    }

    public String ligne(char c, int unite){
        String out = "";
        n = Math.round(valeur/unite);
        for(int i=0;i<n;i++){
            out = out + c;
        }
        out = out + "(" + libelle+" - "+valeur+")";
        return out;
    }

}
