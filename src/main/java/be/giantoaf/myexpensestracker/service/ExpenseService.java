package be.giantoaf.myexpensestracker.service;

import be.giantoaf.myexpensestracker.model.Expense;
import be.giantoaf.myexpensestracker.repository.ExpensesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
