/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tridy;


import nastroje.BiTrigramy;
import nastroje.TextKonvertor;
import nastroje.Vyhledavani;
import nastroje.PriradNgramy;
import nastroje.Analyzer;
import datTyp.Cetnost;
import java.util.Arrays;

/**
 * Komplxni trida ktera implementuje nastroje pro analyzu a rozkodovani polyalphabeticke substitucni sifry
 * @author cecvac1
 */
public class Sifra {
    String sifra = "KSI1B3E194N*8GWZC43UAG6FN2RQB3RG7AB31EL2Q724W*EGV991KBP172NQ8G1012BDY6*14QX1QZESIN7WK6QDMDGIMYWQSL*F6FNQGOUTI2UA8BIL*TXC1ZBGWGGPGMCX2C9B418XGS6IW*44WYVC4SQ1HXP1777GK4XG6T1LNBWNV6V4ZQKSI1B3E194R9GXLVQC*2VVBJGISW7JT2XWYN60*C8I1QD7JBBDKTFC4CCPOWQQJ1F4A*143OVMHX*G612QQS26IDNGLHSF1ZZ2WFASNXCSPOS24A8HT0XILFF7DYTGOIQ*IH8JNX1WFUDQ*7JY3IGAGCGFKPI8POIDU32HGDLFMV3CQ0JI6TNCGOPTCS45IHF5QCZ4MR3N6*BST37AOG6L16G3J9MVUKQILAQCGTFIXMBOSQXJGYJ02VLVTNXQQL3IZI48HN7Z76IGX1L2XH1CQ0*94R9GXMCCB273GVMKFGHPOGXLYVDXDL2Q72BQKTC3JUTQ122GXK6QXW92IPIN7WKJFAFLLR8HX922A8HT0X7QLB2SAVMHX*GG4YW433*9A4RKH87BWSU6YVT0T41HNEXN3V359SC8HGZDULV3TQ12L2C5XXQ6X4KQGW4TCQGJY3ITL18I25S2R*AMKFGHPX2Z4WCHJUXXWHOY2AVMGGDQRYRIQ23GV6X*LH623RQLF8CMTIWSOXQ*3WQV4QSIH81QLV62ET0CIH8OS77AFUD0LHQLB2SAVMHX**CS*CBGX62E6*F21D14Q6G8YXRKFHZQ9DL*F6F08IMIN7WKJI6TQCI8*14QB*G69QSEHDQIG9G6QT0XCU24ZSMBJ53KPCSINZ261CBSL2V8OG7XXYBCBN1ELHUTWNTYXFL22DON2675G6F5IW9F9IGX1KEJKBXWIJUWBVZBN*ROEWTDXLUMHKQTFZ*GFNPOXXG6MXM*1TQN*GE1QD7MYN7Z2YV44DQGHBITDULGVM*SHXF12O662EFJQ21ZOSB0V86N8FKXB32LVG6AMZQIOHJQD7YCBJ1PXHDW7LOYBUMKFGHIWBGLUVHTJF4O7GGQ61QUWN2CWINZMBFM7G5QVUKQILAQCGM*SILPQG60YIC4ZL4ZRO9DNV6GXDQX86TN*1JGUIL*TXB32LNG6CNRIWO2OGW6E9XWLX7WLHTL6JM741KRQ2Q5M2RVEGL8RBRGTBJVT36KQEMV397UWZBT0T4QPA9W*AF6NKQRBL17D7HGGPZK48HN7Z76IHFVLRBD8WWKV6BSG6HXB32LU3M7G1LTX8Q4WKVMHX*LH8OJYS76IG99G2D*GT*4V8CX8G6BH2SWNNFGNL21UYW5B1U8CTFIEHHNTMX6FG4ZPX8BIIG4*9*4TQGORWQ2X1BHD9GIULJ2LE1KCJKFXSPQCS26FURKTS8*JIG6GFV9TKQBCOSB0V86N8FKXB32L7AKHD9GC8I27LLWYBF02VZOXIX2YB64*QILHU7DJ62QF08GHOI2*VJFGX6Q7M2T4245*XNK3KSOCIQK5Y3JQFRXCW294TM3992WSO397UWZBT0T4YUN2DYGLCKNMGOBOW225VET02KSY47LOJ9V1NGXHDJ2LE1KCJKFXSH2SWNNFGNL2IO72ZTU*K6MZKKW*NC*2VVBJGIGHOHQVKYMG9N26XL4NG6Y364G*CLH2SWNNFGNL28YBHQVYVC4SNQCM2Q4QKT63J8FW1LN7Q05LBFZFJQ*47LEYVKMKFGH4MNQ*1COXDCXLHO9A1FC3TVKKSI1B3E1Y45Q*7SFYTB1U8ENKNGYC4JG4NTB1DLR8H2LWN6QVXRKFQCWZI1*FVT0XILF397UWZBT0T44IM2L0FTCDTLR8HB7XV6QD1LGCMB2QD7YCBSZIKY234VUIUCDKFQBPGTI1WKA4ZQGOPT9276G*NK3HBKTN3K3QX59GIULNEQ618VS9QRQM3ZMAVILGUFQBLO9*J6QDGLJHB6I2L2GKGX72GNBIT3K3QX59GIULIQZ7APBTLJRBRGTDL*YB192K1DOZ2KYMYNRKGH*CCB2J8GX9MHZ7JYA4AM6DTLR8HB7GVVMG99GHBKTNS162E16KG6CQGQJV6VGZQKSI1B3E1Y4N*8GWZC43UAQUSJFJLVT6QNG6AG9*7ZIN4T21COXDCXLHO92XGC6NKFQQBMNGQGLBJ1PXAOC9X2TM3E*T1QLC5M76G3J1FR8*H7L16G3JL8IHMOIA16G3J0QGOBT9BUN3B1KC7HBCN3TQKX4S6IWH2L23Q6HMTLWZHN7WKVLVSNLFXLJTS48*H1QC7HB1WGULLEY0G6XRJT2X6Q3JNGP6OOSBUN3B1KC7HBCN3TQKHJ8TF4IN7WKNFTIL*2DINIX1JQUMTT414Q5GK1Y4MG1C8PN2W6EYXDLCSX2NGGK6FAN4IWQLB2SAVMHX*JCUUWZ9YYCC41LKMO1BDU62E5LQ28O2B361DEN*GCSC3LXK59HJ8TF4IN7WKEQAR9GR8R34W3JYV1QGRBL17D7H9VXEJXWBHZL6QKHJ8TF4IN7WK5LEMDL4MO1WXL1FADTKXWI2CXXVVC1N9EQ2T57UWFVDNQRL7JIV36QY19J6QRC9MKU6AG9*RBRGTDX1CBR1F2Q724T4W9B1NQS1R3Q*156EFZJFU8GQAXYV6M6Q2DINIGX6VHDKLKM*1BDUVLAN*8GWZC43UAVCS9GIH8N2DYVMD1LZFXZOI6NYUEDKGGXC3G36QKU6EB7W7BWS2V3D1LX7ZUT260G";
    char[][] tab, tabt;//tabulka se znaky sifry/transponovana
    int key;//perioda neboli delka klice
    TextKonvertor tk;//trida pro praci s textem
    Vyhledavani vyh;
    Vystup vys1, vys2;//pro regulovaný výstup
    PriradNgramy png;

