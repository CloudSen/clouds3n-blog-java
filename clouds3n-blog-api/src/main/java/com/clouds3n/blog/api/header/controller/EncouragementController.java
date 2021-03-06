package com.clouds3n.blog.api.header.controller;


import com.clouds3n.blog.common.dto.Res;
import com.clouds3n.blog.common.service.IEncouragementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 励志短语 前端控制器
 * </p>
 *
 * @author CloudS3n
 * @since 2020-01-12
 */
@RestController
@RequestMapping("/header/encouragement")
public class EncouragementController {

    private final IEncouragementService encouragementService;

    public EncouragementController(IEncouragementService encouragementService) {
        this.encouragementService = encouragementService;
    }

    @GetMapping
    public Res randomGetOne() {
        return Res.ok(encouragementService.randomGetOne());
    }

    @GetMapping("/all")
    public Res listAll() {
        return Res.ok(encouragementService.list());
    }
}
