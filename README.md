# README for Ex1 - Number Formatting Converter and Calculator

## Overview
This project implements a number formatting converter and calculator for numeric strings based on custom formats defined in the range of bases [2-16]. The functionality allows for conversion between bases, validation of custom numeric formats, and basic operations such as equality checks and finding the maximum value from a collection of numbers.

The implementation consists of the `Ex1` class with multiple static methods and corresponding unit tests provided in `Ex1Test`.

---

## Features and Functionality
1. **Base Conversion**:
    - Convert custom-formatted numbers to decimal integers.
    - Convert decimal integers to custom-formatted strings in a specified base.

2. **Validation**:
    - Check whether a given string adheres to the custom numeric format.

3. **Equality Check**:
    - Compare two numbers (in any valid format) to verify if they represent the same value.

4. **Maximum Finder**:
    - Identify the index of the maximum value in an array of numeric strings.

5. **Input Handling**:
    - Supports both upper and lowercase alphanumeric characters for bases above 10.
    - Automatically rejects invalid inputs with meaningful feedback via return values.

---

## Number Format
- **General Representation**: `<number><b><base>`
    - Examples:
      - `1011b2` (binary, base 2)
      - `123bA` (decimal, base 10)
      - `FFbG` (hexadecimal, base 16)

- **Invalid Representations**:
    - Missing parts (e.g., `b2`, `123b`)
    - Invalid characters (e.g., `GbG`, `A1b10`)
    - Null or empty strings

---

## Class and Method Descriptions
### `Ex1` Class
#### **Methods:**
1. `number2Int(String num)`:
   - Converts a numeric string to its decimal representation.
   - Returns `-1` for invalid input.

2. `isNumber(String a)`:
   - Validates whether a given string adheres to the defined format.
   - Returns `true` if valid, `false` otherwise.

3. `int2Number(int num, int base)`:
   - Converts a decimal integer to a custom-formatted string in the specified base.
   - Returns an empty string for invalid inputs.

4. `equals(String n1, String n2)`:
   - Compares two numeric strings for equality.
   - Returns `true` if values are equal, `false` otherwise.

5. `maxIndex(String[] arr)`:
   - Identifies the index of the maximum value in an array of numeric strings.
   - Returns `-1` if all values are invalid or the array is empty.

6. `isValidBase(int base)`:
   - Validates whether the base is within the accepted range (2-16).
   - Returns `true` for valid bases, `false` otherwise.

---

## Testing
### `Ex1Test` Class
- Implements unit tests using **JUnit** to ensure correctness and reliability of the methods.
- Key tests include:
  - `isNumberTest`: Validates whether a given string adheres to the custom numeric format.
  - `number2IntTest`: Tests the conversion of custom-formatted strings to decimal integers.
  - `int2NumberTest`: Verifies the conversion of decimal integers to custom-formatted strings in specified bases.
  - `equalsTest`: Ensures the equality comparison between two numeric strings is correct.
  - `maxIndexTest`: Tests finding the index of the maximum value in an array of numeric strings.
  - `isValidBaseTest`: Checks whether a base is valid within the range [2-16].

#### Example Test Scenarios
1. Conversion from base 2 to base 10:
    - Input: `1011b2` -> Output: `11`
2. Conversion from base 10 to base 3:
    - Input: `10, 3` -> Output: `101b3`
3. Invalid format check:
    - Input: `1G3bG` -> Output: `false`
4. Handling empty arrays in `maxIndex`:
    - Input: `[]` -> Output: `-1`
---

## File Structure
- `Ex1.java`: Implementation of the number converter and calculator.
- `Ex1Test.java`: JUnit tests for validating functionality.
- `Ex1Main.java`: Main function, all the code runs threw it.

### Hello, there was a problem with the synchronization in my GitHub when I was working on the master branch, but the README file that I wrote was added to the main branch. After the submission I noticed the problem and contacted practitioner Ilan and was told that I must inform you the examiner that the README file was transferred to the master branch after the submission with his approval.
