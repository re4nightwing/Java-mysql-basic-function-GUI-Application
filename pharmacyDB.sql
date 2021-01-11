CREATE DATABASE  IF NOT EXISTS `stock_pharmacydb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `stock_pharmacydb`;
-- MariaDB dump 10.17  Distrib 10.4.14-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: stock_pharmacydb
-- ------------------------------------------------------
-- Server version	10.4.14-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `delivers`
--

DROP TABLE IF EXISTS `delivers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivers` (
  `supplier_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`supplier_id`,`product_id`),
  KEY `deliver_pro_pro` (`product_id`),
  CONSTRAINT `deliver_pro_pro` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `deliver_sup_sup` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivers`
--

LOCK TABLES `delivers` WRITE;
/*!40000 ALTER TABLE `delivers` DISABLE KEYS */;
INSERT INTO `delivers` VALUES (1,1),(1,3),(2,4),(2,7),(2,9),(3,1),(4,1),(5,6),(6,2),(7,5),(8,8),(9,10),(10,10);
/*!40000 ALTER TABLE `delivers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `Emp_ID` int(10) NOT NULL AUTO_INCREMENT,
  `F_Name` varchar(255) NOT NULL,
  `L_Name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `designation` varchar(100) NOT NULL,
  `DOB` date NOT NULL,
  `salary` int(10) NOT NULL,
  `hired_date` date NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`Emp_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'dulan','pabasara','galle','male','pharmacist','2000-11-08',50000,'2020-11-03','dulan@13.com'),(2,'tharindu','jaya','Gampaha','male','pharmacist','2000-06-16',60000,'2020-11-03','tharindu@13.com'),(3,'janindu','jaya','Gampaha','male','pharmacist','2000-06-20',60000,'2020-11-03','janindu@13.com'),(4,'adam','lee','Waligama','male','worker','2000-03-25',30000,'2020-11-03','adam@13.com'),(5,'ramesh','mohamad','Gampaha','male','worker','2000-01-13',30000,'2020-11-03','rameshu@13.com'),(6,'chee','lai','Galle','male','worker','2000-01-12',30000,'2020-11-03','cheeu@13.com'),(7,'kakashi','sensei','Konaha','male','worker','2000-02-20',30000,'2020-11-03','kakashi@13.com'),(8,'naruto','uzumaki','Konaha','male','pharmacist','2000-07-08',65000,'2020-11-03','narutouzu@13.com'),(9,'mirai','nikki','Tokyo','male','worker','2000-03-30',30000,'2020-11-03','mirai@13.com'),(10,'blind','zoro','Gampaha','male','worker','2000-12-01',25000,'2020-11-03','zoro@13.com');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_contact`
--

DROP TABLE IF EXISTS `employee_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_contact` (
  `Emp_ID` int(11) NOT NULL,
  `contact_no` int(11) NOT NULL,
  PRIMARY KEY (`Emp_ID`,`contact_no`),
  CONSTRAINT `employee_employee_contact` FOREIGN KEY (`Emp_ID`) REFERENCES `employee` (`Emp_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_contact`
--

LOCK TABLES `employee_contact` WRITE;
/*!40000 ALTER TABLE `employee_contact` DISABLE KEYS */;
INSERT INTO `employee_contact` VALUES (1,711234567),(1,768500503),(2,771234567),(2,781234567),(3,721234567),(3,751234567),(4,767654321),(5,727654321),(6,787654321),(7,757654321),(8,717654321),(9,707654321),(10,767652222);
/*!40000 ALTER TABLE `employee_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory` (
  `inv_id` int(11) NOT NULL AUTO_INCREMENT,
  `update_date` date DEFAULT NULL,
  `remain_quantity` int(10) DEFAULT NULL,
  `exp_date` date DEFAULT NULL,
  PRIMARY KEY (`inv_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (1,'2020-12-16',5,'2021-05-01'),(2,'2020-12-14',10,'2021-05-01'),(3,'2020-12-12',30,'2021-05-01'),(4,'2020-12-12',8,'2021-05-01'),(5,'2020-12-15',8,'2022-05-01'),(6,'2020-12-13',10,'2022-05-01'),(7,'2020-12-12',35,'2022-05-01'),(8,NULL,NULL,NULL),(9,'2020-12-12',50,'2023-05-01'),(10,NULL,NULL,NULL);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `Emp_ID` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `order_date` date NOT NULL,
  PRIMARY KEY (`Emp_ID`,`product_id`,`order_date`),
  KEY `order_pro_pro` (`product_id`),
  CONSTRAINT `order_emp_emp` FOREIGN KEY (`Emp_ID`) REFERENCES `pharmacists` (`Emp_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_pro_pro` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,10,'2020-12-10'),(1,1,10,'2020-12-12'),(3,3,50,'2020-12-10'),(3,4,20,'2020-12-09'),(4,1,10,'2020-12-09'),(4,5,10,'2020-12-10'),(4,6,25,'2020-12-11'),(6,7,50,'2020-12-09'),(8,9,60,'2020-12-10'),(9,10,20,'2020-12-16'),(10,1,10,'2020-12-09'),(10,2,20,'2020-12-10');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacists`
--

DROP TABLE IF EXISTS `pharmacists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pharmacists` (
  `Emp_ID` int(11) NOT NULL,
  `license_No` varchar(11) NOT NULL,
  PRIMARY KEY (`Emp_ID`),
  CONSTRAINT `emp_phar` FOREIGN KEY (`Emp_ID`) REFERENCES `employee` (`Emp_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacists`
--

LOCK TABLES `pharmacists` WRITE;
/*!40000 ALTER TABLE `pharmacists` DISABLE KEYS */;
INSERT INTO `pharmacists` VALUES (1,'LK55'),(3,'LK26'),(4,'LK101'),(6,'LK20'),(8,'LK65'),(9,'LK78'),(10,'LK55');
/*!40000 ALTER TABLE `pharmacists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) DEFAULT NULL,
  `sell_price` int(10) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `inv_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `product_inv` (`inv_id`),
  CONSTRAINT `product_inv` FOREIGN KEY (`inv_id`) REFERENCES `inventory` (`inv_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'baby cream',750,'baby cream for babies',1),(2,'baby cream V2',1000,'baby cream for babies version 2',2),(3,'Thermale Water Spray',1800,'Avène Eau Thermale Water Spray',3),(4,'Dry Shampoo',2500,'Klorane Gentle Dry Shampoo with Oatmilk',4),(5,'Homeoplasmine',500,'Homeoplasmine Homeoplasmine',5),(6,'Biafine',400,'Biafine Biafine',6),(7,'Embryolisse',900,'Embryolisse Embryolisse',7),(8,'Avibon',750,'Avibon Avibon',8),(9,'H2O Micelle Solution',2500,'Bioderma Crealine H2O Micelle Solution',9),(10,'Alfalux Baume Levres',1750,'Alfalux Baume Levres Alfalux Baume Levres',10);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase` (
  `supplier_id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `cost_per_unit` int(11) NOT NULL,
  `purchase_date` date NOT NULL,
  PRIMARY KEY (`supplier_id`,`emp_id`,`product_id`,`purchase_date`),
  KEY `emp_to_emp` (`emp_id`),
  KEY `pro_to_pro` (`product_id`),
  CONSTRAINT `pro_to_pro` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sup_to_sup` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` VALUES (1,1,1,10,700,'2020-12-12'),(1,1,1,10,700,'2020-12-16'),(1,2,3,50,1500,'2020-12-12'),(2,3,4,20,2000,'2020-12-12'),(2,4,7,50,800,'2020-12-12'),(2,4,9,60,2000,'2020-12-12'),(3,5,1,10,650,'2020-12-13'),(4,6,1,10,700,'2020-12-13'),(5,7,6,25,350,'2020-12-13'),(6,8,2,20,900,'2020-12-14'),(7,9,5,10,470,'2020-12-15');
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `supplier_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `monthly invoice amount` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'ABC-holdings','Galle',100000,'abc@abc.com'),(2,'lance-inc','Colombo',100000,'lance@lance.com'),(3,'vial-ltd','Colombo',100000,'vial@vial.com'),(4,'diamond-coop','Colombo',100000,'diamond@diamond.com'),(5,'araliya','Colombo',100000,'araliya@araliya.com'),(6,'rathna','Jaffna',100000,'rathna@rathna.com'),(7,'uniliver','Jaffna',100000,'uniliver@uniliver.com'),(8,'viral-support','Colombo',100000,'viral@viral.com'),(9,'sql-life','Galle',100000,'sql@sql.com'),(10,'lorem-ipsum','Galle',100000,'lorem@lorem.com');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_contact`
--

DROP TABLE IF EXISTS `supplier_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier_contact` (
  `supplier_id` int(11) NOT NULL,
  `contact_no` int(11) NOT NULL,
  PRIMARY KEY (`supplier_id`,`contact_no`),
  CONSTRAINT `supplier_supContacts` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_contact`
--

LOCK TABLES `supplier_contact` WRITE;
/*!40000 ALTER TABLE `supplier_contact` DISABLE KEYS */;
INSERT INTO `supplier_contact` VALUES (1,711234567),(1,767652222),(1,2147483647),(2,771234567),(2,781234567),(3,721234567),(3,751234567),(4,767654321),(5,727654321),(6,787654321),(7,757654321),(8,717654321),(9,707654321),(10,712563495);
/*!40000 ALTER TABLE `supplier_contact` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-05 14:03:53
