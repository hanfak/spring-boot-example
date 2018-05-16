package com.hanfak.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BlogController {
    @RequestMapping(value = "/", method = GET)
    public String index() {
        return "You have reached the blog controller";
    }

    @GetMapping(value="/hello")
    public String helloIndex() {
        return "You have reached the blog controller, hello endpoint";
    }

    @RequestMapping(value = "/ex/foos/{id}", method = GET)
    public String getFoosBySimplePathWithPathVariable(
            @PathVariable("id") long id) {
        return "Get a specific Foo with id=" + id;
    }

    @RequestMapping(value = "/ex/foos/{id}/{name}", method = GET)
    public String getMorePathVar(@PathVariable("id") long id, @PathVariable("name") String name) {
        return "Get a specific Foo with id=" + id + " and name: " + name;
    }
}