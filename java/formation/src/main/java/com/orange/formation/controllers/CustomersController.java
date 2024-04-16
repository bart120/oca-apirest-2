package com.orange.formation.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CustomersController {

    @GetMapping("/customers")
    public List<Object> getCustomers() {
        return new ArrayList<>();
    }

}
