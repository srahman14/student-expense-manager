/**
 * Expense.java
 * This is the Expense.java file holding the Expense class.
 * The fields are title and amount, title set as String and
 * amount set as a double. getFinalaAmount() is a method to return
 * the final amount of the expense.
 * showInfo() is a method defined to print out the details of the expense class.
 */

public class Expense {
    // Expense Fields
    private String title;
    private double amount;

    // Constructor
    public Expense(String title, double amount) {
        this.title = title;
        this.amount = amount;
    }

    // Getter Method for Title
    public String getTitle() {
        return title;
    }

    // Setter Methodo for Title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter Method for Amount
    public double getAmount() {
        return amount;
    }

    // Setter Method for Amount
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Method for final amount -> returns the final amount
    public double getFinalAmount() {
        return amount;
    }

    // Method for printing the expense details
    public void showInfo() {
        System.out.println("Expense: " + title);
        System.out.println("Amount: " + amount);
        System.out.println("Final amount: " + getFinalAmount());
        System.out.println("Type: Normal");
    }
}

