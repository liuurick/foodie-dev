SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel`
(
    `id`         bigint(64) NOT NULL COMMENT '主键',
    `image_url`  varchar(128) NOT NULL COMMENT '图片 图片地址',
    `bg_color`   varchar(32) DEFAULT NULL COMMENT '背景色',
    `goods_id`   varchar(64) DEFAULT NULL COMMENT '商品id 商品id',
    `cat_id`     varchar(64) DEFAULT NULL COMMENT '商品分类id 商品分类id',
    `type`       tinyint(1) NOT NULL COMMENT '轮播图类型 轮播图类型，用于判断，可以根据商品id或者分类进行页面跳转，1：商品 2：分类',
    `sort`       tinyint(1) NOT NULL COMMENT '轮播图展示顺序',
    `is_show`    tinyint(1) NOT NULL COMMENT '是否展示:0:不展示,1:展示',
    `is_delete`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除:0:正常,1删除',
    `create_by`  bigint(20) NOT NULL COMMENT '创建者id',
    `update_by`  bigint(20) NOT NULL COMMENT '更新者id',
    `gmt_create` datetime    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update` datetime    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='轮播图';

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`
(
    `id`         bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`       varchar(32) NOT NULL COMMENT '分类名称',
    `type`       int(11) NOT NULL COMMENT '分类类型',
    `father_id`  int(11) NOT NULL COMMENT '父id',
    `logo`       varchar(64) DEFAULT NULL COMMENT '图标',
    `slogan`     varchar(64) DEFAULT NULL COMMENT '口号',
    `cat_image`  varchar(64) DEFAULT NULL COMMENT '分类图',
    `bg_color`   varchar(32) DEFAULT NULL COMMENT '背景颜色',
    `is_delete`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除:0:正常,1删除',
    `create_by`  bigint(20) NOT NULL COMMENT '创建者id',
    `update_by`  bigint(20) NOT NULL COMMENT '更新者id',
    `gmt_create` datetime    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update` datetime    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='商品分类 ';

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`
(
    `id`            bigint(64) NOT NULL COMMENT '商品主键id',
    `goods_name`    varchar(32) NOT NULL COMMENT '商品名称 商品名称',
    `cat_id`        int(11) NOT NULL COMMENT '分类外键id 分类id',
    `root_cat_id`   int(11) NOT NULL COMMENT '一级分类外键id',
    `sell_counts`   int(11) NOT NULL COMMENT '累计销售 累计销售',
    `on_off_status` int(11) NOT NULL COMMENT '上下架状态 上下架状态,1:上架 2:下架',
    `content`       text        NOT NULL COMMENT '商品内容 商品内容',
    `is_delete`     tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除:0:正常,1删除',
    `create_by`     bigint(20) NOT NULL COMMENT '创建者id',
    `update_by`     bigint(20) NOT NULL COMMENT '更新者id',
    `gmt_create`    datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update`    datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8mb4 COMMENT='商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表';


DROP TABLE IF EXISTS `goods_comments`;
CREATE TABLE `goods_comments`
(
    `id`            bigint(64) NOT NULL COMMENT 'id主键',
    `user_id`       varchar(64) DEFAULT NULL COMMENT '用户id 用户名须脱敏',
    `goods_id`      varchar(64)  NOT NULL COMMENT '商品id',
    `goods_name`    varchar(64) DEFAULT NULL COMMENT '商品名称',
    `goods_spec_id` varchar(64) DEFAULT NULL COMMENT '商品规格id 可为空',
    `sepc_name`     varchar(32) DEFAULT NULL COMMENT '规格名称 可为空',
    `comment_level` int(11) NOT NULL COMMENT '评价等级 1：好评 2：中评 3：差评',
    `content`       varchar(128) NOT NULL COMMENT '评价内容',
    `is_delete`     tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除:0:正常,1删除',
    `create_by`     bigint(20) NOT NULL COMMENT '创建者id',
    `update_by`     bigint(20) NOT NULL COMMENT '更新者id',
    `gmt_create`    datetime    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update`    datetime    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8mb4 COMMENT='商品评价表 ';


DROP TABLE IF EXISTS `goods_img`;
CREATE TABLE `goods_img`
(
    `id`         bigint(64) NOT NULL COMMENT '图片主键',
    `goods_id`   varchar(64)  NOT NULL COMMENT '商品外键id 商品外键id',
    `url`        varchar(128) NOT NULL COMMENT '图片地址 图片地址',
    `sort`       int(11) NOT NULL COMMENT '顺序 图片顺序，从小到大',
    `is_main`    int(11) NOT NULL COMMENT '是否主图 是否主图，1：是，0：否',
    `is_delete`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除:0:正常,1删除',
    `create_by`  bigint(20) NOT NULL COMMENT '创建者id',
    `update_by`  bigint(20) NOT NULL COMMENT '更新者id',
    `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8mb4 COMMENT='商品图片 ';


DROP TABLE IF EXISTS `goods_param`;
CREATE TABLE `goods_param`
(
    `id`               bigint(64) NOT NULL COMMENT '商品参数id',
    `goods_id`         varchar(32) NOT NULL COMMENT '商品外键id',
    `product_place`    varchar(32) NOT NULL COMMENT '产地 产地，例：中国江苏',
    `foot_period`      varchar(32) NOT NULL COMMENT '保质期 保质期，例：180天',
    `brand`            varchar(32) NOT NULL COMMENT '品牌名 品牌名，例：三只大灰狼',
    `factory_name`     varchar(32) NOT NULL COMMENT '生产厂名 生产厂名，例：大灰狼工厂',
    `factory_address`  varchar(32) NOT NULL COMMENT '生产厂址 生产厂址，例：大灰狼生产基地',
    `packaging_method` varchar(32) NOT NULL COMMENT '包装方式 包装方式，例：袋装',
    `weight`           varchar(32) NOT NULL COMMENT '规格重量 规格重量，例：35g',
    `storage_method`   varchar(32) NOT NULL COMMENT '存储方法 存储方法，例：常温5~25°',
    `eat_method`       varchar(32) NOT NULL COMMENT '食用方式 食用方式，例：开袋即食',
    `is_delete`        tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除:0:正常,1删除',
    `create_by`        bigint(20) NOT NULL COMMENT '创建者id',
    `update_by`        bigint(20) NOT NULL COMMENT '更新者id',
    `gmt_create`       datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update`       datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8mb4 COMMENT='商品参数 ';


DROP TABLE IF EXISTS `goods_spec`;
CREATE TABLE `goods_spec`
(
    `id`             bigint(64) NOT NULL COMMENT '商品规格id',
    `goods_id`       varchar(64)   NOT NULL COMMENT '商品外键id',
    `name`           varchar(32)   NOT NULL COMMENT '规格名称',
    `stock`          int(11) NOT NULL COMMENT '库存',
    `discounts`      decimal(4, 2) NOT NULL COMMENT '折扣力度',
    `price_discount` int(11) NOT NULL COMMENT '优惠价',
    `price_normal`   int(11) NOT NULL COMMENT '原价',
    `is_delete`      tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除:0:正常,1删除',
    `create_by`      bigint(20) NOT NULL COMMENT '创建者id',
    `update_by`      bigint(20) NOT NULL COMMENT '更新者id',
    `gmt_create`     datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update`     datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8mb4 COMMENT='商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计';


DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods`
(
    `id`              bigint(64) NOT NULL COMMENT '主键id',
    `order_id`        varchar(64)  NOT NULL COMMENT '归属订单id',
    `goods_id`        varchar(64)  NOT NULL COMMENT '商品id',
    `goods_img`       varchar(128) NOT NULL COMMENT '商品图片',
    `goods_name`      varchar(32)  NOT NULL COMMENT '商品名称',
    `goods_spec_id`   varchar(32)  NOT NULL COMMENT '规格id',
    `goods_spec_name` varchar(32)  NOT NULL COMMENT '规格名称',
    `price`           int(11) NOT NULL COMMENT '成交价格',
    `buy_counts`      int(11) NOT NULL COMMENT '购买数量',
    `is_delete`       tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除:0:正常,1删除',
    `create_by`       bigint(20) NOT NULL COMMENT '创建者id',
    `update_by`       bigint(20) NOT NULL COMMENT '更新者id',
    `gmt_create`      datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update`      datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8mb4 COMMENT='订单商品关联表 ';

DROP TABLE IF EXISTS `order_status`;
CREATE TABLE `order_status`
(
    `id`           bigint(64) NOT NULL COMMENT '主键id',
    `order_id`     varchar(64) NOT NULL COMMENT '订单ID;对应订单表的主键id',
    `order_status` int(11) NOT NULL COMMENT '订单状态',
    `created_time` datetime DEFAULT NULL COMMENT '订单创建时间;对应[10:待付款]状态',
    `pay_time`     datetime DEFAULT NULL COMMENT '支付成功时间;对应[20:已付款，待发货]状态',
    `deliver_time` datetime DEFAULT NULL COMMENT '发货时间;对应[30：已发货，待收货]状态',
    `success_time` datetime DEFAULT NULL COMMENT '交易成功时间;对应[40：交易成功]状态',
    `close_time`   datetime DEFAULT NULL COMMENT '交易关闭时间;对应[50：交易关闭]状态',
    `comment_time` datetime DEFAULT NULL COMMENT '留言时间;用户在交易成功后的留言时间',
    `is_delete`    tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除:0:正常,1删除',
    `create_by`    bigint(20) NOT NULL COMMENT '创建者id',
    `update_by`    bigint(20) NOT NULL COMMENT '更新者id',
    `gmt_create`   datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update`   datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

    PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8mb4 COMMENT='订单状态表;订单的每个状态更改都需要进行记录\n10：待付款  20：已付款，待发货  30：已发货，待收货（7天自动确认）  40：交易成功（此时可以评价）50：交易关闭（待付款时，用户取消 或 长时间未付款，系统识别后自动关闭）\n退货/退货，此分支流程不做，所以不加入';


DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`
(
    `id`               bigint(64) NOT NULL COMMENT '订单主键;同时也是订单编号',
    `user_id`          varchar(64)  NOT NULL COMMENT '用户id',
    `receiver_name`    varchar(32)  NOT NULL COMMENT '收货人快照',
    `receiver_mobile`  varchar(32)  NOT NULL COMMENT '收货人手机号快照',
    `receiver_address` varchar(128) NOT NULL COMMENT '收货地址快照',
    `total_amount`     int(11) NOT NULL COMMENT '订单总价格',
    `real_pay_amount`  int(11) NOT NULL COMMENT '实际支付总价格',
    `post_amount`      int(11) NOT NULL COMMENT '邮费;默认可以为零，代表包邮',
    `pay_method`       int(11) NOT NULL COMMENT '支付方式',
    `left_msg`         varchar(128) DEFAULT NULL COMMENT '买家留言',
    `extend`           varchar(32)  DEFAULT NULL COMMENT '扩展字段',
    `is_comment`       int(11) NOT NULL COMMENT '买家是否评价;1：已评价，0：未评价',
    `is_delete`        tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除:0:正常,1删除',
    `create_by`        bigint(20) NOT NULL COMMENT '创建者id',
    `update_by`        bigint(20) NOT NULL COMMENT '更新者id',
    `gmt_create`       datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update`       datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8mb4 COMMENT='订单表;';


DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address`
(
    `id`         bigint(64) NOT NULL COMMENT '地址主键id',
    `user_id`    varchar(64)  NOT NULL COMMENT '关联用户id',
    `receiver`   varchar(32)  NOT NULL COMMENT '收件人姓名',
    `mobile`     varchar(32)  NOT NULL COMMENT '收件人手机号',
    `province`   varchar(32)  NOT NULL COMMENT '省份',
    `city`       varchar(32)  NOT NULL COMMENT '城市',
    `district`   varchar(32)  NOT NULL COMMENT '区县',
    `detail`     varchar(128) NOT NULL COMMENT '详细地址',
    `extend`     varchar(128) DEFAULT NULL COMMENT '扩展字段',
    `is_default` int(11) DEFAULT NULL COMMENT '是否默认地址',
    `is_delete`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除:0:正常,1删除',
    `create_by`  bigint(20) NOT NULL COMMENT '创建者id',
    `update_by`  bigint(20) NOT NULL COMMENT '更新者id',
    `gmt_create` datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update` datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8mb4 COMMENT='用户地址表 ';


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    `id`         varchar(64)   NOT NULL COMMENT '主键id 用户id',
    `username`   varchar(32)   NOT NULL COMMENT '用户名 用户名',
    `password`   varchar(64)   NOT NULL COMMENT '密码 密码',
    `nickname`   varchar(32)  DEFAULT NULL COMMENT '昵称 昵称',
    `real_name`  varchar(128) DEFAULT NULL COMMENT '真实姓名',
    `face`       varchar(1024) NOT NULL COMMENT '头像',
    `mobile`     varchar(32)  DEFAULT NULL COMMENT '手机号 手机号',
    `email`      varchar(32)  DEFAULT NULL COMMENT '邮箱地址 邮箱地址',
    `sex`        int(11) DEFAULT NULL COMMENT '性别 性别 1:男  0:女  2:保密',
    `birthday`   date         DEFAULT NULL COMMENT '生日 生日',
    `is_delete`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除:0:正常,1删除',
    `create_by`  bigint(20) NOT NULL COMMENT '创建者id',
    `update_by`  bigint(20) NOT NULL COMMENT '更新者id',
    `gmt_create` datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update` datetime     DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

DROP TABLE
    IF
    EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log`
(
    `id`             VARCHAR(32) NOT NULL COMMENT '编号',
    `login_name`     VARCHAR(32) DEFAULT NULL COMMENT '登录名称',
    `login_way`      VARCHAR(2)  DEFAULT NULL COMMENT '1：微信',
    `login_platform` VARCHAR(2)  DEFAULT NULL COMMENT '1：安卓手机,2:苹果手机，3：PC',
    `login_ip`       VARCHAR(2)  DEFAULT NULL COMMENT '登录IP',
    `login_time`     VARCHAR(20) DEFAULT NULL COMMENT '登录时间',
    `login_status`   VARCHAR(2)  DEFAULT NULL COMMENT '登录状态(1：成功,2:用户错误，3：密码错误，4：账号锁定)',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT = '用户登录日志';

DROP TABLE IF EXISTS `sys_login_ref`;
CREATE TABLE `sys_login_ref`
(
    `id`       varchar(32) NOT NULL COMMENT '编号',
    `login_id` varchar(32) NOT NULL COMMENT '登录ID',
    `user_id`  varchar(64) DEFAULT NULL COMMENT '用户ID',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='登录关联表';


DROP TABLE IF EXISTS `sys_login_short_message`;
CREATE TABLE `sys_login_short_message`
(
    `id`                 varchar(32) NOT NULL COMMENT '编号',
    `login_id`           varchar(32) DEFAULT NULL COMMENT '登录ID',
    `login_mobile`       varchar(11) DEFAULT NULL COMMENT '手机号码',
    `verification_code`  varchar(6)  DEFAULT NULL COMMENT '验证码',
    `status`             varchar(2)  DEFAULT NULL COMMENT '状态',
    `send_time`          bigint(20) DEFAULT NULL COMMENT '发送时间',
    `end_time`           bigint(20) DEFAULT NULL COMMENT '有效时间',
    `short_message_type` varchar(2)  DEFAULT NULL COMMENT '消息类型',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='登录短信';

DROP TABLE IF EXISTS `sys_login_user`;
CREATE TABLE `sys_login_user`
(
    `id`                varchar(32) NOT NULL COMMENT '登录ID',
    `login_name`        varchar(32) DEFAULT NULL COMMENT '登录名称',
    `login_mobile`      varchar(11) DEFAULT NULL COMMENT '登录手机号码',
    `login_mail`        varchar(50) DEFAULT NULL COMMENT '登录邮箱',
    `password`          varchar(64) DEFAULT NULL COMMENT '密码（MD5）',
    `login_status`      varchar(2)  DEFAULT NULL COMMENT '登录状态',
    `last_login_time`   datetime                            DEFAULT NULL COMMENT '最后一次登录时间',
    `last_login_ip`     varchar(20) DEFAULT NULL COMMENT '最后一次登录IP',
    `last_login_device` varchar(2)  DEFAULT NULL COMMENT '最后一次登录设备(PC,IOS...)',
    `register_time`     datetime                            DEFAULT NULL COMMENT '注册时间',
    `login_user_type`   varchar(2)  DEFAULT NULL COMMENT '登录用户类型(1:平台操作人员,2:客户,3:经纪人,4:系统用户)',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='登录用户表';

DROP TABLE IF EXISTS `sys_third_party_account`;
CREATE TABLE `sys_third_party_account`
(
    `id`                       varchar(32) NOT NULL COMMENT '编号',
    `login_id`                 varchar(32) NOT NULL COMMENT '登录ID',
    `open_id`                  varchar(256) DEFAULT NULL COMMENT '用户ID',
    `third_party_account_type` varchar(2)   DEFAULT NULL COMMENT '第三方类型(1:微信，2：QQ 3：微博)',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='登录关联表';
