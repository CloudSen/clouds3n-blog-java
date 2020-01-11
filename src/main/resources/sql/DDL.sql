CREATE TABLE `encouragement`
(
    `uuid`        VARCHAR(32)  NOT NULL COMMENT 'UUID-32',
    `content`     VARCHAR(500) NOT NULL COMMENT '短语',
    `create_time` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`     TINYINT(1)   NOT NULL DEFAULT 0 COMMENT '是否已删除，0否，1是',
    PRIMARY KEY (`uuid`)
)
    COMMENT ='励志短语'
    COLLATE = 'utf8_general_ci'
;
