/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Czat;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Grzechu
 */
public class BazaElement {
    String prefiks;
    ArrayList<String> sufiks;

    public BazaElement(String prefiks, String sufiks) {
        this.sufiks = new ArrayList<>();
        
        this.prefiks = prefiks;
        this.sufiks.add(sufiks);
    }
    
    public BazaElement(String prefiks, ArrayList<String> sufiks){
        this.prefiks = prefiks;
        this.sufiks = sufiks;
    }
    
    public void dodajSufiks (String sufiks){
        this.sufiks.add(sufiks);
    }
    
    public String losujSufiks(){
        Random r = new Random();
        int numer = Math.abs(r.nextInt()) % sufiks.size();
        return sufiks.get(numer);
    }
    
    @Override
    public String toString() {
        String tekst = new String();
        tekst = prefiks + "|" + wypiszSufiksy();
        return tekst;
    }

    private String wypiszSufiksy() {
        String sufiksy = new String();
        for (int i = 0; i < sufiks.size(); i++)
            sufiksy += sufiks.get(i) + " ";
        return sufiksy;
    }
    
}
