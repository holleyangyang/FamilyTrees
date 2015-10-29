# Host: localhost  (Version: 5.6.27-log)
# Date: 2015-10-28 23:51:43
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

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
