package com.clouds3n.config.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author CloudS3n
 * @date 2020-05-08 21:12
 */
@Data
@Validated
@Configuration
@ConfigurationProperties(prefix = "clouds3n.system")
public class SystemProperties {

    @NotBlank
    private String druidUsername;
    @NotBlank
    private String druidPassword;
    @NotNull
    private String druidResettable;
    @NotBlank
    private String druidAllowIps;
}
