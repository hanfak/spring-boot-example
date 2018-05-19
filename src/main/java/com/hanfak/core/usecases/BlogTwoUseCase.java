package com.hanfak.core.usecases;

import com.hanfak.core.domain.Blog;
import com.hanfak.entrypoints.controllers.BlogUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.lang.String.format;

public class BlogTwoUseCase implements BlogUseCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(BlogTwoUseCase.class);

    private final BlogRepository blogRepository;

    public BlogTwoUseCase(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
    // Change some stuff
    @Override
    public List<Blog> fetchBlogs() {
        LOGGER.info("Getting all blogs");
        return blogRepository.fetchBlogs();
    }

    @Override
    public Blog getBlogById(int blogId) {
        LOGGER.info(format("Getting blog with id '%s'", blogId));
        return blogRepository.getBlogById(blogId);
    }

    @Override
    public List<Blog> searchBlogs(String searchTerm) {
        LOGGER.info(format("Getting blog(s) which include search term '%s'", searchTerm));
        return blogRepository.searchBlogs(searchTerm);
    }

    @Override
    public Blog createBlog(int id, String title, String content) {
        LOGGER.info(format("Creating new blog with id '%s', title '%s'", id, title));

        return blogRepository.createBlog(id + 10,title,content);
    }

    @Override
    public Blog updateBlog(int blogId, String title, String content) {
        LOGGER.info(format("Updating blog with id '%s'", blogId));

        return blogRepository.updateBlog(blogId,title,content);
    }

    @Override
    public boolean deleteBlog(int blogId) {
        LOGGER.info(format("Deleting blog with id '%s'", blogId));

        return blogRepository.deleteBlog(blogId);
    }
}
