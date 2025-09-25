import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.Scanner;

public class tests {

    @Test
    public void test1() {
        String path = "src/Kurssisuoritus.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Kurssisuoritus")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Kurssisuoritus.java tiedostosta ei löytynyt 'public class Kurssisuoritus' -määritystä.");
    }

    @Test
    public void test2() {
        Kurssisuoritus kurssisuoritus = new Kurssisuoritus();  // Oletusmuodostin
        assertNotNull(kurssisuoritus, "Oletusmuodostin ei saanut luotua Kurssisuoritus-oliota.");
    }

    // Test3: Tarkista, että on muodostin, joka ottaa vastaan kaikki attribuutit
    @Test
    public void test3() {
        Kurssisuoritus kurssisuoritus = new Kurssisuoritus("Matti", 15.0, 40.0);  // Muodostin kaikilla attribuuteilla
        assertEquals("Matti", kurssisuoritus.getOpiskelijanimi(), "Opiskelijanimi ei ole oikein.");
        assertEquals(15.0, kurssisuoritus.getKoepisteet(), "Koepisteet eivät ole oikein.");
        assertEquals(40.0, kurssisuoritus.getTehtavapisteet(), "Tehtavapisteet eivät ole oikein.");
    }

    // Test4: Tarkista kaikkien attribuuttien getterit ja setterit
    @Test
    public void test4() {
        Kurssisuoritus kurssisuoritus = new Kurssisuoritus();

        // Testataan setterit
        kurssisuoritus.setOpiskelijanimi("Liisa");
        kurssisuoritus.setKoepisteet(15.0);
        kurssisuoritus.setTehtavapisteet(35.0);

        // Testataan getterit
        assertEquals("Liisa", kurssisuoritus.getOpiskelijanimi(), "Opiskelijanimi-getteri ei toimi oikein.");
        assertEquals(15.0, kurssisuoritus.getKoepisteet(), "Koepisteet-getteri ei toimi oikein.");
        assertEquals(35.0, kurssisuoritus.getTehtavapisteet(), "Tehtavapisteet-getteri ei toimi oikein.");
    }

    // Test5: Koepisteiden set-metodissa tarkistetaan, että pisteet ovat välillä 0-20
    @Test
    public void test5() {
        Kurssisuoritus kurssisuoritus = new Kurssisuoritus();

        kurssisuoritus.setKoepisteet(-1);
        assertEquals(0, kurssisuoritus.getKoepisteet(), "Koepisteiden pitäisi olla 0, jos pisteet ovat alle 0.");

        kurssisuoritus.setKoepisteet(21);
        assertEquals(0, kurssisuoritus.getKoepisteet(), "Koepisteiden pitäisi olla 0, jos pisteet ovat yli 20.");

        kurssisuoritus.setKoepisteet(10);
        assertEquals(10, kurssisuoritus.getKoepisteet(), "Koepisteiden pitäisi olla oikein, kun pisteet ovat välillä 0-20.");
    }

    // Test6: Opiskelijanimen set-metodissa tarkistetaan, että nimi ei ole null tai tyhjä
    @Test
    public void test6() {
        Kurssisuoritus kurssisuoritus = new Kurssisuoritus();

        kurssisuoritus.setOpiskelijanimi(null);
        assertEquals("Olli Opiskelija", kurssisuoritus.getOpiskelijanimi(), "Opiskelijanimen pitäisi olla 'Olli Opiskelija', jos nimi on null.");

        kurssisuoritus.setOpiskelijanimi("");
        assertEquals("Olli Opiskelija", kurssisuoritus.getOpiskelijanimi(), "Opiskelijanimen pitäisi olla 'Olli Opiskelija', jos nimi on tyhjä.");

        kurssisuoritus.setOpiskelijanimi("Matti Meikäläinen");
        assertEquals("Matti Meikäläinen", kurssisuoritus.getOpiskelijanimi(), "Opiskelijanimen pitäisi olla sama kuin annettu arvo.");
    }

    // Test7: Tehtäväpisteiden setterissä tarkistetaan, että pisteet ovat välillä 0-50
    @Test
    public void test7() {
        Kurssisuoritus kurssisuoritus = new Kurssisuoritus();

        kurssisuoritus.setTehtavapisteet(-1);
        assertEquals(0, kurssisuoritus.getTehtavapisteet(), "Tehtäväpisteiden pitäisi olla 0, jos pisteet ovat alle 0.");

        kurssisuoritus.setTehtavapisteet(51);
        assertEquals(0, kurssisuoritus.getTehtavapisteet(), "Tehtäväpisteiden pitäisi olla 0, jos pisteet ovat yli 50.");

        kurssisuoritus.setTehtavapisteet(30);
        assertEquals(30, kurssisuoritus.getTehtavapisteet(), "Tehtäväpisteiden pitäisi olla oikein, kun pisteet ovat välillä 0-50.");
    }

    @Test
    public void test8() {
        Kurssisuoritus kurssisuoritus = new Kurssisuoritus();

        // Simuloidaan käyttäjän syötteet virheellisillä arvoilla
        String simulatedInput = "\n-1\n-1\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        Scanner sc = new Scanner(System.in);

        // Kutsutaan kysyTiedot-metodia
        kurssisuoritus.kysyTiedot(sc);

        // Tarkistetaan tulokset: nimi = "Olli Opiskelija", koepisteet = 0, tehtäväpisteet = 0
        assertEquals("Olli Opiskelija", kurssisuoritus.getOpiskelijanimi(), "Nimen pitäisi olla 'Olli Opiskelija', jos nimi on null.");
        assertEquals(0, kurssisuoritus.getKoepisteet(), "Koepisteiden pitäisi olla 0, jos annettu arvo on alle 0.");
        assertEquals(0, kurssisuoritus.getTehtavapisteet(), "Tehtäväpisteiden pitäisi olla 0, jos annettu arvo on alle 0.");
    }

    @Test
    public void test9() {
        Kurssisuoritus kurssisuoritus = new Kurssisuoritus();

        // Simuloidaan käyttäjän syötteet hyväksyttävillä arvoilla
        String simulatedInput = "Matti Meikäläinen\n15\n30\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        Scanner sc = new Scanner(System.in);
        // Kutsutaan kysyTiedot-metodia
        kurssisuoritus.kysyTiedot(sc);

        // Tarkistetaan tulokset: nimi = "Matti Meikäläinen", koepisteet = 15, tehtäväpisteet = 30
        assertEquals("Matti Meikäläinen", kurssisuoritus.getOpiskelijanimi(), "Nimen pitäisi olla 'Matti Meikäläinen'.");
        assertEquals(15, kurssisuoritus.getKoepisteet(), "Koepisteiden pitäisi olla 15.");
        assertEquals(30, kurssisuoritus.getTehtavapisteet(), "Tehtäväpisteiden pitäisi olla 30.");
    }

    @Test
    public void test10() {
        Kurssisuoritus kurssisuoritus = new Kurssisuoritus();

        // Testataan arvosanat 0-5 ilman bonusta
        kurssisuoritus.setKoepisteet(9);
        kurssisuoritus.setTehtavapisteet(0);
        assertEquals(0, kurssisuoritus.arvosana(), "Koepisteillä 9 pitäisi saada arvosana 0.");

        kurssisuoritus.setKoepisteet(10);
        assertEquals(1, kurssisuoritus.arvosana(), "Koepisteillä 10 pitäisi saada arvosana 1.");
        kurssisuoritus.setKoepisteet(11);
        assertEquals(1, kurssisuoritus.arvosana(), "Koepisteillä 10 pitäisi saada arvosana 1.");

        kurssisuoritus.setKoepisteet(12);
        assertEquals(2, kurssisuoritus.arvosana(), "Koepisteillä 12 pitäisi saada arvosana 2.");
        kurssisuoritus.setKoepisteet(13);
        assertEquals(2, kurssisuoritus.arvosana(), "Koepisteillä 12 pitäisi saada arvosana 2.");


        kurssisuoritus.setKoepisteet(14);
        assertEquals(3, kurssisuoritus.arvosana(), "Koepisteillä 14 pitäisi saada arvosana 3.");
        kurssisuoritus.setKoepisteet(15);
        assertEquals(3, kurssisuoritus.arvosana(), "Koepisteillä 14 pitäisi saada arvosana 3.");

        kurssisuoritus.setKoepisteet(16);
        assertEquals(4, kurssisuoritus.arvosana(), "Koepisteillä 16 pitäisi saada arvosana 4.");
        kurssisuoritus.setKoepisteet(17);
        assertEquals(4, kurssisuoritus.arvosana(), "Koepisteillä 16 pitäisi saada arvosana 4.");

        kurssisuoritus.setKoepisteet(18);
        assertEquals(5, kurssisuoritus.arvosana(), "Koepisteillä 18 pitäisi saada arvosana 5.");
        kurssisuoritus.setKoepisteet(20);
        assertEquals(5, kurssisuoritus.arvosana(), "Koepisteillä 18 pitäisi saada arvosana 5.");

        // Testataan bonuksen vaikutus arvosanaan
        kurssisuoritus.setTehtavapisteet(30);  // Bonus täyttyy
        kurssisuoritus.setKoepisteet(15);
        assertEquals(4, kurssisuoritus.arvosana(), "Koepisteillä 15 ja tehtäväpisteillä 25 pitäisi saada arvosana 4 bonuspisteen ansiosta.");

        kurssisuoritus.setKoepisteet(18);
        assertEquals(5, kurssisuoritus.arvosana(), "Koepisteillä 18 ja tehtäväpisteillä 30 arvosana ei voi ylittää 5, joten tuloksen pitäisi olla 5.");
    }

    @Test
    public void test11() {
        // Luodaan uusi Kurssisuoritus-olio ja asetetaan arvot
        Kurssisuoritus kurssisuoritus = new Kurssisuoritus();
        kurssisuoritus.setOpiskelijanimi("Mikko Mallikas");
        kurssisuoritus.setKoepisteet(12);
        kurssisuoritus.setTehtavapisteet(33);

        // Odotettu tuloste, jossa mukana arvosana
        String expected = "Mikko Mallikas,12.0,33.0,3";

        // Verrataan, että toString-metodi palauttaa oikean tuloksen
        assertEquals(expected, kurssisuoritus.toString(), "ToString-metodin tulos ei ollut odotetun mukainen.");
    }

    @Test
    public void test12() {
        // Simuloidaan käyttäjän syötteet
        String lineSeparator = System.lineSeparator();
        String simulatedInput = "k\nMikko Mallikas\n12\n33\nk\nTiina Tomera\n99\n12\nk\nJussi Juonio\n18\n34\ne\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        // Tallennetaan alkuperäinen System.out, jotta voidaan palauttaa se myöhemmin
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Suoritetaan main-metodi
        my_code.main(new String[0]);

        // Palautetaan alkuperäinen System.out
        System.setOut(originalOut);

        // Odotettu tuloste

//        String expectedOutput = "Lisätäänkö uusi? " + lineSeparator +
//                "Anna opiskelijanimi: " + lineSeparator +
//                "Anna koepisteet: " + lineSeparator +
//                "Anna tehtavapisteet: " + lineSeparator +
//                "Lisätäänkö uusi? " + lineSeparator +
//                "Anna opiskelijanimi: " + lineSeparator +
//                "Anna koepisteet: " + lineSeparator +
//                "Anna tehtavapisteet: " + lineSeparator +
//                "Lisätäänkö uusi? " + lineSeparator +
//                "Anna opiskelijanimi: " + lineSeparator +
//                "Anna koepisteet: " + lineSeparator +
//                "Anna tehtavapisteet: " + lineSeparator +
//                "Lisätäänkö uusi? " + lineSeparator +
//                "Mikko Mallikas,12.0,33.0,3" + lineSeparator +
//                "Tiina Tomera,0.0,12.0,0" + lineSeparator +
//                "Jussi Juonio,18.0,34.0,5" + lineSeparator +
//                "Arvosanojen keskiarvo on 2,67";
        String aputeksti = String.format("Arvosanojen keskiarvo on %.2f",2.67);
        String expectedOutput = "Lisätäänkö uusi? " +
                "Anna opiskelijanimi: " +
                "Anna koepisteet: " +
                "Anna tehtavapisteet: " +
                "Lisätäänkö uusi? " +
                "Anna opiskelijanimi: " +
                "Anna koepisteet: " +
                "Anna tehtavapisteet: " +
                "Lisätäänkö uusi? " +
                "Anna opiskelijanimi: " +
                "Anna koepisteet: " +
                "Anna tehtavapisteet: " +
                "Lisätäänkö uusi? " +
                "Mikko Mallikas,12.0,33.0,3" + lineSeparator +
                "Tiina Tomera,0.0,12.0,0" + lineSeparator +
                "Jussi Juonio,18.0,34.0,5" + lineSeparator +
                aputeksti;
        // Verrataan tulostusta odotettuun
        assertEquals(expectedOutput, outContent.toString(), "Tulostus ei vastannut odotettua.");
    }
}