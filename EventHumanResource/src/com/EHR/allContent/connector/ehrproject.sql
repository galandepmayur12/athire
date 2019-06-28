-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ehrproject
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `apply_table`
--

DROP TABLE IF EXISTS `apply_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apply_table` (
  `job_id` decimal(16,0) NOT NULL,
  `freelancer_id` decimal(16,0) NOT NULL,
  `time` timestamp(2) NULL DEFAULT CURRENT_TIMESTAMP(2),
  `bid` int(11) DEFAULT NULL,
  PRIMARY KEY (`job_id`,`freelancer_id`),
  KEY `app_fl_idx` (`freelancer_id`),
  CONSTRAINT `app_fl` FOREIGN KEY (`freelancer_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `app_job` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`job_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply_table`
--

LOCK TABLES `apply_table` WRITE;
/*!40000 ALTER TABLE `apply_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `apply_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `client_id` decimal(16,0) NOT NULL,
  `f_name` varchar(45) NOT NULL,
  `m_name` varchar(45) DEFAULT NULL,
  `l_name` varchar(45) NOT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  `dob` date NOT NULL,
  `add_line1` varchar(45) DEFAULT NULL,
  `add_line2` varchar(45) DEFAULT NULL,
  `street_name` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `zipcode` decimal(6,0) DEFAULT NULL,
  `comp_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE KEY `email_id_UNIQUE` (`email_id`),
  CONSTRAINT `key` FOREIGN KEY (`client_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (123,'Mayur Pravin',NULL,'Galande','galandepmayur@gmail.com','1998-02-12','kothrud',NULL,NULL,'pune',NULL,NULL,411321,'hrs'),(1506197309730,'mayu','null','galande','mayurgrocks@gmail.com','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hdasi'),(1506200013836,'mayu','null','galande','mayurguigrocks@gmail.com','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hdasi'),(1506200193293,'mayu','null','galande','mayu458rguigrocks@gmail.com','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hdasi'),(1506200272260,'mayu','null','galande','mayu458r65guigrocks@gmail.com','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hdasi'),(1506200543002,'mayu','null','galande','mayu458r655guigrocks@gmail.com','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hdasi'),(1506242608574,'mayur','null','null','ghiqeihef@yu.com','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1506242701241,'mayu','null','null','ghiqfsdeihef@yu.com','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1506242714161,'mayu','null','null','ghiqfsdsdfeihef@yu.com','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1506242803951,'mayu','null','null','ghiqfsdassdfeihef@yu.com','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1506242838157,'mayu','null','null','ghiqfsdassadfeihef@yu.com','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1506242889310,'mayu','null','null','gzc','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1506243213280,'mayu','null','null','gzc4','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1506243426729,'mayu','null','null','gzc46','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1506243503343,'mayu','null','null','gzc464','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1506244293219,'mayu','null','null','gzc4647','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1506262836860,'mayu','pravin','galande','gzc4647@asdfig','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'uiadsfy'),(1506264127698,'mayu','pravin','galande','gzc4647@asdfigs','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'uiadsfy'),(1506265199635,'m','pravin','galande','gzc4647@asdfigshd','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'uiadsfy'),(1506292073911,'m','pravin','galande','gzc4647@asdfigshd3','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'uiadsfy'),(1506688613904,'son',NULL,'sad','galandekajsdhpmayur@gmail.com','1998-02-12',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1506689701631,'son',NULL,'sad','agalandekajsdhpmayur@gmail.com','1998-02-12','flat no 103','suyash apartments','pune','behind vedbhavan,kothrud','mahatrashtra','INDIA',411038,NULL),(1506793979731,'Mayur','Pravin','Galande','hello@gmail.com','1998-02-12','flat no 103','suyash apartments','pune','behind vedbhavan,kothrud','mahatrashtra','INDIA',411138,'null'),(1506796322055,'fas','ASDn','D','hi@gmail.com','1998-02-12','flat no 103','suyash apartments','pune','behind vedbhavan,kothrud','mahatrashtra','INDIA',411138,'null'),(1506878927067,'fkapkj','Afgah','Dafpj','falh@fdtr.com','1998-02-12','flat no 103','suyash apartments','pune','behind vedbhavan,kothrud','mahatrashtra','INDIA',411138,'ifsdbh'),(1506879542570,'mayur',NULL,'galande','vikassaini@gmail.com','1998-02-12','flat no 103','suyash apartments','pune','behind vedbhavan,kothrud','mahatrashtra','INDIA',411138,'ifsdbh'),(1507092806797,'Mayur','Pravin','Galande','jh.com','1998-02-12','kothrud','airforce station vimanagar','Pune','airfoce school','Mahatrashtra','INDIA',411015,'null'),(1507092888689,'Mayur','Pravin','Galande','jha.com','1998-02-12','kothrud','airforce station vimanagar','Pune','airfoce school','Mahatrashtra','INDIA',411015,'null'),(1507231304263,'Mayur','Pravin','Galande','clown@gmail.com','1998-02-12','kothrud','airforce station vimanagar','Pune','airfoce school','Mahatrashtra','INDIA',411015,'null'),(1507231390425,'Mayur','Pravin','Galande','clow1n@gmail.com','1998-02-12','kothrud','airforce station vimanagar','Pune','airfoce school','Mahatrashtra','INDIA',411015,'null'),(1507231873653,'Mayur','Pravin','Galande','clow3n@gmail.com','1998-02-12','kothrud','airforce station vimanagar','Pune','airfoce school','Mahatrashtra','INDIA',411015,'null'),(1507232401742,'uyf',NULL,'fukyq','hgd@aew.ctyrs','1998-04-12','456',NULL,NULL,'pune',NULL,NULL,641313,NULL),(1507234381866,'asd',NULL,'sdf','dqas@dfa.fasdkhi','1321-11-11','asd',NULL,NULL,'sdf',NULL,NULL,416544,NULL),(1507234648000,'vikas',NULL,'saini','vikassxaig@gmail.com','1321-11-11','asd',NULL,NULL,'sdf',NULL,NULL,416544,NULL),(1507270224845,'sarth',NULL,'patil','sarthpatil7@gmail.com','1980-12-01','rj',NULL,NULL,'gut',NULL,NULL,123456,NULL),(1507316441540,'asfjh',NULL,'sdfjkh','g@jksag.com','1212-12-12','az',NULL,NULL,'asdjh',NULL,NULL,123456,NULL),(1507557230772,'Vikas',NULL,'Saini','vikas.saini1708@gmail.com','1998-08-17','Lohegaon',NULL,NULL,'Pune',NULL,NULL,411047,NULL),(1507557645143,'Sarth',NULL,'Patil','sarthpatil007@gmail.com','1998-02-02','Chinchwad',NULL,NULL,'Pune',NULL,NULL,411040,NULL),(1507559861057,'Kunal',NULL,'Nevagi','knevagi1@gmail.com','1997-04-11','Saudamini',NULL,NULL,'PUNE',NULL,NULL,411038,'Newton'),(1507565076469,'askfjh',NULL,'l;skd','czkljl@jh.com','1237-12-12','slvjh',NULL,NULL,'pune',NULL,NULL,132456,NULL),(1507664057853,'kunal',NULL,'Nevagi','knevagi@yahoo.com','1997-04-11','Kothrud',NULL,NULL,'Pune',NULL,NULL,411038,'Newton'),(1507667675017,'asd',NULL,'dsf','asd@l.co','1212-12-12','das',NULL,NULL,'as',NULL,NULL,123456,NULL),(1507710014762,'abc',NULL,'xyz','ghi@xyz.com','1998-02-12','lohegaon',NULL,NULL,'pune',NULL,NULL,411038,NULL),(1508916489379,'Mayur Pravin',NULL,'Galande','mayurthetechy.12@gmail.com','1998-02-12','fsdj',NULL,NULL,'Pune',NULL,NULL,411038,'rishmay');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ehrproject`.`client_AFTER_INSERT` AFTER INSERT ON `client` FOR EACH ROW
BEGIN
	insert into notification_table (notification_id,user_id,notification_desc,notification_ref_id) values(UNIX_TIMESTAMP(CURTIME(4)) * 1000,new.client_id,"Welcome User!! Your account has been created successfully",new.client_id);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `credential`
--

DROP TABLE IF EXISTS `credential`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credential` (
  `user_id` decimal(16,0) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `id_idx` (`user_id`),
  KEY `username_idx` (`username`),
  CONSTRAINT `id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `username` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credential`
--

LOCK TABLES `credential` WRITE;
/*!40000 ALTER TABLE `credential` DISABLE KEYS */;
INSERT INTO `credential` VALUES (123,'galandepmayur@gmail.com','Admin@12345'),(1506691052860,'agalandekajsdhpmasayur@gmail.com','Admin@12345'),(1507092888689,'jha.com','hello'),(1507230063172,'jack@gmail.com','123'),(1507230219727,'mayur@gmail.com','123'),(1507231390425,'clow1n@gmail.com','das'),(1507231873653,'clow3n@gmail.com','das'),(1507232401742,'hgd@aew.ctyrs','12345'),(1507232568280,'yfjhf@thdh.com','123'),(1507233773585,'dfs@td.dyt','Admin@123'),(1507234381866,'dqas@dfa.fasdkhi','123456789'),(1507234648000,'vikassxaig@gmail.com','Admin@123'),(1507270224845,'sarthpatil7@gmail.com','Admin@123'),(1507296514016,'sarthpatil07@gmail.com','Sarth@123'),(1507300699176,'abc@gmail.com','Admin@123'),(1507316441540,'g@jksag.com','asjkgh@123Sd'),(1507316493805,'czjhcx@zkvj.com','Admin@123'),(1507316632043,'akdjh@ljksda.com','Admin@123'),(1507317140408,'som@q.com','123'),(1507317639968,'shaktiman@shaktimann.com','Admin@123'),(1507317706012,'shaktiman@shaktimannn.com','Admin@123'),(1507317765146,'asji12@asdkgh112.com','AF123@SSAa'),(1507318417103,'abc1@gmail.com','Admin@123'),(1507318465497,'abc2@gmail.com','Admin@123'),(1507318531325,'mahidfswyfu@dfsjkg.cioh','Admin@123'),(1507318597514,'gsda@sdf.xco','Admin@123'),(1507319040568,'vikas.saini@gmail.com','Vikas@123'),(1507320099472,'aghi@jhs.com','Admin@123'),(1507448237767,'rishirich021@gmail.com','Admin@123'),(1507524539922,'abc4@gmail.com','Admin@123'),(1507557230772,'vikas.saini1708@gmail.com','Vikas@123'),(1507557645143,'sarthpatil007@gmail.com','Sarth@123'),(1507559861057,'knevagi1@gmail.com','Kunal@123'),(1507565076469,'czkljl@jh.com','Dasxe@123'),(1507664057853,'knevagi@yahoo.com','Kunal@123'),(1507665438581,'xyz@abc.com','MIT@nit123'),(1507667675017,'asd@l.co','ads@as1asscS'),(1507710014762,'ghi@xyz.com','Admin@123'),(1507710083629,'dassad@gmail.com','Admin@123'),(1507710245034,'dsa@awaer.com','Vikas@1078'),(1508916489379,'mayurthetechy.12@gmail.com','Admin@123');
/*!40000 ALTER TABLE `credential` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `default_package`
--

DROP TABLE IF EXISTS `default_package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `default_package` (
  `packageid` decimal(16,0) NOT NULL,
  `event_name` varchar(45) NOT NULL,
  `package_type` varchar(35) NOT NULL,
  `event_desc` varchar(300) DEFAULT NULL,
  `package_quote` int(11) DEFAULT NULL,
  PRIMARY KEY (`packageid`),
  CONSTRAINT `pkg_id` FOREIGN KEY (`packageid`) REFERENCES `events` (`event_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `default_package`
--

LOCK TABLES `default_package` WRITE;
/*!40000 ALTER TABLE `default_package` DISABLE KEYS */;
INSERT INTO `default_package` VALUES (1507025264224,'Wedding','Default','Informal event uniting two people in marriage',28000),(1507041479894,'School/College events','Default','Technical or Cultural event in a school or college',26000),(1507041524271,'Birthday','Default','Informal event celebrating the birthday of someone',15000),(1507041558885,'Brand Promotion','Default','Promotion of a company product',58000),(1507041613263,'Business Conclave','Default','Private formal meeting  of a business company',NULL),(1507041654632,'Traditional Events/Pooja','Default','Preparation for various traditional events like pooja ',NULL),(1507041683838,'Theatrical Events','Default','Various events related to music and other arts',NULL),(1507041715275,'Corporate Exhibitions','Default','coming together of various corporations.',NULL);
/*!40000 ALTER TABLE `default_package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_log`
--

DROP TABLE IF EXISTS `event_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_log` (
  `event_id` decimal(16,0) NOT NULL,
  `client_id` decimal(16,0) NOT NULL,
  `event_name` varchar(45) NOT NULL,
  `event_type` varchar(45) DEFAULT NULL,
  `event_desc` varchar(300) DEFAULT NULL,
  `event_date` date NOT NULL,
  `event_location` varchar(45) NOT NULL,
  `event_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `event_status` varchar(45) NOT NULL,
  `event_final` varchar(45) DEFAULT NULL,
  `event_quote` int(11) DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  KEY `cevnt_id_idx` (`client_id`),
  CONSTRAINT `cevnt_id` FOREIGN KEY (`client_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `evnt_id` FOREIGN KEY (`event_id`) REFERENCES `events` (`event_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_log`
--

LOCK TABLES `event_log` WRITE;
/*!40000 ALTER TABLE `event_log` DISABLE KEYS */;
INSERT INTO `event_log` VALUES (1507505039107,123,'Birthday','Default','Informal event uniting two people in marriage','2017-11-27','kothrud\n, Pune','2017-10-08 23:23:59','Upcoming',NULL,28300),(1507667595163,123,'Birthday','Default','Informal event uniting two people in marriage','2021-02-12','Kothrud, Pune','2017-10-10 20:33:15','Upcoming',NULL,28300),(1508822487160,123,'Wedding','Default','Informal event uniting two people in marriage','2030-08-11','saudamini, Los angeles','2017-10-24 05:21:27','Upcoming','True',28300),(1508822525488,123,'Brand Promotion','Default','Promotion of a company product','2020-12-11','Time square, New York','2017-10-24 05:22:05','Upcoming','True',56100),(1508822663734,1507664057853,'Wedding','Default','Informal event uniting two people in marriage','2029-08-11','Malibu, malibu','2017-10-24 05:24:23','Upcoming','True',28300),(1508822691478,1507664057853,'Brand Promotion','Default','Promotion of a company product','2020-09-11','Down town, New York','2017-10-24 05:24:51','Upcoming','True',56100),(1508916563520,1508916489379,'Wedding','Default','Informal event uniting two people in marriage','2018-02-12','mit, pune','2017-10-25 07:29:23','Upcoming','True',28300),(1508917170891,1508916489379,'manu','Custom_event','asfk;l','2018-02-12','ads,Pune','2017-10-25 07:39:30','Upcoming','True',46400);
/*!40000 ALTER TABLE `event_log` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ehrproject`.`event_log_AFTER_INSERT` AFTER INSERT ON `event_log` FOR EACH ROW
BEGIN
insert into notification_table (notification_id,user_id,notification_desc,notification_ref_id) values(UNIX_TIMESTAMP(CURTIME(4)) * 1000,new.client_id,"New event created Successfully!!",new.event_id);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ehrproject`.`event_log_BEFORE_DELETE` BEFORE DELETE ON `event_log` FOR EACH ROW
BEGIN
insert into notification_table (notification_id,user_id,notification_desc,notification_ref_id) values(UNIX_TIMESTAMP(CURTIME(4)) * 1000,old.client_id,"Your event is cancelled successfully but as a fine u will be charged 10% of amount of your event and refund will be made in tw0 woriking days!!!!",old.event_id);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `event_id` decimal(16,0) NOT NULL,
  `event_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1507025264224,'Default'),(1507041479894,'Default'),(1507041524271,'Default'),(1507041558885,'Default'),(1507041613263,'Default'),(1507041654632,'Default'),(1507041683838,'Default'),(1507041715275,'Default'),(1507503260366,'Default'),(1507505039107,'Default'),(1507667595163,'Default'),(1508822487160,'Default'),(1508822525488,'Default'),(1508822663734,'Default'),(1508822691478,'Default'),(1508916563520,'Default'),(1508917170891,'Custom_event');
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `freelancer`
--

DROP TABLE IF EXISTS `freelancer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `freelancer` (
  `freelancer_id` decimal(16,0) NOT NULL,
  `f_name` varchar(45) NOT NULL,
  `m_name` varchar(45) DEFAULT NULL,
  `l_name` varchar(45) NOT NULL,
  `email_id` varchar(45) NOT NULL,
  `dob` varchar(45) NOT NULL,
  `add_line1` varchar(45) DEFAULT NULL,
  `add_line2` varchar(45) DEFAULT NULL,
  `street_name` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `zipcode` decimal(6,0) DEFAULT NULL,
  `work_environment` varchar(45) NOT NULL,
  PRIMARY KEY (`freelancer_id`),
  UNIQUE KEY `email_id_UNIQUE` (`email_id`),
  CONSTRAINT `fkey` FOREIGN KEY (`freelancer_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `freelancer`
--

LOCK TABLES `freelancer` WRITE;
/*!40000 ALTER TABLE `freelancer` DISABLE KEYS */;
INSERT INTO `freelancer` VALUES (1506691052860,'son of ',NULL,'sardar','agalandekajsdhpmasayur@gmail.com','1998-02-12','flat no 103',NULL,NULL,'Pune',NULL,NULL,411038,'In team'),(1507224827216,'son',NULL,'sad','agalandekajasdhpmasayur@gmail.com','1998-02-12','flat no 103','suyash apartments','pune','behind vedbhavan,kothrud','mahatrashtra','INDIA',411038,'Individually and in team'),(1507224931214,'son',NULL,'sad','jasdhpmasayur@gmail.com','1998-02-12','flat no 103','suyash apartments','pune','behind vedbhavan,kothrud','mahatrashtra','INDIA',411038,'no'),(1507230063172,'son',NULL,'sad','jack@gmail.com','1998-02-12','flat no 103','suyash apartments','pune','behind vedbhavan,kothrud','mahatrashtra','INDIA',411038,'yes'),(1507230219727,'masd',NULL,'asd','mayur@gmail.com','1997-02-12','as',NULL,NULL,'pune',NULL,NULL,411038,'qw'),(1507232568280,'yufr',NULL,'fgd','yfjhf@thdh.com','1998-02-12','AS',NULL,NULL,'asd',NULL,NULL,411038,'qw'),(1507233773585,'yf',NULL,'piojh','dfs@td.dyt','1997-03-13','fsda',NULL,NULL,'vhf1',NULL,NULL,456153,'qw'),(1507296514016,'Sarth',NULL,'Patil','sarthpatil07@gmail.com','1998-11-13','Chinchwad',NULL,NULL,'Pune',NULL,NULL,411040,'Individually'),(1507300699176,'xyz',NULL,'abc','abc@gmail.com','1900-05-06','sdf',NULL,NULL,'gnas',NULL,NULL,412345,'Individually'),(1507316493805,'cXZJKL',NULL,'LJKXVHljkh','czjhcx@zkvj.com','1414-12-14','GJK',NULL,NULL,'vz',NULL,NULL,123456,'In team'),(1507316632043,'afsjk',NULL,'dfsjk','akdjh@ljksda.com','1212-12-12','asdh',NULL,NULL,'asdjkh',NULL,NULL,411038,'Individually'),(1507317067959,'son',NULL,'sad','som@gmail.com','1998-02-12','flat no 103','suyash apartments','pune','behind vedbhavan,kothrud','mahatrashtra','INDIA',411038,'yes'),(1507317140408,'son',NULL,'sad','som@q.com','1998-02-12','flat no 103','suyash apartments','pune','behind vedbhavan,kothrud','mahatrashtra','INDIA',411038,'yes'),(1507317639968,'shaktimann',NULL,'shakitman','shaktiman@shaktimann.com','1998-01-12','fgsdjh',NULL,NULL,'city',NULL,NULL,123465,'In team'),(1507317706012,'shaktimann',NULL,'shakitman','shaktiman@shaktimannn.com','1998-01-12','fgsdjh',NULL,NULL,'city',NULL,NULL,123465,'In team'),(1507317765146,'dsg',NULL,'sdg','asji12@asdkgh112.com','1212-12-12','SDFA',NULL,NULL,'svhk',NULL,NULL,121212,'Individually'),(1507318417103,'xyz',NULL,'abc','abc1@gmail.com','1900-05-06','sdf',NULL,NULL,'gnas',NULL,NULL,412345,'Individually'),(1507318465497,'xyz',NULL,'abc','abc2@gmail.com','1900-05-06','sdf',NULL,NULL,'gnas',NULL,NULL,412345,'Individually'),(1507318531325,'sdg',NULL,'sdf','mahidfswyfu@dfsjkg.cioh','1998-12-12','k',NULL,NULL,'df',NULL,NULL,123564,'Individually'),(1507318597514,'df',NULL,'sg','gsda@sdf.xco','1998-02-12','asd',NULL,NULL,'Apno',NULL,NULL,123456,'Individually'),(1507319040568,'Vikas',NULL,'Saini','vikas.saini@gmail.com','1998-08-17','Lohegaon',NULL,NULL,'Pune',NULL,NULL,411047,'Individually and in team'),(1507320099472,'bz',NULL,'fdg','aghi@jhs.com','1298-12-12','dfskojh',NULL,NULL,'asdf',NULL,NULL,415415,'Individually and in team'),(1507448237767,'Rishikesh',NULL,'Galande','rishirich021@gmail.com','1987-04-13','katowice,poland',NULL,NULL,'Katowice',NULL,NULL,415625,'Individually and In team'),(1507524539922,'xyz',NULL,'abc','abc4@gmail.com','1998-02-12','gfhhgf',NULL,NULL,'ctsd',NULL,NULL,411038,'Individually and In team'),(1507665438581,'ABC',NULL,'XYZ','xyz@abc.com','1998-12-12','Mit',NULL,NULL,'Pune',NULL,NULL,411038,'Individually and In team'),(1507709543989,'Vikas',NULL,'Saini','monster.vicky1708@gmail.com','1998-08-17','Lohegaon',NULL,NULL,'Pune',NULL,NULL,411047,'Individually'),(1507709688655,'Vikas',NULL,'Saini','monster.vicky170@gmail.com','1998-08-17','Lohegaon',NULL,NULL,'Pune',NULL,NULL,411047,'Individually'),(1507710083629,'zqwe',NULL,'eqw','dassad@gmail.com','1998-02-12','adskjh',NULL,NULL,'pune',NULL,NULL,123546,'Individually and In team'),(1507710167234,'ads',NULL,'jlk','dsa@wer.com','1212-12-12','asfkj',NULL,NULL,'pune',NULL,NULL,123456,'Individually'),(1507710199552,'ads',NULL,'jlk','dsa@waer.com','1212-12-12','asfkj',NULL,NULL,'pune',NULL,NULL,123456,'Individually and In team'),(1507710245034,'ads',NULL,'jlk','dsa@awaer.com','1212-12-12','asfkj',NULL,NULL,'pune',NULL,NULL,123456,'Individually and In team');
/*!40000 ALTER TABLE `freelancer` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ehrproject`.`freelancer_AFTER_INSERT` AFTER INSERT ON `freelancer` FOR EACH ROW
BEGIN
	insert into notification_table (notification_id,user_id,notification_desc,notification_ref_id) values(UNIX_TIMESTAMP(CURTIME(4)) * 1000,new.freelancer_id,"Welcome User!! Your account has been created successfully",new.freelancer_id);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `freelancer_schedule`
--

DROP TABLE IF EXISTS `freelancer_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `freelancer_schedule` (
  `freelancer_id` decimal(16,0) NOT NULL,
  `job_id` decimal(16,0) NOT NULL,
  `slot` date DEFAULT NULL,
  PRIMARY KEY (`freelancer_id`,`job_id`),
  KEY `sch_job_idx` (`job_id`),
  CONSTRAINT `fid` FOREIGN KEY (`freelancer_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sch_job` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`job_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `freelancer_schedule`
--

LOCK TABLES `freelancer_schedule` WRITE;
/*!40000 ALTER TABLE `freelancer_schedule` DISABLE KEYS */;
INSERT INTO `freelancer_schedule` VALUES (1506691052860,12345,'2017-10-08'),(1506691052860,1507505039321,'2017-10-10'),(1506691052860,1507505039334,'2017-10-10');
/*!40000 ALTER TABLE `freelancer_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `has_skill`
--

DROP TABLE IF EXISTS `has_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `has_skill` (
  `skill_id` decimal(16,0) NOT NULL,
  `freelancer_id` decimal(16,0) NOT NULL,
  `skill_name` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY (`skill_id`,`freelancer_id`),
  KEY `has_f_idx` (`freelancer_id`),
  CONSTRAINT `has_f` FOREIGN KEY (`freelancer_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `has_s` FOREIGN KEY (`skill_id`) REFERENCES `skill_set` (`skill_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `has_skill`
--

LOCK TABLES `has_skill` WRITE;
/*!40000 ALTER TABLE `has_skill` DISABLE KEYS */;
INSERT INTO `has_skill` VALUES (1507025170669,1506691052860,'Photographer','agalandekajsdhpmasayur@gmail.com'),(1507025170669,1507316493805,'Photographer','czjhcx@zkvj.com'),(1507025170669,1507317765146,'Photographer','asji12@asdkgh112.com'),(1507025170669,1507318417103,'Photographer','abc1@gmail.com'),(1507025170669,1507318465497,'Photographer','abc2@gmail.com'),(1507025170669,1507318531325,'Photographer','mahidfswyfu@dfsjkg.cioh'),(1507025170669,1507318597514,'Photographer','gsda@sdf.xco'),(1507025170669,1507319040568,'Photographer','vikas.saini@gmail.com'),(1507025170669,1507448237767,'Photographer','rishirich021@gmail.com'),(1507025170669,1507524539922,'Photographer','abc4@gmail.com'),(1507025170669,1507665438581,'Photographer','xyz@abc.com'),(1507025170669,1507709543989,'Photographer','monster.vicky1708@gmail.com'),(1507025170669,1507709688655,'Photographer','monster.vicky170@gmail.com'),(1507025170669,1507710083629,'Photographer','dassad@gmail.com'),(1507025170669,1507710167234,'Photographer','dsa@wer.com'),(1507025170669,1507710199552,'Photographer','dsa@waer.com'),(1507025191495,1507318417103,'Anchor','abc1@gmail.com'),(1507025191495,1507318465497,'Anchor','abc2@gmail.com'),(1507025191495,1507318531325,'Anchor','mahidfswyfu@dfsjkg.cioh'),(1507025191495,1507710245034,'Anchor','dsa@awaer.com'),(1507025201373,1506691052860,'Designer','agalandekajsdhpmasayur@gmail.com'),(1507025201373,1507316493805,'Designer','czjhcx@zkvj.com'),(1507025201373,1507448237767,'Designer','rishirich021@gmail.com'),(1507025201373,1507524539922,'Designer','abc4@gmail.com'),(1507025201373,1507665438581,'Designer','xyz@abc.com'),(1507025201373,1507710083629,'Designer','dassad@gmail.com'),(1507025212763,1507317639968,'Caterers','shaktiman@shaktimann.com'),(1507025212763,1507317706012,'Caterers','shaktiman@shaktimannn.com'),(1507025223099,1507316632043,'Promoter','akdjh@ljksda.com'),(1507025223099,1507317639968,'Promoter','shaktiman@shaktimann.com'),(1507025223099,1507317706012,'Promoter','shaktiman@shaktimannn.com'),(1507025223099,1507319040568,'Promoter','vikas.saini@gmail.com'),(1507025223099,1507524539922,'Promoter','abc4@gmail.com'),(1507025230914,1507319040568,'Sound System','vikas.saini@gmail.com'),(1507025230914,1507320099472,'Sound System','aghi@jhs.com'),(1507025230914,1507448237767,'Sound System','rishirich021@gmail.com'),(1507025243393,1507317067959,'Singer ','som@gmail.com'),(1507025243393,1507317140408,'Singer ','som@q.com'),(1507025243393,1507319040568,'Singer','vikas.saini@gmail.com'),(1507025243393,1507320099472,'Singer','aghi@jhs.com'),(1507025254852,1507316632043,'Volunteer','akdjh@ljksda.com'),(1507025254852,1507317639968,'Volunteer','shaktiman@shaktimann.com'),(1507025254852,1507317706012,'Volunteer','shaktiman@shaktimannn.com'),(1507025264224,1507316632043,'Event_Organizer','akdjh@ljksda.com'),(1507025264224,1507319040568,'Event_Organizer','vikas.saini@gmail.com'),(1507025264224,1507320099472,'Event_Organizer','aghi@jhs.com'),(1507025264224,1507448237767,'Event_Organizer','rishirich021@gmail.com'),(1507296145125,1506691052860,'Choreographer','agalandekajsdhpmasayur@gmail.com'),(1507296145125,1507316493805,'Choreographer','czjhcx@zkvj.com'),(1507296145125,1507317765146,'Choreographer','asji12@asdkgh112.com'),(1507296145125,1507318417103,'Choreographer','abc1@gmail.com'),(1507296145125,1507318465497,'Choreographer','abc2@gmail.com'),(1507296145125,1507318531325,'Choreographer','mahidfswyfu@dfsjkg.cioh'),(1507296145125,1507318597514,'Choreographer','gsda@sdf.xco'),(1507296145125,1507448237767,'Choreographer','rishirich021@gmail.com'),(1507296145125,1507524539922,'Choreographer','abc4@gmail.com'),(1507296145125,1507665438581,'Choreographer','xyz@abc.com'),(1507296145125,1507709543989,'Choreographer','monster.vicky1708@gmail.com'),(1507296145125,1507709688655,'Choreographer','monster.vicky170@gmail.com'),(1507296145125,1507710083629,'Choreographer','dassad@gmail.com'),(1507296145125,1507710167234,'Choreographer','dsa@wer.com'),(1507296145125,1507710199552,'Choreographer','dsa@waer.com');
/*!40000 ALTER TABLE `has_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobs` (
  `job_id` decimal(16,0) NOT NULL,
  `job_title` varchar(45) NOT NULL,
  `job_desc` varchar(200) DEFAULT NULL,
  `job_skill` decimal(16,0) DEFAULT NULL,
  `status` varchar(45) NOT NULL,
  `assign_status` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `client_id` decimal(16,0) NOT NULL,
  `freelancer_id` decimal(16,0) DEFAULT NULL,
  `wage` int(11) DEFAULT NULL,
  `event_id` decimal(16,0) DEFAULT NULL,
  `work_environment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  KEY `f_job_idx` (`freelancer_id`),
  KEY `c_job_idx` (`client_id`),
  KEY `s_job_idx` (`job_skill`),
  KEY `e_job_idx` (`event_id`),
  CONSTRAINT `c_job` FOREIGN KEY (`client_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `e_job` FOREIGN KEY (`event_id`) REFERENCES `events` (`event_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `f_job` FOREIGN KEY (`freelancer_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `s_job` FOREIGN KEY (`job_skill`) REFERENCES `skill_set` (`skill_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` VALUES (12345,'afgh','jh',1507025170669,'Live','Assigned','2017-10-09',123,1506691052860,3500,NULL,'In team'),(1507505039309,'CaterersNeeded!!','Caterers needed for a Default event on 2017-11-27 at kothrud\n, Pune',1507025212763,'Live','Not Assigned','2017-11-27',123,0,10000,1507505039107,'In team'),(1507505039321,'PhotographerNeeded!!','Photographer needed for a Default event on 2017-11-27 at kothrud\n, Pune',1507025170669,'Live','Assigned','2017-11-27',123,1506691052860,3500,1507505039107,'In team'),(1507505039334,'PhotographerNeeded!!','Photographer needed for a Default event on 2017-11-27 at kothrud\n, Pune',1507025170669,'Live','Assigned','2017-11-27',123,1506691052860,3500,1507505039107,'In team'),(1507505039347,'PhotographerNeeded!!','Photographer needed for a Default event on 2017-11-27 at kothrud\n, Pune',1507025170669,'Live','Not Assigned','2017-11-27',123,0,3500,1507505039107,'In team'),(1507505039362,'DecoratorsNeeded!!','Decorators needed for a Default event on 2017-11-27 at kothrud\n, Pune',1507363726296,'Live','Not Assigned','2017-11-27',123,0,2000,1507505039107,'In team'),(1507505039433,'Sound_SystemNeeded!!','Sound_System needed for a Default event on 2017-11-27 at kothrud\n, Pune',1507025230914,'Live','Not Assigned','2017-11-27',123,0,3250,1507505039107,'In team'),(1507667595554,'CaterersNeeded!!','Caterers needed for a Default event on 2021-2-12 at Kothrud, Pune',1507025212763,'Live','Not Assigned','2021-02-12',0,0,10000,1507667595163,'In team'),(1507667595591,'PhotographerNeeded!!','Photographer needed for a Default event on 2021-2-12 at Kothrud, Pune',1507025170669,'Live','Not Assigned','2021-02-12',0,0,3500,1507667595163,'In team'),(1507667595603,'PhotographerNeeded!!','Photographer needed for a Default event on 2021-2-12 at Kothrud, Pune',1507025170669,'Live','Not Assigned','2021-02-12',0,0,3500,1507667595163,'In team'),(1507667595641,'PhotographerNeeded!!','Photographer needed for a Default event on 2021-2-12 at Kothrud, Pune',1507025170669,'Live','Not Assigned','2021-02-12',0,0,3500,1507667595163,'In team'),(1507667595652,'DecoratorsNeeded!!','Decorators needed for a Default event on 2021-2-12 at Kothrud, Pune',1507363726296,'Live','Not Assigned','2021-02-12',0,0,2000,1507667595163,'In team'),(1507667595665,'Sound_SystemNeeded!!','Sound_System needed for a Default event on 2021-2-12 at Kothrud, Pune',1507025230914,'Live','Not Assigned','2021-02-12',0,0,3250,1507667595163,'In team'),(1508822487328,'Caterers','Informal event uniting two people in marriage',1507025212763,'Live','Not Assigned','2030-08-11',123,0,10000,1508822487160,'In team'),(1508822487339,'Photographer','Informal event uniting two people in marriage',1507025170669,'Live','Not Assigned','2030-08-11',123,0,3500,1508822487160,'In team'),(1508822487378,'Photographer','Informal event uniting two people in marriage',1507025170669,'Live','Not Assigned','2030-08-11',123,0,3500,1508822487160,'In team'),(1508822487390,'Photographer','Informal event uniting two people in marriage',1507025170669,'Live','Not Assigned','2030-08-11',123,0,3500,1508822487160,'In team'),(1508822487403,'Decorators','Informal event uniting two people in marriage',1507363726296,'Live','Not Assigned','2030-08-11',123,0,2000,1508822487160,'In team'),(1508822487415,'Sound_System','Informal event uniting two people in marriage',1507025230914,'Live','Not Assigned','2030-08-11',123,0,3250,1508822487160,'In team'),(1508822525758,'Promoter','Promotion of a company product',1507025223099,'Live','Not Assigned','2020-12-11',123,0,10000,1508822525488,'In team'),(1508822525770,'Promoter','Promotion of a company product',1507025223099,'Live','Not Assigned','2020-12-11',123,0,10000,1508822525488,'In team'),(1508822525790,'Promoter','Promotion of a company product',1507025223099,'Live','Not Assigned','2020-12-11',123,0,10000,1508822525488,'In team'),(1508822525803,'Designer','Promotion of a company product',1507025201373,'Live','Not Assigned','2020-12-11',123,0,7900,1508822525488,'In team'),(1508822525815,'Designer','Promotion of a company product',1507025201373,'Live','Not Assigned','2020-12-11',123,0,7900,1508822525488,'In team'),(1508822525853,'Anchor','Promotion of a company product',1507025191495,'Live','Not Assigned','2020-12-11',123,0,2000,1508822525488,'In team'),(1508822525939,'Sound_System','Promotion of a company product',1507025230914,'Live','Not Assigned','2020-12-11',123,0,3250,1508822525488,'In team'),(1508822664022,'Caterers','Informal event uniting two people in marriage',1507025212763,'Live','Not Assigned','2029-08-11',1507664057853,0,10000,1508822663734,'In team'),(1508822664046,'Photographer','Informal event uniting two people in marriage',1507025170669,'Live','Not Assigned','2029-08-11',1507664057853,0,3500,1508822663734,'In team'),(1508822664075,'Photographer','Informal event uniting two people in marriage',1507025170669,'Live','Not Assigned','2029-08-11',1507664057853,0,3500,1508822663734,'In team'),(1508822664105,'Photographer','Informal event uniting two people in marriage',1507025170669,'Live','Not Assigned','2029-08-11',1507664057853,0,3500,1508822663734,'In team'),(1508822664133,'Decorators','Informal event uniting two people in marriage',1507363726296,'Live','Not Assigned','2029-08-11',1507664057853,0,2000,1508822663734,'In team'),(1508822664171,'Sound_System','Informal event uniting two people in marriage',1507025230914,'Live','Not Assigned','2029-08-11',1507664057853,0,3250,1508822663734,'In team'),(1508822691619,'Promoter','Promotion of a company product',1507025223099,'Live','Not Assigned','2020-09-11',1507664057853,0,10000,1508822691478,'In team'),(1508822691631,'Promoter','Promotion of a company product',1507025223099,'Live','Not Assigned','2020-09-11',1507664057853,0,10000,1508822691478,'In team'),(1508822691644,'Promoter','Promotion of a company product',1507025223099,'Live','Not Assigned','2020-09-11',1507664057853,0,10000,1508822691478,'In team'),(1508822691656,'Designer','Promotion of a company product',1507025201373,'Live','Not Assigned','2020-09-11',1507664057853,0,7900,1508822691478,'In team'),(1508822691669,'Designer','Promotion of a company product',1507025201373,'Live','Not Assigned','2020-09-11',1507664057853,0,7900,1508822691478,'In team'),(1508822691681,'Anchor','Promotion of a company product',1507025191495,'Live','Not Assigned','2020-09-11',1507664057853,0,2000,1508822691478,'In team'),(1508822691719,'Sound_System','Promotion of a company product',1507025230914,'Live','Not Assigned','2020-09-11',1507664057853,0,3250,1508822691478,'In team'),(1508916563798,'Caterers','Informal event uniting two people in marriage',1507025212763,'Live','Not Assigned','2018-02-12',1508916489379,0,10000,1508916563520,'In team'),(1508916563828,'Photographer','Informal event uniting two people in marriage',1507025170669,'Live','Not Assigned','2018-02-12',1508916489379,0,3500,1508916563520,'In team'),(1508916563840,'Photographer','Informal event uniting two people in marriage',1507025170669,'Live','Not Assigned','2018-02-12',1508916489379,0,3500,1508916563520,'In team'),(1508916563853,'Photographer','Informal event uniting two people in marriage',1507025170669,'Live','Not Assigned','2018-02-12',1508916489379,0,3500,1508916563520,'In team'),(1508916563874,'Decorators','Informal event uniting two people in marriage',1507363726296,'Live','Not Assigned','2018-02-12',1508916489379,0,2000,1508916563520,'In team'),(1508916563887,'Sound_System','Informal event uniting two people in marriage',1507025230914,'Live','Not Assigned','2018-02-12',1508916489379,0,3250,1508916563520,'In team'),(1508917171138,'Promoter','asfk;l',1507025223099,'Live','Not Assigned','2018-02-12',1508916489379,0,10000,1508917170891,'In team'),(1508917171151,'Promoter','asfk;l',1507025223099,'Live','Not Assigned','2018-02-12',1508916489379,0,10000,1508917170891,'In team'),(1508917171172,'Photographer','asfk;l',1507025170669,'Live','Not Assigned','2018-02-12',1508916489379,0,3500,1508917170891,'In team'),(1508917171235,'Event_Organizer','asfk;l',1507025264224,'Live','Not Assigned','2018-02-12',1508916489379,0,9000,1508917170891,'In team'),(1508917171247,'Sound_System','asfk;l',1507025230914,'Live','Not Assigned','2018-02-12',1508916489379,0,3250,1508917170891,'In team'),(1508917171261,'Sound_System','asfk;l',1507025230914,'Live','Not Assigned','2018-02-12',1508916489379,0,3250,1508917170891,'In team'),(1508917171298,'Sound_System','asfk;l',1507025230914,'Live','Not Assigned','2018-02-12',1508916489379,0,3250,1508917170891,'In team');
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ehrproject`.`jobs_AFTER_UPDATE` AFTER UPDATE ON `jobs` FOR EACH ROW
BEGIN

if old.assign_status = 'Not Assigned' and new.assign_status='Assigned'
then 
insert into notification_table (notification_id,user_id,notification_desc,notification_ref_id) values(UNIX_TIMESTAMP(CURTIME(4)) * 1000,new.freelancer_id,"Job has been assigned To You!!",new.job_id);
insert into notification_table (notification_id,user_id,notification_desc,notification_ref_id) values((UNIX_TIMESTAMP(CURTIME(4)) * 1000) + 1,new.client_id,"Job from your event got assigned !!",new.job_id);
end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ehrproject`.`jobs_BEFORE_DELETE` BEFORE DELETE ON `jobs` FOR EACH ROW
BEGIN
insert into notification_table (notification_id,user_id,notification_desc,notification_ref_id) values(UNIX_TIMESTAMP(CURTIME(4)) * 1000,old.freelancer_id,"Job which was assigned To You has been dropped. Sorry for the inconvience caused !!",old.job_id);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `notification_table`
--

DROP TABLE IF EXISTS `notification_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification_table` (
  `notification_id` decimal(16,0) NOT NULL,
  `user_id` decimal(16,0) NOT NULL,
  `notification_desc` varchar(300) DEFAULT NULL,
  `notification_ref_id` decimal(16,0) DEFAULT NULL,
  `notification_status` varchar(45) DEFAULT 'Not Seen',
  PRIMARY KEY (`notification_id`),
  KEY `usid_idx` (`user_id`),
  CONSTRAINT `usid` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification_table`
--

LOCK TABLES `notification_table` WRITE;
/*!40000 ALTER TABLE `notification_table` DISABLE KEYS */;
INSERT INTO `notification_table` VALUES (1507565076517,1507565076469,'Welcome User!! Your account is been created successfully',1507565076469,'Not Seen'),(1507601246894,1506691052860,'Job is been assigned To You!!',1507505039321,'Seen'),(1507601246895,123,'Job from your event got assigned !!',1507505039321,'Seen'),(1507601247130,1506691052860,'Job is been assigned To You!!',1507503481954,'Seen'),(1507601247131,123,'Job from your event got assigned !!',1507503481954,'Seen'),(1507601846887,1506691052860,'Job is been assigned To You!!',1507503482060,'Seen'),(1507601846888,123,'Job from your event got assigned !!',1507503482060,'Seen'),(1507611497846,123,'New event created Successfully!!',1507611497758,'Seen'),(1507612046439,1506691052860,'Job is been assigned To You!!',1507505039334,'Seen'),(1507612046440,123,'Job from your event got assigned !!',1507505039334,'Seen'),(1507613868233,123,'New event created Successfully!!',1507613868141,'Seen'),(1507614009568,123,'New event created Successfully!!',1507614009496,'Seen'),(1507614094120,123,'New event created Successfully!!',1507614094088,'Seen'),(1507614181034,123,'New event created Successfully!!',1507614180975,'Seen'),(1507614932132,123,'New event created Successfully!!',1507614932080,'Seen'),(1507615117711,123,'New event created Successfully!!',1507615117657,'Seen'),(1507625354801,123,'New event created Successfully!!',1507625354697,'Seen'),(1507637733525,123,'New event created Successfully!!',1507637733484,'Seen'),(1507646295746,123,'New event created Successfully!!',1507646295628,'Seen'),(1507658521569,123,'New event created Successfully!!',1507658521474,'Seen'),(1507664057890,1507664057853,'Welcome User!! Your account has been created successfully',1507664057853,'Seen'),(1507665438635,1507665438581,'Welcome User!! Your account has been created successfully',1507665438581,'Not Seen'),(1507666046598,1507665438581,'Job is been assigned To You!!',1507450146968,'Not Seen'),(1507666046599,123,'Job from your event got assigned !!',1507450146968,'Seen'),(1507666046936,1507665438581,'Job is been assigned To You!!',1507450147104,'Not Seen'),(1507666046937,123,'Job from your event got assigned !!',1507450147104,'Seen'),(1507666474979,123,'New event created Successfully!!',1507666474903,'Seen'),(1507667595230,123,'New event created Successfully!!',1507667595163,'Seen'),(1507667675064,1507667675017,'Welcome User!! Your account has been created successfully',1507667675017,'Not Seen'),(1507668136990,123,'New event created Successfully!!',1507668136935,'Seen'),(1507709544166,1507709543989,'Welcome User!! Your account has been created successfully',1507709543989,'Not Seen'),(1507709688765,1507709688655,'Welcome User!! Your account has been created successfully',1507709688655,'Not Seen'),(1507710014884,1507710014762,'Welcome User!! Your account has been created successfully',1507710014762,'Not Seen'),(1507710083667,1507710083629,'Welcome User!! Your account has been created successfully',1507710083629,'Not Seen'),(1507710167280,1507710167234,'Welcome User!! Your account has been created successfully',1507710167234,'Not Seen'),(1507710199586,1507710199552,'Welcome User!! Your account has been created successfully',1507710199552,'Not Seen'),(1507710245056,1507710245034,'Welcome User!! Your account has been created successfully',1507710245034,'Not Seen'),(1508822487218,123,'New event created Successfully!!',1508822487160,'Seen'),(1508822525529,123,'New event created Successfully!!',1508822525488,'Seen'),(1508822663786,1507664057853,'New event created Successfully!!',1508822663734,'Not Seen'),(1508822691493,1507664057853,'New event created Successfully!!',1508822691478,'Not Seen'),(1508916489611,1508916489379,'Welcome User!! Your account has been created successfully',1508916489379,'Seen'),(1508916563590,1508916489379,'New event created Successfully!!',1508916563520,'Seen'),(1508917170937,1508916489379,'New event created Successfully!!',1508917170891,'Seen');
/*!40000 ALTER TABLE `notification_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_no`
--

DROP TABLE IF EXISTS `phone_no`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone_no` (
  `ph_no` decimal(15,0) NOT NULL,
  `username` varchar(45) NOT NULL,
  `user_id` decimal(16,0) NOT NULL,
  PRIMARY KEY (`ph_no`,`username`),
  KEY `c_id_idx` (`username`),
  CONSTRAINT `uname` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_no`
--

LOCK TABLES `phone_no` WRITE;
/*!40000 ALTER TABLE `phone_no` DISABLE KEYS */;
INSERT INTO `phone_no` VALUES (0,'shaktiman@shaktimann.com',1507317639968),(0,'shaktiman@shaktimannn.com',1507317706012),(948748,'gzc4647@asdfigshd',1506265199635),(948748,'gzc4647@asdfigshd3',1506292073911),(45674748,'gzc4647@asdfigshd',1506265199635),(45674748,'gzc4647@asdfigshd3',1506292073911),(1111111111,'dfs@td.dyt',1507233773585),(1111111111,'monster.vicky1708@gmail.com',1507709543989),(1111111111,'monster.vicky170@gmail.com',1507709688655),(1211111111,'dsa@awaer.com',1507710245034),(1211111111,'dsa@waer.com',1507710199552),(1211111111,'dsa@wer.com',1507710167234),(1234567890,'abc1@gmail.com',1507318417103),(1234567890,'abc2@gmail.com',1507318465497),(1234567890,'abc@gmail.com',1507300699176),(1234567890,'asd@l.co',1507667675017),(1234567890,'czkljl@jh.com',1507565076469),(1234567890,'dassad@gmail.com',1507710083629),(1234567890,'g@jksag.com',1507316441540),(1234567890,'ghi@xyz.com',1507710014762),(1234567890,'hgd@aew.ctyrs',1507232401742),(1234567890,'mayur@gmail.com',1507230219727),(1234567890,'sarthpatil7@gmail.com',1507270224845),(1234567890,'yfjhf@thdh.com',1507232568280),(1234567891,'czjhcx@zkvj.com',1507316493805),(1235647890,'akdjh@ljksda.com',1507316632043),(1235647890,'asji12@asdkgh112.com',1507317765146),(1235647890,'vikassxaig@gmail.com',1507234648000),(1236578907,'aghi@jhs.com',1507320099472),(1324569780,'mahidfswyfu@dfsjkg.cioh',1507318531325),(1324845641,'dqas@dfa.fasdkhi',1507234381866),(1328656487,'gsda@sdf.xco',1507318597514),(8007295026,'vikas.saini1708@gmail.com',1507557230772),(8007295026,'vikas.saini@gmail.com',1507319040568),(8698506086,'sarthpatil007@gmail.com',1507557645143),(8698506086,'sarthpatil07@gmail.com',1507296514016),(9000010000,'abc4@gmail.com',1507524539922),(9111111111,'xyz@abc.com',1507665438581),(9241164154,'knevagi@yahoo.com',1507664057853),(9762272834,'agalandekajasdhpmasayur@gmail.com',1507224827216),(9762272834,'agalandekajsdhpmasayur@gmail.com',1506691052860),(9762272834,'agalandekajsdhpmayur@gmail.com',1506689701631),(9762272834,'clow1n@gmail.com',1507231390425),(9762272834,'clow3n@gmail.com',1507231873653),(9762272834,'clown@gmail.com',1507231304263),(9762272834,'falh@fdtr.com',1506878927067),(9762272834,'galandekajsdhpmayur@gmail.com',1506688613904),(9762272834,'galandepmayur@gmail.com',123),(9762272834,'hello@gmail.com',1506793979731),(9762272834,'hi@gmail.com',1506796322055),(9762272834,'jack@gmail.com',1507230063172),(9762272834,'jasdhpmasayur@gmail.com',1507224931214),(9762272834,'jh.com',1507092806797),(9762272834,'jha.com',1507092888689),(9762272834,'som@gmail.com',1507317067959),(9762272834,'som@q.com',1507317140408),(9762272834,'vikassaini@gmail.com',1506879542570),(9762601241,'rishirich021@gmail.com',1507448237767),(9822213047,'knevagi1@gmail.com',1507559861057),(9923301694,'agalandekajasdhpmasayur@gmail.com',1507224827216),(9923301694,'agalandekajsdhpmasayur@gmail.com',1506691052860),(9923301694,'agalandekajsdhpmayur@gmail.com',1506689701631),(9923301694,'clow1n@gmail.com',1507231390425),(9923301694,'clow3n@gmail.com',1507231873653),(9923301694,'clown@gmail.com',1507231304263),(9923301694,'falh@fdtr.com',1506878927067),(9923301694,'galandekajsdhpmayur@gmail.com',1506688613904),(9923301694,'galandepmayur@gmail.com',123),(9923301694,'hello@gmail.com',1506793979731),(9923301694,'hi@gmail.com',1506796322055),(9923301694,'jack@gmail.com',1507230063172),(9923301694,'jasdhpmasayur@gmail.com',1507224931214),(9923301694,'jh.com',1507092806797),(9923301694,'jha.com',1507092888689),(9923301694,'mayurthetechy.12@gmail.com',1508916489379),(9923301694,'som@gmail.com',1507317067959),(9923301694,'som@q.com',1507317140408),(9923301694,'vikassaini@gmail.com',1506879542570);
/*!40000 ALTER TABLE `phone_no` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session_table`
--

DROP TABLE IF EXISTS `session_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `session_table` (
  `user_id` decimal(16,0) NOT NULL,
  `token` varchar(45) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `created` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`token`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  KEY `uname_idx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session_table`
--

LOCK TABLES `session_table` WRITE;
/*!40000 ALTER TABLE `session_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `session_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill_needed`
--

DROP TABLE IF EXISTS `skill_needed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill_needed` (
  `skill_id` decimal(16,0) NOT NULL,
  `event_id` decimal(16,0) NOT NULL,
  `skill_name` varchar(45) DEFAULT NULL,
  `require_no` decimal(3,0) DEFAULT NULL,
  PRIMARY KEY (`event_id`,`skill_id`),
  KEY `id_evnt_idx` (`event_id`),
  CONSTRAINT `id_evnt` FOREIGN KEY (`event_id`) REFERENCES `events` (`event_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill_needed`
--

LOCK TABLES `skill_needed` WRITE;
/*!40000 ALTER TABLE `skill_needed` DISABLE KEYS */;
INSERT INTO `skill_needed` VALUES (1507025170669,1507025264224,'Photographer',3),(1507025212763,1507025264224,'Caterers',1),(1507025230914,1507025264224,'Sound_System',1),(1507363726296,1507025264224,'Decorators',1),(1507025170669,1507041479894,'Photographer',3),(1507025191495,1507041479894,'Anchor',1),(1507025201373,1507041479894,'Designer',1),(1507025230914,1507041479894,'Sound_System',1),(1507025170669,1507041524271,'Photographer',2),(1507025191495,1507041524271,'Anchor',1),(1507025230914,1507041524271,'Sound_System',1),(1507363726296,1507041524271,'Decorators',1),(1507025191495,1507041558885,'Anchor',1),(1507025201373,1507041558885,'Designer',2),(1507025223099,1507041558885,'Promoter',3),(1507025230914,1507041558885,'Sound_System',1),(1507025170669,1507505039107,'Photographer',3),(1507025212763,1507505039107,'Caterers',1),(1507025230914,1507505039107,'Sound_System',1),(1507363726296,1507505039107,'Decorators',1),(1507025170669,1507667595163,'Photographer',3),(1507025212763,1507667595163,'Caterers',1),(1507025230914,1507667595163,'Sound_System',1),(1507363726296,1507667595163,'Decorators',1),(1507025170669,1508822487160,'Photographer',3),(1507025212763,1508822487160,'Caterers',1),(1507025230914,1508822487160,'Sound_System',1),(1507363726296,1508822487160,'Decorators',1),(1507025191495,1508822525488,'Anchor',1),(1507025201373,1508822525488,'Designer',2),(1507025223099,1508822525488,'Promoter',3),(1507025230914,1508822525488,'Sound_System',1),(1507025170669,1508822663734,'Photographer',3),(1507025212763,1508822663734,'Caterers',1),(1507025230914,1508822663734,'Sound_System',1),(1507363726296,1508822663734,'Decorators',1),(1507025191495,1508822691478,'Anchor',1),(1507025201373,1508822691478,'Designer',2),(1507025223099,1508822691478,'Promoter',3),(1507025230914,1508822691478,'Sound_System',1),(1507025170669,1508916563520,'Photographer',3),(1507025212763,1508916563520,'Caterers',1),(1507025230914,1508916563520,'Sound_System',1),(1507363726296,1508916563520,'Decorators',1),(1507025170669,1508917170891,'Photographer',1),(1507025223099,1508917170891,'Promoter',2),(1507025230914,1508917170891,'Sound_System',3),(1507025264224,1508917170891,'Event_Organizer',1);
/*!40000 ALTER TABLE `skill_needed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill_set`
--

DROP TABLE IF EXISTS `skill_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill_set` (
  `skill_id` decimal(16,0) NOT NULL,
  `skill_name` varchar(45) NOT NULL,
  `skill_cost` int(11) DEFAULT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill_set`
--

LOCK TABLES `skill_set` WRITE;
/*!40000 ALTER TABLE `skill_set` DISABLE KEYS */;
INSERT INTO `skill_set` VALUES (1507025170669,'Photographer',3500),(1507025191495,'Anchor',2000),(1507025201373,'Designer',7900),(1507025212763,'Caterers',10000),(1507025223099,'Promoter',10000),(1507025230914,'Sound_System',3250),(1507025243393,'Singer',4500),(1507025254852,'Volunteer',500),(1507025264224,'Event_Organizer',9000),(1507296145125,'Choreographer',5000),(1507363726296,'Decorators',2000);
/*!40000 ALTER TABLE `skill_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `temp`
--

DROP TABLE IF EXISTS `temp`;
/*!50001 DROP VIEW IF EXISTS `temp`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `temp` AS SELECT 
 1 AS `job_id`,
 1 AS `freelancer_id`,
 1 AS `clock`,
 1 AS `bid`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` decimal(16,0) NOT NULL,
  `username` varchar(45) NOT NULL,
  `user_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (0,'sdfgh','freelancer'),(123,'galandepmayur@gmail.com','client'),(1506197309730,'mayurgrocks@gmail.com','client'),(1506200013836,'mayurguigrocks@gmail.com','client'),(1506200193293,'mayu458rguigrocks@gmail.com','client'),(1506200272260,'mayu458r65guigrocks@gmail.com','client'),(1506200543002,'mayu458r655guigrocks@gmail.com','client'),(1506242608574,'ghiqeihef@yu.com','client'),(1506242701241,'ghiqfsdeihef@yu.com','client'),(1506242714161,'ghiqfsdsdfeihef@yu.com','client'),(1506242803951,'ghiqfsdassdfeihef@yu.com','client'),(1506242838157,'ghiqfsdassadfeihef@yu.com','client'),(1506242889310,'gzc','client'),(1506243213280,'gzc4','client'),(1506243426729,'gzc46','client'),(1506243503343,'gzc464','client'),(1506244293219,'gzc4647','client'),(1506262836860,'gzc4647@asdfig','client'),(1506264127698,'gzc4647@asdfigs','client'),(1506265199635,'gzc4647@asdfigshd','client'),(1506292073911,'gzc4647@asdfigshd3','client'),(1506688613904,'galandekajsdhpmayur@gmail.com','client'),(1506689701631,'agalandekajsdhpmayur@gmail.com','client'),(1506691052860,'agalandekajsdhpmasayur@gmail.com','freelancer'),(1506793979731,'hello@gmail.com','client'),(1506796322055,'hi@gmail.com','client'),(1506878927067,'falh@fdtr.com','client'),(1506879443222,'falh@fdtrsf.com','client'),(1506879542570,'vikassaini@gmail.com','client'),(1507092806797,'jh.com','client'),(1507092888689,'jha.com','client'),(1507224827216,'agalandekajasdhpmasayur@gmail.com','freelancer'),(1507224931214,'jasdhpmasayur@gmail.com','freelancer'),(1507230063172,'jack@gmail.com','freelancer'),(1507230219727,'mayur@gmail.com','freelancer'),(1507231304263,'clown@gmail.com','client'),(1507231390425,'clow1n@gmail.com','client'),(1507231873653,'clow3n@gmail.com','client'),(1507232401742,'hgd@aew.ctyrs','client'),(1507232568280,'yfjhf@thdh.com','freelancer'),(1507233773585,'dfs@td.dyt','freelancer'),(1507234381866,'dqas@dfa.fasdkhi','client'),(1507234648000,'vikassxaig@gmail.com','client'),(1507270224845,'sarthpatil7@gmail.com','client'),(1507296514016,'sarthpatil07@gmail.com','freelancer'),(1507300699176,'abc@gmail.com','freelancer'),(1507316441540,'g@jksag.com','client'),(1507316493805,'czjhcx@zkvj.com','freelancer'),(1507316632043,'akdjh@ljksda.com','freelancer'),(1507317067959,'som@gmail.com','freelancer'),(1507317140408,'som@q.com','freelancer'),(1507317639968,'shaktiman@shaktimann.com','freelancer'),(1507317706012,'shaktiman@shaktimannn.com','freelancer'),(1507317765146,'asji12@asdkgh112.com','freelancer'),(1507318417103,'abc1@gmail.com','freelancer'),(1507318465497,'abc2@gmail.com','freelancer'),(1507318531325,'mahidfswyfu@dfsjkg.cioh','freelancer'),(1507318597514,'gsda@sdf.xco','freelancer'),(1507319040568,'vikas.saini@gmail.com','freelancer'),(1507320099472,'aghi@jhs.com','freelancer'),(1507448237767,'rishirich021@gmail.com','freelancer'),(1507524539922,'abc4@gmail.com','freelancer'),(1507557230772,'vikas.saini1708@gmail.com','client'),(1507557645143,'sarthpatil007@gmail.com','client'),(1507559861057,'knevagi1@gmail.com','client'),(1507565076469,'czkljl@jh.com','client'),(1507664057853,'knevagi@yahoo.com','client'),(1507665438581,'xyz@abc.com','freelancer'),(1507667675017,'asd@l.co','client'),(1507709543989,'monster.vicky1708@gmail.com','freelancer'),(1507709688655,'monster.vicky170@gmail.com','freelancer'),(1507710014762,'ghi@xyz.com','client'),(1507710083629,'dassad@gmail.com','freelancer'),(1507710167234,'dsa@wer.com','freelancer'),(1507710199552,'dsa@waer.com','freelancer'),(1507710245034,'dsa@awaer.com','freelancer'),(1508916489379,'mayurthetechy.12@gmail.com','client');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ehrproject'
--
/*!50106 SET @save_time_zone= @@TIME_ZONE */ ;
/*!50106 DROP EVENT IF EXISTS `applyUpdate` */;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8 */ ;;
/*!50003 SET character_set_results = utf8 */ ;;
/*!50003 SET collation_connection  = utf8_general_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`root`@`localhost`*/ /*!50106 EVENT `applyUpdate` ON SCHEDULE EVERY 3 MINUTE STARTS '2017-10-07 12:08:42' ON COMPLETION NOT PRESERVE ENABLE DO call assignJob() */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `check_application` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8 */ ;;
/*!50003 SET character_set_results = utf8 */ ;;
/*!50003 SET collation_connection  = utf8_general_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`root`@`localhost`*/ /*!50106 EVENT `check_application` ON SCHEDULE EVERY 10 MINUTE STARTS '2017-10-08 11:07:26' ON COMPLETION NOT PRESERVE ENABLE DO Begin
		DECLARE finished INTEGER DEFAULT 0;
		DECLARE jid DECIMAL(16) DEFAULT 0;
		DECLARE fid DECIMAL(16) DEFAULT 0;
		DECLARE slot TIMESTAMP(2) DEFAULT NULL;



		declare reading_cursor Cursor for 
		 select job_id,freelancer_id,clock from temp;
		 declare continue handler 
		 for not Found set finished = 1;
		 
		 open reading_cursor;
		 assign_job: loop
		 fetch reading_cursor into jid,fid,slot;
		 
		 
		 IF finished = 1 THEN 
		 LEAVE assign_job;
		  END IF;
		 
		 update jobs set freelancer_id=fid, assign_status='Assigned' where job_id=jid and assign_status='Not Assigned' and status='Live';
		 insert into freelancer_schedule values(fid,jid,date(slot));
		 delete from apply_table where job_id=jid;
		 
		 end loop assign_job;
		 close reading_cursor;
 
 end */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `dailyStatusCheck` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8 */ ;;
/*!50003 SET character_set_results = utf8 */ ;;
/*!50003 SET collation_connection  = utf8_general_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`root`@`localhost`*/ /*!50106 EVENT `dailyStatusCheck` ON SCHEDULE AT '2017-10-09 00:20:00' ON COMPLETION PRESERVE DISABLE DO begin
 update event_log set event_status = 'Completed' where event_date < curdate();
 update event_log set event_status = 'Ongoing' where event_date = curdate();
 end */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
/*!50106 DROP EVENT IF EXISTS `sessionEvent` */;;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8 */ ;;
/*!50003 SET character_set_results = utf8 */ ;;
/*!50003 SET collation_connection  = utf8_general_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`root`@`localhost`*/ /*!50106 EVENT `sessionEvent` ON SCHEDULE EVERY 1 MINUTE STARTS '2017-10-05 19:44:47' ON COMPLETION NOT PRESERVE ENABLE DO DELETE FROM session_table WHERE created < NOW() - INTERVAL 25 MINUTE */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
DELIMITER ;
/*!50106 SET TIME_ZONE= @save_time_zone */ ;

--
-- Dumping routines for database 'ehrproject'
--
/*!50003 DROP PROCEDURE IF EXISTS `assignJobs` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `assignJobs`()
begin

DECLARE finished INTEGER DEFAULT 0;
DECLARE jid DECIMAL(16) DEFAULT 0;
DECLARE fid DECIMAL(16) DEFAULT 0;
DECLARE slot TIMESTAMP(2) DEFAULT NULL;



declare reading_cursor Cursor for 
 select job_id,freelancer_id,clock from temp;
 declare continue handler 
 for not Found set finished = 1;
 
 open reading_cursor;
 assign_job: loop
 fetch reading_cursor into jid,fid,slot;
 
 
 IF finished = 1 THEN 
 LEAVE assign_job;
  END IF;
 
 update jobs set freelancer_id=fid, assign_status='Assigned' where job_id=jid and assign_status='Not Assigned' and status='Live';
 insert into freelancer_schedule values(fid,jid,date(slot));
 delete from apply_table where job_id=jid;
 
 end loop assign_job;
 close reading_cursor;

 
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `temp`
--

/*!50001 DROP VIEW IF EXISTS `temp`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `temp` AS select `apply_table`.`job_id` AS `job_id`,`apply_table`.`freelancer_id` AS `freelancer_id`,`apply_table`.`time` AS `clock`,`apply_table`.`bid` AS `bid` from `apply_table` order by `apply_table`.`time` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;