    Cetnosti cet;
    Cetnost[] tabCet;

    public Sifra() {
        //init
        //cet = new Cetnosti("KRYPTOSABCDEFGHIJLMNQUVWXZ");
        cet = new Cetnosti();
        //String sifra = "EMUFPHZLRFAXYUSDJKZLDKRNSHGNFIVJYQTQUXQBQVYUVLLTREVJYQTMKYRDMFDVFPJUDEEHZWETZYVGWHKKQETGFQJNCEGGWHKK";
        sifra = "VFPJUDEEHZWETZYVGWHKKQETGFQJNCEGGWHKK?DQMCPFQZDQMMIAGPFXHQRLGTIMVMZJANQLVKQEDAGDVFRPJUNGEUNAQZGZLECGYUXUEENJTBJLBQCRTBJDFHRRYIZETKZEMVDUFKSJHKFWHKUWQLSZFTIHHDDDUVH?DWKBFUFPWNTDFIYCUQZEREEVLDKFEZMOQQJLTTUGSYQPFEUNLAVIDXFLGGTEZ?FKZBSFDQVGOGIPUFXHHDRKFFHQNTGPUAECNUVPDJMQCLQUMUNEDFQELZZVRRGKFFVOEEXBDMVPNFQXEZLGREDNQFMPNZGLFLPMRJQYALMGNUVPDXVKPDQUMEBEDMHDAFMJGZNUPLGEWJLLAETG";
        
        sifra = sifra.toLowerCase(); //male pismena
        tk = new TextKonvertor("");
        
        //init();
        
        //zjisteni delky klice
        //new Analyzer(sifra, 8);// vyzkousenim klicu (delky hesla)
        
        //znam klic
        key = 8;//zjistena delka klice
        sifruDoTabulky(key);//sifru do pole znaku pro rychlejsi operace
        
        nactiCetnosti();//nacteni cetnosti
        podrobnyVypisCetnosti();
        
        
        
        //analyzaCet();
        //vyh= new Vyhledavani(2.7,6);//nacte slovnik
        
       vys1 = new Vystup(52);
       png = new PriradNgramy(this, cet);
        
        
        
        //zname();
        //analyzaCet();
        //zkouskaCet();
        znamSlovo("vfpjudeehz",0,"itwastotal");
        radkoveVypisy();
        zkusSlovo("8i", 1, "oa",true);
        //zkusSlovo("in7wk",2,"ation",true);
        //zkusSlovo("vmhx*g",2,"nation",true);
        //zkusSlovo("2dinigx6", 0,"stations",true);
        //najdiZkusNgram("p17", 2, true);
        //zkusSlovo("48hn7z76i", 0,"beatified",true);
        //najdiZkusSlovo("a8ht0xilf", 7,true);//dobré na hádání
        //najdiZkusSlovo("l16g3j", 5,true);
        //najdiZkusDvojici("hqv", 3,true, "qd7", 4, true);
        //najdiZkusSlovo("osb0v86n8fkxb32l", 3,true);
        //najdiZkusDvojici("2dinigx6", 0,false, "s26", 5, true);
        //najdiZkusDvojici("n*8gwzc43ua", 10,false, "hj8tf4in7wk", 9,false);
        //najdiZkusDvojici("*14", 2 ,true, "14q", 3 ,true);
       //najdiZkusDvojici("c8i", 0 ,true, "8i2", 3 ,true);
        //png.prirad("in7", 2);
        //najdiZkusNGramy();
        //najdiZkusSlovo("bun3b1kc7hbcn3tqk", 5,false);
        //
        /*vypis(0, 0);
        vypis(5, 0);
        vys1.vlozRadku(vypisNaRadku(5, 0));
        vys1.vlozRadku(vypisNaRadku(0, 0));
        vys1.vlozRadku(vypisNaRadku(1, 0));*/
        
        //BiTrigramy bt;
        /*for (int i = 3; i < 10; i++) {
            bt = new BiTrigramy(sifra.toLowerCase(), key, i);
            vys1.vlozRadku(bt.vypisVsehoNaRadku());
            System.out.println(""+bt.vypisVsehoNaRadku());
        }*/

        //vys1.vypisVse();
        
        //png.prirad("r9g", 10);
        //png.prirad("p17", 2);
        /*png.prirad("1ln", 1);
        png.prirad("tfi", 10);
        png.prirad("nk3", 10);
        png.prirad("il*", 10);
        png.prirad("wso", 0);
        png.prirad("xhd", 0);
        png.prirad("62e", 7);
        png.prirad("hqv", 3);
        png.prirad("h21", 2);*/



        

    }

