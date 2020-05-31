package com.clouds3n.blog.dashboard.monitor.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author CloudS3n
 * @date 2020-05-31 14:03
 */
@Data
@Accessors(chain = true)
public class MonitorCardDto implements Serializable {

    private static final long serialVersionUID = -3355698833573980148L;
    private String type;
    private String name;
    private Long count;
    private String url;
    private String color;
    private String textColor;
}
