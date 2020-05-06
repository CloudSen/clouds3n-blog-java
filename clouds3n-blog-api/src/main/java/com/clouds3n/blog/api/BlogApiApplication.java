package com.clouds3n.blog.api;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 博客API应用
 *
 * @author CloudS3n
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@ComponentScan("com.clouds3n.*")
public class BlogApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApiApplication.class, args);
    }

}
