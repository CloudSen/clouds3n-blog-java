package com.clouds3n.blog.business.header.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.business.header.entity.Encouragement;
import com.clouds3n.blog.business.header.mapper.EncouragementMapper;
import com.clouds3n.blog.business.header.service.IEncouragementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 励志短语 服务实现类
 * </p>
 *
 * @author CloudS3n
 * @since 2020-01-12
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EncouragementServiceImpl extends ServiceImpl<EncouragementMapper, Encouragement> implements IEncouragementService {

}
