CREATE TABLE `categorias` (
  `cat_id` int(10) unsigned NOT NULL auto_increment,
  `cat_descripcion` varchar(255) NOT NULL default '',
  PRIMARY KEY  (`cat_id`)
) ENGINE=MyISAM;


CREATE TABLE `categorias_items` (
  `cat_id` int(10) unsigned NOT NULL,
  `it_id` int(10) unsigned NOT NULL  
) ENGINE=MyISAM;