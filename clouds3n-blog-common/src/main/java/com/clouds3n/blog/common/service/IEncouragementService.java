package com.clouds3n.blog.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.clouds3n.blog.common.entity.Encouragement;

/**
 * <p>
 * 励志短语 服务类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-01-12
 */
public interface IEncouragementService extends IService<Encouragement> {

    /**
     * 随机获取一个励志短语
     *
     * @return 励志短语
     */
    Encouragement randomGetOne();
}
