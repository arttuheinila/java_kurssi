import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class tests {


    private Opiskelija opiskelija;
    private Osoite osoite;

    @BeforeEach
    void setUp() {
        osoite = new Osoite("Testikatu 1", "12345", "Helsinki");
        opiskelija = new Opiskelija("Matti", "Meikäläinen", "123456", osoite);
    }

    @Test
    void testOsoiteConstructorAndGetters() {
        assertEquals("Testikatu 1", osoite.getLahiosoite());
        assertEquals("12345", osoite.getPostinumero());
        assertEquals("Helsinki", osoite.getPostitoimipaikka());
    }

    @Test
    void testSetLahiosoite() {
        osoite.setLahiosoite("Uusikatu 2");
        assertEquals("Uusikatu 2", osoite.getLahiosoite());
    }

    @Test
    void testSetPostinumeroValid() {
        osoite.setPostinumero("54321");
        assertEquals("54321", osoite.getPostinumero());
    }

    @Test
    void testSetPostinumeroInvalidLength() {
        osoite.setPostinumero("1234"); // Väärä pituus
        assertEquals("00000", osoite.getPostinumero());
    }

    @Test
    void testSetPostinumeroNonNumeric() {
        osoite.setPostinumero("12A45"); // Sisältää kirjaimen
        assertEquals("00000", osoite.getPostinumero());
    }

    @Test
    void testSetPostitoimipaikka() {
        osoite.setPostitoimipaikka("Espoo");
        assertEquals("Espoo", osoite.getPostitoimipaikka());
    }

    @Test
    void testOsoiteToString() {
        assertEquals("Testikatu 1,12345,Helsinki", osoite.toString());
    }
    @Test
    void testOpiskelijaConstructorAndGetters() {
        assertEquals("Matti", opiskelija.getEtunimi());
        assertEquals("Meikäläinen", opiskelija.getSukunimi());
        assertEquals("123456", opiskelija.getOpiskelijanumero());
        assertEquals(osoite, opiskelija.getOsoite());
    }

    @Test
    void testSetEtunimi() {
        opiskelija.setEtunimi("Kalle");
        assertEquals("Kalle", opiskelija.getEtunimi());
    }

    @Test
    void testSetSukunimi() {
        opiskelija.setSukunimi("Virtanen");
        assertEquals("Virtanen", opiskelija.getSukunimi());
    }

    @Test
    void testSetOpiskelijanumero() {
        opiskelija.setOpiskelijanumero("654321");
        assertEquals("654321", opiskelija.getOpiskelijanumero());
    }

    @Test
    void testSetOsoite() {
        Osoite uusiOsoite = new Osoite("Uusikatu 2", "54321", "Espoo");
        opiskelija.setOsoite(uusiOsoite);
        assertEquals(uusiOsoite, opiskelija.getOsoite());
    }

    @Test
    void testOpiskelijaToString() {
        String expected = "Matti Meikäläinen,123456,Testikatu 1,12345,Helsinki";
        assertEquals(expected, opiskelija.toString());
    }

    @Test
    public void testTarkastaTiedot_ValidData() {
        // Luodaan validi Opiskelija-olio
        Osoite osoite = new Osoite("Esimerkkikatu 1", "00100", "Helsinki");
        Opiskelija opiskelija = new Opiskelija("matti", "meikäläinen", "12345", osoite);

        // Tarkastetaan, että metodi palauttaa opiskelijan ilman virheitä
        Opiskelija tarkastettu = OpiskelijaUtils.tarkastaTiedot(opiskelija);
        assertNotNull(tarkastettu);
        assertEquals("Matti", tarkastettu.getEtunimi());
        assertEquals("Meikäläinen", tarkastettu.getSukunimi());
        assertEquals("12345", tarkastettu.getOpiskelijanumero());
        assertNotNull(tarkastettu.getOsoite());
    }

    @Test
    public void testTarkastaTiedot_EmptyFirstName() {
        // Luodaan Opiskelija-olio, jossa etunimi puuttuu
        Osoite osoite = new Osoite("Esimerkkikatu 1", "00100", "Helsinki");
        Opiskelija opiskelija = new Opiskelija("", "meikäläinen", "12345", osoite);

        // Tarkastetaan, että metodi palauttaa null
        Opiskelija tarkastettu = OpiskelijaUtils.tarkastaTiedot(opiskelija);
        assertNull(tarkastettu);
    }

    @Test
    public void testTarkastaTiedot_EmptyLastName() {
        // Luodaan Opiskelija-olio, jossa sukunimi puuttuu
        Osoite osoite = new Osoite("Esimerkkikatu 1", "00100", "Helsinki");
        Opiskelija opiskelija = new Opiskelija("Matti", "", "12345", osoite);

        // Tarkastetaan, että metodi palauttaa null
        Opiskelija tarkastettu = OpiskelijaUtils.tarkastaTiedot(opiskelija);
        assertNull(tarkastettu);
    }

    @Test
    public void testTarkastaTiedot_EmptyOpiskelijanumero() {
        // Luodaan Opiskelija-olio, jossa opiskelijanumero puuttuu
        Osoite osoite = new Osoite("Esimerkkikatu 1", "00100", "Helsinki");
        Opiskelija opiskelija = new Opiskelija("Matti", "Meikäläinen", "", osoite);

        // Tarkastetaan, että metodi palauttaa null
        Opiskelija tarkastettu = OpiskelijaUtils.tarkastaTiedot(opiskelija);
        assertNull(tarkastettu);
    }

    @Test
    public void testTarkastaTiedot_InvalidOpiskelijanumero() {
        // Luodaan Opiskelija-olio, jossa opiskelijanumero ei ole vain numeroita
        Osoite osoite = new Osoite("Esimerkkikatu 1", "00100", "Helsinki");
        Opiskelija opiskelija = new Opiskelija("Matti", "Meikäläinen", "abc12", osoite);

        // Tarkastetaan, että metodi palauttaa null
        Opiskelija tarkastettu = OpiskelijaUtils.tarkastaTiedot(opiskelija);
        assertNull(tarkastettu);
    }

    @Test
    public void testTarkastaTiedot_CorrectsCapitalization() {
        // Luodaan Opiskelija-olio, jossa etunimi ja sukunimi on väärin kirjoitettu
        Osoite osoite = new Osoite("Esimerkkikatu 1", "00100", "Helsinki");
        Opiskelija opiskelija = new Opiskelija("mATTI", "mEIKÄLÄINEN", "12345", osoite);

        // Tarkastetaan, että metodi muuttaa etunimen ja sukunimen oikeaan muotoon
        Opiskelija tarkastettu = OpiskelijaUtils.tarkastaTiedot(opiskelija);
        assertNotNull(tarkastettu);
        assertEquals("Matti", tarkastettu.getEtunimi());
        assertEquals("Meikäläinen", tarkastettu.getSukunimi());
    }

    @Test
    public void testTarkastaTiedot_AllFieldsNull() {
        // Luodaan Opiskelija-olio, jossa kaikki kentät puuttuvat
        Opiskelija opiskelija = new Opiskelija(null, null, null, null);

        // Tarkastetaan, että metodi palauttaa null
        Opiskelija tarkastettu = OpiskelijaUtils.tarkastaTiedot(opiskelija);
        assertNull(tarkastettu);
    }

    @Test
    public void test1() {
        String path = "src/Osoite.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        boolean found = false;

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

        path = "src/Opiskelija.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

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

        path = "src/OpiskelijaUtils.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class OpiskelijaUtils")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "OpiskelijaUtils.java tiedostosta ei löytynyt 'public class OpiskelijaUtils' -määritystä.");

    }

}