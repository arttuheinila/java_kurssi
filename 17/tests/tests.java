import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tests {


    // Väliaikainen aliluokka Tili-luokan testaamiseksi
    class TestTili extends Tili {
        public TestTili(String tilinumero, String omistaja) {
            this.setTilinumero(tilinumero);
            this.setOmistaja(omistaja);
        }

        public TestTili() {

        }

        public TestTili(String tilinumero, String omistaja, double saldo, double vuosikorko) {
            this(tilinumero, omistaja);
            this.setVuosikorko(vuosikorko);
            this.setSaldoEuroa(saldo);
        }

        @Override
        public double laskeVuosiKorkotuotto() {
            return getSaldoEuroa() * getVuosikorko() / 100;
        }

        @Override
        public void tulostaTilinTiedot() {
            System.out.printf("Omistaja: %s, Tilinumero: %s, Saldo: %.2f €, Korko: %.2f%%%n",
                    getOmistaja(), getTilinumero(), getSaldoEuroa(), getVuosikorko());
        }
    }

        @Test
        public void testOletusmuodostin() {
            Tili tili = new TestTili();
            assertEquals("Unknown", tili.getTilinumero());
            assertEquals("Unknown", tili.getOmistaja());
            assertEquals(0.0, tili.getSaldoEuroa());
            assertEquals(0.0, tili.getVuosikorko());
        }

        @Test
        public void testMuodostinTilinumerollaJaOmistajalla() {
            Tili tili = new TestTili("FI123456789012345", "Testi Henkilö");
            assertEquals("FI123456789012345", tili.getTilinumero());
            assertEquals("Testi Henkilö", tili.getOmistaja());
            assertEquals(0.0, tili.getSaldoEuroa());
            assertEquals(0.0, tili.getVuosikorko());
        }

        @Test
        public void testMuodostinKaikillaAttribuuteilla() {
            Tili tili = new TestTili("FI123456789012345", "Testi Henkilö", 1000.0, 1.5);
            assertEquals("FI123456789012345", tili.getTilinumero());
            assertEquals("Testi Henkilö", tili.getOmistaja());
            assertEquals(1000.0, tili.getSaldoEuroa());
            assertEquals(1.5, tili.getVuosikorko());
        }

        @Test
        public void testSetTilinumeroKelvollinen() {
            Tili tili = new TestTili();
            tili.setTilinumero("FI123456789012345");
            assertEquals("FI123456789012345", tili.getTilinumero());
        }

        @Test
        public void testSetTilinumeroVirheellinen() {
            Tili tili = new TestTili();
            tili.setTilinumero("12345");
            assertEquals("Unknown", tili.getTilinumero());
        }

        @Test
        public void testSetSaldoEuroaKelvollinen() {
            Tili tili = new TestTili();
            tili.setSaldoEuroa(500.0);
            assertEquals(500.0, tili.getSaldoEuroa());
        }

        @Test
        public void testSetSaldoEuroaNegatiivinen() {
            Tili tili = new TestTili();
            tili.setSaldoEuroa(-500.0);
            assertEquals(0.0, tili.getSaldoEuroa());
        }

        @Test
        public void testSetVuosikorkoKelvollinen() {
            Tili tili = new TestTili();
            tili.setVuosikorko(3.5);
            assertEquals(3.5, tili.getVuosikorko());
        }

        @Test
        public void testSetVuosikorkoNegatiivinen() {
            Tili tili = new TestTili();
            tili.setVuosikorko(-3.5);
            assertEquals(0.0, tili.getVuosikorko());
        }

        @Test
        public void testLaskeVuosiKorkotuotto() {
            Tili tili = new TestTili("FI123456789012345", "Testi Henkilö", 1000.0, 5.0);
            assertEquals(50.0, tili.laskeVuosiKorkotuotto());
        }


    @Test
    public void testSaastitiliLaskeVuosiKorkotuotto() {
        // Luodaan Saastotili-olio
        Saastotili tili = new Saastotili("FI1234567890123456", "Maiju Matikainen", 1000, 4.5);

        // Lasketaan korkotuotto
        double korkotuotto = tili.laskeVuosiKorkotuotto();

        // Tarkistetaan, että korkotuotto on oikein laskettu
        double expectedKorkotuotto = 1000 * (4.5 / 100);
        assertEquals(expectedKorkotuotto, korkotuotto, "Vuosikorkotuotto ei ole oikein");
    }

    @Test
    public void testTulostaTilinTiedot() {
        // Luodaan Saastotili-olio
        Saastotili tili = new Saastotili("FI1234567890123456", "Maiju Matikainen", 1000, 4.5);

        // Virtauskaappaus System.out:sta
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Kutsutaan tulostaTilinTiedot-metodia
        tili.tulostaTilinTiedot();

        // Tarkistetaan, että tuloste on oikeanlainen
        String expectedOutput = String.format("FI1234567890123456,  Maiju Matikainen: Saastotilin saldo on %.2f €, korkoprosentilla %.2f vuosikorko on %.2f €", 1000.0,4.5, 45.0);
        expectedOutput += System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString(), "Tilin tiedot eivät ole oikein tulostettu");
    }

    @Test
    public void testSaldoEiNegatiivinen() {
        // Luodaan Saastotili-olio negatiivisella saldolla
        Saastotili tili = new Saastotili("FI1234567890123456", "Kalle Hakkarainen", -1000, 4.5);

        // Varmistetaan, että saldo on nolla
        assertEquals(0, tili.getSaldoEuroa(), "Saldo ei voi olla negatiivinen");
    }

    @Test
    public void testKorkoprosenttiEiNegatiivinen() {
        // Luodaan Saastotili-olio negatiivisella korkoprosentilla
        Saastotili tili = new Saastotili("FI1234567890123456", "Kalle Hakkarainen", 1000.0, -4.5);

        // Varmistetaan, että korkoprosentti on nolla
        assertEquals(0, tili.getVuosikorko(), "Korkoprosentti ei voi olla negatiivinen");
    }



        @Test
        public void testSupersaastotiliKonstruktorit() {
            Supersaastotili tili = new Supersaastotili("FI1234567890123456", "Kalle Hakkarainen", 15000, 5.0);
            // Testaa, että konstruktorit toimivat oikein
            assertEquals("FI1234567890123456", tili.getTilinumero());
            assertEquals("Kalle Hakkarainen", tili.getOmistaja());
            assertEquals(15000, tili.getSaldoEuroa());
            assertEquals(5.0, tili.getVuosikorko());
        }

        @Test
        public void testLaskeVuosiKorkotuotto_perusOsuus() {
            Supersaastotili tili = new Supersaastotili("FI1234567890123456", "Kalle Hakkarainen", 15000, 5.0);

            // Testaa peruskoron laskeminen tilillä, jossa saldo on alle 10000 €
            tili.setSaldoEuroa(8000);
            tili.setVuosikorko(4.0);
            double korkotuotto = tili.laskeVuosiKorkotuotto();
            assertEquals(320, korkotuotto, 0.001);
        }

        @Test
        public void testLaskeVuosiKorkotuotto_lisaKorko() {
            Supersaastotili tili = new Supersaastotili("FI1234567890123456", "Kalle Hakkarainen", 15000, 5.0);

            // Testaa lisäkorko-osuuden laskeminen tilillä, jossa saldo on yli 10000 €
            tili.setSaldoEuroa(15000);
            tili.setVuosikorko(4.0);
            double korkotuotto = tili.laskeVuosiKorkotuotto();
            // Perusosuus: 10000 * 4% = 400
            // Lisäkorkoosuus: 5000 * 7% = 350
            // Yhteensä: 400 + 350 = 750
            assertEquals(750, korkotuotto, 0.001);
        }

        @Test
        public void testSupersaastitiliTulostaTilinTiedot() {
            Supersaastotili tili = new Supersaastotili("FI1234567890123456", "Kalle Hakkarainen", 15000, 5.0);

            // Testaa, että tulostus tapahtuu oikein
            tili.setSaldoEuroa(15000);
            tili.setVuosikorko(5.0);

            // Odotettu tulostus: "FI1234567890123456, Kalle Hakkarainen: Supersaastotilin saldo on 15000.00 €, korkoprosentilla 5.00 vuosikorko on 750.00 €"
            // Tämän testin voi suorittaa vain manuaalisesti, koska tulostus menee konsoliin
            tili.tulostaTilinTiedot();
        }

        @Test
        public void testNegativeSaldo() {            Supersaastotili tili = new Supersaastotili("FI1234567890123456", "Kalle Hakkarainen", 15000, 5.0);


            // Testaa, että saldo ei voi olla negatiivinen
            tili.setSaldoEuroa(-1000);
            assertEquals(0, tili.getSaldoEuroa(), 0.001);
        }

        @Test
        public void testNegativeKorko() {
            Supersaastotili tili = new Supersaastotili("FI1234567890123456", "Kalle Hakkarainen", 15000, 5.0);

            // Testaa, että korko ei voi olla negatiivinen
            tili.setVuosikorko(-2.0);
            assertEquals(0, tili.getVuosikorko(), 0.001);
        }





    @Test
    public void test1() {
        String path = "src/Tili.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public abstract class Tili")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Tili.java tiedostosta ei löytynyt 'public abstract class Tili' -määritystä.");


        path = "src/Saastotili.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Saastotili")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Saastotili.java tiedostosta ei löytynyt 'public class Saastotili' -määritystä.");



        path = "src/Supersaastotili.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Supersaastotili")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Supersaastotili.java tiedostosta ei löytynyt 'public class Supersaastotili' -määritystä.");

    }

}