CREATE DATABASE `hibernate`;
USE `hibernate`;
CREATE TABLE `autos` (
  `au_id` int(10) unsigned NOT NULL auto_increment,
  `au_marca` varchar(255) NOT NULL default '',
  `au_modelo` varchar(255) NOT NULL default '',
  PRIMARY KEY  (`au_id`)
) ENGINE=MyISAM;