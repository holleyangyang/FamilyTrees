# Host: localhost  (Version: 5.6.27-log)
# Date: 2015-10-28 23:52:13
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "bookmark"
#

CREATE TABLE `bookmark` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `urlname` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "bookmark"
#

INSERT INTO `bookmark` VALUES (1,'百度','http://www.baidu.com','holleyangyang','19910908xsg','百度'),(2,'163','http://www.163.com','holleyangyang@163.com','19910908xsg','163邮箱');

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

#
# Structure for table "fanmilytree"
#

CREATE TABLE `fanmilytree` (
  `Id` varchar(11) NOT NULL DEFAULT '0',
  `pid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `open` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `isshow` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "fanmilytree"
#

INSERT INTO `fanmilytree` VALUES ('1_1_1','1_1','第3代','11','','1'),('1_1','1','第2代','false','http://www.jeasyui.com/','1'),('1','0','第1代','true',NULL,'1'),('1_1_1_1','1_1_1','第4代',NULL,'/examForAPI/jquery-easyui-1.4.3/demo/datagrid/basic.html','1');

#
# Structure for table "funtree"
#

CREATE TABLE `funtree` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `open` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "funtree"
#


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
