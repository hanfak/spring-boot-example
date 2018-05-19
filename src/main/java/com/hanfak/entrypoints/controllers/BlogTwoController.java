package com.hanfak.entrypoints.controllers;

import com.hanfak.core.domain.Blog;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BlogTwoController {

    private BlogUseCase blogUseCase;

    public BlogTwoController(BlogUseCase blogUseCase) {
        this.blogUseCase = blogUseCase;
    }

    @GetMapping("/blog2")
    public List<Blog> index() {
        return blogUseCase.fetchBlogs();
    }

    @GetMapping("/blog2/{id}")
    public Blog show(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        return blogUseCase.getBlogById(blogId);
    }

    @PostMapping("/blog2/search")
    public List<Blog> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return blogUseCase.searchBlogs(searchTerm);
    }

    @PostMapping("/blog2")
    public Blog create(@RequestBody Map<String, String> body) {
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String content = body.get("content");
        return blogUseCase.createBlog(id, title, content);
    }

    @PutMapping("/blog2/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int blogId = Integer.parseInt(id);
        String title = body.get("title");
        String content = body.get("content");
        return blogUseCase.updateBlog(blogId, title, content);
    }


    @DeleteMapping("blog2/{id}")
    public boolean delete(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        return blogUseCase.deleteBlog(blogId);
    }
}