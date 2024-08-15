import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*****************************************");
        System.out.println("*Welcome to the Student Grade Calculator*");
        System.out.println("*****************************************");

        // Input grades for different course components
        System.out.print("Enter your assignment grade (0-100): ");
        double assignmentGrade = getValidatedGrade(scanner);

        System.out.print("Enter your quiz grade (0-100): ");
        double quizGrade = getValidatedGrade(scanner);

        System.out.print("Enter your midterm exam grade (0-100): ");
        double midtermGrade = getValidatedGrade(scanner);

        System.out.print("Enter your final exam grade (0-100): ");
        double finalExamGrade = getValidatedGrade(scanner);

        // Calculate the final grade using weighted averages
        double finalGrade = calculateFinalGrade(assignmentGrade, quizGrade, midtermGrade, finalExamGrade);
        char letterGrade = getLetterGrade(finalGrade);

        // Display the final result
        System.out.println("*****************************************");
        System.out.println("Your Final Grade: " + finalGrade);
        System.out.println("Your Letter Grade: " + letterGrade);
        System.out.println("*****************************************");

        scanner.close();
    }

    // Function to get a validated grade from the user
    public static double getValidatedGrade(Scanner scanner) {
        double grade = -1;
        while (grade < 0 || grade > 100) {
            grade = scanner.nextDouble();
            if (grade < 0 || grade > 100) {
                System.out.print("Invalid grade. Please enter a value between 0 and 100: ");
            }
        }
        return grade;
    }

    // Function to calculate the final grade using weighted averages
    public static double calculateFinalGrade(double assignment, double quiz, double midterm, double finalExam) {
        double finalGrade = (assignment * 0.2) + (quiz * 0.2) + (midterm * 0.3) + (finalExam * 0.3);
        return finalGrade;
    }

    // Function to determine the letter grade based on the final grade
    public static char getLetterGrade(double finalGrade) {
        if (finalGrade >= 90) {
            return 'A';
        } else if (finalGrade >= 80) {
            return 'B';
        } else if (finalGrade >= 70) {
            return 'C';
        } else if (finalGrade >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
