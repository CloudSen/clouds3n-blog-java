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

CREATE TABLE `datasource`
(
    `uuid`                VARCHAR(32)  NOT NULL COMMENT 'uuid-32',
    `poll_name`           VARCHAR(32)  NOT NULL COMMENT '数据源名',
    `user_name`           VARCHAR(32)  NOT NULL COMMENT '用户名',
    `password`            VARCHAR(100) NOT NULL COMMENT '密码',
    `driver_class_name`   VARCHAR(100) NOT NULL COMMENT '驱动完整包名',
    `url`                 VARCHAR(300) NOT NULL COMMENT '数据库地址',
    `druid_properties_id` VARCHAR(32)  NOT NULL COMMENT 'Druid参数ID',
    `create_time`         DATETIME     NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
    `update_time`         DATETIME     NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新时间',
    `deleted`             TINYINT(1)   NOT NULL DEFAULT 0 COMMENT '0未删除，1已删除',
    PRIMARY KEY (`uuid`)
)
    COMMENT ='动态数据源'
    COLLATE = 'utf8_general_ci'
    ENGINE = InnoDB
;



CREATE TABLE `druid_properties`
(
    `uuid`             VARCHAR(32)  NOT NULL,
    `initial_size`     INT(11)      NOT NULL COMMENT '初始化大小',
    `max_active`       INT(11)      NOT NULL COMMENT '最大连接数',
    `min_idle`         INT(11)      NOT NULL COMMENT '最小空闲连接数',
    `max_wait`         INT(11)      NOT NULL COMMENT '最大等待时常',
    `test_while_idle`  TINYINT(1)   NOT NULL DEFAULT 1 COMMENT '空闲时是否检测可用性，1检测，0不检测',
    `validation_query` VARCHAR(100) NOT NULL DEFAULT 'select 1' COMMENT '测试语句',
    `create_time`      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP() COMMENT '创建时间',
    `update_time`      DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP() COMMENT '更新时间',
    `deleted`          TINYINT(1)   NOT NULL DEFAULT 0 COMMENT '0未删除，1删除',
    PRIMARY KEY (`uuid`)
)
    ENGINE = InnoDB
;
