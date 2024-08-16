package com.ordermanagement.productservice.controller;

import com.ordermanagement.productservice.dto.ProductDto;
import com.ordermanagement.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto savedProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/getProductById/{PID}")
    public ResponseEntity<ProductDto> getProductByProductId(@PathVariable("PID") Long productId){
        ProductDto productDto = productService.getProductByProductId(productId);
        return ResponseEntity.ok(productDto);
    }
}
