-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: javafx
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `carihesaplar`
--

DROP TABLE IF EXISTS `carihesaplar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carihesaplar` (
  `cariID` int NOT NULL AUTO_INCREMENT,
  `cariAd` varchar(45) DEFAULT NULL,
  `cariSoyad` varchar(45) DEFAULT NULL,
  `cariTC` varchar(11) DEFAULT NULL,
  `cariAdres` varchar(255) DEFAULT NULL,
  `cariBorc` float DEFAULT NULL,
  `cariDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cariID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carihesaplar`
--

LOCK TABLES `carihesaplar` WRITE;
/*!40000 ALTER TABLE `carihesaplar` DISABLE KEYS */;
INSERT INTO `carihesaplar` VALUES (1,'burak','can','1111111','mardin',7788,'2021-05-29 21:56:14.84'),(3,'mehmet','ekin','333333333','kızıltepe',15787,'2021-05-29 17:38:49.886'),(4,'sait','can','444444444','artuklu',18784,'2021-05-29 17:38:35.854'),(15,'Tekin','Can','12345678','iskenderun /hatay',12500,'2021-05-29 21:56:04.623');
/*!40000 ALTER TABLE `carihesaplar` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-29 22:31:16
