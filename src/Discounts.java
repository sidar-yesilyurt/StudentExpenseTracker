/**
 * DiscountedExpense.java
 * 
 * This class is for expenses that have a student discount applied.
 * It extends the Expense class and adds a discount percentage.
 * The getFinalAmount method is overridden to calculate the price after discount,
 * so if something costs £10 with 20% off, it returns £8.
 */
public class Discounts extends Expense {
    // Store the discount percentage
    private double discountPercent;

    // Constructor - creates a discounted expense
    public Discounts(String title, double amount, double discountPercent) {
        super(title, amount);
        this.discountPercent = discountPercent;
    }

    // Getter for discount
    public double getDiscountPercent() {
        return discountPercent;
    }

    // Setter for discount
    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    // Overrides parent method to calculate price after discount
    @Override
    public double getFinalFigure() {
        return getAmount() * (1 - discountPercent / 100);
    }

    // Prints the discounted expense details
    @Override
    public void showInfo() {
        System.out.printf("Title: %s | Original: £%.2f | Discount: %.0f%% | Final: £%.2f | Type: Discounted\n", //Rounds the number of decimal places for all to appropriate amount
                          getTitle(), getAmount(), discountPercent, getFinalFigure());
    }
}
