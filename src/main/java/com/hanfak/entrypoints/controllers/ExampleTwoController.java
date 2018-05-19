package com.hanfak.entrypoints.controllers;

import com.hanfak.core.domain.Blog;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

import static org.springframework.util.MimeTypeUtils.TEXT_HTML;

@Controller
public class ExampleTwoController {

    private final BlogRepository blogRepository;

    public ExampleTwoController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @RequestMapping(value = "/blah1", method =  RequestMethod.GET, headers = { "key1=val1", "key2=val2" })
    public ResponseEntity<List<Blog>> headers(){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, TEXT_HTML.toString());
        headers.add("Tracey", UUID.randomUUID().toString());

        return new ResponseEntity<>(blogRepository.fetchBlogs(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/blah", method =  RequestMethod.GET, headers = "key1=val1")
    public ResponseEntity<List<Blog>> index(){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        headers.add("Tracey", UUID.randomUUID().toString());

        return ResponseEntity.
                status(200).
                headers(headers).
                contentType(MediaType.APPLICATION_JSON_UTF8).
                body(blogRepository.fetchBlogs());
    }
}