import java.util.Arrays;
import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1, input2, quit = "quit";
        while (true) {
            System.out.println("\nEx1 class solution:");
            System.out.print("Enter a string as number#1 (or \"quit\" to end the program): ");
            input1 = scanner.nextLine();

            if (input1.equalsIgnoreCase(quit)) {
                break;
            }

            boolean isNum1Valid = Ex1.isNumber(input1);
            System.out.println("input1 = " + input1 + " is number: " + isNum1Valid +
                    " value: " + (isNum1Valid ? Ex1.number2Int(input1) : "-1"));

            if (!isNum1Valid) {
                System.out.println("Invalid input for number#1. Try again.");
                continue;
            }

            System.out.print("Enter a string as number#2 (or \"quit\" to end the program): ");
            input2 = scanner.nextLine();

            if (input2.equalsIgnoreCase(quit)) {
                break;
            }

            boolean isNum2Valid = Ex1.isNumber(input2);
            System.out.println("input2 = " + input2 + " is number: " + isNum2Valid +
                    " value: " + (isNum2Valid ? Ex1.number2Int(input2) : "-1"));

            if (!isNum2Valid) {
                System.out.println("Invalid input for number#2. Try again.");
                continue;
            }

            System.out.print("Enter a base for output (a number [2,16]): ");
            int base = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline

            if (base < 2 || base > 16) {
                System.out.println("Base must be between 2 and 16. Try again.");
                continue;
            }

            int sum = Ex1.number2Int(input1) + Ex1.number2Int(input2);
            String formattedSum = Ex1.int2Number(sum, base);

            int product = Ex1.number2Int(input1) * Ex1.number2Int(input2);
            String formattedProduct = Ex1.int2Number(product, base);

            System.out.println(input1 + " + " + input2 + " = " + formattedSum);
            System.out.println(input1 + " * " + input2 + " = " + formattedProduct);

            String[] res = {
                    input1,
                    input2,
                    formattedSum,
                    formattedProduct
            };

            int max = Ex1.maxIndex(res);
            String maxValue = res[max];
            System.out.println("Max number over: " + Arrays.toString(res) +
                    " is: " + maxValue + " (index: " + max + ")");
        }

        System.out.println("Quitting now...");
    }
}
