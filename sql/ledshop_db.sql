-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ledshop
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application` (
  `id` int(11) NOT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `url` varchar(400) DEFAULT NULL,
  `enable` tinyint(1) NOT NULL,
  `position` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Лампы','//',1,1),(2,'Прожекторы','//',1,2),(3,'Светильники','//',1,4),(4,'Комплектующие','//',1,3),(5,'Ремонт','//',0,5);
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `username` varchar(255) NOT NULL,
  `text` text NOT NULL,
  `products_id` int(11) NOT NULL,
  `enable` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comments_products1_idx` (`products_id`),
  CONSTRAINT `fk_comments_products1` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(45) NOT NULL,
  `orders_id` int(11) NOT NULL,
  `address` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customers_orders1_idx` (`orders_id`),
  CONSTRAINT `fk_customers_orders1` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_options`
--

DROP TABLE IF EXISTS `delivery_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_options` (
  `id` int(11) NOT NULL,
  `price_start` decimal(18,2) NOT NULL,
  `price_end` decimal(18,2) NOT NULL,
  `delivery_types_id` int(11) NOT NULL,
  `price` decimal(18,2) NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `position` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_delivery_options_delivery_types1_idx` (`delivery_types_id`),
  CONSTRAINT `fk_delivery_options_delivery_types1` FOREIGN KEY (`delivery_types_id`) REFERENCES `delivery_types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_options`
--

LOCK TABLES `delivery_options` WRITE;
/*!40000 ALTER TABLE `delivery_options` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_types`
--

DROP TABLE IF EXISTS `delivery_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_types` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `position` int(11) DEFAULT NULL,
  `orders_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_delivery_types_orders1_idx` (`orders_id`),
  CONSTRAINT `fk_delivery_types_orders1` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_types`
--

LOCK TABLES `delivery_types` WRITE;
/*!40000 ALTER TABLE `delivery_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medias`
--

DROP TABLE IF EXISTS `medias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medias` (
  `id` int(11) NOT NULL,
  `size` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `data` text,
  `enable` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_media_product1_idx` (`product_id`),
  CONSTRAINT `fk_media_product1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medias`
--

LOCK TABLES `medias` WRITE;
/*!40000 ALTER TABLE `medias` DISABLE KEYS */;
/*!40000 ALTER TABLE `medias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_details` (
  `id` int(11) NOT NULL,
  `price` decimal(18,2) NOT NULL,
  `products_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_details_products1_idx` (`products_id`),
  CONSTRAINT `fk_order_details_products1` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `order_details_id` int(11) NOT NULL,
  `order_uuid` varchar(32) NOT NULL,
  `pin` int(11) NOT NULL,
  `comment` varchar(300) DEFAULT NULL,
  `date` datetime NOT NULL,
  `close_date` datetime DEFAULT NULL,
  `price` decimal(18,2) NOT NULL,
  `delivery_price` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_orders_order_details1_idx` (`order_details_id`),
  CONSTRAINT `fk_orders_order_details1` FOREIGN KEY (`order_details_id`) REFERENCES `order_details` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parameters`
--

DROP TABLE IF EXISTS `parameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parameters` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `enable` tinyint(1) DEFAULT NULL,
  `position` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parameters`
--

LOCK TABLES `parameters` WRITE;
/*!40000 ALTER TABLE `parameters` DISABLE KEYS */;
/*!40000 ALTER TABLE `parameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametrs_products`
--

DROP TABLE IF EXISTS `parametrs_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametrs_products` (
  `id` int(11) NOT NULL,
  `products_id` int(11) NOT NULL,
  `parameters_id` int(11) NOT NULL,
  `value` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_parametrs_products_products1_idx` (`products_id`),
  KEY `fk_parametrs_products_parameters1_idx` (`parameters_id`),
  CONSTRAINT `fk_parametrs_products_parameters1` FOREIGN KEY (`parameters_id`) REFERENCES `parameters` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_parametrs_products_products1` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametrs_products`
--

LOCK TABLES `parametrs_products` WRITE;
/*!40000 ALTER TABLE `parametrs_products` DISABLE KEYS */;
/*!40000 ALTER TABLE `parametrs_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_types`
--

DROP TABLE IF EXISTS `payment_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_types` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `position` int(11) NOT NULL,
  `description` varchar(300) DEFAULT NULL,
  `orders_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_payment_types_orders1_idx` (`orders_id`),
  CONSTRAINT `fk_payment_types_orders1` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_types`
--

LOCK TABLES `payment_types` WRITE;
/*!40000 ALTER TABLE `payment_types` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `photos`
--

DROP TABLE IF EXISTS `photos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `photos` (
  `id` int(11) NOT NULL,
  `size` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `data` text,
  `position` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_photo_product1_idx` (`product_id`),
  CONSTRAINT `fk_photo_product1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `photos`
--

LOCK TABLES `photos` WRITE;
/*!40000 ALTER TABLE `photos` DISABLE KEYS */;
INSERT INTO `photos` VALUES (1,25,'orig','2014-12-30 15:20:31',1,'',1),(2,25,'large','2014-12-30 15:20:31',3,NULL,1),(3,25,'large','2014-12-30 15:20:31',2,NULL,1),(4,25,'ge','2014-12-30 15:20:31',2,NULL,1),(5,25,'orig','2014-12-30 15:20:31',1,NULL,1),(6,25,'large','2014-12-30 15:20:31',3,NULL,1),(7,25,'large','2014-12-30 15:20:31',2,NULL,1),(8,25,'ge','2014-12-30 15:20:31',2,NULL,1),(9,25,'orig','2014-12-30 15:20:31',1,NULL,1),(10,25,'large','2014-12-30 15:20:31',3,NULL,1),(11,25,'large','2014-12-30 15:20:31',2,NULL,1),(12,25,'ge','2014-12-30 15:20:31',2,NULL,1),(13,25,'orig','2014-12-30 15:20:31',1,NULL,1),(14,25,'large','2014-12-30 15:20:31',3,NULL,1),(15,25,'large','2014-12-30 15:20:31',2,NULL,1);
/*!40000 ALTER TABLE `photos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prices`
--

DROP TABLE IF EXISTS `prices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prices` (
  `id` int(11) NOT NULL,
  `price` decimal(18,2) NOT NULL,
  `product_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `enable` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_prices_product1_idx` (`product_id`),
  CONSTRAINT `fk_prices_product1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prices`
--

LOCK TABLES `prices` WRITE;
/*!40000 ALTER TABLE `prices` DISABLE KEYS */;
/*!40000 ALTER TABLE `prices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sku` varchar(45) NOT NULL,
  `position` int(11) NOT NULL,
  `shot_descr` varchar(255) DEFAULT NULL,
  `long_descr` text,
  `date` datetime NOT NULL,
  `category_id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_product_category_idx` (`category_id`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Просто лампочка E27','111',1,'foo','fooo','2014-12-29 12:42:00',1,0),(2,'Просто лампочка E27','112',2,'foo','fooo','2014-12-29 12:42:00',1,0),(3,'Очень крутая лампочка E27 10W','113',3,'foo','fooo','2014-12-29 12:42:00',1,0),(4,'Хуйня какаето, Е27','114',4,'foo','fooo','2014-12-29 12:42:00',1,0),(5,'Просто лампочка E27','115',5,'foo','fooo','2014-12-29 12:42:00',1,0),(6,'Очень крутая лампочка E27 10W','116',6,'foo','fooo','2014-12-29 12:42:00',1,0),(7,'Очень крутая лампочка E27 10W','116',1,'foo','fooo','2014-12-29 12:42:00',2,0),(8,'Очень крутая лампочка E27 10W','116',2,'foo','fooo','2014-12-29 12:42:00',2,0),(9,'Очень крутая лампочка E27 10W','116',1,'foo','fooo','2014-12-29 12:42:00',4,0),(10,'Очень крутая лампочка E27 10W','116',2,'foo','fooo','2014-12-29 12:42:00',4,0),(11,'Очень крутая лампочка E27 10W','116',3,'foo','fooo','2014-12-29 12:42:00',4,0),(12,'Очень крутая лампочка E27 10W','116',1,'foo','fooo','2014-12-29 12:42:00',3,0),(13,'Очень крутая лампочка E27 10W','116',2,'foo','fooo','2014-12-29 12:42:00',3,0),(14,'Очень крутая лампочка E27 10W','116',3,'foo','fooo','2014-12-29 12:42:00',3,0),(15,'Очень крутая лампочка E27 10W','116',4,'foo','fooo','2014-12-29 12:42:00',3,0),(16,'Очень крутая лампочка E27 10W','116',5,'foo','fooo','2014-12-29 12:42:00',3,0),(17,'Очень крутая лампочка E27 10W','116',4,'foo','fooo','2014-12-29 12:42:00',4,0),(18,'Очень крутая лампочка E27 10W','116',3,'foo','fooo','2014-12-29 12:42:00',2,0),(19,'Очень крутая лампочка E27 10W','116',4,'foo','fooo','2014-12-29 12:42:00',2,0);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reviews` (
  `id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `username` varchar(255) NOT NULL,
  `text` text NOT NULL,
  `products_id` int(11) NOT NULL,
  `enable` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reviews_products1_idx` (`products_id`),
  CONSTRAINT `fk_reviews_products1` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-30 18:16:53
