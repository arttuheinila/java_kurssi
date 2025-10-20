import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
    private static final Object lock = new Object();
    private static boolean writeCompleted = false;

    public static void WriteToFile(String fileName, String content) {
        Thread writerThread = new Thread(() -> {
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write(content);
                System.out.println("Data written to file: " + fileName);
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }

            //Ilmoitetaan että kirjoitus on valmis
            synchronized (lock) {
                writeCompleted = true;
                lock.notifyAll();
            }
        });

        writerThread.start();
    }

    public static void WaitForWriteCompletion() {
        synchronized (lock) {
            while (!writeCompleted) {
                try {
                    lock.wait(); //Odota notifyAll() kutsua
                } catch (InterruptedException e) {
                    System.err.println("Waiting interrupted: " + e.getMessage());
                }
            }
        }
    }

    public static String ReadFromFile(String fileName) {
        WaitForWriteCompletion();

        try {
            return Files.readString(Paths.get(fileName));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return "";
        }
    }
}
