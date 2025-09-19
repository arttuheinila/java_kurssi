

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class tests {

    private String adaptForLocale(String output) {
        char decimalSeparator = new DecimalFormatSymbols(Locale.getDefault()).getDecimalSeparator();

        return output.replace(',', decimalSeparator).replace('.', decimalSeparator);
    }

    @Test
    public void test1() {
        String input = "1000\n2000\n3000\n-1000\n";
        String expectedOutput =
                "Kokonaistulot ovat 6000.0\n" +
                        "Keskiarvoinen kuukausikohtainen tulo on 2000.0\n" +
                        "Suurin kuukausikohtainen tulo on 3000.0\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        my_code.main(new String[0]);

        String actualOutput = out.toString().replace("\r\n", "\n").trim();
        String adaptedExpectedOutput = adaptForLocale(expectedOutput).trim();
        String adaptedActualOutput = adaptForLocale(actualOutput);

        assertTrue(adaptedActualOutput.contains(adaptedExpectedOutput.trim()), "The output should contain the expected values.");
    }
    @Test
    public void test2() {
        String input = "1000\n2000\n3000\n-1000\n";
        String expectedOutput =
                "Anna kuukauden 0.\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));

        my_code.main(new String[0]);

        String actualOutput = out.toString().replace("\r\n", "\n").trim();
        String adaptedExpectedOutput = adaptForLocale(expectedOutput).trim();
        String adaptedActualOutput = adaptForLocale(actualOutput);

        assertTrue(!adaptedActualOutput.contains(adaptedExpectedOutput.trim()), "The output should contain NOT the expected values.");
    }

}