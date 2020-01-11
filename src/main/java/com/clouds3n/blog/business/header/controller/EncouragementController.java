package com.clouds3n.blog.business.header.controller;


import com.clouds3n.blog.business.header.service.IEncouragementService;
import com.clouds3n.blog.common.Res;
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
    public Res listAll() {
        return Res.ok(encouragementService.list());
    }
}
