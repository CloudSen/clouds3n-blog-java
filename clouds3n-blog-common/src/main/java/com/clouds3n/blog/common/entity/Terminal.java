package com.clouds3n.blog.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.clouds3n.blog.common.SysCode;
import com.clouds3n.blog.common.service.dto.TerminalDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * <p>
 * web终端
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Terminal implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "uuid", type = IdType.ASSIGN_UUID)
    private String uuid;

    /**
     * 支持的组合键，多个用逗号隔开。"C,T,H"
     */
    private String supportedCombination;

    /**
     * 支持的命令，多个用逗号隔开。"home, clear"
     */
    private String supportedCommand;

    /**
     * 手机端的高度，默认420px
     */
    private String mobileHeight;

    /**
     * 非手机端的高度，默认500px
     */
    private String noneMobileHeight;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除【0正在使用，1已删除】
     */
    private Boolean deleted;

    public TerminalDto toDto() {
        return new TerminalDto()
            .setMobileHeight(this.mobileHeight)
            .setNoneMobileHeight(this.noneMobileHeight)
            .setSupportedCombination(
                StringUtils.isEmpty(this.supportedCombination) ?
                    null : Arrays.asList(this.supportedCombination.split(SysCode.COMMA))
            )
            .setSupportedCommand(
                StringUtils.isEmpty(this.supportedCommand) ?
                    null : Arrays.asList(this.supportedCommand.split(SysCode.COMMA))
            );
    }

}
