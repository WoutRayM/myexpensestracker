package be.giantoaf.myexpensestracker.service;

import be.giantoaf.myexpensestracker.model.Expense;

import java.time.LocalDate;
import java.util.function.Predicate;

public class ExpensePredicate {

    public static Predicate<Expense> isSameMonthAndYear() {
        return expense ->
            expense.getDateOfExpense().getMonthValue() == LocalDate.now().getMonthValue() &&
                    expense.getDateOfExpense().getYear() == LocalDate.now().getYear();
    }

}
