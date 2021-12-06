package com.example.demotastdb.controller;

import com.example.demotastdb.entity.Product;
import com.example.demotastdb.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequestMapping({"/api/v1/products"})
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public  List<Product> getAll(){
        return productService.findAll();
    }

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.createOrUpdate(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id) {

        Optional<Product> product = productService.findById(id);

        if (!product.isPresent()) {
            log.error("Product with id " + id + " does not exist.");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product.get());
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Product> update(@PathVariable long id, @Valid @RequestBody Product product) {

        Optional<Product> p = productService.findById(id);

        if (!p.isPresent()) {
            log.error("Product with id " + id + " does not exist.");
            return ResponseEntity.notFound().build();
        }

        p.get().setName(product.getName());
        p.get().setPrice(product.getPrice());
        p.get().setDescription(product.getDescription());

        return ResponseEntity.ok(productService.createOrUpdate(p.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable long id) {
        Optional<Product> p = productService.findById(id);

        if (!p.isPresent()) {
            log.error("Product with id " + id + " does not exist.");
            return ResponseEntity.notFound().build();
        }

        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
