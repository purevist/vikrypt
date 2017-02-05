/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tridy;

import java.util.Arrays;


/**
 *Metody pro praci s cetnostmi
 * @author cecvac1
 */
public class Cetnosti {
    public double[] obecCet;
    public char[] abc;
    int delka;
    
    //data cetnosti
    //public double[] cetAj = {8,2,3,4,13,2,2,6,7,0,1,4,2,7,8,2,0,6,6,9,3,1,2,0,2,0,0,0,0,0,0,0,0,0,0,0,0};
    public double[] cetAj = {8.167,1.492,2.782,4.253,12.702,2.228,2.015,6.094,6.966,0.153,0.772,4.025,2.406,6.749,7.507,1.929,0.095,5.987,6.327,9.056,2.758,0.978,2.360,0.150,1.974,0.074};
    public double[] cetCj = {9,2,3,4,11,0,0,1,8,2,4,4,3,7,8,3,0,5,5,6,4,4,0,0,3,3,0,0,0,0,0,0,0,0,0,0,0};
    public double[] cetFr = {8,1,3,4,15,1,1,1,8,1,0,5,3,7,5,3,1,7,8,7,6,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public double[] cetGe = {7,2,3,5,17,2,3,5,8,0,1,3,3,10,3,1,0,7,7,6,4,1,2,0,0,1,0,0,0,0,0,0,0,0,0,0,0};
    public String pabc = "abcdefghijklmnopqrstuvwxyz"; // predpis pismen pro cetnosti
    

    public Cetnosti(String imAbc) {//abeceda v jakemkoli tvaru
        init(imAbc,cetAj);
    }
    
    public Cetnosti() {
        String imAbc = "abcdefghijklmnopqrstuvwxyz0123456789*";//format abecedy
        init(imAbc,cetAj);
    }

    public void init(String imAbc,double[] cetP){
        delka = imAbc.length();
        
        //do abc spravnou vstupni volitelnou abecedu + na mala pismena
        abc = new char[delka];
        imAbc.toLowerCase().getChars(0, delka, abc, 0);
        
        //presklada cetnosti dle abecedy napevno dle aj      
        obecCet = new double[delka];
        for (int i = 0; i < delka; i++) {
            if(pabc.indexOf(abc[i])<0)obecCet[i]=0;
            else obecCet[i]=cetP[pabc.indexOf(abc[i])];
            
        }
        
        System.out.println("Abeceda "+Arrays.toString(abc));
        System.out.println("Cetnost "+Arrays.toString(obecCet));
    }
    
    /**
     * tabulka absolutnich cetnosti v poradi abc
     * @param s
     * @return
     */
    public int[] absCetnosti(String s){
        int[] abs = new int[delka];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cetn = poradiAbc(c);
            if(cetn!=-1)abs[cetn]++;
        }
        return abs;
    }

    public int getDelka() {
        return delka;
    }



    /**
     * tabulka relativnich cetnosti v poradi abc
     * @param s retezec pro analyzu
     * @return
     */
    public double[] relCetnosti(String s){
        double[] rel = new double[delka];
        int delkas = s.length();
        for (int i = 0; i < delkas; i++) {
            char c = s.charAt(i);
            int cetn = poradiAbc(c);
            if(cetn!=-1)rel[cetn]++;
        }
        for (int i = 0; i < delka; i++) {
            rel[i] = 100*rel[i]/s.length();
        }
        return rel;
    }


    /**
     * poradi zadaneho pismene v abecede abc[]
     * @param c pismeno
     * @return poradi v abecede
     */
    public int poradiAbc(char c){
        for (int i = 0; i < abc.length; i++) {
            if (c == abc[i]) return i;
        }
        return -1;
    }

    /**
     * Seradi abecedu dle zadane cetnosti
     * neboli nejpravdepodobnejsi znaky pro doplneni
     * @param cet
     * @return
     */
    public char[] dleCetnosti(double[] cet){
        double[] b = cet.clone();
        char[] a = abc.clone();

        //pole nulovych znaku
        char[] nuly = new char[a.length];
        int p = 0;
        for (int i = 0; i < a.length; i++) {
            if(b[i]==0){//==0
                nuly[p] = a[i];
                p++;
            }
        }

        //sort dvou poli
        boolean konec;
        do{
            konec = false;
            for (int i = 0; i < b.length-1; i++) {
            if(b[i]<b[i+1]){
                double temp = b[i+1];
                b[i+1] = b[i];
                b[i] = temp;

                char temp1 = a[i+1];
                a[i+1] = a[i];
                a[i] = temp1;

                konec=true;
            }
        }
    }while(konec);

        //navraceni znaku z nul
        System.arraycopy(nuly, 0, a, a.length-p, p);
        return a;
    }
    
