package be.giantoaf.myexpensestracker.controller;

import be.giantoaf.myexpensestracker.model.Category;
import be.giantoaf.myexpensestracker.service.CategoryService;
import be.giantoaf.myexpensestracker.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExpensesDetailsController {

    private final ExpenseService expenseService;
    private final CategoryService categoryService;

    public ExpensesDetailsController(ExpenseService expenseService, CategoryService categoryService) {
        this.expenseService = expenseService;
        this.categoryService = categoryService;
    }

    @GetMapping("/expensedetails")
    public String expenseDetails(Model model) {
        model.addAttribute("allCategories", categoryService.getAllCategories());
        model.addAttribute("category", new Category());
        return "expensedetails";
    }

    @PostMapping("/expensedetails")
    public String expenseDetails(@ModelAttribute Category category, Model model) {
        model.addAttribute("allCategories", categoryService.getAllCategories());
        model.addAttribute("expensesForThisCategory", expenseService.getAllExpensesForCategory(category.getId()));
        model.addAttribute("totalAmountOfExpensesForCategory",
                expenseService.getLifetimeExpenseAmountForCategory(category.getId()));
        model.addAttribute("totalAmountOfExpensesForCategoryThisMonth",
                expenseService.getLifetimeExpenseAmountForCategoryForThisMonth(category.getId()));
        return "expensedetails";
    }
}
