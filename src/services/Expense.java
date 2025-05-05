package src.models;

public class Expense {
    private double amount;
    private String category;
    private String description;

    public Expense(double amount, String category, String description) {
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return amount + "," + category + "," + description;
    }

    public static Expense fromString(String line) {
        String[] parts = line.split(",", 3);
        return new Expense(Double.parseDouble(parts[0]), parts[1], parts[2]);
    }
}
