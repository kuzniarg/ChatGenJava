/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Czat;

import java.util.ArrayList;

/**
 *
 * @author Grzechu
 */
public class Element {
    String prefiks;
    public ArrayList<String> sufiks;

    public Element(String prefiks, String sufiks) {
        this.sufiks = new ArrayList<>();
        
        this.prefiks = prefiks;
        this.sufiks.add(sufiks);
    }
    
    public void dodajSufiks (String sufiks){
        this.sufiks.add(sufiks);
    }
    
}
