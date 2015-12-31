# Host: localhost  (Version: 5.6.27-log)
# Date: 2015-11-15 18:52:00
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "message"
#

CREATE TABLE `message` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `funtion_type` varchar(255) DEFAULT NULL COMMENT '功能类型',
  `funtion_name` varchar(255) DEFAULT NULL COMMENT '功能名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `code_demo` text COMMENT '示例代码',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注说明',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "message"
#

INSERT INTO `message` VALUES (2,'1','命令','linux查找命令','find\n','需要基于linux系统'),(3,'1','命令','linux创建文件夹','md dir\n','需要基于linux系统');
