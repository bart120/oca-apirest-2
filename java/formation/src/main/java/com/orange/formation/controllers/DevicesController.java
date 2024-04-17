package com.orange.formation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orange.formation.models.Device;
import com.orange.formation.models.DevicesRepository;

@RestController
public class DevicesController {

    @Autowired
    DevicesRepository devRepo;

    @GetMapping("/devices")
    public ResponseEntity<List<Device>> getDevices(@RequestParam int customerid) {
        List<Device> liste = devRepo.findAllByCustomerId(customerid);
        return new ResponseEntity<>(liste, HttpStatus.OK);

    }

    @PostMapping("/devices")
    public ResponseEntity<Device> insertDevice(@RequestBody Device d) {
        devRepo.save(d);
        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }
}
