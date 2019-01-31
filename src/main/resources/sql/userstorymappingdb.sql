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

 Date: 31/01/2019 22:39:47
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
  `content` varchar(1024) DEFAULT NULL,
  `color` varchar(6) DEFAULT NULL,
  `statusid` int(11) DEFAULT NULL,
  `createdtime` bigint(20) DEFAULT NULL,
  `isdeleted` smallint(1) DEFAULT '0',
  `deletedtime` bigint(20) DEFAULT NULL,
  `modifiedtime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cardid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryid` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `sequence` int(11) DEFAULT NULL,
  `createdtime` bigint(20) DEFAULT NULL,
  `isdeleted` smallint(1) DEFAULT '0',
  `deletedtime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='用于展示分类，如release1，release2';

-- ----------------------------
-- Table structure for color
-- ----------------------------
DROP TABLE IF EXISTS `color`;
CREATE TABLE `color` (
  `colorid` bigint(20) NOT NULL AUTO_INCREMENT,
  `colorcode` varchar(64) NOT NULL,
  `name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`colorid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for map
-- ----------------------------
DROP TABLE IF EXISTS `map`;
CREATE TABLE `map` (
  `mapid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `createdtime` bigint(20) DEFAULT NULL,
  `isdeleted` smallint(1) DEFAULT '0',
  `deletedtime` bigint(20) DEFAULT NULL,
  `modifiedtime` bigint(20) DEFAULT NULL,
  `releasenum` int(10) DEFAULT NULL,
  `storynum` int(10) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mapid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `createdtime` bigint(20) DEFAULT '0',
  `isdeleted` smallint(1) DEFAULT '0',
  `deletedtime` bigint(20) DEFAULT NULL,
  `nickname` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='user table';

SET FOREIGN_KEY_CHECKS = 1;
