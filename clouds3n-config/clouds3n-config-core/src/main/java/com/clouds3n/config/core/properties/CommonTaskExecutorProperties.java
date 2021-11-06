package com.clouds3n.config.core.properties;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

/**
 * @author CloudS3n
 * @date 2019/12/6 15:53
 */
@Validated
@Data
@Configuration
@ConfigurationProperties(prefix = "clouds3n.thread-pool.common-executor")
public class CommonTaskExecutorProperties {

    @NotBlank
    private String threadNamePrefix;

    @Range(min = 1, max = Integer.MAX_VALUE)
    private Integer corePoolSize;

    @Range(min = 1, max = Integer.MAX_VALUE)
    private Integer maxPoolSize;

    @Range(min = 1, max = Integer.MAX_VALUE)
    private Integer queueCapacity;

    private Boolean allowCoreThreadTimeOut;

    @Range(min = 30, max = Integer.MAX_VALUE)
    private Integer keepAliveSeconds;
}
