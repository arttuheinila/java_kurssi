

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

class tests {

    private String adaptForLocale(String output) {
        char decimalSeparator = new DecimalFormatSymbols(Locale.getDefault()).getDecimalSeparator();

        return output.replace(',', decimalSeparator).replace('.', decimalSeparator);
    }

    @Test
    public void test1() {
        String input = "Nordea\n3\n3400\n"; // \n on tärkeä tässä, erottaa eri tyyppiset syötteet toisistaan

        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);

        PrintStream originalOut = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(baos);
        System.setOut(newOut);

        my_code.main(new String[0]);

        System.setOut(originalOut);

        String actualOutput = baos.toString().trim();

        String expectedOutput = "Anna osake:Anna osinkopros:Anna sijoitus:Osakkeen Nordea tuotto pääomalle 3400 on 102.00";

        String adaptedExpectedOutput = adaptForLocale(expectedOutput);
        String adaptedActualOutput = adaptForLocale(actualOutput);

        assertEquals(adaptedExpectedOutput, adaptedActualOutput);
    }
}