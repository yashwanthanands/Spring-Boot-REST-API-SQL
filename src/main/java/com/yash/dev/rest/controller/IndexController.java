package com.yash.dev.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String welcome() {
        return "Hi!!! \n Welcome to the Yash-Micro-Notes App. You can create a new Note by making a POST requests";
    }
}