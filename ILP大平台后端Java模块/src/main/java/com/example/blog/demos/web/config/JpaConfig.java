package com.example.blog.demos.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.blog.Dao")
public class JpaConfig {
    // JPA配置代码
}
