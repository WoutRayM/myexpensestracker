package be.giantoaf.myexpensestracker.controller;

import be.giantoaf.myexpensestracker.model.Expense;
import be.giantoaf.myexpensestracker.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AllExpensesController {

    private List<Expense> allExpenses;

    public AllExpensesController(ExpenseService expenseService) {
        allExpenses = expenseService.getAllExpenses();
    }

    @GetMapping("/allexpenses")
    public String allExpenses(Model model) {
        model.addAttribute("allExpenses", allExpenses);
        return "allexpenses";
    }

    @GetMapping("sortallexpensesbyname")
    public String allExpensesSortedByName(Model model) {
        model.addAttribute("allExpenses", allExpenses.stream()
                                                        .sorted(Comparator.comparing(Expense::getName, String.CASE_INSENSITIVE_ORDER))
                                                        .collect(Collectors.toList()));
        return "allexpenses";
    }

    @GetMapping("sortallexpensesbydescription")
    public String allExpensesSortedByDescription(Model model) {
        model.addAttribute("allExpenses", allExpenses.stream()
                .sorted(Comparator.comparing(Expense::getDescription, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList()));
        return "allexpenses";
    }

    @GetMapping("sortallexpensesbyamount")
    public String allExpensesSortedByAmount(Model model) {
        model.addAttribute("allExpenses", allExpenses.stream()
                .sorted(Comparator.comparingDouble(Expense::getAmount))
                .collect(Collectors.toList()));
        return "allexpenses";
    }

    @GetMapping("sortallexpensesbydateofexpense")
    public String allExpensesSortedByDateOfExpense(Model model) {
        model.addAttribute("allExpenses", allExpenses.stream()
                .sorted(Comparator.comparing(Expense::getDateOfExpense))
                .collect(Collectors.toList()));
        return "allexpenses";
    }

}
