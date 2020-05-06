package com.clouds3n.blog.dashboard;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 博客管理系统
 *
 * @author CloudS3n
 * @date 2020-05-07 0:08
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@ComponentScan("com.clouds3n.*")
public class BlogDashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogDashboardApplication.class, args);
    }
}
