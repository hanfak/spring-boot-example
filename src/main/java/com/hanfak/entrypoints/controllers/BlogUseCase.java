package com.hanfak.entrypoints.controllers;

import com.hanfak.core.domain.Blog;

import java.util.List;

public interface BlogUseCase {

    List<Blog> fetchBlogs();

    Blog getBlogById(int blogId);

    List<Blog> searchBlogs(String searchTerm);

    Blog createBlog(int id, String title, String content);

    Blog updateBlog(int blogId, String title, String content);

    boolean deleteBlog(int blogId);
}
