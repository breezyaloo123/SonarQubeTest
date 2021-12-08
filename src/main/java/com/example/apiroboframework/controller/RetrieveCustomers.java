package com.example.apiroboframework.controller;

import com.example.apiroboframework.interfaces.CustomerRepository;
import com.example.apiroboframework.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RetrieveCustomers {

@Autowired
    private CustomerRepository customerRepository;

@GetMapping(path = "/customers")
    public List<Customer> retrieveAllCustomers(){
    return customerRepository.findAll();
}
@GetMapping(path = "/customers/{id}")
    public String retrieveCustomer(@PathVariable Integer id){
    String res = "";
    if(customerRepository.existsById(id)){
    return customerRepository.findById(id).isPresent()
            ? customerRepository.getById(id).getFirstname()
            +" " +customerRepository.getById(id).getLastname(): "";
}

    return "Customer not found";
}
}
