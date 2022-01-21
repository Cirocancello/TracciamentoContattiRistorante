-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              10.6.5-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win64
-- HeidiSQL Versione:            11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database stcr
CREATE DATABASE IF NOT EXISTS `stcr` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `stcr`;

-- Dump della struttura di tabella stcr.camerieri
CREATE TABLE IF NOT EXISTS `camerieri` (
  `Codice` int(11) NOT NULL AUTO_INCREMENT,
  `Cognome` varchar(50) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  PRIMARY KEY (`Codice`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella stcr.clienti
CREATE TABLE IF NOT EXISTS `clienti` (
  `Codice` int(11) NOT NULL AUTO_INCREMENT,
  `CodiceTavolo` int(11) NOT NULL,
  `Cognome` varchar(50) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `NumeroCartaIdentita` varchar(10) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `Data` date NOT NULL,
  PRIMARY KEY (`Codice`),
  KEY `FK_Clienti_Tavoli` (`CodiceTavolo`),
  KEY `NumeroCartaIdentita_Data` (`NumeroCartaIdentita`,`Data`),
  CONSTRAINT `FK_Clienti_Tavoli` FOREIGN KEY (`CodiceTavolo`) REFERENCES `tavoli` (`Codice`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella stcr.prenotazioni
CREATE TABLE IF NOT EXISTS `prenotazioni` (
  `Codice` int(11) NOT NULL AUTO_INCREMENT,
  `CodiceTavolo` int(11) NOT NULL,
  `Cognome` varchar(50) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `NumeroPersone` int(11) NOT NULL,
  `Data` date NOT NULL,
  `Note` text DEFAULT NULL,
  PRIMARY KEY (`Codice`),
  KEY `FK_Prenotazioni_Tavoli` (`CodiceTavolo`),
  CONSTRAINT `FK_Prenotazioni_Tavoli` FOREIGN KEY (`CodiceTavolo`) REFERENCES `tavoli` (`Codice`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella stcr.ristoranti
CREATE TABLE IF NOT EXISTS `ristoranti` (
  `Codice` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(50) NOT NULL,
  `Indirizzo` varchar(100) NOT NULL,
  `Citta` varchar(50) NOT NULL,
  `Provincia` varchar(2) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  PRIMARY KEY (`Codice`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella stcr.sale
CREATE TABLE IF NOT EXISTS `sale` (
  `Codice` int(11) NOT NULL AUTO_INCREMENT,
  `CodiceRistorante` int(11) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  PRIMARY KEY (`Codice`),
  UNIQUE KEY `CodiceRistorante_Nome` (`CodiceRistorante`,`Nome`),
  CONSTRAINT `FK_Sale_Ristoranti` FOREIGN KEY (`CodiceRistorante`) REFERENCES `ristoranti` (`Codice`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella stcr.salecamerieri
CREATE TABLE IF NOT EXISTS `salecamerieri` (
  `CodiceSala` int(11) NOT NULL,
  `CodiceCameriere` int(11) NOT NULL,
  `Data` date NOT NULL,
  PRIMARY KEY (`CodiceSala`,`CodiceCameriere`,`Data`),
  KEY `FK_SaleCamerieri_Camerieri` (`CodiceCameriere`),
  CONSTRAINT `FK_SaleCamerieri_Camerieri` FOREIGN KEY (`CodiceCameriere`) REFERENCES `camerieri` (`Codice`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SaleCamerieri_Sale` FOREIGN KEY (`CodiceSala`) REFERENCES `sale` (`Codice`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella stcr.tavoli
CREATE TABLE IF NOT EXISTS `tavoli` (
  `Codice` int(11) NOT NULL AUTO_INCREMENT,
  `CodiceSala` int(11) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `CapacitaMassima` int(11) NOT NULL,
  PRIMARY KEY (`Codice`),
  UNIQUE KEY `CodiceSala_Nome` (`CodiceSala`,`Nome`),
  CONSTRAINT `FK_Tavoli_Sale` FOREIGN KEY (`CodiceSala`) REFERENCES `sale` (`Codice`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella stcr.tavoliadiacenti
CREATE TABLE IF NOT EXISTS `tavoliadiacenti` (
  `CodiceTavolo` int(11) NOT NULL,
  `CodiceTavoloAdiacente` int(11) NOT NULL,
  PRIMARY KEY (`CodiceTavolo`,`CodiceTavoloAdiacente`),
  KEY `FK_TavoliAdiacenti_Tavoli_2` (`CodiceTavoloAdiacente`),
  CONSTRAINT `FK_TavoliAdiacenti_Tavoli` FOREIGN KEY (`CodiceTavolo`) REFERENCES `tavoli` (`Codice`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_TavoliAdiacenti_Tavoli_2` FOREIGN KEY (`CodiceTavoloAdiacente`) REFERENCES `tavoli` (`Codice`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
