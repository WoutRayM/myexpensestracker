package be.giantoaf.myexpensestracker.service;

import be.giantoaf.myexpensestracker.repository.ExpensesRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final ExpensesRepository expensesRepository;

    public UserService(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

}
