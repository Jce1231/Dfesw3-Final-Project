-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: charactercrusher
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `charact`
--

DROP TABLE IF EXISTS `charact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `charact` (
  `charact_id` int NOT NULL AUTO_INCREMENT,
  `con` int NOT NULL,
  `dex` int NOT NULL,
  `dmg` int NOT NULL,
  `health` int NOT NULL,
  `intel` int NOT NULL,
  `speed` int NOT NULL,
  `str` int NOT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`charact_id`),
  KEY `FKhgtq5ujkbqls3m61v7c2nyx4u` (`user_id`),
  CONSTRAINT `FKhgtq5ujkbqls3m61v7c2nyx4u` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `charact`
--

LOCK TABLES `charact` WRITE;
/*!40000 ALTER TABLE `charact` DISABLE KEYS */;
INSERT INTO `charact` VALUES (1,6,0,30,220,11,0,8,1),(2,9,9,7,190,6,13,1,1),(3,1,11,9,30,12,16,1,1),(4,7,4,27,220,7,6,7,1),(5,8,1,37,280,6,1,10,1),(6,3,9,37,170,4,13,9,1),(7,11,8,22,280,1,12,5,1),(8,7,8,33,240,2,12,8,1),(9,4,9,15,110,9,13,3,1),(10,12,3,12,270,7,4,3,1),(11,11,2,27,300,5,3,7,1),(12,5,11,16,130,6,16,3,1),(13,7,7,36,250,2,10,9,1),(14,7,9,12,160,7,13,2,1),(15,2,11,39,150,3,16,9,1),(16,9,10,7,190,5,15,1,1),(17,3,8,45,190,3,12,11,1),(18,3,10,49,210,0,15,12,1),(19,7,8,37,250,1,12,9,1),(20,11,6,3,220,8,9,0,1),(21,12,4,9,260,7,6,2,1),(22,11,6,21,280,3,9,5,1),(23,2,9,27,110,8,13,6,1),(24,7,3,42,270,4,4,11,1),(25,6,3,31,220,8,4,8,1),(26,11,6,3,220,8,9,0,1),(27,10,3,46,350,0,4,12,1),(28,0,5,43,130,9,7,11,1),(29,11,7,28,300,0,10,7,1),(30,5,12,36,200,0,18,8,1),(31,0,11,24,60,9,16,5,1),(32,1,12,16,50,9,18,3,1),(33,7,10,7,150,7,15,1,1),(34,2,2,45,190,9,3,12,1),(35,2,12,46,170,0,18,11,1),(36,4,1,45,230,8,1,12,1),(37,4,10,22,140,6,15,5,1),(38,2,8,48,190,3,12,12,1),(39,8,6,18,210,7,9,4,1),(40,0,8,22,60,12,12,5,1),(41,5,0,45,250,8,0,12,1),(42,5,4,31,200,8,6,8,1),(43,11,1,22,290,7,1,6,1),(44,5,11,39,210,0,16,9,1),(45,7,9,27,210,3,13,6,1),(46,11,8,7,230,5,12,1,1),(47,12,3,1,240,10,4,0,1),(48,7,1,37,260,7,1,10,1),(49,4,8,22,140,8,12,5,1),(50,12,11,9,250,1,16,1,1),(51,3,12,39,170,1,18,9,1),(52,2,1,37,160,12,1,10,1),(53,10,4,34,310,2,6,9,1),(54,7,9,37,250,0,13,9,1),(55,1,8,37,130,7,12,9,1),(56,11,8,7,230,5,12,1,1),(57,9,6,6,190,9,9,1,1),(58,8,9,15,190,5,13,3,1),(59,7,5,36,250,4,7,9,1),(60,1,3,46,170,9,4,12,1),(61,0,3,39,120,12,4,10,1),(62,3,9,7,70,12,13,1,1),(63,3,7,21,120,10,10,5,1),(64,3,12,31,140,3,18,7,1),(65,1,10,30,100,7,15,7,1),(66,11,1,33,330,4,1,9,1),(67,10,2,7,220,11,3,2,1),(68,2,9,12,60,12,13,2,1),(69,8,11,4,160,6,16,0,1),(70,8,11,16,190,3,16,3,1),(71,5,11,31,180,2,16,7,1),(72,10,5,24,270,4,7,6,1),(73,5,0,37,220,10,0,10,1),(74,10,4,42,330,0,6,11,1),(75,7,5,36,250,4,7,9,1),(76,7,12,16,170,3,18,3,1),(77,0,2,45,150,11,3,12,1),(78,11,9,19,270,1,13,4,1),(79,2,8,37,150,6,12,9,1),(80,2,11,12,60,10,16,2,1),(81,5,5,46,250,3,7,12,1),(82,6,11,9,130,7,16,1,1),(83,7,4,27,220,7,6,7,1),(84,4,2,42,210,8,3,11,1),(85,6,9,15,150,7,13,3,1),(86,6,6,48,270,1,9,12,1),(87,12,2,4,250,10,3,1,1),(88,9,9,12,200,5,13,2,1),(89,8,8,25,230,3,12,6,1),(90,8,7,25,230,4,10,6,1),(91,10,3,4,210,11,4,1,1),(92,9,0,18,240,11,0,5,1),(93,10,8,30,280,0,12,7,1),(94,0,6,48,150,7,9,12,1),(95,3,7,43,190,4,10,11,1),(96,2,11,4,40,12,16,0,1),(97,2,12,36,140,3,18,8,1),(98,10,1,7,220,12,1,2,1),(99,6,7,3,120,12,10,0,1),(100,7,2,19,200,11,3,5,1),(101,12,4,4,250,8,6,1,1),(102,6,8,25,190,5,12,6,1),(103,2,8,40,160,5,12,10,1),(104,0,11,16,30,11,16,3,1),(105,9,6,33,280,2,9,8,1);
/*!40000 ALTER TABLE `charact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leaderboard`
--

DROP TABLE IF EXISTS `leaderboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leaderboard` (
  `leaderboard_id` int NOT NULL AUTO_INCREMENT,
  `losses` int NOT NULL,
  `wins` int NOT NULL,
  `charact_id` int DEFAULT NULL,
  PRIMARY KEY (`leaderboard_id`),
  KEY `FK2g6gsww5g2qo6gyklodj5v0qu` (`charact_id`),
  CONSTRAINT `FK2g6gsww5g2qo6gyklodj5v0qu` FOREIGN KEY (`charact_id`) REFERENCES `charact` (`charact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaderboard`
--

LOCK TABLES `leaderboard` WRITE;
/*!40000 ALTER TABLE `leaderboard` DISABLE KEYS */;
INSERT INTO `leaderboard` VALUES (1,8,96,5),(2,65,39,10);
/*!40000 ALTER TABLE `leaderboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'System Generated');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-13 23:52:55
