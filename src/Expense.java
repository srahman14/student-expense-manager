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
    private String title;
    private double amount;

    public Expense(String title, double amount) {
        this.title = title;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setAmount(double newAmount){
        this.amount = newAmount;
    }

    public double getAmount() {
        return amount;
    }

    public double getFinalAmount() {
        return amount;
    }

    public void showInfo() {
        System.out.println("Expense: " + title);
        System.out.println("Amount: " + amount);
        System.out.println("Type: Normal");
    }
}

