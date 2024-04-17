package com.orange.formation.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.orange.formation.models.Customer;
import com.orange.formation.models.CustomersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/customers/{msisdn}")
    public ResponseEntity<Customer> getCustomerByMsisdn(@PathVariable String msisdn) {
        Customer c = custoRepo.findByMsisdn(msisdn);
        if (c != null)
            return new ResponseEntity<>(c, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> insertCustomer(@RequestBody Customer c) {
        custoRepo.save(c);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

}
