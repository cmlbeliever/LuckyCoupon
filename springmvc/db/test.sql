/*
Navicat MySQL Data Transfer

Source Server         : bendi
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2015-12-14 16:50:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_coupon`
-- ----------------------------
DROP TABLE IF EXISTS `t_coupon`;
CREATE TABLE `t_coupon` (
  `coupon_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) CHARACTER SET utf8 DEFAULT NULL,
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0 一般优惠券 1 抢优惠券',
  `max_assign_count` tinyint(4) DEFAULT NULL COMMENT '一个用户可分配的最大个数',
  `create_date` datetime NOT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`coupon_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_coupon
-- ----------------------------
INSERT INTO `t_coupon` VALUES ('1', '一般优惠券', '0', '1', '2015-12-12 16:29:44', '2015-12-12 16:29:46');
INSERT INTO `t_coupon` VALUES ('2', '可以抢2张的优惠券', '1', '2', '2015-12-12 16:29:57', '2015-12-12 16:29:59');
INSERT INTO `t_coupon` VALUES ('3', '可以抢1张的优惠券', '1', '1', '2015-12-12 16:31:39', '2015-12-12 16:31:42');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `update_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '测试：1431179358466', '2015-05-09 21:49:19');

-- ----------------------------
-- Table structure for `t_user_coupon`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_coupon`;
CREATE TABLE `t_user_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `coupon_id` bigint(20) NOT NULL,
  `use_flg` tinyint(4) DEFAULT NULL COMMENT '0 可用 1 已使用',
  `bind_date` datetime NOT NULL,
  `version` varchar(32) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100002 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Procedure structure for `init`
-- ----------------------------
DROP PROCEDURE IF EXISTS `init`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `init`(couponId INT)
BEGIN DECLARE initSize INT;
SET initSize = 0;
WHILE initSize < 100000 DO INSERT INTO t_user_coupon ( coupon_id, use_flg, create_date, update_date ) VALUES (couponId, 0, now(), now());
     SET initSize = initSize + 1;
END WHILE;
END
;;
DELIMITER ;
