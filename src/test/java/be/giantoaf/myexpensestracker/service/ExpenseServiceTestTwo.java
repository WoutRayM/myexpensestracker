package be.giantoaf.myexpensestracker.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ExpenseServiceTestTwo {

    @Autowired
    ExpenseService expenseService;

    @Test
    void getAllExpenses() {
        when(expenseService.getAllExpenses()).thenReturn(new ArrayList<>());
    }
}