package be.giantoaf.myexpensestracker.service;

import be.giantoaf.myexpensestracker.model.Category;
import be.giantoaf.myexpensestracker.model.Expense;
import be.giantoaf.myexpensestracker.model.User;
import be.giantoaf.myexpensestracker.repository.ExpensesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class ExpenseServiceTest {

    @Mock
    private ExpensesRepository expensesRepository;

    @InjectMocks
    private ExpenseService service;

    private List<Expense> expenses = new ArrayList<>();
    private Expense expenseOne;

    @BeforeEach
    void setUp() {
        expenses = new ArrayList<>();
        expenseOne = new Expense(1L, "Party", "Big Party", 2.53, LocalDate.of(2018, 12, 23), new Category(), new User());
        expenses.add(expenseOne);
        expenses.add(new Expense(2L, "Sad", "Sad Times", 5.52, LocalDate.of(2019, 2, 23), new Category(), new User()));
        expenses.add(new Expense(3L, "Dank", "Dank meme", 6.58, LocalDate.of(2019, 6, 23), new Category(), new User()));
    }

    @Test
    void getAllExpenses() {
        //given
        given(expensesRepository.findAll()).willReturn(expenses);
        //when
        List<Expense> foundExpenses = service.getAllExpenses();
        //then
        then(expensesRepository).should().findAll();
        assertThat(foundExpenses).hasSize(3);
    }

    @Test
    void getAllExpensesFilteredByName() {
        List<Expense> foundExpenses = service.getAllExpensesFilteredByName("ar");
        then(expensesRepository).should().findAllByNameContaining(anyString());
        assertThat(foundExpenses.size()).isLessThan(expenses.size());
        assertThat(foundExpenses).contains(expenseOne);
    }

    @Test
    void getAllExpensesForCategory() {
    }

    @Test
    void saveNewExpense() {
    }

    @Test
    void getAllThisMonthsExpenses() {
    }

    @Test
    void getAllExpensesSortByName() {
    }

    @Test
    void getAllExpensesSortByDescription() {
    }

    @Test
    void getAllExpensesSortByAmount() {
    }

    @Test
    void getAllExpensesSortByDateOfExpense() {
    }

    @Test
    void getAllExpensesSortByCategoryName() {
    }

    @Test
    void getLifetimeExpensesTotalAmountAllCategories() {
    }

    @Test
    void getLifetimeExpenseAmountForCategory() {
    }

    @Test
    void getLifetimeExpenseAmountForCategoryForThisMonth() {
    }

}