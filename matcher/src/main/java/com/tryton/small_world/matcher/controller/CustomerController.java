package com.tryton.small_world.matcher.controller;

import com.tryton.small_world.matcher.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getInfo() {
        Customer customer = Customer.builder()
            .customerId(123L)
            .createdDate(LocalDateTime.now())
            .lastModified(LocalDateTime.now())
            .build();
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }
}
