package com.ditryx.hangover.DAO.Implementation;

import com.ditryx.hangover.DAO.ProductService;
import com.ditryx.hangover.entities.Product;
import com.ditryx.hangover.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(final ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public void save(Product product) {
       productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        productRepository.deleteProductById(id);
    }

    @Override
    public Product findByType(String whiskeyType) {
        return productRepository.findProductByWhiskeyType(whiskeyType);
    }


}
