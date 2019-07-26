package be.giantoaf.myexpensestracker.controller;

import be.giantoaf.myexpensestracker.model.Category;
import be.giantoaf.myexpensestracker.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewCategoryController {

    private final CategoryService categoryService;

    public NewCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/newcategory")
    public String collectNewCategory(Model model) {
        model.addAttribute("category", new Category());
        return "newcategory";
    }

    @PostMapping("/newcategory")
    public String storeNewCategory(@ModelAttribute Category category) {
        categoryService.saveNewCategory(category);
        return "result";
    }

}
