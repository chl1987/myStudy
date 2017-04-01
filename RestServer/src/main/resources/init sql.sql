CREATE DATABASE  IF NOT EXISTS `chltest`;
USE `chltest`;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



CREATE TABLE `lockentry` (
  `lockId` varchar(32) NOT NULL DEFAULT '',
  `status` int(1) NOT NULL DEFAULT '0',
  `timeOut` int(4) NOT NULL DEFAULT '0',
  `updateTime` varchar(32) DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  PRIMARY KEY (`lockId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
