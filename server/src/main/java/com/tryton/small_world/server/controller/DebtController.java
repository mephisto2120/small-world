package com.tryton.small_world.server.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class DebtController {

    @RequestMapping("/")
    public String index() {
        return "First endpoint!";
    }

    @GetMapping("/healthz")
    public ResponseEntity checkStatus() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Custom-Header", "Awesome");

        return ResponseEntity.ok().headers(httpHeaders).build();
    }
}
