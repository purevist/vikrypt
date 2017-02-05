/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nastroje;
import java.text.Normalizer;

/**
 *
 * @author cechvac1
 */
public class TextKonvertor {
    private String vstupni, vystupni;
    private int delka;

    /**
     *
     * @param vstupni
     */
    public TextKonvertor(String vstupni) {
        this.vstupni = vstupni;
        this.delka = vstupni.length();

        init();
    }

    /**
     * inicalizace
     */
    private void init(){
        bezDiakrit();
        male();
    }

    public void setVstupni(String vstupni) {
        this.vstupni = vstupni;
        this.delka = vstupni.length();
    }

    /**
     * Odstrani diakritiku
     * @param vstup
     * @return
     */
    public String bezDiakrit(String vstup){
        String temp = Normalizer.normalize(vstup, Normalizer.Form.NFKD);
            return temp.replaceAll("[^\\p{ASCII}]", "");
    }

    /**
     * Vraci text bez diakritiky
     */
    public void bezDiakrit(){
        vstupni = bezDiakrit(vstupni);
    }

    /**
     * Prevede na mala pismena
     * @param vstup
     * @return
     */
    public String male(String vstup){
        return vstup.toLowerCase();
    }

    /**
     * prevede text na male znaky
     */
    public void male(){
        vstupni =  vstupni.toLowerCase();
    }

    /**
     * vraci zadany upraveny text do pole znaku
     * @param s
     * @return
     */
    public char[] doPole(String s){
        char[] ret = new char[s.length()];
        s.getChars(0, s.length(), ret, 0);
        return ret;
    }

    /**
     * vraci upraveny text do pole znaku
     * @return
     */
    public char[] doPole(){
        return doPole(vstupni);
    }

    /**
     * Pole znaku do stringu
     * @param ch
     * @return
     */
    public String doStr(char[] ch){
        return String.copyValueOf(ch);
    }

    /**
     * vraci vstupni text
     * @return
     */
    public String getVstupni() {
        return vstupni;
    }

    /**
     * odstrani vsechny znaky krom tech co jsou v abecede
     * @param s
     * @param abc
     * @return
     */
    public String pouzeAbc(String s, char[] abc){
        String ret = "";
        for (int i = 0; i < s.length(); i++) {
            if(soucastiAbc(s.charAt(i), abc))
                ret += s.charAt(i);
        }
        return ret;
    }

    /**
     * odstrani vsechny znaky krom tech co jsou v abecede
     * @param abc
     */
    public void pouzeAbc(char[] abc){
        vstupni = pouzeAbc(vstupni, abc);
    }

    /**
     * zjistuje zda-li je znak soucasti abecedy
     * @param ch
     * @param abc
     * @return
     */
    public boolean soucastiAbc(char ch, char[] abc){
        for (int i = 0; i < abc.length; i++) {
            if(abc[i]==ch)
                return true;
        }
        return false;

    }


}
