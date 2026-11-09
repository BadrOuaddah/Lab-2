package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getProducts() {
        List<Product> products = repository.findAll();
        return products;
    }

    public Product getProduct(Integer id) {
        Product product = repository.findById(id).get();
        return product;
    }

    public Product addNewProduct(Product product) {
        Product save = repository.save(product);
        return save;
    }

    public Product updateProduct(Integer id, Product product) throws Exception {
        repository.findById(id).orElseThrow(() -> new Exception("Product not found with id : " + id));
        product.setId(id);
        Product updated = repository.save(product);
        return updated;
    }

    public void deleteProduct(Integer id) throws Exception {
        repository.deleteById(id);
    }

}
