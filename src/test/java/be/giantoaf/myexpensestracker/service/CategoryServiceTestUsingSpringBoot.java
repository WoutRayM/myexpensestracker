package be.giantoaf.myexpensestracker.service;

import be.giantoaf.myexpensestracker.model.Category;
import be.giantoaf.myexpensestracker.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class CategoryServiceTestUsingSpringBoot {

    private CategoryService categoryService;

    private CategoryRepository categoryRepository = Mockito.mock(CategoryRepository.class);

    private List<Category> categories = new ArrayList<>();

    @BeforeEach
    void init() {
        categoryService = new CategoryService(categoryRepository);
        categories.add(new Category());
        categories.add(new Category());
    }

    @Test
    void getAllCategories() {
        given(categoryRepository.findAll()).willReturn(categories);
        List<Category> foundCategories = categoryService.getAllCategories();
        assertThat(foundCategories.size()).isEqualTo(2);
    }

    @Test
    void saveNewCategory() {
    }

    @Test
    void getCategoryById() {
    }

    @Test
    void getCategoryByCategoryname() {
    }
}