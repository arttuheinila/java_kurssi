import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.time.LocalDate;

public class tests {

    private Osake osake;
    private OsakeOsto osakeOsto1;
    private OsakeOsto osakeOsto2;

    @BeforeEach
    public void setUp() {
        // Luodaan Osake-olio ennen jokaista testiä
        osake = new Osake("Testiosake");

        // Luodaan OsakeOsto-olioita, joita käytetään testeissä
        osakeOsto1 = new OsakeOsto(100, 50, LocalDate.of(2025, 1, 1)); // Esimerkiksi 100 kappaletta hintaan 50
        osakeOsto2 = new OsakeOsto(200, 60, LocalDate.of(2023, 1, 1)); // Esimerkiksi 200 kappaletta hintaan 60

        // Lisätään osakeostot osakkeeseen
        osake.lisaaOsto(osakeOsto1);
        osake.lisaaOsto(osakeOsto2);
    }

    @Test
    public void testPalautaSijoitettuPaaoma() {
        // Testaa, että sijoitettu pääoma on oikein
        double sijoitettuPaaoma = osake.palautaSijoitettuPaaoma();
        // osakeOsto1 sijoitettu pääoma = 100 * 50 = 5000
        // osakeOsto2 sijoitettu pääoma = 200 * 60 = 12000
        double expected = 5000 + 12000;
        assertEquals(expected, sijoitettuPaaoma);
    }

    @Test
    public void testPalautaArvoKurssilla() {
        // Testaa, että osakkeen arvo kurssilla 100 on oikein
        double arvo = osake.palautaArvo(100); // (100 * 100) + (200 * 100)
        double expected = (100 * 100) + (200 * 100); // 10000 + 20000 = 30000
        assertEquals(expected, arvo);
    }

    @Test
    public void testPalautaArvoTuotolla() {
        // Testaa, että osakkeen arvo tuotoilla on oikein
        // Käytetään korkoprosenttia 5 ja vuosia 3
        double arvo = osake.palautaArvo(5, 3);
        // Osto 1 tuotto = (5000 * 5 / 100) * 3 = 750
        // Osto 2 tuotto = (12000 * 5 / 100) * 3 = 1800
        double expected = (5000 + 750) + (12000 + 1800);
        assertEquals(expected, arvo);
    }

    @Test
    public void testTulostaOsakeTiedotJaOstot() {
        // Testaa, että tulostus toimii, tässä ei testata tulostuksen sisältöä vaan sen suorittamista
        // Voit käyttää jollain tavalla System.out-tulostusta tms. testataaksesi
        // Tämä testataan vain että metodi ei aiheuta virhettä
        osake.tulostaOsakeTiedotJaOstot();
        // Ei voida tarkistaa suoraan ilman ulkoista tarkastelua
        assertTrue(true); // Pelkkä tarkistus, että metodi suoritettiin ilman virhettä
    }

    @Test
    public void testLisaaOsto() {
        // Testaa, että ostot lisätään oikein listalle
        OsakeOsto osakeOsto3 = new OsakeOsto(50, 70, LocalDate.now());
        osake.lisaaOsto(osakeOsto3);
        assertEquals(3, osake.ostot.size()); // Osakkeita pitäisi olla nyt 3
        assertTrue(osake.ostot.contains(osakeOsto3)); // Uusi osto pitäisi olla listalla
    }

    @Test
    public void test1() {
        String path = "src/Osake.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Osake")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Osake.java tiedostosta ei löytynyt 'public class Opiskelija' -määritystä.");

        path = "src/OsakeOsto.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class OsakeOsto")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "OsakeOsto.java tiedostosta ei löytynyt 'public class Opiskelijat' -määritystä.");


    }



    @Test
    public void testGetKappalemaara() {
        // Testaa, että kappalemaara on oikein
        assertEquals(100, osakeOsto1.getKappalemaara());
    }

    @Test
    public void testSetKappalemaaraPositive() {
        // Testaa, että kappalemaara asetetaan oikein
        osakeOsto1.setKappalemaara(150);
        assertEquals(150, osakeOsto1.getKappalemaara());
    }

    @Test
    public void testSetKappalemaaraNegative() {
        // Testaa, että negatiivinen kappalemaara asetetaan nollaksi
        osakeOsto1.setKappalemaara(-50);
        assertEquals(0, osakeOsto1.getKappalemaara());
    }

    @Test
    public void testGetOstohinta() {
        // Testaa, että ostohinta on oikein
        assertEquals(50.0, osakeOsto1.getOstohinta());
    }

    @Test
    public void testSetOstohintaPositive() {
        // Testaa, että ostohinta asetetaan oikein
        osakeOsto1.setOstohinta(60.0);
        assertEquals(60.0, osakeOsto1.getOstohinta());
    }

    @Test
    public void testSetOstohintaNegative() {
        // Testaa, että negatiivinen ostohinta asetetaan nollaksi
        osakeOsto1.setOstohinta(-100.0);
        assertEquals(0.0, osakeOsto1.getOstohinta());
    }

    @Test
    public void testGetOstopaivamaara() {
        // Testaa, että ostopäivämäärä on oikein
        assertEquals(LocalDate.of(2023, 1, 1), osakeOsto2.getOstopaivamaara());
    }

    @Test
    public void testSetOstopaivamaaraFuture() {
        // Testaa, että tuleva päivämäärä asetetaan nykyiseksi
        osakeOsto1.setOstopaivamaara(LocalDate.of(2050, 1, 1));
        assertEquals(LocalDate.now(), osakeOsto1.getOstopaivamaara());
    }

    @Test
    public void testSetOstopaivamaaraPast() {
        // Testaa, että mennyt päivämäärä hyväksytään
        osakeOsto1.setOstopaivamaara(LocalDate.of(2022, 1, 1));
        assertEquals(LocalDate.of(2022, 1, 1), osakeOsto1.getOstopaivamaara());
    }

    @Test
    public void testPalautaSijoitettuPaaoma2() {
        // Testaa, että sijoitettu pääoma lasketaan oikein
        double sijoitettuPaaoma = osakeOsto1.palautaSijoitettuPaaoma();
        assertEquals(100 * 50.0, sijoitettuPaaoma);
    }

    @Test
    public void testPalautaYhdenVuodenTuotto() {
        // Testaa, että yhden vuoden tuotto lasketaan oikein
        double tuotto = osakeOsto1.palautaYhdenVuodenTuotto(5);
        assertEquals(5000 * 0.05, tuotto);
    }

    @Test
    public void testPalautaTuotto() {
        // Testaa, että tuotto lasketaan oikein useammalle vuodelle
        double tuotto = osakeOsto1.palautaTuotto(5, 3);

        assertEquals(750, tuotto);
    }

    @Test
    public void testToString() {
        // Testaa toString-metodin toimivuutta
        String expected = "200,60.0,2023-01-01";
        assertEquals(expected, osakeOsto2.toString());
    }

}