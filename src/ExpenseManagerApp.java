/**
 * ExpenseManagerApp.java
 * This is the main program that displays the Student Expense Manager
 * menu and allows users to track their expenses. Optinos are, adding an expense,
 * adding a discounted expense, viewing all expenses, viewing the total spending,
 * and viewing the highest expense.
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class ExpenseManagerApp {
    // Use of ArrayList to store all expenses
    private static ArrayList<Expense> expenses = new ArrayList<>();
    public static Scanner menuOption =  new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;

        // Menu will keep running unless user enters 6
        while (isRunning) {
            showMenu();
            System.out.print("Enter an option (1-6): ");

            // Handles the user's choices
            switch(menuOption.next()) {
                case "1":
                    addExpense();
                    break;
                case "2":
                    addDiscountedExpense();
                    break;
                case "3":
                    viewAllExpenses();
                    break;
                case "4":
                    showTotalSpending();
                    break;
                case "5":
                    showHighestExpense();
                    break;
                case "6":
                    System.out.println("Thank you for using Student Expense Manager");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Enter an option between 1-6.");
                    break;
            }
        }
    }

    // Display's the menu
    public static void showMenu() {
        System.out.println("\n==== Student Expense Manager ====\n");
        System.out.println("1. Add Expense");
        System.out.println("2. Add dicounted expense");
        System.out.println("3. View all expense");
        System.out.println("4. Show total spending");
        System.out.println("5. Show highest expense");
        System.out.println("6. Exit");
    }

    // Adds a normal expense using the Expense class
    public static void addExpense() {
        System.out.println("\n--------------------------------");
        System.out.println("==== Adding Expense ====");

        System.out.print("Enter title of expense: ");
        Scanner expenseTitle = new Scanner(System.in);
        String title = expenseTitle.nextLine();

        // Validate the title
        if (title.trim().isEmpty()) {
            System.out.println("\nTitle cannot be empty");
            return;
        }

        try {
            System.out.print("Enter amount of expense (£): ");
            Scanner expenseAmount = new Scanner(System.in);
            double amount = expenseAmount.nextDouble();

            // Validate the entered amount
            if (amount < 0) {
                System.out.println("Amount cannot be negative");
                return;
            }

            // Instantiate Expense
            Expense newExpense = new Expense(title, amount);
            // Add the expense to the expenses ArrayList
            expenses.add(newExpense);
        } catch (InputMismatchException e) { // Catches error if user enters an incorrect type
            System.out.println("\nYou have entered an invalid amount.");
            return;
        }

        System.out.println("--------------------------------");
    }

    // Adds a discounted expense using the DiscountedExpense class
    public static void addDiscountedExpense() {
        System.out.println("\n--------------------------------");
        System.out.println("==== Adding Discounted Expense ====");

        System.out.print("Enter title of expense: ");
        Scanner expenseTitle = new Scanner(System.in);
        String title = expenseTitle.nextLine();

        // Validate the title
        if (title.trim().isEmpty()) {
            System.out.println("\nTitle cannot be empty");
            return;
        }

        try {
            System.out.print("Enter amount of expense: ");
            Scanner expenseAmount = new Scanner(System.in);
            double amount = expenseAmount.nextDouble();

            // Validate the entered amount
            if (amount < 0) {
                System.out.println("Amount cannot be negative");
                return;
            }

            System.out.print("Enter discount: ");
            Scanner discountedPercentageInput = new Scanner(System.in);
            double discountedPercentage = discountedPercentageInput.nextDouble();

            // Validate the entered discount
            if (discountedPercentage < 0.0 || discountedPercentage > 100.0) {
                System.out.println("Discounted percentage must be between 0.0 and 100.");
                return;
            }

            // Instantiate DiscountedExpense
            DiscountedExpense newDiscountedExpense = new DiscountedExpense(title, amount, discountedPercentage);
            // Add the expense to the expenses ArrayList
            expenses.add(newDiscountedExpense);
        } catch (InputMismatchException e) {
            System.out.println("\nYou have entered an invalid amount or discount.");
            return;
        }
        System.out.println("--------------------------------");
    }

    public static void viewAllExpenses() {
        // Validate if any expenses exist
        if (expenses.isEmpty()) {
            System.out.println("\nThere are no expenses to view\nAdd an expense by selecting option 1 or 2.");
            return;
        }

        System.out.println("--------------------------------");
        System.out.println("==== Viewing All Expenses ====");

        // Iterate through each expense and call the showInfo() method to print expense details
        expenses.forEach(expense -> { expense.showInfo(); System.out.println("--------------------------------\n");});
    }

    public static void showTotalSpending() {
        // Validate if any expenses exist
        if (expenses.isEmpty()) {
            System.out.println("\nThere are no expenses to view\nAdd an expense by selecting option 1 or 2.");
            return;
        }

        System.out.println("--------------------------------");
        System.out.println("==== Viewing Total Spending ====");

        double totalSpending = 0;
        // Iterate through all the expenses and sum up the expenses calling the method getFinalAmount for each
        // expense to get its final amount
        for (Expense expense : expenses) {
            totalSpending += expense.getFinalAmount();
        }

        System.out.println("Total Spending: " + totalSpending);
        System.out.println("--------------------------------\n");
    }

    public static void showHighestExpense() {
        // Validate if any expenses exist
        if (expenses.isEmpty()) {
            System.out.println("\nThere are no expenses to view\nAdd an expense by selecting option 1 or 2.");
            return;
        }
        System.out.println("--------------------------------");
        System.out.println("==== Viewing Total Spending ====");


        double currentHighest = 0;
        // Iterate through all the expenses and sum up the expenses calling the method getFinalAmount for each
        // expense to get its final amount
        for (Expense expense: expenses) {
            // Set the current highest by comparing the current highest to the current expense's final amount.
            // Math max will take the larger value, and if the values are equal, the current highest remains unchanged.
            currentHighest = Math.max(currentHighest, expense.getFinalAmount());
        }

        System.out.println("Highest Expense: " + currentHighest);
        System.out.println("--------------------------------");
    }
}

