package com.hanfak.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "You have reached the blog controller";
    }

    @GetMapping(value="/hello")
    public String helloIndex() {
        return "You have reached the blog controller, hello endpoint";
    }
}