package com.hanfak.entrypoints.controllers;

import com.hanfak.core.domain.Blog;

import java.util.List;

public interface BlogRepository {
    // return all blogs
    List<Blog> fetchBlogs();
}