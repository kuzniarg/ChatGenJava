/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Czat;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Grzechu
 */
public class BazaTest {

    public BazaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testDodajDoBazy() {
        System.out.println("dodajDoBazy");
        Baza.baza = new ArrayList<>();
        Baza.dodajDoBazy("Agnieszka już dawno tutaj nie mieszka.");
        String expResult = "Agnieszka już dawno tutaj";
        String result = Baza.baza.get(0).prefiks + " " + Baza.baza.get(0).sufiks.get(0);
        Baza.baza = null;
        assertEquals(expResult, result);
    }

    @Test
    public void testWyciagnijPrefiks() {
        System.out.println("wyciagnijPrefiks");
        String expResult = "Agnieszka już dawno";
        String result = Baza.wyciagnijPrefiks("Agnieszka już dawno tutaj nie mieszka.");
        assertEquals(expResult, result);
    }

    @Test
    public void testWyciagnijSufiks() {
        System.out.println("wyciagnijSufiks");
        String expResult = "tutaj";
        String result = Baza.wyciagnijSufiks("Agnieszka już dawno tutaj nie mieszka.");
        assertEquals(expResult, result);
    }

    @Test
    public void testZnajdzPrefiks() {
        System.out.println("znajdzPrefiks");
        Baza.baza = new ArrayList<>();
        Baza.baza.add(new BazaElement("prefiks1", "sufiks1"));
        Baza.baza.add(new BazaElement("prefiks2", "sufiks2"));
        Baza.baza.add(new BazaElement("prefiks3", "sufiks3"));
        int expResult = 1;
        int result = Baza.znajdzPrefiks("prefiks2");
        Baza.baza = null;
        assertEquals(expResult, result);
    }
}
