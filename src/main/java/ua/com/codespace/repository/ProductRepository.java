package ua.com.codespace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.codespace.model.Product;

/**
 * Created by devT on 08.01.2017.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
