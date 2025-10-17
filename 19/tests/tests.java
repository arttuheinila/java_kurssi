import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;


    public class tests {

        @Test
        public void testLuottokorttiMaksuAlimaarin() {
            Maksutapa maksutapa = new Luottokortti("1234567890123456", "12/25");
            assertTrue(maksutapa.maksa(4000.0), "Maksu pitäisi hyväksyä, koska summa on alle maksurajan.");
        }

        @Test
        public void testLuottokorttiMaksuYlimaarin() {
            Maksutapa maksutapa = new Luottokortti("testi@esimerkki.com", "salasana123");
            assertFalse(maksutapa.maksa(6000.0), "Maksua ei pitäisi hyväksyä, koska summa on yli maksurajan.");
        }

        @Test
        public void testPayPalMaksuAlimaarin() {
            Maksutapa maksutapa = new PayPal("testi@esimerkki.com", "salasana123");
            assertTrue(maksutapa.maksa(3000.0), "Maksu pitäisi hyväksyä, koska summa on alle maksurajan.");
        }

        @Test
        public void testPayPalMaksuYlimaarin() {
            Maksutapa maksutapa = new PayPal("testi@esimerkki.com", "salasana123");
            assertFalse(maksutapa.maksa(6000.0), "Maksua ei pitäisi hyväksyä, koska summa on yli maksurajan.");
        }

        @Test
        public void testPankkisiirtoMaksuAlimaarin() {
            Maksutapa maksutapa = new Pankkisiirto("FI1234567890123456", "Esimerkkipankki");
            assertTrue(maksutapa.maksa(4000.0), "Maksu pitäisi hyväksyä, koska summa on alle maksurajan.");
        }

        @Test
        public void testPankkisiirtoMaksuYlimaarin() {
            Maksutapa maksutapa = new Pankkisiirto("FI1234567890123456", "Esimerkkipankki");
            assertFalse(maksutapa.maksa(6000.0), "Maksua ei pitäisi hyväksyä, koska summa on yli maksurajan.");
        }


            @Test
            void testMaksuOnnistuuLuottokortilla() {
                String lineSeparator = System.lineSeparator();
                // Simuloidaan käyttäjän syöte
                String simulatedInput = "1" + lineSeparator+ "3000" + lineSeparator; // 1 = Luottokortti, summa 3000
                System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

                // Simuloidaan ohjelman tulosteen ohjaaminen toiseen virtaan
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outputStream));

                // Suoritetaan pääohjelma
                my_code.main(new String[]{});

                // Varmistetaan, että ohjelma tuotti odotetun tulosteen
                String apu = String.format("%.1f€", 3000.0);
                String expectedOutput = "Valitse maksutapa:" + lineSeparator +
                        "1. Luottokortti" + lineSeparator +
                        "2. PayPal" + lineSeparator +
                        "3. Pankkisiirto" + lineSeparator +
                        "Syötä maksettava summa:" + lineSeparator +
                        "Maksu luottokortilla onnistui: " + apu  + lineSeparator;
                assertEquals(expectedOutput, outputStream.toString());
            }

            @Test
            void testMaksuLiianSuurellaSummalla() {
                String lineSeparator = System.lineSeparator();
                // Simuloidaan käyttäjän syöte
                String simulatedInput = "1" + lineSeparator + "6000" + lineSeparator; // 1 = Luottokortti, summa 6000 (ylittää maksurajan)
                System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

                // Simuloidaan ohjelman tulosteen ohjaaminen toiseen virtaan
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outputStream));

                // Suoritetaan pääohjelma
                my_code.main(new String[]{});

                // Varmistetaan, että ohjelma tuotti odotetun virheilmoituksen
                String expectedOutput = "Valitse maksutapa:" + lineSeparator +
                        "1. Luottokortti" + lineSeparator +
                        "2. PayPal" + lineSeparator +
                        "3. Pankkisiirto" + lineSeparator +
                        "Syötä maksettava summa:" + lineSeparator +
                        "Maksu luottokortilla epäonnistui, maksurajan ylitys" + lineSeparator;
                assertEquals(expectedOutput, outputStream.toString());
            }

            @Test
            void testMaksuValintaVirheellinen() {
                String lineSeparator = System.lineSeparator();
                // Simuloidaan käyttäjän syöte
                String simulatedInput = "10" + lineSeparator  + "3000" + lineSeparator; // Virheellinen valinta
                System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

                // Simuloidaan ohjelman tulosteen ohjaaminen toiseen virtaan
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outputStream));

                // Suoritetaan pääohjelma
                my_code.main(new String[]{});

                // Varmistetaan, että ohjelma tuotti virheilmoituksen virheellisestä valinnasta
                String expectedOutput = "Valitse maksutapa:" + lineSeparator +
                        "1. Luottokortti" + lineSeparator +
                        "2. PayPal" + lineSeparator +
                        "3. Pankkisiirto" + lineSeparator +
                        "Syötä maksettava summa:" + lineSeparator +
                        "Virheellinen valinta" + lineSeparator;
                assertEquals(expectedOutput, outputStream.toString());
            }



    @Test
    public void test1() {
        String path = "src/Maksutapa.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public interface Maksutapa")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Maskutapa.java tiedostosta ei löytynyt 'public interface Maksutapa' -määritystä.");


        path = "src/Luottokortti.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Luottokortti implements Maksutapa")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Luottokortti.java tiedostosta ei löytynyt 'public class Luottokortti implements Maksutapa' -määritystä.");

        path = "src/PayPal.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class PayPal implements Maksutapa")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "PayPal.java tiedostosta ei löytynyt 'public class PayPal implements Maksutapa' -määritystä.");


        path = "src/Pankkisiirto.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class Pankkisiirto implements Maksutapa")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "Pankkisiirto.java tiedostosta ei löytynyt 'public class Pankkisiirto implements Maksutapa' -määritystä.");

    }

}