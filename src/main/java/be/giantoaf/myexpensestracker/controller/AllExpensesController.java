package be.giantoaf.myexpensestracker.controller;

import be.giantoaf.myexpensestracker.model.FormValue;
import be.giantoaf.myexpensestracker.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AllExpensesController {

    private final ExpenseService expenseService;

    public AllExpensesController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/allexpenses")
    public String allExpenses(Model model) {
        if(!model.containsAttribute("allExpenses")) {
            model.addAttribute("allExpenses", expenseService.getAllExpenses());
        }
        model.addAttribute("namefilter", new FormValue());
        return "allexpenses";
    }

    @GetMapping("sortallexpensesbyname")
    public String allExpensesSortedByName(Model model) {
        model.addAttribute("allExpenses", expenseService.getAllExpensesSortByName());
        return allExpenses(model);
    }

    @GetMapping("sortallexpensesbydescription")
    public String allExpensesSortedByDescription(Model model) {
        model.addAttribute("allExpenses", expenseService.getAllExpensesSortByDescription());
        return allExpenses(model);
    }

    @GetMapping("sortallexpensesbyamount")
    public String allExpensesSortedByAmount(Model model) {
        model.addAttribute("allExpenses", expenseService.getAllExpensesSortByAmount());
        return allExpenses(model);
    }

    @GetMapping("sortallexpensesbydateofexpense")
    public String allExpensesSortedByDateOfExpense(Model model) {
        model.addAttribute("allExpenses", expenseService.getAllExpensesSortByDateOfExpense());
        return allExpenses(model);
    }

    @GetMapping("sortallexpensesbycategory")
    public String allExpensesSortedByCategory(Model model) {
        model.addAttribute("allExpenses", expenseService.getAllExpensesSortByCategoryName());
        return allExpenses(model);
    }

    @PostMapping("filterallexpensesbyname")
    public String allExpensesFilteredByName(@ModelAttribute FormValue formValue, Model model) {
        model.addAttribute("allExpenses", expenseService.getAllExpensesFilteredByName(formValue.getFormValueOne()));
        return allExpenses(model);
    }

}
