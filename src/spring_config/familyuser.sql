# Host: localhost  (Version: 5.6.27-log)
# Date: 2015-10-28 23:51:34
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "familyuser"
#

CREATE TABLE `familyuser` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '成员姓名',
  `treeid` varchar(255) DEFAULT NULL COMMENT '所属节点',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='家庭成员表';

#
# Data for table "familyuser"
#

INSERT INTO `familyuser` VALUES (1,'杨洋','1','男'),(2,'杨洋杨','1','女');
