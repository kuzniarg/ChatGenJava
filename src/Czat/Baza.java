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
public class Baza {
    public static ArrayList<Element> baza;
    public static int N_gram = 4;
    
    public static void dodajDoBazy (String tekst){
        String prefiks = wyciagnijPrefiks(tekst), sufiks = wyciagnijSufiks(tekst), pom;
        boolean petla = true;
        int warunek = -1;
        
        while (petla){
            for (int i = 0; i < baza.size(); i++)
            {
                if (prefiks.equals(baza.get(i).prefiks)){
                    warunek = i;
                    break;
                } else warunek = -1;
            }
            if (warunek > 0)
                baza.get(warunek).dodajSufiks(sufiks);
            else
                baza.add(new Element(prefiks, sufiks));
            
            pom = tekst.substring(tekst.indexOf(' ')+1);
            tekst = pom;

            prefiks = wyciagnijPrefiks(tekst);
            sufiks = wyciagnijSufiks(tekst);
            if (prefiks == null || sufiks == null)
                petla = false;
        }
    }
    
    public static String generujTekst (String probka){
        String tekst = "Test", pom;
        int i = 0, spacja = 0;
        boolean szukajBaza = false;
        
        while (i <= probka.length() - 1){
            if (probka.charAt(i) == ' ')
                spacja++;
            i++;
        }
        
        i=0;
        if (spacja == N_gram - 2){
            szukajBaza = true;
        } else if (spacja > N_gram - 2){
            
            szukajBaza = true;
        }
        
        if (szukajBaza){
            for (i = 0; i < baza.size(); i++){
                if (probka.compareTo(baza.get(i).prefiks) == 0){
                    tekst = losujTekst(i);
                    return tekst;
                }
            }
        }
        
        Random r = new Random();
        int rand = Math.abs(r.nextInt()) % baza.size();
        while( Character.isUpperCase(baza.get(rand).prefiks.charAt(0)) )
            rand = Math.abs(r.nextInt()) % baza.size();
        tekst = losujTekst(rand);
        
        return tekst;
    }

    private static String wyciagnijPrefiks(String tekst) {
        String wyrazy = "";
        String pom;
        int spacja;
        
        for (int i = 0; i < N_gram - 1; i++)
        {
            spacja = tekst.indexOf(" ");
            if (spacja < 0)
                return null;
            wyrazy += tekst.substring(0, spacja);

            pom = tekst.substring(spacja+1);
            tekst = pom;
            if (i != N_gram -2)
                wyrazy += " ";
        }
        return wyrazy;
    }
    
    
    private static String wyciagnijSufiks(String tekst) {
        String sufiks = "";
        char tablica[] = tekst.toCharArray();
        int j=0, i;
        
        for (i = 0; i < N_gram - 1; i++)
        {
            while (tablica[j] != ' '){
                tablica[j++] = '#';
                if (j >= tablica.length)
                    return null;
                if (tablica[j] == '\n')
                    tablica[j] = ' ';
            }
            tablica[j] = '#';
        }
        
        j=0; i=0;
        
        while (Character.isAlphabetic(tablica[i])){
            if (tablica[i] != '#')
                tablica[j++] = tablica[i];
            i++;
        }
        if (tablica[i] == '.')
            tablica[j] = '.';
        
        i = 0;
        while (tablica[i] != '#')
            sufiks += tablica[i++];
        return sufiks;
    }
    

    public static String druk (){
        StringBuilder wydruk = new StringBuilder();
        for (int i = 0; i < baza.size(); i++){
            wydruk.append(baza.get(i).prefiks).append(": ").append(baza.get(i).sufiks.size()).append(" sufiksy: ");
            for (int j = 0; j < baza.get(i).sufiks.size(); j++)
                wydruk.append(baza.get(i).sufiks.get(j)).append(", ");
            wydruk.append("\n");
        }
        return wydruk.toString();
    }

    private static String losujTekst(int i) {
        return "Losuj";
    }
}

