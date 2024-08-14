package com.ordermanagement.customerservice.service.Impl;

import com.ordermanagement.customerservice.dto.ApiResponseDto;
import com.ordermanagement.customerservice.dto.CustomerDto;
import com.ordermanagement.customerservice.dto.ProductDto;
import com.ordermanagement.customerservice.entity.Customer;
import com.ordermanagement.customerservice.repositorty.CustomerRepository;
import com.ordermanagement.customerservice.service.APIClient;
import com.ordermanagement.customerservice.service.CustomerService;
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

    private final APIClient apiClient;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        Customer customer = modelMapper.map(customerDto, Customer.class);

        Customer savedCustomer = customerRepository.save(customer);

        CustomerDto savedCustomerDto = modelMapper.map(savedCustomer, CustomerDto.class);

        return savedCustomerDto;
    }

    @Override
    public ApiResponseDto getCustomerById(Long customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId).orElseThrow();

        CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);

//        get product using RestTemplate

//        ResponseEntity<ProductDto> productDtoEntity = restTemplate.getForEntity("http://localhost:9090/api/products/getProductById/" + customer.getProductId(), ProductDto.class);
//        ProductDto productDto = productDtoEntity.getBody();


//        get product using WebClient

//        ProductDto productDto = webClient.get()
//                .uri("http://localhost:9090/api/products/getProductById/" + customer.getProductId())
//                .retrieve()
//                .bodyToMono(ProductDto.class)
//                .block();

        ProductDto productDto = apiClient.getProductByProductId(customer.getProductId());


        ApiResponseDto apiResponseDto =new ApiResponseDto();
        apiResponseDto.setCustomer(customerDto);
        apiResponseDto.setProduct(productDto);


        return apiResponseDto;
    }
}
