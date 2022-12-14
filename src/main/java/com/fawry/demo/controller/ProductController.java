package com.fawry.demo.controller;

import com.fawry.demo.repository.entity.Product;
import com.fawry.demo.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;


    @GetMapping()
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
    @GetMapping("sorted-product")
    public ResponseEntity<List<?>> getProductsByPopularity(){
        return new ResponseEntity<>(productService.getProductsByPopularity(), HttpStatus.OK);
    }

    @GetMapping(path = "{productId}")
    public ResponseEntity<?> getProduct(@PathVariable("productId") @Min(value = 1, message = "enter valid number") Long productId){
        return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
    }

    @PutMapping(path = "{productId}")
    public ResponseEntity<?> updateProducts(@PathVariable Long productId, @RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(productId, product), HttpStatus.OK);
    }

    @DeleteMapping(path = "{productId}")
    public ResponseEntity<?> deleteProducts(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
