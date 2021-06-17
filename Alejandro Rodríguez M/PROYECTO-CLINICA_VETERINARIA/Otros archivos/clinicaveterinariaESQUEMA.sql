-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.60 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para clinicaveterinaria
CREATE DATABASE IF NOT EXISTS `clinicaveterinaria` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `clinicaveterinaria`;

-- Volcando estructura para tabla clinicaveterinaria.cita
CREATE TABLE IF NOT EXISTS `cita` (
  `idcita` int(11) NOT NULL AUTO_INCREMENT,
  `motivo` varchar(300) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `idcliente` int(11) DEFAULT NULL,
  `idmascota` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcita`),
  KEY `idcita` (`idcita`),
  KEY `FK_cita_cliente` (`idcliente`),
  KEY `FK_cita_mascota` (`idmascota`),
  CONSTRAINT `FK_cita_cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `FK_cita_mascota` FOREIGN KEY (`idmascota`) REFERENCES `mascota` (`idmascota`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla clinicaveterinaria.cita: ~0 rows (aproximadamente)
DELETE FROM `cita`;
/*!40000 ALTER TABLE `cita` DISABLE KEYS */;
/*!40000 ALTER TABLE `cita` ENABLE KEYS */;

-- Volcando estructura para tabla clinicaveterinaria.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(11) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `poblacion` varchar(50) DEFAULT NULL,
  `telefono` varchar(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `clave` varchar(50) DEFAULT NULL,
  `baja` date DEFAULT NULL,
  PRIMARY KEY (`idcliente`),
  KEY `idcliente` (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2001 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla clinicaveterinaria.cliente: ~0 rows (aproximadamente)
DELETE FROM `cliente`;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla clinicaveterinaria.historialclinico
CREATE TABLE IF NOT EXISTS `historialclinico` (
  `idhistorialclinico` int(11) NOT NULL AUTO_INCREMENT,
  `juicioclinico` varchar(500) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `pagado` varchar(2) DEFAULT NULL,
  `idmascota` int(11) DEFAULT NULL,
  `idveterinario` int(11) DEFAULT NULL,
  `idtratamiento` int(11) DEFAULT NULL,
  PRIMARY KEY (`idhistorialclinico`),
  KEY `idhistorialclinico` (`idhistorialclinico`),
  KEY `FK_historialclinico_tratamiento` (`idtratamiento`),
  KEY `FK_historialclinico_mascota` (`idmascota`),
  KEY `FK_historialclinico_veterinario` (`idveterinario`),
  CONSTRAINT `FK_historialclinico_mascota` FOREIGN KEY (`idmascota`) REFERENCES `mascota` (`idmascota`),
  CONSTRAINT `FK_historialclinico_tratamiento` FOREIGN KEY (`idtratamiento`) REFERENCES `tratamiento` (`idtratamiento`),
  CONSTRAINT `FK_historialclinico_veterinario` FOREIGN KEY (`idveterinario`) REFERENCES `veterinario` (`idveterinario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla clinicaveterinaria.historialclinico: ~0 rows (aproximadamente)
DELETE FROM `historialclinico`;
/*!40000 ALTER TABLE `historialclinico` DISABLE KEYS */;
/*!40000 ALTER TABLE `historialclinico` ENABLE KEYS */;

-- Volcando estructura para tabla clinicaveterinaria.mascota
CREATE TABLE IF NOT EXISTS `mascota` (
  `idmascota` int(11) NOT NULL AUTO_INCREMENT,
  `numerochip` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `anionacimiento` int(11) DEFAULT NULL,
  `especie` varchar(50) DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `idcliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idmascota`),
  KEY `idmascota` (`idmascota`),
  KEY `FK_mascota_cliente` (`idcliente`),
  CONSTRAINT `FK_mascota_cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2004 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla clinicaveterinaria.mascota: ~0 rows (aproximadamente)
DELETE FROM `mascota`;
/*!40000 ALTER TABLE `mascota` DISABLE KEYS */;
/*!40000 ALTER TABLE `mascota` ENABLE KEYS */;

-- Volcando estructura para tabla clinicaveterinaria.tratamiento
CREATE TABLE IF NOT EXISTS `tratamiento` (
  `idtratamiento` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(300) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`idtratamiento`),
  KEY `idtratamiento` (`idtratamiento`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla clinicaveterinaria.tratamiento: ~0 rows (aproximadamente)
DELETE FROM `tratamiento`;
/*!40000 ALTER TABLE `tratamiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tratamiento` ENABLE KEYS */;

-- Volcando estructura para tabla clinicaveterinaria.veterinario
CREATE TABLE IF NOT EXISTS `veterinario` (
  `idveterinario` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(10) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `fechanacimiento` date DEFAULT NULL,
  `especialidad` varchar(50) DEFAULT NULL,
  `clave` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idveterinario`),
  KEY `idveterinario` (`idveterinario`)
) ENGINE=InnoDB AUTO_INCREMENT=1501 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla clinicaveterinaria.veterinario: ~0 rows (aproximadamente)
DELETE FROM `veterinario`;
/*!40000 ALTER TABLE `veterinario` DISABLE KEYS */;
/*!40000 ALTER TABLE `veterinario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
