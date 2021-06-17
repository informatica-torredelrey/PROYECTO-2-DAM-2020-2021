-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.22 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para inventario_instituto
DROP DATABASE IF EXISTS `inventario_instituto`;
CREATE DATABASE IF NOT EXISTS `inventario_instituto` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `inventario_instituto`;

-- Volcando estructura para tabla inventario_instituto.historial
DROP TABLE IF EXISTS `historial`;
CREATE TABLE IF NOT EXISTS `historial` (
  `idhistorial` int NOT NULL AUTO_INCREMENT,
  `material` varchar(50) NOT NULL,
  `localizacion` varchar(50) NOT NULL,
  `fecha` varchar(100) NOT NULL DEFAULT '',
  `user` varchar(50) NOT NULL,
  PRIMARY KEY (`idhistorial`),
  KEY `idhistorial` (`idhistorial`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla inventario_instituto.historial: ~6 rows (aproximadamente)
DELETE FROM `historial`;
/*!40000 ALTER TABLE `historial` DISABLE KEYS */;
INSERT INTO `historial` (`idhistorial`, `material`, `localizacion`, `fecha`, `user`) VALUES
	(1, 'madera', 'DEPARTAMENTO', '1622484180316', 'root del sistema'),
	(2, 'mesa', 'DEPARTAMENTO', '1622484260947', 'root del sistema'),
	(3, 'sillon', 'AULA', '1622484432819', 'root del sistema'),
	(4, 'madera', 'AULA', '1622485133585', 'Zeke Kubasek'),
	(5, 'mesa', 'AULA', '1622485846664', 'root del sistema'),
	(6, 'madera', 'AULA', '1623065013617', 'root del sistema');
/*!40000 ALTER TABLE `historial` ENABLE KEYS */;

-- Volcando estructura para tabla inventario_instituto.localizacion
DROP TABLE IF EXISTS `localizacion`;
CREATE TABLE IF NOT EXISTS `localizacion` (
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`nombre`),
  KEY `nombre` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla inventario_instituto.localizacion: ~3 rows (aproximadamente)
DELETE FROM `localizacion`;
/*!40000 ALTER TABLE `localizacion` DISABLE KEYS */;
INSERT INTO `localizacion` (`nombre`) VALUES
	('AULA'),
	('DEPARTAMENTO'),
	('SIN ASIGNAR');
/*!40000 ALTER TABLE `localizacion` ENABLE KEYS */;

-- Volcando estructura para tabla inventario_instituto.material
DROP TABLE IF EXISTS `material`;
CREATE TABLE IF NOT EXISTS `material` (
  `nombre` varchar(50) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `stock` int NOT NULL,
  `localizacion` varchar(50) NOT NULL,
  `proveedor` int NOT NULL DEFAULT '0',
  `dado_de_baja` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'no',
  `precio_unitario` double NOT NULL,
  PRIMARY KEY (`nombre`),
  KEY `nombre` (`nombre`),
  KEY `FK__tipo_material` (`tipo`),
  KEY `FK_material_localizacion` (`localizacion`),
  KEY `FK_material_proveedor` (`proveedor`),
  CONSTRAINT `FK__tipo_material` FOREIGN KEY (`tipo`) REFERENCES `tipo_material` (`codigo`),
  CONSTRAINT `FK_material_localizacion` FOREIGN KEY (`localizacion`) REFERENCES `localizacion` (`nombre`),
  CONSTRAINT `FK_material_proveedor` FOREIGN KEY (`proveedor`) REFERENCES `proveedor` (`idproveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla inventario_instituto.material: ~5 rows (aproximadamente)
DELETE FROM `material`;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` (`nombre`, `tipo`, `marca`, `stock`, `localizacion`, `proveedor`, `dado_de_baja`, `precio_unitario`) VALUES
	('madera', '1111', 'Muebles Catalán', 1, 'DEPARTAMENTO', 30, 'no', 3.77),
	('mesa', '1111', 'Ikea', 17, 'AULA', 20, 'no', 17.54),
	('mesilla', '0q90K08eg', 'Ikea', 12, 'SIN ASIGNAR', 4, 'no', 1.75),
	('silla', '2222', 'Ikea', 32, 'AULA', 1, 'no', 0),
	('sillon', '1111', 'Muebles esp', 3, 'AULA', 29, 'no', 7.75);
/*!40000 ALTER TABLE `material` ENABLE KEYS */;

-- Volcando estructura para tabla inventario_instituto.proveedor
DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE IF NOT EXISTS `proveedor` (
  `idproveedor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  PRIMARY KEY (`idproveedor`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `telefono` (`telefono`),
  KEY `idproveedor` (`idproveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla inventario_instituto.proveedor: ~22 rows (aproximadamente)
DELETE FROM `proveedor`;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` (`idproveedor`, `nombre`, `apellido`, `email`, `telefono`) VALUES
	(1, 'Junta', 'de Andalucia', '-', '-'),
	(4, 'Pedro', 'Benito', 'pb.gmail.com', '638442322'),
	(11, 'Uriah', 'Narramor', 'unarramor0@reddit.com', '761167665'),
	(12, 'Steffi', 'Dracksford', 'sdracksford1@wufoo.com', '576618680'),
	(13, 'Elberta', 'Brankley', 'ebrankley2@indiatimes.com', '294283086'),
	(14, 'Felice', 'Watkin', 'fwatkin3@prnewswire.com', '807652993'),
	(15, 'Tracy', 'Bierman', 'tbierman4@abc.net.au', '629718477'),
	(16, 'Aura', 'Mougel', 'amougel5@slate.com', '285954334'),
	(17, 'Guinevere', 'Corwin', 'gcorwin6@flavors.me', '326798660'),
	(18, 'Brade', 'Guerrier', 'bguerrier7@marketwatch.com', '202659626'),
	(19, 'Lorin', 'Hamm', 'lhamm8@simplemachines.org', '907672433'),
	(20, 'Amalie', 'O\'Reagan', 'aoreagan9@ehow.com', '980271841'),
	(21, 'Pris', 'Dabnot', 'pdabnota@example.com', '571344466'),
	(22, 'Annette', 'Jerdan', 'ajerdanb@noaa.gov', '856870511'),
	(23, 'Napoleon', 'Drakard', 'ndrakardc@multiply.com', '393688958'),
	(24, 'Emmanuel', 'Cullinan', 'ecullinand@ebay.co.uk', '723224269'),
	(25, 'Emmit', 'Wisham', 'ewishame@dot.gov', '972582709'),
	(26, 'Felicle', 'Tuckey', 'ftuckeyf@discuz.net', '112832354'),
	(27, 'Jenda', 'Placido', 'jplacidog@etsy.com', '997811526'),
	(28, 'Nixie', 'Huntington', 'nhuntingtonh@topsy.com', '181215861'),
	(29, 'Gunther', 'Probart', 'gprobarti@java.com', '470660655'),
	(30, 'Tarrah', 'Rambadt', 'trambadtj@xinhuanet.com', '245710968');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;

-- Volcando estructura para tabla inventario_instituto.tipo_material
DROP TABLE IF EXISTS `tipo_material`;
CREATE TABLE IF NOT EXISTS `tipo_material` (
  `codigo` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `codigo` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla inventario_instituto.tipo_material: ~3 rows (aproximadamente)
DELETE FROM `tipo_material`;
/*!40000 ALTER TABLE `tipo_material` DISABLE KEYS */;
INSERT INTO `tipo_material` (`codigo`, `nombre`) VALUES
	('0q90K08eg', 'carbono'),
	('2222', 'hierro'),
	('1111', 'madera');
/*!40000 ALTER TABLE `tipo_material` ENABLE KEYS */;

-- Volcando estructura para tabla inventario_instituto.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `email` (`email`),
  KEY `idusuario` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla inventario_instituto.usuario: ~23 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idusuario`, `nombre`, `apellido`, `email`, `password`, `tipo`) VALUES
	(1, 'root', 'del sistema', 'root', '3c3f1f5b929b88411b851e42a4bfec0b4797bc355a36dd8e3dd8e164290a0c91edd445c563fb7e0f3929d8e2dd765ca25351a39ceac97c813536333c1d70a915', 'admin'),
	(4, 'Marco', 'Aures', 'marco@yes.no', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'admin'),
	(9, 'joaquim', 'morales', 'd@jefso.es', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'normal'),
	(10, 'Hugues', 'Oakenfield', 'hoakenfield0@go.com', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'normal'),
	(11, 'Omero', 'MacGray', 'omacgray1@themeforest.net', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'normal'),
	(12, 'Thaddus', 'Saltsberger', 'tsaltsberger2@yandex.ru', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'normal'),
	(13, 'Nicko', 'Calabry', 'ncalabry3@prlog.org', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'normal'),
	(14, 'Manda', 'Cadogan', 'mcadogan4@vinaora.com', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'normal'),
	(15, 'Burk', 'Wight', 'bwight5@java.com', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'normal'),
	(16, 'Zacharias', 'Lillo', 'zlillo6@usda.gov', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'admin'),
	(17, 'Koenraad', 'Officer', 'kofficer7@drupal.org', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'admin'),
	(18, 'Caldwell', 'Laviste', 'claviste8@addtoany.com', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'normal'),
	(19, 'Claudette', 'Hanbridge', 'chanbridge9@soundcloud.com', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'normal'),
	(20, 'Larry', 'Oscroft', 'loscrofta@apple.com', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'admin'),
	(21, 'Zeke', 'Kubasek', 'zkubasekb@stanford.edu', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'admin'),
	(22, 'Wilfrid', 'Ferber', 'wferberc@prlog.org', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'admin'),
	(23, 'Mercie', 'Mayfield', 'mmayfieldd@who.int', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'normal'),
	(24, 'Miguela', 'Senescall', 'msenescalle@sphinn.com', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'admin'),
	(25, 'Caprice', 'Cicci', 'cciccif@statcounter.com', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'admin'),
	(26, 'Northrup', 'Tippler', 'ntipplerg@craigslist.org', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'normal'),
	(27, 'Solly', 'Ugolini', 'sugolinih@infoseek.co.jp', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'admin'),
	(28, 'Casie', 'Micheu', 'cmicheui@github.com', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'normal'),
	(29, 'Lyle', 'Ottewell', 'lottewellj@dedecms.com', '4b8618eb2d44f0716a6153939a4ab2e56ad10d67f6c9f2a98f4a9ee024bed26a55a2ea97df5b7560b0077af48b05e259a63d1920e07e1bfa7c792d6120393dca', 'normal');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
