package com.clouds3n.config.core.druid;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.clouds3n.config.core.properties.SystemProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CloudS3n
 * @date 2020-01-12 4:33
 */
@Configuration
public class DruidConfig {

    private static final String URL_MAPPING = "/druid/*";
    private static final String EXCLUSIONS = "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*";
    private static final String URL_PATTERNS = "/*";
    private static final String PARA_EXCLUSIONS = "exclusions";

    /**
     * 注册一个StatViewServlet
     *
     * @return ServletRegistrationBean
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidStatViewServlet(SystemProperties systemProperties) {
        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), URL_MAPPING);
        //白名单
        servletRegistrationBean.addInitParameter("allow", systemProperties.getDruidAllowIps());
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername", systemProperties.getDruidUsername());
        servletRegistrationBean.addInitParameter("loginPassword", systemProperties.getDruidPassword());
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", systemProperties.getDruidResettable());
        return servletRegistrationBean;
    }

    /**
     * 注册一个：filterRegistrationBean
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> druidStatFilter() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns(URL_PATTERNS);
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter(PARA_EXCLUSIONS, EXCLUSIONS);
        return filterRegistrationBean;
    }
}
