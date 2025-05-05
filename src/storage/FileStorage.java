package src.storage;

import src.models.Expense;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {
    private final String filename;

    public FileStorage(String filename) {
        this.filename = filename;
    }

    public void saveExpense(Expense expense) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.write(expense.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public List<Expense> loadExpenses() {
        List<Expense> list = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Expense.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        return list;
    }
}
