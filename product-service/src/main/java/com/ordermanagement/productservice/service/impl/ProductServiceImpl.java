package com.ordermanagement.productservice.service.impl;

import com.ordermanagement.productservice.dto.ProductDto;
import com.ordermanagement.productservice.entity.Product;
import com.ordermanagement.productservice.repository.ProductRepository;
import com.ordermanagement.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private ModelMapper modelMapper;


    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product = modelMapper.map(productDto, Product.class);

        Product savedProduct = productRepository.save(product);

        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);

        return savedProductDto;
    }

    @Override
    public ProductDto getProductByProductId(Long productId) {
        Product product = productRepository.findByProductId(productId).orElseThrow();
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }
}
