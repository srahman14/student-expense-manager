import java.util.Scanner;
import java.util.ArrayList;

class TestExpenseManager {
    public static void main(String[] args) {
        // Test Method
        ExpenseManager expenseManager = new ExpenseManager();

        expenseManager.addExpense();
        expenseManager.addDiscountedExpense();
        expenseManager.viewAllExpenses();
        expenseManager.showTotalSpending();
        expenseManager.showHighestExpense();
    }
}

public class ExpenseManager {
    private ArrayList<Expense> expenses;
    private double totalSpending;
    private double currentHighest = 0;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
    }

    public void startMenu() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {

            System.out.println("==== Student Expense Manager ====");
            System.out.println("1. Add Expense");
            System.out.println("2. Add dicounted expense");
            System.out.println("3. View all expense");
            System.out.println("4. Show total spending");
            System.out.println("5. Show highest expense");
            System.out.println("6. Exit");


            Scanner menuOption = new Scanner(System.in);
            System.out.println("Enter an option");

            switch(menuOption.next()) {
                case "1":
                    System.out.println("---------------------------");
                    addExpense();
                    System.out.println("---------------------------");
                    break;
                case "2":
                    System.out.println("---------------------------");
//                    System.out.println("Add discounted expense");
                    addDiscountedExpense();
                    System.out.println("---------------------------");
                    break;
                case "3":
                    System.out.println("---------------------------");
                    viewAllExpenses();
                    System.out.println("---------------------------");
                    break;
                case "4":
                    System.out.println("---------------------------");
//                    System.out.println("Show total spending");
                    showTotalSpending();
                    System.out.println("---------------------------");
                    break;
                case "5":
                    System.out.println("---------------------------");
//                    System.out.println("Show highest expense");
                    showHighestExpense();
                    System.out.println("---------------------------");
                    break;
                case "6":
                    System.out.println("Thank you for using Student Expense Manager");
                    isRunning = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public void addExpense() {
        System.out.println("Enter title of expense: ");
        Scanner expenseTitle = new Scanner(System.in);
        String title = expenseTitle.nextLine();
        System.out.println("Enter amount of expense: ");
        Scanner expenseAmount = new Scanner(System.in);
        double amount = expenseAmount.nextDouble();

        Expense newExpense = new Expense(title, amount);
        expenses.add(newExpense);
    }

    public void addDiscountedExpense() {
        System.out.println("Enter title of expense: ");
        Scanner expenseTitle = new Scanner(System.in);
        String title = expenseTitle.nextLine();
        System.out.println("Enter amount of expense: ");
        Scanner expenseAmount = new Scanner(System.in);
        double amount = expenseAmount.nextDouble();
        System.out.println("Enter discount (%): ");
        Scanner discountedPercentageInput = new Scanner(System.in);
        double discountedPercentage = discountedPercentageInput.nextDouble();

        DiscountedExpense newDiscountedExpense = new DiscountedExpense(title, amount, discountedPercentage);
        expenses.add(newDiscountedExpense);
    }

    public void viewAllExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("There are no expenses to view");
        }

        expenses.forEach(expense -> { expense.showInfo(); System.out.println("---------------------------");});
    }

    public void showTotalSpending() {
        if (expenses.isEmpty()) {
            System.out.println("There are no expenses.");
        }

        expenses.forEach(expense -> { totalSpending += expense.getFinalAmount(); });
        System.out.println("Total Spending: " + totalSpending);
    }

    public void showHighestExpense() {
        if (expenses.isEmpty()) {
            System.out.println("There are no expenses to view");
        }
        expenses.forEach(expense -> { currentHighest = Math.max(currentHighest, expense.getFinalAmount());} );
        System.out.println("Highest Expense: " + currentHighest);
    }
}

