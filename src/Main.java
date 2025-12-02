import java.util.ArrayList;
import java.util.Scanner;

/**
 * App.java - Student Expense Manager
 * 
 * This is the main program that helps students track their daily expenses.
 * It shows a menu where users can add normal expenses, add discounted expenses,
 * view all their expenses, see total spending, and find the highest expense.
 * Uses a loop to keep running until the user exits, and a switch statement
 * to handle the different menu choices.
 * Exp = Expense
 */
public class Main {
    // List to store all the expenses
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean inMenu = true;

        System.out.println("Welcome to Student Expense Manager!");
        System.out.println("=====================================\n");

        // Keep running until user exits
        while (inMenu) {
            displayingMenu();
            int choice = getUserChoice();

            // Handle user's choice
            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    addDiscountedExp();
                    break;
                case 3:
                    viewAllExp();
                    break;
                case 4:
                    showTotalSpending();
                    break;
                case 5:
                    showHighestExp();
                    break;
                case 6:
                    inMenu = false;
                    System.out.println("\nThank you for using our Student Expense Manager!");
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("\nPlease enter a number between 1 and 6.");
            }

            // Add blank line between actions
            if (inMenu) {
                System.out.println();
            }
        }

        scanner.close();
    }

    // Shows the menu to the user
    private static void displayingMenu() {
        System.out.println("==== Student Expense Manager ====");
        System.out.println("1. Add Expense");
        System.out.println("2. Add Discounted Expense");
        System.out.println("3. View All Expenses");
        System.out.println("4. Show Total Spending");
        System.out.println("5. Show Highest Expense");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    // Gets the user's choice from the menu
    private static int getUserChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            return choice;
        } catch (NumberFormatException e) { //Handles non numeric input, e.g letter is entered it will return -1
            return -1;
        }
    }

    // Adds a normal expense
    private static void addExpense() { 
        System.out.println("\n--- Add Expense ---");
        
        System.out.print("Enter expense title: ");
        String title = scanner.nextLine();

        // Check if title is empty
        if (title.trim().isEmpty()) { // removes whitespace from both end of string and checks if its empty
            System.out.println("Error: Title cannot be empty!");
            return;
        }

        System.out.print("Enter expense amount (£): ");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            
            // Make sure amount is not negative
            if (amount < 0) {
                System.out.println("Error: Amount cannot be negative!");
                return;
            }

            Expense expense = new Expense(title, amount);
            expenses.add(expense);
            System.out.println("✓ Expense added successfully!");
        } catch (NumberFormatException e) { //Handles non numeric input, e.g letter is entered it will return an error message
            System.out.println("Error: Invalid amount! Please enter a valid number.");
        }
    }

    // Adds an expense with a discount
    private static void addDiscountedExp() {
        System.out.println("\n--- Add Discounted Expense ---");
        
        System.out.print("Enter expense title: ");
        String title = scanner.nextLine();

        // Check if title is empty
        if (title.trim().isEmpty()) {
            System.out.println("Error: Title cannot be empty!");
            return;
        }

        System.out.print("Enter original amount (£): ");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            
            // Make sure amount is not negative
            if (amount < 0) {
                System.out.println("Error: Amount cannot be negative!");
                return;
            }

            System.out.print("Enter discount percentage (e.g., 10 for 10%): ");
            double discount = Double.parseDouble(scanner.nextLine());
            
            // Check discount is between 0 and 100
            if (discount < 0 || discount > 100) {
                System.out.println("Error: Discount must be between 0 and 100!");
                return;
            }

            Discounts expense = new Discounts(title, amount, discount);
            expenses.add(expense);
            System.out.println("✓ Discounted expense added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input! Please enter valid numbers.");
        }
    }

    // Shows all expenses that have been added
    private static void viewAllExp() {
        System.out.println("\n--- All Expenses ---");
        
        // Check if list is empty
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }

        // Print each expense
        for (int i = 0; i < expenses.size(); i++) {
            System.out.print((i + 1) + ". ");
            expenses.get(i).showInfo();
        }
    }

    // Calculates the total amount spent
    private static void showTotalSpending() {
        System.out.println("\n--- Total Spending ---");
        
        // Check if list is empty
        if (expenses.isEmpty()) {
            System.out.println("No expenses");
            return;
        }

        double total = 0;
        // Add up all the expenses
        for (Expense expense : expenses) {
            total += expense.getFinalFigure();
        }

        System.out.printf("Total Expenses: £%.2f\n", total);
        System.out.printf("Number of Expenses: %d\n", expenses.size());
    }

    // Finds the most expensive item
    private static void showHighestExp() {
        System.out.println("\n--- Highest Expense ---");
        
        // Check if list is empty
        if (expenses.isEmpty()) {
            System.out.println("No expenses");
            return;
        }

        Expense highest = expenses.get(0);
        
        // Find the biggest expense
        for (int i = 1; i < expenses.size(); i++) {
            if (expenses.get(i).getFinalFigure() > highest.getFinalFigure()) {
                highest = expenses.get(i);
            }
        }

        System.out.printf("Highest Expense: %s - £%.2f\n", 
                          highest.getTitle(), highest.getFinalFigure());
    }
}
