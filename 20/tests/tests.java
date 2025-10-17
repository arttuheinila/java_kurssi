import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;


public class tests {
    private BroadcomSpeaker bspeaker;
    private BroadcomMic bmic;
    private SamsungMic smic;
    private QualcommSpeaker qspeaker;

    @BeforeEach
    void setUp() {
        qspeaker = new QualcommSpeaker();
        smic = new SamsungMic();

        bmic = new BroadcomMic(); // Luodaan uusi BroadcomMic-olio ennen jokaista testiä
        bspeaker = new BroadcomSpeaker(); // Alustetaan BroadcomSpeaker ennen jokaista testiä
    }

    @Test
    void testMainMethod() {
        // Tallennetaan konsolin tulostus, jotta voimme tarkistaa sen myöhemmin
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        // Kutsutaan main-metodia
        String[] args = {}; // Tyhjä argumentti taulukko, koska main ei käytä sitä
        my_code.main(args);

        // Verifioidaan, että oikeat tulosteet tulostuvat konsoliin
        String output = baos.toString();

        // Testataan, että tulosteet ovat odotettuja
        assertTrue(output.contains("Jos kaiuttimen äänenvoimakkuus on 10, niin ekan puhelimen kaiutin voitiin laittaa päälle"));
        assertTrue(output.contains("Jos kaiuttimen äänenvoimakkuus on 200, niin ekan puhelimen kaiutinta ei voida laittaa päälle"));
        assertTrue(output.contains("Jos mikin äänenvoimakkuus on 45, niin ekan puhelimen mikki voitiin laittaa päälle"));
        assertTrue(output.contains("Jos mikin äänenvoimakkuus on 70, niin ekan puhelimen mikkiä ei voida laittaa päälle"));
        assertTrue(output.contains("Jos kaiuttimen äänenvoimakkuus on 88, niin tokan puhelimen kaiutin voitiin laittaa päälle"));
        assertTrue(output.contains("Jos kaiuttimen äänenvoimakkuus on 102, niin tokan puhelimen kaiutinta ei voida laittaa päälle"));
        assertTrue(output.contains("Jos mikin äänenvoimakkuus on 99, niin tokan puhelimen mikki voitiin laittaa päälle"));
        assertTrue(output.contains("Jos mikin äänenvoimakkuus on 101, niin tokan puhelimen mikkiä ei voida laittaa päälle"));

        // Varmistetaan, että tulostus ei ole tyhjä
        assertFalse(output.isEmpty());

        // Palautetaan alkuperäinen konsolin tulostus
        System.setOut(System.out);
    }
    @Test
    void testSamsungMicMicOnWithValidVolume() {
        smic.setVolume(30); // Asetetaan sallittu äänenvoimakkuus
        assertTrue(smic.micOn(), "micOn-metodin tulisi palauttaa true, kun äänenvoimakkuus on 30.");
    }

    @Test
    void testSamsungMicMicOnWithExcessiveVolume() {
        smic.setVolume(60); // Asetetaan liian korkea äänenvoimakkuus
        assertFalse(smic.micOn(), "micOn-metodin tulisi palauttaa false, kun äänenvoimakkuus ylittää 50.");
    }

    @Test
    void testSamsungMicMicOff() {
        smic.setVolume(40); // Asetetaan sallittu äänenvoimakkuus
        smic.micOn(); // Kytketään mikrofoni päälle
        assertTrue(smic.micOff(), "micOff-metodin tulisi aina palauttaa true.");
        assertFalse(smic.isOn, "isOn-tilan tulisi olla false micOff-kutsun jälkeen.");
    }

    @Test
    void testSamsungMicVolumeSetting() {
        smic.setVolume(45); // Asetetaan äänenvoimakkuus
        assertEquals(45, smic.getVolume(), "getVolume-metodin tulisi palauttaa asetettu arvo 45.");

        smic.setVolume(0); // Asetetaan äänenvoimakkuudeksi 0
        assertEquals(0, smic.getVolume(), "getVolume-metodin tulisi palauttaa asetettu arvo 0.");
    }

    @Test
    void testMicOnAfterVolumeChange() {
        smic.setVolume(30); // Asetetaan sallittu äänenvoimakkuus
        assertTrue(smic.micOn(), "micOn-metodin tulisi palauttaa true, kun äänenvoimakkuus on sallittu.");

        smic.setVolume(65); // Muutetaan äänenvoimakkuus liian suureksi
        assertFalse(smic.micOn(), "micOn-metodin tulisi palauttaa false, kun äänenvoimakkuus ylittää 50.");
    }
    @Test
    void testQualcommSpeakerUnMuteWithValidVolume() {
        qspeaker.setVolume(50); // Asetetaan äänenvoimakkuudeksi sallittu arvo
        qspeaker.mute(); // Mykistetään aluksi
        assertTrue(qspeaker.unMute(), "unMute-metodin tulisi palauttaa true, kun äänenvoimakkuus on 50.");

    }

    @Test
    void testQualcommSpeakerUnMuteWithExcessiveVolume() {
        qspeaker.setVolume(85); // Asetetaan äänenvoimakkuudeksi yli 80
        assertFalse(qspeaker.unMute(), "unMute-metodin tulisi palauttaa false, kun äänenvoimakkuus ylittää 80.");
    }

    @Test
    void testMQualcommSpeakeruteFunctionality() {
        qspeaker.setVolume(60); // Asetetaan sallittu äänenvoimakkuus
        qspeaker.mute(); // Mykistetään kaiutin

    }

