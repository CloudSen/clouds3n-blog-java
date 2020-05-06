package com.clouds3n.blog.api.terminal.controller;


import com.clouds3n.blog.common.dto.Res;
import com.clouds3n.blog.common.service.ITerminalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * web终端 前端控制器
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-25
 */
@RestController
@RequestMapping("/terminal")
public class TerminalController {

    private final ITerminalService terminalService;

    public TerminalController(ITerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @GetMapping("")
    public Res getTerminalData() {
        return Res.ok(terminalService.getTerminalData());
    }
}
