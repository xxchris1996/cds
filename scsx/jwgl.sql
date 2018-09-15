/*
Navicat MySQL Data Transfer

Source Server         : xchris
Source Server Version : 50543
Source Host           : localhost:3306
Source Database       : jwgl

Target Server Type    : MYSQL
Target Server Version : 50543
File Encoding         : 65001

Date: 2018-09-12 09:02:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cls`
-- ----------------------------
DROP TABLE IF EXISTS `cls`;
CREATE TABLE `cls` (
  `cls_id` int(11) NOT NULL AUTO_INCREMENT,
  `cls_name` varchar(100) NOT NULL,
  `cls_remark` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`cls_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of cls
-- ----------------------------
INSERT INTO `cls` VALUES ('7', '酒水饮料', null);
INSERT INTO `cls` VALUES ('8', '母婴童装', null);
INSERT INTO `cls` VALUES ('9', '医药保健', null);
INSERT INTO `cls` VALUES ('10', '运动户外', null);
INSERT INTO `cls` VALUES ('11', '汽车用品', null);
INSERT INTO `cls` VALUES ('12', '箱包手表', null);
INSERT INTO `cls` VALUES ('13', '家居厨具', null);
INSERT INTO `cls` VALUES ('14', '家居家装', null);
INSERT INTO `cls` VALUES ('15', '礼品鲜花', null);
INSERT INTO `cls` VALUES ('16', '宠物生活', null);
INSERT INTO `cls` VALUES ('17', '图书音像', null);
INSERT INTO `cls` VALUES ('18', '艺术邮币', null);
INSERT INTO `cls` VALUES ('19', '服装', null);
INSERT INTO `cls` VALUES ('22', '箱包手表', null);
INSERT INTO `cls` VALUES ('23', '手机数码', null);
INSERT INTO `cls` VALUES ('24', '电脑办公', null);
INSERT INTO `cls` VALUES ('25', '家用电器', null);
INSERT INTO `cls` VALUES ('26', '食品生鲜', null);
INSERT INTO `cls` VALUES ('27', '酒水饮料', null);
INSERT INTO `cls` VALUES ('28', '母婴童装', null);
INSERT INTO `cls` VALUES ('29', '医药保健', null);
INSERT INTO `cls` VALUES ('30', '运动户外', null);
INSERT INTO `cls` VALUES ('31', '汽车用品', null);
INSERT INTO `cls` VALUES ('32', '箱包手表', null);
INSERT INTO `cls` VALUES ('33', '家居厨具', null);
INSERT INTO `cls` VALUES ('34', '家居家装', null);
INSERT INTO `cls` VALUES ('35', '礼品鲜花', null);
INSERT INTO `cls` VALUES ('36', '宠物生活', null);
INSERT INTO `cls` VALUES ('37', '图书音像', null);
INSERT INTO `cls` VALUES ('38', '艺术邮币', null);

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cus_id` varchar(20) NOT NULL DEFAULT '',
  `cus_name` varchar(100) DEFAULT NULL,
  `cus_xingzhi` varchar(100) DEFAULT NULL,
  `cus_score` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('110121', '工程设计实验', '选修', '3.0');
INSERT INTO `course` VALUES ('110123', '软件工程', '必修', '2.5');
INSERT INTO `course` VALUES ('110125', '数字信号处理', '必修', '1.5');
INSERT INTO `course` VALUES ('110127', '专业英语', '选修', '3.0');
INSERT INTO `course` VALUES ('110129', '单片机原理', '必修', '2.0');
INSERT INTO `course` VALUES ('110131', '高等数学', '选修', '4.0');
INSERT INTO `course` VALUES ('110133', '数字与信号系统', '选修', '3.0');
INSERT INTO `course` VALUES ('110135', 'EDA技术', '必修', '1.0');
INSERT INTO `course` VALUES ('110137', '电磁场与电磁波', '选修', '4.5');
INSERT INTO `course` VALUES ('110139', '光纤通信', '必修', '0.5');

-- ----------------------------
-- Table structure for `students`
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `stu_xuehao` varchar(20) NOT NULL,
  `stu_name` varchar(100) DEFAULT NULL,
  `stu_xueyuan` varchar(100) DEFAULT NULL,
  `stu_zhuanye` varchar(100) DEFAULT NULL,
  `stu_address` varchar(100) DEFAULT NULL,
  `stu_telephone` varchar(100) DEFAULT NULL,
  `stu_birth` varchar(20) DEFAULT NULL,
  `stu_state` varchar(20) DEFAULT NULL,
  `stu_xingbie` varchar(10) DEFAULT NULL,
  `stu_nation` varchar(10) DEFAULT NULL,
  `tag` bit(1) DEFAULT b'1',
  PRIMARY KEY (`stu_xuehao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('151004105', '赵六', '文学院', '汉语言1501', 'SSSXSSSX', '88888888888', '1996-1-1', '共产党员', '女', '汉', '');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `u_id` varchar(20) NOT NULL DEFAULT '',
  `u_pwd` varchar(20) NOT NULL,
  `identity` bit(1) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('111', '000000', '');
INSERT INTO `users` VALUES ('11111', '000000', '');
INSERT INTO `users` VALUES ('111111', '000000', '');
INSERT INTO `users` VALUES ('11121', '000000', '');
INSERT INTO `users` VALUES ('1212', '000000', '');
INSERT INTO `users` VALUES ('121211', '000000', '');
INSERT INTO `users` VALUES ('123123', '000000', '');
INSERT INTO `users` VALUES ('12331231', '000000', '');
INSERT INTO `users` VALUES ('151004101', '000000', '');
INSERT INTO `users` VALUES ('151004105', '000000', '');
INSERT INTO `users` VALUES ('151004131', '000000', '');
INSERT INTO `users` VALUES ('2121', '000000', '');
INSERT INTO `users` VALUES ('2213', '000000', '');
INSERT INTO `users` VALUES ('41414', '000000', '');
INSERT INTO `users` VALUES ('admin', 'admin', '');

-- ----------------------------
-- Table structure for `xuanke`
-- ----------------------------
DROP TABLE IF EXISTS `xuanke`;
CREATE TABLE `xuanke` (
  `stu_xuehao` varchar(20) NOT NULL DEFAULT '',
  `cus_id` varchar(20) DEFAULT NULL,
  `cus_name` varchar(100) DEFAULT NULL,
  `cus_xingzhi` varchar(100) DEFAULT NULL,
  `cus_score` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`stu_xuehao`),
  CONSTRAINT `xuanke_ibfk_1` FOREIGN KEY (`stu_xuehao`) REFERENCES `course` (`cus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xuanke
-- ----------------------------
