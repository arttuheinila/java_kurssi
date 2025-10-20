import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;


public class tests {

        @Test
        public void testMainOutput() throws InterruptedException {
            // Kaapataan standardilähtö
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream originalOut = System.out;
            System.setOut(new PrintStream(outputStream));

            try {
                // Suoritetaan main-metodi
                my_code.main(null);

                // Odotetaan riittävästi ajastimen toiminnan loppuun viemiseksi
                Thread.sleep(11000); // 10 sekuntia ohjelman ajastimelle + hieman lisäaikaa

                // Luetaan tuloste
                String output = outputStream.toString();

                // Tarkistetaan, että tuloste sisältää odotetut viestit
                for (int i = 1; i <= 10; i++) {
                    assertTrue(output.contains("Sekunti " + i + ": Aika kulkee..."),
                            "Tuloste puuttuu sekunnilta " + i);
                }
                assertTrue(output.contains("Ajastin päättyy."), "Loppuviesti puuttuu.");

            } finally {
                // Palautetaan alkuperäinen System.out
                System.setOut(originalOut);
            }
        }


}