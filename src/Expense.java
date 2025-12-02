/**
 * Expense.java
 * 
 * This class stores information about a basic expense.
 * It has a title and an amount.
 * The getFinalAmount method returns the amount to pay, and showInfo displays
 * the expense details. This is the parent class for DiscountedExpense.
 */
public class Expense {
    // Store the expense details
    private String title;
    private double amount;

    // Constructor - creates a new expense
    public Expense(String title, double amount) {
        this.title = title;
        this.amount = amount;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setName(String title) {
        this.title = title;
    }

    // Getter for amount
    public double getAmount() {
        return amount;
    }

    // Setter for amount
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Returns the final amount (same as original for normal expenses)
    public double getFinalFigure() {
        return amount;
    }

    // Prints the expense details
    public void showInfo() {
        System.out.printf("Title: %s | Amount: £%.2f | Type: Normal\n", title, amount);
    }
}
