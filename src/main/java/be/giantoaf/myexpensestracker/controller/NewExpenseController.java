package be.giantoaf.myexpensestracker.controller;

import be.giantoaf.myexpensestracker.model.Expense;
import be.giantoaf.myexpensestracker.service.CategoryService;
import be.giantoaf.myexpensestracker.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

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
        return "newexpense";
    }

    @PostMapping("/newexpense")
    public String storeNewExpense(@ModelAttribute Expense expense, @RequestBody MultiValueMap<String, String> dataNeededForForeignKey) {
        expense.setCategory(categoryService.getCategoryById(Long.parseLong(dataNeededForForeignKey.getFirst("categoryId"))));
        expenseService.saveNewExpense(expense);
        return "result";
    }

}
