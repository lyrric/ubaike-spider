/*
Navicat MySQL Data Transfer

Source Server         : localhost_1
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2020-11-04 16:28:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for company_info
-- ----------------------------
DROP TABLE IF EXISTS `company_info`;
CREATE TABLE `company_info` (
  `id` bigint(12) unsigned NOT NULL AUTO_INCREMENT,
  `company_id` varchar(20) DEFAULT NULL COMMENT '公司id，由代码生成',
  `company_name` varchar(100) DEFAULT NULL COMMENT '公司名称',
  `legal_representative` varchar(50) DEFAULT NULL COMMENT '法定代表人/法人代表',
  `register_number` varchar(50) DEFAULT NULL COMMENT '注册号',
  `credit_code` varchar(50) DEFAULT NULL COMMENT '统一社会信用代码',
  `register_amount` varchar(20) DEFAULT NULL COMMENT '注册资本',
  `register_date` date DEFAULT NULL COMMENT '注册日期',
  `company_type` varchar(50) DEFAULT NULL COMMENT '企业类型',
  `scope_of_business` mediumtext COMMENT '经营范围',
  `register_address` varchar(100) DEFAULT NULL COMMENT '注册地址/公司住所',
  `term_of_business` varchar(50) DEFAULT NULL COMMENT '营业期限',
  `register_agency` varchar(50) DEFAULT NULL COMMENT '登记机关',
  `status` varchar(20) DEFAULT NULL COMMENT '经营状态/企业状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `company_id` (`company_id`),
  KEY `register_number` (`register_number`),
  KEY `credit_code` (`credit_code`),
  KEY `company_name` (`company_name`),
  KEY `status` (`status`),
  KEY `create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1  DEFAULT CHARSET=utf8 COMMENT='企业基本信息';

-- ----------------------------
-- Table structure for error_log
-- ----------------------------
DROP TABLE IF EXISTS `error_log`;
CREATE TABLE `error_log` (
  `id` bigint(12) unsigned NOT NULL AUTO_INCREMENT,
  `web_id` int(11) DEFAULT NULL COMMENT '页面id',
  `error_msg` varchar(500) DEFAULT NULL COMMENT '错误信息',
  `html` longtext COMMENT 'html内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='出错记录';
