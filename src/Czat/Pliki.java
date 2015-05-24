/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Czat;

import static Czat.Baza.dodajDoBazy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Grzechu
 */
public class Pliki {

    public static boolean wczytajPlik(File plik) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(plik);
        BufferedReader bufferReader = new BufferedReader(fileReader);
        String linia, tekst = "";
        while((linia = bufferReader.readLine()) != null) {
            tekst = linia + " ";
        }
        fileReader.close();
        dodajDoBazy(tekst);
        return true;
    }
}
