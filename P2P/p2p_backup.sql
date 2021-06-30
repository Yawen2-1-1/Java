-- MySQL dump 10.13  Distrib 5.7.17, for Win32 (AMD64)
--
-- Host: localhost    Database: p2p
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `t_application`
--

CREATE DATABASE p2p;
USE `p2p`;
DROP TABLE IF EXISTS `t_application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_application` (
  `ApplicationID` varchar(15) NOT NULL,
  `Borrower` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Amount` int(20) NOT NULL,
  `PurposeforLoan` char(20) NOT NULL,
  `TotalRepaymentAmount` int(25) NOT NULL,
  `RepaymentMethod` char(12) NOT NULL,
  `MemberAccount` char(20) NOT NULL,
  PRIMARY KEY (`ApplicationID`),
  KEY `TC_T_Application4` (`MemberAccount`),
  CONSTRAINT `FK_T_Application0` FOREIGN KEY (`MemberAccount`) REFERENCES `t_member_data` (`MemberAccount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_application`
--

LOCK TABLES `t_application` WRITE;
/*!40000 ALTER TABLE `t_application` DISABLE KEYS */;
INSERT INTO `t_application` VALUES ('irenelee_1057','Irene',50000,'買機車',60001,'831245679024','irenelee'),('kevinlin_1084','Kevin',3000,'買書錢',3000,'700565704323','kevinlin'),('yvonnep2p_1089','Yvonne',100000,'創業',130000,'822955673420','yvonnep2p');
/*!40000 ALTER TABLE `t_application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_loancaseinfo`
--

DROP TABLE IF EXISTS `t_loancaseinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_loancaseinfo` (
  `CaseNo` varchar(15) NOT NULL,
  `Interest` float NOT NULL,
  `RepaymentDate` int(100) NOT NULL,
  `LoanDate` date NOT NULL,
  PRIMARY KEY (`CaseNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_loancaseinfo`
--

LOCK TABLES `t_loancaseinfo` WRITE;
/*!40000 ALTER TABLE `t_loancaseinfo` DISABLE KEYS */;
INSERT INTO `t_loancaseinfo` VALUES ('irenelee_1057',1.2,60,'2021-06-30'),('kevinlin_1084',0,10,'2021-06-30'),('yvonnep2p_1089',1.3,90,'2021-06-30');
/*!40000 ALTER TABLE `t_loancaseinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_member_data`
--

DROP TABLE IF EXISTS `t_member_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_member_data` (
  `MemberAccount` char(20) NOT NULL,
  `MemberPassword` varchar(64) NOT NULL,
  `MemberName` char(10) NOT NULL,
  `ContactMethod` char(40) NOT NULL,
  PRIMARY KEY (`MemberAccount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_member_data`
--

LOCK TABLES `t_member_data` WRITE;
/*!40000 ALTER TABLE `t_member_data` DISABLE KEYS */;
INSERT INTO `t_member_data` VALUES ('irenelee','49536179bd18b445888fc7693ff0394e7d38d92ce27c6753f4db7e8db7d75add','Irene','irenelee@gmail.com'),('kevinlin','80d41c54a8ce6d26ae0bdd509db6b187140cae39b4b771269a0d006b0620e2d2','kevinlin','euphoric1230@gmail.com'),('yvonnep2p','1df1854015e31ca286d015345eaff29a6c6073f70984a3a746823d4cac16b075','Yvonne','0971523896');
/*!40000 ALTER TABLE `t_member_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-30 16:33:10
