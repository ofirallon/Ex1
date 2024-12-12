# README for Ex1 - Number Formatting Converter and Calculator

## Overview
This project implements a number formatting converter and calculator for numeric strings based on custom formats defined in the range of bases [2-16]. The functionality allows for conversion between bases, validation of custom numeric formats, and basic operations such as equality checks and finding the maximum value from a collection of numbers.

The implementation includes the class Ex1 with several static methods and unit tests in Ex1Test.

---

## Features and Functionality
1. **Base Conversion**:
    - Parse custom formatted numbers into decimal integers.
    - Convert decimal integers into custom formatted strings in a given base.

2. **Validation**:
    - Check if a given string is a valid custom numeric format.

3. **Equality Check**:
- Compare two numbers in any valid format to check whether they are equal.
 
4. **Maximum Finder**:
    - Find the position of the maximum number present in an array of strings containing numeric values.

 ---
 
## Number Format
- **General Representation**: "number" then 'b' then 'base'
    - Examples:
      - 1011b2 for binary, base 2
      - 123bA for decimal, base 10
- FFbG (hexadecimal, base 16)

- **Invalid Representations:**
    - Partially missing parts (e.g., b2, 123b)
    - Invalid characters (e.g., GbG, A1b10)
    - Empty or null strings

---
## Class and Method Descriptions
### Ex1 Class
#### **Methods:**
1. number2Int(String num):
   - This method converts a numeric string into its decimal representation.
   - In case of an invalid input, it returns -1.

2. isNumber(String a):
- Checks if a given string is valid according to the specified format.
   - It returns true if it's valid, false otherwise.

3. int2Number(int num, int base):
   - Converts a decimal integer to a custom-formatted string in the specified base.
   - Returns an empty string if the input is invalid.

4. equals(String n1, String n2):
   - Tests whether two numeric strings are equal.
- Returns true if values are equal, false otherwise.

5. maxIndex(String[] arr):
   - Finds index of the maximum value from an array of numeric strings.
   - Returns -1 for all invalid values or if the array is empty.

---
## Testing
### Ex1Test Class
- Provides unit tests for the methods described using **JUnit** in order to guarantee the correctness and robustness of such methods.
- The important tests are the following:
  - Validation of conversion (isNumberTest)
  - Base conversion (int2NumberTest)
  - Equality checks (equalsTes)
  - Maximum value finding (maxIndexTest)

#### Example Test Scenarios
1. Base 2 to base 10 conversion:
    - Input: 1011b2 -> Output: 11
2. Base 10 to base 3 conversion:
    - Input: 10, 3 -> Output: 101b3
3. Check for invalid format:
    - Input: 1G3bG -> Output: false

---
 
// File Structure
- Ex1.java: This is where the implementation of the number converter and calculator goes.
- Ex1Test.java: JUnit tests for validating functionality.

