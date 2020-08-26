package com.tryton.small_world.server;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class DebtController {

    @RequestMapping("/")
    public String index() {
        return "First endpoint!";
    }
}
