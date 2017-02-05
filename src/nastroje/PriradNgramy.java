/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nastroje;

import datTyp.NGram;
import datTyp.Slovo;
import java.util.*;
import tridy.Cetnosti;
import tridy.Sifra;

/**
 * Trida pro prirazeni nejcastejsich bi a trigramu na urcitou pozici
 * @author cechvac1
 */
public class PriradNgramy {
    private ArrayList<NGram> realBiGramy;
    private ArrayList<NGram> realTriGramy;
    private Sifra sif;
    private Cetnosti cet;
    private double limit = 4;

    public PriradNgramy(Sifra sif, Cetnosti cet) {
        this.sif = sif;
        this.cet = cet;
        napln();
    }
    
    
    /*inicalizacni metoda pro ngramy
     * u vsech zadanych ngramu je vypoctena cetnost ktera je treba porovnavat
     * 
     */
    public void napln(){
        String[] trigrams = {"the","and","ing","her","tha","hat","his","you","ere","dth","ent","eth","for","nth","thi","she","was","hes","ith","oth","int","not","wit","edt","ver","ter","all","ion","fth","sth","oft","had","rea","est","ers","ght","ess","him","ear","ean","ave","one","hec","tin","res","hew","ont","ati","hem","esa","eve","nce","eda","aid","hin","ndt","hen","but","ome","ill","ast","rth","oul","att","sto","sai","ath","oun","ert","san","hou","our","out","hea"};
        String[] bigrams = {"th","he","in","er","an","re","nd","ed","ha","es","ou","to","at","en","on","ea","nt","st","hi","ng","is","it","as","or","et","te","ti","se","ar","le","of","sa","ve","me","al","no","ne","ll","el","sh","ot","tt","ro","de","ta","dt","ri","wa","wh","ho","si","so","ra","ec","yo","be","ad","ss","da","li","om","rt","ew","di","co","ee","ma","em","ai","ut","wi","ce","ow","ch","rs"};
        
            realBiGramy = new ArrayList<NGram>();
            for (int i = 0; i < bigrams.length; i++) {
                realBiGramy.add(new NGram(bigrams[i], cet.pravaCetnostSlova(bigrams[i])));
            }
        
            realTriGramy = new ArrayList<NGram>();
            for (int i = 0; i < trigrams.length; i++) {
                realTriGramy.add(new NGram(trigrams[i], cet.pravaCetnostSlova(trigrams[i])));

            
        }
    }

    /**
     * Priradi nejpravdepodobnejsi ngramy a vypise na vystup
     * @param s
     * @param k
     */
    public void prirad(String s,int k){
        double[] cethl = sif.relCetnostSlova(s,k);
        double hod;
        System.out.println("hledam alternativy pro "+s+" - "+Arrays.toString(cethl));
        if(s.length()==3){
            for (int i = 0; i < realTriGramy.size(); i++) {
            hod = cet.relPomCetnosti(cethl, realTriGramy.get(i).getCetnost());
            hod = (double)((int)(hod*100))/100;
            if(hod<limit)
            System.out.println(realTriGramy.get(i).getText()+" "+hod+" - "+Arrays.toString(realTriGramy.get(i).getCetnost()));

        }
        }
        if(s.length()==2){
            for (int i = 0; i < realBiGramy.size(); i++) {
            hod = cet.relPomCetnosti(cethl, realBiGramy.get(i).getCetnost());
            hod = (double)((int)(hod*100))/100;
            if(hod<limit)
            System.out.println(realBiGramy.get(i).getText()+" "+hod+" - "+Arrays.toString(realBiGramy.get(i).getCetnost()));

        }
        }
    }

    /**
     * nejpravdepodobnejsi ngramy vraci v poli a zaroven na vystup
     * @param s
     * @param k
     * @return
     */
    public String[] priradDoPole(String s,int k){
        List<Slovo> ret = new ArrayList<Slovo>();
        double[] cethl = sif.relCetnostSlova(s,k);
        double hod;
        System.out.println("hledam alternativy pro "+s+" - "+Arrays.toString(cethl));
        if(s.length()==3){
            for (int i = 0; i < realTriGramy.size(); i++) {
            hod = cet.relPomCetnosti(cethl, realTriGramy.get(i).getCetnost());
            hod = (double)((int)(hod*100))/100;
            if(hod<limit){
            System.out.println(realTriGramy.get(i).getText()+" "+hod+" - "+Arrays.toString(realTriGramy.get(i).getCetnost()));
            ret.add(new Slovo(realTriGramy.get(i).getText(),hod));
            }

        }
        }
        if(s.length()==2){
            for (int i = 0; i < realBiGramy.size(); i++) {
            hod = cet.relPomCetnosti(cethl, realBiGramy.get(i).getCetnost());
            hod = (double)((int)(hod*100))/100;
            if(hod<limit){
            System.out.println(realBiGramy.get(i).getText()+" "+hod+" - "+Arrays.toString(realBiGramy.get(i).getCetnost()));
            ret.add(new Slovo(realBiGramy.get(i).getText(),hod));
            }

        }
        }
        String[] rett = new String[ret.size()];
        Collections.sort(ret);
        int i = 0;
        for (Slovo st : ret) {
            System.out.println(st.getText()+" "+st.getCislo());
            rett[i]=st.getText();
            i++;
        }
        
        return rett;
    }


}
