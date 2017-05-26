CREATE TABLE `items` (
  `it_id` int(10) unsigned NOT NULL auto_increment,
  `it_descripcion` varchar(255) NOT NULL default '',
  `fac_id` int(10) unsigned default '0',
  `it_cantidad` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`it_id`)
) ENGINE=MyISAM;