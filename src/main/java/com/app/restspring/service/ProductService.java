package com.app.restspring.service;

import com.app.restspring.model.Product;
import com.app.restspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> listProducts(){
        return repository.findAll();
    }
    public void saveProduct(Product product){
        repository.save(product);
    }
    public Product getProductById(Integer id){
        return repository.findById(id).get();
    }
    public void deleteProduct(Integer id){
        repository.deleteById(id);
    }
}

