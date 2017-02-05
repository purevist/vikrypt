/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tridy;

import java.util.ArrayList;

/**
 * Vypise vystup na radky
 * @author cecvac1
 */
public class Vystup {
    int radka;
    ArrayList<String> list;


    public Vystup(int radka) {
        this.radka = radka;
        list = new ArrayList<String>();
    }

    /**
     * Vlozi dalsi radku
     * @param s
     */
    public void vlozRadku(String s){
        list.add(s);
    }

    /**
     * Vlozi vice radek v poli
     * @param s
     */
    public void vlozRadky(String[] s){
        for (int i = 0; i < s.length; i++) {
            vlozRadku(s[i]);

        }
    }

    /**
     * Vypise vse a rozdeli na urcity pocet casti
     * @param rozdel
     */
    public void vypisVse(int rozdel){
        int kolikrat = rozdel;
        for (int i = 0; i < kolikrat; i++) {
            vypisVystup(i*radka, i*radka+radka);
        }
    }

    /**
     * vypise vse
     */
    public void vypisVse(){
        int delka = list.get(0).length();
        vypisVse(delka/radka+((delka%radka==0)?0:1));

    }

    /**
     * vypise urcitou cast radek
     * @param odkud
     * @param kam
     */
    public void vypisVystup(int odkud, int kam){
         for (int i = 0; i < list.size(); i++) {
            if(list.get(i).length()<kam)kam = list.get(i).length();
            System.out.println(""+list.get(i).substring(odkud, kam));
        }
    }



}
