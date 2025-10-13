import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tests {

    @Test
    public void testTietokoneDefaultConstructor() {
        Tietokone tietokone = new Tietokone();
        assertEquals("?", tietokone.getMerkki());
        assertEquals("?", tietokone.getMalli());
        assertEquals("?", tietokone.getTuotenumero());
        assertEquals(0, tietokone.getMaara());
        assertEquals(0, tietokone.getTuotepaikka());
    }

    @Test
    public void testConstructorWithMerkkiAndMalli() {
        Tietokone tietokone = new Tietokone("Dell", "XPS 13");
        assertEquals("Dell", tietokone.getMerkki());
        assertEquals("XPS 13", tietokone.getMalli());
        assertEquals("?", tietokone.getTuotenumero());
        assertEquals(0, tietokone.getMaara());
        assertEquals(0, tietokone.getTuotepaikka());
    }

    @Test
    public void testConstructorWithMerkkiMalliAndTuotenumero() {
        Tietokone tietokone = new Tietokone("HP", "Spectre x360", "HP12345");
        assertEquals("HP", tietokone.getMerkki());
        assertEquals("Spectre x360", tietokone.getMalli());
        assertEquals("HP12345", tietokone.getTuotenumero());
        assertEquals(0, tietokone.getMaara());
        assertEquals(0, tietokone.getTuotepaikka());
    }

    @Test
    public void testTietokoneConstructorWithAllAttributes() {
        Tietokone tietokone = new Tietokone("Apple", "MacBook Pro", "AP45678", 5, 300);
        assertEquals("Apple", tietokone.getMerkki());
        assertEquals("MacBook Pro", tietokone.getMalli());
        assertEquals("AP45678", tietokone.getTuotenumero());
        assertEquals(5, tietokone.getMaara());
        assertEquals(300, tietokone.getTuotepaikka());
    }

    @Test
    public void testSetMerkki() {
        Tietokone tietokone = new Tietokone();
        tietokone.setMerkki("Lenovo");
        assertEquals("Lenovo", tietokone.getMerkki());

        // Test invalid values for merkki
        tietokone.setMerkki("");
        assertEquals("?", tietokone.getMerkki());

        tietokone.setMerkki(null);
        assertEquals("?", tietokone.getMerkki());
    }

    @Test
    public void testSetMalli() {
        Tietokone tietokone = new Tietokone();
        tietokone.setMalli("ThinkPad");
        assertEquals("ThinkPad", tietokone.getMalli());

        // Test invalid values for malli
        tietokone.setMalli("");
        assertEquals("?", tietokone.getMalli());

        tietokone.setMalli(null);
        assertEquals("?", tietokone.getMalli());
    }

    @Test
    public void testTietokoneSetTuotenumero() {
        Tietokone tietokone = new Tietokone();
        tietokone.setTuotenumero("PC78901");
        assertEquals("PC78901", tietokone.getTuotenumero());

        // Test invalid values for tuotenumero
        tietokone.setTuotenumero("");
        assertEquals("?", tietokone.getTuotenumero());

        tietokone.setTuotenumero(null);
        assertEquals("?", tietokone.getTuotenumero());
    }

    @Test
    public void testTietokoneSetMaara() {
        Tietokone tietokone = new Tietokone();
        tietokone.setMaara(10);
        assertEquals(10, tietokone.getMaara());

        // Test negative value for maara
        tietokone.setMaara(-5);
        assertEquals(0, tietokone.getMaara());
    }

    @Test
    public void testTietokoneSetTuotepaikka() {
        Tietokone tietokone = new Tietokone();
        tietokone.setTuotepaikka(200);
        assertEquals(200, tietokone.getTuotepaikka());

        // Test negative value for tuotepaikka
        tietokone.setTuotepaikka(-50);
        assertEquals(0, tietokone.getTuotepaikka());
    }

    @Test
    public void testTietokoneToString() {
        Tietokone tietokone = new Tietokone("Asus", "ZenBook", "AS78910", 7, 250);
        assertEquals("Asus,ZenBook,AS78910,7,250", tietokone.toString());
    }


    @Test
    public void testDefaultConstructor() {
        Tuote tuote = new Tuote();
        assertEquals("?", tuote.getTuotenumero());
        assertEquals(0, tuote.getMaara());
        assertEquals(0, tuote.getTuotepaikka());
    }

    @Test
    public void testConstructorWithTuotenumero() {
        Tuote tuote = new Tuote("ABC123");
        assertEquals("ABC123", tuote.getTuotenumero());
        assertEquals(0, tuote.getMaara());
        assertEquals(0, tuote.getTuotepaikka());
    }

    @Test
    public void testConstructorWithAllAttributes() {
        Tuote tuote = new Tuote("XYZ456", 10, 200);
        assertEquals("XYZ456", tuote.getTuotenumero());
        assertEquals(10, tuote.getMaara());
        assertEquals(200, tuote.getTuotepaikka());
    }

    @Test
    public void testSetTuotenumero() {
        Tuote tuote = new Tuote();
        tuote.setTuotenumero("DEF789");
        assertEquals("DEF789", tuote.getTuotenumero());

        // Test invalid values for tuotenumero
        tuote.setTuotenumero("");
        assertEquals("?", tuote.getTuotenumero());

        tuote.setTuotenumero(null);
        assertEquals("?", tuote.getTuotenumero());
    }

    @Test
    public void testSetMaara() {
        Tuote tuote = new Tuote();
        tuote.setMaara(15);
        assertEquals(15, tuote.getMaara());

        // Test negative value for maara
        tuote.setMaara(-5);
        assertEquals(0, tuote.getMaara());
    }

    @Test
    public void testSetTuotepaikka() {
        Tuote tuote = new Tuote();
        tuote.setTuotepaikka(300);
        assertEquals(300, tuote.getTuotepaikka());

        // Test negative value for tuotepaikka
        tuote.setTuotepaikka(-100);
        assertEquals(0, tuote.getTuotepaikka());
    }

    @Test
    public void testToString() {
        Tuote tuote = new Tuote("LMN101", 20, 150);
        assertEquals("LMN101,20,150", tuote.toString());
    }

    @Test
    public void test1() {
        String path = "src/Tietokone.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Tietokone")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Tietokone.java tiedostosta ei löytynyt 'public class Tietokone' -määritystä.");

        path = "src/Tuote.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Tuote")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Tuote.java tiedostosta ei löytynyt 'public class Tuote' -määritystä.");



    }

}