# encouragement
INSERT INTO `blog`.`encouragement` (`uuid`, `content`)
VALUES ('f5b30800c4cd476eb7ff08bdcbc2dc0b', 'Go Pro, Or Go Home.');

INSERT INTO `blog`.`encouragement` (`uuid`, `content`)
VALUES ('e604c74ed8fd414b8a38fb618088551a', '别人都在以你不知道的方式进步，你的进步只是别人的常态。');

INSERT INTO `blog`.`encouragement` (`uuid`, `content`)
VALUES ('3ee6269da2a34fba9194787940c9b3c0', '蜉，水虫也，朝生暮死。');

INSERT INTO `blog`.`encouragement` (`uuid`, `content`)
VALUES ('756f96450cf54ce7839530a4986df93e', '夫学须静也，才须学也，非学无以广才，非志无以成学。');

INSERT INTO `blog`.`encouragement` (`uuid`, `content`)
VALUES ('2f7e181b5e21417394b5463b1774b126', '不积跬步，无以至千里；不积小流，无以成江海。');

INSERT INTO `blog`.`encouragement` (`uuid`, `content`)
VALUES ('527aefba0b32495e99515f5069547a38', '一日无二晨，时过不再临。');

INSERT INTO `blog`.`encouragement` (`uuid`, `content`)
VALUES ('f9cd2a7b26304a20a9ee265fa1d5e975', 'Prices will rise, politicians will philander, you, too, will get old.');

INSERT INTO `blog`.`encouragement` (`uuid`, `content`)
VALUES ('f8741ae954fc4e48acc4a151347b2e51', '青，取之于蓝，而青于蓝；冰，水为之，而寒于水。');

# header-menu
INSERT INTO `blog`.`header_menu` (`uuid`, `name`, `router_path`, `icon`, `item_order`, `create_time`, `update_time`,
                                  `delete`)
VALUES ('1b1314fa93034b19b8ac26012b54091b', '格言', '/home/motto', 'home', '1', '2020-04-18 22:29:58',
        '2020-04-18 22:30:00', '0');

INSERT INTO `blog`.`header_menu` (`uuid`, `name`, `router_path`, `icon`, `item_order`, `create_time`, `update_time`)
VALUES ('3aae6783b80a49c68d802a7dce11ced2', '个人博客', '/home/blog', 'book', '2', '2020-04-18 22:31:22',
        '2020-04-18 22:31:21');

INSERT INTO `blog`.`header_menu` (`uuid`, `name`, `router_path`, `icon`, `item_order`, `create_time`, `update_time`)
VALUES ('1389c1d910ef4d28a168adb6d5d23a53', '专题', '/home/topic', 'wb_incandescent', '3', '2020-04-18 22:31:22',
        '2020-04-18 22:31:21');

INSERT INTO `blog`.`header_menu` (`uuid`, `name`, `router_path`, `icon`, `item_order`, `create_time`, `update_time`)
VALUES ('29b4431977314b1a891d94970b772f8d', '我的项目', '/home/my-project', 'work', '4', '2020-04-18 22:33:54',
        '2020-04-18 22:33:55');

INSERT INTO `blog`.`header_menu` (`uuid`, `name`, `router_path`, `item_order`, `create_time`, `update_time`)
VALUES ('c2c0f7686ecc4174a3241861a74266a9', '关于', '/home/about', '5', '2020-04-18 22:34:58', '2020-04-18 22:34:58');
