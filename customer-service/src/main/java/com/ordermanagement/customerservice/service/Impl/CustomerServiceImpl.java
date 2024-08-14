package com.ordermanagement.customerservice.service.Impl;

import com.ordermanagement.customerservice.dto.CustomerDto;
import com.ordermanagement.customerservice.entity.Customer;
import com.ordermanagement.customerservice.repositorty.CustomerRepository;
import com.ordermanagement.customerservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {


    private CustomerRepository customerRepository;

    private ModelMapper modelMapper;

    private RestTemplate restTemplate;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        Customer customer = modelMapper.map(customerDto, Customer.class);

        Customer savedCustomer = customerRepository.save(customer);

        CustomerDto savedCustomerDto = modelMapper.map(savedCustomer, CustomerDto.class);

        return savedCustomerDto;
    }

    @Override
    public CustomerDto getCustomerById(Long customerId) {
        Customer customer = customerRepository.findByCustomerId(customerId).orElseThrow();

        restTemplate.getForEntity()

        CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);


        return customerDto;
    }
}
