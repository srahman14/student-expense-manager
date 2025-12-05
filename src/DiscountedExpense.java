/**
 * DiscuontedExpense.java
 * This is the DiscuontedExpense.java file holding the DiscuontedExpense class.
 * The DiscuontedExpense class is child class of the Expense class.
 * The fields the same as the child class plus the disccuontedPercentage field.
 * getFinalAmount() is as method to get the final amount of the expense after
 * the discuont is applied. showInfo() is the same method as in theexpense class
 * with the additional discount percentage shown.
 */

public class DiscountedExpense extends Expense {
    // DiscountedExpense fields
    private double discountedPercentage;

    // Constructor
    public DiscountedExpense(String title, double amount, double discountedPercentage) {
        super(title, amount);
        this.discountedPercentage = discountedPercentage;
    }

    // Getter Method for Discount
    public double getDiscountedPercentage() {
        return discountedPercentage;
    }

    // Setter Method for Discount
    public void setDiscountedPercentage(double discountedPercentage) {
        this.discountedPercentage = discountedPercentage;
    }

    // Overrides parent (Expense) method for calculating final amount for price
    // after applying the discount
    @Override
    public double getFinalAmount() {
        return getAmount() * (1 - discountedPercentage/100);
    }

    // Overrides parent (Expense) method for printing discounted expense details
    @Override
    public void showInfo() {
        System.out.println("Expense: " + getTitle());
        System.out.println("Amount: " + getAmount());
        System.out.println("Discounted Percent: " + discountedPercentage);
        System.out.println("Expense (after discount): " + getFinalAmount());
        System.out.println("Type: Discounted");
    }
}