/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Czat;

/**
 *
 * @author Grzechu
 */
public class StatystykaElement implements Comparable<StatystykaElement>{
    public String wyraz;
    public int ileRazy;
    
    public StatystykaElement (String wyraz){
        this.wyraz = wyraz;
        this.ileRazy = 1;
    }
    
    @Override
    public int compareTo(StatystykaElement o) {
    int pom = o.ileRazy - this.ileRazy;
    return pom;
    }
    
    
    
    
}
