/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Czat;

import static Czat.Baza.generujTekst;
import static Czat.Statystyka.dodajDoStatystyki;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Grzechu
 */
public class Rozmowa {

    static String rozmowa = null;
    static String odpowiedzi = null;
    static Clip dzwiek = null;

    public static String botPrzywitanie() {
        String przywitaj = "Symulator czatu z botem Gniewomirem generujący tekst na podstawie plików wejściowych oraz wiadomości użytkownika.\n\n"
                + "Wykonał: Grzegorz Kuźniarski (271 068, gr 1, Informatyka, Wydział Elektryczny)\n"
                + "----------------------------------------------------------------\n\n";
        przywitaj += botInfo();
        przywitaj += "Dzień dobry. Nazywam się Gniewomir i jestem botem, który będzie miał przyjemność poprowadzić z Tobą rozmowę. Jak minął Ci dzień?\n\n";
        dodajDoStatystyki("Dzień dobry. Nazywam się Gniewomir i jestem botem, który będzie miał przyjemność poprowadzić z Tobą rozmowę. Jak minął Ci dzień?");
        Baza.dodajDoBazy("Dzień dobry. Nazywam się Gniewomir i jestem botem, który będzie miał przyjemność poprowadzić z Tobą rozmowę. Jak minął Ci dzień?");

        rozmowa = przywitaj;
        return rozmowa;
    }

    private static String botInfo() {
        String info = "";
        SimpleDateFormat godzina = new SimpleDateFormat("kk:mm:ss");
        info += godzina.format(new Date());
        info += "  Gniewomir\n";

        return info;
    }

    private static String jaInfo() {
        String info = "";
        SimpleDateFormat godzina = new SimpleDateFormat("kk:mm:ss");
        info += godzina.format(new Date());
        info += "  " + Baza.Imie + "\n";

        return info;
    }

    public static String wyslijWiadomosc(String wiadomosc) {
        if ("".equals(wiadomosc) || "\n".equals(wiadomosc)) {
            rozmowa += botNierozmowny() + "\n";
        } else {
            if ('\n' == wiadomosc.charAt(wiadomosc.length() - 1)) {
                wiadomosc = wiadomosc.substring(0, wiadomosc.length() - 1);
            }
            rozmowa += jaInfo();
            rozmowa += wiadomosc + "\n\n";
            rozmowa += botOdpowiedz();
            Baza.dodajDoBazy(wiadomosc);
        }
        rozmowa += "\n";

        if (dzwiek != null)
            dzwiek.stop();
        odtworz();
        dzwiek.start();
        
        return rozmowa;
    }

    private static String botNierozmowny() {
        String tekst = "", druk = "";
        druk += botInfo();

        int los = 0;
        Random r = new Random();
        los = Math.abs(r.nextInt()) % 6;

        if (los == 0) {
            tekst += "Czemu nic nie mówisz?";
        } else if (los == 1) {
            tekst += "Powiedz coś.";
        } else if (los == 2) {
            tekst += "Jesteś tam?";
        } else if (los == 3) {
            tekst += "Halo, halo?";
        } else if (los == 4) {
            tekst += "Odezwij się.";
        } else if (los == 5) {
            tekst += "Porozmawiaj ze mną.";
        }
        dodajDoStatystyki(tekst);
        druk += tekst;

        return druk;
    }

    public static String botOdpowiedz() {
        String tekst = "", odpowiedz = null;
        tekst += botInfo();
        odpowiedz = generujTekst();
        tekst += odpowiedz + "\n";
        dodajDoStatystyki(odpowiedz);

        return tekst;
    }

    public static void odtworz() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Rozmowa.class.getResourceAsStream("/Dane/dzwiek.wav"));
            dzwiek = AudioSystem.getClip();
            dzwiek.open(audioInputStream);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Błąd dźwięku");
        }
    }
}
