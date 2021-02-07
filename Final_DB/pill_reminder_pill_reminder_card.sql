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
-- Table structure for table `pill_reminder_card`
--

DROP TABLE IF EXISTS `pill_reminder_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pill_reminder_card` (
  `pillTableId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `dependentId` int DEFAULT NULL,
  `pillName` varchar(100) NOT NULL,
  `dosageAmount` int NOT NULL,
  `pillTime` time DEFAULT NULL,
  `checkbox` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`pillTableId`),
  KEY `userId` (`userId`),
  KEY `pill_reminder_card_ibfk_2` (`dependentId`),
  CONSTRAINT `pill_reminder_card_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user_info` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pill_reminder_card_ibfk_2` FOREIGN KEY (`dependentId`) REFERENCES `user_dependents` (`dependentId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pill_reminder_card`
--

LOCK TABLES `pill_reminder_card` WRITE;
/*!40000 ALTER TABLE `pill_reminder_card` DISABLE KEYS */;
INSERT INTO `pill_reminder_card` VALUES (1,1,NULL,'nopillneeded',46,'12:00:00',1),(2,1,NULL,'pillneeded',1,'12:00:00',0),(4,1,NULL,'nopillneeded',46,'21:00:00',1),(5,1,2,'nopillneeded',2,'12:00:00',1),(6,1,2,'pillneeded',1,'12:00:00',0),(8,1,2,'nopillneeded',2,'21:00:00',1),(9,1,NULL,'nopillneeded',46,'12:00:00',0),(10,1,NULL,'pillneeded',1,'12:00:00',1);
/*!40000 ALTER TABLE `pill_reminder_card` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-07 20:46:25
