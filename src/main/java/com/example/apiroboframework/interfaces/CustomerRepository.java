package com.example.apiroboframework.interfaces;

import com.example.apiroboframework.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
