package com.clouds3n.blog.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.clouds3n.blog.common.entity.Encouragement;
import com.clouds3n.blog.common.mapper.EncouragementMapper;
import com.clouds3n.blog.common.service.IEncouragementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

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

    @Override
    public Encouragement randomGetOne() {
        List<Encouragement> allEncouragements = this.list();
        int randomIndex = new Random().ints(0, allEncouragements.size())
            .limit(1).findFirst().orElse(0);
        return allEncouragements.get(randomIndex);
    }
}
