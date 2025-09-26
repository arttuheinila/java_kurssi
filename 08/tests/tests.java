import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

public class tests {
    private Opiskelijat opiskelijat;
    private Opiskelija opiskelija1;
    private Opiskelija opiskelija2;
    private Opiskelija opiskelija3;

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

        path = "src/Opiskelijat.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Opiskelijat")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Opiskelijat.java tiedostosta ei löytynyt 'public class Opiskelijat' -määritystä.");

        path = "src/Osoite.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Osoite")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Osoite.java tiedostosta ei löytynyt 'public class Osoite' -määritystä.");
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
        Opiskelija opiskelija = new Opiskelija("Matti", "Meikäläinen", 12345, new Osoite("Kauppakatu 12", "79100", "Kuopio"));

        assertEquals("Matti", opiskelija.getEtunimi(), "Etunimi ei ole oikein");
        assertEquals("Meikäläinen", opiskelija.getSukunimi(), "Sukunimi ei ole oikein");
        assertEquals(12345, opiskelija.getOpiskelijanumero(), "Opiskelijanumero ei ole oikein");
        assertEquals("Kauppakatu 12", opiskelija.getOsoite().getKatuosoite(), "Katusoite ei ole oikein");
        assertEquals("79100", opiskelija.getOsoite().getPostinumero(), "Postinumero ei ole oikein");
        assertEquals("Kuopio", opiskelija.getOsoite().getKaupunki(), "Kaupunki ei ole oikein");
    }

    @Test
    public void test4() {
        // Testataan kaikkien attribuuttien setterit ja getterit
        Opiskelija opiskelija = new Opiskelija();
        opiskelija.setEtunimi("Anna");
        opiskelija.setSukunimi("Esimerkki");
        opiskelija.setOpiskelijanumero(54321);
        opiskelija.setOsoite(new Osoite("Keskuskuja 16", "78100", "Pöljä"));

        assertEquals("Anna", opiskelija.getEtunimi(), "Etunimen asettaminen epäonnistui");
        assertEquals("Esimerkki", opiskelija.getSukunimi(), "Sukunimen asettaminen epäonnistui");
        assertEquals(54321, opiskelija.getOpiskelijanumero(), "Opiskelijanumeron asettaminen epäonnistui");
        assertEquals("Keskuskuja 16", opiskelija.getOsoite().getKatuosoite(), "Katusoite ei ole oikein");
        assertEquals("78100", opiskelija.getOsoite().getPostinumero(), "Postinumero ei ole oikein");
        assertEquals("Pöljä", opiskelija.getOsoite().getKaupunki(), "Kaupunki ei ole oikein");
    }

    @Test
    public void test5() {
        // Testataan toString-metodin toimivuus
        Opiskelija opiskelija = new Opiskelija("Pekka", "Mallikas", 67890, new Osoite("Torikatu 15", "9100", "Rovaniemi"));
        String expectedOutput = "Pekka,Mallikas,67890,Torikatu 15,9100,Rovaniemi";
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
        String expectedOutput = "Maija,Mallikas,534,Kauppakatu 13,78100,Kuopio"+ lineSeparator +
        "Opiskelijat, jotka asuvat kaupungissa Rautavaara:"+ lineSeparator +
        "Kaija,Kaunokas,111,Salotie,7623000,Rautavaara"+ lineSeparator +
        "Opiskelijat, jotka asuvat kaupungissa Siilinjärvi:"+ lineSeparator +
        "Mikko,Mallikas,345,Kauppakatu 13,78100,Siilinjärvi"+ lineSeparator +
        "Maija,Mallikas,534,Kauppakatu 13,78100,Siilinjärvi"+ lineSeparator;

        // Verrataan tulostetta odotettuun
        assertEquals(expectedOutput, outContent.toString(), "Tulostus ei täsmännyt odotetun kanssa." + System.lineSeparator() +
                "Odotettu:" + System.lineSeparator() + expectedOutput + System.lineSeparator() +
                "Todellinen:" + System.lineSeparator() + outContent.toString());
    }

    @BeforeEach
    public void setUp() {
        opiskelijat = new Opiskelijat();
        opiskelija1 = new Opiskelija("Matti", "Makkonen", 123, new Osoite("Savonkatu 14", "78100", "Kuopio"));
        opiskelija2 = new Opiskelija("Maija", "Kakkonen", 789, new Osoite("Torikatu 2", "75100", "Lapinlahti"));
        opiskelija3 = new Opiskelija("Keijo", "Kolmonen", 889, new Osoite("Wredenkatu 14", "00100", "Iisalmi"));
    }

    @Test
    public void testLisaaOpiskelija() {
        opiskelijat.lisaaOpiskelija(opiskelija1);
        opiskelijat.lisaaOpiskelija(opiskelija2);
        assertTrue(opiskelijat.getOpiskelijat().contains(opiskelija1));
        assertTrue(opiskelijat.getOpiskelijat().contains(opiskelija2));
    }

    @Test
    public void testPoistaOpiskelija() {
        opiskelijat.lisaaOpiskelija(opiskelija1);
        opiskelijat.lisaaOpiskelija(opiskelija2);
        opiskelijat.poistaOpiskelija(opiskelija1);
        assertFalse(opiskelijat.getOpiskelijat().contains(opiskelija1));
        assertTrue(opiskelijat.getOpiskelijat().contains(opiskelija2));
    }

    @Test
    public void testTulostaAsukkaat() {
        opiskelijat.lisaaOpiskelija(opiskelija1);
        opiskelijat.lisaaOpiskelija(opiskelija2);
        opiskelijat.lisaaOpiskelija(opiskelija3);

        // Ohjataan tulostus ByteArrayOutputStreamiin, jotta tulostuksen sisältö voidaan tarkistaa
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        opiskelijat.tulostaAsukkaat("Lapinlahti");

        String expectedOutput = "Opiskelijat, jotka asuvat kaupungissa Lapinlahti:" + System.lineSeparator()
                + "Maija,Kakkonen,789,Torikatu 2,75100,Lapinlahti" + System.lineSeparator();

        assertEquals(expectedOutput.trim(), outContent.toString().trim());

        // Palautetaan System.out normaaliksi
        System.setOut(System.out);
    }
}