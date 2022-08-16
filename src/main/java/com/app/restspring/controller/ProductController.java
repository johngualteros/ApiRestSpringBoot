package com.app.restspring.controller;

import com.app.restspring.model.Product;
import com.app.restspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> products(){
        return productService.listProducts();
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id){
        try{
            Product product = productService.getProductById(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/products")
    public void saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product,@PathVariable Integer id){
        try{
            Product productExists = productService.getProductById(id);
            productExists.setName(product.getName());
            productExists.setPrice(product.getPrice());
            productService.saveProduct(productExists);
            return new ResponseEntity<Product>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }
}
