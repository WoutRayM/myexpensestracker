package be.giantoaf.myexpensestracker.repository;

import be.giantoaf.myexpensestracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category getCategoryByNameEquals(String categoryName);

}
