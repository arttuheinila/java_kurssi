
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

public class realtests {

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
    }

    @Test
    public void test2() {
        // Testataan, että oletusmuodostin toimii
        Opiskelija opiskelija = new Opiskelija();
        assertNotNull(opiskelija, "Oletusmuodostin ei saanut luotua opiskelija-oliota");
    }

    @Test
    public void test3() {
        // Testataan muodostinta, joka vastaanottaa kaikki attribuutit
        Opiskelija opiskelija = new Opiskelija("Matti", "Meikäläinen", 12345, "Esimerkkikatu 1");

        assertEquals("Matti", opiskelija.getEtunimi(), "Etunimi ei ole oikein");
        assertEquals("Meikäläinen", opiskelija.getSukunimi(), "Sukunimi ei ole oikein");
        assertEquals(12345, opiskelija.getOpiskelijanumero(), "Opiskelijanumero ei ole oikein");
        assertEquals("Esimerkkikatu 1", opiskelija.getOsoite(), "Osoite ei ole oikein");
    }

    @Test
    public void test4() {
        // Testataan kaikkien attribuuttien setterit ja getterit
        Opiskelija opiskelija = new Opiskelija();
        opiskelija.setEtunimi("Anna");
        opiskelija.setSukunimi("Esimerkki");
        opiskelija.setOpiskelijanumero(54321);
        opiskelija.setOsoite("Katutie 2");

        assertEquals("Anna", opiskelija.getEtunimi(), "Etunimen asettaminen epäonnistui");
        assertEquals("Esimerkki", opiskelija.getSukunimi(), "Sukunimen asettaminen epäonnistui");
        assertEquals(54321, opiskelija.getOpiskelijanumero(), "Opiskelijanumeron asettaminen epäonnistui");
        assertEquals("Katutie 2", opiskelija.getOsoite(), "Osoitteen asettaminen epäonnistui");
    }

    @Test
    public void test5() {
        // Testataan toString-metodin toimivuus
        Opiskelija opiskelija = new Opiskelija("Pekka", "Mallikas", 67890, "Testikuja 3");
        String expectedOutput = "Pekka,Mallikas,67890,Testikuja 3";
        assertEquals(expectedOutput, opiskelija.toString(), "toString-metodi ei toiminut oikein");
    }

    @Test
    public void test6() {
        // Ohjataan System.out tulostus ByteArrayOutputStreamiin, jotta voimme tarkastaa sen sisällön
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; // Tallenna alkuperäinen System.out
        System.setOut(new PrintStream(outContent)); // Aseta uusi tulostevirta

        // Suoritetaan my_code.java:n main metodi
        my_code.main(new String[]{});

        // Palautetaan alkuperäinen System.out
        System.setOut(originalOut);

        // Odotettu tuloste
        String lineSeparator = System.lineSeparator();
        String expectedOutput = "null,null,0,null" + lineSeparator +
                "Jussi,Juonio,123,Keskuskuja 15" + lineSeparator +
                "Jussi" + lineSeparator +
                "Juonio" + lineSeparator +
                "123" + lineSeparator +
                "Keskuskuja 15" + lineSeparator +
                "Matti,Mainio,123,Kauppakatu 12" + lineSeparator;

        // Verrataan tulostetta odotettuun
        assertEquals(expectedOutput, outContent.toString(), "Tulostus ei täsmännyt odotetun kanssa.\nOdotettu:\n" + expectedOutput + "\nTodellinen:\n" + outContent.toString());
    }
}