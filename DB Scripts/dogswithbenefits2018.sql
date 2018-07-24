# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.5.5-10.3.8-MariaDB)
# Database: dogswithbenefits
# Generation Time: 2018-07-24 09:52:31 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table addresses
# ------------------------------------------------------------

DROP TABLE IF EXISTS `addresses`;

CREATE TABLE `addresses` (
  `addressid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `streetaddress` int(11) DEFAULT NULL,
  `postalcode` int(11) DEFAULT NULL,
  `cityid` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`addressid`),
  KEY `cityid` (`cityid`),
  CONSTRAINT `addresses_ibfk_1` FOREIGN KEY (`cityid`) REFERENCES `cities` (`cityid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table cities
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cities`;

CREATE TABLE `cities` (
  `cityid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cityname` varchar(50) NOT NULL DEFAULT '',
  `countryid` int(11) unsigned NOT NULL,
  PRIMARY KEY (`cityid`),
  UNIQUE KEY `CityName` (`cityname`),
  KEY `countryid` (`countryid`),
  CONSTRAINT `cities_ibfk_1` FOREIGN KEY (`countryid`) REFERENCES `countries` (`countryid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table countries
# ------------------------------------------------------------

DROP TABLE IF EXISTS `countries`;

CREATE TABLE `countries` (
  `countryid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `countryname` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`countryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



# Dump of table dogs
# ------------------------------------------------------------

DROP TABLE IF EXISTS `dogs`;

CREATE TABLE `dogs` (
  `dogId` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `ownerId` int(6) unsigned NOT NULL,
  `name` varchar(13) NOT NULL,
  `gender` char(1) NOT NULL,
  `breed` varchar(30) NOT NULL,
  `secBreed` varchar(30) DEFAULT NULL,
  `age` int(2) unsigned NOT NULL,
  `weight` int(3) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`dogId`),
  KEY `ownerId` (`ownerId`),
  CONSTRAINT `dogs_ibfk_1` FOREIGN KEY (`ownerId`) REFERENCES `users` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table photos
# ------------------------------------------------------------

DROP TABLE IF EXISTS `photos`;

CREATE TABLE `photos` (
  `photoId` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `dogId` int(6) unsigned NOT NULL,
  `photo` varchar(100) NOT NULL,
  PRIMARY KEY (`photoId`),
  KEY `dogId` (`dogId`),
  CONSTRAINT `photos_ibfk_1` FOREIGN KEY (`dogId`) REFERENCES `dogs` (`dogId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL DEFAULT '',
  `lastname` varchar(50) NOT NULL DEFAULT '',
  `phonenumber` varchar(15) DEFAULT '',
  `email` varchar(100) NOT NULL DEFAULT '',
  `addressid` int(11) unsigned NOT NULL,
  `password` varchar(40) NOT NULL DEFAULT '',
  PRIMARY KEY (`userid`),
  UNIQUE KEY `email` (`email`),
  KEY `addressid` (`addressid`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`addressid`) REFERENCES `addresses` (`addressid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
