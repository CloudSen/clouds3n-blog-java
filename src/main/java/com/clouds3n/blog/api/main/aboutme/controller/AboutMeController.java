package com.clouds3n.blog.api.main.aboutme.controller;


import com.clouds3n.blog.api.main.aboutme.service.IAboutMeService;
import com.clouds3n.blog.common.Res;
import com.clouds3n.blog.util.OptionalUtil;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 关于我 前端控制器
 * </p>
 *
 * @author CloudS3n
 * @since 2020-04-19
 */
@RestController
@RequestMapping("/aboutme/about-me")
public class AboutMeController {

    private final IAboutMeService aboutMeService;

    public AboutMeController(IAboutMeService aboutMeService) {
        this.aboutMeService = aboutMeService;
    }

    @GetMapping
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public Res getAboutMe() throws NotFoundException {
        return Res.ok(
            OptionalUtil.ofCollectionNullable(aboutMeService.list())
                .orElseThrow(() -> new NotFoundException("未找【到关于我】的数据"))
                .stream()
                .limit(1)
                .findFirst().get()
        );
    }
}
