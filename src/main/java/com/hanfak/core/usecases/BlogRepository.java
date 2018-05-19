package com.hanfak.core.usecases;

import com.hanfak.core.domain.Blog;

import java.util.List;

public interface BlogRepository {
    // return all blogs
    List<Blog> fetchBlogs();

    // return blog by id
    Blog getBlogById(int id);

    // search blog by text
    List<Blog> searchBlogs(String searchTerm);

    // create blog
    Blog createBlog(int id, String title, String content);

    // update blog
    Blog updateBlog(int id, String title, String content);

    // delete blog by id
    boolean deleteBlog(int id);
}