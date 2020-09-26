DROP SCHEMA IF EXISTS `cryptocurrencytracker`;

CREATE SCHEMA `cryptocurrencytracker`;

use `cryptocurrencytracker`;

DROP TABLE IF EXISTS `currency_daily_price`;

CREATE TABLE `currency_daily_price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `symbol` varchar(45) DEFAULT NULL,
  `price` varchar(100) DEFAULT NULL,
  `price_date` varchar(100) DEFAULT NULL,
  `price_timestamp` varchar(100) DEFAULT NULL,
  `circulating_supply` varchar(100) DEFAULT NULL,
  `max_supply` varchar(100) DEFAULT NULL,
  `market_cap` varchar(100) DEFAULT NULL,
  `high` varchar(100) DEFAULT NULL,
  `high_timestamp` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `cryptocurrency`;

CREATE TABLE `cryptocurrency` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `currency_id` varchar(45) DEFAULT NULL,  
  `currency` varchar(45) DEFAULT NULL,
  `symbol` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `ranking` varchar(100) DEFAULT NULL,
  `logo_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
  )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


  
DROP TABLE IF EXISTS `currency_interval`;
  
CREATE TABLE `currency_interval` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `symbol` VARCHAR(45) NULL,
  `time_interval` VARCHAR(45) NULL,
  `price_change` VARCHAR(45) NULL,
  `price_change_pct` VARCHAR(45) NULL,
  `volume` VARCHAR(45) NULL,
  `volume_change` VARCHAR(45) NULL,
  `volume_change_pct` VARCHAR(45) NULL,
  `market_cap_change` VARCHAR(45) NULL,
  `market_cap_change_pct` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
  )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
  