    @Test
    void testQualcommSpeakerVolumeSetting() {
        qspeaker.setVolume(75);
        assertEquals(75, qspeaker.getVolume(), "getVolume-metodin tulisi palauttaa 75.");

        qspeaker.setVolume(0);
        assertEquals(0, qspeaker.getVolume(), "getVolume-metodin tulisi palauttaa 0.");
    }

    @Test
    void testQualcommSpeakerUnMuteWhenAlreadyUnmuted() {
        qspeaker.setVolume(60); // Asetetaan sallittu äänenvoimakkuus
        qspeaker.unMute(); // Poistetaan mykistys
        assertTrue(qspeaker.unMute(), "unMute-metodin tulisi palauttaa true, kun kaiutin ei ole mykistetty.");

    }


    @Test
    void testUnMuteWithValidVolume() {
        bspeaker.setVolume(50); // Asetetaan äänenvoimakkuudeksi sallittu arvo
        bspeaker.mute(); // Mykistetään aluksi
        assertTrue(bspeaker.unMute(), "unMute-metodin tulisi palauttaa true, kun äänenvoimakkuus on 50.");
    }

    @Test
    void testUnMuteWithExcessiveVolume() {
        bspeaker.setVolume(120); // Asetetaan äänenvoimakkuudeksi yli sallitun rajan
        assertFalse(bspeaker.unMute(), "unMute-metodin tulisi palauttaa false, kun äänenvoimakkuus ylittää 100.");
    }

    @Test
    void testMuteFunctionality() {
        bspeaker.setVolume(80); // Asetetaan sallittu äänenvoimakkuus
        bspeaker.mute(); // Mykistetään kaiutin
    }

    @Test
    void testVolumeSetting() {
        bspeaker.setVolume(75);
        assertEquals(75, bspeaker.getVolume(), "getVolume-metodin tulisi palauttaa 75.");

        bspeaker.setVolume(0);
        assertEquals(0, bspeaker.getVolume(), "getVolume-metodin tulisi palauttaa 0.");
    }

    @Test
    void testUnMuteWhenAlreadyUnmuted() {
        bspeaker.setVolume(60); // Asetetaan sallittu äänenvoimakkuus
        bspeaker.unMute(); // Poistetaan mykistys
        assertTrue(bspeaker.unMute(), "unMute-metodin tulisi palauttaa true, kun kaiutin ei ole mykistetty.");
    }



        @Test
        void testMicOnWithValidVolume() {
            bmic.setVolume(50); // Asetetaan äänenvoimakkuudeksi sallittu arvo
            assertTrue(bmic.micOn(), "Mikrofonin tulisi kytkeytyä päälle, kun äänenvoimakkuus on 50.");
        }

        @Test
        void testMicOnWithExcessiveVolume() {
            bmic.setVolume(120); // Asetetaan äänenvoimakkuudeksi yli sallitun rajan
            assertFalse(bmic.micOn(), "Mikrofonin ei tulisi kytkeytyä päälle, kun äänenvoimakkuus on yli 100.");
        }

        @Test
        void testMicOff() {
            bmic.micOn(); // Kytketään mikrofoni päälle
            assertTrue(bmic.micOff(), "micOff-metodin tulisi palauttaa aina true.");
            assertFalse(bmic.isOn, "Mikrofonin tilan tulisi olla false micOff-metodin jälkeen.");
        }

        @Test
        void testSetAndGetVolume() {
            bmic.setVolume(80);
            assertEquals(80, bmic.getVolume(), "getVolume-metodin tulisi palauttaa asetettu äänenvoimakkuus (80).");

            bmic.setVolume(0);
            assertEquals(0, bmic.getVolume(), "getVolume-metodin tulisi palauttaa asetettu äänenvoimakkuus (0).");

            bmic.setVolume(-10); // Testataan negatiivinen arvo
            assertEquals(-10, bmic.getVolume(), "BaseMic sallii negatiiviset äänenvoimakkuudet, ja niiden tulisi palautua oikein.");
        }





        @Test
    public void test1() {
        String path = "src/ITelephoneMic.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public interface ITelephoneMic")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "ITelephoneMic.java tiedostosta ei löytynyt 'public interface ITelephoneMic' -määritystä.");

        path = "src/ITelephoneSpeaker.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String rivi;
                while ((rivi = br.readLine()) != null) {
                    if (rivi.contains("public interface ITelephoneSpeaker")) {
                        found = true;
                        break;
                    }
                }
        } catch (IOException e) {
                fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "ITelephoneSpeaker.java tiedostosta ei löytynyt 'public interface ITelephoneSpeaker' -määritystä.");

        path = "src/BaseMic.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public abstract class BaseMic implements ITelephoneMic")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "BaseMic.java tiedostosta ei löytynyt 'ppublic abstract class BaseMic implements ITelephoneMic' -määritystä.");

        path = "src/BroadcomMic.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class BroadcomMic extends BaseMic")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "BroadcomMic.java tiedostosta ei löytynyt 'public class BroadcomMic extends BaseMic' -määritystä.");


        path = "src/BaseSpeaker.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public abstract class BaseSpeaker implements ITelephoneSpeaker")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "BaseSpeaker.java tiedostosta ei löytynyt 'public abstract class BaseSpeaker implements ITelephoneSpeaker' -määritystä.");

    }

}