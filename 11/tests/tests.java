import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class tests {



    private Kayttaja kayttaja;
    private Osoite osoite;
    private Tietokone tietokone;
    private LeasingTieto leasingTieto;

    @BeforeEach
    public void setUp() {
        tietokone = new Tietokone();
        kayttaja = new Kayttaja();
        osoite = new Osoite();
        leasingTieto = new LeasingTieto();
    }


    @Test
    public void testKayttajaOletusmuodostin() {
        assertNull(kayttaja.getNimi());
        assertNull(kayttaja.getOsoite());
    }

    @Test
    public void testKayttajaMuodostinArvoilla() {
        Kayttaja kayttaja = new Kayttaja("Matti Meikäläinen", osoite);
        assertEquals("Matti Meikäläinen", kayttaja.getNimi());
        assertEquals(osoite, kayttaja.getOsoite());
    }

    @Test
    public void testSetNimi() {
        kayttaja.setNimi("Matti Meikäläinen");
        assertEquals("Matti Meikäläinen", kayttaja.getNimi());
    }

    @Test
    public void testSetOsoite() {
        kayttaja.setOsoite(osoite);
        assertEquals(osoite, kayttaja.getOsoite());
    }

    @Test
    public void testKayttajaToString() {
        Osoite osoite = new Osoite("Testikatu 1", "12345", "Helsinki");
        kayttaja = new Kayttaja("Matti Meikäläinen", osoite);
        assertEquals("Matti Meikäläinen, Testikatu 1,12345,Helsinki", kayttaja.toString());
    }
    @Test
    public void testLuokat() {
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

        path = "src/Kayttaja.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Kayttaja")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Kayttaja.java tiedostosta ei löytynyt 'public class Kayttaja' -määritystä.");

        path = "src/Tietokone.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

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

        path = "src/LeasingTieto.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class LeasingTieto")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "LeasingTieto.java tiedostosta ei löytynyt 'public class LeasingTieto' -määritystä.");

        path = "src/LeasingUtils.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class LeasingUtils")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "LeasingUtils.java tiedostosta ei löytynyt 'public class LeasingUtils' -määritystä.");
    }




    @Test
    public void testOsoiteOletusmuodostin() {
        Osoite osoite = new Osoite();
        assertNull(osoite.getLahiosoite());
        assertNull(osoite.getPostinumero());
        assertNull(osoite.getPostitoimipaikka());
    }

    @Test
    public void testOsoiteMuodostinArvoilla() {
        Osoite osoite = new Osoite("Testikatu 1", "12345", "Helsinki");
        assertEquals("Testikatu 1", osoite.getLahiosoite());
        assertEquals("12345", osoite.getPostinumero());
        assertEquals("Helsinki", osoite.getPostitoimipaikka());
    }

    @Test
    public void testSetLahiosoite() {
        osoite.setLahiosoite("Testikatu 1");
        assertEquals("Testikatu 1", osoite.getLahiosoite());
    }

    @Test
    public void testSetPostinumeroValid() {
        osoite.setPostinumero("12345");
        assertEquals("12345", osoite.getPostinumero());
    }

    @Test
    public void testSetPostinumeroInvalidLength() {
        osoite.setPostinumero("1234");
        assertEquals("00000", osoite.getPostinumero()); // liian lyhyt postinumero
    }



    @Test
    public void testOsoiteToString() {
        osoite = new Osoite("Testikatu 1", "12345", "Helsinki");
        assertEquals("Testikatu 1,12345,Helsinki", osoite.toString());
    }


    @Test
    public void testTietokoneOletusmuodostin() {
        assertNull(tietokone.getMerkki());
        assertNull(tietokone.getMalli());
        assertNull(tietokone.getSarjanumero());
    }

    @Test
    public void testTietokoneMuodostinArvoilla() {
        Tietokone tietokone = new Tietokone("Dell", "XPS 13", "SN123456");
        assertEquals("Dell", tietokone.getMerkki());
        assertEquals("XPS 13", tietokone.getMalli());
        assertEquals("SN123456", tietokone.getSarjanumero());
    }

    @Test
    public void testSetMerkki() {
        tietokone.setMerkki("Apple");
        assertEquals("Apple", tietokone.getMerkki());
    }

    @Test
    public void testSetMalli() {
        tietokone.setMalli("MacBook Pro");
        assertEquals("MacBook Pro", tietokone.getMalli());
    }

    @Test
    public void testSetSarjanumero() {
        tietokone.setSarjanumero("SN987654");
        assertEquals("SN987654", tietokone.getSarjanumero());
    }

    @Test
    public void testTietokoneToString() {
        tietokone = new Tietokone("HP", "Pavilion", "SN112233");
        assertEquals("HP,Pavilion,SN112233", tietokone.toString());
    }

    @Test
    public void testLeasingTietoOletusmuodostin() {
        assertNull(leasingTieto.getTietokone());
        assertNull(leasingTieto.getKayttaja());
        assertNull(leasingTieto.getPaivamaara());
    }

    @Test
    public void testLeasingTietoMuodostinArvoilla() {
        LocalDate paivamaara = LocalDate.of(2024, 1, 1);
        LeasingTieto leasingTieto = new LeasingTieto(tietokone, kayttaja, paivamaara);
        assertEquals(tietokone, leasingTieto.getTietokone());
        assertEquals(kayttaja, leasingTieto.getKayttaja());
        assertEquals(paivamaara, leasingTieto.getPaivamaara());
    }

    @Test
    public void testSetTietokone() {
        leasingTieto.setTietokone(tietokone);
        assertEquals(tietokone, leasingTieto.getTietokone());
    }

    @Test
    public void testSetKayttaja() {
        leasingTieto.setKayttaja(kayttaja);
        assertEquals(kayttaja, leasingTieto.getKayttaja());
    }

    @Test
    public void testSetPaivamaara() {
        LocalDate paivamaara = LocalDate.of(2024, 1, 1);
        leasingTieto.setPaivamaara(paivamaara);
        assertEquals(paivamaara, leasingTieto.getPaivamaara());
    }

    @Test
    public void testLeasingTietoToString() {
        tietokone = new Tietokone("Dell", "XPS 13", "SN123456");
        kayttaja = new Kayttaja("Matti Meikäläinen", new Osoite("Testikatu 1", "12345", "Helsinki"));
        LocalDate paivamaara = LocalDate.of(2024, 1, 1);
        leasingTieto = new LeasingTieto(tietokone, kayttaja, paivamaara);
        assertEquals("Dell,XPS 13,SN123456,Matti Meikäläinen, Testikatu 1,12345,Helsinki,2024-01-01", leasingTieto.toString());
    }

    @Test
    public void testKopioiTiedot() {
        tietokone = new Tietokone("Dell", "XPS 13", "SN123456");
        kayttaja = new Kayttaja("Matti Meikäläinen", new Osoite("Testikatu 1", "12345", "Helsinki"));
        LocalDate paivamaara = LocalDate.of(2024, 1, 1);
        leasingTieto = new LeasingTieto(tietokone, kayttaja, paivamaara);

        LeasingTieto kopio = LeasingUtils.kopioiTiedot(leasingTieto);

        // Tarkistetaan, että alkuperäisen ja kopion Tietokone-olioilla on sama merkki ja malli, mutta eri sarjanumero
        assertEquals(leasingTieto.getTietokone().getMerkki(), kopio.getTietokone().getMerkki());
        assertEquals(leasingTieto.getTietokone().getMalli(), kopio.getTietokone().getMalli());
        assertEquals("", kopio.getTietokone().getSarjanumero());

        // Tarkistetaan, että käyttäjän nimi on "?" ja osoite on null
        assertEquals("?", kopio.getKayttaja().getNimi());
        assertNull(kopio.getKayttaja().getOsoite());

        // Tarkistetaan, että päivämäärä on sama
        assertEquals(leasingTieto.getPaivamaara(), kopio.getPaivamaara());

        // Tarkistetaan, että kopio on eri olio kuin alkuperäinen
        assertNotSame(leasingTieto, kopio);
        assertNotSame(leasingTieto.getTietokone(), kopio.getTietokone());
        assertNotSame(leasingTieto.getKayttaja(), kopio.getKayttaja());
    }
}
