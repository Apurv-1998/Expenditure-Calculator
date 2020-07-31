-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ssm_task
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `expense`
--

DROP TABLE IF EXISTS `expense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expense` (
  `id` bigint NOT NULL,
  `amount` double DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `expense` varchar(255) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expense`
--

LOCK TABLES `expense` WRITE;
/*!40000 ALTER TABLE `expense` DISABLE KEYS */;
INSERT INTO `expense` VALUES (269,1250,'Studies','2020-07-29 00:00:00.000000','Course Fees','NEFT','Debit'),(270,1250,'Studies','2020-03-29 00:00:00.000000','Course Fees','NEFT','Debit'),(271,1250,'Studies','2020-02-29 00:00:00.000000','Course Fees','NEFT','Debit'),(272,1250,'Studies','2020-02-29 00:00:00.000000','Course Fees','NEFT','Debit'),(273,1250,'Studies','2020-02-29 00:00:00.000000','Course Fees','NEFT','Debit'),(274,1250,'Studies','2020-02-21 00:00:00.000000','Course Fees','NEFT','Debit'),(275,1250,'Studies','2020-03-21 00:00:00.000000','Course Fees','NEFT','Debit'),(276,1250,'Studies','2020-04-21 00:00:00.000000','Course Fees','NEFT','Debit'),(277,1250,'Studies','2020-07-27 00:00:00.000000','Course Fees','NEFT','Debit'),(278,1250,'Studies','2020-01-27 00:00:00.000000','Course Fees','NEFT','Debit'),(279,1250,'Studies','2020-08-22 00:00:00.000000','Course Fees','NEFT','Debit'),(283,1250,'Studies','2020-07-22 00:00:00.000000','Course Fees','NEFT','Credit'),(284,1250,'Studies','2020-02-22 00:00:00.000000','Course Fees','NEFT','Credit'),(285,1250,'Studies','2020-08-22 00:00:00.000000','Course Fees','NEFT','Credit'),(286,1250,'Studies','2020-11-22 00:00:00.000000','Course Fees','NEFT','Credit'),(289,1250,'Studies','2020-07-22 00:00:00.000000','Course Fees','NEFT','Credit'),(291,1250,'Studies','2020-07-22 00:00:00.000000','Course Fees','NEFT','Credit'),(293,1250,'Studies','2020-07-22 00:00:00.000000','Course Fees','NEFT','Credit'),(294,1250,'Studies','2020-07-22 00:00:00.000000','Course Fees','NEFT','Debit'),(295,1250,'Studies','2020-07-22 00:00:00.000000','Course Fees','NEFT','Credit'),(296,1250,'Studies','2020-07-22 00:00:00.000000','Course Fees','NEFT','Debit'),(297,1250,'Studies','2020-07-22 00:00:00.000000','Course Fees','NEFT','Debit'),(298,1250,'Studies','2020-07-22 00:00:00.000000','Course Fees','NEFT','Debit'),(299,1250,'Studies','2020-07-22 00:00:00.000000','Course Fees','NEFT','Debit'),(300,1250,'Studies','2020-07-22 00:00:00.000000','Course Fees','NEFT','Debit'),(301,1250,'Studies','2020-07-22 00:00:00.000000','Course Fees','NEFT','Debit'),(302,1250,'Studies','2020-07-22 00:00:00.000000','Course Fees','NEFT','Debit'),(303,1250,'Studies','2021-07-22 00:00:00.000000','Course Fees','NEFT','Debit'),(304,1250,'Studies','2021-07-22 00:00:00.000000','Course Fees','NEFT','Debit'),(305,1250,'Studies','2021-07-22 00:00:00.000000','Course Fees','NEFT','Debit'),(306,1250,'Studies','2021-07-22 00:00:00.000000','Course Fees','NEFT','Debit'),(307,1250,'Studies','2022-07-22 00:00:00.000000','Course Fees','NEFT','Debit'),(308,1250,'Studies','2022-07-22 00:00:00.000000','Course Fees','NEFT','Debit'),(309,1250,'Studies','2022-07-12 00:00:00.000000','Course Fees','NEFT','Debit'),(310,1250,'Studies','2022-07-12 00:00:00.000000','Course Fees','NEFT','Debit'),(311,1250,'Studies','2022-07-31 00:00:00.000000','Course Fees','NEFT','Debit'),(312,1250,'Studies','2022-07-30 00:00:00.000000','Course Fees','NEFT','Debit'),(313,1250,'Studies','2022-07-31 00:00:00.000000','Course Fees','NEFT','Debit'),(314,1250,'Studies','2022-07-31 00:00:00.000000','Course Fees','NEFT','Debit'),(315,1250,'Studies','2022-05-01 00:00:00.000000','Course Fees','NEFT','Debit'),(316,1250,'Studies','2022-07-01 00:00:00.000000','Course Fees','NEFT','Debit'),(317,1250,'Studies','2022-12-01 00:00:00.000000','Course Fees','NEFT','Debit'),(318,1250,'Studies','2022-11-21 00:00:00.000000','Course Fees','NEFT','Debit'),(319,1250,'Studies','2022-10-23 00:00:00.000000','Course Fees','NEFT','Debit'),(320,1250,'Studies','2022-10-28 00:00:00.000000','Course Fees','NEFT','Debit'),(321,1250,'Studies','2022-10-28 00:00:00.000000','Course Fees','NEFT','Debit'),(322,1250,'Studies','2023-10-28 00:00:00.000000','Course Fees','NEFT','Debit'),(323,1250,'Studies','2023-11-28 00:00:00.000000','Course Fees','NEFT','Debit');
/*!40000 ALTER TABLE `expense` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-31 12:10:31
