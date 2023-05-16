/*
 Navicat Premium Data Transfer

 Source Server         : djc20240428
 Source Server Type    : MySQL
 Source Server Version : 50718 (5.7.18-cynos-log)
 Source Host           : sh-cynosdbmysql-grp-osm62mc2.sql.tencentcdb.com:21791
 Source Schema         : factory_master_db

 Target Server Type    : MySQL
 Target Server Version : 50718 (5.7.18-cynos-log)
 File Encoding         : 65001

 Date: 15/05/2023 16:23:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accessories
-- ----------------------------
DROP TABLE IF EXISTS `accessories`;
CREATE TABLE `accessories`  (
  `accessories_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '配件id',
  `stock_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存货编码',
  `stock_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存货代码',
  `accessories_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配件名字',
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '计量单位',
  `model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规格型号',
  `machine_type_id` int(11) NULL DEFAULT NULL COMMENT '配件所属设备id',
  `importance` int(11) NULL DEFAULT NULL COMMENT '重要性',
  `employee_id` int(11) NULL DEFAULT NULL COMMENT '负责人id',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配件类型（excl表名）',
  `importance_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '重要性描述',
  PRIMARY KEY (`accessories_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '配件表\r\n' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for accessories_arrival
-- ----------------------------
DROP TABLE IF EXISTS `accessories_arrival`;
CREATE TABLE `accessories_arrival`  (
  `arrival_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '到货表',
  `employee_id` int(11) NULL DEFAULT NULL COMMENT '操作人id',
  `business_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务类型',
  `document` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单据号',
  `arrival_date` datetime NULL DEFAULT NULL COMMENT '到货日期',
  `purchase_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采购类型',
  `vendor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `clerk_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务员',
  `currency` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '币种',
  `exchange_rate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '汇率',
  `transportation_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '运输方式',
  `tax_rate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '税率',
  `arrival_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `invoice_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票号',
  `arrival_creater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '制单人',
  `now_num` int(11) NULL DEFAULT NULL COMMENT '现存量',
  `reviewer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核人',
  `arrival_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '到货到状态',
  `create_date` datetime NULL DEFAULT NULL COMMENT '记录日期',
  PRIMARY KEY (`arrival_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '到货单' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for accessories_arrival_detail
-- ----------------------------
DROP TABLE IF EXISTS `accessories_arrival_detail`;
CREATE TABLE `accessories_arrival_detail`  (
  `arrival_detail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '到达详情id',
  `arrival_id` int(11) NULL DEFAULT NULL COMMENT '到货单id',
  `accessories_id` int(11) NULL DEFAULT NULL COMMENT '配件id',
  `test_wether` int(1) NULL DEFAULT NULL COMMENT '是否检验',
  `material_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物料类型',
  `order_number` int(11) NULL DEFAULT NULL COMMENT '订单号',
  `line_number` int(11) NULL DEFAULT NULL COMMENT '行号',
  `arrival_num` int(11) NULL DEFAULT NULL COMMENT '到货数量',
  `conversion_rate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '换算率',
  `price_with_tax` int(6) NULL DEFAULT NULL COMMENT '原币含税单价',
  `price_without_tax` int(6) NULL DEFAULT NULL COMMENT '原币税后单价',
  PRIMARY KEY (`arrival_detail_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '到货详情' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for accessories_inbound
-- ----------------------------
DROP TABLE IF EXISTS `accessories_inbound`;
CREATE TABLE `accessories_inbound`  (
  `inbound_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '入库id',
  `employee_id` int(11) NULL DEFAULT NULL COMMENT '业务员id',
  `document` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单据号',
  `inbound_date` datetime NULL DEFAULT NULL COMMENT '入库日期',
  `clerk_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务员',
  `inbound_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入库类别',
  `review_date` datetime NULL DEFAULT NULL COMMENT '审核日期',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `inbound_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `inbound_creater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '制单人',
  `inbound_reviewer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核人',
  `inbound_approver` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批准人',
  `inbound_closer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关闭人',
  `inbound_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入库单状态',
  `create_date` datetime NULL DEFAULT NULL COMMENT '提交日期',
  PRIMARY KEY (`inbound_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入库信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for accessories_inbound_detail
-- ----------------------------
DROP TABLE IF EXISTS `accessories_inbound_detail`;
CREATE TABLE `accessories_inbound_detail`  (
  `inbound_detial_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `inbound_id` int(11) NULL DEFAULT NULL COMMENT '入库单id',
  `accessories_id` int(11) NULL DEFAULT NULL COMMENT '零件id',
  `material_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物料类型',
  `inbound_sum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数量',
  `inbound_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入库日期',
  `depot_id` int(11) NULL DEFAULT NULL COMMENT '仓库id',
  PRIMARY KEY (`inbound_detial_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入库详情信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for accessories_outbound
-- ----------------------------
DROP TABLE IF EXISTS `accessories_outbound`;
CREATE TABLE `accessories_outbound`  (
  `outbound_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '出库id',
  `employee_id` int(11) NULL DEFAULT NULL COMMENT '操作人Id',
  `document` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单据号',
  `outbound_date` datetime NULL DEFAULT NULL COMMENT '日期',
  `clerk_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务员',
  `outboud_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出库类别',
  `review_date` datetime NULL DEFAULT NULL COMMENT '审核日期',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `outbound_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `outbound_creater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '制单人',
  `outbound_reviewer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核人',
  `outbound_approver` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批准人',
  `outbound_closer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关闭人',
  `outbound_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出库单状态',
  `create_date` datetime NULL DEFAULT NULL COMMENT '提交日期',
  PRIMARY KEY (`outbound_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出库申请（领材料申请单）' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for accessories_outbound_detail
-- ----------------------------
DROP TABLE IF EXISTS `accessories_outbound_detail`;
CREATE TABLE `accessories_outbound_detail`  (
  `outbound_detail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `outbound_id` int(11) NULL DEFAULT NULL COMMENT '出库单id',
  `accessories_id` int(11) NULL DEFAULT NULL COMMENT '零件id\r\n',
  `material_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物料类型',
  `need_num` int(11) NULL DEFAULT NULL COMMENT '数量',
  `need_date` datetime NULL DEFAULT NULL COMMENT '需求日期',
  `depot_id` int(11) NULL DEFAULT NULL COMMENT '仓库id',
  PRIMARY KEY (`outbound_detail_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出库详情（材料申请表）' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for accessories_procurement
-- ----------------------------
DROP TABLE IF EXISTS `accessories_procurement`;
CREATE TABLE `accessories_procurement`  (
  `procurement_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '采购id',
  `employee_id` int(11) NULL DEFAULT NULL COMMENT '操作人id',
  `business_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务类型',
  `procurement_date` datetime NULL DEFAULT NULL COMMENT '订单日期',
  `document` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
  `purchase_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采购类型',
  `vendor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `clerk_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务员',
  `currency` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '币种',
  `exchange_rate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '汇率',
  `tax_rate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '税率',
  `payment_terms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '付款条件',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `invoice_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票号',
  `procurement_creater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '制单人',
  `procurement_reviewer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核人',
  `procurement_changer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '变更人',
  `procurement_approver` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批准人',
  `now_number` int(11) NULL DEFAULT NULL COMMENT '现存量',
  `procurement_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申购单状态',
  `create_date` datetime NULL DEFAULT NULL COMMENT '提交日期',
  PRIMARY KEY (`procurement_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '采购信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for accessories_procurement_detail
-- ----------------------------
DROP TABLE IF EXISTS `accessories_procurement_detail`;
CREATE TABLE `accessories_procurement_detail`  (
  `procurement_detail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `procurement_id` int(11) NULL DEFAULT NULL COMMENT '申购id',
  `accessories_id` int(11) NULL DEFAULT NULL COMMENT '零件id',
  `test_whether` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否检验',
  `material_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物料类型',
  `procurement_num` int(11) NULL DEFAULT NULL COMMENT '申购数量',
  `conversion_rate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '换算率',
  `purchasing_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采购单位',
  `original_price_with_tax` double NULL DEFAULT NULL COMMENT '原币含税单价',
  `original_currency` double NULL DEFAULT NULL COMMENT '原币金额',
  `original_currency_tax` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原币税额',
  `total_tax_price_in_original_currency` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原币价税合计',
  `tax_rate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '税率',
  PRIMARY KEY (`procurement_detail_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '申购详情' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for depot
-- ----------------------------
DROP TABLE IF EXISTS `depot`;
CREATE TABLE `depot`  (
  `depot_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '仓库id',
  `depot_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库名',
  `depot_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库位置',
  `employee_id` int(11) NULL DEFAULT NULL COMMENT '负责人',
  `depot_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `contact_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `depot_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库类型',
  `depot_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '仓库状态',
  `depot_opened_at` time NULL DEFAULT NULL COMMENT '仓库开门时间',
  `depot_cloesd_at` time NULL DEFAULT NULL COMMENT '仓库关们门间',
  PRIMARY KEY (`depot_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库信息\r\n' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `employee_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工名字',
  `employee_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int(11) NULL DEFAULT NULL COMMENT '员工年龄',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `team_id` int(11) NULL DEFAULT NULL COMMENT '小组id',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '12345678' COMMENT '密码',
  `phone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `work_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作地方/办公室',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `employee_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工邮箱',
  `employee_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工在职状态',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `hire_date` datetime NULL DEFAULT NULL COMMENT '员工入职日期',
  PRIMARY KEY (`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 147 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for employee_duty
-- ----------------------------
DROP TABLE IF EXISTS `employee_duty`;
CREATE TABLE `employee_duty`  (
  `duty_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '值班id',
  `employee_id` int(11) NULL DEFAULT NULL COMMENT '责任人id',
  `employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '责任人名字',
  `nachine_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机器级别',
  `machine_type_id` int(11) NULL DEFAULT NULL COMMENT '机器类型id',
  `machine_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机器名',
  `num` int(11) NULL DEFAULT NULL COMMENT '数量',
  `using_num` int(11) NULL DEFAULT NULL COMMENT '在用数量',
  `using_region` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '在用区域',
  `deactivate_num` int(11) NULL DEFAULT NULL COMMENT '停用数量',
  `deactivate_region` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '停用区域',
  `sluggish_num` int(11) NULL DEFAULT NULL COMMENT '呆滞数量',
  `sluggish_region` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '呆滞区域',
  `duty_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`duty_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '小组值班分工' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for employee_machine(abandon)
-- ----------------------------
DROP TABLE IF EXISTS `employee_machine(abandon)`;
CREATE TABLE `employee_machine(abandon)`  (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `machine_id` int(11) NOT NULL,
  PRIMARY KEY (`employee_id`, `machine_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工机器中间表（启用）' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `file_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件id',
  `records_id` int(11) NULL DEFAULT NULL COMMENT '维修记录id',
  `file_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件地址',
  `file_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `file_size` int(11) NULL DEFAULT NULL COMMENT '文件大小',
  PRIMARY KEY (`file_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '文件表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information`  (
  `information_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `sender_id` int(11) NULL DEFAULT NULL COMMENT '发送者(employeeid)',
  `information_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息标题',
  `information_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  PRIMARY KEY (`information_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '消息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for information_receiver
-- ----------------------------
DROP TABLE IF EXISTS `information_receiver`;
CREATE TABLE `information_receiver`  (
  `receiver_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关系id',
  `employee_id` int(11) NULL DEFAULT NULL COMMENT '接收者id',
  `information_id` int(11) NULL DEFAULT NULL COMMENT '消息id',
  `send_time` datetime NULL DEFAULT NULL COMMENT '发送时间',
  `information_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息状态',
  `priority` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息优先级（紧急程度）',
  PRIMARY KEY (`receiver_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '消息接收者' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory`  (
  `inventory_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '库存id',
  `depot_id` int(11) NOT NULL COMMENT '仓库id',
  `accessories_id` int(11) NOT NULL COMMENT '配件id',
  `accessories_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '零件单位',
  `num` int(11) NULL DEFAULT NULL COMMENT '配件数量',
  `accessories_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '零件存放位置',
  `accessories_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '零件存放状态',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`inventory_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '库存' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for inventory_change
-- ----------------------------
DROP TABLE IF EXISTS `inventory_change`;
CREATE TABLE `inventory_change`  (
  `change_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `inventory_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '库存id',
  `accessories_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '零件名',
  `change_num` int(11) NULL DEFAULT NULL COMMENT '改变数量',
  `change_employee_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存取员工',
  `change_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改单位',
  `change_employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工名',
  `change_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改类型(入库还是出库）',
  `change_date` datetime NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`change_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '库存变化记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for machine
-- ----------------------------
DROP TABLE IF EXISTS `machine`;
CREATE TABLE `machine`  (
  `machine_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备id',
  `machine_type_id` int(11) NULL DEFAULT NULL COMMENT '设备种类id',
  `machine_serial_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设备编号',
  `machine_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机器具体位置',
  `into_date` date NULL DEFAULT NULL COMMENT '进厂时间',
  `asset_number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资产编号',
  `machine_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机器状态',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`machine_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备表(具体到台)' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for machine_type
-- ----------------------------
DROP TABLE IF EXISTS `machine_type`;
CREATE TABLE `machine_type`  (
  `machine_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备种类id',
  `machine_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备种类',
  `machine_type_information` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备详情',
  `machine_model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备型号',
  `machine_manufacturer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '制造商',
  `orientation_position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '定向位置',
  `machine_voltage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电压',
  `machine_power` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功率',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`machine_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 125 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '机器类型(按种类）\r\n' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for maintenance_arrange
-- ----------------------------
DROP TABLE IF EXISTS `maintenance_arrange`;
CREATE TABLE `maintenance_arrange`  (
  `maintenance_arrange_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '维护id',
  `machine_id` int(11) NULL DEFAULT NULL COMMENT '机器id',
  `machine_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机器名字',
  `employees_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工名（多个）',
  `maintenance_date` datetime NULL DEFAULT NULL COMMENT '维护日期',
  `maintenance_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维护状态（是否完成）',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`maintenance_arrange_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '维护（保养）安排表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for maintenance_employee
-- ----------------------------
DROP TABLE IF EXISTS `maintenance_employee`;
CREATE TABLE `maintenance_employee`  (
  `maintenance_employee_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关系id',
  `maintenance_arrange_id` int(11) NULL DEFAULT NULL COMMENT '维护安排id',
  `employee_id` int(11) NULL DEFAULT NULL COMMENT '员工id',
  `importance` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '重要性',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`maintenance_employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '维护安排与员工关系表\r\n' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for maintenance_finish_ummary
-- ----------------------------
DROP TABLE IF EXISTS `maintenance_finish_ummary`;
CREATE TABLE `maintenance_finish_ummary`  (
  `ummmary_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '汇总',
  `machine_id` int(11) NULL DEFAULT NULL COMMENT '机器id',
  `machine_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名',
  `maintenance_date` date NULL DEFAULT NULL COMMENT '维护日期',
  `start_time` time NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` time NULL DEFAULT NULL COMMENT '结束时间',
  `finish_recording` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维护记录',
  `maintenance_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维护状态',
  `importance` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '重要性',
  PRIMARY KEY (`ummmary_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '维护完成汇总' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for maintenance_records(abandon)
-- ----------------------------
DROP TABLE IF EXISTS `maintenance_records(abandon)`;
CREATE TABLE `maintenance_records(abandon)`  (
  `records_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `machine_id` int(11) NULL DEFAULT NULL COMMENT '机器id',
  `machine_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机器名',
  `machine_type_id` int(11) NULL DEFAULT NULL COMMENT '机器型号id',
  `employee_id` int(11) NULL DEFAULT NULL COMMENT '提交人id',
  `repaire_employees_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参与维护员工',
  `method_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修方案描述',
  `maintenance_time` datetime NULL DEFAULT NULL COMMENT '维修时间',
  `records_state` tinyint(1) NULL DEFAULT 0 COMMENT '判断是否通过审核（0通过，1不通过）',
  PRIMARY KEY (`records_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '维修记录表\r\n' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for permission_menus
-- ----------------------------
DROP TABLE IF EXISTS `permission_menus`;
CREATE TABLE `permission_menus`  (
  `menusId` int(11) NOT NULL AUTO_INCREMENT COMMENT '按钮id',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `menu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '按钮',
  PRIMARY KEY (`menusId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '按钮权限' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for permission_points
-- ----------------------------
DROP TABLE IF EXISTS `permission_points`;
CREATE TABLE `permission_points`  (
  `points_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '操作权限',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `point` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`points_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for permissions(stop)
-- ----------------------------
DROP TABLE IF EXISTS `permissions(stop)`;
CREATE TABLE `permissions(stop)`  (
  `id` int(11) NOT NULL COMMENT '权限id',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for records
-- ----------------------------
DROP TABLE IF EXISTS `records`;
CREATE TABLE `records`  (
  `records_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `machine_id` int(11) NULL DEFAULT NULL COMMENT '机器id',
  `machine_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机器名',
  `machine_type_id` int(11) NULL DEFAULT NULL COMMENT '机器型号id',
  `employee_id` int(11) NULL DEFAULT NULL COMMENT '提交人id',
  `repaire_employees_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参与维修员工',
  `fault_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障问题描述',
  `method_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维修方案描述',
  `maintenance_time` datetime NULL DEFAULT NULL COMMENT '维修日期',
  `urgency_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '紧急程度',
  `record_type` int(2) NULL DEFAULT NULL COMMENT '记录类型(0维修，1维护)',
  `start_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime NULL DEFAULT NULL COMMENT '结束时间',
  `records_state` tinyint(1) NULL DEFAULT 0 COMMENT '判断是否通过审核（0通过，1不通过）',
  PRIMARY KEY (`records_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '维修(维修)记录表\r\n' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for repair_request
-- ----------------------------
DROP TABLE IF EXISTS `repair_request`;
CREATE TABLE `repair_request`  (
  `request_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '维修请求id',
  `machine_id` int(11) NULL DEFAULT NULL COMMENT '机器id',
  `machine_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机器名',
  `employee_id` int(11) NULL DEFAULT NULL COMMENT '员工id',
  `employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请人名字',
  `degree_urgency` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '紧急程度',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '情况描述',
  `telephone_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话号码',
  `specific_position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '具体位置',
  `progress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进展',
  PRIMARY KEY (`request_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '维修请求' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `team_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '小组id',
  `team_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小组名',
  `employee_id` int(11) NULL DEFAULT 0 COMMENT '小组长id',
  `employee_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小组长名',
  `employee_number` int(11) NULL DEFAULT NULL COMMENT '组员数量',
  `team_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '紧急电话',
  `team_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小组地点',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`team_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '小组表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for upcoming
-- ----------------------------
DROP TABLE IF EXISTS `upcoming`;
CREATE TABLE `upcoming`  (
  `upcoming_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '待办id',
  `employee_id` int(11) NULL DEFAULT NULL COMMENT '员工id',
  `start_date` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `end_date` datetime NULL DEFAULT NULL COMMENT '结束日期',
  `deadline` datetime NULL DEFAULT NULL COMMENT '截止日期',
  `upcoming_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '待办标题',
  `upcoming_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `sate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `creater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  PRIMARY KEY (`upcoming_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '待办信息表' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
