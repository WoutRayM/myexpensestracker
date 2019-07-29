package be.giantoaf.myexpensestracker.controller;

import be.giantoaf.myexpensestracker.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllExpensesController {

    private final ExpenseService expenseService;

    public AllExpensesController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/allexpenses")
    public String allExpenses(Model model) {
        model.addAttribute("allExpenses", expenseService.getAllExpenses());
        return "allexpenses";
    }

    @GetMapping("sortallexpensesbyname")
    public String allExpensesSortedByName(Model model) {
        model.addAttribute("allExpenses", expenseService.getAllExpensesSortByName());
        return "allexpenses";
    }

    @GetMapping("sortallexpensesbydescription")
    public String allExpensesSortedByDescription(Model model) {
        model.addAttribute("allExpenses", expenseService.getAllExpensesSortByDescription());
        return "allexpenses";
    }

    @GetMapping("sortallexpensesbyamount")
    public String allExpensesSortedByAmount(Model model) {
        model.addAttribute("allExpenses", expenseService.getAllExpensesSortByAmount());
        return "allexpenses";
    }

    @GetMapping("sortallexpensesbydateofexpense")
    public String allExpensesSortedByDateOfExpense(Model model) {
        model.addAttribute("allExpenses", expenseService.getAllExpensesSortByDateOfExpense());
        return "allexpenses";
    }

    @GetMapping("sortallexpensesbycategory")
    public String allExpensesSortedByCategory(Model model) {
        model.addAttribute("allExpenses", expenseService.getAllExpensesSortByCategoryName());
        return "allexpenses";
    }

}
