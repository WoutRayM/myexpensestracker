package be.giantoaf.myexpensestracker.controller;

import be.giantoaf.myexpensestracker.model.Expense;
import be.giantoaf.myexpensestracker.model.FormValue;
import be.giantoaf.myexpensestracker.service.CategoryService;
import be.giantoaf.myexpensestracker.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class NewExpenseController {

    private final ExpenseService expenseService;
    private final CategoryService categoryService;

    public NewExpenseController(ExpenseService expenseService, CategoryService categoryService) {
        this.expenseService = expenseService;
        this.categoryService = categoryService;
    }

    @GetMapping("/newexpense")
    public String collectNewExpense(Model model) {
        model.addAttribute("allCategories", categoryService.getAllCategories());
        model.addAttribute("expense", new Expense());
        model.addAttribute("formValue", new FormValue());
        return "newexpense";
    }

    @PostMapping("/newexpense")
    public String storeNewExpense(@ModelAttribute Expense expense, @ModelAttribute FormValue formValue) {
        expense.setCategory(categoryService.getCategoryById(Long.parseLong(formValue.getFormValueOne())));
        expenseService.saveNewExpense(expense);
        return "result";
    }

}
