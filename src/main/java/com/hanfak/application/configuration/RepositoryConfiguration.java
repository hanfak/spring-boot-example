package com.hanfak.application.configuration;

import com.hanfak.core.usecases.BlogRepository;
import com.hanfak.dataproviders.repository.BlogInMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public BlogRepository blogRepository() {
        return new BlogInMemoryRepository();
    }
}
