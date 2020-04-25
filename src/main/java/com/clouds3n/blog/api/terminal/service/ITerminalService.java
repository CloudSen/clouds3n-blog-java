package com.clouds3n.blog.api.terminal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clouds3n.blog.api.terminal.dto.TerminalDto;
import com.clouds3n.blog.api.terminal.entity.Terminal;

/**
 * <p>
 * web终端 服务类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-25
 */
public interface ITerminalService extends IService<Terminal> {

    /**
     * 获取web终端参数
     *
     * @return TerminalDto
     */
    TerminalDto getTerminalData();
}
