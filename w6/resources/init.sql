create table `customer`
(
    id          bigint unsigned not null primary key comment '用户编号',
    nickname    varchar(64)     not null comment '用户昵称',
    password    varchar(255)    not null comment '密码',
    phone_no    varchar(64)     not null comment '登录手机号',
    create_time datetime        not null default CURRENT_TIMESTAMP comment '创建时间',
    update_time datetime        not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    unique key uk_phone_no (`phone_no`)
) comment '客户表';


create table `production`
(
    id          bigint unsigned not null primary key comment '商品编号',
    pd_name     varchar(128)    not null comment '商品名称',
    orig_price  decimal(16, 2)  not null comment '原价',
    sale_price  decimal(16, 2)  not null comment '折后价',
    stock_qty   bigint unsigned not null comment '库存数量',
    create_time datetime        not null default CURRENT_TIMESTAMP comment '创建时间',
    update_time datetime        not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间'
) comment '商品表';

create table `order`
(
    id              bigint unsigned not null primary key comment '订单编号',
    customer_id     bigint unsigned not null comment '用户编号',
    total_price     decimal(16, 2)  not null comment '商品总价',
    actual_price    decimal(16, 2)           default null comment '实付价格',
    customer_remark varchar(255)             default null comment '用户备注',
    pay_time        datetime                 default null comment '付款时间',
    create_time     datetime        not null default CURRENT_TIMESTAMP comment '创建时间',
    update_time     datetime        not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    key idx_customer_id (`customer_id`)
) comment '订单表';

create table `order_item`
(
    id           bigint unsigned not null primary key comment '订单物品编号',
    order_id     bigint unsigned not null comment '订单编号',
    pd_id        bigint unsigned not null comment '商品编号',
    pd_name      varchar(128)    not null comment '商品名称',
    unit_price   decimal(16, 2)  not null comment '商品单价',
    qty          bigint unsigned not null comment '购买数量',
    discounted   decimal(16, 2)  not null comment '优惠减免价格',
    actual_price decimal(16, 2)           default null comment '实付价格',
    create_time  datetime        not null default CURRENT_TIMESTAMP comment '创建时间',
    update_time  datetime        not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    key idx_order_id (`order_id`),
    key idx_pd_id (`pd_id`)
) comment '订单物品表';