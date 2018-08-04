# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.5.5-10.3.8-MariaDB)
# Database: dogswithbenefits
# Generation Time: 2018-08-04 18:47:21 +0000
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

CREATE TABLE `addresses` (
  `addressid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `streetaddress` varchar(100) NOT NULL,
  `postalcode` int(11) DEFAULT NULL,
  `cityid` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`addressid`),
  KEY `cityid` (`cityid`),
  CONSTRAINT `addresses_ibfk_1` FOREIGN KEY (`cityid`) REFERENCES `cities` (`cityid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;

INSERT INTO `addresses` (`addressid`, `streetaddress`, `postalcode`, `cityid`)
VALUES
	(1,'Mladost 1, bl. 40',1784,1),
	(8,'5 Tepe str',1000,4),
	(9,'123',12,5);

/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table breeds
# ------------------------------------------------------------

CREATE TABLE `breeds` (
  `breedid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `breedname` varchar(60) NOT NULL DEFAULT '',
  PRIMARY KEY (`breedid`),
  UNIQUE KEY `breedname` (`breedname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `breeds` WRITE;
/*!40000 ALTER TABLE `breeds` DISABLE KEYS */;

INSERT INTO `breeds` (`breedid`, `breedname`)
VALUES
	(1,'Affenpinscher'),
	(2,'Afghan Hound'),
	(3,'Airedale Terrier'),
	(4,'Akita'),
	(5,'Alaskan Klee Kai'),
	(6,'Alaskan Malamute'),
	(7,'American Bulldog'),
	(8,'American English Coonhound'),
	(9,'American Eskimo Dog'),
	(10,'American Foxhound'),
	(11,'American Pit Bull Terrier'),
	(12,'American Staffordshire Terrier'),
	(13,'American Water Spaniel'),
	(14,'Anatolian Shepherd Dog'),
	(15,'Appenzeller Sennenhunde'),
	(16,'Australian Cattle Dog'),
	(17,'Australian Kelpie'),
	(18,'Australian Shepherd'),
	(19,'Australian Terrier'),
	(20,'Azawakh'),
	(21,'Barbet'),
	(22,'Basenji'),
	(23,'Basset Hound'),
	(24,'Beagle'),
	(25,'Bearded Collie'),
	(26,'Bedlington Terrier'),
	(27,'Belgian Malinois'),
	(28,'Belgian Sheepdog'),
	(29,'Belgian Tervuren'),
	(30,'Berger Picard'),
	(31,'Bernedoodle'),
	(32,'Bernese Mountain Dog'),
	(33,'Bichon Frise'),
	(34,'Black and Tan Coonhound'),
	(35,'Black Mouth Cur'),
	(36,'Black Russian Terrier'),
	(37,'Bloodhound'),
	(38,'Blue Lacy'),
	(39,'Bluetick Coonhound'),
	(40,'Boerboel'),
	(41,'Bolognese'),
	(42,'Border Collie'),
	(43,'Border Terrier'),
	(44,'Borzoi'),
	(45,'Boston Terrier'),
	(46,'Bouvier des Flandres'),
	(47,'Boxer'),
	(48,'Boykin Spaniel'),
	(49,'Bracco Italiano'),
	(50,'Briard'),
	(51,'Brittany'),
	(52,'Brussels Griffon'),
	(53,'Bull Terrier'),
	(54,'Bulldog'),
	(55,'Bullmastiff'),
	(56,'Cairn Terrier'),
	(57,'Canaan Dog'),
	(58,'Cane Corso'),
	(59,'Cardigan Welsh Corgi'),
	(60,'Catahoula Leopard Dog'),
	(61,'Caucasian Shepherd Dog'),
	(62,'Cavalier King Charles Spaniel'),
	(63,'Cesky Terrier'),
	(64,'Chesapeake Bay Retriever'),
	(65,'Chihuahua'),
	(66,'Chinese Crested'),
	(67,'Chinese Shar-Pei'),
	(68,'Chinook'),
	(69,'Chow Chow'),
	(70,'Clumber Spaniel'),
	(71,'Cockapoo'),
	(72,'Cocker Spaniel'),
	(73,'Collie'),
	(74,'Coton de Tulear'),
	(75,'Curly-Coated Retriever'),
	(76,'Dachshund'),
	(77,'Dalmatian'),
	(78,'Dandie Dinmont Terrier'),
	(79,'Doberman Pinscher'),
	(80,'Dogo Argentino'),
	(81,'Dogue de Bordeaux'),
	(82,'Dutch Shepherd'),
	(83,'English Cocker Spaniel'),
	(84,'English Foxhound'),
	(85,'English Setter'),
	(86,'English Springer Spaniel'),
	(87,'English Toy Spaniel'),
	(88,'Entlebucher Mountain Dog'),
	(89,'Field Spaniel'),
	(90,'Finnish Lapphund'),
	(91,'Finnish Spitz'),
	(92,'Flat-Coated Retriever'),
	(93,'Fox Terrier'),
	(94,'French Bulldog'),
	(95,'German Pinscher'),
	(96,'German Shepherd Dog'),
	(97,'German Shorthaired Pointer'),
	(98,'German Wirehaired Pointer'),
	(99,'Giant Schnauzer'),
	(100,'Glen of Imaal Terrier'),
	(101,'Goldador'),
	(102,'Golden Retriever'),
	(103,'Goldendoodle'),
	(104,'Gordon Setter'),
	(105,'Great Dane'),
	(106,'Great Pyrenees'),
	(107,'Greater Swiss Mountain Dog'),
	(108,'Greyhound'),
	(109,'Harrier'),
	(110,'Havanese'),
	(111,'Ibizan Hound'),
	(112,'Icelandic Sheepdog'),
	(113,'Irish Red and White Setter'),
	(114,'Irish Setter'),
	(115,'Irish Terrier'),
	(116,'Irish Water Spaniel'),
	(117,'Irish Wolfhound'),
	(118,'Italian Greyhound'),
	(119,'Jack Russell Terrier'),
	(120,'Japanese Chin'),
	(121,'Japanese Spitz'),
	(123,'Karelian Bear Dog'),
	(124,'Keeshond'),
	(125,'Kerry Blue Terrier'),
	(126,'Komondor'),
	(127,'Kooikerhondje'),
	(122,'Korean Jindo Dog'),
	(128,'Kuvasz'),
	(129,'Labradoodle'),
	(130,'Labrador Retriever'),
	(131,'Lagotto Romagnolo'),
	(132,'Lakeland Terrier'),
	(133,'Lancashire Heeler'),
	(134,'Leonberger'),
	(135,'Lhasa Apso'),
	(136,'Lowchen'),
	(137,'Maltese'),
	(138,'Maltese Shih Tzu'),
	(139,'Maltipoo'),
	(140,'Manchester Terrier'),
	(141,'Mastiff'),
	(142,'Miniature Pinscher'),
	(143,'Miniature Schnauzer'),
	(144,'Mudi'),
	(145,'Mutt'),
	(146,'Neapolitan Mastiff'),
	(147,'Newfoundland'),
	(148,'Norfolk Terrier'),
	(149,'Norwegian Buhund'),
	(150,'Norwegian Elkhound'),
	(151,'Norwegian Lundehund'),
	(152,'Norwich Terrier'),
	(304,'Nova Scotia Duck Tolling Retriever'),
	(305,'Old English Sheepdog'),
	(306,'Otterhound'),
	(307,'Papillon'),
	(308,'Peekapoo'),
	(309,'Pekingese'),
	(310,'Pembroke Welsh Corgi'),
	(311,'Petit Basset Griffon Vendeen'),
	(312,'Pharaoh Hound'),
	(313,'Plott'),
	(314,'Pocket Beagle'),
	(315,'Pointer'),
	(316,'Polish Lowland Sheepdog'),
	(317,'Pomeranian'),
	(318,'Pomsky'),
	(319,'Poodle'),
	(320,'Portuguese Water Dog'),
	(321,'Pug'),
	(322,'Puggle'),
	(323,'Puli'),
	(324,'Pyrenean Shepherd'),
	(325,'Rat Terrier'),
	(326,'Redbone Coonhound'),
	(327,'Rhodesian Ridgeback'),
	(328,'Rottweiler'),
	(329,'Saint Bernard'),
	(330,'Saluki'),
	(331,'Samoyed'),
	(332,'Schipperke'),
	(333,'Schnoodle'),
	(334,'Scottish Deerhound'),
	(335,'Scottish Terrier'),
	(336,'Sealyham Terrier'),
	(337,'Shetland Sheepdog'),
	(338,'Shiba Inu'),
	(339,'Shih Tzu'),
	(340,'Siberian Husky'),
	(341,'Silky Terrier'),
	(342,'Skye Terrier'),
	(343,'Sloughi'),
	(344,'Small Munsterlander Pointer'),
	(345,'Soft Coated Wheaten Terrier'),
	(346,'Stabyhoun'),
	(347,'Staffordshire Bull Terrier'),
	(348,'Standard Schnauzer'),
	(349,'Sussex Spaniel'),
	(350,'Swedish Vallhund'),
	(351,'Tibetan Mastiff'),
	(352,'Tibetan Spaniel'),
	(353,'Tibetan Terrier'),
	(354,'Toy Fox Terrier'),
	(355,'Treeing Tennessee Brindle'),
	(356,'Treeing Walker Coonhound'),
	(357,'Vizsla'),
	(358,'Weimaraner'),
	(359,'Welsh Springer Spaniel'),
	(360,'Welsh Terrier'),
	(361,'West Highland White Terrier'),
	(362,'Whippet'),
	(363,'Wirehaired Pointing Griffon'),
	(364,'Xoloitzcuintli'),
	(365,'Yorkipoo'),
	(366,'Yorkshire Terrier');

/*!40000 ALTER TABLE `breeds` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table cities
# ------------------------------------------------------------

CREATE TABLE `cities` (
  `cityid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cityname` varchar(50) NOT NULL DEFAULT '',
  `countryid` int(11) unsigned NOT NULL,
  PRIMARY KEY (`cityid`),
  UNIQUE KEY `CityName` (`cityname`),
  KEY `countryid` (`countryid`),
  CONSTRAINT `cities_ibfk_1` FOREIGN KEY (`countryid`) REFERENCES `countries` (`countryid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;

INSERT INTO `cities` (`cityid`, `cityname`, `countryid`)
VALUES
	(1,'Sofia',1),
	(4,'Plovdiv',1),
	(5,'1',2);

/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table countries
# ------------------------------------------------------------

CREATE TABLE `countries` (
  `countryid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `countryname` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`countryid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;

INSERT INTO `countries` (`countryid`, `countryname`)
VALUES
	(1,'Bulgaria'),
	(2,'1');

/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table dogs
# ------------------------------------------------------------

CREATE TABLE `dogs` (
  `dogId` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `ownerId` int(6) unsigned NOT NULL,
  `name` varchar(13) NOT NULL,
  `gender` char(1) NOT NULL,
  `breedid` int(11) unsigned NOT NULL,
  `secBreedid` int(11) unsigned DEFAULT NULL,
  `age` int(2) unsigned NOT NULL,
  `weight` int(3) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`dogId`),
  KEY `ownerId` (`ownerId`),
  KEY `breedid` (`breedid`),
  KEY `secondarybreedid` (`secBreedid`),
  CONSTRAINT `dogs_ibfk_1` FOREIGN KEY (`ownerId`) REFERENCES `users` (`userid`),
  CONSTRAINT `dogs_ibfk_2` FOREIGN KEY (`breedid`) REFERENCES `breeds` (`breedid`),
  CONSTRAINT `secondarybreedid` FOREIGN KEY (`secBreedid`) REFERENCES `breeds` (`breedid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `dogs` WRITE;
/*!40000 ALTER TABLE `dogs` DISABLE KEYS */;

INSERT INTO `dogs` (`dogId`, `ownerId`, `name`, `gender`, `breedid`, `secBreedid`, `age`, `weight`, `description`)
VALUES
	(8,3,'Charlie','m',338,NULL,3,15,'Very cool doggy'),
	(9,4,'Cony','f',130,NULL,4,30,'Crazy!'),
	(10,4,'Rex','m',96,82,2,28,''),
	(23,3,'Roxy','f',56,NULL,6,23,'New doggy in the house!'),
	(24,3,'Arny','f',4,NULL,6,23,'Third Update for description through Postman'),
	(25,3,'Rosy','f',123,NULL,6,23,'doggy in the house!'),
	(28,3,'Archie','m',12,NULL,4,23,'123'),
	(29,3,'Lany','m',354,6,4,8,''),
	(30,3,'Angela','f',123,NULL,6,23,'From Postman doggy in the house!'),
	(32,3,'Cassandra','f',15,3,4,5,'Added through UI'),
	(33,3,'Catty','f',6,NULL,5,12,'Added through UI'),
	(34,3,'Applebee','f',33,NULL,4,10,'Added through UI'),
	(36,3,'Many','f',123,NULL,6,23,'From Postman doggy in the house!'),
	(37,3,'Bobby','m',149,363,7,10,''),
	(38,3,'Ringo','m',131,1,5,12,'Added with generalized entity'),
	(39,3,'Gary','m',362,NULL,5,14,'');

/*!40000 ALTER TABLE `dogs` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table photos
# ------------------------------------------------------------

CREATE TABLE `photos` (
  `photoId` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `dogId` int(6) unsigned NOT NULL,
  `photo` varchar(3000) NOT NULL DEFAULT '',
  PRIMARY KEY (`photoId`),
  KEY `dogId` (`dogId`),
  CONSTRAINT `photos_ibfk_1` FOREIGN KEY (`dogId`) REFERENCES `dogs` (`dogId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `photos` WRITE;
/*!40000 ALTER TABLE `photos` DISABLE KEYS */;

INSERT INTO `photos` (`photoId`, `dogId`, `photo`)
VALUES
	(65,8,'https://images.dog.ceo/breeds/shiba/shiba-13.jpg'),
	(66,28,'https://images.dog.ceo/breeds/terrier-american/n02093428_3329.jpg'),
	(73,39,'https://images.dog.ceo/breeds/whippet/n02091134_19124.jpg'),
	(74,9,'https://images.pexels.com/photos/5549/yellow-dog-pet-labrador-5549.jpg');

/*!40000 ALTER TABLE `photos` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users
# ------------------------------------------------------------

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

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`userid`, `firstname`, `lastname`, `phonenumber`, `email`, `addressid`, `password`)
VALUES
	(3,'Maria','Grigorova','++359899000111','maria@dogs.com',1,'admin'),
	(4,'Georgi','Georgiev','++359877999000','georgi@dogs.com',8,'admin'),
	(5,'Anita','Mario',NULL,'example@test.com',9,'anita');

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
