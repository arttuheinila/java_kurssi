import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonUtils {
    public static List<Person> alustaHenkilot() {
        List<Person> people = new ArrayList<>();
        
        people.add(new Person("Anna", 28, 165));
        people.add(new Person("Mikko", 32, 180));
        people.add(new Person("Teemu", 35, 175));
        people.add(new Person("Ella", 24, 170));
        people.add(new Person("Laura", 30, 168));
        return people;
    }

    // Lajittelee listan annetun valinnan perusteella
    public static void lajitteleHenkilot(List<Person> people, int choice) {
        if (people == null || people.isEmpty()) {
            return;
        }
        switch (choice) {
            case 1 -> people.sort(Comparator.comparing(person -> person.name));  // Nimen mukaan
            case 2 -> people.sort(Comparator.comparingInt(person -> person.age)); // Iän mukaan
            case 3 -> people.sort(Comparator.comparingInt(person -> person.height)); // Pituuden mukaan
            default -> System.out.println("Virheellinen valinta, ei lajitella.");
        }
    }

    // Tulostaa kaikki henkilöt allekkain
    public static void tulostaHenkilot(List<Person> people) {
        for (Person p : people) {
            System.out.println(p);
        }
    }
}        
