/*
Navicat MySQL Data Transfer

Source Server         : o2o
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : hr

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-07-03 10:14:31
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `hrdepartment`
-- ----------------------------
DROP TABLE IF EXISTS `hrdepartment`;
CREATE TABLE `hrdepartment` (
  `departmentid` int(10) NOT NULL AUTO_INCREMENT,
  `department` varchar(20) NOT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`departmentid`),
  UNIQUE KEY `department` (`department`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hrdepartment
-- ----------------------------
INSERT INTO `hrdepartment` VALUES ('1', '人力资源', '2019-06-21 19:19:34', '负责人事工作');
INSERT INTO `hrdepartment` VALUES ('2', '基础部', '2019-06-21 19:25:14', '123');
INSERT INTO `hrdepartment` VALUES ('4', 'C', '2019-06-25 20:27:36', '负责C语言程序的编写');
INSERT INTO `hrdepartment` VALUES ('5', 'C#', '2019-06-25 21:24:28', '负责C#程序的开发');

-- ----------------------------
-- Table structure for `hrrecruit`
-- ----------------------------
DROP TABLE IF EXISTS `hrrecruit`;
CREATE TABLE `hrrecruit` (
  `recruitid` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `recruittype` varchar(20) NOT NULL,
  `education` varchar(500) NOT NULL,
  `workexp` varchar(500) DEFAULT '无',
  `detainfo` varchar(1000) DEFAULT '无',
  `status` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`recruitid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hrrecruit
-- ----------------------------
INSERT INTO `hrrecruit` VALUES ('2', '冯小刚', '男', '制片人', '小学', '导演许多大片', '无', '1');
INSERT INTO `hrrecruit` VALUES ('3', '真打算', '电风扇', '分身大师的', '鼎折覆餗', '是非得失', '发送到发送到', '0');

-- ----------------------------
-- Table structure for `hrrewpun`
-- ----------------------------
DROP TABLE IF EXISTS `hrrewpun`;
CREATE TABLE `hrrewpun` (
  `rewpunid` int(10) NOT NULL AUTO_INCREMENT,
  `rewpuntitle` varchar(50) NOT NULL,
  `rewpuntype` int(10) NOT NULL,
  `rewpunmount` int(10) NOT NULL,
  `rewpuntime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `detainfo` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`rewpunid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hrrewpun
-- ----------------------------
INSERT INTO `hrrewpun` VALUES ('1', '2', '0', '4', '2019-06-24 18:55:56', '1');
INSERT INTO `hrrewpun` VALUES ('4', '羽毛球单打比赛二等奖', '1', '1', '2019-06-24 19:27:23', '2');
INSERT INTO `hrrewpun` VALUES ('5', '羽毛球单打比赛一等奖', '0', '1', '2019-06-24 19:29:41', '');

-- ----------------------------
-- Table structure for `hrsalary`
-- ----------------------------
DROP TABLE IF EXISTS `hrsalary`;
CREATE TABLE `hrsalary` (
  `staffid` int(10) NOT NULL,
  `staffname` varchar(20) NOT NULL,
  `curmonth` varchar(7) NOT NULL,
  `basepay` int(10) NOT NULL,
  `overtimepay` int(10) DEFAULT '0',
  `duration` int(10) DEFAULT '0',
  `attpay` int(10) DEFAULT '0',
  `abspay` int(10) DEFAULT '0',
  `inspay` int(10) DEFAULT '0',
  PRIMARY KEY (`staffid`,`curmonth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hrsalary
-- ----------------------------
INSERT INTO `hrsalary` VALUES ('1', '郑志豪', '2019-6', '2000', '100', '55', '45', '25', '1');
INSERT INTO `hrsalary` VALUES ('2', 'weqr', '2019-7', '1312', '0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for `hrstaff`
-- ----------------------------
DROP TABLE IF EXISTS `hrstaff`;
CREATE TABLE `hrstaff` (
  `staffid` int(10) NOT NULL AUTO_INCREMENT,
  `staffname` varchar(20) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `department` varchar(20) NOT NULL,
  `worktype` varchar(20) NOT NULL,
  `education` varchar(20) NOT NULL,
  `worktime` date NOT NULL,
  PRIMARY KEY (`staffid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hrstaff
-- ----------------------------
INSERT INTO `hrstaff` VALUES ('1', '许鹏', '男', '人力资源', '面试官', '硕士', '2019-06-07');
INSERT INTO `hrstaff` VALUES ('2', '刘军', '男', 'C#', '程序员', '硕士', '2015-07-07');
INSERT INTO `hrstaff` VALUES ('3', '无名氏', '男', '基础部', '打杂', '无', '2016-07-09');

-- ----------------------------
-- Table structure for `hrtrain`
-- ----------------------------
DROP TABLE IF EXISTS `hrtrain`;
CREATE TABLE `hrtrain` (
  `trainid` int(10) NOT NULL AUTO_INCREMENT,
  `trainer` varchar(20) NOT NULL,
  `traintitle` varchar(20) NOT NULL,
  `traintime` datetime NOT NULL,
  `trainaddr` varchar(20) NOT NULL,
  `detainfo` varchar(1000) DEFAULT '无',
  PRIMARY KEY (`trainid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hrtrain
-- ----------------------------
INSERT INTO `hrtrain` VALUES ('2', '郑志豪', '嵌入式培训', '2017-12-01 00:00:00', '6教608', '无');

-- ----------------------------
-- Table structure for `hruser`
-- ----------------------------
DROP TABLE IF EXISTS `hruser`;
CREATE TABLE `hruser` (
  `userid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `userpwd` varchar(20) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hruser
-- ----------------------------
INSERT INTO `hruser` VALUES ('1', 'admin', '123');
INSERT INTO `hruser` VALUES ('2', '123', '123');
INSERT INTO `hruser` VALUES ('3', 'qwer', 'qwer');
