/*
 Navicat Premium Data Transfer

 Source Server         : 47.107.35.167
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : 47.107.35.167:3306
 Source Schema         : userstorymappingdb

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 01/02/2019 21:54:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `cardid` bigint(20) NOT NULL AUTO_INCREMENT,
  `mapid` bigint(20) NOT NULL,
  `categoryid` bigint(20) NOT NULL,
  `attributeid` smallint(6) NOT NULL,
  `rowseq` int(11) DEFAULT NULL,
  `columnseq` int(11) DEFAULT NULL,
  `content` varchar(1024) CHARACTER SET latin1 DEFAULT NULL,
  `color` varchar(6) CHARACTER SET latin1 DEFAULT NULL,
  `statusid` int(11) DEFAULT NULL,
  `createdtime` bigint(20) DEFAULT NULL,
  `isdeleted` smallint(1) DEFAULT '0',
  `deletedtime` bigint(20) DEFAULT NULL,
  `modifiedtime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cardid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) CHARACTER SET latin1 NOT NULL,
  `sequence` int(11) DEFAULT NULL,
  `createdtime` bigint(20) DEFAULT NULL,
  `isdeleted` smallint(1) DEFAULT '0',
  `deletedtime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用于展示分类，如release1，release2';

-- ----------------------------
-- Table structure for color
-- ----------------------------
DROP TABLE IF EXISTS `color`;
CREATE TABLE `color` (
  `colorid` bigint(20) NOT NULL AUTO_INCREMENT,
  `colorcode` varchar(64) CHARACTER SET latin1 NOT NULL,
  `name` varchar(256) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`colorid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for storymap
-- ----------------------------
DROP TABLE IF EXISTS `storymap`;
CREATE TABLE `storymap` (
  `mapid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) DEFAULT NULL,
  `name` varchar(256) CHARACTER SET latin1 DEFAULT NULL,
  `createdtime` bigint(20) DEFAULT NULL,
  `isdeleted` smallint(1) unsigned zerofill DEFAULT '0',
  `deletedtime` bigint(20) DEFAULT NULL,
  `modifiedtime` bigint(20) DEFAULT NULL,
  `releasenum` int(10) unsigned zerofill DEFAULT '0000000000',
  `storynum` int(10) unsigned zerofill DEFAULT '0000000000',
  `description` varchar(255) CHARACTER SET utf8 DEFAULT '',
  `ongoingstorynum` int(10) unsigned zerofill DEFAULT '0000000000',
  PRIMARY KEY (`mapid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of storymap
-- ----------------------------
BEGIN;
INSERT INTO `storymap` VALUES (1, NULL, '??1', NULL, 0, NULL, NULL, 0000000000, 0000000000, '???????', 0000000000);
INSERT INTO `storymap` VALUES (2, NULL, '??1', NULL, 0, NULL, NULL, 0000000000, 0000000000, '???????', 0000000000);
INSERT INTO `storymap` VALUES (3, NULL, '??1', NULL, 0, NULL, NULL, 0000000000, 0000000000, '???????', 0000000000);
INSERT INTO `storymap` VALUES (4, 1, '??1', NULL, 0, NULL, NULL, 0000000000, 0000000000, 'sadfsd', 0000000000);
INSERT INTO `storymap` VALUES (5, 1, '??2', NULL, 0, NULL, NULL, 0000000000, 0000000000, '1233', 0000000000);
INSERT INTO `storymap` VALUES (6, 1, 'StoryMap1', NULL, NULL, NULL, NULL, NULL, NULL, 'This is a User story Map', NULL);
INSERT INTO `storymap` VALUES (7, 1, '??1', NULL, NULL, NULL, NULL, NULL, NULL, 'qww', NULL);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(256) CHARACTER SET latin1 NOT NULL,
  `password` varchar(256) CHARACTER SET latin1 NOT NULL,
  `mobile` varchar(11) CHARACTER SET latin1 DEFAULT NULL,
  `email` varchar(256) CHARACTER SET latin1 DEFAULT NULL,
  `createdtime` bigint(20) DEFAULT '0',
  `isdeleted` smallint(1) unsigned zerofill DEFAULT '0',
  `deletedtime` bigint(20) DEFAULT NULL,
  `nickname` varchar(256) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='user table';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'yaozs', '123456', NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
