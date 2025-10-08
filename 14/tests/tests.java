import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tests {

    private List<Henkilo> henkilot;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        // Ohjaa tulostus ByteArrayOutputStreamiin, jotta voimme tarkistaa tulostuksen
        System.setOut(new PrintStream(outContent));

        // Alusta testihenkilöt
        henkilot = new ArrayList<>();

        Opiskelija opiskelija1 = new Opiskelija("Matti Meikäläinen", "Koulutie 1", LocalDate.of(2000, 1, 15), 12345, LocalDate.of(2019, 8, 15));
        Opiskelija opiskelija2 = new Opiskelija("Maija Mallikas", "Opistokuja 2", LocalDate.of(2001, 6, 10), 54321, LocalDate.of(2020, 8, 20));

        Henkilokunta henkilokunta1 = new Henkilokunta("Pekka Pomo", "Yliopistonkatu 3", LocalDate.of(1980, 2, 28), "H123", "Päätoimisto", "Professori");
        Henkilokunta henkilokunta2 = new Henkilokunta("Liisa Laitinen", "Työpajankatu 5", LocalDate.of(1975, 5, 20), "H456", "Laitosrakennus", "Labra-assistentti");

        henkilot.add(opiskelija1);
        henkilot.add(opiskelija2);
        henkilot.add(henkilokunta1);
        henkilot.add(henkilokunta2);
    }
    @BeforeEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testTulostusOpiskelijatJaHenkilokunta() {
        // Tulostetaan testattava lista
        System.out.println("Opiskelijat:");
        for (Henkilo h : henkilot) {
            if (h instanceof Opiskelija) {
                ((Opiskelija) h).tulostaOpiskelija();
            }
        }
        System.out.println();
        System.out.println("Henkilökunnan jäsenet:");
        for (Henkilo h : henkilot) {
            if (h instanceof Henkilokunta) {
                ((Henkilokunta) h).tulostaHenkilokunta();
            }
        }

        // Odotettu tulostus
        String expectedOutput = "Opiskelijat:" + System.lineSeparator() +
                "Matti Meikäläinen, Koulutie 1, 2000-01-15, 12345, 2019-08-15" + System.lineSeparator() +
                "Maija Mallikas, Opistokuja 2, 2001-06-10, 54321, 2020-08-20" + System.lineSeparator() + System.lineSeparator() +
                "Henkilökunnan jäsenet:" + System.lineSeparator() +
                "Pekka Pomo, Yliopistonkatu 3, 1980-02-28, H123, Päätoimisto, Professori" + System.lineSeparator() +
                "Liisa Laitinen, Työpajankatu 5, 1975-05-20, H456, Laitosrakennus, Labra-assistentti" +  System.lineSeparator();

        // Vertaa tulostusta odotettuun tulostukseen

        assertEquals(expectedOutput.trim(), outContent.toString().trim());
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