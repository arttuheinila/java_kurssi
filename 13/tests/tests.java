import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class tests {



    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testTulostaOpiskelija() {
        Opiskelija opiskelija = new Opiskelija("Matti Meikäläinen", "Koulutie 1", LocalDate.of(1999, 3, 15), 12345, LocalDate.of(2020, 8, 1));
        assertEquals("Matti Meikäläinen, Koulutie 1, 1999-03-15, 12345, 2020-08-01", opiskelija.toString());
    }

    @Test
    public void testTulostaHenkilokunta() {
        Henkilokunta henkilo = new Henkilokunta("Pekka Esimerkki", "Työskatu 10", LocalDate.of(1975, 2, 5), "TY123", "Pääkonttori", "Johtaja");
        assertEquals("Pekka Esimerkki, Työskatu 10, 1975-02-05, TY123, Pääkonttori, Johtaja", henkilo.toString());
    }

    @Test
    public void testGetHenkilonTiedot() {
        Henkilo henkilo = new Henkilo("Matti Meikäläinen", "Koulutie 1", LocalDate.of(1999, 3, 15));
        assertEquals("Matti Meikäläinen, Koulutie 1, 1999-03-15", henkilo.getHenkilonTiedot());
    }

    @Test
    public void test1() {
        String path = "src/Opiskelija.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Opiskelija")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Opiskelija.java tiedostosta ei löytynyt 'public class Opiskelija' -määritystä.");

        path = "src/Henkilokunta.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Henkilokunta")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Henkilokunta.java tiedostosta ei löytynyt 'public class Henkilokunta' -määritystä.");

        path = "src/Henkilo.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Henkilo")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Henkilo.java tiedostosta ei löytynyt 'public class Henkilo' -määritystä.");


    }

}