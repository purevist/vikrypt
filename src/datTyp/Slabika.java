/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datTyp;
import java.util.ArrayList;

/**
 * Uchovava slabiky pri analyze
 * @author cechvac1
 */
public class Slabika implements Comparable,KodText {
    private String slab;
    private ArrayList<Integer> pozice;
    private boolean opak;

    public Slabika(String slab, int poz) {
        this.slab = slab;
        this.pozice = new ArrayList();
        this.pozice.add(poz);
        this.opak = false;
    }

    /**
     * ulozi dalsi slabiku
     * @param poz
     */
    public void dalsi(int poz){
        this.pozice.add(poz);
        this.opak = true;
    }

    /**
     * Vraci pocet sabik
     * @return pocet slabik
     */
    public int getPocet() {
        return pozice.size();
    }

    /**
     * Pokud je slabika ulozena vicekrat vraci true
     * @return
     */
    public boolean isOpak() {
        return opak;
    }

    /**
     * Vraci hodnotu slabiky
     * @return slabika
     */
    public String getSlab() {
        return slab;
    }

    /**
     * Vraci hodnotu slabiky
     * @return slabika
     */
    public String getText() {
        return slab;
    }


    /**
     * Vraci pozice vsech slabik v poli
     * @return pozice
     */
    public int[] getPozice() {
        int[] ret = new int[pozice.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = pozice.get(i);
        }
        return ret;
    }

    /**
     * Vraci pozice ve stringu pro vypis
     * @return
     */
    public String pozice(){
        String s = "";
        for (Integer integer : pozice) {
            s += " | " + integer;
        }
        return s;
    }

    /**
     * vraci rozdily v pozicich. Pro analyzu delky klice
     * @return
     */
    public String rozdily(){
        String s = "";
        int i=-1;
        for (Integer integer : pozice) {
            if(!(i==-1)) s += " " + (integer - i);
            i = integer;
        }
        return s;
    }

    /**
     * vraci rozdily v pozicich v mod klice mod. Pro analyzu delky klice
     * @return
     */
    public String rozdilyMod(int mod){
        String s = "";
        int i=-1;
        for (Integer integer : pozice) {
            if(!(i==-1)) s += " " + (((integer - i)%mod==0)?(integer - i):"");
            i = integer;
        }
        return s;
    }

    /**
     * vraci rozdily v pozicich. Pro analyzu delky klice
     * @return
     */
    public String rozdilyX(){
        String s = "";
        int i=0;
        for (Integer integer : pozice) {
            if(!(i==-1)) s += "" + ret((integer - i))+((((integer - i)%13)!=0&&i!=0)?"":(this.slab));
            i = integer;
        }
        return s;
    }

    /**
     * vraci rozdily v pozicich.Se zbytky po deleni Pro analyzu delky klice
     * @return
     */
    public String rozdilyDel(int del){
        String s = "";
        int i=-1;
        for (Integer integer : pozice) {
            if(!(i==-1)){
                if((integer - i)%del==0)s += " * ";
                else s += " - ";
            }
            i = integer;
        }
        return s;
    }

    /**
     * vraci prazny string o delce m
     * @param m
     * @return prazny string o delce m
     */
    public String ret(int m){
        String s = "";
        for (int i = 0; i < m; i++) {
            s += " ";
        }

        return s;
    }

    /**
     * Metoda pro razeni slabik dle poctu
     * @param o
     * @return
     */
    public int compareTo(Object o) {
        return (int)(((Slabika)o).getPocet()-getPocet());
        //throw new UnsupportedOperationException("Not supported yet.");
    }





}
