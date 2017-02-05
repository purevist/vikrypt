/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tridy;

/**
 *
 * @author Sienu
 */
public class Transposition {
    public char[] secret;
    public char[] password;
    public int passlen;
    public char[][] decoded;
    
    public Transposition(){
        
    }
    
    public void setSecret(String sec){
        secret = new char[sec.length()];
        sec.toUpperCase().getChars(0, sec.length(), secret, 0);
        System.out.println(""+strArr(secret)+" n>"+sec.length());
    }
    
    private String strArr(char[] arr){
        String ret = "";
        for (char c : arr) {
            ret += c;
        }
        return ret;
    }
    
    private void printTable(char[][] tab){
        for (int y = 0; y < tab.length; y++) {
            System.out.println(strArr(tab[y]));
        }
    }
    
    public void decodeToTab(int col){
        decoded = new char[col][(secret.length/col+1)];
        System.out.println(col+"-"+(secret.length/col+1));
        int row = 0;
        for (int i = 0; i < secret.length; i++) {
            decoded[i%col][i/col] = secret[i];
            System.out.println(i+"- "+i%col+" "+i/col);
            row++;
        }
        printTable(decoded);
        
    }
    
    
}
