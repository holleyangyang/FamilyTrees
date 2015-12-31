# Host:   (Version: 5.6.27-log)
# Date: 2015-12-01 22:47:13
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "zl_1"
#

CREATE TABLE `zl_1` (
  `Id` varchar(11) NOT NULL DEFAULT '',
  `xtname` varchar(255) DEFAULT NULL,
  `functionname` varchar(255) DEFAULT NULL,
  `facetype` varchar(255) DEFAULT NULL,
  `facename` varchar(255) DEFAULT NULL,
  `pId` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `disabled` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资料1表';

#
# Data for table "zl_1"
#

INSERT INTO `zl_1` VALUES ('1','网银','首页-账单','CDTS','101500',NULL,NULL,'true'),('2','网银','首页-额度','ESB','100002000（49）',NULL,NULL,'false'),('3','网银','首页-用户信息','ESB','1111111',NULL,NULL,'true');
