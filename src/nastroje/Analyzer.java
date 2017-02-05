/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nastroje;
import datTyp.Slabika;
import java.util.ArrayList;

/**
 *
 * @author cechvac1
 */
public class Analyzer {
    private String sifra;
    private ArrayList<Slabika> vse;
    private int testKey;

    public Analyzer(String sifra, int testN) {
        this.sifra = sifra;
        this.testKey = testKey;
        vse = new ArrayList();
        cti(testN);
        vypis();
        vypisTab(15);
        /*for (int i = 3; i < 20; i++) {
            System.out.println("----------------------"+13);
            vypisDel(2,13);

        }*/
        
    }

    /**
     * Cte a analyzuje sifru
     * @param p
     */
    public void cti(int p){
            for (int i = 0; i < sifra.length()-(p-1); i++) {
                vloz(sifra.substring(i, i+p),i);
            }
    }
    
    /**
     * uklada slabiky
     * pokud uz existuje zvysi pocet a prida pozici
     * @param sl
     * @param poz
     * @return
     */
    public boolean vloz(String sl,int poz){
        for (Slabika slabika : vse) {
            if(slabika.getSlab().equalsIgnoreCase(sl)){
                slabika.dalsi(poz);
                return true;
            }
        }
        vse.add(new Slabika(sl,poz));
        return false;
    }

    /**
     * vypise slabiky
     */
    public void vypis(){
        for (Slabika slabika : vse) {
            if(slabika.isOpak()){
                System.out.println(""+slabika.getSlab()+" - " + slabika.rozdily());
                //System.out.println(""+slabika.getSlab()+" - " + slabika.pozice() + "\n" + slabika.rozdily());
            //System.out.print(" + "+slabika.getSlab()+" - "  + slabika.rozdilyMod(testKey));
            //System.out.println("f"+slabika.rozdilyX());
            }
            
        }
    }
    
    /**
     * Vypse tabulku
     * @param p
     */
    public void vypisTab(int p){
        for (Slabika slabika : vse) {
            if(slabika.getPocet()>=p)
            System.out.println(""+slabika.rozdily()+" -"+slabika.getSlab()+" - " + slabika.pozice() );
            
        }
    }

    /**
     * vypise delitele
     * @param p
     * @param d
     */
    public void vypisDel(int p, int d){
        for (Slabika slabika : vse) {
            if(slabika.getPocet()>=p)
            System.out.println(""+slabika.rozdilyDel(d)+"-"+slabika.getSlab());

        }
    }

    public String ret(int m){
        String s = "";
        for (int i = 0; i < m; i++) {
            s += " ";
        }
        return s;
    }


}
