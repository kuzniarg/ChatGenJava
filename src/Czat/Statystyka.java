/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Czat;

import static Czat.Okno.progresStaty1;
import static Czat.Okno.progresStaty2;
import static Czat.Okno.progresStaty3;
import static Czat.Okno.wyrazStaty1;
import static Czat.Okno.wyrazStaty2;
import static Czat.Okno.wyrazStaty3;
import java.util.ArrayList;

/**
 *
 * @author Grzechu
 */
public class Statystyka {

    public static ArrayList<StatystykaElement> statystyka;
    public static int ileRazem = 0;

    public static void dodajDoStatystyki(String tekst) {
        if (tekst == null) {
            return;
        }
        String wyraz, pom;
        int spacja, i = 0, j = 0;
        char tablica[] = new char[tekst.length()];

        pom = tekst.toLowerCase();
        tekst = pom;
        pom = "";

        while (i < tekst.length()) {
            if (Character.isLetter(tekst.charAt(i)) || tekst.charAt(i) == ' ') {
                tablica[j] = tekst.charAt(i);
                j++;
            }
            if (tekst.charAt(i) == '\n') {
                tablica[j] = ' ';
                j++;
            }
            i++;
        }
        while (j < tekst.length())
            tablica[j++] = '@';

        i = 0;
        while (i < tekst.length()) {
            pom += tablica[i];
            i++;
        }
        tekst = pom;

        while (true) {
            spacja = tekst.indexOf(' ');
            if (spacja == -1) {
                wyraz = tekst.substring(0, tekst.indexOf('@'));
                dodajElement(wyraz);
                break;
            } else {
                wyraz = tekst.substring(0, spacja);
                pom = tekst.substring(spacja + 1);
                tekst = pom;
            }
            dodajElement(wyraz);
        }
        aktualizujStatystyki();
    }

    private static void dodajElement(String wyraz) {
        if ("".equals(wyraz) || " ".equals(wyraz) || wyraz == null )
            return;
        
        int i = 0;
        ileRazem++;
        
        while (i < statystyka.size()) {
            if ( wyraz.equals(statystyka.get(i).wyraz) ) {
                statystyka.get(i).ileRazy++;
                break;
            }
            i++;
        }
        if (i == statystyka.size()) {
            statystyka.add(new StatystykaElement(wyraz));
        }
    }

    private static void aktualizujStatystyki() {
        statystyka.sort(null);
        if (statystyka.get(0).wyraz.length() > 1)
            wyrazStaty1.setText(Character.toUpperCase(statystyka.get(0).wyraz.charAt(0)) + statystyka.get(0).wyraz.substring(1) + " - " + statystyka.get(0).ileRazy);
        else wyrazStaty1.setText(Character.toUpperCase(statystyka.get(0).wyraz.charAt(0)) + " - " + statystyka.get(0).ileRazy);
        
        if (statystyka.get(1).wyraz.length() > 1)
            wyrazStaty2.setText(Character.toUpperCase(statystyka.get(1).wyraz.charAt(0)) + statystyka.get(1).wyraz.substring(1) + " - " + statystyka.get(1).ileRazy);
        else wyrazStaty1.setText(Character.toUpperCase(statystyka.get(1).wyraz.charAt(0)) + " - " + statystyka.get(1).ileRazy);
        
        if (statystyka.get(2).wyraz.length() > 1)
            wyrazStaty3.setText(Character.toUpperCase(statystyka.get(2).wyraz.charAt(0)) + statystyka.get(2).wyraz.substring(1) + " - " + statystyka.get(2).ileRazy);
        else wyrazStaty1.setText(Character.toUpperCase(statystyka.get(2).wyraz.charAt(0)) + " - " + statystyka.get(2).ileRazy);
        
        progresStaty1.setValue((int) (100.0*statystyka.get(0).ileRazy / ileRazem));
        progresStaty2.setValue((int) (100.0*statystyka.get(1).ileRazy / ileRazem));
        progresStaty3.setValue((int) (100.0*statystyka.get(2).ileRazy / ileRazem));
    }
}
