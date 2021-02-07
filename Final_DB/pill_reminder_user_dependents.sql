-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: pill_reminder
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user_dependents`
--

DROP TABLE IF EXISTS `user_dependents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_dependents` (
  `dependentId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `dependentName` varchar(45) NOT NULL,
  `dependentEmail` varchar(45) NOT NULL,
  `dependentRelation` varchar(45) NOT NULL,
  `dependentContact` varchar(20) NOT NULL,
  `dependentBloodGroup` varchar(3) NOT NULL,
  `dependentWeight` float(5,2) NOT NULL,
  `dependentHeight` float(5,2) NOT NULL,
  `dependentDateOfBirth` date NOT NULL,
  PRIMARY KEY (`dependentId`),
  UNIQUE KEY `dependentEmail_UNIQUE` (`dependentEmail`),
  KEY `userId` (`userId`),
  CONSTRAINT `user_dependents_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user_info` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_dependents`
--

LOCK TABLES `user_dependents` WRITE;
/*!40000 ALTER TABLE `user_dependents` DISABLE KEYS */;
INSERT INTO `user_dependents` VALUES (1,1,'Saroj','Saroj@gmail.com','Mother','1234567890','B+',60.00,158.00,'1958-11-11'),(2,1,'father1','father@gmail.com','Father','1234567890','Z+',80.00,180.00,'1952-08-06'),(3,1,'noone','noones@gmail.com','Spouse','1234567890','Z+',18.00,500.00,'2012-12-31'),(4,1,'abcd','abcd@gmail.com','Spouse','7777777777','O-',44.00,44.00,'2021-02-01'),(5,11,'motherone','mother@gmail.com','Mother','7777777777','B-',55.55,222.00,'2021-02-01'),(6,11,'fatherone','father1@gmail.com','Father','7777777777','AB+',88.00,88.00,'2021-02-01');
/*!40000 ALTER TABLE `user_dependents` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-07 20:46:24
