package com.clouds3n.blog.config.transaction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author CloudS3n
 * @date 2020-01-12 2:14
 */
@Configuration
@EnableTransactionManagement
public class TransactionConfig {
    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager getMybatisTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
