/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50631
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2018-10-03 21:25:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick` varchar(50) DEFAULT NULL,
  `phone` varchar(18) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('1', 'yanglijun', '13900e0e01', 'beijing', 'branky163.com');
INSERT INTO `u_user` VALUES ('2', 'nick', '13900090e0', 'LXkXNÊ', 'fastly163.com');
INSERT INTO `u_user` VALUES ('3', 'nick3', '1399000000', 'bxt', 'jimmly@163.com');
INSERT INTO `u_user` VALUES ('4', 'dhF111', '1700018701', 'LXmèX', '122aa@qq. com');
INSERT INTO `u_user` VALUES ('5', 'KE+2', '199e0e01', 'dtX aß', '2876434346@qq. com');
INSERT INTO `u_user` VALUES ('7', 'nick3', '13990e0e00', 'itKã è+XF', 'quetyj@163.com');
INSERT INTO `u_user` VALUES ('8', ' zhangsanfeng001', '1370099e90', '13e124', '127490808@qq. com');
INSERT INTO `u_user` VALUES ('9', ' zhangsanfeng001', '1370080000', '13e124 ', '127490808@qq. com');
INSERT INTO `u_user` VALUES ('10', ' zhangsanfeng001', ' 1370000000', '13e124', '127490808qq.com ');
INSERT INTO `u_user` VALUES ('11', ' zhangsanfeng001', ' 1372000000', '13e124', '127490808@qq.com');
INSERT INTO `u_user` VALUES ('13', 'hlvy99', '199999999', '上海', '199999999@qq.com');
