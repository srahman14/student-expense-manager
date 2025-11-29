//class Test {
//    public static void main(String[] args) {
//        // Test Method
//        Expense e1 = new Expense("Monitor", 299);
//        System.out.println(e1.getAmount());
//        System.out.println(e1.getTitle());
//        e1.showInfo();
//        e1.setAmount(200);
//        e1.setTitle("TV");
//        e1.showInfo();
//    }
//}

public class Expense {
    // Fields defined as final, as they won't change after creation
    // From CRUD perspective, this project only requires Creating and Reading
    // Since no update or delete needed, use of final is best.
    private final String title;
    private final double amount;

    // Constructor
    public Expense(String title, double amount) {
        this.title = title;
        this.amount = amount;
    }

    // Getter Method for Title
    public String getTitle() {
        return title;
    }

    // Getter Method for Amount
    public double getAmount() {
        return amount;
    }

    // Method for final amount
    public double getFinalAmount() {
        return amount;
    }

    public void showInfo() {
        System.out.println("Expense: " + title);
        System.out.println("Amount: " + amount);
        System.out.println("Final amount: " + getFinalAmount());
        System.out.println("Type: Normal");
    }
}

