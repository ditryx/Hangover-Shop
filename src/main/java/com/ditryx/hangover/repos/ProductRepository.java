package com.ditryx.hangover.repos;

import com.ditryx.hangover.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductById(long id);

    Product findProductByWhiskeyType(String whiskeyType);

    void deleteProductById(long id);

}
