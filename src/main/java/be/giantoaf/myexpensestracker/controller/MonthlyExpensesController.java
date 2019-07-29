package be.giantoaf.myexpensestracker.controller;

import be.giantoaf.myexpensestracker.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MonthlyExpensesController {

    private final ExpenseService expenseService;

    public MonthlyExpensesController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/monthlyexpenses")
    public String mymonthlyexpenses(Model model) {
        model.addAttribute("monthlyexpenses", expenseService.getAllThisMonthsExpenses());
        return "monthlyexpenses";
    }

}
