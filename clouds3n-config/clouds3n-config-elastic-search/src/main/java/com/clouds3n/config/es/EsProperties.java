package com.clouds3n.config.es;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author CloudS3n
 * @date 2020-05-08 21:18
 */
@Data
@Configuration
@ConfigurationProperties("clouds3n.elastic-search")
public class EsProperties {

    @NotNull
    @NotEmpty
    private List<String> addresses;

    @NotNull
    @Range(max = Integer.MAX_VALUE)
    private Integer restPort;

    @NotNull
    @Range(max = Integer.MAX_VALUE)
    private Integer commPort;

    @NotNull
    private Boolean enableSniff;

    @NotEmpty
    private String clusterName;
}
