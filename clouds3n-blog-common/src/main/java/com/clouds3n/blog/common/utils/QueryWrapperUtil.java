package com.clouds3n.blog.common.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clouds3n.config.mybatisplus.query.QueryConditionDto;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author CloudS3n
 * @date 2020-01-12 19:51
 */
public class QueryWrapperUtil {

    public static <T> QueryWrapper<T> parseWhereSql(List<QueryConditionDto> conditionList, T type) throws IllegalAccessException {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        if (CollectionUtils.isNotEmpty(conditionList)) {
            conditionList.forEach(queryConditionDto -> queryConditionDto.setColumn(ColumnUtil.toDbColumn(queryConditionDto.getColumn())));
            for (QueryConditionDto queryCondition : conditionList) {
                switch (queryCondition.getQueryType()) {
                    case EQ:
                        queryWrapper.eq(queryCondition.getColumn(), queryCondition.getValue());
                        break;
                    case NE:
                        queryWrapper.ne(queryCondition.getColumn(), queryCondition.getValue());
                        break;
                    case LIKE:
                        queryWrapper.like(queryCondition.getColumn(), queryCondition.getValue());
                        break;
                    case LEFT_LIKE:
                        queryWrapper.likeLeft(queryCondition.getColumn(), queryCondition.getValue());
                        break;
                    case RIGHT_LIKE:
                        queryWrapper.likeRight(queryCondition.getColumn(), queryCondition.getValue());
                        break;
                    case NOT_LIKE:
                        queryWrapper.notLike(queryCondition.getColumn(), queryCondition.getValue());
                        break;
                    case GT:
                        queryWrapper.gt(queryCondition.getColumn(), queryCondition.getValue());
                        break;
                    case LT:
                        queryWrapper.lt(queryCondition.getColumn(), queryCondition.getValue());
                        break;
                    case GE:
                        queryWrapper.ge(queryCondition.getColumn(), queryCondition.getValue());
                        break;
                    case LE:
                        queryWrapper.le(queryCondition.getColumn(), queryCondition.getValue());
                        break;
                    default:
                        throw new IllegalAccessException("无法匹配查询类型");
                }
            }
        }
        return queryWrapper;
    }
}
