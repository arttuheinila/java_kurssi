import java.time.LocalDate;

public class Projektinhallinta {
    public static void main(String[] args) {
        Projektipaallikko paallikko1 = new Projektipaallikko("Minna Muikku", 38, 10);
        Ohjelmistoprojekti projekti1 = new Ohjelmistoprojekti(
                "Verkkosovellusprojekti", 200000.0, paallikko1,
                LocalDate.of(2024, 6, 1), LocalDate.of(2025, 6, 1),
                5, "Java, Spring Boot, React");

        System.out.println(projekti1);
        projekti1.suunnittele();
        projekti1.toteuta();

        System.out.println();

        Projektipaallikko paallikko2 = new Projektipaallikko("Sakari Silakka", 45, 20);
        Rakennusprojekti projekti2 = new Rakennusprojekti(
                "Talon perustukset", 500000.0, paallikko2,
                LocalDate.of(2024, 5, 1), LocalDate.of(2025, 5, 1),
                "Helsinki");

        System.out.println(projekti2);
        projekti2.suunnittele();
        projekti2.toteuta();
        
        }
}
