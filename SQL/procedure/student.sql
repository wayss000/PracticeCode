/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50634
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-07-11 00:48:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` tinyint(4) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` tinyint(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'aaa', '90');
INSERT INTO `student` VALUES ('2', 'bbb', '91');
INSERT INTO `student` VALUES ('3', 'ccc', '30');
INSERT INTO `student` VALUES ('4', 'ddd', '93');
INSERT INTO `student` VALUES ('5', 'eee', '94');
