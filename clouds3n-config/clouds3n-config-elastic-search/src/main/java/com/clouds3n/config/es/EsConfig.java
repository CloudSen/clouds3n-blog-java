package com.clouds3n.config.es;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.stream.Collectors;

/**
 * @author CloudS3n
 * @date 2019/11/28 17:02
 */
@Slf4j
@Configuration
public class EsConfig {

    private final EsProperties properties;
    public static final String ES_PROPERTIES_DETAIL = "[ ES ] 配置参数: {}";
    public static final String CLIENT_TRANSPORT_SNIFF = "client.transport.sniff";
    public static final String CLUSTER_NAME = "cluster.name";

    public EsConfig(EsProperties properties) {
        this.properties = properties;
        log.info(ES_PROPERTIES_DETAIL, this.properties);
    }

    private static InetAddress apply(String s) {
        try {
            return InetAddress.getByName(s);
        } catch (UnknownHostException e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return null;
    }

    @Bean
    public Client transportClient() {
        Settings settings = Settings.builder()
            .put(CLIENT_TRANSPORT_SNIFF, properties.getEnableSniff())
            .put(CLUSTER_NAME, properties.getClusterName())
            .build();
        TransportAddress[] transportAddresses = properties.getAddresses().stream()
            .map(EsConfig::apply)
            .map(iNetAddress -> new TransportAddress(iNetAddress, properties.getCommPort()))
            .collect(Collectors.toList()).toArray(new TransportAddress[properties.getAddresses().size()]);
        return new PreBuiltTransportClient(settings)
            .addTransportAddresses(transportAddresses);
    }

}
