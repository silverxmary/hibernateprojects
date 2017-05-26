DROP TABLE IF EXISTS `hibernate`.`autos`;
CREATE TABLE  `hibernate`.`autos` (
  `au_id` int(10) unsigned NOT NULL auto_increment,
  `au_marca` varchar(255) NOT NULL default '',
  `au_modelo` varchar(255) NOT NULL default '',
  `au_fecha_venta` date NOT NULL default '0000-00-00',
  `au_precio` float NOT NULL default '0',
  PRIMARY KEY  (`au_id`)
) ENGINE=MyISAM;