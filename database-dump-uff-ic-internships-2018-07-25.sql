-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: uff-ic-internships
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu18.04.1

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
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `cnpj` varchar(14) NOT NULL,
  `id` int(11) NOT NULL,
  `core_activity_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `company_UN` (`cnpj`),
  KEY `company_core_activity_FK` (`core_activity_id`),
  CONSTRAINT `company_core_activity_FK` FOREIGN KEY (`core_activity_id`) REFERENCES `core_activity` (`id`),
  CONSTRAINT `company_user_FK` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `coordinator`
--

DROP TABLE IF EXISTS `coordinator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coordinator` (
  `id` int(11) NOT NULL,
  `teacher_code` varchar(20) NOT NULL COMMENT 'Teacher Identification code at UFF',
  PRIMARY KEY (`id`),
  UNIQUE KEY `coordinator_UN` (`teacher_code`),
  CONSTRAINT `coordinator_user_FK` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `core_activity`
--

DROP TABLE IF EXISTS `core_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `experience`
--

DROP TABLE IF EXISTS `experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `experience` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_Id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `experience_student_FK` (`student_Id`),
  CONSTRAINT `experience_student_FK` FOREIGN KEY (`student_Id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `foreign_language`
--

DROP TABLE IF EXISTS `foreign_language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foreign_language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `internship`
--

DROP TABLE IF EXISTS `internship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `internship` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) NOT NULL,
  `allowance` decimal(8,2) DEFAULT '0.00',
  `title` varchar(50) NOT NULL,
  `description` varchar(3000) DEFAULT NULL,
  `deadline` datetime NOT NULL COMMENT 'Deadline to apply for',
  `interview_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `internship_company_FK` (`company_id`),
  CONSTRAINT `internship_company_FK` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `internship_skill`
--

DROP TABLE IF EXISTS `internship_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `internship_skill` (
  `internship_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  PRIMARY KEY (`internship_id`,`skill_id`),
  KEY `internship_skill_skill_FK` (`skill_id`),
  CONSTRAINT `internship_skill_internship_FK` FOREIGN KEY (`internship_id`) REFERENCES `internship` (`id`),
  CONSTRAINT `internship_skill_skill_FK` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `internship_student`
--

DROP TABLE IF EXISTS `internship_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `internship_student` (
  `internship_id` int(11) NOT NULL,
  `student_Id` int(11) NOT NULL,
  PRIMARY KEY (`internship_id`,`student_Id`),
  KEY `internship_student_student_FK` (`student_Id`),
  CONSTRAINT `internship_student_internship_FK` FOREIGN KEY (`internship_id`) REFERENCES `internship` (`id`),
  CONSTRAINT `internship_student_student_FK` FOREIGN KEY (`student_Id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `internship_student_status`
--

DROP TABLE IF EXISTS `internship_student_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `internship_student_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `internship_id` int(11) NOT NULL,
  `status` varchar(100) NOT NULL,
  `commentary` varchar(1000) DEFAULT NULL COMMENT 'Company reply about the status',
  `datetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `internship_student_status_internship_student_FK` (`internship_id`,`student_id`),
  CONSTRAINT `internship_student_status_internship_student_FK` FOREIGN KEY (`internship_id`, `student_id`) REFERENCES `internship_student` (`internship_id`, `student_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `enrollment_code` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_UN` (`enrollment_code`),
  CONSTRAINT `student_user_FK` FOREIGN KEY (`id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_foreign_language`
--

DROP TABLE IF EXISTS `student_foreign_language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_foreign_language` (
  `student_id` int(11) NOT NULL,
  `foreign_language_id` int(11) NOT NULL,
  `level` char(1) NOT NULL,
  PRIMARY KEY (`foreign_language_id`,`student_id`),
  KEY `student_foreign_laguage_foreign_language_FK` (`foreign_language_id`),
  KEY `foreign_language_student_student_FK` (`student_id`),
  CONSTRAINT `student_foreign_language_ibfk_1` FOREIGN KEY (`foreign_language_id`) REFERENCES `foreign_language` (`id`),
  CONSTRAINT `student_foreign_language_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `student_skill`
--

DROP TABLE IF EXISTS `student_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_skill` (
  `student_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  `level` char(1) NOT NULL,
  PRIMARY KEY (`student_id`,`skill_id`),
  KEY `student_skill_skill_FK` (`skill_id`),
  CONSTRAINT `student_skill_skill_FK` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`),
  CONSTRAINT `student_skill_student_FK` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `complement` varchar(100) DEFAULT NULL,
  `city_id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `born_date` date NOT NULL,
  `password` varchar(100) NOT NULL,
  `validated` tinyint(1) DEFAULT '0',
  `resume` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_UN` (`email`),
  KEY `user_city_FK` (`city_id`),
  CONSTRAINT `user_city_FK` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'uff-ic-internships'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-25 11:34:03
