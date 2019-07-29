package be.giantoaf.myexpensestracker.service;

import be.giantoaf.myexpensestracker.model.Expense;
import be.giantoaf.myexpensestracker.repository.ExpensesRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final ExpensesRepository expensesRepository;

    public ExpenseService(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    public List<Expense> getAllExpenses() {
        return expensesRepository.findAll();
    }

    public void saveNewExpense(Expense expense) {
        expensesRepository.save(expense);
    }

    public List<Expense> getAllThisMonthsExpenses() {
        return getAllExpenses().stream()
                .filter(ExpensePredicate.isSameMonthAndYear())
                .sorted(Comparator.comparing(Expense::getDateOfExpense))
                .collect(Collectors.toList());
    }

    public List<Expense> getAllExpensesSortByName() {
        return getAllExpenses().stream()
                .sorted(Comparator.comparing(Expense::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    public List<Expense> getAllExpensesSortByDescription() {
        return getAllExpenses().stream()
                .sorted(Comparator.comparing(Expense::getDescription, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    public List<Expense> getAllExpensesSortByAmount() {
        return getAllExpenses().stream()
                .sorted(Comparator.comparingDouble(Expense::getAmount))
                .collect(Collectors.toList());
    }

    public List<Expense> getAllExpensesSortByDateOfExpense() {
        return getAllExpenses().stream()
                .sorted(Comparator.comparing(Expense::getDateOfExpense))
                .collect(Collectors.toList());
    }

    public List<Expense> getAllExpensesSortByCategoryName() {
        return getAllExpenses().stream()
                .sorted(Comparator.comparing(expense -> expense.getCategory().getName()))
                .collect(Collectors.toList());
    }

}
