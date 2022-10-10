CREATE DATABASE  IF NOT EXISTS `banking_app` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `banking_app`;
-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: localhost    Database: banking_app
-- ------------------------------------------------------
-- Server version	8.0.30-0ubuntu0.20.04.2

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
-- Table structure for table `MF_inv`
--

DROP TABLE IF EXISTS `MF_inv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MF_inv` (
  `fund_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `min_amount` double NOT NULL,
  `returns` float NOT NULL,
  `fund_type` varchar(45) NOT NULL,
  `fund_size` double DEFAULT NULL,
  `NAV` float DEFAULT NULL,
  PRIMARY KEY (`fund_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MF_inv`
--

LOCK TABLES `MF_inv` WRITE;
/*!40000 ALTER TABLE `MF_inv` DISABLE KEYS */;
INSERT INTO `MF_inv` VALUES (1,'SBI Arbitrage Fund',2000,6.64,'open ended',6001.28,27.81),(2,'SBI Balance Advantage Fund',4000,3.13,'open ended',24735.05,10.33),(3,'SBI Banking and Financial Service Funds',5000,12.74,'open ended',3720.89,24.84),(4,'SBI Blue Chip Fund',5000,11.4,'open ended',34045.17,60.24),(5,'SBI Consumption Opportunities Fund',5000,15.43,'open ended',1060.09,204.12),(6,'SBI Dynamic Bond Fund ',1000,6.18,'open ended',2375.11,28.91),(7,'SBI Magnum Comma Fund',1500,11.64,'open ended',468,66.11);
/*!40000 ALTER TABLE `MF_inv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `trans_id` int NOT NULL AUTO_INCREMENT,
  `from_acc_no` int DEFAULT NULL,
  `to_acc_no` int DEFAULT NULL,
  `amount` double NOT NULL,
  `trans_type` varchar(45) DEFAULT NULL,
  `date_time` datetime NOT NULL,
  PRIMARY KEY (`trans_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,9,10,3000,'UPI','2022-09-21 14:36:47'),(2,0,NULL,1500,'CASH_OUT','2022-09-21 14:43:44'),(3,9,NULL,1200,'CASH_OUT','2022-09-21 14:54:55'),(4,NULL,10,3000,'CASH_IN','2022-09-21 15:02:35'),(5,NULL,10,10000,'CASH_IN','2022-09-21 16:15:47'),(6,10,8,2000,'NEFT','2022-09-21 16:16:41'),(7,9,7,5000,'RTGS','2022-09-21 16:39:33'),(8,10,9,5000,'UPI','2022-09-22 11:20:26'),(9,10,7,4500,'NEFT','2022-09-22 14:11:54'),(10,10,17,2000,'UPI','2022-09-22 14:18:35'),(11,10,18,500,'NEFT','2022-09-22 14:19:38'),(12,NULL,9,2000,'CASH_IN','2022-09-22 14:51:29'),(13,5,7,1500,'NEFT','2022-09-23 10:26:06'),(14,28,8,1000,'UPI','2022-09-23 14:50:18'),(15,NULL,29,6000,'CASH_IN','2022-09-26 14:11:32'),(16,29,20,2000,'NEFT','2022-09-26 14:12:05'),(17,29,NULL,1000,'CASH_OUT','2022-09-26 14:12:55'),(18,NULL,9,1000,'CASH_IN','2022-09-26 14:47:35'),(19,NULL,9,1500,'CASH_IN','2022-09-26 14:49:21'),(20,NULL,19,100000,'CASH_IN','2022-09-26 14:52:17'),(21,19,20,20000,'RTGS','2022-09-26 14:55:34'),(22,NULL,9,1500,'CASH_IN','2022-09-27 11:03:04'),(23,NULL,9,200,'CASH_IN','2022-09-27 11:06:44'),(24,NULL,17,500,'CASH_IN','2022-09-27 11:09:27'),(25,NULL,17,6969,'CASH_IN','2022-09-27 11:17:40'),(26,NULL,17,500,'CASH_IN','2022-09-27 11:22:44'),(27,17,20,1000,'NEFT','2022-09-27 12:14:50'),(28,17,NULL,300,'CASH_OUT','2022-09-27 12:29:50'),(29,17,NULL,300,'CASH_OUT','2022-09-27 12:32:36'),(30,17,NULL,300,'CASH_OUT','2022-09-27 12:32:37'),(31,17,NULL,300,'CASH_OUT','2022-09-27 12:32:38'),(32,17,NULL,300,'CASH_OUT','2022-09-27 12:32:39'),(33,17,NULL,100,'CASH_OUT','2022-09-27 12:32:53'),(34,NULL,17,2000,'CASH_IN','2022-09-27 12:33:19'),(35,17,NULL,300,'CASH_OUT','2022-09-27 12:33:29'),(36,17,NULL,300,'CASH_OUT','2022-09-27 12:34:36'),(37,17,NULL,10,'CASH_OUT','2022-09-27 12:57:54'),(38,17,NULL,20,'CASH_OUT','2022-09-27 12:58:42'),(39,NULL,17,2000,'CASH_IN','2022-09-27 14:57:36'),(40,17,18,4000,'RTGS','2022-09-27 16:20:21'),(41,9,17,2000,'UPI','2022-09-28 10:13:26'),(42,NULL,9,2000,'CASH_IN','2022-09-28 14:30:51'),(43,NULL,9,2000,'CASH_IN','2022-09-28 14:31:43'),(44,9,0,5000,'INVESTMENT','2022-09-29 14:48:10'),(45,9,0,6000,'INVESTMENT','2022-09-29 14:48:37'),(46,9,NULL,1550,'INVESTMENT','2022-09-29 14:57:16'),(47,17,NULL,1500,'INVESTMENT','2022-09-29 15:02:22'),(48,17,NULL,5000,'INVESTMENT','2022-09-29 15:05:55'),(49,9,NULL,6000,'INVESTMENT','2022-09-29 15:14:06'),(50,NULL,9,4000,'CASH_IN','2022-09-29 15:19:53'),(51,9,NULL,10000,'INVESTMENT','2022-09-29 15:39:31'),(52,9,NULL,3000,'INVESTMENT','2022-09-29 16:29:35'),(53,NULL,9,5000,'CASH_IN','2022-09-29 16:56:34'),(54,9,NULL,5000,'INVESTMENT','2022-09-29 16:58:11');
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_details`
--

DROP TABLE IF EXISTS `user_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_details` (
  `name` varchar(30) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `acc_no` int NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `address` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone_no` varchar(10) NOT NULL,
  `gender` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`acc_no`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_no_UNIQUE` (`phone_no`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `acc_no_UNIQUE` (`acc_no`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_details`
--

LOCK TABLES `user_details` WRITE;
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
INSERT INTO `user_details` VALUES ('Dilip','dilip','1234',1,66000,'','dilip@perfios.com','1234567890','Male'),('devesh','devesh123','123',3,45000,'','dev@perfios.com','1239876525','Male'),('dilip','dilip765','123',4,23000,'','dilip@yahoo.com','9876543210','Male'),('devesh','dev123','123',6,42000,'','devvv@gmail.com','98989898','Male'),('sahil','adw','awd',7,82000,'','da','34','Male'),('tejas','ada','123',8,64000,'hyd','hydhyd','98324','Female'),('Aditya Prasad','aditya_8571','1234',9,28450,'bangalore','aditya5858@gmail.com','9345128435','Male'),('Arijit Reddy','cool234','1234',16,30000,'bangalore','cool@gmail.com','9981202678','Male'),('Arijit Reddy','arijit420','12',17,14239,'Chennai','arijit42069@gmail.com','1234567777','Male'),('Jatin Reddy','jatin123','1234',18,4500,'bangalore','jatin@yahoo.com','7659241123','Male'),('Rahul Sharma','rahool23','1234',19,80000,'BTM Layout 2nd Stage','rahool@yahoo.com','1234432199','Male'),('darshan shah','darshanrshah','1234',20,29000,'bangalore','skull@gmail.com','9886553221','Male'),('Unnathi K','kv7','qwerty',28,500,'Canada','unnathi791@gmail.com','9398341502','Female'),('Sai Tejashwini','teju123','1234',29,8000,'bangalore','teju123@gmail.com','7337814136','Female'),('Balaji Reddy','bal1234','12345',30,30000,'bangalore','balaji34@gmail.com','7659241987','Male'),('Balaji','Balaji123','12345',32,20000,'Bangalore','balaji347@gmail.com','7842309253','Male'),('Balaji','Balaji1234','12345',34,20000,'Bangalore','balaji597@gmail.com','7842309230','Male');
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_inv`
--

DROP TABLE IF EXISTS `user_inv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_inv` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `fund_id` int NOT NULL,
  `time` datetime NOT NULL,
  `inv_amount` double DEFAULT NULL,
  `cur_amount` double DEFAULT NULL,
  `account_no` int NOT NULL,
  `fund_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_inv`
--

LOCK TABLES `user_inv` WRITE;
/*!40000 ALTER TABLE `user_inv` DISABLE KEYS */;
INSERT INTO `user_inv` VALUES (1,2,'2022-09-29 14:44:03',5000,5000,0,NULL),(2,4,'2022-09-29 14:48:37',6000,6000,0,NULL),(4,6,'2022-09-29 15:02:22',1500,1500,17,NULL),(5,2,'2022-09-29 15:05:55',5000,5000,17,NULL),(6,3,'2022-09-29 15:14:06',6000,6000,9,'SBI Banking and Financial Service Funds'),(7,5,'2022-09-29 15:39:31',10000,10000,9,'SBI Consumption Opportunities Fund'),(8,6,'2022-09-29 16:29:35',3000,3000,9,'SBI Dynamic Bond Fund '),(9,2,'2022-09-29 16:58:11',5000,5000,9,'SBI Balance Advantage Fund');
/*!40000 ALTER TABLE `user_inv` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-10 14:18:02
