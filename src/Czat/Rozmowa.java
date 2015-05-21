/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Czat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Grzechu
 */
public class Rozmowa {
    static String rozmowa = null;
    static String odpowiedzi = null;
    
    public static String botPrzywitanie(){
        String przywitaj = "Symulator czatu z botem Gniewomirem generujący tekst na podstawie plików wejściowych oraz wiadomości użytkownika.\n\n"
                         + "Wykonał: Grzegorz Kuźniarski (271 068, gr 1, Informatyka, Wydział Elektryczny)\n"
                         + "----------------------------------------------------------------\n\n";
        przywitaj += botInfo();
        przywitaj += "Dzień dobry.\n\n";
        
        rozmowa = przywitaj;
        return rozmowa;
    }
    
    private static String botInfo(){
        String info = "";
        SimpleDateFormat godzina = new SimpleDateFormat("kk:mm:ss");
        info += godzina.format(new Date());
        info+= "  Gniewomir\n";
        
        return info;
    }
    
    private static String jaInfo(){
        String info = "";
        SimpleDateFormat godzina = new SimpleDateFormat("kk:mm:ss");
        info += godzina.format(new Date());
        info+= "  Ja\n";
        
        return info;
    }
    
    public static String wyslijWiadomosc(String wiadomosc){
        if ('\n' == wiadomosc.charAt(wiadomosc.length()-1))
            wiadomosc = wiadomosc.substring(0, wiadomosc.length()-1);
        
        if ("".equals(wiadomosc))
            rozmowa += botNierozmowny() + "\n";
        else{
            rozmowa+= jaInfo();
            rozmowa += wiadomosc + "\n";
        }
        rozmowa += "\n";
        return rozmowa;
    }
    
    
    private static String botNierozmowny(){
        String tekst = "";
        tekst += botInfo();
        
        int los = 0;
        Random r = new Random();
        los = Math.abs(r.nextInt()) % 7;
        
        if (los == 0)
            tekst += "Czemu nic nie mówisz?";
        else if (los == 1)
            tekst += "Powiedz coś.";
        else if (los == 2)
            tekst += "Jesteś tam?";
        else if (los == 3)
            tekst += "Halo, halo?";
        else if (los == 4)
            tekst += "Odezwij się.";
        else if (los == 5)
            tekst += "Porozmawiaj ze mną.";
        else if (los == 6)
            tekst += ":C";
        
        return tekst;
    }
    
    public static String botOdpowiedz(){
        
        return rozmowa;
    }
}
