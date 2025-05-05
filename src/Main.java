package src;

import src.models.Expense;
import src.services.ExpenseManager;
import src.utils.InputHelper;

public class Main {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        while (true) {
            System.out.println("\n==== Expense Tracker ====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total");
            System.out.println("4. Exit");
            int choice = InputHelper.readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    addExpense(manager);
                    break;
                case 2:
                    manager.viewExpenses();
                    break;
                case 3:
                    System.out.println("Total Expenses: " + manager.calculateTotal());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void addExpense(ExpenseManager manager) {
        String description = InputHelper.readLine("Enter expense description: ");
        double amount = InputHelper.readInt("Enter expense amount: ");
        Expense expense = new Expense(description, amount);
        manager.addExpense(expense);
    }
}
