create table machine.access_ecords
(
    access_records_id int      not null comment ' id'
        primary key,
    employee_id       int      null comment '员工id',
    accessories_id    int      null comment '零件id',
    variation         int      null comment '变化数量',
    access_date       datetime null comment '存取时间'
)
    comment '库存变更记录';

create table machine.accessories
(
    accessories_id         int          not null comment '配件id'
        primary key,
    stock_id               varchar(255) null comment '存货编码',
    stock_code             varchar(255) null comment '存货代码',
    accessories_name       varchar(255) null comment '配件名字',
    unit                   varchar(255) null comment '计量单位',
    model                  varchar(255) null comment '规格型号',
    machine_type_id        int          null comment '配件所属设备id',
    importance             int          null comment '重要性',
    employee_id            int          null comment '负责人id',
    type                   varchar(255) null comment '配件类型',
    importance_description varchar(255) null comment '重要性描述'
)
    comment '配件表
';

create table machine.employee
(
    employee_id   int auto_increment comment '员工id'
        primary key,
    employee_name varchar(255) null comment '员工名字',
    role          varchar(255) null comment '角色',
    group_id      int          null comment '小组id',
    password      varchar(255) null comment '密码'
)
    comment '员工表';

create table machine.employee_machine
(
    employee_id int not null,
    machine_id  int not null,
    primary key (employee_id, machine_id)
);

create table machine.inventory
(
    inventory_id   int not null,
    employee_id    int not null,
    accessories_id int not null,
    num            int null,
    primary key (employee_id, accessories_id)
)
    comment '库存';

create table machine.machine
(
    machine_id          int          not null comment '设备id'
        primary key,
    machine_type_id     varchar(255) null comment '设备种类id',
    machine_information varchar(255) not null comment '设备详情信息',
    employee_id         int          null comment '负责员工id'
)
    comment '设备表';

create table machine.machine_type
(
    machine_type_id          int          not null comment '设备种类id'
        primary key,
    machine_type             varchar(255) null comment '设备种类',
    machine_type_information varchar(255) null comment '设备详情'
)
    comment '机器类型';

create table machine.maintenance_records
(
    records_id         int          not null comment '记录id'
        primary key,
    maintenance_time   datetime     null comment '维修时间',
    machine_id         int          null comment '机器id',
    employee_id        int          null comment '维修人id',
    method_description varchar(255) null comment '维修方案描述',
    fault_description  varchar(255) null comment '故障问题描述',
    word_place         varchar(255) not null comment '文档地址',
    photo_place        varchar(255) null comment '图片地址',
    vido_place         varchar(255) null comment '视频地址',
    machine_type_id    int          null comment '机器型号id'
)
    comment '维修记录表
';

create table machine.permissions
(
    id         int          not null comment '权限id'
        primary key,
    role       varchar(255) null comment '角色',
    permission varchar(255) null comment '权限'
)
    comment '权限表';

create table machine.team
(
    group_id    int auto_increment comment '小组id'
        primary key,
    employee_id int null comment '小组长id',
    machine_id  int null comment '小组管理的机器id'
)
    comment '小组表';


