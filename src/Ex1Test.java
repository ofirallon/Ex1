import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */

public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v,11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v,2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v,v2);
        assertTrue(Ex1.equals(s10,s2));
    }

    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (String s :good) {
            boolean ok = Ex1.isNumber(s);
            assertTrue(ok);
        }
        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (String s : not_good) {
            boolean not_ok = Ex1.isNumber(s);
            assertFalse(not_ok, "Failed");
        }
    }
    @Test
    void int2NumberTest() {
        String base3 = Ex1.int2Number(10, 3); // should return "101b3"
        assertEquals(base3, "101b3");

        String base5 = Ex1.int2Number(25, 5); // should return "100b5"
        assertEquals(base5, "100b5");

        String base7 = Ex1.int2Number(49, 7); // should return "100b7"
        assertEquals(base7, "100b7");

        // Convert the number 255 to base 16
        String base16 = Ex1.int2Number(255, 16); // should return "FFbG"

        // Convert back to a decimal number
        int number = Ex1.number2Int(base16); // should return 255

        // Convert back to base 16
        String base16Again = Ex1.int2Number(number, 16); // should return "FFbG"

        // Checking whether the original string matches the re-received string

        assertEquals(base16, base16Again);
        assertTrue(Ex1.equals(base16, base16Again));

        String negativeNumber = Ex1.int2Number(-10, 2); // negative number
        assertEquals(negativeNumber, "");

        String invalidBaseLow = Ex1.int2Number(10, 1); // Base too low
        assertEquals(invalidBaseLow, "");

        String invalidBaseHigh = Ex1.int2Number(10, 17); // Base too high
        assertEquals(invalidBaseHigh, "");

        String binary = Ex1.int2Number(1, 2);
        assertEquals(binary, "1b2");

        String hex = Ex1.int2Number(15, 16);
        assertEquals(hex, "FbG");

        String invalidString = "10Xb2"; // Invalid 'X' character
        int result = Ex1.number2Int(invalidString);
        assertEquals(result, -1);

    }
    @Test
    void maxIndexTest() {
        // normal case: an array with valid numbers
        String[] arr1 = {"10b2", "200", "15bA"};
        int index1 = Ex1.maxIndex(arr1); // the maximum is 200 in base 10 (index 1)
        assertEquals(index1, 1);

        // case with null value
        String[] arr2 = {"10b2", null, "15bA", "7b3"};
        int index2 = Ex1.maxIndex(arr2); // the maximum is 15 in base 10 (index 2)
        assertEquals(index2, 2);

        // case with invalid values
        String[] arr3 = {"10b2", "abc", "15bA", "7b3"};
        int index3 = Ex1.maxIndex(arr3); // the maximum is 15 in base 10 (index 2)
        assertEquals(index3, 2);

        // case with all null values
        String[] arr4 = {null, null, null};
        int index4 = Ex1.maxIndex(arr4); // no valid values (should return -1)
        assertEquals(index4, -1);

        // case with an empty array
        String[] arr5 = {};
        int index5 = Ex1.maxIndex(arr5); // empty array (should return -1)
        assertEquals(index5, -1);

        // Case with negative numbers in different bases
        String[] arr6 = {"10", "20", "5"};
        int index6 = Ex1.maxIndex(arr6); // max index 1
        assertEquals(index6, 1);
    }

    @Test
    void equalsTest() {
        // normal case: two values are the same
        String n1 = "101b2"; // 5 in base 2
        String n2 = "5";  // 5 in base 10
        assertTrue(Ex1.equals(n1, n2)); // The values are equal

        // normal case: two values are not the same
        String n3 = "101b2"; // 5 in base 2
        String n4 = "6b10";  // 6 in base 10
        assertFalse(Ex1.equals(n3, n4)); // The values are not equal

        // case with null: one null value
        String n6 = "101b2";
        assertFalse(Ex1.equals(null, n6)); // one of the values is null

        // case with null: both values are null
        assertFalse(Ex1.equals(null, null)); // Both values are null


        // case with negative numbers
        String n11 = "-10b10"; // -10 in base 10
        String n12 = "-1010b2"; // -10 in base 2
        assertTrue(Ex1.equals(n11, n12)); // The values ars equal

        // case with empty values
        String n13 = "";
        String n14 = "0";
        assertFalse(Ex1.equals(n13, n14)); // one of the values is empty


}
    @Test
    void additionalTests() {
        // Base Conversion with Edge Cases
        String edgeBinary = Ex1.int2Number(0, 2); // Smallest valid binary number
        assertEquals(edgeBinary, "0b2");

        String largeBase16 = Ex1.int2Number(Integer.MAX_VALUE, 16); // Large positive value
        assertTrue(largeBase16.matches("[0-9A-F]+bG"));

        int minValue = Ex1.number2Int("0b2"); // Smallest valid input
        assertEquals(minValue, 0);

        // Validating Base Conversion
        String validBase16 = "FFbG"; // Hexadecimal value
        int decimalValue = Ex1.number2Int(validBase16);
        assertEquals(decimalValue, 255);

        String reconverted = Ex1.int2Number(decimalValue, 16); // Convert back to base 16
        assertEquals(validBase16, reconverted);

        // Invalid Base Conversion
        String invalidBaseString = "1Zb3"; // Invalid character 'Z' in base 3
        int invalidConversion = Ex1.number2Int(invalidBaseString);
        assertEquals(invalidConversion, -1);

        // Validation Tests
        String boundaryFormat = "AAbG";
        assertTrue(Ex1.isNumber(boundaryFormat));

        String nullString = null; // Null input
        assertFalse(Ex1.isNumber(nullString));

        // Edge Cases for maxIndex
        String[] mixedArray = {"1b2", "1bA", "1b16"};
    }
}