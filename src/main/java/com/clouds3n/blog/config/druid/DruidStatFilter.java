package com.clouds3n.blog.config.druid;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author CloudS3n
 * @date 2020-01-12 4:31
 */
@WebFilter(
    filterName = "druidWebStatFilter", urlPatterns = "/*",
    initParams = {@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")}
)
public class DruidStatFilter extends WebStatFilter {
}
