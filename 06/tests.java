import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.time.Year;

public class tests {

    @Test
    public void test1() {
        // Testataan, että luokka löytyy oikeasta tiedostosta
        String path = "src/Auto.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Auto")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Auto.java tiedostosta ei löytynyt 'public class Auto' -määritystä.");
    }

    @Test
    public void test2() {
        // Testataan, että oletusmuodostin toimii
        Auto auto = new Auto();
        assertNotNull(auto, "Oletusmuodostin ei saanut luotua auto-oliota");
    }

    @Test
    public void test3() {
        // Testataan muodostinta, joka vastaanottaa vain rekisterinumeron
        Auto auto = new Auto("ABC-123");
        assertEquals("ABC-123", auto.getRekisterinumero(), "Rekisterinumero ei ole oikein");
    }

    @Test
    public void test4() {
        // Testataan muodostinta, joka vastaanottaa kaikki attribuutit
        Auto auto = new Auto("DEF-456", "Toyota", "Corolla", 2020);

        assertEquals("DEF-456", auto.getRekisterinumero(), "Rekisterinumero ei ole oikein");
        assertEquals("Toyota", auto.getMerkki(), "Merkki ei ole oikein");
        assertEquals("Corolla", auto.getMalli(), "Malli ei ole oikein");
        assertEquals(2020, auto.getVuosimalli(), "Vuosimalli ei ole oikein");
    }

    @Test
    public void test5() {
        // Testataan setterit ja getterit kaikille attribuuteille
        Auto auto = new Auto();

        auto.setRekisterinumero("XYZ-789");
        auto.setMerkki("Honda");
        auto.setMalli("Civic");
        auto.setVuosimalli(2019);

        assertEquals("XYZ-789", auto.getRekisterinumero(), "Rekisterinumero getter/setter ei toimi oikein");
        assertEquals("Honda", auto.getMerkki(), "Merkki getter/setter ei toimi oikein");
        assertEquals("Civic", auto.getMalli(), "Malli getter/setter ei toimi oikein");
        assertEquals(2019, auto.getVuosimalli(), "Vuosimalli getter/setter ei toimi oikein");
    }

    @Test
    public void test6() {
        Auto auto = new Auto();

        // Asetetaan vuosi alle 1900
        auto.setVuosimalli(1800);
        assertEquals(2000, auto.getVuosimalli(), "Vuosimalli ei ole 2000, vaikka annettu vuosi oli alle 1900");

        // Asetetaan vuosi suurempi kuin nykyinen vuosi
        int currentYear = Year.now().getValue();
        auto.setVuosimalli(currentYear + 1);
        assertEquals(2000, auto.getVuosimalli(), "Vuosimalli ei ole 2000, vaikka annettu vuosi oli yli nykyisen vuoden");

        // Asetetaan vuosi 1900
        auto.setVuosimalli(1900);
        assertEquals(1900, auto.getVuosimalli(), "Vuosimalliksi ei asettunut 1900, vaikka sen pitäisi olla sallittu arvo");

        // Asetetaan nykyinen vuosi
        auto.setVuosimalli(currentYear);
        assertEquals(currentYear, auto.getVuosimalli(), "Vuosimalli ei ole nykyinen vuosi, vaikka sen pitäisi olla sallittu arvo");
    }

    @Test
    public void test7() {
        Auto auto = new Auto();

        // Testataan rekisterinumero ilman väliviivaa
        auto.setRekisterinumero("ABC1234");
        assertEquals("unknown", auto.getRekisterinumero(), "Rekisterinumeron ilman väliviivaa tulisi olla 'unknown'.");

        // Testataan rekisterinumero, jonka pituus on yli 7
        auto.setRekisterinumero("ABC-12345");
        assertEquals("unknown", auto.getRekisterinumero(), "Rekisterinumeron, jonka pituus on yli 7, tulisi olla 'unknown'.");

        // Testataan validi rekisterinumero
        auto.setRekisterinumero("ABC-123");
        assertEquals("ABC-123", auto.getRekisterinumero(), "Validi rekisterinumero ei asetettu oikein.");
    }

    @Test
    public void test8() {
        // Simuloidaan käyttäjän syötteitä, jotka vastaa Auto-luokan kysyTiedot-metodin odottamaa järjestystä
        String input = "ABC-123\nToyota\nCorolla\n2015\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Auto auto = new Auto();

        // Kutsutaan kysyTiedot-metodia, joka lukee syötteet System.in:stä
        auto.kysyTiedot();

        // Tarkistetaan, että tiedot on tallentuneet oikein
        assertEquals("ABC-123", auto.getRekisterinumero(), "Rekisterinumero ei täsmää.");
        assertEquals("Toyota", auto.getMerkki(), "Merkki ei täsmää.");
        assertEquals("Corolla", auto.getMalli(), "Malli ei täsmää.");
        assertEquals(2015, auto.getVuosimalli(), "Vuosimalli ei täsmää.");
    }

    @Test
    public void test9() {
        // Luodaan Auto-olio ja asetetaan attribuuteille arvot
        Auto auto = new Auto("ABC-123", "Toyota", "Corolla", 2015);

        // Odotettu tuloste toString-metodilta
        String expectedOutput = "ABC-123,Toyota,Corolla,2015";

        // Testataan, että toString-metodi tuottaa oikeanlaisen tulosteen
        assertEquals(expectedOutput, auto.toString(), "toString-metodin tuloste ei täsmännyt odotetun kanssa.");
    }

    @Test
    public void test10() {
        // Simuloidaan käyttäjän syötteet
        String simulatedInput = "wedfqwef\naudi\nq7\n2024\nmnbc*123\ntoyota\ncorolla\n2090\n";
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
        String expectedOutput = "null,null,null,0" + System.lineSeparator() +
                "abc-123,null,null,0" + System.lineSeparator() +
                "xyz-987,volvo,v70,1990" + System.lineSeparator() +
                "Anna rekisterinumero: " +
                "Anna merkki: " +
                "Anna malli: " +
                "Anna vuosimalli: " +
                "unknown,audi,q7,2024" + System.lineSeparator() +
                "unknown,toyota,corolla,2000" + System.lineSeparator();

        // Testataan, että tulostus vastaa odotettua
        assertEquals(expectedOutput, outContent.toString(), "Tulostus ei täsmännyt odotetun kanssa.");
    }
}