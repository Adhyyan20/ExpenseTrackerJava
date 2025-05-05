package src;

import src.services.ExpenseManager;
import src.utils.InputHelper;

public class Main {
    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        int choice;

        do {
            System.out.println("\n==== Expense Tracker ====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total");
            System.out.println("4. Exit");
            choice = InputHelper.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    manager.addExpenseCLI();
                    break;
                case 2:
                    manager.viewExpenses();
                    break;
                case 3:
                    manager.viewTotal();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}
