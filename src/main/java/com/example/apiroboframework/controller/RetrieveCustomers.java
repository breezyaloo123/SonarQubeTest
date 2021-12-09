package com.example.apiroboframework.controller;

import com.example.apiroboframework.interfaces.CustomerRepository;
import com.example.apiroboframework.model.Customer;
import com.example.apiroboframework.model.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class RetrieveCustomers {

    @Autowired
    private CustomerRepository customerRepository;

    private static final ModelMapper modelMapper = new ModelMapper();



    @GetMapping(path = "/customers")
    public List<Customer> retrieveAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping(path = "/insertCustomer")
    public @ResponseBody Customer insertCustomer(@RequestBody CustomerDTO customer) {
        Customer newCustomer = modelMapper.map(customer, Customer.class);
        return customerRepository.save(newCustomer);
    }
    @DeleteMapping(path = "/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable(value = "id") int id) {
        customerRepository.deleteById(id);
    }

    @PutMapping(path = "/updateCustomer/{id}")
    public String updateCustomer(@PathVariable() int id,@RequestBody CustomerDTO customer) {
            String src = "";
        Optional<Customer> customer1 = customerRepository.findById(id);
        if (customer1.isPresent()) {
            Customer c = customer1.get();
            c.setFirstname(customer.getFirstname());
            c.setLastname(customer.getLastname());
            c.setEmail(customer.getEmail());
            Customer newCustomer = modelMapper.map(c, Customer.class);
            customerRepository.save(newCustomer);
            return "Customer updated successfully";
        }

        return "Customer update failed";

    }

}