    /**
     * inicalizace pouzitych trid
     */
    public void init(){
        
        
        

        

        //cisteni zkusebniho textu
        //tk.pouzeAbc(cet.abc);
        //System.out.println("-"+tk.getVstupni());
    }

    /**
     * Slova ktera zname predvypnlnime do abeced
     */
    public void zname(){
        //znamSlovo("9g", 11, "in");
        znamSlovo("in7wk",2,"ation");
        znamSlovo("n7z", 3,"tin");
        znamSlovo("inz", 2,"ath");
        znamZnak('6',7 , 'e');

        //znamSlovo("48hn7z76i", 0,"continued");//n
        //znamSlovo("48hn7z76ig", 0,"contingent");//n

        /*znamZnak('n',3 , 'e');
        
        znamZnak('q',12 , 'e');
        znamSlovo("n*8", 10, "and");
        znamSlovo("f4in7wk", 0, "outhere");
        
        //znamSlovo("x*", 10, "and");*/
         //vypis(0, 0);
        //vypis(1, 0);
         //znamSlovo("osb0v86n8fkxb32l", 3, "disqualification");
        //vypis(4, 0);
        /*znamSlovo("6g3j", 7, "this");
        vypis(4, 0);

        znamSlovo("6g3j", 7, "they");
        vypis(4, 0);

        znamSlovo("6g3j", 7, "tion");
        vypis(4, 0);

        znamSlovo("6g3j", 7, "thin");
        vypis(4, 0);
znamSlovo("6g3j", 7, "atio");
        vypis(4, 0);
        znamSlovo("6g3j", 7, "ever");
        vypis(4, 0);*/
        

    }
    
