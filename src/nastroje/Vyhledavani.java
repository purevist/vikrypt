/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nastroje;

import datTyp.Slovo;
import java.util.*;
import tridy.Cetnosti;
import tridy.Sifra;
import tridy.Slovnik;

/**
 *  Vyhledava podle cetnosti na zaklade slovniku
 * @author Cechvac1
 */
public class Vyhledavani {
    private Slovnik slovnik;
    private Cetnosti cet;
    public Set<String> slova;
    public List<Slovo> vys;
    private Sifra sif;
    
    //parametry tolerance pro vyhledavani
    double maxPomCet;
    int maxRozCet;

    public static void main(String[] args) {
        new Vyhledavani();
    }

    public Vyhledavani(double maxPomCet, int maxRozCet) {
        this.maxPomCet = maxPomCet;
        this.maxRozCet = maxRozCet;
        init();
    }

    public Vyhledavani() {
        init();
        maxPomCet = 2.7;
        maxRozCet = 7;
        double[] hledam = {8,7,3,10,7,2,7,7,7,9,5};
        //projdi(hledam,10,10);
    }

    /**
     * inicalizace
     */
    public void init(){
        this.cet = new Cetnosti();
        this.slovnik = new Slovnik("tempaj.txt",true);
        slova = slovnik.seznam;
    }

    /**
     * projde a filtruje vsechna slova
     * @param hledam
     * @param min
     * @param max
     */
    public void projdi(double[] hledam,int min, int max){
        vys = new ArrayList<Slovo>();

        for (String sl : slova) {
         if(filtr(sl, hledam, min, max))
            vys.add(new Slovo(sl, cet.relPomCetnosti(cet.relCetSlova(sl), hledam)));
       }
    }

    /**
     * fitruje slova podle delky a shody cetnosti
     * @param sl
     * @param cetn
     * @param min
     * @param max
     * @return
     */
    public boolean filtr(String sl,double[] cetn,int min, int max){
        if(sl.length()>max) return false;
        if(sl.length()<min) return false;
        //if(sl.length()!=11) return false;
        if(cet.relPomCetnosti(cet.relCetSlova(sl), cetn)>3) return false;
        //System.out.println(""+cet.relPomCetnosti(cet.relCetSlova(sl), cetn));
        if(!cet.jeMaxRozdilCetnosti(cet.relCetSlova(sl), cetn ,7)) return false;
        //if(p&&sl.charAt(2)!='d') return false;
        //if(!p&&sl.charAt(0)!='d') return false;
        //if(sl.charAt(1)!='i') return false;
        return true;
    }

    /**
     * vypise vysledek na vystup
     */
    public void vysledek(){
        Collections.sort(vys);
        for (Slovo sll: vys) {
            System.out.println(""+sll.getText()+ " "+sll.getCislo());
        }
    }

    /**
     * vraci serazeny vysledek v poli
     * @return
     */
    public String[] vysledekDoPole(){
        String[] sa = new String[vys.size()];
        Collections.sort(vys);
        for (int i = 0; i < sa.length; i++) {
            sa[i]=vys.get(i).getText();

        }
return sa;
    }




}
