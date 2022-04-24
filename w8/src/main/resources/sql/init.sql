create database `sharding_ds_0`;
create database `sharding_ds_1`;

use `sharding_ds_0`;
create table `sharding_order_0`
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
) comment '订单表0';
create table `sharding_order_1`
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
) comment '订单表1';
create table `sharding_order_2`
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
) comment '订单表2';
create table `sharding_order_3`
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
) comment '订单表3';
create table `sharding_order_4`
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
) comment '订单表4';
create table `sharding_order_5`
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
) comment '订单表5';
create table `sharding_order_6`
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
) comment '订单表6';
create table `sharding_order_7`
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
) comment '订单表7';
create table `sharding_order_8`
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
) comment '订单表8';
create table `sharding_order_9`
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
) comment '订单表9';
create table `sharding_order_10`
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
) comment '订单表10';
create table `sharding_order_11`
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
) comment '订单表11';
create table `sharding_order_12`
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
) comment '订单表12';
create table `sharding_order_13`
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
) comment '订单表13';
create table `sharding_order_14`
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
) comment '订单表14';
create table `sharding_order_15`
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
) comment '订单表15';

use `sharding_ds_1`;
create table `sharding_order_0`
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
) comment '订单表0';
create table `sharding_order_1`
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
) comment '订单表1';
create table `sharding_order_2`
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
) comment '订单表2';
create table `sharding_order_3`
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
) comment '订单表3';
create table `sharding_order_4`
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
) comment '订单表4';
create table `sharding_order_5`
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
) comment '订单表5';
create table `sharding_order_6`
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
) comment '订单表6';
create table `sharding_order_7`
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
) comment '订单表7';
create table `sharding_order_8`
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
) comment '订单表8';
create table `sharding_order_9`
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
) comment '订单表9';
create table `sharding_order_10`
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
) comment '订单表10';
create table `sharding_order_11`
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
) comment '订单表11';
create table `sharding_order_12`
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
) comment '订单表12';
create table `sharding_order_13`
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
) comment '订单表13';
create table `sharding_order_14`
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
) comment '订单表14';
create table `sharding_order_15`
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
) comment '订单表15';