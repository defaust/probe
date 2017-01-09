package ua.com.codespace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.codespace.model.Category;

/**
 * Created by devT on 08.01.2017.
 */
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
