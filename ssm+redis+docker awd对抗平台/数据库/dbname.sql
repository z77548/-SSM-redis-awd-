-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: localhost    Database: awd
-- ------------------------------------------------------
-- Server version	5.7.29

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
-- Table structure for table `accout`
--

DROP TABLE IF EXISTS `accout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accout` (
  `id` tinyint(100) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT '0',
  `passwd` varchar(100) DEFAULT '0',
  `truename` varchar(100) DEFAULT '0',
  `idcard` varchar(100) DEFAULT '0',
  `iphone` varchar(100) DEFAULT '0',
  `email` varchar(100) DEFAULT '0',
  `type` tinyint(3) unsigned DEFAULT '0',
  `team_id` tinyint(100) unsigned DEFAULT '0',
  `captain` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `mac` varchar(1000) DEFAULT 'null',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `awdteam`
--

DROP TABLE IF EXISTS `awdteam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `awdteam` (
  `id` tinyint(100) unsigned NOT NULL AUTO_INCREMENT,
  `teamid` tinyint(100) unsigned DEFAULT '0',
  `eventid` tinyint(100) unsigned DEFAULT '0',
  `flag` varchar(100) DEFAULT '0',
  `source` int(100) unsigned DEFAULT '0',
  `ipaddr` varchar(100) DEFAULT NULL,
  `states` text,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `choose_topic`
--

DROP TABLE IF EXISTS `choose_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `choose_topic` (
  `id` tinyint(100) NOT NULL AUTO_INCREMENT,
  `event_id` tinyint(100) NOT NULL DEFAULT '0',
  `name` varchar(1000) DEFAULT '0',
  `choose_content` text,
  `answer` varchar(100) DEFAULT NULL,
  `fraction` tinyint(100) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `docker`
--

DROP TABLE IF EXISTS `docker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docker` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `eventid` tinyint(3) unsigned DEFAULT '0',
  `model` varchar(100) DEFAULT '0',
  `ipaddr` varchar(100) DEFAULT '0',
  `count` tinyint(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `id` tinyint(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT '0',
  `intime` varchar(100) DEFAULT '0',
  `outime` varchar(100) DEFAULT '0',
  `jianjie` text,
  `file` varchar(100) DEFAULT NULL,
  `awd` tinyint(3) unsigned DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `file_topic`
--

DROP TABLE IF EXISTS `file_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file_topic` (
  `id` tinyint(100) NOT NULL AUTO_INCREMENT,
  `event_id` varchar(100) NOT NULL DEFAULT 'null',
  `name` varchar(1000) DEFAULT '0',
  `type` varchar(1000) DEFAULT '0',
  `topic_name` varchar(1000) DEFAULT 'NULL',
  `introduction` varchar(1000) DEFAULT 'NULL',
  `file` varchar(100) DEFAULT 'NULL',
  `answer` varchar(100) DEFAULT NULL,
  `fraction` tinyint(100) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `multiple_topic`
--

DROP TABLE IF EXISTS `multiple_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `multiple_topic` (
  `id` tinyint(100) NOT NULL AUTO_INCREMENT,
  `event_id` tinyint(100) NOT NULL DEFAULT '0',
  `name` varchar(1000) DEFAULT '0',
  `topic_content` text,
  `answer` varchar(100) DEFAULT NULL,
  `fraction` tinyint(100) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` tinyint(100) unsigned NOT NULL AUTO_INCREMENT,
  `publisher_id` tinyint(100) unsigned DEFAULT '0',
  `recipient_id` tinyint(100) unsigned DEFAULT '0',
  `data` text,
  `publisher_name` varchar(1000) DEFAULT NULL,
  `time` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `result_competition`
--

DROP TABLE IF EXISTS `result_competition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `result_competition` (
  `id` tinyint(255) unsigned NOT NULL AUTO_INCREMENT,
  `team_id` tinyint(255) unsigned DEFAULT NULL,
  `submit_number` tinyint(255) unsigned DEFAULT '0',
  `radio_answer` text,
  `multiple_choice_answer` text,
  `flag_score` tinyint(255) DEFAULT NULL,
  `radio_score` tinyint(255) unsigned DEFAULT NULL,
  `multiple_choice_score` tinyint(255) unsigned DEFAULT NULL,
  `event_id` tinyint(255) unsigned DEFAULT NULL,
  `already_answered1` text,
  `already_answered2` text,
  `already_answered3` text,
  PRIMARY KEY (`id`),
  KEY `id` (`id`,`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `id` tinyint(255) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT '0',
  `captain_id` tinyint(100) unsigned DEFAULT '0',
  `team_member_1_id` tinyint(100) unsigned DEFAULT '0',
  `team_member_2_id` tinyint(100) unsigned DEFAULT '0',
  `event_id` text,
  `count` tinyint(3) unsigned DEFAULT '0',
  `captain_name` varchar(1000) DEFAULT 'null',
  `team_member_2_name` varchar(1000) DEFAULT 'null',
  `team_member_1_name` varchar(1000) DEFAULT 'null',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_application`
--

DROP TABLE IF EXISTS `team_application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_application` (
  `id` tinyint(255) unsigned NOT NULL AUTO_INCREMENT,
  `team_id` tinyint(100) DEFAULT '0',
  `applicant_id` tinyint(3) unsigned DEFAULT '0',
  `captain_id` tinyint(100) unsigned DEFAULT '0',
  `applicant_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-02 18:19:09
