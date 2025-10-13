import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tests {



        @Test
        void testAjoneuvoOletusmuodostin() {
            Ajoneuvo ajoneuvo = new Ajoneuvo();
            assertEquals("Tuntematon", ajoneuvo.getNimi());
            assertEquals(0, ajoneuvo.getMaksiminopeus());
            assertEquals(0, ajoneuvo.getPaino());
        }

        @Test
        void testAjoneuvoParametrillinenMuodostin() {
            Ajoneuvo ajoneuvo = new Ajoneuvo("Auto", 120, 1500);
            assertEquals("Auto", ajoneuvo.getNimi());
            assertEquals(120, ajoneuvo.getMaksiminopeus());
            assertEquals(1500, ajoneuvo.getPaino());
        }

        @Test
        void testSetNimi() {
            Ajoneuvo ajoneuvo = new Ajoneuvo();
            ajoneuvo.setNimi("Moottoripyörä");
            assertEquals("Moottoripyörä", ajoneuvo.getNimi());
        }

        @Test
        void testSetMaksiminopeus() {
            Ajoneuvo ajoneuvo = new Ajoneuvo();
            ajoneuvo.setMaksiminopeus(100);
            assertEquals(100, ajoneuvo.getMaksiminopeus());
            ajoneuvo.setMaksiminopeus(-100);
            assertEquals(0, ajoneuvo.getMaksiminopeus());


        }

        @Test
        void testSetPaino() {
            Ajoneuvo ajoneuvo = new Ajoneuvo();
            ajoneuvo.setPaino(750);
            assertEquals(750, ajoneuvo.getPaino());

            ajoneuvo.setPaino(-100);
            assertEquals(0, ajoneuvo.getPaino());
        }

        @Test
        void testToString() {
            Ajoneuvo ajoneuvo = new Ajoneuvo("Kuorma-auto", 80, 5000);
            assertEquals("Kuorma-auto, 80, 5000", ajoneuvo.toString());
        }



        @Test
        void testVeneOletusmuodostin() {
            Vene vene = new Vene();
            assertEquals("Tuntematon", vene.getNimi());
            assertEquals(0, vene.getMaksiminopeus());
            assertEquals(0, vene.getPaino());
            assertEquals(0, vene.getKantavuus());
            assertEquals(0, vene.getSyvays());
        }

        @Test
        void testVeneParametrillinenMuodostin() {
            Vene vene = new Vene("Moottorivene", 60, 1500, 500, 2);
            assertEquals("Moottorivene", vene.getNimi());
            assertEquals(60, vene.getMaksiminopeus());
            assertEquals(1500, vene.getPaino());
            assertEquals(500, vene.getKantavuus());
            assertEquals(2, vene.getSyvays());
        }

        @Test
        void testSetKantavuus() {
            Vene vene = new Vene();
            vene.setKantavuus(400);
            assertEquals(400, vene.getKantavuus());

            vene.setKantavuus(-50); // Negatiivinen arvo asetetaan nollaksi
            assertEquals(0, vene.getKantavuus());
        }

        @Test
        void testSetSyvays() {
            Vene vene = new Vene();
            vene.setSyvays(3);
            assertEquals(3, vene.getSyvays());

            vene.setSyvays(-1); // Negatiivinen arvo asetetaan nollaksi
            assertEquals(0, vene.getSyvays());
        }

        @Test
        void testVeneToString() {
            Vene vene = new Vene("Soutuvene", 20, 300, 200, 1);
            String odotettu = "Soutuvene, 20, 300, 200, 1";
            assertEquals(odotettu, vene.toString());
        }

        @Test
        void testVenePeritytOminaisuudet() {
            Vene vene = new Vene("Purjevene", 10, 1000, 700, 3);
            vene.setNimi("Uusi Purjevene");
            vene.setMaksiminopeus(15);
            vene.setPaino(1200);

            assertEquals("Uusi Purjevene", vene.getNimi());
            assertEquals(15, vene.getMaksiminopeus());
            assertEquals(1200, vene.getPaino());
        }


        // Testaa oletusmuodostin
        @Test
        void testAutoOletusmuodostin() {
            Auto auto = new Auto();
            assertEquals("Tuntematon", auto.getNimi());
            assertEquals(0, auto.getMaksiminopeus());
            assertEquals(0, auto.getPaino());
            assertEquals(0, auto.getHenkilolkm());
            assertEquals("Tuntematon", auto.getVaihteisto());
        }

        // Testaa parametrillinen muodostin
        @Test
        void testAutoParametrillinenMuodostin() {
            Auto auto = new Auto("Sedan", 180, 1500, 5, "Automaatti");
            assertEquals("Sedan", auto.getNimi());
            assertEquals(180, auto.getMaksiminopeus());
            assertEquals(1500, auto.getPaino());
            assertEquals(5, auto.getHenkilolkm());
            assertEquals("Automaatti", auto.getVaihteisto());
        }

        // Testaa negatiivisen henkilömäärän käsittely
        @Test
        void testSetHenkilolkmNegatiivinen() {
            Auto auto = new Auto();
            auto.setHenkilolkm(-5); // Asetetaan negatiivinen arvo
            assertEquals(0, auto.getHenkilolkm()); // Arvo asetetaan nollaksi
        }

        // Testaa virheellisen vaihteiston käsittely
        @Test
        void testSetVaihteistoVirheellinen() {
            Auto auto = new Auto();
            auto.setVaihteisto("CVT"); // Virheellinen vaihteisto
            assertEquals("Tuntematon", auto.getVaihteisto()); // Oletusarvo "Tuntematon"
        }

        // Testaa vaihteiston tyypin asettaminen oikein
        @Test
        void testSetVaihteistoOikea() {
            Auto auto = new Auto();
            auto.setVaihteisto("Manuaali");
            assertEquals("Manuaali", auto.getVaihteisto()); // Asetetaan oikea vaihteisto
        }

        // Testaa toString-metodi
        @Test
        void testAutoToString() {
            Auto auto = new Auto("Sedan", 180, 1500, 5, "Automaatti");
            String odotettu = "Sedan, 180, 1500, 5, Automaatti";
            assertEquals(odotettu, auto.toString()); // Tarkistetaan oikea toString-arvo
        }

        // Testaa päivitettyjen arvojen käsittely
        @Test
        void testPäivitetytArvot() {
            Auto auto = new Auto("Coupe", 220, 1300, 4, "Manuaali");
            auto.setHenkilolkm(2); // Päivitetään henkilömäärä
            auto.setVaihteisto("Automaatti"); // Päivitetään vaihteisto

            assertEquals(2, auto.getHenkilolkm());
            assertEquals("Automaatti", auto.getVaihteisto());
        }




        // Testaa oletusmuodostin
        @Test
        void testPolttomoottoriautoOletusmuodostin() {
            Polttomoottoriauto auto = new Polttomoottoriauto();
            assertEquals(0, auto.getMoottoritilavuus(), "Moottoritilavuus pitäisi olla 0 oletusmuodostimella.");
            assertEquals(0.0, auto.getPolttoaineenKulutus(), "Polttoaineen kulutus pitäisi olla 0 oletusmuodostimella.");
        }

        // Testaa parametrillinen muodostin
        @Test
        void testPolttomoottoriautoParametrillinenMuodostin() {
            Polttomoottoriauto auto = new Polttomoottoriauto("Sedan", 180, 1500, 5, "Automaatti", 2000, 8.5);
            assertEquals(2000, auto.getMoottoritilavuus(), "Moottoritilavuuden pitäisi olla 2000.");
            assertEquals(8.5, auto.getPolttoaineenKulutus(), "Polttoaineen kulutuksen pitäisi olla 8.5.");
        }

        // Testaa setterit negatiivisille arvoille
        @Test
        void testSetMoottoritilavuusNegatiivinen() {
            Polttomoottoriauto auto = new Polttomoottoriauto();
            auto.setMoottoritilavuus(-2000);
            assertEquals(0, auto.getMoottoritilavuus(), "Moottoritilavuus ei saa olla negatiivinen, sen pitäisi olla 0.");
        }

        @Test
        void testSetPolttoaineenKulutusNegatiivinen() {
            Polttomoottoriauto auto = new Polttomoottoriauto();
            auto.setPolttoaineenKulutus(-8.5);
            assertEquals(0.0, auto.getPolttoaineenKulutus(), "Polttoaineen kulutus ei saa olla negatiivinen, sen pitäisi olla 0.0.");
        }

        // Testaa toString-metodi
        @Test
        void testPolttomoottoriautoToString() {
            Polttomoottoriauto auto = new Polttomoottoriauto("Sedan", 180, 1500, 5, "Automaatti", 2000, 85.5);
            //String odotettu = "";//""Sedan, 180, 1500, 5, Automaatti, 2000, 8,50";
            String odotettu = String.format("Sedan, 180, 1500, 5, Automaatti, 2000, %.2f", 85.5);
            assertEquals(odotettu, auto.toString(), "toString-metodin tulos ei ole odotettu.");
        }

        // Testaa setterit ja getterit
        @Test
        void testPolttomoottoriautoSetteritGetterit() {
            Polttomoottoriauto auto = new Polttomoottoriauto();

            auto.setMoottoritilavuus(3000);
            auto.setPolttoaineenKulutus(10.5);

            assertEquals(3000, auto.getMoottoritilavuus(), "Moottoritilavuuden pitäisi olla 3000.");
            assertEquals(10.5, auto.getPolttoaineenKulutus(), "Polttoaineen kulutuksen pitäisi olla 10.5.");
        }

    // Testaa oletusmuodostin
    @Test
    void testSahkoautoOletusmuodostin() {
        Sahkoauto auto = new Sahkoauto();
        assertEquals(0.0, auto.getAkkukapasiteetti(), "Oletusmuodostimella akkukapasiteetin pitäisi olla 0.0.");
        assertEquals(0, auto.getRange(), "Oletusmuodostimella rangin pitäisi olla 0.");
    }

    // Testaa parametrillinen muodostin
    @Test
    void testSahkoautoParametrillinenMuodostin() {
        Sahkoauto auto = new Sahkoauto("Tesla", 200, 1900, 5, "Automaatti", 85.5, 400);
        assertEquals(85.5, auto.getAkkukapasiteetti(), "Akkukapasiteetin pitäisi olla 85.5.");
        assertEquals(400, auto.getRange(), "Rangin pitäisi olla 400.");
    }

    // Testaa setterit negatiivisille arvoille
    @Test
    void testSetAkkukapasiteettiNegatiivinen() {
        Sahkoauto auto = new Sahkoauto();
        auto.setAkkukapasiteetti(-50.0);
        assertEquals(0.0, auto.getAkkukapasiteetti(), "Akkukapasiteetti ei saa olla negatiivinen, sen pitäisi olla 0.0.");
    }

    @Test
    void testSetRangeNegatiivinen() {
        Sahkoauto auto = new Sahkoauto();
        auto.setRange(-300);
        assertEquals(0, auto.getRange(), "Range ei saa olla negatiivinen, sen pitäisi olla 0.");
    }

    // Testaa toString-metodi
    @Test
    void testSahkoautoToString() {
        Sahkoauto auto = new Sahkoauto("Tesla", 200, 1900, 5, "Automaatti", 85.5, 400);
        //String odotettu = ""; // = "Tesla, 200, 1900, 5, Automaatti, 85,50, 400";
        String odotettu = String.format("Tesla, 200, 1900, 5, Automaatti, %.2f, 400", 85.5);
        assertEquals(odotettu, auto.toString(), "toString-metodin tulos ei vastaa odotettua.");
    }

    // Testaa setterit ja getterit
    @Test
    void testSahkoautoSetteritGetterit() {
        Sahkoauto auto = new Sahkoauto();

        auto.setAkkukapasiteetti(100.0);
        auto.setRange(500);

        assertEquals(100.0, auto.getAkkukapasiteetti(), "Akkukapasiteetin pitäisi olla 100.0.");
        assertEquals(500, auto.getRange(), "Rangin pitäisi olla 500.");
    }
    @Test
    public void test1() {
        String path = "src/Ajoneuvo.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Ajoneuvo")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Ajoneuvo.java tiedostosta ei löytynyt 'public class Ajoneuvo' -määritystä.");


        path = "src/Vene.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Vene")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Vene.java tiedostosta ei löytynyt 'public class Vene' -määritystä.");



        path = "src/Auto.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

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



        path = "src/Polttomoottoriauto.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Polttomoottoriauto")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Polttomoottoriauto.java tiedostosta ei löytynyt 'public class Polttomoottoriauto' -määritystä.");

        path = "src/Sahkoauto.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Sahkoauto")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Sahkoauto.java tiedostosta ei löytynyt 'public class Sahkoauto' -määritystä.");
    }

}