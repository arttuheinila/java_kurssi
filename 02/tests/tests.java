
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class tests {

    @Test
    public void test1() {
        String input = "5\n4\n#\nK\n"; // Simulate user input for height, width, character, and fill choice
        String expectedOutput =
                "####\n" +
                        "####\n" +
                        "####\n" +
                        "####\n" +
                        "####\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in); // Redirect System.in to our simulated input
        System.setOut(new PrintStream(out)); // Redirect System.out to capture output

        my_code.main(new String[0]); // Run the main method

        // Normalize line endings and compare outputs
        String actualOutput = out.toString().replace("\r\n", "\n").trim();

        assertTrue(actualOutput.contains(expectedOutput.trim()), "The output should contain the correct square shape.");
    }

    @Test
    public void test2() {
        String input = "5\n4\n#\nE\n"; // Simulate user input for height, width, character, and fill choice
        String expectedOutput =
                "####\n" +
                        "#  #\n" +
                        "#  #\n" +
                        "#  #\n" +
                        "####\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in); // Redirect System.in to our simulated input
        System.setOut(new PrintStream(out)); // Redirect System.out to capture output

        my_code.main(new String[0]); // Run the main method

        // Normalize line endings and compare outputs
        String actualOutput = out.toString().replace("\r\n", "\n").trim();
        assertTrue(actualOutput.contains(expectedOutput.trim()), "The output should contain the correct square shape.");
    }
}