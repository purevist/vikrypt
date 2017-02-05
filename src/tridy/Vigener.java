/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tridy;

import java.util.Arrays;

/**
 *
 * @author Sienu
 */
public class Vigener {
    //public char[] mainAbc;
    public int delka;
    public String mainAbc;//format hlavni abecedy pro tabulku
    public char[] mainAbcArr;//format hlavni abecedy pro tabulku v poli
    public String innerAbc;
    
    public char[][] vigTable;
    
    public char[] secret;
    public char[] password;
    public int passlen;
    public char[] decoded;
    
    
    public Vigener(String inAbc){
        //init
        innerAbc = inAbc.toUpperCase();
        mainAbc = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        //mainAbc = innerAbc ;
        delka = mainAbc.length();
        
        mainAbcArr = new char[delka];
        mainAbc.getChars(0, delka, mainAbcArr, 0);
        
        
        vigTable = fillTable(innerAbc, 1);
        
        System.out.println("delka " + delka);
        printTable(vigTable);
        
                
    }
    
    private char[][] fillTable(String innerAbc, int shift){
        char[][] vTable = new char[delka][delka];
        for (int x = 0; x < delka; x++) {
            for (int y = 0; y < vTable.length; y++) {
                vTable[y][x] = innerAbc.charAt((x+shift*y)%innerAbc.length());
                
            }            
        }
        return vTable;
    }
    
    private void printTable(char[][] tab){
        System.out.println(" "+strArr(mainAbcArr));
        for (int y = 0; y < tab.length; y++) {
            System.out.println(mainAbcArr[y]+strArr(tab[y]));
        }
    }
    
    private String strArr(char[] arr){
        String ret = "";
        for (char c : arr) {
            ret += c;
        }
        return ret;
    }
    
    public void setSecret(String sec){
        secret = new char[sec.length()];
        sec.toUpperCase().getChars(0, sec.length(), secret, 0);
        System.out.println(""+strArr(secret)+" n>"+sec.length());
    }
    
    public void tryPass(String pass){
        passlen = pass.length();
        password = new char[passlen];
        pass.toUpperCase().getChars(0, passlen, password, 0);
        System.out.println("try>"+pass+" n>"+pass.length());
    }
    
    public void printDecode(){
        decode();
        System.out.println(""+strArr(decoded));
    }
    
    public void decode(){
        decoded = new char[secret.length];
        
        for (int i = 0; i < secret.length; i++) {//secret.length
            int xpos = innerAbc.indexOf(secret[i]);
            int ypos = innerAbc.indexOf(password[i%passlen]);
            //System.out.println("x>"+xpos+" y>"+ypos+" "+(xpos-ypos+delka)%delka);
            decoded[i] = (xpos<0)?secret[i]:vigTable[(xpos-ypos+delka)%delka][0];
        }
    }
    
}
