package com.clouds3n.blog.api.terminal.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author CloudS3n
 * @date 2020-04-25 19:53
 */
@Data
@Accessors(chain = true)
public class TerminalDto implements Serializable {

    private static final long serialVersionUID = 1532451398289671571L;
    private List<String> supportedCombination;
    private List<String> supportedCommand;
    private String mobileHeight;
    private String noneMobileHeight;
}
