import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    // Data structure to represent a task
    static class Task {
        String title;
        String description;
        String dueDate;
        boolean isComplete;

        // Constructor to initialize a new task
        public Task(String title, String description, String dueDate) {
            this.title = title;
            this.description = description;
            this.dueDate = dueDate;
            this.isComplete = false;
        }

        // Mark the task as complete
        public void markAsComplete() {
            this.isComplete = true;
        }

        @Override
        public String toString() {
            return "Title: " + title + "\nDescription: " + description +
                    "\nDue Date: " + dueDate + "\nStatus: " + (isComplete ? "Complete" : "Incomplete") + "\n";
        }
    }

    // ArrayList to store the list of tasks
    static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Display the menu of options to the user
            System.out.println("*****Welcome to To-Do List Application*****");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Complete");
            System.out.println("3. View Tasks");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");

            // Get the user's choice
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add a new task
                    addTask(scanner);
                    break;
                case 2:
                    // Mark a task as complete
                    markTaskAsComplete(scanner);
                    break;
                case 3:
                    // View all tasks
                    viewTasks();
                    break;
                case 4:
                    // Remove a task
                    removeTask(scanner);
                    break;
                case 5:
                    // Exit the application
                    System.out.println("Exiting the application. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Function to add a new task to the list
    public static void addTask(Scanner scanner) {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter task due date (e.g., YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();

        Task newTask = new Task(title, description, dueDate);
        tasks.add(newTask);
        System.out.println("Task added successfully!\n");
    }

    // Function to mark a task as complete
    public static void markTaskAsComplete(Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to mark as complete.");
            return;
        }

        viewTasks();
        System.out.print("Enter the task number to mark as complete: ");
        int taskIndex = scanner.nextInt();

        if (taskIndex > 0 && taskIndex <= tasks.size()) {
            Task task = tasks.get(taskIndex - 1);
            task.markAsComplete();
            System.out.println("Task marked as complete!\n");
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    // Function to view all tasks
    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.\n");
            return;
        }

        System.out.println("Your Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).toString());
        }
    }

    // Function to remove a task from the list
    public static void removeTask(Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to remove.");
            return;
        }

        viewTasks();
        System.out.print("Enter the task number to remove: ");
        int taskIndex = scanner.nextInt();

        if (taskIndex > 0 && taskIndex <= tasks.size()) {
            tasks.remove(taskIndex - 1);
            System.out.println("Task removed successfully!\n");
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }
}
