/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tridy;
import java.io.*;
import java.text.Normalizer;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *Slovnik slov
 * @author cecvac1
 */
public class Slovnik{
    public Set<String> seznam = new TreeSet<String>();// set - zarucuje ze se slova neopakuji a razeni
    
    public Slovnik(String soubor,boolean temp){
        try {
            if(temp)
                zTempSouboru(soubor);
            else
                NactiSoubor(soubor);
        } catch (IOException ex) {
            Logger.getLogger(Slovnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        //doSouboru("temp"+soubor);
    }
   
    /**
     * nacte soubor se slovnikem
     * @param soubor
     * @throws IOException
     */
    private void NactiSoubor(String soubor) throws IOException {
        
        String souborI = soubor;
        FileInputStream in = new FileInputStream(souborI);
        
        int znak,zn, nSlovCelkem = 0;
        String aktSlovo = "";
                
        //zapisuje seznam slov a jejich pocty do dvou arraylistu
        while (in.available() > 0) {    //dokud neni konec souboru cte slova
            aktSlovo = "";
            while (in.available() > 0) {    //precte 1 slovo
                znak = in.read();   //precte ze souboru znak
                if(znak>=192){
                    znak = (znak-192)*64 + (in.read()-128);
                }
                //System.out.println(""+znak);
                //znaky, ktere ukoncuji slovo
                if(znak==13) break; //?
                if(znak==10) break; //enter
                if(znak==32) break; //mezera
                if(znak==46) break; //.
                if(znak==44) break; //,
                if(znak==59) break; //;
                if(znak==63) break; //?
                if(znak==33) break; //!
                if(znak==45) break; //-
                if(znak==132) break; //"
                if(znak==147) break; //"
                if(znak==40) break; //(
                if(znak==41) break; //)
                if(znak==47) break; // /
                if(znak==91) break; // [
                if(znak==93) break; // ]
                
                aktSlovo += (char)znak;
            }
            if(!aktSlovo.equals("")){
                nSlovCelkem++;
                //seznam.add(aktSlovo);
                seznam.add(noCz(aktSlovo).toLowerCase());
             }
        }
        in.close();
   }
    
    /**
     *  porovnava jedntliva slova mezi sebou
     * @param slovo
     * @param pismo
     * @return
     */
    private static boolean porovnej(String slovo,String pismo){
        int[] znaky;
        boolean je = true;
        znaky = new int[pismo.length()];
        for(int i=0;i<pismo.length();i++){
            znaky[i]=pismo.charAt(i);
        }
        zk:for(int i=0;i<slovo.length();i++){
           
            if(!je) break zk;
            je=false;
            pi:for(int j=0;j<znaky.length;j++){
                
                if(slovo.charAt(i)==(char)znaky[j]){
                    znaky[j]=33;
                    
                    je = true;
                    break pi;
                }
            }
        }
        if(je){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * odstrani ceske znaky
     * @param vstup
     * @return
     */
    private String noCz(String vstup){
        String temp = Normalizer.normalize(vstup, Normalizer.Form.NFKD);
            return temp.replaceAll("[^\\p{ASCII}]", "");
    }

    /**
     * ulozi prave nactenz slovnik do temp souboru
     * @param filename
     */
    public void doSouboru(String filename){

        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filename));
            for (String sl : seznam) {
                bufferedWriter.write(sl);
                bufferedWriter.newLine();
            }
            

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * nacte slovnik z temp souboru
     * @param filename
     */
    public void zTempSouboru(String filename){

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filename));
            String line = "";
            while((line = br.readLine()) != null) seznam.add(line);


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}
