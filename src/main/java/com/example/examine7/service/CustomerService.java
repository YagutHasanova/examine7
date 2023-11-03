package com.example.examine7.service;

import com.example.examine7.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> getAllCustomer();
    Customer getCustomerById(Long id);

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer,Long id);
}
