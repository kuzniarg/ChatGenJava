/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Czat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Grzechu
 */
public class Baza {

    public static ArrayList<BazaElement> baza;
    public static int N_gram;
    static String Imie;

    public static void dodajDoBazy(String tekst) {
        String prefiks = wyciagnijPrefiks(tekst), sufiks = wyciagnijSufiks(tekst), pom;
        boolean petla = true;
        int warunek = -1;

        if (prefiks == null || sufiks == null) {
            return;
        }

        while (petla) {
            for (int i = 0; i < baza.size(); i++) {
                if (prefiks.equals(baza.get(i).prefiks)) {
                    warunek = i;
                    break;
                } else {
                    warunek = -1;
                }
            }
            if (warunek > 0) {
                baza.get(warunek).dodajSufiks(sufiks);
            } else {
                baza.add(new BazaElement(prefiks, sufiks));
            }

            pom = tekst.substring(tekst.indexOf(' ') + 1);
            tekst = pom;

            prefiks = wyciagnijPrefiks(tekst);
            sufiks = wyciagnijSufiks(tekst);
            if (prefiks == null || sufiks == null) {
                petla = false;
            }
        }
    }

    public static String generujTekst() {
        String tekst = "";

        Random r = new Random();
        int numer = Math.abs(r.nextInt()) % baza.size();
        while (!Character.isUpperCase(baza.get(numer).prefiks.charAt(0)) || baza.get(numer).prefiks.indexOf('.') != -1) {
            numer = Math.abs(r.nextInt()) % baza.size();
        }

        int ileZdan = Math.abs(r.nextInt()) % 3 + 1;
        int i = 0;
        String zdanie = baza.get(numer).prefiks;
        String prefiks = zdanie;
        String pom;
        while (i < ileZdan) {
            pom = " " + baza.get(numer).losujSufiks();
            zdanie += pom;
            prefiks += pom;

            pom = prefiks.substring(prefiks.indexOf(' ') + 1);
            prefiks = pom;

            numer = znajdzPrefiks(prefiks);
            if (numer == -1) {
                zdanie += ".";
            }

            if (zdanie.contains(".") || zdanie.contains("!") || zdanie.contains("?")) {
                i++;
                tekst += zdanie + " ";
                numer = Math.abs(r.nextInt()) % baza.size();
                while (!Character.isUpperCase(baza.get(numer).prefiks.charAt(0)) || baza.get(numer).prefiks.indexOf('.') != -1) {
                    numer = Math.abs(r.nextInt()) % baza.size();
                }
                zdanie = baza.get(numer).prefiks;
                prefiks = zdanie;
            }
        }
        return tekst;
    }

    public static String wyciagnijPrefiks(String tekst) {
        String prefiks = "";
        char tablica[] = new char[tekst.length()];
        int i = 0, j = 0, spacja;

        while (i < tekst.length()) {
            if (Character.isLetter(tekst.charAt(i)) || tekst.charAt(i) == ' '
                    || tekst.charAt(i) == '.' || tekst.charAt(i) == ','
                    || tekst.charAt(i) == '!' || tekst.charAt(i) == '?') {
                tablica[j] = tekst.charAt(i);
                j++;
            }
            if (tekst.charAt(i) == '\n') {
                tablica[j] = ' ';
                j++;
            }

            i++;
        }

        for (i = 0; i < N_gram - 1; i++) {
            j = 0;
            spacja = -1;
            while (j < tekst.length()) {
                if (tablica[j] == ' ') {
                    spacja = j;
                    tablica[spacja] = '@';
                    break;
                }
                j++;
            }
            if (i == tekst.length() || spacja == -1) {
                return null;
            }

            if (i == N_gram - 2) {
                tablica[spacja] = '#';
            }
        }
        i = 0;
        while (i < tekst.length()) {

            if (tablica[i] == '@') {
                tablica[i] = ' ';
            }
            if (tablica[i] == '#') {
                break;
            }
            prefiks += tablica[i];
            i++;
        }
        return prefiks;
    }

    public static String wyciagnijSufiks(String tekst) {
        String sufiks = "";
        char tablica[] = new char[tekst.length()];
        int j = 0, i = 0;

        while (i < tekst.length()) {
            if (Character.isLetter(tekst.charAt(i)) || tekst.charAt(i) == ' '
                    || tekst.charAt(i) == '.' || tekst.charAt(i) == ','
                    || tekst.charAt(i) == '!' || tekst.charAt(i) == '?') {
                tablica[j] = tekst.charAt(i);
                j++;
            }
            if (tekst.charAt(i) == '\n') {
                tablica[j] = ' ';
                j++;
            }
            i++;
        }

        j = 0;
        for (i = 0; i < N_gram - 1; i++) {
            while (tablica[j] != ' ') {
                tablica[j++] = '#';
                if (j >= tablica.length) {
                    return null;
                }
                if (tablica[j] == '\n') {
                    tablica[j] = ' ';
                }
            }
            tablica[j] = '#';
        }

        j = 0;
        i = 0;

        while (Character.isAlphabetic(tablica[i])) {
            if (tablica[i] != '#') {
                tablica[j++] = tablica[i];
            }
            i++;
        }
        if (tablica[i] == '.') {
            tablica[j] = '.';
        }

        i = 0;
        while (tablica[i] == '#' && i < tablica.length - 1) {
            i++;
        }

        while (tablica[i] != ' ' && i < tablica.length - 1) {
            sufiks += tablica[i++];
        }

        return sufiks;
    }

    public static int znajdzPrefiks(String prefiks) {
        int indeks = 0;

        while (indeks < baza.size()) {
            if (prefiks.equals(baza.get(indeks).prefiks)) {
                break;
            }
            indeks++;
        }
        if (indeks == baza.size()) {
            return -1;
        }
        return indeks;
    }

    static String[] zapiszBaze() {
        String[] wynik = new String[baza.size()];

        for (int i = 0; i < baza.size(); i++) {
            wynik[i] = baza.get(i).toString();
        }

        return wynik;
    }

    static void wczytajBaze() throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader("src\\Dane\\Baza_" + N_gram + ".txt");
        BufferedReader bufferReader = new BufferedReader(fileReader);
        String linia;
        while ((linia = bufferReader.readLine()) != null) {
            String prefiks = linia.substring(0, linia.indexOf('|'));
            ArrayList<String> sufiks = new ArrayList<>();

            int i = linia.indexOf('|') + 1;
            int j = i;
            while (i < linia.length()) {
                if (linia.charAt(i) == ' ') {
                    sufiks.add(linia.substring(j, i));
                    j = i + 1;
                }
                i++;
            }

            wczytajDoBazy(prefiks, sufiks);
        }
    }

    private static void wczytajDoBazy(String prefiks, ArrayList<String> sufiks) {
        int i = 0, j = 0, k = 0;
        while (i < baza.size()) {
            if (prefiks.equals(baza.get(i).prefiks)) {
                while (j < sufiks.size()) {
                    while (k < baza.get(i).sufiks.size()) {
                        if (!sufiks.get(j).equals(baza.get(i).sufiks.get(k))) {
                            k++;
                        } else {
                            k = 0;
                            break;
                        }
                    }
                    if (k > 0)
                        baza.get(i).dodajSufiks(sufiks.get(j));
                    j++;
                    k = 0;
                }
                j = 0;
            }
            i++;
        }
    }
}
