-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: customer-order-details
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('test','ADMIN');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `billing`
--

LOCK TABLES `billing` WRITE;
/*!40000 ALTER TABLE `billing` DISABLE KEYS */;
INSERT INTO `billing` VALUES (1,2,2,1,'2021-08-20'),(2,1,13,1,'2021-09-20'),(3,1,6,1,'2021-10-20'),(4,1,13,2,'2021-08-20'),(5,1,2,2,'2021-09-20'),(6,1,6,2,'2021-10-20'),(7,1,13,3,'2021-09-20'),(8,1,6,3,'2021-09-20'),(9,1,8,3,'2021-09-20'),(10,1,1,4,'2021-08-20'),(11,1,10,5,'2021-02-20');
/*!40000 ALTER TABLE `billing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'John','9998880000','john@xyz.com','xyz',_binary ''),(2,'Mark','8899980000','mark@xyz.com','zyx',_binary ''),(3,'Mike','102030000','mike@xyz.com','yzx',_binary ''),(4,'Sam','1112220000','sam@xyz.com','xzy',_binary ''),(5,'Gwen','1110002222','gwen@xyz.com','zxy',_binary '');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'BOOK-TECH','Crash Course in Python',14.99,_binary ''),(2,'TV','4K Smart Tv',149.99,_binary ''),(3,'Tablet','Android Smart Fire Tablet',79.99,_binary ''),(4,'Headphone','Indulge into Music',74.99,_binary ''),(5,'TV Stand','Best Stand with solid finishing touch',59.99,_binary ''),(6,'Tablet Smart Case','Stylish case with good design',9.99,_binary ''),(7,'Lenovo Laptop','I5 processor with 8gb ram',299.99,_binary ''),(8,'1Tb Hp SSD','1Tb HP SSD',89.99,_binary ''),(9,'Ear Bud','Bluetooth Wireless EarBud',64.99,_binary ''),(10,'Bluetooth Headphone','Bluetooth Headphone',74.99,_binary ''),(11,'WaterBottle','Waterbottle',1.99,_binary ''),(12,'LightBulb','Light bulb',2.99,_binary ''),(13,'Microoven','Samsung Mircooven',144.99,_binary ''),(14,'Trimmer','Philips Trimmer',19.99,_binary ''),(15,'Desktop Monitor','Samsung 15inch Desktop Monitor',39.99,_binary '');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('test','{bcrypt}$2a$12$mhEz80OPf5QEsNfNiHNgKeM1m4ymYhe36Yy4uBizVUDSVvBd0w/8q',1);
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

-- Dump completed on 2021-11-14 13:17:39
