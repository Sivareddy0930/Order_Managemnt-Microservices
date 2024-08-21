package com.ordermanagement.customerservice.service.Impl;

import com.ordermanagement.customerservice.dto.ApiResponseDto;
import com.ordermanagement.customerservice.dto.CustomerDto;
import com.ordermanagement.customerservice.dto.ProductDto;
import com.ordermanagement.customerservice.entity.Customer;
import com.ordermanagement.customerservice.repositorty.CustomerRepository;
import com.ordermanagement.customerservice.service.APIClient;
import com.ordermanagement.customerservice.service.CustomerService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {


    private CustomerRepository customerRepository;

    private ModelMapper modelMapper;

//    private RestTemplate restTemplate;

    private WebClient webClient;

//    private final APIClient apiClient;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        Customer customer = modelMapper.map(customerDto, Customer.class);

        Customer savedCustomer = customerRepository.save(customer);

        CustomerDto savedCustomerDto = modelMapper.map(savedCustomer, CustomerDto.class);

        return savedCustomerDto;
    }




//    @CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultProduct")
    @Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultProduct")
    @Override
    public ApiResponseDto getCustomerById(Long customerId) {

        log.info("Inside getCustomerById method");

        Customer customer = customerRepository.findByCustomerId(customerId).orElseThrow();

        CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);

//        get product using RestTemplate

//        ResponseEntity<ProductDto> productDtoEntity = restTemplate.getForEntity("http://localhost:9090/api/products/getProductById/" + customer.getProductId(), ProductDto.class);
//        ProductDto productDto = productDtoEntity.getBody();


//        get product using WebClient

        ProductDto productDto = webClient.get()
                .uri("http://localhost:9090/api/products/getProductById/" + customer.getProductId())
                .retrieve()
                .bodyToMono(ProductDto.class)
                .block();

//        ProductDto productDto = apiClient.getProductByProductId(customer.getProductId());


        ApiResponseDto apiResponseDto =new ApiResponseDto();
        apiResponseDto.setCustomer(customerDto);
        apiResponseDto.setProduct(productDto);


        return apiResponseDto;
    }



    public ApiResponseDto getDefaultProduct(Long customerId,Exception exception) {

        log.info("Inside getDefaultProduct method");
        Customer customer = customerRepository.findByCustomerId(customerId).orElseThrow();

        CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);

        ProductDto productDto =new ProductDto();
        productDto.setProductId(1111l);
        productDto.setProductName("DefaultProduct");
        productDto.setProductPrice(10000.00);


        ApiResponseDto apiResponseDto =new ApiResponseDto();
        apiResponseDto.setCustomer(customerDto);
        apiResponseDto.setProduct(productDto);


        return apiResponseDto;
    }
}
