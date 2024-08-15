import java.util.Scanner;

public class Calculator {

    // Main function to run the calculator application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;

        while (continueCalculation) {
            // Displaying the menu of operations
            System.out.println("*****************************************");
            System.out.println("* Welcome to the Calculator Application *");
            System.out.println("*****************************************");
            System.out.println("Select an operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.println("*****************************************");

            // Getting user input for menu selection
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            // Handling the exit condition
            if (choice == 5) {
                System.out.println("Exiting the calculator. Goodbye!");
                continueCalculation = false;
                continue;
            }

            // Check if the choice is valid before proceeding
            if (choice < 1 || choice > 4) {
                System.out.println("Invalid choice. Please select a valid operation (1-4).");
                continue;
            }

            // Collecting two numbers from the user for the selected operation
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            // Performing the selected operation based on user choice
            switch (choice) {
                case 1:
                    System.out.println("*****************************************");
                    System.out.println("Result: " + num1 + " + " + num2 + " = " + add(num1, num2));
                    System.out.println("*****************************************");
                    break;
                case 2:
                    System.out.println("*****************************************");
                    System.out.println("Result: " + num1 + " - " + num2 + " = " + subtract(num1, num2));
                    System.out.println("*****************************************");
                    break;
                case 3:
                    System.out.println("*****************************************");
                    System.out.println("Result: " + num1 + " * " + num2 + " = " + multiply(num1, num2));
                    System.out.println("*****************************************");
                    break;
                case 4:
                    // Handling division by zero
                    if (num2 == 0) {
                        System.out.println("*****************************************");
                        System.out.println("Error: Division by zero is not allowed.");
                        System.out.println("*****************************************");
                    } else {
                        System.out.println("*****************************************");
                        System.out.println("Result: " + num1 + " / " + num2 + " = " + divide(num1, num2));
                        System.out.println("*****************************************");
                    }
                    break;
            }

            // Prompting the user to continue or exit
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String userResponse = scanner.next();
            if (!userResponse.equalsIgnoreCase("yes")) {
                continueCalculation = false;
            }
        }

        scanner.close();
    }

    // Function for addition operation
    public static double add(double a, double b) {
        return a + b;
    }

    // Function for subtraction operation
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Function for multiplication operation
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Function for division operation
    public static double divide(double a, double b) {
        return a / b;
    }
}
