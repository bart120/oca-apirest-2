package com.orange.formation.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.orange.formation.models.Customer;
import com.orange.formation.models.CustomersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CustomersController {

    @Autowired
    CustomersRepository custoRepo;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        List<Customer> customers = custoRepo.findAll();
        return customers;
    }

    @PostMapping("/customers")
    public Customer insertCustomer(@RequestBody Customer c) {
        custoRepo.save(c);
        return c;
    }

}
