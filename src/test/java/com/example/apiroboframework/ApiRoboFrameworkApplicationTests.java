package com.example.apiroboframework;

import com.example.apiroboframework.controller.RetrieveCustomers;
import com.example.apiroboframework.model.Customer;
import com.example.apiroboframework.model.CustomerDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = ApiRoboFrameworkApplication.class)
class ApiRoboFrameworkApplicationTests {
    @Autowired
    RetrieveCustomers retrieveCustomers;
    ModelMapper modelMapper = new ModelMapper();
    @Test
    void contextLoads() {
        List<Customer> customers = retrieveCustomers.retrieveAllCustomers();
        Assertions.assertNotNull(customers);



    }
    @Test
    void insertCustomer() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname("John");
        customerDTO.setLastname("Doe");
        customerDTO.setEmail("alassan3@gmail.com");
        modelMapper.map(customerDTO, Customer.class);
       // modelMapper.map(customer, customerDTO);
        Assertions.assertNotNull(retrieveCustomers.insertCustomer(customerDTO));

    }
}
