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
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `userEmail` varchar(45) NOT NULL,
  `userContact` varchar(15) NOT NULL,
  `userPassword` varchar(40) NOT NULL,
  `userCountry` varchar(45) NOT NULL,
  `userDateOfBirth` date NOT NULL,
  `secreteQuestion` varchar(50) NOT NULL,
  `secreteAnswer` varchar(50) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userEmail_UNIQUE` (`userEmail`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'Anupd','anup@gmail.com','5555555555','61fd809f2d7cfdd91cddc057f3ab65f1','India','2012-01-10','whats is your first Teacher Name','reena'),(2,'radhikamasale','radhika@gmail.com','7777777777','61fd809f2d7cfdd91cddc057f3ab65f1','India','2020-12-28','what is your firsts pets name','gurunath'),(3,'person','abc@gmail.com','7777777777','402fd6af80d80e346b96c89d37aae805','India','2021-01-06','which is your favourite color','green'),(4,'saheb','aaa@gmail.com','1111111111','402fd6af80d80e346b96c89d37aae805','India','2021-01-05','what is your firsts pets name','CATTO'),(5,'PersonBond','niraj@gmail.com','7777777777','b75b232a58adfe4b06e2f00fa496e8d0','India','2020-12-28','what is your firsts pets name','pvg pet khandu'),(6,'Alfread','akk@gmail.com','7410852963','e6c760b3216a51c656c5861d72d5bf62','India','0000-00-00','whats is your first Teacher Name','preeti'),(7,'Akash Patole','akashpatole@gmail.com','8888888888','61fd809f2d7cfdd91cddc057f3ab65f1','India','2021-02-04','whats is your first Teacher Name','anjali'),(9,'Anup Deshmukh','anup1@gmail.com','7875258332','61fd809f2d7cfdd91cddc057f3ab65f1','India','2021-02-01','which is your favourite color','green'),(10,'dsadsad','anup2@gmail.com','7777777777','61fd809f2d7cfdd91cddc057f3ab65f1','India','2021-02-01','whats is your first Teacher Name','teacher2'),(11,'Anupaaatttt','anup3@gmail.com','7875258332','61fd809f2d7cfdd91cddc057f3ab65f1','India','2021-02-01','whats is your first Teacher Name','teacher3'),(12,'checkingEmail','emailonreg@gmail.com','1111111111','bd9222d4293c93e175d512f998159be2','India','2021-02-01','which is your favourite color','green'),(14,'dsadsad','dsads@dsada.com','1111111111','61fd809f2d7cfdd91cddc057f3ab65f1','India','2021-02-01','which is your favourite color','green'),(15,'qqq','qqq@gmail.com','1236547890','79d9a95df84275e7d659c7c78ab1a716','India','2021-02-01','which is your favourite color','pink'),(16,'www','www@gmail.com','7896541230','79d9a95df84275e7d659c7c78ab1a716','India','2021-02-02','which is your favourite color','pink');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
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
