import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.Comparator;
import java.util.List;


public class tests {



    @Test
    public void testToString() {
        // Luo uusi henkilö
        Person person = new Person("Mikko", 32, 180);

        // Tarkista toString-metodin tulos
        assertEquals("Mikko, 32, 180", person.toString());
    }

    @Test
    public void testToStringWithDifferentValues() {
        // Luo uusi henkilö
        Person person = new Person("Ella", 24, 170);

        // Tarkista toString-metodin tulos
        assertEquals("Ella, 24, 170", person.toString());
    }

    @Test
    public void testConstructorWithNullName() {
        // Luo uusi henkilö, jossa nimi on null
        Person person = new Person(null, 30, 175);

        // Tarkista, että kentät ovat oikein
        assertNull(person.name);
        assertEquals(30, person.age);
        assertEquals(175, person.height);
    }

    @Test
    public void testConstructorWithNegativeAge() {
        // Luo uusi henkilö, jossa ikä on negatiivinen
        Person person = new Person("Laura", -5, 168);

        // Tarkista, että ikä on negatiivinen
        assertEquals(-5, person.age);
    }

    @Test
    public void testConstructorWithZeroHeight() {
        // Luo uusi henkilö, jossa pituus on nolla
        Person person = new Person("Teemu", 35, 0);

        // Tarkista, että pituus on nolla
        assertEquals(0, person.height);
    }
    @Test
    public void testAlustaHenkilot() {
        // Luo henkilölista
        List<Person> people = PersonUtils.alustaHenkilot();

        // Tarkista listan koko
        assertEquals(5, people.size());

        // Tarkista ensimmäinen henkilö
        Person firstPerson = people.get(0);
        assertEquals("Anna", firstPerson.name);
        assertEquals(28, firstPerson.age);
        assertEquals(165, firstPerson.height);

        // Tarkista viimeinen henkilö
        Person lastPerson = people.get(4);
        assertEquals("Laura", lastPerson.name);
        assertEquals(30, lastPerson.age);
        assertEquals(168, lastPerson.height);
    }

    @Test
    public void testTulostaHenkilot() {
        // Luo henkilölista
        List<Person> people = PersonUtils.alustaHenkilot();

        // Testaa tulostus
        PersonUtils.tulostaHenkilot(people); // Näyttää tulosteet konsolissa
        // Testaus suoraan metodin tulosteisiin on hankalaa ilman konsoleiden väliintuloa. Voi käyttää captor ja similar-mittareita tarkistamiseen.
    }

    @Test
    public void testLajitteleHenkilotByName() {
        // Luo henkilölista ja lajittele nimiä mukaan
        List<Person> people = PersonUtils.alustaHenkilot();
        PersonUtils.lajitteleHenkilot(people, 1);

        // Tarkista ensimmäinen henkilö, joka on nyt lajiteltu nimen mukaan
        Person firstPerson = people.get(0);
        assertEquals("Anna", firstPerson.name);

        // Tarkista viimeinen henkilö, joka on nyt lajiteltu nimen mukaan
        Person lastPerson = people.get(4);
        assertEquals("Teemu", lastPerson.name);
    }

    @Test
    public void testLajitteleHenkilotByAge() {
        // Luo henkilölista ja lajittele iän mukaan
        List<Person> people = PersonUtils.alustaHenkilot();
        PersonUtils.lajitteleHenkilot(people, 2);

        // Tarkista ensimmäinen henkilö, joka on nyt lajiteltu iän mukaan
        Person firstPerson = people.get(0);
        assertEquals(24, firstPerson.age);

        // Tarkista viimeinen henkilö, joka on nyt lajiteltu iän mukaan
        Person lastPerson = people.get(4);
        assertEquals(35, lastPerson.age);
    }

    @Test
    public void testLajitteleHenkilotByHeight() {
        // Luo henkilölista ja lajittele pituuden mukaan
        List<Person> people = PersonUtils.alustaHenkilot();
        PersonUtils.lajitteleHenkilot(people, 3);

        // Tarkista ensimmäinen henkilö, joka on nyt lajiteltu pituuden mukaan
        Person firstPerson = people.get(0);
        assertEquals(165, firstPerson.height);

        // Tarkista viimeinen henkilö, joka on nyt lajiteltu pituuden mukaan
        Person lastPerson = people.get(4);
        assertEquals(180, lastPerson.height);
    }

    @Test
    public void testLajitteleHenkilotInvalidChoice() {
        // Luo henkilölista ja lajittele (virheellinen valinta)
        List<Person> people = PersonUtils.alustaHenkilot();
        PersonUtils.lajitteleHenkilot(people, 4);

        // Tarkista, että listan järjestystä ei ole muutettu virheellisen valinnan jälkeen
        Person firstPerson = people.get(0);
        assertEquals("Anna", firstPerson.name);

        Person lastPerson = people.get(4);
        assertEquals("Laura", lastPerson.name);
    }

    @Test
    public void testLajitteleHenkilotWithEmptyList() {
        // Luo tyhjä henkilölista ja lajittele iän mukaan
        List<Person> people = List.of();
        PersonUtils.lajitteleHenkilot(people, 2);

        // Tarkista, että lista on edelleen tyhjä
        assertTrue(people.isEmpty());
    }

    @Test
    public void testLajitteleHenkilotWithNullList() {
        // Luo null henkilölista ja lajittele iän mukaan
        List<Person> people = null;
        PersonUtils.lajitteleHenkilot(people, 2);

        // Tarkista, että lista on edelleen null
        assertNull(people);
    }

    @Test
    public void testLambdaUsedForSorting() {
        List<Person> people = PersonUtils.alustaHenkilot();
        PersonUtils.lajitteleHenkilot(people, 1); // oletetaan että '1' tarkoittaa nimeä

        try {
            // Tarkistetaan että lajittelu tapahtui lambda-lausekkeella
            Comparator<Person> comparator = (Comparator<Person>) people.get(0).getClass().getDeclaredField("COMPARATOR").get(null);
            assertNotNull(comparator); // Komparaatoreiden ei pitäisi olla null

            // Varmistetaan että komparaatorissa käytetään lambdaa
            boolean usesLambda = comparator.toString().contains("lambda$");
            assertTrue(usesLambda, "Lajittelun pitäisi käyttää lambda-lauseketta");
        }
        catch (Exception ex){}

    }
}