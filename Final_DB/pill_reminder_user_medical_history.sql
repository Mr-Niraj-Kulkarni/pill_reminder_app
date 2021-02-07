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
-- Table structure for table `user_medical_history`
--

DROP TABLE IF EXISTS `user_medical_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_medical_history` (
  `userMedicalHistoryId` int NOT NULL AUTO_INCREMENT,
  `userId_M` int NOT NULL,
  `userIlliness` varchar(45) NOT NULL,
  `userDoctorDetails` varchar(45) NOT NULL,
  `userMedicine` varchar(45) NOT NULL,
  `userMedicineStartDate` date NOT NULL,
  `userMedicineEndDate` date DEFAULT NULL,
  `userDosageAmount` int NOT NULL,
  `userDosageFrequency` enum('Once','twice','thrice') DEFAULT NULL,
  `userDosageBreakfastTime` time DEFAULT NULL,
  `userDosageLunchTime` time DEFAULT NULL,
  `userDosageDinnerTime` time DEFAULT NULL,
  `emailNotification` tinyint(1) NOT NULL,
  `checkBoxBreakfast` tinyint(1) NOT NULL DEFAULT '0',
  `checkBoxLunch` tinyint(1) NOT NULL DEFAULT '0',
  `checkBoxDinner` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`userMedicalHistoryId`),
  KEY `userId_M_idx` (`userId_M`),
  CONSTRAINT `userId_M` FOREIGN KEY (`userId_M`) REFERENCES `user_info` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_medical_history`
--

LOCK TABLES `user_medical_history` WRITE;
/*!40000 ALTER TABLE `user_medical_history` DISABLE KEYS */;
INSERT INTO `user_medical_history` VALUES (1,1,'covid18','amey vaidya','nopillneeded','2021-03-03',NULL,45,'twice','13:05:36',NULL,'13:04:39',0,0,0,0),(2,1,'covid19','niraj vaidya','pillneeded','2021-01-24','2021-02-11',1,'Once',NULL,'14:40:00',NULL,1,0,1,0),(3,1,'covid20','okdoc','ugh','2021-02-23',NULL,14,'Once','18:59:30',NULL,NULL,0,0,0,0),(5,1,'covid22','dasds','dsadsa','2021-02-02',NULL,44,'Once','17:21:58',NULL,NULL,0,0,0,0),(6,1,'tretr','trtre','tretr','2021-02-04','2021-02-20',2,'twice','15:32:09',NULL,'15:33:11',1,0,0,1),(11,1,'covid23','dsad','dsad','2021-02-03',NULL,3,'Once','01:07:52',NULL,NULL,1,0,0,0),(12,1,'saada','sada','sdasd','2021-02-01',NULL,14,'Once','09:23:28',NULL,NULL,0,0,0,0),(13,1,'sdads','dsad','dsada','2021-02-01',NULL,3,'Once',NULL,'12:44:31',NULL,0,0,0,0),(14,1,'bihkj','cyvgbhjk','gvhj','2021-02-01',NULL,2,'Once',NULL,'20:31:00',NULL,1,0,0,0);
/*!40000 ALTER TABLE `user_medical_history` ENABLE KEYS */;
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
