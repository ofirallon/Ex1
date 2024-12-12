/**
 *
 *  This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 *
 */

public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return decimal value of num -1 otherwise.
     */

    public static int number2Int(String num) {
        if (num == null || num.isEmpty()) // Check for empty or null input
            return -1;

        if (!num.contains("b")) { //Checking a specific case in which it will be accepted that there is no 'b' (if the number is already in decimal representation)
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (c < '0' || c > '9') // A character that is not a digit in the base 10 representation
                    return -1;
            }
            return Integer.parseInt(num); //Returns the string num as an integer
        }
        if (!isNumber(num)) // Checks if the num string is valid
            return -1; // If the string is invalid, return -1
        int indexB= num.indexOf('b');
        int base = Character.getNumericValue(num.charAt(indexB + 1)); //Converts the base representation that appears after the 'b' in the given value to a decimal number
        String numberPart = num.substring(0, indexB).toUpperCase(); //Extract the number part from the given string (everything that appears before the 'b') and convert it to uppercase letters (if there are letters)
        int result = 0;

        for (int i = 0; i < numberPart.length(); i++) {
            char currentChar = numberPart.charAt(i); // Access the current digit in the original order
            int digitValue = Character.getNumericValue(currentChar); // Convert to a numeric value
            int power = numberPart.length() - 1 - i; // Calculation of holding
            result += (int) (digitValue * Math.pow(base, power)); // Calculate the weight according to the holding
        }
        return result;
    }



    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */

    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty())
            return false;

        if (!a.contains("b")) { //Checking a specific case in which it will be accepted that there is no 'b' (if the number is already in decimal representation)
            for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                if (c < '0' || c > '9') {
                    return false; // If the character is not a digit (not in base 10 representation), the string is invalid
                }
            }
            return true; // Returns true if all characters are decimal digits (corresponding to base 10 representation)
        }

        if(a.contains(" "))
            return false;

        if(!a.equals(a.trim()))
            return false;

        // Checks for <number>b<base> format
        int indexB = a.indexOf('b');
        if (indexB == 0 || indexB == a.length() - 1) // If index b is the first or last character
            return false;

        String numberPart = a.substring(0, indexB); //Extract the number part from the given string (everything that appears before the 'b')
        if (!numberPart.equals(numberPart.toUpperCase()))
            return false;
        char baseChar = a.charAt(indexB + 1); // baseChar- This character represents the base of the number
        if (!((baseChar >= '2' && baseChar <= '9') || (baseChar >= 'A' && baseChar <= 'G'))) // If the base is invalid, false will be returned
            return false;

        int base = Character.getNumericValue(baseChar); //Convert the character of the base to an integer
        for (int i = 0; i < numberPart.length(); i++) {
            char c = numberPart.charAt(i); // current char
            int digitValue = Character.getNumericValue(c); // Convert a character to a numeric value
            if (digitValue < 0 || digitValue >= base) { // If the value is outside the base range, false will be returned because the string is invalid
                return false;
            }
        }
        return true;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16)// Validity check for input
            return "";
        StringBuilder result = new StringBuilder(); // A string to contain the result
        while (num > 0) {
            int remainder = num % base; // Calculate the remainder
            char digit;

            // המרת השארית לספרה או אות
            if (remainder < 10) {
                digit = (char) ('0' + remainder); // If the remainder is less than 10, convert to a decimal number ('0'-'9')
            } else {
                digit = (char) ('A' + (remainder - 10)); // if left 10 or more, convert to letter ('A'-'F')
            }

            result.insert(0, digit); // Adding the digit to the beginning of the string
            num /= base; // Update the number to proceed to calculate the next digit in the number in the new base
        }

        if (result.isEmpty()) {
            result = new StringBuilder("0"); // In the case of num=0, 0 will appear as the result
        }

        String baseString;
        if (base < 10) { // In case the base is less than 10
            baseString = String.valueOf(base); //the base number will be displayed as a string
        }
        else {
            baseString = String.valueOf((char) ('A' + (base - 10))); //This line measures the distance of the base from 10 and "adds" the distance to A to get the letter corresponding to the base
        }

        return result + "b" + baseString; // Adding "b<base>" to the final string
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        if (n1 == null || n2 == null) // In the case where one of the 2 (n1/n2) is an empty string
            return !ans;
        else
        if (number2Int(n1) == number2Int(n2))
            return ans;
        else
            return !ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */

    public static int maxIndex(String[] arr) {
        int IndexOfTheMaxValue = -1; //This value will hold the position of the largest number in the array
        int maxValue = -1; //This value will hold the value of the largest number in the array

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && isNumber(arr[i])) {
                int value = number2Int(arr[i]); //Setting the value to the value at position i
                if (value > maxValue) { //If the current value is greater than the maximum value found so far
                    maxValue = value; //The current value will be the maximum value
                    IndexOfTheMaxValue = i; //The position of the current value will be the position of the maximum value
                }
            }
        }
        return IndexOfTheMaxValue; //The index of the largest value will be returned
    }
}