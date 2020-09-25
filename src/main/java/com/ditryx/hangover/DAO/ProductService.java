package com.ditryx.hangover.DAO;

import com.ditryx.hangover.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById (long id);
    void save(Product product);
    void delete(long id);
    Product findByType(String whiskeyType);

}
