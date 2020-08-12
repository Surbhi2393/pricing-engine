CREATE DATABASE  IF NOT EXISTS `cycle_pricing`;
USE `cycle_pricing`;

--
-- Table structure for table `cycle_part`
--

DROP TABLE IF EXISTS `cycle_part`;

CREATE TABLE `cycle_part` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `component_name` varchar(45) DEFAULT NULL,
  `part_name` varchar(45) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `valid_from` DATE NOT NULL,
  `valid_to` DATE NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `cycle_part`
--

INSERT INTO `cycle_part` VALUES 
	(1,'Wheel','Tyre',50,'2020-7-04','2020-10-04'),
	(2,'Wheel','Tube',100,'2020-9-04','2020-12-04'),
	(3,'Frame','Top Tube',50,'2020-3-04','2020-6-04'),
	(4,'Wheel','Tyre',70,'2020-10-04','2021-2-04'),
	(5,'Handle Bar','Fork',150,'2020-7-04','2020-9-04'),
	(6,'Seating','Saddle',100,'2020-7-04','2020-9-04'),
	(7,'Seating','Saddle',120,'2020-9-04','2020-11-04'),
	(8,'Chain Assembly','Chain',30,'2020-7-04','2020-9-04');


	
	

