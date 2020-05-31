package com.clouds3n.blog.dashboard.monitor.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author CloudS3n
 * @date 2020-05-31 16:29
 */
@Data
@Accessors(chain = true)
public class TagPieDataDto implements Serializable {

    private static final long serialVersionUID = 4908838156126917508L;
    private String name;
    private Long value;
}
