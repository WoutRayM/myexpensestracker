package be.giantoaf.myexpensestracker.repository;

import be.giantoaf.myexpensestracker.model.Category;
import be.giantoaf.myexpensestracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpensesRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByCategory_id(Long categoryId);

}
