import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class tests {



    @BeforeEach
    public void setUp() {

    }

    @Test
    public void test1() {
        String path = "src/MathUtils.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class MathUtils")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "MathUtils.java tiedostosta ei löytynyt 'public class Opiskelija' -määritystä.");


    }

    @Test
    public void testLaskeYhteenWithNormalList() {
        ArrayList<Double> luvut = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
        double result = MathUtils.LaskeYhteen(luvut);
        assertEquals(15.0, result, 0.0001);
    }

    @Test
    public void testLaskeYhteenWithEmptyList() {
        ArrayList<Double> luvut = new ArrayList<>();
        double result = MathUtils.LaskeYhteen(luvut);
        assertEquals(0.0, result, 0.0001);
    }

    @Test
    public void testLaskeYhteenWithNullList() {
        double result = MathUtils.LaskeYhteen(null);
        assertEquals(0.0, result, 0.0001);
    }

    @Test
    public void testSuurinLukuWithNormalList() {
        ArrayList<Double> luvut = new ArrayList<>(Arrays.asList(-2.0, 3.5, 7.1, 4.4, 6.0));
        double result = MathUtils.SuurinLuku(luvut);
        assertEquals(7.1, result, 0.0001);
    }

    @Test
    public void testSuurinLukuWithEmptyList() {
        ArrayList<Double> luvut = new ArrayList<>();
        double result = MathUtils.SuurinLuku(luvut);
        assertEquals(Double.MIN_VALUE, result, 0.0001);
    }

    @Test
    public void testSuurinLukuWithNullList() {
        double result = MathUtils.SuurinLuku(null);
        assertEquals(Double.MIN_VALUE, result, 0.0001);
    }

    @Test
    public void testLaskeKeskiarvoWithNormalList() {
        ArrayList<Double> luvut = new ArrayList<>(Arrays.asList(2.0, 4.0, 6.0, 8.0, 10.0));
        double result = MathUtils.LaskeKeskiarvo(luvut);
        assertEquals(6.0, result, 0.0001);
    }

    @Test
    public void testLaskeKeskiarvoWithEmptyList() {
        ArrayList<Double> luvut = new ArrayList<>();
        double result = MathUtils.LaskeKeskiarvo(luvut);
        assertEquals(0.0, result, 0.0001);
    }

    @Test
    public void testLaskeKeskiarvoWithNullList() {
        double result = MathUtils.LaskeKeskiarvo(null);
        assertEquals(0.0, result, 0.0001);
    }


}