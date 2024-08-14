package com.ordermanagement.productservice.service;

import com.ordermanagement.productservice.dto.ProductDto;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductByProductId(Long productId);
}
