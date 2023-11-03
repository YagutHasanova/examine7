package com.example.examine7.service;

import com.example.examine7.entity.Customer;
import com.example.examine7.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Primary
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("This id not found :" + id));

    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) {
     Customer customerENtity= customerRepository.findById(id).orElseThrow(() -> new RuntimeException("This id not found :" + id));
        if (customerENtity!=null){
            customerENtity.setFirstName(customer.getFirstName());
            customerENtity.setLastName(customer.getLastName());
            customerENtity.setEmail(customer.getEmail());
            customerENtity.setId(customer.getId());
            customerRepository.save(customerENtity);
        }
        return null;
    }



}
