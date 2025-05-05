package src.services;

import src.models.Expense;
import src.storage.FileStorage;
import src.utils.InputHelper;

import java.util.List;

public class ExpenseManager {
    private final FileStorage storage = new FileStorage("expenses.txt");

    public void addExpenseCLI() {
        double amount = InputHelper.readDouble("Enter amount: ");
        String category = InputHelper.readString("Enter category: ");
        String desc = InputHelper.readString("Enter description: ");

        Expense expense = new Expense(amount, category, desc);
        storage.saveExpense(expense);
        System.out.println("Expense added.");
    }

    public void viewExpenses() {
        List<Expense> expenses = storage.loadExpenses();
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("\n--- Expense List ---");
            for (Expense e : expenses) {
                System.out.println("₹" + e.getAmount() + " | " + e.getCategory() + " | " + e.getDescription());
            }
        }
    }

    public void viewTotal() {
        List<Expense> expenses = storage.loadExpenses();
        double total = expenses.stream().mapToDouble(Expense::getAmount).sum();
        System.out.println("Total Expenses: ₹" + total);
    }
}
