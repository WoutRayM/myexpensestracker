package be.giantoaf.myexpensestracker.repository;

import be.giantoaf.myexpensestracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepository extends JpaRepository<Expense, Long> {
}
