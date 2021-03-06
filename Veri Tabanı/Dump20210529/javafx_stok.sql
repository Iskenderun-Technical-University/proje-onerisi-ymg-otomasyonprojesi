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
-- Table structure for table `stok`
--

DROP TABLE IF EXISTS `stok`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stok` (
  `motorID` int NOT NULL AUTO_INCREMENT,
  `motorMarka` varchar(45) DEFAULT NULL,
  `motorModelYili` varchar(45) DEFAULT NULL,
  `motorRenk` varchar(12) DEFAULT NULL,
  `motorFiyat` float DEFAULT NULL,
  `motorSasiNo` varchar(255) DEFAULT NULL,
  `motorMotorNo` varchar(255) DEFAULT NULL,
  `motorFaturaKesildiMi` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`motorID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stok`
--

LOCK TABLES `stok` WRITE;
/*!40000 ALTER TABLE `stok` DISABLE KEYS */;
INSERT INTO `stok` VALUES (1,'YUKİ','2019','BEYAZ',12225,'ASD45AS4D5SAD45ASD4','SD54S5D4A8D4AS5D4AS5D5A4','KESİLMEDİ'),(2,'YUKİ','2019','BEYAZ',12225,'ASD45AS4D5SAD45ASD4','SD54S5D4A8D4AS5D4AS5D5A4','KESİLMEDİ'),(4,'YUKİ','2019','BEYAZ',12225,'ASD45AS4D5SAD45ASD4','SD54S5D4A8D4AS5D4AS5D5A4','KESİLMEDİ'),(5,'ARORA','2021','KIRMIZI',12225,'ASD45ASASA4DDS5SAD45ASD4AS','SD54S5D4A8DASASSDA4AS5D4AS5D5A4','KESİLMEDİ'),(6,'Yamaha','2020','KIRMIZI',13787,'AS45A4SASJASHAJSA54545','4A5S4A5S454a5s45as4a5s','Kesilmedi'),(7,'Asya Cup','2021','Beyaz',7877,'LSAKSJASASAS89AS7A8S7A55','CFSDCD4C8SD8DC4D8S4C8D4SC8','Kesilmedi'),(8,'ARORA','2021','KIRMIZI',12225,'ASD45ASASA4DDS5SAD45ASD4AS','SD54S5D4A8DASASSDA4AS5D4AS5D5A4','KESİLMEDİ'),(9,'YUKİ','2019','BEYAZ',12225,'ASD45AS4D5SAD45ASD4','SD54S5D4A8D4AS5D4AS5D5A4','KESİLMEDİ'),(10,'YAMAHA R6','2021','KIRMIZI',197089,'ASD45ASASA4D5SAD45ASD4','SD54S5D4A8DASASA4AS5D4AS5D5A4','KESİLMEDİ'),(11,'YAMAHA R1','2021','KIRMIZI',246878,'ASD45ASASA4DDS5SAD45ASD4','SD54S5D4A8DASASSDA4AS5D4AS5D5A4','KESİLMEDİ'),(12,'MOTOLUX','2020','SİYAH',12225,'ASD45ASASA4DDS5SAD45ASD4AS','SD54S5D4A8DASASSDA4AS5D4AS5D5A4','KESİLMEDİ'),(13,'ARORA','2021','KIRMIZI',12225,'ASD45ASASA4DDS5SAD45ASD4AS','SD54S5D4A8DASASSDA4AS5D4AS5D5A4','KESİLMEDİ'),(14,'FALCON','2021','SİYAH',12225,'ASD45ASASA4DDS5SAD45ASD4AS','SD54S5D4A8DASASSDA4AS5D4AS5D5A4','KESİLMEDİ'),(15,'FALCON','2021','SİYAH',12225,'ASD45ASASA4DDS5SAD45ASD4AS','SD54S5D4A8DASASSDA4AS5D4AS5D5A4','KESİLMEDİ');
/*!40000 ALTER TABLE `stok` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-29 22:31:17
