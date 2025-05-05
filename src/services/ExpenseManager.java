package src.services;

import src.models.Expense;
import src.storage.FileStorage;

import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenses;
    private FileStorage storage;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
        this.storage = new FileStorage();
        this.expenses = storage.loadExpenses();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        storage.saveExpenses(expenses);
        System.out.println("Expense added successfully.");
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
        } else {
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }
}
