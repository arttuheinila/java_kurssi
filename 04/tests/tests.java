

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

class tests {
    @Test
    public void testArvoLottoriviPituus() {
        int[] veikkauksenrivi = my_code.arvoLottorivi();
        assertEquals(7, veikkauksenrivi.length, "Lottorivin pituuden tulee olla 7.");
    }

    @Test
    public void testArvoLottoriviVali() {
        int[] veikkauksenrivi = my_code.arvoLottorivi();
        for (int numero : veikkauksenrivi) {
            assertTrue(numero >= 1 && numero <= 40, "Numeron tulee olla välillä 1–40.");
        }
    }
    @Test
    public void testArvoLottoriviUniikitNumerot() {
        int[] veikkauksenrivi = my_code.arvoLottorivi();
        Set<Integer> numerot = new HashSet<>();
        for (int numero : veikkauksenrivi) {
            numerot.add(numero);
        }
        assertEquals(7, numerot.size(), "Lottorivin kaikkien numeroiden tulee olla uniikkeja.");
    }
    @Test
    public void testTulostaRiviMuoto() {
        // Alustetaan testirivi
        int[] veikkauksenrivi = {36, 23, 7, 4, 28, 6, 22};

        // Kaapataan System.out-tuloste
        ByteArrayOutputStream tuloste = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tuloste));

        // Kutsutaan tulostaRivi-metodia
        my_code.tulostaRivi(veikkauksenrivi);

        // Palautetaan System.out normaaliksi
        System.setOut(System.out);

        // Muodostetaan odotettu tuloste
        String odotettuTuloste = "[36, 23, 7, 4, 28, 6, 22]" + System.lineSeparator();

        // Testataan, että tuloste vastaa odotettua
        assertEquals(odotettuTuloste, tuloste.toString(), "Tulostusmuoto ei ole oikein.");
    }
    @Test
    public void testMain() {
        String input = "k" + System.lineSeparator() + "e" + System.lineSeparator(); // \n on tärkeä tässä, erottaa eri tyyppiset syötteet toisistaan

        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);

        PrintStream originalOut = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(baos);
        System.setOut(newOut);

        my_code.main(new String[0]);

        System.setOut(originalOut);

        String actualOutput = baos.toString().trim();


        String expectedOutput = "Veikkauksen lottorivi on:";
        assertTrue(actualOutput.contains(expectedOutput), "Tulosteen pitäisi sisältää haluttu merkkijono");

        expectedOutput = "Haluatko arpoa rivin (k= kyllä, e = ei)?";
        assertTrue(actualOutput.contains(expectedOutput), "Tulosteen pitäisi sisältää haluttu merkkijono");

        expectedOutput = "Ohjelma arpoi sinulle rivin:";
        assertTrue(actualOutput.contains(expectedOutput), "Tulosteen pitäisi sisältää haluttu merkkijono");

        expectedOutput = "kpl, jotka olivat [";
        assertTrue(actualOutput.contains(expectedOutput), "Tulosteen pitäisi sisältää haluttu merkkijono");

    }
    @Test
    public void testTsekkaaOsumatKaikkiOsumat() {
        int[] veikkauksenrivi = {1, 2, 3, 4, 5, 6, 7};
        int[] asiakasrivi = {1, 2, 3, 4, 5, 6, 7};

        ArrayList<Integer> odotetutOsumat = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        ArrayList<Integer> osumat = my_code.tsekkaaOsumat(veikkauksenrivi, asiakasrivi);

        assertEquals(odotetutOsumat, osumat, "Kaikkien numeroiden pitäisi osua.");
    }

    @Test
    public void testTsekkaaOsumatEiOsumia() {
        int[] veikkauksenrivi = {1, 2, 3, 4, 5, 6, 7};
        int[] asiakasrivi = {8, 9, 10, 11, 12, 13, 14};

        ArrayList<Integer> odotetutOsumat = new ArrayList<>();
        ArrayList<Integer> osumat = my_code.tsekkaaOsumat(veikkauksenrivi, asiakasrivi);

        assertEquals(odotetutOsumat, osumat, "Ei pitäisi olla osumia.");
    }

    @Test
    public void testTsekkaaOsumatOsittaisetOsumat() {
        int[] veikkauksenrivi = {1, 2, 3, 4, 5, 6, 7};
        int[] asiakasrivi = {3, 4, 8, 9, 10, 11, 12};

        ArrayList<Integer> odotetutOsumat = new ArrayList<>(Arrays.asList(3, 4));
        ArrayList<Integer> osumat = my_code.tsekkaaOsumat(veikkauksenrivi, asiakasrivi);

        assertEquals(odotetutOsumat, osumat, "Pitäisi olla osumia vain 3 ja 4.");
    }

    @Test
    public void testTulostaOsumatEiOsumia() {
        ArrayList<Integer> osumat = new ArrayList<>();

        // Kaapataan System.out-tuloste
        ByteArrayOutputStream tuloste = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tuloste));

        // Kutsutaan tulostaOsumat-metodia
        my_code.tulostaOsumat(osumat);

        // Palautetaan System.out normaaliksi
        System.setOut(System.out);

        // Tarkistetaan tulosteen sisältö
        String odotettuTuloste = "Oikein oli 0 kpl, jotka olivat []"+ System.lineSeparator();
        assertEquals(odotettuTuloste, tuloste.toString(), "Tulosteen pitäisi näyttää tyhjälle listalle.");
    }

    @Test
    public void testTulostaOsumatMuutamaOsuma() {
        ArrayList<Integer> osumat = new ArrayList<>(Arrays.asList(3, 5, 7));

        // Kaapataan System.out-tuloste
        ByteArrayOutputStream tuloste = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tuloste));

        // Kutsutaan tulostaOsumat-metodia
        my_code.tulostaOsumat(osumat);

        // Palautetaan System.out normaaliksi
        System.setOut(System.out);

        // Tarkistetaan tulosteen sisältö
        String odotettuTuloste = "Oikein oli 3 kpl, jotka olivat [3, 5, 7]"+ System.lineSeparator();
        assertEquals(odotettuTuloste, tuloste.toString(), "Tulosteen pitäisi näyttää 3, 5 ja 7 osumina.");
    }

    @Test
    public void testTulostaOsumatKaikkiOsumat() {
        ArrayList<Integer> osumat = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        // Kaapataan System.out-tuloste
        ByteArrayOutputStream tuloste = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tuloste));

        // Kutsutaan tulostaOsumat-metodia
        my_code.tulostaOsumat(osumat);

        // Palautetaan System.out normaaliksi
        System.setOut(System.out);

        // Tarkistetaan tulosteen sisältö
        String odotettuTuloste = "Oikein oli 7 kpl, jotka olivat [1, 2, 3, 4, 5, 6, 7]" + System.lineSeparator();
        assertEquals(odotettuTuloste, tuloste.toString(), "Tulosteen pitäisi näyttää kaikki 7 osumaa.");
    }

}
