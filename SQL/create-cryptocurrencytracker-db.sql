DROP SCHEMA IF EXISTS `cryptocurrencytracker`;

CREATE SCHEMA `cryptocurrencytracker`;

use `cryptocurrencytracker`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(60) NULL,
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
  
DROP TABLE IF EXISTS `datestamp`;

CREATE TABLE `datestamp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price_date` varchar(45) DEFAULT NULL,
  `price_timestamp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `currency_info`;

CREATE TABLE `currency_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` varchar(100) DEFAULT NULL,
  `circulating_supply` varchar(100) DEFAULT NULL,
  `max_supply` varchar(100) DEFAULT NULL,
  `market_cap` varchar(100) DEFAULT NULL,
  `ranking` varchar(100) DEFAULT NULL,
  `high` varchar(100) DEFAULT NULL,
  `high_timestamp` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `cryptocurrencies`;

CREATE TABLE `cryptocurrencies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `currencyId` varchar(45) DEFAULT NULL,
  `currency` varchar(45) DEFAULT NULL,
  `symbol` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `logo_url` varchar(100) DEFAULT NULL,
  `info_id` int(11) DEFAULT NULL,
  `interval_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_INFO_idx` (`info_id`),
  KEY `FK_INTERVALS_idx` (`interval_id`),
  CONSTRAINT `FK_INFO` FOREIGN KEY (`info_id`) REFERENCES `currency_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_INTERVALS` FOREIGN KEY (`interval_id`) REFERENCES `intervals` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
  )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
  
DROP TABLE IF EXISTS `intervals`;
  
CREATE TABLE `intervals` (
  `id` INT(11) NOT NULL UTO_INCREMENT,
  `symbol` VARCHAR(45) NULL,
  `time` VARCHAR(45) NULL,
  `price_change` VARCHAR(45) NULL,
  `price_change_pct` VARCHAR(45) NULL,
  `volume` VARCHAR(45) NULL,
  `volume_change` VARCHAR(45) NULL,
  `volume_change_pct` VARCHAR(45) NULL,
  `market_cap_change` VARCHAR(45) NULL,
  `market_cap_change_pct` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
  )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
  