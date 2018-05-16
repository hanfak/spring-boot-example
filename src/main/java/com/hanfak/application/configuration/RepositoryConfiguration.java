package com.hanfak.application.configuration;

import com.hanfak.dataproviders.repository.BlogInMemoryRepository;
import com.hanfak.entrypoints.controllers.BlogRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public BlogRepository blogRepository() {
        return new BlogInMemoryRepository();
    }
}
