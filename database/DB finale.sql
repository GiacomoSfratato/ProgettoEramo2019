-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: dbunivaq2019.cgrpp6xc53dw.eu-west-3.rds.amazonaws.com    Database: dbunivaq2019
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `autore`
--

DROP TABLE IF EXISTS `autore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `autore` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autore`
--

LOCK TABLES `autore` WRITE;
/*!40000 ALTER TABLE `autore` DISABLE KEYS */;
INSERT INTO `autore` VALUES (1,'Pippo','Baudo'),(2,'Lev','Tolstoj'),(3,'Alan','Milne'),(4,'Dan','Brown'),(5,'Dawid','Pado'),(6,'Giuseppe','Garibaldi'),(7,'Stan','Lee'),(8,'Bryant','Sarabia');
/*!40000 ALTER TABLE `autore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `capitolo`
--

DROP TABLE IF EXISTS `capitolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `capitolo` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_pubblicazione` int(10) unsigned DEFAULT NULL,
  `numero` int(10) unsigned NOT NULL,
  `titolo` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `capitolo_unico` (`ID_pubblicazione`,`numero`),
  CONSTRAINT `capitolo_ibfk_1` FOREIGN KEY (`ID_pubblicazione`) REFERENCES `pubblicazione` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `capitolo`
--

LOCK TABLES `capitolo` WRITE;
/*!40000 ALTER TABLE `capitolo` DISABLE KEYS */;
INSERT INTO `capitolo` VALUES (1,4,1,'Ingresso'),(2,4,2,'La via'),(3,4,3,'Uscita'),(4,4,4,'Tutto ha una fine'),(5,8,1,'Inizio'),(6,8,2,'Vecchi ricordi'),(7,8,3,'Memento mori'),(8,8,4,'Lutto'),(9,16,1,'Un Grande BS'),(10,16,2,'BS diventa bs'),(11,16,3,'la vendetta '),(12,16,4,'La fine è vicina'),(13,7,1,'Il grano'),(14,7,2,'Fuoco!'),(15,7,3,'Finalmente la pace'),(16,7,4,'Un nuovo nemico');
/*!40000 ALTER TABLE `capitolo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cerca`
--

DROP TABLE IF EXISTS `cerca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cerca` (
  `ID_pubblicazione` int(10) unsigned NOT NULL,
  `ID_parolachiave` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID_pubblicazione`,`ID_parolachiave`),
  KEY `ID_parolachiave` (`ID_parolachiave`),
  CONSTRAINT `cerca_ibfk_1` FOREIGN KEY (`ID_pubblicazione`) REFERENCES `pubblicazione` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `cerca_ibfk_2` FOREIGN KEY (`ID_parolachiave`) REFERENCES `parola_chiave` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cerca`
--

LOCK TABLES `cerca` WRITE;
/*!40000 ALTER TABLE `cerca` DISABLE KEYS */;
INSERT INTO `cerca` VALUES (2,1),(15,2),(4,3),(16,4),(16,5),(16,6),(8,7),(8,8),(4,9),(4,10),(7,11),(7,12),(3,13);
/*!40000 ALTER TABLE `cerca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `likes` (
  `ID_utente` int(10) unsigned NOT NULL,
  `ID_pubblicazione` int(10) unsigned NOT NULL,
  `data` timestamp NOT NULL,
  PRIMARY KEY (`ID_utente`,`ID_pubblicazione`),
  UNIQUE KEY `un_like_ck` (`ID_utente`,`ID_pubblicazione`),
  KEY `ID_pubblicazione` (`ID_pubblicazione`),
  CONSTRAINT `likes_ibfk_1` FOREIGN KEY (`ID_utente`) REFERENCES `utente` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `likes_ibfk_2` FOREIGN KEY (`ID_pubblicazione`) REFERENCES `pubblicazione` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES (11,7,'2019-07-18 22:33:13'),(12,1,'2019-07-18 20:22:10'),(12,6,'2019-07-18 20:22:26'),(12,7,'2019-07-18 22:40:36');
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`dbunivaq2019`@`%`*/ /*!50003 TRIGGER `like_nello_storico` AFTER INSERT ON `likes` FOR EACH ROW BEGIN
INSERT INTO storico VALUES(NEW.ID_utente, NEW.ID_pubblicazione,'like',NEW.data);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`dbunivaq2019`@`%`*/ /*!50003 TRIGGER `rimuovi_like_storico` AFTER DELETE ON `likes` FOR EACH ROW BEGIN 
DELETE FROM storico WHERE OLD.ID_utente = ID_utente AND OLD.ID_pubblicazione=ID_pubblicazione AND descrizione = 'like';
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `metadati`
--

DROP TABLE IF EXISTS `metadati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `metadati` (
  `ID_pubblicazione` int(10) unsigned NOT NULL,
  `isbn` varchar(13) DEFAULT NULL,
  `nrpagine` int(10) unsigned DEFAULT NULL,
  `lingua` varchar(20) DEFAULT NULL,
  `data_pubblicazione` date DEFAULT NULL,
  PRIMARY KEY (`ID_pubblicazione`),
  CONSTRAINT `metadati_ibfk_1` FOREIGN KEY (`ID_pubblicazione`) REFERENCES `pubblicazione` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metadati`
--

LOCK TABLES `metadati` WRITE;
/*!40000 ALTER TABLE `metadati` DISABLE KEYS */;
INSERT INTO `metadati` VALUES (1,'1937402746501',200,'italiano','2009-02-21'),(2,'1937402746521',250,'italiano','2000-10-08'),(3,'1829364092615',100,'italiano','2005-01-28'),(4,'0628361937461',375,'italiano','2009-07-22'),(6,'8526841096293',400,'italiano','2010-07-30'),(7,'5843728195723',190,'IT','2019-07-18'),(8,'1238647544390',100,'italiano','2006-03-23'),(15,'2937615289025',200,'italiano','1998-12-20'),(16,'3458293087076',90,'italiano','2001-01-05');
/*!40000 ALTER TABLE `metadati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parola_chiave`
--

DROP TABLE IF EXISTS `parola_chiave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parola_chiave` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `parola` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parola_chiave`
--

LOCK TABLES `parola_chiave` WRITE;
/*!40000 ALTER TABLE `parola_chiave` DISABLE KEYS */;
INSERT INTO `parola_chiave` VALUES (1,'guerra'),(2,'supereroi'),(3,'complotto'),(4,'BS'),(5,'curioso'),(6,'un poquito loco'),(7,'morte'),(8,'killer'),(9,'diavolo'),(10,'demonio'),(11,'Fulvio'),(12,'agricultura'),(13,'bambini');
/*!40000 ALTER TABLE `parola_chiave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pubblicazione`
--

DROP TABLE IF EXISTS `pubblicazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pubblicazione` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `titolo` varchar(50) DEFAULT NULL,
  `descrizione` varchar(200) DEFAULT 'Non disponibile',
  `editore` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pubblicazione`
--

LOCK TABLES `pubblicazione` WRITE;
/*!40000 ALTER TABLE `pubblicazione` DISABLE KEYS */;
INSERT INTO `pubblicazione` VALUES (1,'Il tempo delle mele','una mele al giorno...','Feltrinelli'),(2,'Guerra e pace','Due mele...','Mondadori'),(3,'Winnie the Pooh','una mele al giorno...','Mondadori'),(4,'Inferno','Due mele...','Mondadori'),(6,'Il Codice da Vinci','Best-seller di Dan Brown','Mondadori'),(7,'L\'attacco delle penne','Le penne assassine vanno alla ricerca degli umani per ucciderli','Dodgelord'),(8,'M come morte','romanzo drammatico','Mondadori'),(15,'L\'uomo ragno','Celebre fumetto Marvel','Marvel Comics'),(16,'La curiosa vita di Bryant','uno due tre quattro','Mondadori');
/*!40000 ALTER TABLE `pubblicazione` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`dbunivaq2019`@`%`*/ /*!50003 TRIGGER `modifica_pubblicazione_storico` AFTER UPDATE ON `pubblicazione` FOR EACH ROW BEGIN
DECLARE ID_tizio INT UNSIGNED;
SET ID_tizio = (SELECT ID_utente FROM storico where OLD.ID = storico.ID_pubblicazione AND storico.descrizione = 'inserimento');
INSERT INTO storico VALUES(ID_tizio, OLD.ID,'modifica',NOW());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `recensione`
--

DROP TABLE IF EXISTS `recensione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `recensione` (
  `ID_utente` int(10) unsigned NOT NULL,
  `ID_pubblicazione` int(10) unsigned NOT NULL,
  `contenuto` varchar(200) NOT NULL,
  `data` timestamp NOT NULL,
  `approvazione` enum('approvata','rifiutata','in attesa') NOT NULL DEFAULT 'in attesa',
  PRIMARY KEY (`ID_pubblicazione`,`ID_utente`),
  UNIQUE KEY `una_recensione` (`ID_utente`,`ID_pubblicazione`),
  CONSTRAINT `recensione_ibfk_1` FOREIGN KEY (`ID_utente`) REFERENCES `utente` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `recensione_ibfk_2` FOREIGN KEY (`ID_pubblicazione`) REFERENCES `pubblicazione` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recensione`
--

LOCK TABLES `recensione` WRITE;
/*!40000 ALTER TABLE `recensione` DISABLE KEYS */;
INSERT INTO `recensione` VALUES (6,1,'ottimo libro','2019-07-18 19:30:43','approvata'),(5,2,'è molto bello anche se in certe parti pensavo di buttarlo via dalla finestra','2019-07-18 19:35:52','in attesa'),(12,3,'un libro profondo che trasmette molta passione','2019-07-18 19:40:44','approvata'),(5,4,'ricorda la mia vita xD','2019-07-18 19:33:35','approvata'),(12,4,'pensavo fosse meglio','2019-07-18 19:41:56','approvata'),(1,6,'Molto appassionante, consigliato!','2019-07-18 21:07:17','approvata'),(6,6,'bello come la fame','2019-07-19 11:19:21','approvata'),(11,15,'Il mio supereroe preferito!','2019-07-18 21:06:10','approvata');
/*!40000 ALTER TABLE `recensione` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`dbunivaq2019`@`%`*/ /*!50003 TRIGGER `recensione_nello_storico` AFTER UPDATE ON `recensione` FOR EACH ROW BEGIN
IF (NEW.approvazione = 'approvata') THEN 
INSERT INTO storico VALUES(OLD.ID_utente, OLD.ID_pubblicazione,'recensione',NOW());
END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `recensioni`
--

DROP TABLE IF EXISTS `recensioni`;
/*!50001 DROP VIEW IF EXISTS `recensioni`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `recensioni` AS SELECT 
 1 AS `ID_utente`,
 1 AS `ID_pubblicazione`,
 1 AS `contenuto`,
 1 AS `data`,
 1 AS `approvazione`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `ristampa`
--

DROP TABLE IF EXISTS `ristampa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ristampa` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_pubblicazione` int(10) unsigned NOT NULL,
  `data_ristampa` date NOT NULL,
  `numero` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ristampa_giorno` (`ID_pubblicazione`,`data_ristampa`),
  CONSTRAINT `ristampa_ibfk_1` FOREIGN KEY (`ID_pubblicazione`) REFERENCES `pubblicazione` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ristampa`
--

LOCK TABLES `ristampa` WRITE;
/*!40000 ALTER TABLE `ristampa` DISABLE KEYS */;
INSERT INTO `ristampa` VALUES (1,2,'2004-10-21',300),(2,1,'2010-03-24',500),(4,8,'2008-07-05',320),(5,3,'2011-05-24',280),(6,4,'2007-03-21',100),(7,6,'2015-01-14',90),(8,7,'2019-02-24',1000),(9,8,'2017-02-10',400),(10,15,'2001-11-24',600),(11,16,'2002-12-19',700),(12,15,'2010-10-24',400);
/*!40000 ALTER TABLE `ristampa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scrittura`
--

DROP TABLE IF EXISTS `scrittura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `scrittura` (
  `ID_pubblicazione` int(10) unsigned NOT NULL,
  `ID_autore` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID_pubblicazione`,`ID_autore`),
  KEY `ID_autore` (`ID_autore`),
  CONSTRAINT `scrittura_ibfk_1` FOREIGN KEY (`ID_pubblicazione`) REFERENCES `pubblicazione` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `scrittura_ibfk_2` FOREIGN KEY (`ID_autore`) REFERENCES `autore` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scrittura`
--

LOCK TABLES `scrittura` WRITE;
/*!40000 ALTER TABLE `scrittura` DISABLE KEYS */;
INSERT INTO `scrittura` VALUES (1,1),(2,2),(3,3),(4,4),(6,4),(8,5),(7,6),(15,7),(16,8);
/*!40000 ALTER TABLE `scrittura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sorgente`
--

DROP TABLE IF EXISTS `sorgente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sorgente` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ID_pubblicazione` int(10) unsigned DEFAULT NULL,
  `URI` varchar(100) NOT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `formato` varchar(20) DEFAULT NULL,
  `descrizione` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_pubblicazione` (`ID_pubblicazione`),
  CONSTRAINT `sorgente_ibfk_1` FOREIGN KEY (`ID_pubblicazione`) REFERENCES `pubblicazione` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sorgente`
--

LOCK TABLES `sorgente` WRITE;
/*!40000 ALTER TABLE `sorgente` DISABLE KEYS */;
INSERT INTO `sorgente` VALUES (1,2,'http://amazon.it/guerraepace.jpg','immagine','jpg','copertina'),(2,6,'http://amazon.it/codicedavinci.jpg','immagine','jpg','copertina'),(3,15,'http://amazon.it/spiderman.jpg','immagine','jpg','copertina'),(4,3,'http://amazon.it/winniepooh.jpg','immagine','jpg','copertina'),(6,6,'http://bookdownload.net/codicedavinci','download','ebook','libro elettronico'),(7,15,'http://bookdownload.net/spiderman','download','ebook','libro elettronico'),(8,3,'http://bookdownload.net/winniepooh','download','ebook','libro elettronico'),(9,1,'http://bookdownload.net/tempodellemele','download','ebook','libro elettronico'),(10,4,'http://bookdownload.net/inferno','download','ebook','libro elettronico'),(11,15,'http://marvelcomics.com/poster','immagine','png','poster');
/*!40000 ALTER TABLE `sorgente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storico`
--

DROP TABLE IF EXISTS `storico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `storico` (
  `ID_utente` int(10) unsigned NOT NULL,
  `ID_pubblicazione` int(10) unsigned NOT NULL,
  `descrizione` enum('inserimento','modifica','recensione','like') NOT NULL,
  `data` timestamp NOT NULL,
  PRIMARY KEY (`ID_utente`,`ID_pubblicazione`,`data`),
  KEY `ID_pubblicazione` (`ID_pubblicazione`),
  CONSTRAINT `storico_ibfk_1` FOREIGN KEY (`ID_utente`) REFERENCES `utente` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `storico_ibfk_2` FOREIGN KEY (`ID_pubblicazione`) REFERENCES `pubblicazione` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storico`
--

LOCK TABLES `storico` WRITE;
/*!40000 ALTER TABLE `storico` DISABLE KEYS */;
INSERT INTO `storico` VALUES (6,16,'inserimento','2019-07-19 11:27:36'),(6,16,'modifica','2019-07-19 11:30:53'),(12,3,'recensione','2019-07-19 12:01:21');
/*!40000 ALTER TABLE `storico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utente` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `passwd` varchar(50) NOT NULL,
  `nome` varchar(20) DEFAULT NULL,
  `cognome` varchar(20) DEFAULT NULL,
  `sesso` enum('M','F','indefinito') DEFAULT 'indefinito',
  `data_nascita` date NOT NULL,
  `luogo_nascita` varchar(20) DEFAULT NULL,
  `tipo` enum('passivo','attivo') NOT NULL,
  `livello` enum('base','moderatore') NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'bryantsarabia@gmail.com','bryantsarabia123','Bryant','Sarabia','M','1998-01-14','Venezuela','passivo','moderatore'),(2,'dawidpado@gmail.com','dawpad97','Dawid','Pado','M','1997-05-07','Stalowa Wola','attivo','moderatore'),(4,'fulviolapenna@gmail.com','fulvpen96','Fulvio','La Penna','M','1996-03-21','Chieti','attivo','base'),(5,'franscescasant@gmail.com','fransant97','Francesca','Santoferrera','F','1997-11-05','Bucchianico','attivo','base'),(6,'alessandrolodi@gmail.com','alelodi97','Alessandro','Lodi','M','1997-01-03','Pescara','attivo','base'),(11,'xbit18@hotmail.it','123stella','Giacomo','Sfratato','M','1997-09-20','Ascoli Piceno','passivo','moderatore'),(12,'lucalanci@hotmail.it','password1234','Luca','Lanci','M','1998-03-18','Pescara','passivo','base'),(13,'danieledidesiderio@gmail.com','danieledd','Daniele','Di Desiderio','M','1998-10-17','Chieti','passivo','base'),(14,'giorgio.innamorati@hotmail.it','forumlibri','Giorgio','Innamorati','M','1998-04-20','Roma','passivo','base'),(17,'daniele.fossemo@live.it','danifoss','Daniele','Fossemò','M','1998-03-29','Pescara','passivo','base'),(18,'marco.autili@gmail.com','marco2019','Marco','Autili','M','1975-08-23','Roma','passivo','base');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`dbunivaq2019`@`%`*/ /*!50003 TRIGGER `data_nascita_tr` BEFORE INSERT ON `utente` FOR EACH ROW BEGIN
  IF ( NEW.data_nascita > CURDATE() ) THEN SIGNAL SQLSTATE '45000' 
   SET MESSAGE_TEXT = 'Errore: La data di nascita dell\'utente è maggiore della data corrente';
   END IF;
   END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping routines for database 'dbunivaq2019'
--
/*!50003 DROP FUNCTION IF EXISTS `check_isbn` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` FUNCTION `check_isbn`(isbn VARCHAR(13)) RETURNS tinyint(1)
    NO SQL
BEGIN
IF (LENGTH(isbn)<> 13 OR isbn REGEXP('^[0-9]+$')=0) THEN
RETURN 0;
ELSE
RETURN 1;
END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `check_lettere` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` FUNCTION `check_lettere`(parola VARCHAR(20)) RETURNS int(11)
BEGIN
RETURN (parola REGEXP ('^[A-z]+$'));
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `check_nrpagine` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` FUNCTION `check_nrpagine`(nrpagine INTEGER) RETURNS int(11)
    NO SQL
BEGIN
IF(nrpagine <= 0) THEN
 RETURN 0;
END IF;
RETURN 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `check_password` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` FUNCTION `check_password`(passw VARCHAR(20)) RETURNS tinyint(1)
    NO SQL
BEGIN
IF(char_length(passw) < 8) THEN
 RETURN 0;
END IF;
RETURN 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `catalogo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `catalogo`()
BEGIN
SELECT 
pubblicazione.ID, pubblicazione.titolo AS Titolo, 
(CONCAT (autore.nome, " ",  autore.cognome)) AS Autore, 
pubblicazione.editore AS Editore,  
YEAR(metadati.data_pubblicazione) AS 'Anno di pubblicazione' 
FROM pubblicazione, scrittura, autore, metadati
WHERE pubblicazione.ID = scrittura.ID_pubblicazione 
AND scrittura.ID_autore = autore.ID
AND pubblicazione.ID = metadati.ID_pubblicazione
ORDER BY Titolo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `catalogo_ristampa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `catalogo_ristampa`()
BEGIN
SELECT pubblicazione.ID AS 'ID Pubblicazione', pubblicazione.titolo, pubblicazione.descrizione, pubblicazione.editore, ristampa.data_ristampa
FROM pubblicazione, ristampa
WHERE pubblicazione.ID = ristampa.ID_pubblicazione;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `catalogo_stessi_autori` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `catalogo_stessi_autori`(var int unsigned)
BEGIN
SET @pub = ( SELECT id FROM pubblicazione where pubblicazione.id = var);
IF ( @pub IS NULL)THEN SIGNAL SQLSTATE '45000'										 
SET MESSAGE_TEXT = 'Errore: La pubblicazione non esiste';
END IF;
select scrittura.ID_pubblicazione as ID, pubblicazione.titolo, pubblicazione.descrizione, pubblicazione.editore from 
scrittura, pubblicazione 
where scrittura.ID_autore = ( select ID_autore from scrittura where ID_pubblicazione = var ) AND scrittura.ID_pubblicazione = pubblicazione.ID;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `cerca_pubblicazione` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `cerca_pubblicazione`(titolo_par VARCHAR(50),nome_autore_par VARCHAR(20), cognome_autore_par VARCHAR(20), isbn_par VARCHAR(13), parolachiave_par VARCHAR(20))
BEGIN
DECLARE var INTEGER;
SET var = 0;

CREATE TABLE info_pubbl AS 
SELECT pubblicazione.ID AS IDpubblicazione, pubblicazione.titolo AS Titolo, 
autore.nome,  autore.cognome, 
metadati.isbn   
FROM pubblicazione, scrittura, autore, metadati
WHERE pubblicazione.ID = scrittura.ID_pubblicazione 
AND scrittura.ID_autore = autore.ID
AND pubblicazione.ID = metadati.ID_pubblicazione;

CREATE TABLE final AS 
SELECT IDpubblicazione AS 'ID Pubblicazione' , Titolo, nome AS Nome, cognome AS Cognome, isbn AS ISBN, parola FROM 
(SELECT * FROM ( info_pubbl LEFT JOIN cerca ON cerca.ID_pubblicazione = info_pubbl.IDpubblicazione)) AS temp LEFT JOIN parola_chiave 
ON temp.ID_parolachiave = parola_chiave.ID;
DROP TABLE info_pubbl;

IF((titolo_par IS NULL) OR (titolo_par = '')) THEN
SET var = var+1;
ELSE DELETE FROM final WHERE Titolo<>titolo_par; 
END IF;

IF((nome_autore_par IS NULL) OR (nome_autore_par = '')) THEN
SET var = var+1;
ELSE
DELETE FROM final WHERE Nome<>nome_autore_par;
END IF;

IF((cognome_autore_par IS NULL) OR (cognome_autore_par = '')) THEN
SET var = var+1;
ELSE 
DELETE FROM final WHERE Cognome<>cognome_autore_par;
END IF;

IF((isbn_par IS NULL) OR (isbn_par = '')) THEN
SET var = var+1;
ELSE 
DELETE FROM final WHERE ISBN<>isbn_par;
END IF;

IF((parolachiave_par IS NULL) OR (parolachiave_par = '')) THEN
SET var = var+1;
ELSE
DELETE FROM final WHERE parola<>parolachiave_par OR parola IS NULL;
END IF;

IF (var<5) THEN
	IF (SELECT COUNT(*) FROM (SELECT `ID Pubblicazione`,Titolo, CONCAT(Nome," ",Cognome) AS Autore, ISBN FROM final) AS finale)=0 THEN
		DROP TABLE final;
        SIGNAL SQLSTATE '45000'										 
		SET MESSAGE_TEXT = 'La ricerca non ha dato risultati';
        ELSE
			SELECT `ID Pubblicazione`,Titolo, CONCAT(Nome," ",Cognome) AS Autore, ISBN FROM final;
            DROP TABLE final;
        END IF;
ELSE 
DROP TABLE final;
SIGNAL SQLSTATE '45000'										 
SET MESSAGE_TEXT = 'Errore: Specificare almeno un parametro';
END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `elenco_download` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `elenco_download`()
BEGIN
SELECT pubblicazione.titolo, pubblicazione.descrizione, pubblicazione.editore, sorgente.URI
FROM pubblicazione, sorgente
WHERE pubblicazione.ID=sorgente.ID_pubblicazione AND sorgente.tipo = 'download';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `elenco_recensioni` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `elenco_recensioni`(ID_pubblicazione INT UNSIGNED)
BEGIN
SELECT * FROM recensione WHERE ID_pubblicazione = recensione.ID_pubblicazione AND approvazione = 'approvata';

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `elenco_recensioni_attesa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `elenco_recensioni_attesa`()
BEGIN
SELECT * FROM recensione WHERE approvazione = 'in attesa';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `estrazione_dati` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `estrazione_dati`(var INT UNSIGNED)
BEGIN
SET @pub = ( SELECT id FROM pubblicazione where pubblicazione.id = var);
IF ( @pub IS NULL)THEN SIGNAL SQLSTATE '45000'										 
SET MESSAGE_TEXT = 'Errore: La pubblicazione non esiste';
END IF;
SELECT pubblicazione.ID, pubblicazione.titolo AS Titolo, pubblicazione.descrizione AS Descrizione, pubblicazione.editore AS Editore,
metadati.isbn AS ISBN, metadati.nrpagine AS 'N° pagine', metadati.lingua AS Lingua, metadati.data_pubblicazione AS 'Data di pubblicazione', utente.email AS 'Pubblicata da'
FROM pubblicazione, metadati, storico, utente
WHERE (pubblicazione.ID = var) AND (metadati.ID_pubblicazione = var) AND (storico.ID_pubblicazione = var) AND (storico.descrizione = 'inserimento') AND (utente.ID = storico.ID_utente);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `estrazione_modifiche_pubblicazione` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `estrazione_modifiche_pubblicazione`(ID_pubblicazione INT UNSIGNED)
BEGIN
SELECT * FROM storico WHERE storico.ID_pubblicazione = ID_pubblicazione AND descrizione = 'modifica';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserimento_like` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `inserimento_like`(email VARCHAR(50),passwd VARCHAR(50), ID_pubblicazione INT UNSIGNED)
BEGIN
DECLARE var INT UNSIGNED;
SET @id_utente_scelto = (SELECT ID FROM utente WHERE utente.email = email);                      --
SET @id_pubblicazione_scelta = (SELECT ID FROM pubblicazione WHERE pubblicazione.ID = ID_pubblicazione); 																					 --

IF(@id_utente_scelto IS NULL) THEN SIGNAL SQLSTATE '45000'										 --
SET MESSAGE_TEXT = 'Errore: L\'utente specificato non esiste';									 --
END IF;

IF(@id_pubblicazione_scelta IS NULL) THEN SIGNAL SQLSTATE '45000'										 --
SET MESSAGE_TEXT = 'Errore: La pubblicazione specificata non esiste';									 --
END IF;


IF ((SELECT passwd FROM utente WHERE utente.email = email) <> passwd) THEN SIGNAL SQLSTATE '45000'					 
SET MESSAGE_TEXT = 'Errore: La password inserita non è giusta';
END IF;
SELECT ID FROM utente WHERE utente.email = email INTO var;
INSERT INTO likes (ID_utente, ID_pubblicazione, data) VALUES (var,ID_pubblicazione,NOW());
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserimento_parola_chiave` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `inserimento_parola_chiave`(ID_pubblicazione_par INTEGER, parolachiave_par VARCHAR(20))
BEGIN

SET @pub = ( SELECT ID FROM pubblicazione where pubblicazione.id = ID_pubblicazione_par);
IF ( @pub IS NULL)THEN SIGNAL SQLSTATE '45000'										 
SET MESSAGE_TEXT = 'Errore: La pubblicazione non esiste';
END IF;

SET  @id_parola_inserita = (SELECT ID FROM parola_chiave WHERE parola_chiave.parola = parolachiave_par);
IF(@id_parola_inserita IS NULL) THEN
		INSERT INTO parola_chiave (parola) VALUES (parolachiave_par);
        SET @id_nuova_parola = (SELECT last_insert_id());
        INSERT INTO cerca (ID_pubblicazione, ID_parolachiave) VALUES (ID_pubblicazione_par, @id_nuova_parola);
ELSE
	INSERT INTO cerca (ID_pubblicazione, ID_parolachiave) VALUES (ID_pubblicazione_par, @id_parola_inserita);
END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserimento_pubblicazione` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `inserimento_pubblicazione`(email varchar(50), titolo varchar(50), descrizione varchar(200), editore varchar(20), isbn varchar(13), nrpagine integer, lingua varchar(20), data_pubblicazione date, nome_autore VARCHAR(20), cognome_autore VARCHAR(20))
BEGIN
DECLARE all_ok BOOLEAN;
SET all_ok = true;

START TRANSACTION;

-- controlla che l'utente specificato esista nel database e se non esiste dà un messaggio di errore
SET @id_utente_scelto = (SELECT ID FROM utente WHERE utente.email = email);                      --
																								 --
IF(@id_utente_scelto IS NULL) THEN SIGNAL SQLSTATE '45000'										 --
SET MESSAGE_TEXT = 'Errore: L\'utente specificato non esiste';
SET all_ok = false;									 --
END IF;

IF((SELECT utente.tipo FROM utente WHERE ID = @id_utente_scelto ) = 'passivo') THEN
call setTipoUtente(email, 'attivo');
END IF;

-- Lista di check: controlla che i valori inseriti siano giusti
IF(check_isbn(isbn) = 0) THEN SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'Errore: l\'ISBN deve essere lungo 13 caratteri e deve contenere solo numeri';
SET all_ok = false;
END IF;

IF(check_nrpagine(nrpagine) = 0) THEN SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'Errore: una pubblicazione deve contenere almeno una pagina';
SET all_ok = false;
END IF;

IF(check_lettere(lingua) = 0) THEN SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'Errore: \'lingua\' non può contenere lettere o caratteri speciali';
SET all_ok = false;
END IF;

IF(check_lettere(nome_autore) = 0) THEN SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'Errore: \'nome_autore\' non può contenere lettere o caratteri speciali';
SET all_ok = false;
END IF;

IF(check_lettere(cognome_autore) = 0) THEN SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'Errore: \'cognome_autore\' non può contenere lettere o caratteri speciali';
END IF;

-- ---------------------------------------------------------------------------------------------------------------------------------------

-- inserisci pubblicazione
INSERT INTO pubblicazione (`titolo`, `descrizione`, `editore`) VALUES (titolo, descrizione, editore);

SET @id_nuova_pubblicazione = (SELECT LAST_INSERT_ID());

-- inserisci metadati relativi a pubblicazione
INSERT INTO metadati (`ID_pubblicazione`, `isbn`, `nrpagine`, `lingua`, `data_pubblicazione`) VALUES (@id_nuova_pubblicazione, isbn, nrpagine, lingua, data_pubblicazione);

-- aggiungi inserimento a storico
SET @id_utente = (SELECT ID FROM utente WHERE (utente.email = email));
INSERT INTO storico (`ID_utente`,`ID_pubblicazione`,`descrizione`,`data`) VALUES (@id_utente, @id_nuova_pubblicazione, "inserimento", NOW()); 

-- inserisci autore relativo a pubblicazione
SET  @id_autore_inserito = (SELECT ID FROM autore WHERE autore.nome = nome_autore AND autore.cognome = cognome_autore);

-- se l'autore specificato non esiste, aggiunge l'autore e poi aggiunge la relativa riga a "scrittura" altrimenti aggiunge la relativa riga a "scrittura"
IF(@id_autore_inserito IS NULL) THEN
		INSERT INTO autore (nome, cognome) VALUES (nome_autore, cognome_autore);
        SET @id_nuovo_autore = (SELECT last_insert_id());
        INSERT INTO scrittura (ID_pubblicazione, ID_autore) VALUES (@id_nuova_pubblicazione, @id_nuovo_autore);
ELSE
	INSERT INTO scrittura (ID_pubblicazione, ID_autore) VALUES (@id_nuova_pubblicazione, @id_autore_inserito);
END IF;

IF NOT all_ok THEN
ROLLBACK;
ELSE COMMIT;
END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserimento_recensione` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `inserimento_recensione`(email VARCHAR(50),passwd VARCHAR(50), descrizione VARCHAR(200), id_pubblicazione INT UNSIGNED)
BEGIN
IF ((SELECT utente.passwd FROM utente WHERE utente.email = email) <> passwd) THEN SIGNAL SQLSTATE '45000'					 
SET MESSAGE_TEXT = 'Errore: La password inserita non è giusta';
END IF;
SET @user_id = (SELECT ID FROM utente WHERE utente.email = email);
INSERT INTO recensione (ID_utente, ID_pubblicazione, contenuto, data) VALUES (@user_id, id_pubblicazione, descrizione, NOW());
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserimento_ristampa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `inserimento_ristampa`(ID_pubblicazione_par INTEGER, data_r DATE, num INTEGER)
BEGIN
SET @id_pubblicazione_scelta = (SELECT ID FROM pubblicazione WHERE pubblicazione.ID = ID_pubblicazione_par); 			
IF(@id_pubblicazione_scelta IS NULL) THEN SIGNAL SQLSTATE '45000'										 --
SET MESSAGE_TEXT = 'Errore: La pubblicazione specificata non esiste';									 --
END IF;

INSERT INTO ristampa (ID_pubblicazione, data_ristampa, numero) VALUES (ID_pubblicazione_par, data_r, num);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserimento_sorgente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `inserimento_sorgente`(ID_pubblicazione_par INT UNSIGNED, uri_par VARCHAR(100), tip VARCHAR(20), forma VARCHAR(20), descr VARCHAR (50))
BEGIN
SET @id_pubblicazione_scelta = (SELECT ID FROM pubblicazione WHERE pubblicazione.ID = ID_pubblicazione_par); 			
IF(@id_pubblicazione_scelta IS NULL) THEN SIGNAL SQLSTATE '45000'										 --
SET MESSAGE_TEXT = 'Errore: La pubblicazione specificata non esiste';									 --
END IF;

INSERT INTO sorgente(ID_pubblicazione, URI, tipo, formato, descrizione)
VALUES (ID_pubblicazione_par, uri_par, tip, forma, descr);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserimento_utente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `inserimento_utente`(email_par VARCHAR(50), passwd_par VARCHAR(50), n VARCHAR(20), c VARCHAR(20), s ENUM('M','F','indefinito'), d_n DATE, l_n VARCHAR(20),lv ENUM('base','moderatore'))
BEGIN

SET @id_utente_scelto = (SELECT ID FROM utente WHERE utente.email = email_par);                      --
																								 --
IF(@id_utente_scelto IS NOT NULL) THEN SIGNAL SQLSTATE '45000'										 --
SET MESSAGE_TEXT = 'Errore: L\'email specificata esiste già';								 --
END IF;

INSERT INTO utente(email, passwd, nome, cognome, sesso, data_nascita, luogo_nascita, livello) VALUES (email_par, passwd_par, n ,c, s, d_n, l_n, lv);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `likes_totali` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `likes_totali`(id INT(10))
BEGIN
SET @pub = ( SELECT id FROM pubblicazione where pubblicazione.id = id);
IF ( @pub IS NULL)THEN SIGNAL SQLSTATE '45000'										 
SET MESSAGE_TEXT = 'Errore: La pubblicazione non esiste';
END IF;
SELECT ID_pubblicazione AS 'ID Pubblicazione', 
pubblicazione.titolo AS Titolo,
(count(*)) AS `Like Totali` 

	FROM 
    (SELECT * FROM storico WHERE descrizione = 'like' AND ID_pubblicazione = id) AS storico_like, 
    pubblicazione 
    
    WHERE 
    storico_like.ID_pubblicazione = pubblicazione.ID ; 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modifica_tipo_utente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `modifica_tipo_utente`(email VARCHAR(50), tipo VARCHAR(10))
BEGIN
DECLARE id_utente_scelto INT UNSIGNED;
-- controlla che l'utente specificato esista nel database e se non esiste dà un messaggio di errore
SET id_utente_scelto = (SELECT ID FROM utente WHERE utente.email = email);                      --
																								 --
IF(id_utente_scelto IS NULL) THEN SIGNAL SQLSTATE '45000'										 --
SET MESSAGE_TEXT = 'Errore: L\'utente specificato non esiste';									 --
END IF;																							 --
-- ------------------------------------------------------------------------------------------------
IF ((tipo <> "attivo") or (tipo <> "passivo")) THEN SIGNAL SQLSTATE '45000'										 --
SET MESSAGE_TEXT = 'Errore: il campo \'Modifica\' può contenere solo \'attivo\' o \'passivo\', riprovare';									 --
END IF;
UPDATE utente SET utente.tipo=tipo WHERE utente.email=email;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pubblicazioni_utente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `pubblicazioni_utente`(email VARCHAR(50))
BEGIN

-- controlla che l'utente specificato esista nel database e se non esiste dà un messaggio di errore
SET @id_utente_scelto = (SELECT ID FROM utente WHERE utente.email = email);                      --
																								 --
IF(@id_utente_scelto IS NULL) THEN SIGNAL SQLSTATE '45000'										 --
SET MESSAGE_TEXT = 'Errore: L\'utente specificato non esiste';									 --
END IF;																							 --
-- ------------------------------------------------------------------------------------------------
CREATE VIEW inserimenti AS
SELECT ID_utente, ID, titolo FROM storico JOIN pubblicazione ON storico.ID_pubblicazione = pubblicazione.ID WHERE storico.descrizione = "inserimento";

SELECT ID, titolo AS Titolo FROM inserimenti WHERE ID_utente = @id_utente_scelto;

DROP VIEW inserimenti;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `rimuovere_like` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `rimuovere_like`(email VARCHAR(50),passwd VARCHAR(50), ID_pubblicazione INT UNSIGNED)
BEGIN
IF ((SELECT utente.passwd FROM utente WHERE utente.email = email) <> passwd) THEN SIGNAL SQLSTATE '45000'					 
SET MESSAGE_TEXT = 'Errore: La password inserita non è giusta';
END IF;
SET @var = (SELECT ID FROM utente WHERE utente.email = email);
DELETE FROM likes WHERE likes.ID_utente = @var AND likes.ID_pubblicazione = ID_pubblicazione;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `rimuovere_pubblicazione` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `rimuovere_pubblicazione`(email VARCHAR(50), passwd VARCHAR(50), id INT UNSIGNED)
BEGIN
IF ((SELECT utente.passwd FROM utente WHERE utente.email = email) <> passwd) THEN SIGNAL SQLSTATE '45000'					 
SET MESSAGE_TEXT = 'Errore: La password è sbagliata';
	ELSEIF ((SELECT livello FROM utente WHERE utente.email = email) = 'base') THEN SIGNAL SQLSTATE '45000'						 
	SET MESSAGE_TEXT = 'Errore: Non hai privilegi necessari per questa operazione';
END IF;
DELETE FROM pubblicazione WHERE pubblicazione.ID = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `rimuovere_recensione` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `rimuovere_recensione`(ID_utente INTEGER, ID_pubblicazione INTEGER)
BEGIN
DELETE FROM recensione WHERE (recensione.ID_utente = ID_utente AND recensione.ID_pubblicazione = ID_pubblicazione);
DELETE FROM storico WHERE descrizione = "recensione" AND storico.ID_utente = ID_utente AND storico.ID_pubblicazione = ID_pubblicazione;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `rimuovere_sorgente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `rimuovere_sorgente`(ID_pubblicazione_par INT UNSIGNED, uri varchar(100))
BEGIN

SET @id_pubblicazione_scelta = (SELECT ID FROM pubblicazione WHERE pubblicazione.ID = ID_pubblicazione_par); 			
IF(@id_pubblicazione_scelta IS NULL) THEN SIGNAL SQLSTATE '45000'										 --
SET MESSAGE_TEXT = 'Errore: La pubblicazione specificata non esiste';									 --
END IF;

DELETE FROM sorgente WHERE sorgente.ID_pubblicazione = ID_pubblicazione_par AND sorgente.URI = uri;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `rimuovere_utente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `rimuovere_utente`(email VARCHAR(50),passwd VARCHAR(50))
BEGIN
IF ((SELECT utente.passwd FROM utente WHERE utente.email = email) <> passwd) THEN SIGNAL SQLSTATE '45000'					 
SET MESSAGE_TEXT = 'Errore: La password inserita non è giusta';
END IF;
DELETE FROM utente WHERE utente.email = email;
SELECT ('Utente eliminato') as '';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ultime_pubblicazioni` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `ultime_pubblicazioni`()
BEGIN
-- Estrazione elenco delle ultime dieci pubblicazioni inserite.

-- ricavo dallo storico le ultime 10 pubblicazioni inserite ordinandole dalla più alla meno recente
CREATE VIEW selezione_storico AS SELECT ID_pubblicazione,data FROM storico WHERE descrizione = "inserimento" ORDER BY data DESC LIMIT 10; 

-- ricavo dal join fra pubblicazione e metadati l'isbn, il titolo e l'ID delle pubblicazioni
CREATE VIEW info_pubblicazioni AS SELECT ID,titolo,isbn FROM pubblicazione JOIN metadati ON ID = ID_pubblicazione; 

-- ricavo dal join fra le due view la tabella finale (id, titolo, isbn e data)
SELECT ID AS 'ID Pubblicazione' ,titolo AS Titolo, isbn AS ISBN, data AS 'Data di inserimento' FROM selezione_storico JOIN (info_pubblicazioni) ON selezione_storico.ID_pubblicazione = info_pubblicazioni.ID;

-- elimino le view temporanee
DROP VIEW selezione_storico, info_pubblicazioni;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_recente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `update_recente`()
BEGIN
CREATE VIEW id_pubblicazioni_recenti AS 
SELECT DISTINCT 
	ID_pubblicazione 
FROM 
	storico 
WHERE (data >= DATE_SUB(now(), INTERVAL 30 DAY) AND (descrizione = "inserimento" or descrizione = "modifica"));

SELECT ID, titolo FROM pubblicazione JOIN id_pubblicazioni_recenti ON pubblicazione.ID = id_pubblicazioni_recenti.ID_pubblicazione ORDER BY titolo;
DROP VIEW id_pubblicazioni_recenti;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `utenti_attivi` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `utenti_attivi`()
BEGIN
CREATE VIEW id_utenti AS 
SELECT * FROM storico WHERE descrizione = "inserimento";

CREATE VIEW utenti_collab AS SELECT ID_utente, (count(*)) AS `libri inseriti` FROM (id_utenti)
GROUP BY ID_utente
ORDER BY count(*) DESC;

SELECT * FROM utenti_collab;
SELECT email, `libri inseriti` FROM utenti_collab JOIN utente ON utenti_collab.ID_utente = utente.ID LIMIT 10;

DROP VIEW utenti_collab;
DROP VIEW id_utenti;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `verifica_recensione` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`dbunivaq2019`@`%` PROCEDURE `verifica_recensione`(email VARCHAR(50),passwd VARCHAR(50), id_utente INT UNSIGNED,id_pubblicazione INT UNSIGNED,  giudizio ENUM('approvata','rifiutata'))
BEGIN

IF ((SELECT passwd FROM utente WHERE utente.email = email) <> passwd) THEN SIGNAL SQLSTATE '45000'					 
SET MESSAGE_TEXT = 'Errore: La password è sbagliata giusta';
	ELSEIF ((SELECT livello FROM utente WHERE utente.email = email) = 'base') THEN SIGNAL SQLSTATE '45000'						 
	SET MESSAGE_TEXT = 'Errore: Non hai privilegi necessari per questa operazione';
END IF;

UPDATE recensione SET recensione.approvazione = giudizio WHERE (recensione.ID_pubblicazione = id_pubblicazione) AND (recensione.ID_utente = id_utente);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `recensioni`
--

/*!50001 DROP VIEW IF EXISTS `recensioni`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`dbunivaq2019`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `recensioni` AS select `recensione`.`ID_utente` AS `ID_utente`,`recensione`.`ID_pubblicazione` AS `ID_pubblicazione`,`recensione`.`contenuto` AS `contenuto`,`recensione`.`data` AS `data`,`recensione`.`approvazione` AS `approvazione` from `recensione` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-19 15:47:35
