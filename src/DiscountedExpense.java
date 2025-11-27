class Test2 {
    public static void main(String[] args) {
        // Test Method
        Expense e1 = new DiscountedExpense("Monitor", 300, 20);
        System.out.println(e1.getAmount());
        System.out.println(e1.getTitle());
        e1.showInfo();
        e1.setAmount(200);
        e1.setTitle("TV");
        e1.showInfo();
    }
}

public class DiscountedExpense extends Expense {
    private double discountedPercent;

    public DiscountedExpense(String title, double amount, double discountedPercent) {
        super(title, amount);
        this.discountedPercent = discountedPercent;
    }


    // Method Overloading (Polymorphism)
    public double getFinalAmount() {
        return getAmount() * (1 - discountedPercent/100);
    }

    public void showInfo() {
        System.out.println("Expense: " + getTitle());
        System.out.println("Amount: " + getAmount());
        System.out.println("Discounted Percent: " + discountedPercent);
        System.out.println("Expense (after discount): " + getFinalAmount());
        System.out.println("Type: Discounted");
    }
}