    public void radkoveVypisy(){
        System.out.println("-----");
        vypis(0, 0);
        vypis(1, 0);
        vypis(4, 0);
        new BiTrigramy(sifra.toLowerCase(), key, 3);
        vypis(2, 0);
        vypis(2, 1);
    }

    /**
     * prevede sifru do tabulky o t radcich/sloupcich
     * @param t
     */
    public void sifruDoTabulky(int t){
        //vytvoreni tabulky
        int x = t;
        int y = sifra.length()/t+1;
        tab = new char[x][y];
        tabt = new char[y][x];
        //zapis do tabulky
        int p = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(p<sifra.length()){
                    tab[j][i] = sifra.charAt(p);
                    tabt[i][j] = sifra.charAt(p);
                }
                p++;
            }
        }
        //info
        System.out.println("tabulka "+Arrays.deepToString(tab));
        System.out.println("tabulkaT "+Arrays.deepToString(tabt));
    }

    public void sifruDoTabulkySpecial(int t){
        //vytvoreni tabulky
        int x = t;
        int y = sifra.length()/t+1;
        tab = new char[x][y];
        tabt = new char[y][x];
        //zapis do tabulky
        int p = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(p<sifra.length()){
                    tab[j][i] = sifra.charAt(p);
                    tabt[i][j] = sifra.charAt(p);
                    if(j==11){
                        tab[j][i] = cet.posunDleAbc(sifra.charAt(p), 34);
                        tabt[i][j] = cet.posunDleAbc(sifra.charAt(p), 34);
                    }
                    if(j==9){
                        tab[j][i] = cet.posunDleAbc(sifra.charAt(p), 10);
                        tabt[i][j] = cet.posunDleAbc(sifra.charAt(p), 10);
                    }
                    if(j==10){
                        tab[j][i] = cet.posunDleAbc(sifra.charAt(p), 7);
                        tabt[i][j] = cet.posunDleAbc(sifra.charAt(p), 7);
                    }
                }
                p++;
            }
        }
        //info
        System.out.println("tabulka "+Arrays.deepToString(tab));
        System.out.println("tabulkaT "+Arrays.deepToString(tabt));
    }

    public void vypis(int typ, int cetnost){
        System.out.println(""+vypisNaRadku(typ, cetnost));
    }

    public String vypisNaRadku(int typ, int cetnost){
        String ret = "";
        for (int i = 0; i < tabt.length; i++) {
            for (int j = 0; j < tabt[0].length; j++) {
                if(typ == 0)
                    ret += tabt[i][j];
                else if(typ == 1)
                    ret +=tabCet[j].relCetnostH(tabt[i][j]);
                else if(typ == 3)
                    ret +=((tabCet[j].nejvhodnejsiZnak(tabt[i][j],cetnost)==tabt[i][j])?tabt[i][j]:' ');
                else if(typ == 2)
                    ret +=tabCet[j].nejvhodnejsiZnak(tabt[i][j],cetnost);
                else if(typ == 4)
                    ret +=tabCet[j].znamyZnak(tabt[i][j]);
                else
                    ret += Integer.toHexString(j);
            }
        }
        return ret;
    }

    public void analyzaCet(){
        //int[] hesla = {0,0,0,37,0,0,37,0,37,10,7,34,0};
        int[] hesla = {0,0,0,0,0,0,37,0,0,0,0,0,0,0,0,0,0,0,0,0,0,19,0,0,0,19};
        String s;
        double[] cetn,cetn2;
        int sum;
        int summ = 0;
        double abccz,abcen,sumcz,sumen;
        sumcz=0;sumen=0;
        for (int i = 0; i < tab.length; i++) {
            s = "";
            sum = 0;
            //System.out.println(""+String.copyValueOf(tab[i]));
            
            //cetn2 = cet.relCetnosti(String.copyValueOf(tab[i]));
            //System.out.print(" +"+tk.doStr(cet.dleCetnosti(cetn2)));
            //cet.init(cet.dleCetnosti(cetn2));
            cetn = cet.relCetnosti(String.copyValueOf(tab[i]));
            for (double c : cetn) {
                s+=(c==0)?" ":(c>9)?"*":" ";
                if(c==0) sum++;
            }
            summ += sum;
            abcen = cet.relPomCetnostiS(cetn, cet.obecCet);
            sumen+=abcen;
            System.out.println(i+" "+s+" "+sum+") en("+abcen+")"+tk.doStr(cet.dleCetnosti(cetn)));
        }
        System.out.println("cz "+(float)sumcz/key);
        System.out.println("en "+(float)sumen/key);
        System.out.println("sum "+(float)summ/key);
        
        System.out.println("hesla");
        for (int i = 0; i < tab.length; i++) {
            s = "";
            //System.out.println(""+String.copyValueOf(tab[i]));
            for (double c : posun(cet.relCetnosti(String.copyValueOf(tab[i])),hesla[i])) {
                s+=(c==0.0)?"_":(c>7)?"*":"-";
            }
            if(hesla[i]!=0){
            System.out.println(Integer.toHexString(i)+" "+s);
            }
        }
    }
    
    public void zkouskaCet(){
        for (int x = 0; x < key; x++) {
            for (int i = 0; i < key; i++) {
            for (int j = 0; j < 37; j++) {
                double a = cet.relPomCetnosti(posun(cet.relCetnosti(String.copyValueOf(tab[x])),0), posun(cet.relCetnosti(String.copyValueOf(tab[i])),j));
                if(a<1.9&&x!=i)
                System.out.println(x+"x"+i+"("+j+") "+a+" |"+cet.relPomCetnostiNul(posun(cet.relCetnosti(String.copyValueOf(tab[x])),0), posun(cet.relCetnosti(String.copyValueOf(tab[i])),j)));
            }
        }
        }
    }

    
    /**
     * Posouva pole o urcity pocet mist doleva
     * @param pole
     * @param posun
     * @return
     */
    public double[] posun(double[] pole,int posun){
        //posun 0-12
        int delpol = pole.length;
        posun = posun%delpol;
        double[] ret = new double[delpol];
        System.arraycopy(pole, posun, ret, 0, delpol-posun);
        System.arraycopy(pole, 0, ret, delpol-posun, posun);
        return ret;
    }


    public void podrobnyVypisCetnosti(){
        char[] serazCet;
        String[] radky = new String[38];
        radky[0]="";
        for (int i = 0; i < tabCet.length; i++) {
            Cetnost ct = tabCet[i];
            serazCet = cet.dleCetnosti(ct.getRelcet());
            System.out.println("|"+i+" ");
            radky[0] += ""+i+"+"+i+"+";
            for (int j = 0; j < serazCet.length; j++) {
                if(i==0)radky[j+1]=""+serazCet[j]+"+"+ct.relCetnostZnaku(serazCet[j])+"+";
                else radky[j+1]+=""+serazCet[j]+"+"+ct.relCetnostZnaku(serazCet[j])+"+";
            }
        }
        System.out.println(""+Arrays.toString(radky));
        
    }

    public void nactiCetnosti(){
        // vytvori tabulku cetnosti pro kazny klic
        tabCet = new Cetnost[key];
        for (int i = 0; i < key; i++) {
            tabCet[i] = new Cetnost(cet, String.copyValueOf(tab[i]));
        }
    }

    public void znamZnak(char c,int i,char z){
        tabCet[i].vlozZname(z,c);
    }

    public void znamSlovo(String s,int i,String z){
        for (int j = 0; j < z.length(); j++) {
            znamZnak(s.charAt(j), (i+j)%key, z.charAt(j));
        }
    }

    public boolean kolizeZnamSlova(String s,int i,String z){
        for (int j = 0; j < z.length(); j++) {
            if(tabCet[(i+j)%key].kolizeZnamehoZnaku(z.charAt(j), s.charAt(j)))return true;
        }
        return false;
    }

    public double[] relCetnostSlova(String s, int zac){
        double[] ret = new double[s.length()];
        for (int i = 0; i < ret.length; i++) {
            ret[i]=tabCet[(zac+i)%key].relCetnostZnaku(s.charAt(i));
        }
        return ret;
    }

    public void zkusSlovo(String ss,int poz,String zs,boolean vyp){

            if(kolizeZnamSlova(ss, poz, zs)){
                //System.out.println("kolize "+zs);
            }
            else
            {
             znamSlovo(ss, poz, zs);
             if(vyp)vypis(4, 0);
            }

    }

    public void najdiZkusSlovo(String ss,int poz,boolean smaz){
        
        vyh.projdi(this.relCetnostSlova(ss, poz), ss.length(), ss.length());
        String[] sa = vyh.vysledekDoPole();
        for (int i = 0; i < sa.length; i++) {
            if(smaz) resetZname();
            zkusSlovo(ss, poz, sa[i],true);
        }
    }

    public void najdiZkusNgram(String ss,int poz,boolean smaz){

        String[] sa = png.priradDoPole(ss, poz);
        for (int i = 0; i < sa.length; i++) {
            if(smaz) resetZname();
            zkusSlovo(ss, poz, sa[i],true);
        }
    }

    /**
     * vyzkousi vsechny kombinace dle slovniku ktere sedi
     * @param ss1
     * @param poz1
     * @param p1
     * @param ss2
     * @param poz2
     * @param p2
     */
    public void najdiZkusDvojici(String ss1,int poz1,boolean gramy1,String ss2,int poz2,boolean gramy2){
        String[] sa1,sa2;
        if(gramy1){
            sa1 = png.priradDoPole(ss1, poz1);
            
        }else{
            vyh.projdi(this.relCetnostSlova(ss1, poz1), ss1.length(), ss1.length());
            sa1 = vyh.vysledekDoPole();
            
        }

        if(gramy2){
            sa2 = png.priradDoPole(ss2, poz2);
        }else{
            vyh.projdi(this.relCetnostSlova(ss2, poz2), ss2.length(), ss2.length());
            sa2 = vyh.vysledekDoPole();
        }
        
        System.out.println(""+Arrays.toString(sa1));
        System.out.println(""+Arrays.toString(sa2));
        for (int i = 0; i < sa1.length; i++) {
            for (int j = 0; j < sa2.length; j++) {
                resetZname();
                zkusSlovo(ss1, poz1, sa1[i],false);
                zkusSlovo(ss2, poz2, sa2[j],true);
                //System.out.println(ss1+" "+sa1[i]+" " + ss2+" "+sa2[j]);
            }
        }

    }


    public void najdiZkusNGramy(){
        String[] s1,s2,s3;
        String[] sif = {"p17","*14","14q"};
        int[] pozs = {2,2,3};
        s1 = png.priradDoPole(sif[0], pozs[0]);
        s2 = png.priradDoPole(sif[1], pozs[1]);
        s3 = png.priradDoPole(sif[2], pozs[2]);
        
        for (int k = 0; k < s3.length; k++) {
            for (int l = 0; l < s2.length; l++) {
                for (int m = 0; m < s1.length; m++) {
                    resetZname();
                    zname();
                    zkusSlovo(sif[0], pozs[0], s1[m],false);
                    zkusSlovo(sif[1], pozs[1], s2[l],false);
                    zkusSlovo(sif[2], pozs[2], s2[k],true);
                    
                }
            }
        }
        

    }


    /**
     * smaze vsechny zname znaky v cetnostech
     */
    public void resetZname(){
        for (int i = 0; i < key; i++) {
            tabCet[i].resetZname();

        }
        zname();
    }


}
