import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;


public class tests {


        @Test
        void testPrintDiamondOutput() {
            // Redirect System.out to capture output
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Create a PrintDiamond instance and test the print method
            PrintDiamond printer = new PrintDiamond();
            printer.print(1); // Pass a thread number to test

            // Expected diamond output
            String expectedOutput = System.lineSeparator() + "Säie nro 1 käynnistettiin:" + System.lineSeparator()
                    + "   *" + System.lineSeparator()
                    + "  ***" + System.lineSeparator()
                    + " *****" + System.lineSeparator()
                    + "*******" + System.lineSeparator()
                    + " *****" + System.lineSeparator()
                    + "  ***" + System.lineSeparator()
                    + "   *" + System.lineSeparator();

            // Verify the output matches the expected diamond
            assertEquals(expectedOutput.trim(), outputStream.toString().trim());

            // Reset System.out
            System.setOut(System.out);
        }

        @Test
        void testMultipleThreads() {
            // Redirect System.out to capture output
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // Create a PrintDiamond instance
            PrintDiamond printer = new PrintDiamond();

            // Create and start multiple threads
            int threadCount = 3;
            Thread[] threads = new Thread[threadCount];
            for (int i = 0; i < threadCount; i++) {
                threads[i] = new DiamondThread(printer, i + 1);
                threads[i].start();
            }

            // Wait for all threads to finish
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    fail("Thread interrupted unexpectedly.");
                }
            }

            // Check output contains multiple diamonds (non-deterministic order)
            String output = outputStream.toString();
            assertTrue(output.contains("Säie nro 1 käynnistettiin"));
            assertTrue(output.contains("Säie nro 2 käynnistettiin"));
            assertTrue(output.contains("Säie nro 3 käynnistettiin"));

            // Reset System.out
            System.setOut(System.out);
        }



    @Test
    public void test1() {
        String path = "src/DiamondThread.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class DiamondThread extends Thread")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "DiamondThread.java tiedostosta ei löytynyt 'public class DiamondThread extends Thread' -määritystä.");

        path = "src/PrintDiamond.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String rivi;
                while ((rivi = br.readLine()) != null) {
                    if (rivi.contains("public class PrintDiamond")) {
                        found = true;
                        break;
                    }
                }
        } catch (IOException e) {
                fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "PrintDiamond.java tiedostosta ei löytynyt 'public class PrintDiamond' -määritystä.");


    }

}