package com.example.web.controller;

import com.example.web.entity.Product;
import com.example.web.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/{id}")
    Product getProductById(@PathVariable Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @GetMapping("/list")
    List<Product> listProduct() {
        return productRepository.findAll();
    }

    @PostMapping("/create")
    Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/delete")
    Boolean deleteProduct(@RequestParam Integer id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return false;
        }

        productRepository.delete(product);
        return true;
    }

    @PatchMapping("/update")
    Product updateProduct(@RequestBody Product product, @RequestParam Integer id) {
        Product product1 = productRepository.findById(id).orElse(null);
        if (product1 == null) {
            return null;
        }

        product.setId(id);
        return productRepository.save(product);
    }
}
