import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;


public class tests {


        private static final String TEST_FILE = "testfile.txt";

        @BeforeEach
        void setup() {
            // Poista testitiedosto, jos se on olemassa
            File file = new File(TEST_FILE);
            if (file.exists()) {
                file.delete();
            }
        }

        @AfterEach
        void cleanup() {
            // Poista testitiedosto, jos se on olemassa
            File file = new File(TEST_FILE);
            if (file.exists()) {
                file.delete();
            }
        }

        @Test
        void testWriteToFileAndReadFromFile() {
            String testContent = "Hello, JUnit!";
            FileUtils.WriteToFile(TEST_FILE, testContent);

            Thread readerThread = new Thread(() -> {
                // Wait for the writing to complete
                FileUtils.WaitForWriteCompletion();

                // Read and print the file content
                String fileContent = FileUtils.ReadFromFile(TEST_FILE);
                System.out.println("\nContent of the file: \n" + fileContent);
                assertEquals(testContent, fileContent, "File content should match written content.");
            });

        }

        @Test
        void testWriteAndReadEmptyFile() {
            String testContent = "";
            FileUtils.WriteToFile(TEST_FILE, testContent);

            // Odotetaan, että kirjoitus valmistuu
            FileUtils.WaitForWriteCompletion();

            // Luetaan tiedosto ja tarkistetaan sisältö
            String fileContent = FileUtils.ReadFromFile(TEST_FILE).trim();
            assertEquals(testContent, fileContent, "File content should be empty.");
        }

        @Test
        void testConcurrentWriteAndRead() {
            String testContent = "Concurrent Test";
            Thread writerThread = new Thread(() -> FileUtils.WriteToFile(TEST_FILE, testContent));
            Thread readerThread = new Thread(() -> {
                FileUtils.WaitForWriteCompletion();
                String fileContent = FileUtils.ReadFromFile(TEST_FILE).trim();
                assertEquals(testContent, fileContent, "File content should match written content in concurrent execution.");
            });

            writerThread.start();
            readerThread.start();

            try {
                writerThread.join();
                readerThread.join();
            } catch (InterruptedException e) {
                fail("Test interrupted: " + e.getMessage());
            }
        }

        @Test
        void testFileNotFound() {
            String nonExistentFile = "nonexistent.txt";
            String content = FileUtils.ReadFromFile(nonExistentFile);
            assertTrue(content.isEmpty(), "Reading a non-existent file should return an empty string.");
        }


    @Test
    public void test1() {
        String path = "src/FileUtils.java";  // Oletus, että tiedosto sijaitsee src-kansiossa
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String rivi;
            while ((rivi = br.readLine()) != null) {
                if (rivi.contains("public class FileUtils")) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            fail("Tiedoston lukeminen epäonnistui: " + e.getMessage());
        }

        assertTrue(found, "FileUtils.java tiedostosta ei löytynyt 'public class FileUtils' -määritystä.");

    }

}