    /**
     * Pro relativni cetnost nejakeho znaku vytvori alternativy.
     * @param cetnostZnaku
     * @return
     */
    public char[] dlePravdepodobnosti(double cetnostZnaku){
        char[] a = abc.clone();
        double[] b = obecCet.clone();
        double x;

        //rozdil mezi pozadovanou pravdepodobnosti a realnou
        for (int i = 0; i < b.length; i++) {
            x = b[i] - cetnostZnaku;
            b[i] = (x>=0)?x:-x;
        }
        
        //sort dvou poli
        boolean konec;
        do{
            konec = false;
            for (int i = 0; i < b.length-1; i++) {
            if(b[i]>b[i+1]){
                double temp = b[i+1];
                b[i+1] = b[i];
                b[i] = temp;

                char temp1 = a[i+1];
                a[i+1] = a[i];
                a[i] = temp1;

                konec=true;
            }
        }
    }while(konec);

        return a;
    }

    /**
     * porovna shodu dvou cetnosti
     * @param cet1 cetnost
     * @param cet2 druha cetnost musi mit stejnou delku
     * @return vrati prumerny rozdil jednotlivych cetnosti zaokrouhleny na 2des mista
     */
    public double relPomCetnosti(double[] cet1, double[] cet2){
        double sum = 0;
        double x = 0;
        int mensi = (cet1.length<cet2.length)?cet1.length:cet2.length;
        for (int i = 0; i < mensi; i++) {
             x = cet1[i]-cet2[i];
             sum +=(x>=0)?x:-x;
        }
        return (double)sum/mensi;
    }

    /**
     * porovna serazene cetnosti
     * @param cet1
     * @param cet2
     * @return
     */
    public double relPomCetnostiS(double[] cet1, double[] cet2){
        double[] a = cet1.clone();
        Arrays.sort(a);
        double[] b = cet2.clone();
        Arrays.sort(b);

        return relPomCetnosti(a, b);
    }
    
    /**
     * porovna shodu dvou cetnosti
     * @param cet1 cetnost
     * @param cet2 druha cetnost musi mit stejnou delku
     * @return vrati prumerny rozdil jednotlivych cetnosti zaokrouhleny na 2des mista
     */
    public boolean jeMaxRozdilCetnosti(double[] cet1, double[] cet2,double max){
        int mensi = (cet1.length<cet2.length)?cet1.length:cet2.length;
        for (int i = 0; i < mensi; i++) {
             if(max<cet1[i]-cet2[i]) return false;
        }
        return true;
        
    }

    public double relPomCetnostiNul(double[] cet1, double[] cet2){
        int sumNul = 0;
        int mensi = (cet1.length<cet2.length)?cet1.length:cet2.length;
        for (int i = 0; i < mensi; i++) {
             if(cet1[i]==0&&cet2[i]==0)sumNul++;
        }
        return (double)(sumNul*100/mensi)/100;
    }
    

    public double[] relCetSlova(String sl){
        double[] ret = new double[sl.length()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = obecCet[(poradiAbc(sl.charAt(i))==-1)?0:poradiAbc(sl.charAt(i))];
        }
        return ret;
    }

    /**
     * posun doleva v abecede znaku
     * @param ch
     * @param posun
     * @return
     */
    public char posunDleAbc(char ch,int posun){
        int por = poradiAbc(ch);
        return abc[(abc.length+por-posun)%abc.length];
    }


    public void vypisCetnost(double[] ct){
        for (int i = 0; i < ct.length; i++) {
            System.out.print(""+abc[i]+","+ct[i]+",");

        }
    }

    public double pravaCetnostZnaku(char c){
        return obecCet[poradiAbc(c)];
    }

    public double[] pravaCetnostSlova(String s){
        double[] ret = new double[s.length()];
        for (int i = 0; i < ret.length; i++) {
            ret[i]=pravaCetnostZnaku(s.charAt(i));

        }
        return ret;
    }








}
