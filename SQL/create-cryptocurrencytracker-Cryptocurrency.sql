use `cryptocurrencytracker`;

DROP TABLE IF EXISTS `cryptocurrency`;

CREATE TABLE `cryptocurrency` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `currencyId` varchar(45) DEFAULT NULL,
  `currency` varchar(45) DEFAULT NULL,
  `symbol` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `logo_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
  )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
