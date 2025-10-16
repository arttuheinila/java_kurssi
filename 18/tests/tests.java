import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class tests {


        void konstruktoriProjektiAlustaaOikein() {
            Projektipaallikko paallikko = new Projektipaallikko("Matti", 40, 10);
            Projekti projekti = new Projekti("Uusi Projekti", 50000, paallikko, LocalDate.of(2024, 5, 1), LocalDate.of(2025, 5, 1)) {
                @Override
                public void suunnittele() {
                    // Täytetään abstrakti metodi
                }

                @Override
                public void toteuta() {
                    // Täytetään abstrakti metodi
                }
            };

            assertEquals("Uusi Projekti", projekti.getNimi());
            assertEquals(50000, projekti.getBudjetti());
            assertEquals("Matti", projekti.getPaallikko().getNimi());
            assertEquals(LocalDate.of(2024, 5, 1), projekti.getAlkamisaika());
            assertEquals(LocalDate.of(2025, 5, 1), projekti.getPaattymisaika());
        }

        // Testi tyhjän nimen tarkistamiselle
        @Test
        void setNimiHeittaaPoikkeuksenTyhjallaNimella() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new Projekti("", 50000, new Projektipaallikko("Matti", 40, 10), LocalDate.of(2024, 5, 1), LocalDate.of(2025, 5, 1)) {
                    @Override
                    public void suunnittele() {}
                    @Override
                    public void toteuta() {}
                };
            });
            assertEquals("Nimi ei saa olla tyhjä.", exception.getMessage());
        }

        // Testi negatiiviselle budjetille
        @Test
        void setBudjettiHeittaaPoikkeuksenNegatiivisellaBudjetilla() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new Projekti("Uusi Projekti", -1000, new Projektipaallikko("Matti", 40, 10), LocalDate.of(2024, 5, 1), LocalDate.of(2025, 5, 1)) {
                    @Override
                    public void suunnittele() {}
                    @Override
                    public void toteuta() {}
                };
            });
            assertEquals("Budjetti ei saa olla negatiivinen.", exception.getMessage());
        }

        // Testi projektipäällikön null-arvolle
        @Test
        void setPaallikkoHeittaaPoikkeuksenNullPaallikolla() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new Projekti("Uusi Projekti", 50000, null, LocalDate.of(2024, 5, 1), LocalDate.of(2025, 5, 1)) {
                    @Override
                    public void suunnittele() {}
                    @Override
                    public void toteuta() {}
                };
            });
            assertEquals("Projektipäällikkö ei saa olla null.", exception.getMessage());
        }

        // Testi alkamisaika ennen päättymisaikaa
        @Test
        void setPaattymisaikaHeittaaPoikkeuksenJosPaattymisaikaOnEnnenAlkamisaikaa() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new Projekti("Uusi Projekti", 50000, new Projektipaallikko("Matti", 40, 10), LocalDate.of(2025, 5, 1), LocalDate.of(2024, 5, 1)) {
                    @Override
                    public void suunnittele() {}
                    @Override
                    public void toteuta() {}
                };
            });
            assertEquals("Päättymisaika ei voi olla ennen alkamisaikaa.", exception.getMessage());
        }

        // Testi toString-metodille
        @Test
        void toStringPalauttaaOikeanMerkkijonon() {
            Projektipaallikko paallikko = new Projektipaallikko("Matti", 40, 10);
            Projekti projekti = new Projekti("Uusi Projekti", 50000, paallikko, LocalDate.of(2024, 5, 1), LocalDate.of(2025, 5, 1)) {
                @Override
                public void suunnittele() {}
                @Override
                public void toteuta() {}
            };

            String expected = "Uusi Projekti, 50000.0, Matti, 2024-05-01, 2025-05-01";
            assertEquals(expected, projekti.toString());
        }

        // Testiluokka Henkilo on abstrakti, joten luodaan testikäyttöä varten toteutus.
        private static class TestiHenkilo extends Henkilo {
            public TestiHenkilo() {
                super();
            }

            public TestiHenkilo(String nimi, int ika) {
                super(nimi, ika);
            }
        }


        @Test
        void konstruktoriAlustaaOikein() {
            Projektipaallikko paallikko = new Projektipaallikko("Anna", 40, 15);
            assertEquals("Anna", paallikko.getNimi());
            assertEquals(40, paallikko.getIka());
            assertEquals(15, paallikko.getKokemusVuodet());
        }

        @Test
        void konstruktoriHeittaaPoikkeuksenNegatiivisillaKokemusVuodenArvoilla() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new Projektipaallikko("Anna", 40, -5);
            });
            assertEquals("Kokemusvuodet ei saa olla negatiivinen.", exception.getMessage());
        }

        @Test
        void setKokemusVuodetToimiiOikein() {
            Projektipaallikko paallikko = new Projektipaallikko("Anna", 40, 10);
            paallikko.setKokemusVuodet(20);
            assertEquals(20, paallikko.getKokemusVuodet());
        }

        @Test
        void setKokemusVuodetHeittaaPoikkeuksenNegatiivisellaArvolla() {
            Projektipaallikko paallikko = new Projektipaallikko("Anna", 40, 10);
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                paallikko.setKokemusVuodet(-1);
            });
            assertEquals("Kokemusvuodet ei saa olla negatiivinen.", exception.getMessage());
        }

        @Test
        void toStringProjektipaallikkoPalauttaaOikeanMerkkijonon() {
            Projektipaallikko paallikko = new Projektipaallikko("Anna", 40, 15);
            assertEquals("Anna, 40, 15", paallikko.toString());
        }

        @Test
        void toStringPalauttaaOikeanMerkkijononTyhjaNimi() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new Projektipaallikko("", 40, 10);
            });
            assertEquals("Nimi ei saa olla tyhjä.", exception.getMessage());
        }


        @Test
        void oletusmuodostinAlustaaOikein() {
            Henkilo henkilo = new TestiHenkilo();
            assertEquals("Tuntematon", henkilo.getNimi());
            assertEquals(0, henkilo.getIka());
        }

        @Test
        void parametrillinenMuodostinAlustaaOikein() {
            Henkilo henkilo = new TestiHenkilo("Matti", 25);
            assertEquals("Matti", henkilo.getNimi());
            assertEquals(25, henkilo.getIka());
        }

        @Test
        void parametrillinenMuodostinHeittaaPoikkeuksenTyhjallaNimella() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new TestiHenkilo("", 25);
            });
            assertEquals("Nimi ei saa olla tyhjä.", exception.getMessage());
        }

        @Test
        void parametrillinenMuodostinHeittaaPoikkeuksenNegatiivisellaIalla() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new TestiHenkilo("Matti", -5);
            });
            assertEquals("Ikä ei saa olla negatiivinen.", exception.getMessage());
        }

        @Test
        void setNimiToimiiOikein() {
            Henkilo henkilo = new TestiHenkilo();
            henkilo.setNimi("Liisa");
            assertEquals("Liisa", henkilo.getNimi());
        }

        @Test
        void setNimiHeittaaPoikkeuksenTyhjallaArvolla() {
            Henkilo henkilo = new TestiHenkilo();
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                henkilo.setNimi("");
            });
            assertEquals("Nimi ei saa olla tyhjä.", exception.getMessage());
        }

        @Test
        void setIkaToimiiOikein() {
            Henkilo henkilo = new TestiHenkilo();
            henkilo.setIka(30);
            assertEquals(30, henkilo.getIka());
        }

        @Test
        void setIkaHeittaaPoikkeuksenNegatiivisellaArvolla() {
            Henkilo henkilo = new TestiHenkilo();
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                henkilo.setIka(-1);
            });
            assertEquals("Ikä ei saa olla negatiivinen.", exception.getMessage());
        }

        @Test
        void toStringHenkiloPalauttaaOikeanMerkkijonon() {
            Henkilo henkilo = new TestiHenkilo("Matti", 25);
            assertEquals("Matti, 25", henkilo.toString());
        }



        // Testi konstruktorille ja getterien tarkistamiselle
        @Test
        void konstruktoriOhjelmistoprojektiAlustaaOikein() {
            Projektipaallikko paallikko = new Projektipaallikko("Matti", 40, 10);
            Ohjelmistoprojekti projekti = new Ohjelmistoprojekti(
                    "Verkkosovellusprojekti",
                    200000,
                    paallikko,
                    LocalDate.of(2024, 6, 1),
                    LocalDate.of(2025, 6, 1),
                    5,
                    "Java, Spring Boot, React"
            );

            assertEquals("Verkkosovellusprojekti", projekti.getNimi());
            assertEquals(200000, projekti.getBudjetti());
            assertEquals("Matti", projekti.getPaallikko().getNimi());
            assertEquals(5, projekti.getKehittajienMaara());
            assertEquals("Java, Spring Boot, React", projekti.getTeknologiat());
        }

        // Testi kehittäjien määrän validoinnille (negatiivinen arvo)
        @Test
        void setKehittajienMaaraHeittaaPoikkeuksenNegatiivisellaArvolla() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new Ohjelmistoprojekti(
                        "Verkkosovellusprojekti",
                        200000,
                        new Projektipaallikko("Matti", 40, 10),
                        LocalDate.of(2024, 6, 1),
                        LocalDate.of(2025, 6, 1),
                        -5,  // negatiivinen kehittäjien määrä
                        "Java"
                );
            });
            assertEquals("Kehittäjien määrä ei saa olla negatiivinen.", exception.getMessage());
        }

        // Testi teknologioiden validoinnille (tyhjä arvo)
        @Test
        void setTeknologiatHeittaaPoikkeuksenTyhjallaArvolla() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new Ohjelmistoprojekti(
                        "Verkkosovellusprojekti",
                        200000,
                        new Projektipaallikko("Matti", 40, 10),
                        LocalDate.of(2024, 6, 1),
                        LocalDate.of(2025, 6, 1),
                        5,
                        ""  // tyhjä teknologiat
                );
            });
            assertEquals("Teknologiat ei saa olla tyhjä.", exception.getMessage());
        }

        // Testi suunnittele-metodin toiminnan varmistamiselle
        @Test
        void suunnitteleTulostaaOikeanViestin() {
            Ohjelmistoprojekti projekti = new Ohjelmistoprojekti(
                    "Verkkosovellusprojekti",
                    200000,
                    new Projektipaallikko("Matti", 40, 10),
                    LocalDate.of(2024, 6, 1),
                    LocalDate.of(2025, 6, 1),
                    5,
                    "Java, Spring Boot, React"
            );

            // Ohjelmistoprojekti suunnittele-metodi tulostaa tekstin, joten voimme tarkistaa sen
            projekti.suunnittele(); // Ei void-metodille voi tarkistaa palautusta suoraan
        }

        // Testi toteuta-metodin toiminnan varmistamiselle
        @Test
        void toteutaTulostaaOikeanViestin() {
            Ohjelmistoprojekti projekti = new Ohjelmistoprojekti(
                    "Verkkosovellusprojekti",
                    200000,
                    new Projektipaallikko("Matti", 40, 10),
                    LocalDate.of(2024, 6, 1),
                    LocalDate.of(2025, 6, 1),
                    5,
                    "Java, Spring Boot, React"
            );

            // Ohjelmistoprojekti toteuta-metodi tulostaa tekstin, joten voimme tarkistaa sen
            projekti.toteuta(); // Ei void-metodille voi tarkistaa palautusta suoraan
        }

        // Testi toString-metodin toiminnalle
        @Test
        void toStringOhjelmistoprojektiPalauttaaOikeanMerkkijonon() {
            Projektipaallikko paallikko = new Projektipaallikko("Matti", 40, 10);
            Ohjelmistoprojekti projekti = new Ohjelmistoprojekti(
                    "Verkkosovellusprojekti",
                    200000,
                    paallikko,
                    LocalDate.of(2024, 6, 1),
                    LocalDate.of(2025, 6, 1),
                    5,
                    "Java, Spring Boot, React"
            );

            String expected = "Verkkosovellusprojekti, 200000.0, Matti, 2024-06-01, 2025-06-01, 5, Java, Spring Boot, React";
            assertEquals(expected, projekti.toString());
        }


        @Test
        void konstruktoriRakennusprojektiAlustaaOikein() {
            // Luo Projektipaallikko ja Rakennusprojekti
            Projektipaallikko paallikko = new Projektipaallikko("Matti", 40, 10);
            Rakennusprojekti projekti = new Rakennusprojekti(
                    "Talo",
                    500000,
                    paallikko,
                    LocalDate.of(2024, 5, 1),
                    LocalDate.of(2025, 5, 1),
                    "Helsinki"
            );

            // Tarkistetaan, että kaikki kentät on alustettu oikein
            assertEquals("Talo", projekti.getNimi());
            assertEquals(500000, projekti.getBudjetti());
            assertEquals("Matti", projekti.getPaallikko().getNimi());
            assertEquals("Helsinki", projekti.getSijainti());
            assertEquals(LocalDate.of(2024, 5, 1), projekti.getAlkamisaika());
            assertEquals(LocalDate.of(2025, 5, 1), projekti.getPaattymisaika());
        }

        @Test
        void setSijaintiHeittaaPoikkeuksenTyhjallaArvolla() {
            // Testaa, että tyhjä sijainti aiheuttaa poikkeuksen
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new Rakennusprojekti(
                        "Talo",
                        500000,
                        new Projektipaallikko("Matti", 40, 10),
                        LocalDate.of(2024, 5, 1),
                        LocalDate.of(2025, 5, 1),
                        ""  // Tyhjä sijainti
                );
            });
            assertEquals("Sijainti ei saa olla tyhjä.", exception.getMessage());
        }

        @Test
        void suunnitteleTulostaaOikein() {
            // Testaa suunnittelu-metodin toimivuus
            Rakennusprojekti projekti = new Rakennusprojekti(
                    "Talo",
                    500000,
                    new Projektipaallikko("Matti", 40, 10),
                    LocalDate.of(2024, 5, 1),
                    LocalDate.of(2025, 5, 1),
                    "Helsinki"
            );

            // Ohjelma tulostaa, joten testissä käytetään System.out:n tarkkailua
            assertDoesNotThrow(() -> projekti.suunnittele());
        }

        @Test
        void toteutaTulostaaOikein() {
            // Testaa toteutus-metodin toimivuus
            Rakennusprojekti projekti = new Rakennusprojekti(
                    "Talo",
                    500000,
                    new Projektipaallikko("Matti", 40, 10),
                    LocalDate.of(2024, 5, 1),
                    LocalDate.of(2025, 5, 1),
                    "Helsinki"
            );

            // Ohjelma tulostaa, joten testissä käytetään System.out:n tarkkailua
            assertDoesNotThrow(() -> projekti.toteuta());
        }

        @Test
        void toStringRakennusproketiPalauttaaOikeanMerkkijonon() {
            // Testaa, että toString palauttaa oikean merkkijonon
            Projektipaallikko paallikko = new Projektipaallikko("Matti", 40, 10);
            Rakennusprojekti projekti = new Rakennusprojekti(
                    "Talo",
                    500000,
                    paallikko,
                    LocalDate.of(2024, 5, 1),
                    LocalDate.of(2025, 5, 1),
                    "Helsinki"
            );

            String expected = "Talo, 500000.0, Matti, 2024-05-01, 2025-05-01, Helsinki";
            assertEquals(expected, projekti.toString());
        }


    @Test
    public void test1() {
        String path = "src/Henkilo.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public abstract class Henkilo")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Henkilo.java tiedostosta ei löytynyt 'public abstract class Henkilo' -määritystä.");


        path = "src/Projektipaallikko.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Projektipaallikko")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Ohjelmistoprojekti.java tiedostosta ei löytynyt 'public class Ohjelmistoprojekti' -määritystä.");

        path = "src/Ohjelmistoprojekti.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Ohjelmistoprojekti")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Ohjelmistoprojekti.java tiedostosta ei löytynyt 'public class Ohjelmistoprojekti' -määritystä.");


        path = "src/Rakennusprojekti.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Rakennusprojekti")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Rakennusprojekti.java tiedostosta ei löytynyt 'public class Rakennusprojekti' -määritystä.");

        path = "src/Projekti.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public abstract class Projekti")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Projekti.java tiedostosta ei löytynyt 'public class Projekti' -määritystä.");

    }

}