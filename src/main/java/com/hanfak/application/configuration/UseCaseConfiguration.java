package com.hanfak.application.configuration;

import com.hanfak.core.usecases.BlogRepository;
import com.hanfak.core.usecases.BlogTwoUseCase;
import com.hanfak.entrypoints.controllers.BlogUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    public BlogUseCase blogUseCase(BlogRepository blogRepository) {
        return new BlogTwoUseCase(blogRepository);
    }
}
