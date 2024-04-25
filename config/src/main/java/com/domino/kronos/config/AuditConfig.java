package com.domino.kronos.config;

import com.domino.kronos.config.audit.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;

@Configuration
@EnableReactiveMongoAuditing(auditorAwareRef = "auditorProvider")
public class AuditConfig {
    @Bean
    public ReactiveAuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }
}
