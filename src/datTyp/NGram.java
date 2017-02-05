/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datTyp;

/**
 * Uchovava Ngramy spolu s
 * @author cechvac1
 */
public class NGram implements KodText{
    private String text;
    private int n;
    private double[] cetnost;
    private int pozice;

    public NGram(String text, double[] cetnost) {
        this.text = text;
        this.cetnost = cetnost;
        n = text.length();
        pozice = 0;
    }

    public NGram(String text, double[] cetnost, int pozice) {
        this.text = text;
        this.cetnost = cetnost;
        this.pozice = pozice;
        n = text.length();
    }

    /**
     * Vraci pozici ngramu
     * @return
     */
    public int getPozice() {
        return pozice;
    }

    /**
     * vraci cetnost ngramu
     * @return
     */
    public double[] getCetnost() {
        return cetnost;
    }

    public int getN() {
        return n;
    }

    /**
     * vraci hodnotu textu
     * @return
     */
    public String getText() {
        return text;
    }



}
