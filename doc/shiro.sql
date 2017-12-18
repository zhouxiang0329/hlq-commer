/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-12-18 17:19:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_module
-- ----------------------------
DROP TABLE IF EXISTS `t_module`;
CREATE TABLE `t_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `module_name` varchar(32) DEFAULT NULL,
  `module_path` varchar(50) DEFAULT NULL,
  `module_type` int(2) DEFAULT NULL COMMENT '1.URL, 2.功能',
  `module_key` varchar(32) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_module
-- ----------------------------
INSERT INTO `t_module` VALUES ('1', '0', '系统管理', '/index', '1', 'SystemMgt', 'fa fa-cog', '2016-06-01 23:41:39');
INSERT INTO `t_module` VALUES ('2', '0', '诊所管理', '/HospitalMgt', '1', 'HospitalMgt', 'fa fa-hospital-o', '2016-06-02 09:42:17');
INSERT INTO `t_module` VALUES ('3', '0', '数据统计', '/Analytics', '1', 'Analytics', 'fa fa-bar-chart-o', '2016-06-03 21:42:17');
INSERT INTO `t_module` VALUES ('4', '1', '角色管理', '/Role_mgt', '1', 'Role_mgt', '', '2016-06-03 20:38:01');
INSERT INTO `t_module` VALUES ('5', '1', '权限管理', '/Privil_mgt', '1', 'Privil_mgt', '', '2016-06-03 20:38:04');
INSERT INTO `t_module` VALUES ('6', '1', '用户管理', '/User_mgt', '1', 'User_mgt', '', '2016-06-03 20:38:08');
INSERT INTO `t_module` VALUES ('7', '2', '诊所查询', '/Hospital_qry', '1', 'Hospital_qry', '', '2016-06-21 20:38:11');
INSERT INTO `t_module` VALUES ('8', '2', '诊所审核', '/Hospital_check', '1', 'Hospital_check', '', '2016-05-29 20:38:23');
INSERT INTO `t_module` VALUES ('9', '3', '诊所统计', '/Hospital_analytics', '1', 'Hospital_analytics', '', '2016-06-05 20:38:14');
INSERT INTO `t_module` VALUES ('10', '3', '医生统计', '/Doctor_analytics', '1', 'Doctor_analytics', '', '2016-07-01 20:38:28');
INSERT INTO `t_module` VALUES ('11', '3', '患者统计', '/Patient_analytics', '1', 'Patient_analytics', '', '2016-05-31 20:38:18');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', '系统管理员', '2016-06-01 23:41:11');
INSERT INTO `t_role` VALUES ('2', '诊所管理员', '诊所管理员', '2016-06-01 23:41:11');

-- ----------------------------
-- Table structure for t_role_module
-- ----------------------------
DROP TABLE IF EXISTS `t_role_module`;
CREATE TABLE `t_role_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `module_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_module
-- ----------------------------
INSERT INTO `t_role_module` VALUES ('1', '1', '1');
INSERT INTO `t_role_module` VALUES ('2', '1', '2');
INSERT INTO `t_role_module` VALUES ('3', '1', '3');
INSERT INTO `t_role_module` VALUES ('4', '1', '4');
INSERT INTO `t_role_module` VALUES ('5', '1', '5');
INSERT INTO `t_role_module` VALUES ('6', '1', '6');
INSERT INTO `t_role_module` VALUES ('7', '1', '7');
INSERT INTO `t_role_module` VALUES ('8', '1', '8');
INSERT INTO `t_role_module` VALUES ('9', '1', '9');
INSERT INTO `t_role_module` VALUES ('10', '1', '10');
INSERT INTO `t_role_module` VALUES ('11', '1', '11');
INSERT INTO `t_role_module` VALUES ('12', '2', '2');
INSERT INTO `t_role_module` VALUES ('13', '2', '7');
INSERT INTO `t_role_module` VALUES ('14', '2', '8');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `username` varchar(32) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `userNumber` int(255) DEFAULT NULL,
  `identity` int(11) DEFAULT NULL,
  `motifyTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'Admin', '2016-06-01 23:35:17', '1', null, null);
INSERT INTO `t_user` VALUES ('2', 'lance', 'e10adc3949ba59abbe56e057f20f883e', 'Lance', '2016-06-02 23:35:38', '1', null, null);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1');
INSERT INTO `t_user_role` VALUES ('2', '2', '2');
