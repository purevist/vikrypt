 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datTyp;

/**
 *
 * @author cechvac1
 */
public class Slovo implements Comparable,KodText {
    private String text;
    private double cislo;

    public Slovo(String text, double cislo) {
        this.text = text;
        this.cislo = cislo*100;
    }

    /**
     * metoda pro razeni podle hodnoty shody
     * @param o
     * @return
     */
    public int compareTo(Object o) {
        return (int)(cislo-((Slovo)o).getCislo());

        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * vraci hodnotu shody
     * @return cislo
     */
    public double getCislo() {
        return cislo;
    }

    /**
     * Nastavi shodu
     * @param cislo
     */
    public void setCislo(double cislo) {
        this.cislo = cislo;
    }

    /**
     * Vraci hodnotu textu
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * Nastavi text
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }




}
