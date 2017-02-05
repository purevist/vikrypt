/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nastroje;

import datTyp.Slabika;
import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author cechvac1
 */
public class BiTrigramy {
    private int key, n, delka;

    private String sifra;
    private List<Slabika>[] vse;// = new TreeSet<Slovo>();
    //ArrayList[] vse;


    public BiTrigramy(String sifra, int key, int n) {
        //init
        this.key = key;
        this.sifra = sifra;
        delka = sifra.length();
        //vse = new ArrayList[key];
        vse = new ArrayList[key];
        this.n = n;

        nactiNGramy();
        //vypisVse(false, true);
        //vypisVse(true, false);
        
    }

    public void nactiNGramy(){
        for (int i = 0; i < key; i++) {
            vse[i] = new ArrayList<Slabika>();
            vsechnyNGramy(i);
        }
    }

    public void vsechnyNGramy(int it){
        int kolik = (delka-it-n)/key;
        String slov = "";
        for (int i= 0; i < kolik+1; i++) {
            slov = sifra.substring(key*i+it, key*i+it+n);
            vloz(slov, key*i+it, it);
        }
    }

    /**
     * Vlozi slabiku do arraylistu. Pokud uz existuje ulozi pozici. Jinak vytvori novou slabiku.
     * @param sl
     * @param poz
     * @param ng
     * @return true pokud byla slabika jiz nalezena
     */
    public boolean vloz(String sl,int poz,int it){
        for (Slabika slabika : vse[it]) {
            if(slabika.getSlab().equalsIgnoreCase(sl)){
                slabika.dalsi(poz);
                return true;
            }
        }
        vse[it].add(new Slabika(sl,poz));
        return false;
    }


    public void vypisVse(boolean seznam, boolean radka){
        System.out.println(n+"gramy ");
        for (int i = 0; i < key; i++) {
            Collections.sort(vse[i]);
            if(radka)System.out.println(""+vypisNaRadku(i));
            if(seznam)vypis(i);
            
        }
    }

    public void vypis(int i){
        System.out.println(i);
        for (Slabika sl : vse[i]) {
            if(sl.isOpak())
            System.out.print(""+sl.getSlab()+" ("+sl.getPocet()+"), ");
        }
        System.out.println("");
    }

    public String vypisNaRadku(int i){
        char[] ret = new char[delka];
        //prazny retezec
        for (int j = 0; j < delka; j++) {
            ret[j] ='_';
        }

        int poz;
        for (Slabika sl : vse[i]) {
            if(sl.isOpak()){
                
                for (int j = 0; j < sl.getPocet(); j++) {
                    poz = sl.getPozice()[j];
                    for (int k = 0; k < n; k++) {
                        ret[poz+k]=sl.getSlab().charAt(k);
                    }
                }
            }
        }
        return String.copyValueOf(ret);
    }

    public String vypisVsehoNaRadku(){
        char[] ret = new char[delka];
        //prazny retezec
        for (int j = 0; j < delka; j++) {
            ret[j] ='_';
        }

        int poz;
        for (int i = 0; i < key; i++) {
            for (Slabika sl : vse[i]) {
            if(sl.isOpak()){

                for (int j = 0; j < sl.getPocet(); j++) {
                    poz = sl.getPozice()[j];
                    for (int k = 0; k < n; k++) {
                        ret[poz+k]=sl.getSlab().charAt(k);
                    }
                }
            }
        }

        }

        return String.copyValueOf(ret);
    }
    

}
