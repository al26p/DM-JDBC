

public class LibelleValeur {
    private String libelle;
    private float valeur;
    private int n=0;

    /**
     * Constructeur de la classe
     *
     * @param lib libelle de la valeur
     * @param val valeur
     */
    public LibelleValeur(String lib, float val) {
        libelle = lib;
        valeur = val;

    }

    /**
     * To string
     *
     * @return retourne un string sous forme Libelle : valeur
     */
    public String toString() {
        String retour = libelle + " : " + valeur;
        return retour;

    }
    //focntion d'affichage sous forme d'histogramme du résultat.

    /**
     * Méthode d'affichage en histogramme
     *
     * @param c charactère utilisé pour l'histogramme
     * @param unite définition de l'histogramme
     * @return renvoi un champ text composé de l'histogramme
     */
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
