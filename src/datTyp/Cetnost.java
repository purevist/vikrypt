/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datTyp;

import java.util.ArrayList;
import tridy.Cetnosti;

/**
 * Uchovava cetnost ruznych abeced a dalsi nalezitosi
 * @author cechvac1
 */
public class Cetnost {
    private Cetnosti cet;
    private double[] relcet;
    private int pocet;
    private char[][] pravdepodobne;
    private char[] zname;
    private char neznam = '_';
    private ArrayList zn = new ArrayList<Character>();

    public Cetnost(Cetnosti cet, String text) {
        this.cet = cet;
        //this.abc = cet.abc;
        this.relcet = cet.relCetnosti(text);
        this.pocet = cet.getDelka();

        zname = new char[pocet];
        resetZname();
        nactiPravdepodobne();
    }

    /**
     * Vytvori tabulku nejpravdepodobnejsich pismen pro kazde pismeno sifry
     */
    public void nactiPravdepodobne(){
        pravdepodobne = new char[pocet][pocet];
        for (int i = 0; i < pocet; i++) {
            pravdepodobne[i] = cet.dlePravdepodobnosti(relcet[i]);
        }
    }

    /**
     * vrati relativni cetnost znaku
     * @param ch
     * @return
     */
    public double relCetnostZnaku(char ch){
        if(cet.poradiAbc(ch)==-1) return 0;
        return relcet[cet.poradiAbc(ch)];
    }

    /**
     * vrati rel cetnost znaku v hex podobe (pro vypis)
     * @param ch
     * @return
     */
    public String relCetnostH(char ch){
        return Integer.toHexString((int)relCetnostZnaku(ch));
    }

    /**
     * Vrati nejpravdepodobnejsi znak. Podle cetnosti.
     * @param ch
     * @param iterace
     * @return
     */
    public char nejvhodnejsiZnak(char ch,int iterace){
        if(iterace>=37) return '#';
        if(cet.poradiAbc(ch)==-1) return '^';
        //pokud znamy znak existuje ve znamych neni pravdepodobny
        if(zn.contains(pravdepodobne[cet.poradiAbc(ch)][iterace])) return nejvhodnejsiZnak(ch,iterace+1);


        return pravdepodobne[cet.poradiAbc(ch)][iterace];
    }

    /**
     * vrati znamy znak
     * @param ch
     * @return
     */
    public char znamyZnak(char ch){
        if(cet.poradiAbc(ch)==-1) return '^';
        return zname[cet.poradiAbc(ch)];
    }

    /**
     * vraci pole s relativni cetnosti znaku 
     * @return
     */
    public double[] getRelcet() {
        return relcet;
    }

    /**
     * Vlozi znak na pozici pismene v urcite abecede
     * @param ch
     * @param pozice
     */
    public void vlozZname(char ch,char pozice){
        zname[cet.poradiAbc(pozice)] = ch;
        zn.add(ch);
    }

    /**
     * pokud uz na pozici znameho znaku nachazi jiny znak
     * @param ch
     * @param pozice
     * @return
     */
    public boolean kolizeZnamehoZnaku(char ch,char pozice){
        if(zname[cet.poradiAbc(pozice)] == neznam) return false;
        if(zname[cet.poradiAbc(pozice)] == ch) return false;
        return true;
    }

    /**
     * vyplni pole znamych znaku neznamymi znaky
     */
    public void resetZname(){
        for (int i = 0; i < zname.length; i++) {
            zname[i]=neznam;
        }
    }







}
