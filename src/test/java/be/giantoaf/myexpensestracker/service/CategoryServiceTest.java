package be.giantoaf.myexpensestracker.service;

import be.giantoaf.myexpensestracker.model.Category;
import be.giantoaf.myexpensestracker.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    CategoryRepository categoryRepository;

    @InjectMocks
    CategoryService categoryService;

    @Test
    void getAllCategories() {
        //given
        List<Category> categories = new ArrayList<>();
        categories.add(new Category());
        categories.add(new Category());
        given(categoryRepository.findAll()).willReturn(categories);
        //when
        List<Category> categoriesFound = categoryService.getAllCategories();
        //then
        then(categoryRepository).should().findAll();
        assertThat(categoriesFound).hasSize(2);
    }

    @Test
    void saveNewCategory() {
        //given
        Category category = new Category();
        //when
        categoryService.saveNewCategory(category);
        //then
        then(categoryRepository).should().save(any());
    }

    @Test
    void getCategoryById() {
        //given
        given(categoryRepository.getOne(anyLong())).willReturn(new Category());
        //when
        Category category = categoryService.getCategoryById(1L);
        //then
        then(categoryRepository).should().getOne(anyLong());
        assertThat(category).isNotNull();
    }

    @Test
    void getCategoryByCategoryName() {

    }
}