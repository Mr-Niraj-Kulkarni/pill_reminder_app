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
-- Table structure for table `dependent_medical_history`
--

DROP TABLE IF EXISTS `dependent_medical_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dependent_medical_history` (
  `dependentMedicalHistoryId` int NOT NULL AUTO_INCREMENT,
  `dependentId` int NOT NULL,
  `dependentUser` int NOT NULL,
  `dependentIlliness` varchar(45) NOT NULL,
  `dependentDoctorDetails` varchar(45) NOT NULL,
  `dependentMedicine` varchar(45) NOT NULL,
  `dependentMedicineStartDate` date NOT NULL,
  `dependentMedicineEndDate` date DEFAULT NULL,
  `dependentDosageAmount` int NOT NULL,
  `dependentDosageFrequency` enum('Once','twice','thrice') DEFAULT NULL,
  `dependentDosageBreakfastTime` time DEFAULT NULL,
  `dependentDosageLunchTime` time DEFAULT NULL,
  `dependentDosageDinnerTime` time DEFAULT NULL,
  `emailNotification` tinyint(1) NOT NULL,
  `checkBoxBreakfast` tinyint(1) NOT NULL DEFAULT '0',
  `checkBoxLunch` tinyint(1) NOT NULL DEFAULT '0',
  `checkBoxDinner` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`dependentMedicalHistoryId`),
  KEY `dependentId_idx` (`dependentId`),
  KEY `dependentUser` (`dependentUser`),
  CONSTRAINT `dependentId` FOREIGN KEY (`dependentId`) REFERENCES `user_dependents` (`dependentId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `dependentUser` FOREIGN KEY (`dependentUser`) REFERENCES `user_info` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependent_medical_history`
--

LOCK TABLES `dependent_medical_history` WRITE;
/*!40000 ALTER TABLE `dependent_medical_history` DISABLE KEYS */;
INSERT INTO `dependent_medical_history` VALUES (1,2,1,'covid18','niraj vaidya','nopillneeded','2021-01-20','2021-02-11',2,'twice',NULL,'14:40:00','21:00:00',1,0,1,0),(2,2,1,'covid19','niraj vaidya','pillneeded','2021-01-24','2021-02-11',1,'Once',NULL,'14:40:00',NULL,1,0,0,0),(3,1,1,'none','apple','apple','2021-02-03','2021-02-27',90,'Once',NULL,'12:09:32',NULL,1,0,1,0),(4,3,1,'sadsa','dsa','dsad','2021-02-03',NULL,3,'Once','15:19:49',NULL,NULL,0,0,0,0),(7,1,1,'dsfsdf','fdsf','sdfsd','2021-02-02',NULL,3,'Once','01:09:55',NULL,NULL,0,0,0,0),(9,1,1,'dsad','sad','sad','2021-02-13',NULL,2,'Once','01:10:26',NULL,NULL,1,0,0,0),(10,1,1,'vubhnk','das','sada','2021-02-11',NULL,2,'Once',NULL,'14:44:34',NULL,0,0,0,0);
/*!40000 ALTER TABLE `dependent_medical_history` ENABLE KEYS */;
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
