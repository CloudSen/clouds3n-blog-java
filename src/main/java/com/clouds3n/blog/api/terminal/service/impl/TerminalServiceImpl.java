package com.clouds3n.blog.api.terminal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.api.terminal.dto.TerminalDto;
import com.clouds3n.blog.api.terminal.entity.Terminal;
import com.clouds3n.blog.api.terminal.mapper.TerminalMapper;
import com.clouds3n.blog.api.terminal.service.ITerminalService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>
 * web终端 服务实现类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-25
 */
@Service
public class TerminalServiceImpl extends ServiceImpl<TerminalMapper, Terminal> implements ITerminalService {

    @Override
    public TerminalDto getTerminalData() {
        LambdaQueryWrapper<Terminal> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Terminal::getDeleted, 0);
        Terminal terminal = Optional.ofNullable(getOne(wrapper))
            .orElseThrow(() -> new IllegalArgumentException("请配置web终端参数"));
        return terminal.toDto();
    }
}
