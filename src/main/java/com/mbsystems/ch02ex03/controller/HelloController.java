package com.mbsystems.ch02ex03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/basil3")
    public String hello() {
        return "basil03";
    }
}
