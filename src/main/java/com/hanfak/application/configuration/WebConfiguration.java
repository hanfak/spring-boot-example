package com.hanfak.application.configuration;

import com.hanfak.entrypoints.exception.GlobalResponseEntityExceptionHandler;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
        @Bean
        public EmbeddedServletContainerCustomizer containerCustomizer() {
            return (container -> container.setPort(8012));
        }

    @Bean
    public GlobalResponseEntityExceptionHandler globalResponseEntityExceptionHandler() {
        return new GlobalResponseEntityExceptionHandler();
    }
}
