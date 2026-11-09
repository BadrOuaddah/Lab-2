package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(service.getProduct(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
        return new ResponseEntity<>(service.addNewProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProduct(@PathVariable("id") Integer id) throws Exception {
        service.deleteProduct(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product) throws Exception {
        return new ResponseEntity<>(service.updateProduct(id, product), HttpStatus.OK);
    }

}
