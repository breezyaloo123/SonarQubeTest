package com.example.apiroboframework;

import com.example.apiroboframework.controller.RetrieveCustomers;
import com.example.apiroboframework.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = ApiRoboFrameworkApplication.class)
class ApiRoboFrameworkApplicationTests {
    @Autowired
    RetrieveCustomers retrieveCustomers;
    @Test
    void contextLoads() {
        List<Customer> customers = retrieveCustomers.retrieveAllCustomers();
        Assertions.assertNotNull(customers);



    }
}
