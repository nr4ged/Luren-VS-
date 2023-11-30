CREATE DATABASE  IF NOT EXISTS `bd_luren` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_luren`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_luren
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `tb_boleta_compra`
--

DROP TABLE IF EXISTS `tb_boleta_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_boleta_compra` (
  `codigo` varchar(255) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `descripcion_servicio` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_boleta_compra`
--

LOCK TABLES `tb_boleta_compra` WRITE;
/*!40000 ALTER TABLE `tb_boleta_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_boleta_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cliente` (
  `codigo` varchar(255) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `empresa` varchar(255) DEFAULT NULL,
  `nru_documento` varchar(255) DEFAULT NULL,
  `tipo` int DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_tipo_cliente_idx` (`tipo`),
  CONSTRAINT `fk_tipo_cliente` FOREIGN KEY (`tipo`) REFERENCES `tb_tipocliente` (`id_tipocliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` VALUES ('C001','Luis','Guillen','ElectroMax','123456789',1),('C002','GURJEN','QUISPE','REPUESTOS SANTA CLARA','20553856451',1),('C003','CARLOS','PEREZ','CIBERTEC','10818119',2),('C004','SAUL','ROJAS','ASIF S.A.C.','75152323',2),('C005','JAIME','ROCA BERMEJO','FRENOS \"JAIMITO\"','12345678',2),('C006','JOSE','SILVA','UNICEF S.A.C','20604915351',1),('C007','FABRICIO ANDRES','BULEJE GATILLON','ELECTREMAN','75152318',2),('C008','KARINA','REJAS GATILLON','EVENTOS D\'KG','10548632875',1),('C009','MARIO AVILA','PEREZ LLANOS','FANTA S.A.C.','74962589',2);
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_productos`
--

DROP TABLE IF EXISTS `tb_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_productos` (
  `codigo` varchar(255) NOT NULL,
  `producto` varchar(255) DEFAULT NULL,
  `proveedor` varchar(255) DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `precio` double NOT NULL,
  `tipo` int DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_id_tipoProducto_idx` (`tipo`),
  CONSTRAINT `FKj8d40emc878yuixfqghfkslv1` FOREIGN KEY (`tipo`) REFERENCES `tb_tipprod` (`tipo_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_productos`
--

LOCK TABLES `tb_productos` WRITE;
/*!40000 ALTER TABLE `tb_productos` DISABLE KEYS */;
INSERT INTO `tb_productos` VALUES ('P001','BUJIA NGK','SAN JORGE',20,24,1),('P002','RODAJE DAC- KOYO','DUCASSE',22,35,1),('P003','ROTULA CTR','SAMTIN',20,25.5,1),('P004','MANGUERA DE COMBUSTIBLE','PECSA',8,12,2),('P005','FAJA ACANALADA 4PK','SAN JORGE',47,28,2),('P006','FOCO 12V','OPALUX',10,5,3),('P007','RETEN NOK','DUCASSE',50,12,1),('P008','TERMINAL DE LUZ','OPALUX',35,2,3),('P009','PALIER','AUTOLINE',48,24,1),('P010','PRECALENTADOR','OPALUX',22,12.9,1),('P011','CHUMACERA  PIE','SAMTIN',31,25,2),('P013','asd','aaa',23,30,2);
/*!40000 ALTER TABLE `tb_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_servicio`
--

DROP TABLE IF EXISTS `tb_servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_servicio` (
  `cod_servicio` varchar(255) NOT NULL,
  `descripcion_servicio` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`cod_servicio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_servicio`
--

LOCK TABLES `tb_servicio` WRITE;
/*!40000 ALTER TABLE `tb_servicio` DISABLE KEYS */;
INSERT INTO `tb_servicio` VALUES ('S002','Limpieza MOTOR',125),('S003','CAMBIO DE GNV A GLP',100),('S004','CAMBIO DE FAROS',25),('S005','PALIER',30),('S006','CAMBIO DE PASTILLAS DE FRENO',20),('S007','SERVICO DE PLANCHADO Y PINTURA',120),('S008','LAVADO ',30),('S009','REVISION TECNICA',100),('S010','MANTENIMIENTO',200),('S011','CAMBIOS DE FRENOS',150),('S012','REVISION DE GAS',500),('S013','REVISION DE LLANTAS',5100),('S014','MANTENIMIENTO DE ASIENTOS',500),('S015','MANTENIMIENTO DE ASIE',500),('S016','CAMBIO DE VENTANAS',33),('S017','CAMBIO DE ESTEREO',175);
/*!40000 ALTER TABLE `tb_servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipocliente`
--

DROP TABLE IF EXISTS `tb_tipocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipocliente` (
  `id_tipocliente` int NOT NULL,
  `documento_cliente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_tipocliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipocliente`
--

LOCK TABLES `tb_tipocliente` WRITE;
/*!40000 ALTER TABLE `tb_tipocliente` DISABLE KEYS */;
INSERT INTO `tb_tipocliente` VALUES (1,'RUC'),(2,'DNI'),(3,'PASAPORTE');
/*!40000 ALTER TABLE `tb_tipocliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipousuario`
--

DROP TABLE IF EXISTS `tb_tipousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipousuario` (
  `id_tipo_usuario` int NOT NULL AUTO_INCREMENT,
  `des_tipo_usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipousuario`
--

LOCK TABLES `tb_tipousuario` WRITE;
/*!40000 ALTER TABLE `tb_tipousuario` DISABLE KEYS */;
INSERT INTO `tb_tipousuario` VALUES (1,'Vendedor'),(2,'Gerente RRHH'),(3,'Administrador'),(4,'Gerente de Almacen'),(5,'Cajero');
/*!40000 ALTER TABLE `tb_tipousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipprod`
--

DROP TABLE IF EXISTS `tb_tipprod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipprod` (
  `tipo_prod` int NOT NULL,
  `des_tipo` varchar(255) DEFAULT NULL,
  `tipo` int NOT NULL,
  PRIMARY KEY (`tipo_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipprod`
--

LOCK TABLES `tb_tipprod` WRITE;
/*!40000 ALTER TABLE `tb_tipprod` DISABLE KEYS */;
INSERT INTO `tb_tipprod` VALUES (1,'Repuesto Original',0),(2,'Repuesto alternativo',0),(3,'Otros',0);
/*!40000 ALTER TABLE `tb_tipprod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `codigo` varchar(255) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `id_tipo` int DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_tipo_idx` (`id_tipo`),
  CONSTRAINT `fk_tipo` FOREIGN KEY (`id_tipo`) REFERENCES `tb_tipousuario` (`id_tipo_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES ('U001','Stefano','Sanchez','PAPI','1987',3),('U002','Ángel','Quispe Cachuan','CAJA','2022',1),('U003','Saúl Moisés','Vargas Condori','RRHH','2022',2),('U004','Walter','Gallegos','Wally','2304',2),('U005','Abner Abi','Durand Espinoza','ADMIN2','2022',3),('U006','Edwin Manuel','Caceres Xain','GEALM','2022',1),('U007','Angel	','Vargas Perez','GEALM1','2022',4),('U008','Elias Mario','Velasquez Salas','CAJA','2022',5),('U009','Angela','Jesus','VEND','2023',1),('U011','Santiago','Santiago','CAJ','2023',5),('U012','Omar','Salinas','Somar','1234',3),('U013','Gustavo','Juanjo','Mike','1234',1),('U014','Walter','Gallegos','pedro','1234',2),('U015','Juan','Pedro','H3421','4561',1);
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_luren'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-28 23:11:11
