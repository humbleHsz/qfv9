
/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 09/04/2020 18:38:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(12) NOT NULL,
  `price` bigint(20) NOT NULL,
  `sale_price` bigint(20) NOT NULL,
  `sale_point` varchar(64) NOT NULL COMMENT '卖点',
  `image` varchar(256) NOT NULL,
  `stock` bigint(20) NOT NULL,
  `flag` tinyint(1) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `create_user` bigint(255) NOT NULL,
  `update_user` bigint(20) NOT NULL,
  `type_id` bigint(20) NOT NULL,
  `type_name` varchar(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_product
-- ----------------------------
BEGIN;
INSERT INTO `t_product` VALUES (1, 'mate30', 9999, 9998, '中国心', '123', 10000, 1, '2020-04-09 18:37:52', '2020-04-09 18:37:59', 1, 1, 1, '手机数码');
COMMIT;

-- ----------------------------
-- Table structure for t_product_desc
-- ----------------------------
DROP TABLE IF EXISTS `t_product_desc`;
CREATE TABLE `t_product_desc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `p_desc` text NOT NULL,
  `product_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for t_product_type
-- ----------------------------
DROP TABLE IF EXISTS `t_product_type`;
CREATE TABLE `t_product_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pid` bigint(20) NOT NULL,
  `name` varchar(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_product_type
-- ----------------------------
BEGIN;
INSERT INTO `t_product_type` VALUES (1, -1, '家用电器');
INSERT INTO `t_product_type` VALUES (2, 1, '电视');
INSERT INTO `t_product_type` VALUES (3, 1, '冰箱');
INSERT INTO `t_product_type` VALUES (4, 2, '液晶电视');
INSERT INTO `t_product_type` VALUES (5, 2, '曲面电视');
INSERT INTO `t_product_type` VALUES (6, 3, '双开冰箱');
INSERT INTO `t_product_type` VALUES (7, 3, '三开冰箱');
INSERT INTO `t_product_type` VALUES (8, -1, '手机数码');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
