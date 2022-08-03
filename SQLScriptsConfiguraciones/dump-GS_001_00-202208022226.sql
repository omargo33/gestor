-- MariaDB dump 10.19  Distrib 10.7.3-MariaDB, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: GS_001_00
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `codigo_definido_usuario`
--

DROP TABLE IF EXISTS `codigo_definido_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `codigo_definido_usuario` (
  `id_codigo_definido_usuario` int NOT NULL AUTO_INCREMENT,
  `id_modulo` int NOT NULL,
  `grupo` varchar(8) NOT NULL COMMENT 'Grupo de listas',
  `codigo_texto` varchar(8) NOT NULL COMMENT 'Codigo para los campos de: estado, tipo, grupo y/o categoría',
  `codigo_numero` int NOT NULL COMMENT 'Codigo para los campos de: estado, tipo y/o categoría',
  `nombre` varchar(64) NOT NULL COMMENT 'Nombre del campo',
  `descripcion` varchar(512) DEFAULT NULL COMMENT 'Descripción del campo para presentación',
  `orden` int NOT NULL COMMENT 'Orden de presentacion',
  `estado` varchar(8) NOT NULL COMMENT 'Estado del listado A=Activo, I=Inactivo y X=Eliminado',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_codigo_definido_usuario`),
  KEY `codigo_definido_usuario_id_modulo_IDX` (`id_modulo`,`grupo`) USING BTREE,
  KEY `codigo_definido_usuario_codigo_texto_IDX` (`codigo_texto`) USING BTREE,
  KEY `codigo_definido_usuario_codigo_numero_IDX` (`codigo_numero`) USING BTREE,
  CONSTRAINT `codigo_definido_usuario_FK` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id_modulo`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codigo_definido_usuario`
--

LOCK TABLES `codigo_definido_usuario` WRITE;
/*!40000 ALTER TABLE `codigo_definido_usuario` DISABLE KEYS */;
INSERT INTO `codigo_definido_usuario` VALUES
(1,1,'AD_US_01','A',1,'Activo','Usuario Activo',1,'A','ovelez','2021-05-19 01:41:42','manual'),
(2,1,'AD_US_01','X',2,'Borrado','Usuario Borrado',3,'A','ovelez','2021-05-19 01:42:36','manual'),
(3,1,'AD_US_01','P',3,'Pausado','Usuario Suspendido',2,'A','ovelez','2021-05-19 01:43:01','manual'),
(4,1,'001','AD_US_01',1,'Usuario-Estado','Usuario-Estado',11,'A','ovelez','2021-05-19 01:43:01','manual'),
(5,1,'AD_RL_01','A',1,'Activo','Rol Activo',1,'A','ovelez','2021-06-18 17:15:10','manual'),
(6,1,'AD_RL_01','I',2,'Inactivo','Rol Inactivo',2,'A','ovelez','2021-06-18 17:15:10','manual'),
(7,1,'AD_RL_02','ADM',1,'Administrador','Rol-Administrador',2,'A','ovelez','2021-06-18 17:15:10','manual'),
(8,1,'AD_RL_02','LOG',2,'Auditor','Rol-Auditor',3,'A','ovelez','2021-06-18 17:15:10','manual'),
(9,1,'AD_RL_02','CLI-01',3,'Cliente 01','Rol-Cliente',4,'A','ovelez','2021-06-18 17:15:10','manual'),
(10,1,'AD_RL_02','CLI-02',4,'Cliente 02','Rol-Cliente',5,'A','ovelez','2021-06-18 17:15:10','manual'),
(11,1,'AD_RL_02','ROOT',5,'Principal','Rol-Principal',1,'A','ovelez','2021-06-18 17:15:10','manual'),
(12,1,'001','AD_RL_01',2,'Rol-Estado','Rol-Estado',12,'A','ovelez','2021-05-19 01:43:01','manual'),
(13,1,'001','AD_RL_02',3,'Rol-Tipo-Acceso','Rol-Tipo-Acceso',13,'A','ovelez','2021-05-19 01:43:01','manual'),
(14,1,'001','AD_MD_01',4,'Modulo-Estado','Modulo-Estado',17,'A','ovelez','2021-06-22 22:11:12','manual'),
(15,1,'AD_MD_01','A',1,'Activo','Modulo Activo',1,'A','ovelez','2021-06-22 22:11:52','manual'),
(16,1,'AD_MD_01','I',1,'Inactivo','Modulo Inactivo',2,'A','ovelez','2021-06-22 22:12:39','manual'),
(17,1,'001','AD_CD_01',5,'CDU-Estado','CDU-Estado',6,'A','ovelez','2021-06-22 22:11:12','manual'),
(18,1,'AD_CD_01','A',1,'Activo','Codigo Definido Usuario Activo',1,'A','ovelez','2021-06-22 23:37:06','manual'),
(19,1,'AD_CD_01','I',2,'Inactivo','Codigo Definido Usuario Inactivo',2,'A','ovelez','2021-06-22 23:37:06','manual'),
(23,1,'sdfsadf','11',11,'11','11',-1,'A','Pendiente','2021-06-25 22:18:28','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(24,1,'001','AD_PM_01',1,'Parametro-Clave','Administracion de parametros, en el que se tiene como clave o no',14,'A','Pendiente','2021-07-01 16:24:40','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(25,1,'AD_PM_01','C',0,'Clave','El parametro contiene claves',1,'A','Pendiente','2021-07-01 16:26:59','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(26,1,'AD_PM_01','N',1,'Sin Clave','El parametro no tiene claves',2,'A','Pendiente','2021-07-01 16:27:26','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(27,1,'001','AD_TK_01',1,'Token-Tipo','Tipo de toke, Correo, Facebook o cualquier otra red social',15,'A','Pendiente','2021-07-02 15:22:02','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(28,1,'AD_TK_01','C',1,'Correo','Es el inicial que usa directamente el correo',1,'A','Pendiente','2021-07-02 15:24:18','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(29,1,'AD_TK_01','F',2,'Facebook','Ingreso por Facebook',2,'A','Pendiente','2021-07-02 15:25:51','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(30,1,'AD_TK_01','G',3,'Google','Google Autenticador',3,'A','Pendiente','2021-07-02 16:01:19','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(35,1,'001','AD_TK_02',2,'Token-Estado','Estado del token',16,'A','Pendiente','2021-07-02 16:35:17','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(36,1,'AD_TK_02','A',1,'Activo','Token Activo',2,'A','Pendiente','2021-07-02 16:35:59','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(37,1,'AD_TK_02','I',2,'Inactivo','Token inactivo',3,'A','Pendiente','2021-07-02 16:36:19','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(38,1,'AD_TK_02','C',0,'Creado','Creado pero aun no activado',1,'A','Pendiente','2021-07-02 17:32:39','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(39,1,'001','AD_MN_01',1,'Menu-Tipo','Tipo de menus',9,'A','Pendiente','2021-07-07 22:44:29','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(42,1,'001','AD_MN_02',1,'Menu-Estado','Menu Estado',10,'A','Pendiente','2021-07-07 22:47:25','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(43,1,'AD_MN_01','P',1,'Principal','Es menu principal',1,'A','Pendiente','2021-07-07 22:50:25','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(44,1,'AD_MN_01','S',2,'Secundario','Menu Secundario',2,'A','Pendiente','2021-07-07 22:51:02','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(45,1,'AD_MN_01','U',2,'Usuario','Menu de Usuario',3,'A','Pendiente','2021-07-07 22:51:27','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(46,1,'AD_MN_01','S',4,'Salir','Menu de salida ',4,'A','Pendiente','2021-07-07 22:52:03','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(47,1,'AD_MN_02','A',1,'Activo','Menu activo',2,'A','Pendiente','2021-07-07 22:52:29','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(48,1,'AD_MN_02','I',2,'Inactivo','Menu inactivo',1,'A','Pendiente','2021-07-07 22:52:47','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(49,1,'001','AD_PR_01',1,'Permiso-Crear','Permisos de creación, actualizar, borrar y auditar',8,'A','Pendiente','2021-07-08 16:36:32','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(50,1,'AD_PR_01','S',1,'Si','Esta habilitado',1,'A','Pendiente','2021-07-08 16:37:51','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(51,1,'AD_PR_01','N',0,'No','No Habilitado',2,'A','Pendiente','2021-07-08 16:38:13','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(52,4,'001','CL_PR_01',1,'Estado proyecto','Estado proyecto',7,'A','omar','2022-01-20 14:41:54','/ViewControllerAdministrativo'),
(53,4,'CL_PR_01','A',1,'Activo','Proyecto Activo/Ejecución ',1,'A','omar','2022-01-20 14:42:40','/ViewControllerAdministrativo'),
(54,4,'001','CL_UB_01',2,'Ubicación','CDU para la ubicación de clientes',3,'A','omar','2022-01-28 00:37:24','/Administrativo-001'),
(55,4,'CL_UB_01','E',1,'Email','Correo de contacto',2,'A','omar','2022-01-28 00:40:08','/Administrativo-001'),
(56,4,'CL_UB_01','C',2,'Celular','Teléfono Celular',1,'A','omar','2022-01-28 00:42:06','/Administrativo-001'),
(57,4,'CL_UB_01','T',3,'Teléfono','Teléfono Fijo',3,'A','omar','2022-01-28 00:42:35','/Administrativo-001'),
(58,6,'001','MV_LD_01',1,'Tipo de Direcciones','Tipo de direcciones para el manifiesto',1,'A','omar','2022-02-18 23:05:46','/Administrativo-001'),
(59,6,'MV_LD_01','C',1,'Aerolinea','Aerolinea',0,'A','omar','2022-02-18 23:06:27','/Administrativo-001'),
(60,6,'MV_LD_01','AR',2,'Aeropuerto','Aeropuerto Origen/Desino ',1,'A','omar','2022-02-18 23:08:23','/Administrativo-001'),
(61,6,'MV_LD_01','CA',2,'Aeronave','Idenfivicacion de Avion',2,'A','omar','2022-02-18 23:09:00','/Administrativo-001'),
(62,6,'001','MV_LD_02',2,'Estado libro de direcciones','Estado libro de direcciones si esta borrado acitivo, etc',2,'A','omar','2022-02-20 16:09:55','/Administrativo-001'),
(63,6,'MV_LD_02','A',1,'Activo','Activo',0,'A','omar','2022-02-20 16:11:02','/Administrativo-001'),
(64,6,'MV_LD_02','I',1,'Inactivo','Inactivo',2,'A','omar','2022-02-20 16:11:29','/Administrativo-001'),
(65,6,'MV_LD_02','X',2,'Borrado','Borrado Logico',2,'A','omar','2022-02-20 16:11:51','/Administrativo-001'),
(66,6,'001','MV_LD_03',3,'Estado Sin borrar','Estado Sin borrar',4,'A','omar','2022-02-20 16:50:01','/Administrativo-001'),
(67,6,'MV_LD_03','A',1,'Activo','Activo',0,'A','omar','2022-02-20 16:11:02','/Administrativo-001'),
(68,6,'MV_LD_03','I',1,'Inactivo','Inactivo',2,'A','omar','2022-02-20 16:11:29','/Administrativo-001'),
(69,6,'001','MV_MN_02',4,'Tipo de Manifiesto','Tipo de Manifiesto',18,'A','omar','2022-02-21 23:37:02','/Administrativo-001'),
(70,6,'MV_MN_02','N',0,'Nacional','Vuelo Local',0,'A','omar','2022-02-21 23:37:34','/Administrativo-001'),
(71,6,'MV_MN_02','I',1,'Internacional','Vuelo Internacional',2,'A','omar','2022-02-21 23:38:51','/Administrativo-001'),
(72,6,'001','MV_MN_01',2,'Estado','Estado de manifiesto',5,'A','omar','2022-02-22 00:02:12','/Administrativo-001'),
(73,6,'MV_MN_01','C',1,'Creado','Creado',1,'A','omar','2022-02-22 00:02:42','/Administrativo-001'),
(74,6,'MV_MN_01','B',2,'Bloqueado','Bloqueado para Ediciones',2,'A','omar','2022-02-22 00:03:29','/Administrativo-001'),
(75,6,'MV_MN_01','JDE',3,'JDE','Pasado a JDE',3,'A','omar','2022-02-22 00:04:04','/Administrativo-001'),
(76,6,'MV_MN_01','BAD',4,'Error JDE','Error al pasar a JDE',4,'A','omar','2022-02-22 00:04:48','/Administrativo-001');
/*!40000 ALTER TABLE `codigo_definido_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `error`
--

DROP TABLE IF EXISTS `error`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `error` (
  `id_error` int NOT NULL AUTO_INCREMENT,
  `indice` varchar(128) NOT NULL COMMENT 'Indice de error',
  `mensaje` varchar(1024) NOT NULL COMMENT 'Mensaje de error',
  `descripcion` varchar(4098) DEFAULT NULL COMMENT 'Descripcion del mensaje de error',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_error`),
  KEY `error_indice_IDX` (`indice`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `error`
--

LOCK TABLES `error` WRITE;
/*!40000 ALTER TABLE `error` DISABLE KEYS */;
INSERT INTO `error` VALUES
(1,'SAF000001','SAF000001 Error commit para el codigo {0} en la ubicacion {1}.{2}(). Motivado por: {3}','Mensaje que se usa al dar: \n\ncommitRollback(elemento, \"metodoInvocado\");\n\nelemento: es el campo de los datos que va a indicar los datos que se esten haciendo.\n\n\"metodoInvocado\": es el campo con el nombre del metodo que invoca el commitRollback \n\n','ovelez','2021-05-04 23:03:08','manual'),
(2,'SAF000002','SAF000002 Error al registrar el acceso {0}','Mensaje que se usa al dar: \n\ncrearAcceso(SAFAuditoriaModuloImpl moduloAplicacion, String nombre, String token, String tokenApi, String usuarioPrograma)\n\nNo fue capaz de ejecutar','ovelez','2021-05-04 23:03:08','manual');
/*!40000 ALTER TABLE `error` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informacion`
--

DROP TABLE IF EXISTS `informacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `informacion` (
  `id_informacion` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre de la información a relatar',
  `valor_01` varchar(256) NOT NULL COMMENT 'Valor 01',
  `valor_02` varchar(256) DEFAULT NULL COMMENT 'Valor 02',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_informacion`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacion`
--

LOCK TABLES `informacion` WRITE;
/*!40000 ALTER TABLE `informacion` DISABLE KEYS */;
INSERT INTO `informacion` VALUES
(1,'Nombre','GS_001_00','','ovelez','2012-12-12 17:12:12','manual'),
(2,'Descripción','General Setup version 001','..','ovelez','2012-12-12 17:12:12','manual'),
(3,'Autor','Omar Velez omargo33@hotmail.com','..','ovelez','2021-04-08 14:58:38','manual');
/*!40000 ALTER TABLE `informacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id_menu` int NOT NULL AUTO_INCREMENT,
  `id_modulo` int DEFAULT NULL COMMENT 'Id de modulo',
  `tipo` varchar(8) NOT NULL COMMENT 'Tipo de menu, P=principal, S=secundario, U=usuario y S=salir',
  `indice` varchar(32) NOT NULL COMMENT 'Indice con el que se conce al menu de forma simplificada',
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre del indice',
  `task_flow` varchar(128) NOT NULL COMMENT 'Contexto del modulo',
  `estado` varchar(8) DEFAULT NULL COMMENT 'Estado del listado A=Activo, I=Inactivo',
  `orden` int DEFAULT '0' COMMENT 'Orden de presentacion',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_menu`),
  KEY `menu_indice_IDX` (`indice`),
  KEY `menu_FK` (`id_modulo`),
  CONSTRAINT `menu_FK` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id_modulo`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES
(3,1,'P','LG-US-001','Usuario','/WEB-INF/usuario-task-flow.xml#usuario-task-flow','A',1,'Pendiente','2021-07-09 00:39:01','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(6,2,'P','GS-RL-001','Roles','/WEB-INF/rol-task-flow.xml#rol-task-flow','A',3,'Pendiente','2021-07-09 05:02:06','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(9,2,'P','GS-MN-001','Menus','/WEB-INF/menu-task-flow.xml#menu-task-flow','A',2,'Pendiente','2021-07-09 05:19:24','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(10,2,'P','GS-CD-001','Códigos Definidos','/WEB-INF/cdu-task-flow.xml#cdu-task-flow','A',4,'Pendiente','2021-07-11 17:40:39','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(11,2,'P','GS-ER-001','Errores','/WEB-INF/error-task-flow.xml#error-task-flow','A',6,'Pendiente','2022-01-04 15:53:49','manual'),
(12,2,'P','GS-IN-001','Informacion','/WEB-INF/informacion-task-flow.xml#informacion-task-flow','A',7,'Pendiente','2022-01-04 16:28:04','manual'),
(13,3,'P','IW-EN-001','Reportes','/WEB-INF/reporte-task-flow.xml#reporte-task-flow','A',1,'Pendiente','2022-01-05 04:54:14','manual'),
(14,4,'P','CL_001','Cliente','/WEB-INF/cliente-task-flow#cliente-task-flow','A',2,'omar','2022-01-06 13:43:16','/ViewControllerAdministrativo'),
(15,2,'P','GS-US-001','Usuarios','/WEB-INF/usuario-task-flow.xml#usuario-task-flow','A',5,'omar','2022-01-08 05:40:54','/ViewControllerAdministrativo'),
(16,2,'P','GS-MD-001','Modulos','/WEB-INF/modulo-task-flow.xml#modulo-task-flow','A',1,'omar','2022-01-20 13:53:00','/ViewControllerAdministrativo'),
(18,4,'P','CS_PR_001','Proyecto','/WEB-INF/proyecto-task-flow#proyecto-task-flow','A',1,'omar','2022-01-25 14:42:01','/Administrativo-001'),
(19,4,'P','CS_CT_001','Contacto','/WEB-INF/contacto-task-flow#contacto-task-flow','A',3,'omar','2022-02-08 14:53:37','/Administrativo-001'),
(20,6,'P','MV_RG_001','Cierre de Vuelo (ADM)','/WEB-INF/manifiesto-usuario-task-flow.xml#manifiesto-usuario-task-flow','A',1,'omar','2022-02-18 18:18:04','/Administrativo-001'),
(21,6,'P','MV_AL_001','Cierre de Vuelo','/WEB-INF/manifiesto-usuario-task-flow.xml#manifiesto-usuario-task-flow','A',2,'omar','2022-02-18 20:10:46','/Administrativo-001'),
(22,6,'P','MV_LD_001','Libro Direcciones','/WEB-INF/libro-direccion-task-flow.xml#libro-direccion-task-flow','A',3,'omar','2022-02-20 16:37:18','/Administrativo-001'),
(23,6,'P','MV_TT_001','Tasas Timbres','/WEB-INF/tasa-task-flow.xml#tasa-task-flow','A',4,'admin','2022-03-15 18:03:26','/Administrativo-001'),
(24,2,'P','GS-CC-001','Cambio Clave','/WEB-INF/clave-task-flow.xml#clave-task-flow','A',8,'root','2022-06-14 00:04:43','/Administrativo-001'),
(25,6,'P','MV_ER_001','Envio Cierre Vuelo','/WEB-INF/error-rest-task-flow.xml#error-rest-task-flow','A',5,'admin','2022-03-15 18:03:26','/Administrativo-001');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulo`
--

DROP TABLE IF EXISTS `modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modulo` (
  `id_modulo` int NOT NULL AUTO_INCREMENT,
  `indice` varchar(32) NOT NULL COMMENT 'Indici con el que se conce al modulo de forma simplificada',
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre del indice',
  `contexto` varchar(128) NOT NULL COMMENT 'Contexto de aplicacion',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  `estado` varchar(8) DEFAULT NULL COMMENT 'Estado del listado A=Activo, I=Inactivo y X=Eliminado',
  PRIMARY KEY (`id_modulo`),
  KEY `modulo_indice_IDX` (`indice`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulo`
--

LOCK TABLES `modulo` WRITE;
/*!40000 ALTER TABLE `modulo` DISABLE KEYS */;
INSERT INTO `modulo` VALUES
(1,'LG_001_00','Login','http://3.139.25.45:28080/Login-001/faces/LOG001?server=GF5&?token=','ovelez','2021-05-16 22:47:55','manual','I'),
(2,'GS_001_00','X. Configuración','http://3.139.25.45:28081/Administrativo-001/faces/LOG001?server=GF5&?token=','Pendiente','2021-07-07 23:24:44','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT','A'),
(3,'IW_001_00','Reportes Impresiones','ViewControllerReportes/faces/LOG001','Pendiebnte','2022-01-05 04:52:13','manual','I'),
(4,'CS_001_00','Cliente SAF','Cliente-001/faces/LOG001','omar','2022-01-06 13:40:57','/ViewControllerAdministrativo','I'),
(6,'MV_001_00','Manifiesto','http://3.139.25.45:28082/Manifiesto-001/faces/LOG001?server=GF5&?token=','omar','2022-02-18 18:13:50','/Administrativo-001','A'),
(7,'GA_001_00','Gestion de Archivos','Archivo-001/faces/LOG001','omar','2022-02-25 04:30:28','/Administrativo-001','I'),
(8,'BD_001_00','Base Desarrollo','BaseDesarrollo-001/faces/LOG001','omar','2022-02-25 04:30:28','/Administrativo-001','I');
/*!40000 ALTER TABLE `modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametro`
--

DROP TABLE IF EXISTS `parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametro` (
  `id_parametro` int NOT NULL AUTO_INCREMENT,
  `id_modulo` int DEFAULT NULL,
  `indice` varchar(32) NOT NULL COMMENT 'Indice de busquedas',
  `clave` varchar(8) DEFAULT NULL COMMENT 'Si los campos te texto son o no encriptados',
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre del parametro',
  `descripcion` varchar(512) NOT NULL COMMENT 'Descripción del campo a ser usado',
  `valor_texto_01` varchar(256) DEFAULT NULL COMMENT 'Valor texto a parametro',
  `valor_texto_02` varchar(256) DEFAULT NULL COMMENT 'Valor texto a parametro',
  `valor_numero_01` double DEFAULT NULL COMMENT 'Valor numero a parametro',
  `valor_numero_02` double DEFAULT NULL COMMENT 'Valor numero a parametro',
  `default_texto_01` varchar(256) DEFAULT NULL COMMENT 'Default texto 01',
  `default_texto_02` varchar(256) DEFAULT NULL COMMENT 'Default texto 02',
  `default_numero_01` double DEFAULT NULL COMMENT 'Default numero 01',
  `default_numero_02` double DEFAULT NULL COMMENT 'Default numero 02',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_parametro`),
  KEY `parametro_FK` (`id_modulo`),
  KEY `parametro_indice_IDX` (`indice`) USING BTREE,
  CONSTRAINT `parametro_FK` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id_modulo`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametro`
--

LOCK TABLES `parametro` WRITE;
/*!40000 ALTER TABLE `parametro` DISABLE KEYS */;
INSERT INTO `parametro` VALUES
(2,1,'002','N','Tiempo de espera ante intentos fallidos','Tiempo en horas, antes que la clave vuelva a estar activo','','',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),
(8,1,'001','N','Numero de Intentos','Numero de Intentos que el login tendra antes de bloquear',NULL,NULL,3,0,'<No Definido>','<No Definido>',3,0,'Pendiente','2021-07-05 21:54:10','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(9,1,'003','N',' reCAPTCHA','reCAPTCHA al sitio web  \"loginADF\"','6LfRpt8bAAAAAFUbbzttVV5FrAhSiIN5vZUsekSL','6LfRpt8bAAAAANCPK5xqiHX2GTp3xC7MmTSL-p4o',NULL,NULL,'Clave del sitio Web','Clave secreta Servidor',0,0,'weblogic','2021-08-05 15:05:49','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(10,1,'004','N','Contexto Usuario','Contexto Usuario nuevo y/o cambio clave + idMenu menu de cambio de clave','http://3.139.25.45:28081/Administrativo-001/faces/LOG001?server=GF5&?token=','',24,NULL,'Contexto de Usuario','Contexto de Usuario',0,0,'weblogic','2021-08-05 15:05:49','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(11,1,'005','N','Plantilla notificación enviar token','id Plantilla notificación enviar token',NULL,NULL,1,NULL,'Expresión Regular de validación','Mensaje de validación',0,0,'omar','2022-01-22 05:43:02','/Administrativo-001'),
(13,2,'001','N','Expresion Regular para el cambio de claves','Expresion regular para claves ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;\',?/*~$^+=<>]).{8,20}$','^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;\',?/*~$^+=<>]).{8,20}$','Debe contener: del 0-9, A-Z, a-z y los caracteres ! @ # & ( ) ; en un largo de 8-20 caracteres ',2,NULL,'<No Definido>','<No Definido>',2,0,'omar','2022-01-27 05:30:31','/Administrativo-001'),
(14,8,'200','N','Path Relativo','Path Relativo para guardado de archivos','/home/centos/',NULL,NULL,NULL,'<No Definido>','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),
(15,1,'100','N','Servidor por default de seguridades','Servidor por default de seguridades o proveedor o tecnologia de servidor, puede ser WLS12 GF5','GF5','',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),
(16,2,'100','N','Servidor por default de seguridades','Servidor por default de seguridades o proveedor o tecnologia de servidor, puede ser WLS12 GF5','GF5','',2,NULL,'<No Definido>','<No Definido>',NULL,2,'ovelez','2021-05-16 23:00:24','manual'),
(18,8,'50','N','Logout del modulo','Logout del modulo','http://3.139.25.45:28080/Login-001/faces/Home.jspx',NULL,NULL,NULL,'<No Definido>','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),
(19,2,'50','N','Logout del modulo','Logout del modulo','http://3.139.25.45:28080/Login-001/faces/Home.jspx',NULL,NULL,NULL,'/homo/user','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),
(20,1,'50','N','Logout del modulo','Logout del modulo','http://3.139.25.45:28080/Login-001/faces/Home.jspx',NULL,NULL,NULL,'/homo/user','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),
(21,6,'200','N','Path Relativo','Path Relativo para guardado de archivos','/home/centos/',NULL,NULL,NULL,'<No Definido>','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),
(26,6,'001','N','URL Servicio manifiesto JDE','URL Servicio manifiesto JDE','https://186.31.107.90:8089/PY920/IntegracionPortalTasasTimbres',NULL,NULL,NULL,'https://186.31.107.90:8089/PY920/IntegracionPortalTasasTimbres','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),
(27,6,'002','N','Usuario/Clave URL Servicio manifiesto JDE','Usuario/Clave URL Servicio manifiesto JDE','CONSULTOR','C0nsult0r2021#*',NULL,NULL,'Usuario/Clave asignado desde  JDE ','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),
(28,6,'003','N','Path de archivo de llave SSL','Path de archivo de llave SSL que debe ser obtenida desde el sitio https','/home/centos/ssl_jde_aerocivil','1937480',NULL,NULL,'Path de SSL','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),
(31,1,'006','N','URL empresarial','Url empresarial','https://www.aerocivil.gov.co/',NULL,1,NULL,'Expresión Regular de validación','Mensaje de validación',0,0,'omar','2022-01-22 05:43:02','/Administrativo-001'),
(32,1,'007','N','URL Declaimer','URL de declaimer del sitio web, se usa para dar informacion legal o de contenido variado','http://3.139.25.45:28080/Imagen-001/declaimer.html',NULL,1,NULL,'Expresión Regular de validación','Url del Declamer',0,0,'omar','2022-01-22 05:43:02','/Administrativo-001'),
(33,6,'004','N','Dias de seguridad para ingreso de Cierres','Dias de seguridad para ingreso de Cierres','','',30,NULL,'','',30,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),
(34,6,'005','N','Maximo de ocupantes de los aviones','Maximo de ocupantes de los aviones validaciones',NULL,NULL,501,NULL,NULL,NULL,501,0,'omar','2022-02-25 04:31:17','/Administrativo-001'),
(35,1,'300','N','Notificacion Solicitud Nueva Clave','Notificacion Solicitud Nueva Clave (Formato y Servicio)','',NULL,1,1,'','',1,1,'ovelez','2022-02-25 04:31:17','/Administrativo-001'),
(36,2,'300','N','Notificacion Crear Clave ','Notificacion Crear Clave (Formato y Servicio)','',NULL,2,1,' ',' ',2,1,'omar','2022-02-25 04:31:17','/Administrativo-001'),
(37,2,'301','N','Notificacion Cambio Clave ','Notificacion Cambio Clave (Formato y Servicio)','',NULL,1,1,' ',' ',1,1,'omar','2022-02-25 04:31:17','/Administrativo-001'),
(38,6,'50','N','Logout del modulo','Logout del modulo','http://3.139.25.45:28080/Login-001/faces/Home.jspx',NULL,NULL,NULL,'/homo/user','<No Definido>',0,0,'omar','2022-02-25 04:31:17','/Administrativo-001');
/*!40000 ALTER TABLE `parametro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permiso`
--

DROP TABLE IF EXISTS `permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permiso` (
  `id_permiso` int NOT NULL AUTO_INCREMENT,
  `id_menu` int DEFAULT NULL COMMENT 'Id de menu',
  `id_rol` int DEFAULT NULL COMMENT 'Id de Rol',
  `crear` varchar(8) NOT NULL COMMENT 'Si el menu permite crear',
  `actualizar` varchar(8) NOT NULL COMMENT 'Si el menu permite actualizar',
  `borrar` varchar(8) NOT NULL COMMENT 'Si el menu permite borrar',
  `ver_auditoria` varchar(8) NOT NULL COMMENT 'Si el menu permite ver la auditoria',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_permiso`),
  KEY `permiso_FK` (`id_rol`),
  KEY `permiso_FK_1` (`id_menu`),
  CONSTRAINT `permiso_FK` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `permiso_FK_1` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_menu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso`
--

LOCK TABLES `permiso` WRITE;
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
INSERT INTO `permiso` VALUES
(4,6,1,'S','S','S','S','Pendiente','2021-07-09 05:02:38','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(12,10,1,'S','S','S','S','Pendiente','2021-07-11 17:45:20','SAFAdministrativo.ViewControllerAdministrativo.1.0-SNAPSHOT'),
(15,11,1,'S','S','S','S','Pendiente','2022-01-04 15:54:50','manual'),
(17,12,1,'S','S','S','S','Pendiente','2022-01-04 16:28:32','manual'),
(19,13,1,'S','S','S','S','Pendiente','2022-01-05 04:54:43','manual'),
(23,15,1,'S','S','S','S','omar','2022-01-08 05:55:12','/ViewControllerAdministrativo'),
(25,3,1,'S','S','S','S','omar','2022-01-19 04:56:31','/ViewControllerAdministrativo'),
(72,21,1,'S','S','S','S','admin','2022-03-09 14:32:55','/Administrativo-001'),
(78,23,1,'S','S','S','S','admin','2022-03-15 18:03:59','/Administrativo-001'),
(81,16,1,'S','S','S','S','admin','2022-03-23 09:42:49','/Administrativo-001'),
(82,9,1,'S','S','S','S','admin','2022-03-23 09:43:27','/Administrativo-001'),
(83,22,1,'S','S','S','S','admin','2022-03-23 09:48:03','/Administrativo-001'),
(84,20,1,'S','S','S','S','admin','2022-03-23 09:48:39','/Administrativo-001'),
(85,21,11,'S','S','S','S','root','2022-03-23 10:04:44','/Administrativo-001'),
(86,3,11,'S','S','S','S','root','2022-03-23 10:43:27','/Administrativo-001'),
(87,15,12,'S','S','S','S','root','2022-03-23 10:48:31','/Administrativo-001'),
(88,20,12,'N','N','N','S','root','2022-03-23 10:50:07','/Administrativo-001'),
(89,23,12,'S','S','S','S','root','2022-03-23 10:53:37','/Administrativo-001'),
(90,22,12,'S','S','S','S','root','2022-03-23 10:58:50','/Administrativo-001'),
(91,3,12,'S','S','S','S','root','2022-03-23 11:05:09','/Administrativo-001'),
(92,3,13,'S','S','S','S','root','2022-03-23 11:05:17','/Administrativo-001'),
(93,22,13,'S','S','S','S','root','2022-03-23 11:05:37','/Administrativo-001'),
(94,20,13,'S','S','S','S','root','2022-03-23 11:07:22','/Administrativo-001'),
(99,24,12,'S','S','S','S','root','2022-06-14 00:05:38','/Administrativo-001'),
(100,24,11,'S','S','S','S','root','2022-06-14 00:05:44','/Administrativo-001'),
(101,24,1,'S','S','S','S','root','2022-06-14 00:05:56','/Administrativo-001'),
(102,24,13,'S','S','S','S','root','2022-06-14 00:06:04','/Administrativo-001'),
(103,25,1,'S','S','S','S','admin','2022-03-15 18:03:59','/Administrativo-001'),
(104,25,12,'S','S','S','S','root','2022-03-23 10:53:37','/Administrativo-001');
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `id_modulo` int DEFAULT NULL COMMENT 'Menu al que afecta este modulo',
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre del rol',
  `tipo` varchar(8) NOT NULL COMMENT 'Tipo de Rol tecnico en desarrollo JANZ',
  `estado` varchar(8) NOT NULL COMMENT 'Estado del listado A=Activo, I=Inactivo y X=Eliminado',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_rol`),
  KEY `rol_FK` (`id_modulo`),
  CONSTRAINT `rol_FK` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id_modulo`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES
(1,2,'Root-SuperUsuarios','ROOT','A','sdfsadf','2021-06-21 22:01:53','fsdfs'),
(11,NULL,'Aerolinea','CLI-02','A','root','2022-03-23 10:01:34','/Administrativo-001'),
(12,NULL,'Administrador','ADM','A','root','2022-03-23 10:47:54','/Administrativo-001'),
(13,NULL,'Supervisor','CLI-01','A','root','2022-03-23 11:04:09','/Administrativo-001');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol_usuario`
--

DROP TABLE IF EXISTS `rol_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol_usuario` (
  `id_rol_usuario` int NOT NULL AUTO_INCREMENT,
  `id_rol` int NOT NULL,
  `id_usuario` int NOT NULL,
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_rol_usuario`),
  KEY `rol_usuario_FK` (`id_rol`),
  KEY `rol_usuario_FK_1` (`id_usuario`),
  CONSTRAINT `rol_usuario_FK` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`),
  CONSTRAINT `rol_usuario_FK_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol_usuario`
--

LOCK TABLES `rol_usuario` WRITE;
/*!40000 ALTER TABLE `rol_usuario` DISABLE KEYS */;
INSERT INTO `rol_usuario` VALUES
(39,1,15,'admin','2022-03-23 09:42:33','/Administrativo-001'),
(42,12,13,'root','2022-03-23 10:49:10','/Administrativo-001'),
(43,13,25,'root','2022-03-23 11:25:14','/Administrativo-001'),
(44,11,26,'admin','2022-03-23 14:38:00','/Administrativo-001'),
(49,12,29,'admin','2022-04-18 15:33:38','/Administrativo-001'),
(50,13,30,'admin','2022-04-18 15:41:47','/Administrativo-001'),
(51,12,31,'cgaribello','2022-04-18 22:22:39','/Administrativo-001'),
(52,12,32,'supervisor','2022-04-20 22:09:10','/Administrativo-001'),
(54,11,34,'ADMIN','2022-06-03 16:59:21','/Administrativo-001'),
(55,13,35,'supervisor','2022-06-09 14:40:42','/Administrativo-001'),
(56,11,36,'admin','2022-06-13 15:00:41','/Administrativo-001'),
(57,11,37,'admin','2022-06-13 15:00:43','/Administrativo-001'),
(58,13,38,'admin','2022-06-13 15:24:45','/Administrativo-001'),
(59,11,39,'admin','2022-06-13 16:14:49','/Administrativo-001'),
(60,11,40,'admin','2022-06-13 16:21:04','/Administrativo-001'),
(61,11,33,'cgaribello','2022-06-15 11:53:29','/Administrativo-001'),
(62,11,41,'cgaribello','2022-06-15 12:46:59','/Administrativo-001'),
(65,11,38,'cgaribello','2022-06-16 13:06:49','/Administrativo-001'),
(66,13,42,'cgaribello','2022-07-25 20:50:47','/Administrativo-001'),
(67,11,43,'cgaribello','2022-07-26 15:26:22','/Administrativo-001'),
(68,13,44,'cgaribello','2022-07-26 15:52:02','/Administrativo-001');
/*!40000 ALTER TABLE `rol_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id_token` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `tipo` varchar(8) NOT NULL COMMENT 'Tipo de red social, L=linkeid, G=google, etc',
  `social_nick` varchar(256) NOT NULL COMMENT 'Nombre de usuario de red @omargo33',
  `correo` varchar(256) DEFAULT NULL COMMENT 'Correo electrónico',
  `token` varchar(512) NOT NULL COMMENT 'Token o clave encripatada',
  `validador` varchar(512) NOT NULL COMMENT 'Campo validacion de los campos ejecutados',
  `estado` varchar(8) NOT NULL COMMENT 'Estado del listado A=Activo, I=Inactivo y X=Eliminado',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_token`),
  KEY `token_FK` (`id_usuario`),
  KEY `token_correo_IDX` (`correo`) USING BTREE,
  KEY `token_social_nick_IDX` (`social_nick`) USING BTREE,
  CONSTRAINT `token_FK` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES
(4,15,'C','root','omargo33@hotmail.com','D3CCE906E17553C064A2576C1479908A7F92AB1D8046C94A13A51B9F3E5FBC36','3506402','A','root','2022-06-17 16:24:38','/Administrativo-001'),
(13,18,'C','aerolinea','administracion001@procesoelectronico.com','4819567762E70300348172C234F8695DD3B2F4BAD149420D35B8A4CC7B8083AE','2077778476','A','aerolinea','2022-06-14 01:29:47','/Administrativo-001'),
(14,25,'C','supervisor','jmartinez214@hotmail.com','8AE0E9DF7CFFA030D4C1AEE3392D89C33B2564468D04FF28448AA9098151F01D','-1697229976','A','supervisor','2022-06-15 21:01:40','/Administrativo-001'),
(15,13,'C','admin','administracion@procesoelectronico.com','76C9E8B681DDA0FA9C7A442E1055B0AF6FCEADF184307B6B0FB67076CE3E0FD7','92668751','C','admin','2022-06-15 20:06:53','/Administrativo-001'),
(16,26,'C','jmartinez','johanna.martinez@sicsas.com','93B6E33B14494AC8C7C3C3A990B50F1567CB765C936620B06C472B5278762A43','1938753242','A','jmartinez','2022-06-21 15:01:18','/Administrativo-001'),
(17,27,'C','lhernandez',NULL,'EFBDB71710DEDCB86BFE0C4719183DC9649B85B77D806DBEBB1B5CBEDCE5DC09','-1771738745','C','admin','2022-04-06 18:17:17','/Administrativo-001'),
(18,28,'C','aerolinea2','administracion003@procesoelectronico.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','-13376634','P','admin','2022-04-07 19:13:24','/Administrativo-001'),
(19,29,'C','cgaribello','carlos.garibello@aerocivil.gov.co','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','-1014419240','A','admin','2022-04-18 15:32:19','/Administrativo-001'),
(20,30,'C','hloaiza','jmartinez214@gmail.com','992260BC6BB8BCCB195756F1A39B9C87BBE25D44A2E34F2E314F113CE21F9B52','1008555962','A','hloaiza','2022-06-15 21:18:36','/Administrativo-001'),
(21,31,'C','ovelez','johanna.martinez000@sicsas.com','1D15EF70F4F792789B729FB77A28635278E6E8521372D4CDDBFC5E9B80C8B7FA','-1005040125','C','ovelez','2022-06-14 19:33:42','/Administrativo-001'),
(22,32,'C','aerocivil','administrador002@procesoelectronico.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','2069474610','P','supervisor','2022-04-20 22:08:23','/Administrativo-001'),
(23,33,'C','pgomez','consultorjde@gmail.com','8DF79DEB606C9A5955D4D7FBD93037C29F736659B06AEF73A377626DCD404B41','-989964918','C','admin','2022-04-21 18:37:56','/Administrativo-001'),
(24,34,'C','truiz','tania.ruiz@sicsas.com','8AC1AE3DADB9C81D91DEA32EA853846114854C87A387CFD4554206300FE126B9','110640424','A','truiz','2022-06-13 16:02:31','/Usuario-001'),
(25,35,'C','adiaz','tania.m.ruiz92@gmail.com','A5605B1EB37C461E2CBC28EFFCCDAF734F4A30E284FC87CE36D8C9A84C0A6071','92664671','A','adiaz','2022-07-25 23:12:16','/Administrativo-001'),
(26,36,'C','ivera','consultoriajde@gmail.com','49D16E2A3850201535F3F73C3DA561DA42D70449CDF8D39A7B6BBBDC8C4B5824','100585735','A','ivera','2022-06-15 17:22:02','/Administrativo-001'),
(27,37,'C','sjimenez','soniajimenez_m@hotmail.com','90F635306512986F97474E458C5808AB3666A062FAADBAA8CD6165FB3FAF456D','1255677785','A','sjimenez','2022-06-15 17:32:23','/Administrativo-001'),
(29,38,'C','msalinas','marcela_250694@hotmail.com','B5EAEC45A56DCBA09ED25ECFD27C04895B01A55D6FB0AC84D97ED4905E6FF995','-1443488792','A','msalinas','2022-06-15 20:09:53','/Administrativo-001'),
(30,39,'C','dpedreros','diana.pedreros@aerocivil.gov.co','E37C6F535750F0B9FF29DDE5AE72B57F0276D81A7961B3D31FD034ADE50C3380','-315680904','A','dpedreros','2022-06-15 17:38:05','/Administrativo-001'),
(31,40,'C','rodriguezm','myrockstar28@gmail.com','AFC921649FBD3FB9EA5114104279DB0E521191B042AF1051DFBD2A46F61D92CC','-303336660','A','rodriguezm','2022-06-15 19:19:59','/Administrativo-001'),
(32,41,'C','stovar','confirmacionesjde@gmail.com','706913F9819F1116532263C79123219AB88AFCD803A5C1071D4FA1839DD3C705','-892063175','A','stovar','2022-06-15 17:07:15','/Administrativo-001'),
(33,43,'C','cjami','carlos.garibello1569@gmail.com','18DFB491062924BA57360B36C0CB19DC1704EA153DBD532DCEAAC4D0E182A85C','94683126','C','cgaribello','2022-07-26 15:25:52','/Administrativo-001'),
(34,44,'C','grodriguez','gerson.rodriguez@aerocivil.gov.co','FB6E527367D709722EE51A0914CE8719271747D560221710F302EE9EAE24FE85','-854049574','C','cgaribello','2022-07-26 15:51:05','/Administrativo-001');
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token_servidor`
--

DROP TABLE IF EXISTS `token_servidor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token_servidor` (
  `id_token_servidor` int NOT NULL AUTO_INCREMENT,
  `id_token` int DEFAULT NULL,
  `tipo` varchar(8) NOT NULL COMMENT 'Tipo de encripcion AES DES JASCRIPT',
  `servidor` varchar(8) NOT NULL COMMENT 'Servidor que esta utilizando WL12=weblogic 12c  WF19=wildfly 19, GF5 glassfish 5',
  `password` varchar(512) DEFAULT NULL COMMENT 'Clave que se ha guardado password',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  PRIMARY KEY (`id_token_servidor`),
  KEY `token_servidor_indice_IDX` (`tipo`),
  KEY `token_servidor_FK` (`id_token`),
  CONSTRAINT `token_servidor_FK` FOREIGN KEY (`id_token`) REFERENCES `token` (`id_token`)
) ENGINE=InnoDB AUTO_INCREMENT=1701 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token_servidor`
--

LOCK TABLES `token_servidor` WRITE;
/*!40000 ALTER TABLE `token_servidor` DISABLE KEYS */;
INSERT INTO `token_servidor` VALUES
(740,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 10:08:51','/Login-001'),
(741,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 10:16:47','/Login-001'),
(742,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 10:20:48','/Login-001'),
(743,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 10:30:10','/Login-001'),
(744,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 10:41:32','/Login-001'),
(745,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 11:13:03','/Login-001'),
(746,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 11:20:56','/Login-001'),
(747,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 11:24:38','/Login-001'),
(748,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 11:27:22','/Login-001'),
(749,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 11:27:58','/Login-001'),
(750,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 11:30:19','/Login-001'),
(751,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 11:34:04','/Login-001'),
(752,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 11:36:20','/Login-001'),
(753,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 11:38:04','/Login-001'),
(754,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 11:38:40','/Login-001'),
(755,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 11:47:42','/Login-001'),
(756,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 11:49:51','/Login-001'),
(757,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 14:34:28','/Login-001'),
(758,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 14:46:59','/Login-001'),
(759,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 14:50:37','/Login-001'),
(760,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 14:51:29','/Login-001'),
(761,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 14:52:49','/Login-001'),
(762,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 15:02:53','/Login-001'),
(763,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 15:11:00','/Login-001'),
(764,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 15:13:39','/Login-001'),
(765,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 15:36:43','/Login-001'),
(766,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 15:39:43','/Login-001'),
(767,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 15:43:33','/Login-001'),
(768,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 15:44:01','/Login-001'),
(769,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 18:43:11','/Login-001'),
(770,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 19:33:54','/Login-001'),
(771,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 19:34:23','/Login-001'),
(772,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 19:55:04','/Login-001'),
(773,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 19:57:00','/Login-001'),
(774,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 20:03:29','/Login-001'),
(775,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 20:04:30','/Login-001'),
(776,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 20:08:10','/Login-001'),
(777,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 23:24:30','/Login-001'),
(778,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 23:26:50','/Login-001'),
(779,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-23 23:46:57','/Login-001'),
(780,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 05:53:42','/Login-001'),
(781,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 06:10:18','/Login-001'),
(782,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 06:10:43','/Login-001'),
(783,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 06:13:51','/Login-001'),
(784,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 06:16:00','/Login-001'),
(785,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 06:20:52','/Login-001'),
(786,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 06:22:28','/Login-001'),
(787,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 08:29:24','/Login-001'),
(788,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 09:17:11','/Login-001'),
(789,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 16:05:43','/Login-001'),
(790,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 16:06:16','/Login-001'),
(791,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 16:24:00','/Login-001'),
(792,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 18:08:41','/Login-001'),
(793,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 18:09:05','/Login-001'),
(794,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 18:10:07','/Login-001'),
(795,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 20:52:58','/Login-001'),
(796,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 22:24:52','/Login-001'),
(797,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 22:27:27','/Login-001'),
(798,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 22:51:51','/Login-001'),
(799,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-24 22:54:01','/Login-001'),
(800,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-25 10:00:53','/Login-001'),
(801,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-25 10:10:20','/Login-001'),
(802,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-25 10:11:03','/Login-001'),
(803,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-25 10:41:18','/Login-001'),
(804,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-25 11:01:26','/Login-001'),
(805,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-25 11:03:09','/Login-001'),
(806,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-25 11:04:43','/Login-001'),
(807,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-25 11:56:53','/Login-001'),
(808,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-25 12:19:35','/Login-001'),
(809,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-25 12:21:12','/Login-001'),
(810,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-25 14:39:39','/Login-001'),
(811,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 03:48:02','/Login-001'),
(812,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 03:53:57','/Login-001'),
(813,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 04:01:12','/Login-001'),
(814,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 04:02:22','/Login-001'),
(815,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 04:06:09','/Login-001'),
(816,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 04:13:13','/Login-001'),
(817,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 04:40:45','/Login-001'),
(818,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 04:41:07','/Login-001'),
(819,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 04:42:54','/Login-001'),
(820,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 04:55:02','/Login-001'),
(821,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 04:57:06','/Login-001'),
(822,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 05:01:54','/Login-001'),
(823,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 06:10:49','/Login-001'),
(824,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 06:51:25','/Login-001'),
(825,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 06:53:51','/Login-001'),
(826,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 08:33:23','/Login-001'),
(827,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 08:33:51','/Login-001'),
(828,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 11:48:47','/Login-001'),
(829,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 11:54:05','/Login-001'),
(830,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 12:37:12','/Login-001'),
(831,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 12:39:49','/Login-001'),
(832,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 12:57:39','/Login-001'),
(833,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 13:00:55','/Login-001'),
(834,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 14:41:18','/Login-001'),
(835,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-28 16:23:10','/Login-001'),
(836,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 06:54:46','/Login-001'),
(837,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 06:59:35','/Login-001'),
(838,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 07:09:12','/Login-001'),
(839,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 07:14:40','/Login-001'),
(840,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 08:21:34','/Login-001'),
(841,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 08:26:15','/Login-001'),
(842,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 08:27:49','/Login-001'),
(843,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 08:28:13','/Login-001'),
(844,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 16:19:48','/Login-001'),
(845,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 20:22:35','/Login-001'),
(846,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 20:22:45','/Login-001'),
(847,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 20:35:08','/Login-001'),
(848,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 20:35:24','/Login-001'),
(849,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 20:36:10','/Login-001'),
(850,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 21:01:48','/Login-001'),
(851,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 21:02:04','/Login-001'),
(852,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-30 21:02:38','/Login-001'),
(853,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-31 09:50:48','/Login-001'),
(854,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-03-31 10:02:25','/Login-001'),
(855,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-01 07:15:22','/Login-001'),
(856,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-01 08:44:55','/Login-001'),
(857,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-01 08:58:21','/Login-001'),
(858,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-01 08:59:02','/Login-001'),
(859,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-01 14:40:56','/Login-001'),
(860,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-01 14:49:20','/Login-001'),
(861,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-01 15:00:29','/Login-001'),
(862,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-01 15:01:57','/Login-001'),
(863,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-01 15:02:48','/Login-001'),
(864,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-01 15:08:20','/Login-001'),
(865,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-01 15:08:53','/Login-001'),
(866,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-01 15:10:04','/Login-001'),
(867,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-04 22:56:11','/Login-001'),
(868,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-04 23:13:44','/Login-001'),
(869,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-04 23:16:08','/Login-001'),
(870,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-04 23:26:20','/Login-001'),
(871,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-04 23:27:16','/Login-001'),
(872,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 03:52:04','/Login-001'),
(873,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 04:10:34','/Login-001'),
(874,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 04:22:46','/Login-001'),
(875,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 11:08:18','/Login-001'),
(876,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 11:34:37','/Login-001'),
(877,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 11:35:22','/Login-001'),
(878,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 11:47:35','/Login-001'),
(879,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 11:53:28','/Login-001'),
(880,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 11:53:47','/Login-001'),
(881,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 14:15:54','/Login-001'),
(882,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 14:20:57','/Login-001'),
(883,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 14:21:54','/Login-001'),
(884,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 14:22:16','/Login-001'),
(885,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 14:29:42','/Login-001'),
(886,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 14:30:48','/Login-001'),
(887,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 14:49:30','/Login-001'),
(888,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 15:22:40','/Login-001'),
(889,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-05 15:24:39','/Login-001'),
(890,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-06 17:56:40','/Login-001'),
(891,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 18:06:16','/Login-001'),
(892,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 18:18:44','/Login-001'),
(893,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 18:19:34','/Login-001'),
(894,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 18:20:14','/Login-001'),
(895,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 18:21:53','/Login-001'),
(896,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 18:23:14','/Login-001'),
(897,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 18:34:58','/Login-001'),
(898,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 18:37:39','/Login-001'),
(899,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 18:39:13','/Login-001'),
(900,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 18:40:23','/Login-001'),
(901,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 18:44:39','/Login-001'),
(902,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 18:49:31','/Login-001'),
(903,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 18:49:45','/Login-001'),
(904,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 19:05:13','/Login-001'),
(905,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 19:07:19','/Login-001'),
(906,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 19:08:11','/Login-001'),
(907,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 19:08:52','/Login-001'),
(908,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 19:09:31','/Login-001'),
(909,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 19:10:05','/Login-001'),
(910,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 19:12:30','/Login-001'),
(911,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 19:21:13','/Login-001'),
(912,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-07 19:23:14','/Login-001'),
(913,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-08 15:32:08','/Login-001'),
(914,17,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-08 15:34:04','/Login-001'),
(915,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-08 15:35:17','/Login-001'),
(916,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-11 11:09:44','/Login-001'),
(917,17,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-11 11:10:08','/Login-001'),
(918,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-11 13:00:34','/Login-001'),
(919,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-12 10:07:27','/Login-001'),
(920,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-12 17:48:00','/Login-001'),
(921,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-12 19:51:11','/Login-001'),
(922,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-12 19:51:29','/Login-001'),
(923,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-12 19:51:41','/Login-001'),
(924,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-12 19:52:02','/Login-001'),
(925,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-12 19:53:54','/Login-001'),
(926,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-12 20:13:29','/Login-001'),
(927,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-12 20:24:21','/Login-001'),
(928,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-12 20:28:28','/Login-001'),
(929,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-12 21:32:43','/Login-001'),
(930,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-12 21:33:11','/Login-001'),
(931,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-12 21:33:47','/Login-001'),
(932,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-12 21:37:45','/Login-001'),
(933,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-12 21:44:26','/Login-001'),
(934,17,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-12 22:09:14','/Login-001'),
(935,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-15 22:30:13','/Login-001'),
(936,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-18 10:40:20','/Login-001'),
(937,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-18 14:59:46','/Login-001'),
(938,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-18 15:18:17','/Login-001'),
(939,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-18 15:21:47','/Login-001'),
(940,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-18 15:22:24','/Login-001'),
(941,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-18 15:23:34','/Login-001'),
(942,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-18 15:37:08','/Login-001'),
(943,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-18 15:39:37','/Login-001'),
(944,17,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-18 16:05:17','/Login-001'),
(945,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-18 16:08:08','/Login-001'),
(946,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-18 16:19:53','/Login-001'),
(947,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-18 16:21:02','/Login-001'),
(948,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-18 22:07:04','/Login-001'),
(949,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-18 22:20:39','/Login-001'),
(950,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-19 05:16:50','/Login-001'),
(951,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-19 05:20:05','/Login-001'),
(952,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-19 05:22:28','/Login-001'),
(953,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-19 09:01:37','/Login-001'),
(954,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 15:02:05','/Login-001'),
(955,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 15:06:16','/Login-001'),
(956,20,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 15:08:01','/Login-001'),
(957,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 18:40:53','/Login-001'),
(958,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 18:41:31','/Login-001'),
(959,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 18:42:43','/Login-001'),
(960,20,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 18:43:05','/Login-001'),
(961,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 18:43:17','/Login-001'),
(962,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 21:51:36','/Login-001'),
(963,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 22:03:18','/Login-001'),
(964,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 22:04:05','/Login-001'),
(965,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 22:07:00','/Login-001'),
(966,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 22:10:18','/Login-001'),
(967,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 22:10:47','/Login-001'),
(968,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 22:11:44','/Login-001'),
(969,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 22:13:46','/Login-001'),
(970,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-20 22:40:26','/Login-001'),
(971,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 08:24:40','/Login-001'),
(972,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 08:30:30','/Login-001'),
(973,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 08:39:19','/Login-001'),
(974,18,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 08:44:32','/Login-001'),
(975,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 08:45:43','/Login-001'),
(976,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 08:49:19','/Login-001'),
(977,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 08:51:51','/Login-001'),
(978,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 09:14:28','/Login-001'),
(979,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 09:16:02','/Login-001'),
(980,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 09:17:35','/Login-001'),
(981,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 09:22:01','/Login-001'),
(982,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 09:22:56','/Login-001'),
(983,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 09:30:21','/Login-001'),
(984,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 09:32:45','/Login-001'),
(985,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 10:10:03','/Login-001'),
(986,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 10:12:17','/Login-001'),
(987,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 10:13:16','/Login-001'),
(988,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 10:16:29','/Login-001'),
(989,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 10:17:25','/Login-001'),
(990,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 10:18:20','/Login-001'),
(991,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 10:18:38','/Login-001'),
(992,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 10:31:44','/Login-001'),
(993,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 10:32:20','/Login-001'),
(994,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 11:38:30','/Login-001'),
(995,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 11:41:18','/Login-001'),
(996,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 11:41:30','/Login-001'),
(997,20,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 14:58:45','/Login-001'),
(998,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 18:11:00','/Login-001'),
(999,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 18:34:33','/Login-001'),
(1000,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 18:35:02','/Login-001'),
(1001,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 18:37:13','/Login-001'),
(1002,23,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 19:12:09','/Login-001'),
(1003,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 19:14:42','/Login-001'),
(1004,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-21 19:16:55','/Login-001'),
(1005,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-22 11:01:07','/Login-001'),
(1006,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-25 10:44:50','/Login-001'),
(1007,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-25 18:02:42','/Login-001'),
(1008,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-25 18:04:13','/Login-001'),
(1009,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-25 18:29:22','/Login-001'),
(1010,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-25 18:29:43','/Login-001'),
(1011,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-25 19:21:57','/Login-001'),
(1012,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-25 19:48:42','/Login-001'),
(1013,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-25 19:59:39','/Login-001'),
(1014,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-25 19:59:41','/Login-001'),
(1015,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-25 20:01:04','/Login-001'),
(1016,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-25 23:46:56','/Login-001'),
(1017,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-25 23:47:42','/Login-001'),
(1018,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 07:17:24','/Login-001'),
(1019,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 07:17:33','/Login-001'),
(1020,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 07:17:47','/Login-001'),
(1021,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 07:20:36','/Login-001'),
(1022,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 07:21:41','/Login-001'),
(1023,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 07:21:51','/Login-001'),
(1024,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 09:21:17','/Login-001'),
(1025,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 09:26:38','/Login-001'),
(1026,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 09:29:09','/Login-001'),
(1027,23,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 09:30:03','/Login-001'),
(1028,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 10:02:21','/Login-001'),
(1029,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 10:03:27','/Login-001'),
(1030,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 10:25:16','/Login-001'),
(1031,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 16:26:55','/Login-001'),
(1032,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 16:28:20','/Login-001'),
(1033,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 16:29:19','/Login-001'),
(1034,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-26 16:30:55','/Login-001'),
(1035,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 00:54:25','/Login-001'),
(1036,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 00:55:24','/Login-001'),
(1037,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 01:13:55','/Login-001'),
(1038,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 01:15:37','/Login-001'),
(1039,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 08:54:27','/Login-001'),
(1040,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 09:07:29','/Login-001'),
(1041,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 09:08:47','/Login-001'),
(1042,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 09:11:24','/Login-001'),
(1043,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 09:12:51','/Login-001'),
(1044,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 09:22:20','/Login-001'),
(1045,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 09:23:20','/Login-001'),
(1046,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 09:24:17','/Login-001'),
(1047,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 09:25:08','/Login-001'),
(1048,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 09:32:10','/Login-001'),
(1049,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 09:59:47','/Login-001'),
(1050,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 10:04:39','/Login-001'),
(1051,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 10:23:29','/Login-001'),
(1052,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 10:33:03','/Login-001'),
(1053,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 11:51:26','/Login-001'),
(1054,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-04-27 12:01:16','/Login-001'),
(1055,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 12:07:40','/Login-001'),
(1056,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 12:08:07','/Login-001'),
(1057,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 12:12:20','/Login-001'),
(1058,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 12:12:54','/Login-001'),
(1059,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 12:19:38','/Login-001'),
(1060,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 12:23:40','/Login-001'),
(1061,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-02 14:08:38','/Login-001'),
(1062,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-13 11:05:36','/Login-001'),
(1063,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-13 12:31:04','/Login-001'),
(1064,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-13 12:31:30','/Login-001'),
(1065,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-13 12:31:52','/Login-001'),
(1066,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-13 12:32:24','/Login-001'),
(1067,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-05-18 20:19:38','/Login-001'),
(1068,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-01 08:53:15','/Login-001'),
(1069,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:05:01','/Login-001'),
(1070,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:16:24','/Login-001'),
(1071,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:32:40','/Login-001'),
(1072,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:33:00','/Login-001'),
(1073,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:36:09','/Login-001'),
(1074,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:36:27','/Login-001'),
(1075,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:38:06','/Login-001'),
(1076,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:39:03','/Login-001'),
(1077,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:39:11','/Login-001'),
(1078,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:39:21','/Login-001'),
(1079,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:39:38','/Login-001'),
(1080,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:41:46','/Login-001'),
(1081,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:41:56','/Login-001'),
(1082,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:42:13','/Login-001'),
(1083,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:42:22','/Login-001'),
(1084,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:42:31','/Login-001'),
(1085,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:42:50','/Login-001'),
(1086,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:42:58','/Login-001'),
(1087,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:43:31','/Login-001'),
(1088,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:45:09','/Login-001'),
(1089,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:45:17','/Login-001'),
(1090,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:45:29','/Login-001'),
(1091,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:45:38','/Login-001'),
(1092,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:45:59','/Login-001'),
(1093,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:46:46','/Login-001'),
(1094,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:47:16','/Login-001'),
(1095,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:47:31','/Login-001'),
(1096,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:50:12','/Login-001'),
(1097,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:50:28','/Login-001'),
(1098,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:51:54','/Login-001'),
(1099,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:53:05','/Login-001'),
(1100,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:53:42','/Login-001'),
(1101,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:54:15','/Login-001'),
(1102,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 17:58:02','/Login-001'),
(1103,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 18:00:37','/Login-001'),
(1104,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 18:02:36','/Login-001'),
(1105,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 18:05:23','/Login-001'),
(1106,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 18:15:57','/Login-001'),
(1107,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 18:16:47','/Login-001'),
(1108,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 18:25:23','/Login-001'),
(1109,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 19:07:28','/Login-001'),
(1110,23,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-02 19:13:12','/Login-001'),
(1111,23,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 09:41:05','/Login-001'),
(1112,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 09:42:24','/Login-001'),
(1113,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 10:00:39','/Login-001'),
(1114,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 10:00:53','/Login-001'),
(1115,23,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 10:33:51','/Login-001'),
(1116,23,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 10:34:11','/Login-001'),
(1117,23,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 10:38:11','/Login-001'),
(1118,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 10:39:33','/Login-001'),
(1119,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 12:05:45','/Login-001'),
(1120,23,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 12:49:35','/Login-001'),
(1121,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 12:54:10','/Login-001'),
(1122,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 12:54:21','/Login-001'),
(1123,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 12:54:33','/Login-001'),
(1124,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 12:55:31','/Login-001'),
(1125,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 12:58:43','/Login-001'),
(1126,23,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 13:09:46','/Login-001'),
(1127,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 14:28:39','/Login-001'),
(1128,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 14:36:56','/Login-001'),
(1129,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 16:30:37','/Login-001'),
(1130,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 16:39:46','/Login-001'),
(1131,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 16:46:28','/Login-001'),
(1132,23,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 16:46:30','/Login-001'),
(1133,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 16:46:38','/Login-001'),
(1134,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 16:47:23','/Login-001'),
(1135,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 16:57:04','/Login-001'),
(1136,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 16:57:13','/Login-001'),
(1137,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 16:57:29','/Login-001'),
(1138,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 16:58:05','/Login-001'),
(1139,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 16:58:38','/Login-001'),
(1140,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:00:02','/Login-001'),
(1141,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:00:12','/Login-001'),
(1142,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:00:43','/Login-001'),
(1143,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:00:55','/Login-001'),
(1144,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:05:00','/Login-001'),
(1145,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:05:15','/Login-001'),
(1146,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:05:35','/Login-001'),
(1147,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:11:54','/Login-001'),
(1148,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:16:18','/Login-001'),
(1149,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:24:27','/Login-001'),
(1150,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:24:50','/Login-001'),
(1151,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:27:30','/Login-001'),
(1152,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:27:43','/Login-001'),
(1153,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:29:34','/Login-001'),
(1154,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:48:08','/Login-001'),
(1155,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:50:01','/Login-001'),
(1156,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:53:38','/Login-001'),
(1157,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:55:57','/Login-001'),
(1158,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 17:56:27','/Login-001'),
(1159,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 18:26:10','/Login-001'),
(1160,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 18:34:51','/Login-001'),
(1161,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 19:05:58','/Login-001'),
(1162,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 19:06:11','/Login-001'),
(1163,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 19:06:25','/Login-001'),
(1164,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 19:06:51','/Login-001'),
(1165,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 19:07:04','/Login-001'),
(1166,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 19:07:21','/Login-001'),
(1167,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 19:07:52','/Login-001'),
(1168,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 19:08:07','/Login-001'),
(1169,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 19:08:28','/Login-001'),
(1170,24,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-03 19:40:42','/Login-001'),
(1171,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-03 19:43:56','/Login-001'),
(1172,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-03 20:08:43','/Login-001'),
(1173,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-03 20:45:02','/Login-001'),
(1174,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-03 21:46:00','/Login-001'),
(1175,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-03 21:52:14','/Login-001'),
(1176,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-03 21:57:09','/Login-001'),
(1177,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-04 19:55:29','/Login-001'),
(1178,18,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-04 20:16:57','/Login-001'),
(1179,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-04 20:19:23','/Login-001'),
(1180,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-04 20:35:26','/Login-001'),
(1181,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-04 21:32:11','/Login-001'),
(1182,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-04 22:04:14','/Login-001'),
(1183,16,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-04 22:04:41','/Login-001'),
(1184,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-04 22:05:37','/Login-001'),
(1185,16,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-04 22:09:37','/Login-001'),
(1186,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-04 22:43:01','/Login-001'),
(1187,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-04 22:43:34','/Login-001'),
(1188,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-04 22:44:41','/Login-001'),
(1189,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-04 22:49:15','/Login-001'),
(1190,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-04 22:50:11','/Login-001'),
(1191,16,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-04 22:51:27','/Login-001'),
(1192,16,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-04 22:52:00','/Login-001'),
(1193,16,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-04 22:52:42','/Login-001'),
(1194,16,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-04 22:54:15','/Login-001'),
(1195,16,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-04 23:40:51','/Login-001'),
(1196,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-05 00:52:43','/Login-001'),
(1197,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-05 01:14:20','/Login-001'),
(1198,14,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-05 01:44:12','/Login-001'),
(1199,14,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-05 01:45:16','/Login-001'),
(1200,16,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-05 01:47:48','/Login-001'),
(1201,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-06 13:07:11','/Login-001'),
(1202,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-06 13:20:40','/Login-001'),
(1203,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-06 14:34:33','/Login-001'),
(1204,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-06 15:06:38','/Login-001'),
(1205,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-06 15:12:18','/Login-001'),
(1206,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-06 15:31:33','/Login-001'),
(1207,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-06 16:12:49','/Login-001'),
(1208,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-06 18:12:59','/Login-001'),
(1209,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-06 21:12:04','/Login-001'),
(1210,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-06 21:17:10','/Login-001'),
(1211,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-06 21:18:35','/Login-001'),
(1212,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-06 23:32:26','/Login-001'),
(1213,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-07 07:08:06','/Login-001'),
(1214,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-07 08:23:11','/Login-001'),
(1215,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-07 09:22:08','/Login-001'),
(1216,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-07 10:48:12','/Login-001'),
(1217,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-07 11:13:11','/Login-001'),
(1218,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-07 11:14:22','/Login-001'),
(1219,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-07 11:56:00','/Login-001'),
(1220,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-07 11:56:17','/Login-001'),
(1221,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-07 11:59:29','/Login-001'),
(1222,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 01:40:09','/Login-001'),
(1223,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 07:03:39','/Login-001'),
(1224,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 07:12:46','/Login-001'),
(1225,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 07:38:34','/Login-001'),
(1226,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 07:48:34','/Login-001'),
(1227,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 08:20:40','/Login-001'),
(1228,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-08 08:21:23','/Login-001'),
(1229,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 08:22:03','/Login-001'),
(1230,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-08 08:31:19','/Login-001'),
(1231,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-08 08:31:53','/Login-001'),
(1232,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 08:45:29','/Login-001'),
(1233,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 09:15:46','/Login-001'),
(1234,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 09:44:02','/Login-001'),
(1235,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 09:44:22','/Login-001'),
(1236,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 09:45:34','/Login-001'),
(1237,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 09:46:14','/Login-001'),
(1238,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 09:46:22','/Login-001'),
(1239,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 09:46:48','/Login-001'),
(1240,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 10:05:10','/Login-001'),
(1241,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 10:12:13','/Login-001'),
(1242,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 10:13:51','/Login-001'),
(1243,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 10:14:38','/Login-001'),
(1244,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-08 10:17:53','/Login-001'),
(1245,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 10:20:34','/Login-001'),
(1246,14,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-08 10:27:05','/Login-001'),
(1247,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 10:28:11','/Login-001'),
(1248,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 10:28:18','/Login-001'),
(1249,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 10:31:05','/Login-001'),
(1250,14,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-08 10:34:28','/Login-001'),
(1251,14,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-08 10:34:51','/Login-001'),
(1252,14,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-08 10:35:33','/Login-001'),
(1253,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 10:35:45','/Login-001'),
(1254,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 10:36:26','/Login-001'),
(1255,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 10:58:11','/Login-001'),
(1256,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 10:58:28','/Login-001'),
(1257,14,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-08 11:02:48','/Login-001'),
(1258,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-08 12:29:20','/Login-001'),
(1259,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 12:58:55','/Login-001'),
(1260,14,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-08 13:51:47','/Login-001'),
(1261,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 22:44:34','/Login-001'),
(1262,4,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-08 23:49:07','/Login-001'),
(1263,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-09 08:45:08','/Login-001'),
(1264,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-09 08:55:29','/Login-001'),
(1265,14,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-09 13:37:00','/Login-001'),
(1266,14,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-09 13:46:01','/Login-001'),
(1267,14,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-09 13:49:56','/Login-001'),
(1268,14,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-09 15:34:51','/Login-001'),
(1269,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-09 15:35:06','/Login-001'),
(1270,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-09 15:35:21','/Login-001'),
(1271,14,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-09 15:50:24','/Login-001'),
(1272,14,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-09 15:50:44','/Login-001'),
(1273,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-09 17:27:11','/Login-001'),
(1274,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-09 17:52:24','/Login-001'),
(1275,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-09 20:05:10','/Login-001'),
(1276,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-09 20:13:47','/Login-001'),
(1277,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-09 20:16:48','/Login-001'),
(1278,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-09 20:26:19','/Login-001'),
(1279,14,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-09 20:26:49','/Login-001'),
(1280,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-09 20:30:26','/Login-001'),
(1281,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-10 08:42:20','/Login-001'),
(1282,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-10 08:49:24','/Login-001'),
(1283,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-10 09:47:56','/Login-001'),
(1284,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-10 10:18:14','/Login-001'),
(1285,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-10 10:19:58','/Login-001'),
(1286,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-10 10:20:19','/Login-001'),
(1287,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-10 10:27:01','/Login-001'),
(1288,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-10 11:02:46','/Login-001'),
(1289,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-10 11:05:22','/Login-001'),
(1290,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-10 11:20:58','/Login-001'),
(1291,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-10 12:47:05','/Login-001'),
(1292,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-10 13:03:18','/Login-001'),
(1293,14,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-10 14:04:52','/Login-001'),
(1294,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-13 14:51:09','/Login-001'),
(1295,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-13 14:51:09','/Login-001'),
(1296,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-13 14:51:13','/Login-001'),
(1297,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-13 14:57:17','/Login-001'),
(1298,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-13 15:17:38','/Login-001'),
(1299,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-13 15:43:25','/Login-001'),
(1300,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-13 15:45:12','/Login-001'),
(1301,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-13 15:58:44','/Login-001'),
(1302,24,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-13 16:01:16','/Login-001'),
(1303,24,'JASCRIPT','WL12','{SHA-1}Myo+Ot426/CKNFonDDGwGAqwz5M=','2022-06-13 16:04:05','/Login-001'),
(1304,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-13 16:04:57','/Login-001'),
(1305,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-13 16:09:41','/Login-001'),
(1306,4,'JASCRIPT','WL12','{SHA-1}mo027FjZY1KZxZfVr42TwXzpNaw=','2022-06-13 23:44:30','/Login-001'),
(1307,4,'JASCRIPT','WL12','{SHA-1}mo027FjZY1KZxZfVr42TwXzpNaw=','2022-06-13 23:47:45','/Login-001'),
(1308,4,'JASCRIPT','WL12','{SHA-1}2vqO9dc5Tiqz/DKNY9e/uWrc1sI=','2022-06-13 23:59:14','/Login-001'),
(1309,4,'JASCRIPT','WL12','{SHA-1}2vqO9dc5Tiqz/DKNY9e/uWrc1sI=','2022-06-14 00:02:12','/Login-001'),
(1310,4,'JASCRIPT','WL12','{SHA-1}2vqO9dc5Tiqz/DKNY9e/uWrc1sI=','2022-06-14 00:07:00','/Login-001'),
(1311,4,'JASCRIPT','WL12','{SHA-1}uuOKwo7p3uEgpzf3sdKueGRbUnY=','2022-06-14 00:18:58','/Login-001'),
(1312,4,'JASCRIPT','WL12','{SHA-1}uuOKwo7p3uEgpzf3sdKueGRbUnY=','2022-06-14 00:28:11','/Login-001'),
(1313,4,'JASCRIPT','WL12','{SHA-1}uuOKwo7p3uEgpzf3sdKueGRbUnY=','2022-06-14 00:29:56','/Login-001'),
(1314,4,'JASCRIPT','WL12','{SHA-1}uuOKwo7p3uEgpzf3sdKueGRbUnY=','2022-06-14 00:36:20','/Login-001'),
(1315,4,'JASCRIPT','WL12','{SHA-1}uuOKwo7p3uEgpzf3sdKueGRbUnY=','2022-06-14 01:17:08','/Login-001'),
(1316,4,'JASCRIPT','WL12','{SHA-1}uuOKwo7p3uEgpzf3sdKueGRbUnY=','2022-06-14 01:21:21','/Login-001'),
(1317,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 01:22:31','/Login-001'),
(1318,13,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 01:29:12','/Login-001'),
(1319,4,'JASCRIPT','WL12','{SHA-1}uuOKwo7p3uEgpzf3sdKueGRbUnY=','2022-06-14 01:30:31','/Login-001'),
(1320,16,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-14 12:49:02','/Login-001'),
(1321,16,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-14 12:50:19','/Login-001'),
(1322,16,'JASCRIPT','WL12','{SHA-1}Myo+Ot426/CKNFonDDGwGAqwz5M=','2022-06-14 12:51:37','/Login-001'),
(1323,16,'JASCRIPT','WL12','{SHA-1}Myo+Ot426/CKNFonDDGwGAqwz5M=','2022-06-14 12:53:18','/Login-001'),
(1324,16,'JASCRIPT','WL12','{SHA-1}Myo+Ot426/CKNFonDDGwGAqwz5M=','2022-06-14 12:53:54','/Login-001'),
(1325,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 12:54:14','/Login-001'),
(1326,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 14:08:54','/Login-001'),
(1327,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 14:21:12','/Login-001'),
(1328,24,'JASCRIPT','WL12','{SHA-1}Myo+Ot426/CKNFonDDGwGAqwz5M=','2022-06-14 14:29:05','/Login-001'),
(1329,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 14:32:35','/Login-001'),
(1330,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 14:33:08','/Login-001'),
(1331,20,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 14:34:16','/Login-001'),
(1332,20,'JASCRIPT','WL12','{SHA-1}g60WY4lSFDFtWISMX/1S+7wuG0Y=','2022-06-14 14:38:54','/Login-001'),
(1333,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 14:39:41','/Login-001'),
(1334,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 14:43:48','/Login-001'),
(1335,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 14:44:43','/Login-001'),
(1336,20,'JASCRIPT','WL12','{SHA-1}g60WY4lSFDFtWISMX/1S+7wuG0Y=','2022-06-14 14:44:43','/Login-001'),
(1337,24,'JASCRIPT','WL12','{SHA-1}Myo+Ot426/CKNFonDDGwGAqwz5M=','2022-06-14 14:45:32','/Login-001'),
(1338,24,'JASCRIPT','WL12','{SHA-1}Myo+Ot426/CKNFonDDGwGAqwz5M=','2022-06-14 14:46:03','/Login-001'),
(1339,27,'JASCRIPT','WL12','{SHA-1}JQEpLO0Rmf7U0f+kpkswOSCopxQ=','2022-06-14 14:46:06','/Login-001'),
(1340,27,'JASCRIPT','WL12','{SHA-1}JQEpLO0Rmf7U0f+kpkswOSCopxQ=','2022-06-14 14:47:47','/Login-001'),
(1341,20,'JASCRIPT','WL12','{SHA-1}g60WY4lSFDFtWISMX/1S+7wuG0Y=','2022-06-14 14:49:31','/Login-001'),
(1342,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 14:52:53','/Login-001'),
(1343,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 14:54:38','/Login-001'),
(1344,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 14:56:26','/Login-001'),
(1345,16,'JASCRIPT','WL12','{SHA-1}AiZ2kq97cW4NLVac7eVYUZxzLMc=','2022-06-14 15:02:04','/Login-001'),
(1346,16,'JASCRIPT','WL12','{SHA-1}AiZ2kq97cW4NLVac7eVYUZxzLMc=','2022-06-14 15:04:59','/Login-001'),
(1347,16,'JASCRIPT','WL12','{SHA-1}AiZ2kq97cW4NLVac7eVYUZxzLMc=','2022-06-14 15:08:45','/Login-001'),
(1348,16,'JASCRIPT','WL12','{SHA-1}AiZ2kq97cW4NLVac7eVYUZxzLMc=','2022-06-14 15:18:41','/Login-001'),
(1349,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 15:29:04','/Login-001'),
(1350,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 15:30:18','/Login-001'),
(1351,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 15:30:41','/Login-001'),
(1352,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 15:30:57','/Login-001'),
(1353,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 15:58:09','/Login-001'),
(1354,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 16:01:38','/Login-001'),
(1355,4,'JASCRIPT','WL12','{SHA-1}hZk4qREsInng9lFgqF4lyjim+qU=','2022-06-14 17:53:46','/Login-001'),
(1356,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-14 17:54:19','/Login-001'),
(1357,16,'JASCRIPT','WL12','{SHA-1}3EfYeN4fCC41DAT2Dq4OMHLxcKE=','2022-06-14 18:19:17','/Login-001'),
(1358,16,'JASCRIPT','WL12','{SHA-1}oEQ16/weLnvQLCRXk+bxZoEPF6o=','2022-06-14 18:19:55','/Login-001'),
(1359,16,'JASCRIPT','WL12','{SHA-1}9MceCOmCWnMs0lQ9LCzq38sBNvU=','2022-06-14 18:20:25','/Login-001'),
(1360,16,'JASCRIPT','WL12','{SHA-1}fQqse0am9LWKBjRL4nJDEr7OIXI=','2022-06-14 18:33:00','/Login-001'),
(1361,16,'JASCRIPT','WL12','{SHA-1}ZrOuqh5XixMLw5VXYTiojqMV+Zs=','2022-06-14 18:42:27','/Login-001'),
(1362,24,'JASCRIPT','WL12','{SHA-1}Myo+Ot426/CKNFonDDGwGAqwz5M=','2022-06-14 18:43:45','/Login-001'),
(1363,16,'JASCRIPT','WL12','{SHA-1}ZrOuqh5XixMLw5VXYTiojqMV+Zs=','2022-06-14 18:44:52','/Login-001'),
(1364,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 19:15:48','/Login-001'),
(1365,16,'JASCRIPT','WL12','{SHA-1}TlDuFgkmEoRHm6RZ5EKZsaGsbWQ=','2022-06-14 19:17:28','/Login-001'),
(1366,16,'JASCRIPT','WL12','{SHA-1}TlDuFgkmEoRHm6RZ5EKZsaGsbWQ=','2022-06-14 19:18:08','/Login-001'),
(1367,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 19:18:48','/Login-001'),
(1368,16,'JASCRIPT','WL12','{SHA-1}TlDuFgkmEoRHm6RZ5EKZsaGsbWQ=','2022-06-14 19:19:27','/Login-001'),
(1369,16,'JASCRIPT','WL12','{SHA-1}TlDuFgkmEoRHm6RZ5EKZsaGsbWQ=','2022-06-14 19:19:51','/Login-001'),
(1370,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 19:20:11','/Login-001'),
(1371,16,'JASCRIPT','WL12','{SHA-1}TlDuFgkmEoRHm6RZ5EKZsaGsbWQ=','2022-06-14 19:20:49','/Login-001'),
(1372,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 19:21:20','/Login-001'),
(1373,4,'JASCRIPT','WL12','{SHA-1}cGSIu32SwIlOxE1DzbjHGmHmBkE=','2022-06-14 19:29:15','/Login-001'),
(1374,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-14 19:29:53','/Login-001'),
(1375,21,'JASCRIPT','WL12','{SHA-1}qd0ZYKOuQJ/uO9lSSgR1SLRtAAQ=','2022-06-14 19:33:20','/Login-001'),
(1376,21,'JASCRIPT','WL12','{SHA-1}K5e2pmHRg939OSjOSh2AjfoQ58A=','2022-06-14 19:34:04','/Login-001'),
(1377,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 19:42:29','/Login-001'),
(1378,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-14 19:48:55','/Login-001'),
(1379,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-14 20:02:28','/Login-001'),
(1380,4,'JASCRIPT','WL12','{SHA-1}nTNKQMDptExZ4pj8qDhJmsBdkZc=','2022-06-14 21:08:02','/Login-001'),
(1381,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-14 21:11:40','/Login-001'),
(1382,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-14 21:15:33','/Login-001'),
(1383,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-14 21:40:50','/Login-001'),
(1384,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-14 22:05:21','/Login-001'),
(1385,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 22:16:44','/Login-001'),
(1386,15,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-14 22:18:50','/Login-001'),
(1387,16,'JASCRIPT','WL12','{SHA-1}2YfPZIpFT9D0JsppFvRtXw1KIzw=','2022-06-14 22:21:34','/Login-001'),
(1388,16,'JASCRIPT','WL12','{SHA-1}2YfPZIpFT9D0JsppFvRtXw1KIzw=','2022-06-14 22:22:17','/Login-001'),
(1389,16,'JASCRIPT','WL12','{SHA-1}2YfPZIpFT9D0JsppFvRtXw1KIzw=','2022-06-14 22:23:31','/Login-001'),
(1390,15,'JASCRIPT','WL12','{SHA-1}hSOytCkLdj6n9qHvDbaEFMw7rgA=','2022-06-14 22:25:24','/Login-001'),
(1391,15,'JASCRIPT','WL12','{SHA-1}hSOytCkLdj6n9qHvDbaEFMw7rgA=','2022-06-14 22:25:30','/Login-001'),
(1392,15,'JASCRIPT','WL12','{SHA-1}wtViWQn50GeYZGAPmYz9XyxeknI=','2022-06-14 22:25:59','/Login-001'),
(1393,16,'JASCRIPT','WL12','{SHA-1}2YfPZIpFT9D0JsppFvRtXw1KIzw=','2022-06-14 22:32:48','/Login-001'),
(1394,16,'JASCRIPT','WL12','{SHA-1}2YfPZIpFT9D0JsppFvRtXw1KIzw=','2022-06-14 22:35:06','/Login-001'),
(1395,16,'JASCRIPT','WL12','{SHA-1}LQ3hjpU+VJDQ0+1zwqL1AdmAWxI=','2022-06-14 22:36:49','/Login-001'),
(1396,16,'JASCRIPT','WL12','{SHA-1}LQ3hjpU+VJDQ0+1zwqL1AdmAWxI=','2022-06-14 22:39:36','/Login-001'),
(1397,16,'JASCRIPT','WL12','{SHA-1}LQ3hjpU+VJDQ0+1zwqL1AdmAWxI=','2022-06-14 22:44:17','/Login-001'),
(1398,16,'JASCRIPT','WL12','{SHA-1}LQ3hjpU+VJDQ0+1zwqL1AdmAWxI=','2022-06-14 22:56:36','/Login-001'),
(1399,16,'JASCRIPT','WL12','{SHA-1}LQ3hjpU+VJDQ0+1zwqL1AdmAWxI=','2022-06-14 22:58:59','/Login-001'),
(1400,16,'JASCRIPT','WL12','{SHA-1}LQ3hjpU+VJDQ0+1zwqL1AdmAWxI=','2022-06-14 23:12:51','/Login-001'),
(1401,20,'JASCRIPT','WL12','{SHA-1}g60WY4lSFDFtWISMX/1S+7wuG0Y=','2022-06-15 09:12:03','/Login-001'),
(1402,16,'JASCRIPT','WL12','{SHA-1}66FC1r3COiN3XtUHQSayhEE+NXU=','2022-06-15 09:13:16','/Login-001'),
(1403,16,'JASCRIPT','WL12','{SHA-1}ZrOuqh5XixMLw5VXYTiojqMV+Zs=','2022-06-15 09:14:44','/Login-001'),
(1404,16,'JASCRIPT','WL12','{SHA-1}ZrOuqh5XixMLw5VXYTiojqMV+Zs=','2022-06-15 09:15:05','/Login-001'),
(1405,16,'JASCRIPT','WL12','{SHA-1}D8ZD0b2GPjDhz+LLJrUY+qyy9Dc=','2022-06-15 09:16:44','/Login-001'),
(1406,16,'JASCRIPT','WL12','{SHA-1}SRoaI4H4d5ylkNucmf4AaMRtJS8=','2022-06-15 09:19:37','/Login-001'),
(1407,16,'JASCRIPT','WL12','{SHA-1}sVJNx0t9yz9ajZwBGSuGB9bQ5gQ=','2022-06-15 09:21:16','/Login-001'),
(1408,16,'JASCRIPT','WL12','{SHA-1}PUTyR7cH5NUaWtRVAEM+0ZXqIQk=','2022-06-15 09:24:57','/Login-001'),
(1409,20,'JASCRIPT','WL12','{SHA-1}g60WY4lSFDFtWISMX/1S+7wuG0Y=','2022-06-15 09:26:31','/Login-001'),
(1410,20,'JASCRIPT','WL12','{SHA-1}g60WY4lSFDFtWISMX/1S+7wuG0Y=','2022-06-15 09:27:47','/Login-001'),
(1411,20,'JASCRIPT','WL12','{SHA-1}g60WY4lSFDFtWISMX/1S+7wuG0Y=','2022-06-15 10:13:28','/Login-001'),
(1412,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-15 11:42:52','/Login-001'),
(1413,32,'JASCRIPT','WL12','{SHA-1}prjykCkr0L8BK57kkeeWsrJioGw=','2022-06-15 13:13:11','/Login-001'),
(1414,24,'JASCRIPT','WL12','{SHA-1}Myo+Ot426/CKNFonDDGwGAqwz5M=','2022-06-15 13:16:19','/Login-001'),
(1415,32,'JASCRIPT','WL12','{SHA-1}sVJNx0t9yz9ajZwBGSuGB9bQ5gQ=','2022-06-15 13:16:23','/Login-001'),
(1416,32,'JASCRIPT','WL12','{SHA-1}sVJNx0t9yz9ajZwBGSuGB9bQ5gQ=','2022-06-15 13:17:51','/Login-001'),
(1417,32,'JASCRIPT','WL12','{SHA-1}sVJNx0t9yz9ajZwBGSuGB9bQ5gQ=','2022-06-15 13:35:49','/Login-001'),
(1418,4,'JASCRIPT','WL12','{SHA-1}+Wv8b3k2VrMCgczXbsS4RTdavFg=','2022-06-15 15:47:08','/Login-001'),
(1419,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-15 15:47:38','/Login-001'),
(1420,16,'JASCRIPT','WL12','{SHA-1}wJMWa7RQdi54v114d9BsqeEqR7Q=','2022-06-15 16:09:03','/Login-001'),
(1421,16,'JASCRIPT','WL12','{SHA-1}Wj7GimoqINWYR0A+BhfS6qFxsL0=','2022-06-15 16:12:22','/Login-001'),
(1422,4,'JASCRIPT','WL12','{SHA-1}8laz/ZVeMD2leTdoueugjjk7Drw=','2022-06-15 16:15:32','/Login-001'),
(1423,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-15 16:15:57','/Login-001'),
(1424,32,'JASCRIPT','WL12','{SHA-1}SOv9KLRjJYpJUjUl1EG2731djvU=','2022-06-15 17:06:03','/Login-001'),
(1425,32,'JASCRIPT','WL12','{SHA-1}aRpx52lv1pMrcNoaOqaiW8hlEpY=','2022-06-15 17:07:36','/Login-001'),
(1426,32,'JASCRIPT','WL12','{SHA-1}aRpx52lv1pMrcNoaOqaiW8hlEpY=','2022-06-15 17:11:38','/Login-001'),
(1427,24,'JASCRIPT','WL12','{SHA-1}Myo+Ot426/CKNFonDDGwGAqwz5M=','2022-06-15 17:14:04','/Login-001'),
(1428,16,'JASCRIPT','WL12','{SHA-1}rZXIAEckEIse8Oawp1wMwtZtVQs=','2022-06-15 17:14:46','/Login-001'),
(1429,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-15 17:15:16','/Login-001'),
(1430,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-15 17:18:04','/Login-001'),
(1431,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-15 17:18:57','/Login-001'),
(1432,26,'JASCRIPT','WL12','{SHA-1}JFfkP9j3oTNlfpKgDTc6UUCWnPI=','2022-06-15 17:21:48','/Login-001'),
(1433,26,'JASCRIPT','WL12','{SHA-1}ay5k2rP8qKzE2/yMAv1KIJhmncw=','2022-06-15 17:22:19','/Login-001'),
(1434,26,'JASCRIPT','WL12','{SHA-1}ay5k2rP8qKzE2/yMAv1KIJhmncw=','2022-06-15 17:23:10','/Login-001'),
(1435,27,'JASCRIPT','WL12','{SHA-1}Dewe3SvSqpJ1evjKCTGHs1Ljj9A=','2022-06-15 17:32:03','/Login-001'),
(1436,27,'JASCRIPT','WL12','{SHA-1}lxpePwTKLIr5+lj05u2oD0YA1H8=','2022-06-15 17:32:38','/Login-001'),
(1437,30,'JASCRIPT','WL12','{SHA-1}phRsbP7trdfR1G+xiDvT34eEXS4=','2022-06-15 17:37:54','/Login-001'),
(1438,30,'JASCRIPT','WL12','{SHA-1}bloETWng2AIAc9bNWGdbT8B1gZ8=','2022-06-15 17:38:18','/Login-001'),
(1439,30,'JASCRIPT','WL12','{SHA-1}bloETWng2AIAc9bNWGdbT8B1gZ8=','2022-06-15 17:39:21','/Login-001'),
(1440,31,'JASCRIPT','WL12','{SHA-1}BAQC4vCk1O9OL5L7BVKUJ76avxM=','2022-06-15 17:42:05','/Login-001'),
(1441,31,'JASCRIPT','WL12','{SHA-1}BAQC4vCk1O9OL5L7BVKUJ76avxM=','2022-06-15 17:45:05','/Login-001'),
(1442,31,'JASCRIPT','WL12','{SHA-1}BAQC4vCk1O9OL5L7BVKUJ76avxM=','2022-06-15 19:19:25','/Login-001'),
(1443,31,'JASCRIPT','WL12','{SHA-1}TUypwiHvd0OMkwrA7BJT+zHQwGo=','2022-06-15 19:20:10','/Login-001'),
(1444,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-15 19:24:33','/Login-001'),
(1445,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-15 20:03:13','/Login-001'),
(1446,15,'JASCRIPT','WL12','{SHA-1}fpdMi0TOXKb0dsN3Q5PbZEhgJNg=','2022-06-15 20:06:25','/Login-001'),
(1447,15,'JASCRIPT','WL12','{SHA-1}cjC7lPayA+LHdUfU6CXXxkDmzto=','2022-06-15 20:07:22','/Login-001'),
(1448,15,'JASCRIPT','WL12','{SHA-1}cjC7lPayA+LHdUfU6CXXxkDmzto=','2022-06-15 20:08:10','/Login-001'),
(1449,29,'JASCRIPT','WL12','{SHA-1}TrawxVFWN75hILGKsY7t3eqx7sQ=','2022-06-15 20:08:15','/Login-001'),
(1450,29,'JASCRIPT','WL12','{SHA-1}TrawxVFWN75hILGKsY7t3eqx7sQ=','2022-06-15 20:09:36','/Login-001'),
(1451,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-06-15 20:10:11','/Login-001'),
(1452,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-06-15 20:13:19','/Login-001'),
(1453,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-06-15 20:13:55','/Login-001'),
(1454,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-06-15 20:15:26','/Login-001'),
(1455,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-15 20:16:14','/Login-001'),
(1456,15,'JASCRIPT','WL12','{SHA-1}cjC7lPayA+LHdUfU6CXXxkDmzto=','2022-06-15 20:16:30','/Login-001'),
(1457,24,'JASCRIPT','WL12','{SHA-1}Myo+Ot426/CKNFonDDGwGAqwz5M=','2022-06-15 20:16:32','/Login-001'),
(1458,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-06-15 20:17:50','/Login-001'),
(1459,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-15 20:19:31','/Login-001'),
(1460,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-15 20:20:29','/Login-001'),
(1461,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-15 20:21:09','/Login-001'),
(1462,15,'JASCRIPT','WL12','{SHA-1}cjC7lPayA+LHdUfU6CXXxkDmzto=','2022-06-15 20:21:42','/Login-001'),
(1463,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-15 20:23:43','/Login-001'),
(1464,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-15 20:26:26','/Login-001'),
(1465,15,'JASCRIPT','WL12','{SHA-1}cjC7lPayA+LHdUfU6CXXxkDmzto=','2022-06-15 20:29:03','/Login-001'),
(1466,15,'JASCRIPT','WL12','{SHA-1}cjC7lPayA+LHdUfU6CXXxkDmzto=','2022-06-15 20:33:21','/Login-001'),
(1467,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-15 20:40:39','/Login-001'),
(1468,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-06-15 20:45:15','/Login-001'),
(1469,15,'JASCRIPT','WL12','{SHA-1}cjC7lPayA+LHdUfU6CXXxkDmzto=','2022-06-15 20:46:42','/Login-001'),
(1470,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-06-15 20:48:29','/Login-001'),
(1471,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-06-15 20:48:55','/Login-001'),
(1472,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-15 20:50:21','/Login-001'),
(1473,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-15 20:50:55','/Login-001'),
(1474,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-06-15 20:52:26','/Login-001'),
(1475,14,'JASCRIPT','WL12','{SHA-1}wPRE8/ciyMgOHuiPeC7wWCaWvI0=','2022-06-15 21:01:24','/Login-001'),
(1476,14,'JASCRIPT','WL12','{SHA-1}wPRE8/ciyMgOHuiPeC7wWCaWvI0=','2022-06-15 21:01:47','/Login-001'),
(1477,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-15 21:02:23','/Login-001'),
(1478,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-15 21:04:43','/Login-001'),
(1479,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-15 21:05:43','/Login-001'),
(1480,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-15 21:06:13','/Login-001'),
(1481,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-15 21:07:03','/Login-001'),
(1482,20,'JASCRIPT','WL12','{SHA-1}fOjm9E9x4zCbbfWNGCKjCwKfpys=','2022-06-15 21:17:35','/Login-001'),
(1483,20,'JASCRIPT','WL12','{SHA-1}7nAuxIj7eudN67w1vGiNdmZdyUU=','2022-06-15 21:19:20','/Login-001'),
(1484,20,'JASCRIPT','WL12','{SHA-1}7nAuxIj7eudN67w1vGiNdmZdyUU=','2022-06-16 08:42:00','/Login-001'),
(1485,32,'JASCRIPT','WL12','{SHA-1}aRpx52lv1pMrcNoaOqaiW8hlEpY=','2022-06-16 08:48:00','/Login-001'),
(1486,32,'JASCRIPT','WL12','{SHA-1}aRpx52lv1pMrcNoaOqaiW8hlEpY=','2022-06-16 08:50:04','/Login-001'),
(1487,32,'JASCRIPT','WL12','{SHA-1}aRpx52lv1pMrcNoaOqaiW8hlEpY=','2022-06-16 08:53:20','/Login-001'),
(1488,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-16 08:58:08','/Login-001'),
(1489,26,'JASCRIPT','WL12','{SHA-1}ay5k2rP8qKzE2/yMAv1KIJhmncw=','2022-06-16 09:06:44','/Login-001'),
(1490,31,'JASCRIPT','WL12','{SHA-1}TUypwiHvd0OMkwrA7BJT+zHQwGo=','2022-06-16 09:07:05','/Login-001'),
(1491,26,'JASCRIPT','WL12','{SHA-1}ay5k2rP8qKzE2/yMAv1KIJhmncw=','2022-06-16 09:09:35','/Login-001'),
(1492,27,'JASCRIPT','WL12','{SHA-1}lxpePwTKLIr5+lj05u2oD0YA1H8=','2022-06-16 09:11:04','/Login-001'),
(1493,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-16 09:11:10','/Login-001'),
(1494,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-16 09:13:58','/Login-001'),
(1495,31,'JASCRIPT','WL12','{SHA-1}TUypwiHvd0OMkwrA7BJT+zHQwGo=','2022-06-16 09:15:04','/Login-001'),
(1496,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-16 09:15:05','/Login-001'),
(1497,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-16 09:24:02','/Login-001'),
(1498,15,'JASCRIPT','WL12','{SHA-1}cjC7lPayA+LHdUfU6CXXxkDmzto=','2022-06-16 09:37:35','/Login-001'),
(1499,32,'JASCRIPT','WL12','{SHA-1}aRpx52lv1pMrcNoaOqaiW8hlEpY=','2022-06-16 09:50:17','/Login-001'),
(1500,32,'JASCRIPT','WL12','{SHA-1}aRpx52lv1pMrcNoaOqaiW8hlEpY=','2022-06-16 10:41:52','/Login-001'),
(1501,20,'JASCRIPT','WL12','{SHA-1}7nAuxIj7eudN67w1vGiNdmZdyUU=','2022-06-16 10:54:33','/Login-001'),
(1502,20,'JASCRIPT','WL12','{SHA-1}7nAuxIj7eudN67w1vGiNdmZdyUU=','2022-06-16 11:50:23','/Login-001'),
(1503,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-06-16 11:52:18','/Login-001'),
(1504,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-16 11:54:03','/Login-001'),
(1505,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-06-16 13:05:40','/Login-001'),
(1506,31,'JASCRIPT','WL12','{SHA-1}TUypwiHvd0OMkwrA7BJT+zHQwGo=','2022-06-16 15:26:30','/Login-001'),
(1507,31,'JASCRIPT','WL12','{SHA-1}TUypwiHvd0OMkwrA7BJT+zHQwGo=','2022-06-16 15:29:04','/Login-001'),
(1508,31,'JASCRIPT','WL12','{SHA-1}TUypwiHvd0OMkwrA7BJT+zHQwGo=','2022-06-16 15:30:50','/Login-001'),
(1509,20,'JASCRIPT','WL12','{SHA-1}7nAuxIj7eudN67w1vGiNdmZdyUU=','2022-06-16 15:33:30','/Login-001'),
(1510,31,'JASCRIPT','WL12','{SHA-1}TUypwiHvd0OMkwrA7BJT+zHQwGo=','2022-06-16 15:42:45','/Login-001'),
(1511,31,'JASCRIPT','WL12','{SHA-1}TUypwiHvd0OMkwrA7BJT+zHQwGo=','2022-06-16 15:51:07','/Login-001'),
(1512,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-16 16:26:07','/Login-001'),
(1513,16,'JASCRIPT','WL12','{SHA-1}i6GhNAKd08wqEc72p1tJQfXmUpA=','2022-06-16 17:42:27','/Login-001'),
(1514,16,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-16 17:43:06','/Login-001'),
(1515,16,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-16 18:28:23','/Login-001'),
(1516,16,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-16 18:48:45','/Login-001'),
(1517,16,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-16 18:57:16','/Login-001'),
(1518,4,'JASCRIPT','WL12','{SHA-1}TQ9eftpUKclzHJsyBBcDDdKnKpc=','2022-06-16 18:58:49','/Login-001'),
(1519,15,'JASCRIPT','WL12','{SHA-1}cjC7lPayA+LHdUfU6CXXxkDmzto=','2022-06-16 20:56:33','/Login-001'),
(1520,26,'JASCRIPT','WL12','{SHA-1}ay5k2rP8qKzE2/yMAv1KIJhmncw=','2022-06-16 21:06:15','/Login-001'),
(1521,26,'JASCRIPT','WL12','{SHA-1}ay5k2rP8qKzE2/yMAv1KIJhmncw=','2022-06-16 21:31:19','/Login-001'),
(1522,26,'JASCRIPT','WL12','{SHA-1}ay5k2rP8qKzE2/yMAv1KIJhmncw=','2022-06-16 21:31:48','/Login-001'),
(1523,4,'JASCRIPT','WL12','{SHA-1}sawSiG/bkuq6ACIUOQitoNiGXkU=','2022-06-16 22:02:27','/Login-001'),
(1524,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-06-16 22:03:02','/Login-001'),
(1525,26,'JASCRIPT','WL12','{SHA-1}ay5k2rP8qKzE2/yMAv1KIJhmncw=','2022-06-16 22:18:04','/Login-001'),
(1526,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-06-16 22:18:08','/Login-001'),
(1527,26,'JASCRIPT','WL12','{SHA-1}ay5k2rP8qKzE2/yMAv1KIJhmncw=','2022-06-16 22:18:21','/Login-001'),
(1528,31,'JASCRIPT','WL12','{SHA-1}TUypwiHvd0OMkwrA7BJT+zHQwGo=','2022-06-17 12:04:25','/Login-001'),
(1529,31,'JASCRIPT','WL12','{SHA-1}TUypwiHvd0OMkwrA7BJT+zHQwGo=','2022-06-17 14:22:12','/Login-001'),
(1530,20,'JASCRIPT','WL12','{SHA-1}7nAuxIj7eudN67w1vGiNdmZdyUU=','2022-06-17 14:52:14','/Login-001'),
(1531,20,'JASCRIPT','WL12','{SHA-1}7nAuxIj7eudN67w1vGiNdmZdyUU=','2022-06-17 15:22:07','/Login-001'),
(1532,20,'JASCRIPT','WL12','{SHA-1}7nAuxIj7eudN67w1vGiNdmZdyUU=','2022-06-17 15:28:49','/Login-001'),
(1533,4,'JASCRIPT','WL12','{SHA-1}Ytg60V7YBx7lrCBP3Z6mYWAiAjk=','2022-06-17 16:24:20','/Login-001'),
(1534,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-06-17 16:24:50','/Login-001'),
(1535,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-06-17 16:32:33','/Login-001'),
(1536,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-06-17 16:43:38','/Login-001'),
(1537,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-17 17:38:24','/Login-001'),
(1538,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-06-17 22:47:15','/Login-001'),
(1539,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-21 14:55:01','/Login-001'),
(1540,16,'JASCRIPT','WL12','{SHA-1}ep9hDmoxjo3WianQ4q6z61MQsFE=','2022-06-21 15:00:51','/Login-001'),
(1541,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-21 15:01:26','/Login-001'),
(1542,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-21 15:08:42','/Login-001'),
(1543,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-22 12:15:19','/Login-001'),
(1544,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-22 12:24:41','/Login-001'),
(1545,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-22 12:25:36','/Login-001'),
(1546,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-23 11:39:44','/Login-001'),
(1547,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-23 11:40:13','/Login-001'),
(1548,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-23 12:14:15','/Login-001'),
(1549,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-23 12:29:08','/Login-001'),
(1550,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-23 12:29:58','/Login-001'),
(1551,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-23 14:02:58','/Login-001'),
(1552,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-23 14:33:37','/Login-001'),
(1553,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-23 14:36:34','/Login-001'),
(1554,14,'JASCRIPT','WL12','{SHA-1}5Jk9iZgGg9q0W/doOZXTJ+YIS1o=','2022-06-23 14:39:30','/Login-001'),
(1555,20,'JASCRIPT','WL12','{SHA-1}7nAuxIj7eudN67w1vGiNdmZdyUU=','2022-06-23 14:57:01','/Login-001'),
(1556,27,'JASCRIPT','WL12','{SHA-1}lxpePwTKLIr5+lj05u2oD0YA1H8=','2022-06-23 14:59:51','/Login-001'),
(1557,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-06-23 23:32:14','/Login-001'),
(1558,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-06-23 23:40:48','/Login-001'),
(1559,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-06-23 23:55:20','/Login-001'),
(1560,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-06-24 16:31:34','/Login-001'),
(1561,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-28 09:48:42','/Login-001'),
(1562,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-28 10:02:45','/Login-001'),
(1563,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-28 10:04:31','/Login-001'),
(1564,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-06-28 10:27:26','/Login-001'),
(1565,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-06-28 10:33:22','/Login-001'),
(1566,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-28 10:42:47','/Login-001'),
(1567,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-28 11:24:17','/Login-001'),
(1568,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-28 11:25:08','/Login-001'),
(1569,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-28 11:27:34','/Login-001'),
(1570,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-28 11:30:02','/Login-001'),
(1571,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-28 11:36:33','/Login-001'),
(1572,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-28 15:47:30','/Login-001'),
(1573,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-06-30 17:08:00','/Login-001'),
(1574,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-07-01 15:55:30','/Login-001'),
(1575,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-07-03 08:50:40','/Login-001'),
(1576,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-07-03 09:18:57','/Login-001'),
(1577,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-07-03 13:21:44','/Login-001'),
(1578,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-07-05 10:48:28','/Login-001'),
(1579,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-07-05 11:17:29','/Login-001'),
(1580,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-07-08 01:57:28','/Login-001'),
(1581,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-07-08 02:01:19','/Login-001'),
(1582,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-07-12 09:52:42','/Login-001'),
(1583,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-07-12 10:00:11','/Login-001'),
(1584,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-07-12 10:07:39','/Login-001'),
(1585,4,'JASCRIPT','WL12','{SHA-1}wJVM7/1uhoQSbNNImKp/Pdts9uI=','2022-07-15 09:29:42','/Login-001'),
(1586,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-07-15 20:24:00','/Login-001'),
(1587,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-07-15 21:25:02','/Login-001'),
(1588,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-07-15 21:25:22','/Login-001'),
(1589,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-07-15 21:26:26','/Login-001'),
(1590,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-07-15 21:27:40','/Login-001'),
(1591,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-07-18 15:10:11','/Login-001'),
(1592,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-07-18 15:53:41','/Login-001'),
(1593,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-07-18 16:14:07','/Login-001'),
(1594,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-07-19 08:16:32','/Login-001'),
(1595,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-19 08:19:17','/Login-001'),
(1596,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-19 08:20:40','/Login-001'),
(1597,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-19 08:27:17','/Login-001'),
(1598,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-19 09:34:14','/Login-001'),
(1599,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-19 10:08:06','/Login-001'),
(1600,16,'JASCRIPT','WL12','{SHA-1}FG0Y0UYr8++vRvrcxrXCVhpjmY4=','2022-07-19 18:23:51','/Login-001'),
(1601,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 13:00:41','/Login-001'),
(1602,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 13:24:34','/Login-001'),
(1603,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 13:24:49','/Login-001'),
(1604,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 13:25:27','/Login-001'),
(1605,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 13:27:26','/Login-001'),
(1606,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 13:28:14','/Login-001'),
(1607,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 13:28:24','/Login-001'),
(1608,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 13:28:32','/Login-001'),
(1609,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 13:28:54','/Login-001'),
(1610,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 13:34:03','/Login-001'),
(1611,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 15:06:30','/Login-001'),
(1612,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 15:06:52','/Login-001'),
(1613,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 15:07:03','/Login-001'),
(1614,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 15:32:36','/Login-001'),
(1615,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 15:44:50','/Login-001'),
(1616,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 16:38:42','/Login-001'),
(1617,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 17:15:00','/Login-001'),
(1618,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 17:15:32','/Login-001'),
(1619,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 17:18:37','/Login-001'),
(1620,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 17:22:12','/Login-001'),
(1621,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 17:25:38','/Login-001'),
(1622,24,'JASCRIPT','WL12','{SHA-1}Myo+Ot426/CKNFonDDGwGAqwz5M=','2022-07-25 17:28:10','/Login-001'),
(1623,24,'JASCRIPT','WL12','{SHA-1}Myo+Ot426/CKNFonDDGwGAqwz5M=','2022-07-25 17:28:42','/Login-001'),
(1624,24,'JASCRIPT','WL12','{SHA-1}Myo+Ot426/CKNFonDDGwGAqwz5M=','2022-07-25 17:31:06','/Login-001'),
(1625,22,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 17:32:53','/Login-001'),
(1626,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 17:35:27','/Login-001'),
(1627,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 17:36:06','/Login-001'),
(1628,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 17:37:49','/Login-001'),
(1629,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 17:38:17','/Login-001'),
(1630,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 17:38:32','/Login-001'),
(1631,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 17:39:24','/Login-001'),
(1632,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 17:39:56','/Login-001'),
(1633,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 17:40:55','/Login-001'),
(1634,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 17:57:53','/Login-001'),
(1635,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 18:02:09','/Login-001'),
(1636,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 18:07:11','/Login-001'),
(1637,27,'JASCRIPT','WL12','{SHA-1}lxpePwTKLIr5+lj05u2oD0YA1H8=','2022-07-25 18:11:41','/Login-001'),
(1638,27,'JASCRIPT','WL12','{SHA-1}lxpePwTKLIr5+lj05u2oD0YA1H8=','2022-07-25 18:21:18','/Login-001'),
(1639,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 18:22:08','/Login-001'),
(1640,27,'JASCRIPT','WL12','{SHA-1}lxpePwTKLIr5+lj05u2oD0YA1H8=','2022-07-25 18:31:21','/Login-001'),
(1641,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-07-25 19:30:55','/Login-001'),
(1642,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-07-25 19:31:40','/Login-001'),
(1643,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-07-25 19:32:24','/Login-001'),
(1644,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 19:33:21','/Login-001'),
(1645,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 19:33:52','/Login-001'),
(1646,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-07-25 19:38:27','/Login-001'),
(1647,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-07-25 19:45:58','/Login-001'),
(1648,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-07-25 19:51:38','/Login-001'),
(1649,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-07-25 19:58:27','/Login-001'),
(1650,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 20:45:03','/Login-001'),
(1651,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 21:06:31','/Login-001'),
(1652,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 21:08:06','/Login-001'),
(1653,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 21:33:51','/Login-001'),
(1654,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 21:41:25','/Login-001'),
(1655,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 22:02:01','/Login-001'),
(1656,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 22:09:36','/Login-001'),
(1657,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 22:12:44','/Login-001'),
(1658,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 22:13:03','/Login-001'),
(1659,27,'JASCRIPT','WL12','{SHA-1}lxpePwTKLIr5+lj05u2oD0YA1H8=','2022-07-25 22:15:03','/Login-001'),
(1660,27,'JASCRIPT','WL12','{SHA-1}lxpePwTKLIr5+lj05u2oD0YA1H8=','2022-07-25 22:16:34','/Login-001'),
(1661,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 22:17:12','/Login-001'),
(1662,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 22:21:53','/Login-001'),
(1663,32,'JASCRIPT','WL12','{SHA-1}aRpx52lv1pMrcNoaOqaiW8hlEpY=','2022-07-25 22:24:15','/Login-001'),
(1664,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 22:24:39','/Login-001'),
(1665,27,'JASCRIPT','WL12','{SHA-1}lxpePwTKLIr5+lj05u2oD0YA1H8=','2022-07-25 22:26:03','/Login-001'),
(1666,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-07-25 22:41:50','/Login-001'),
(1667,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 22:52:48','/Login-001'),
(1668,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 23:00:07','/Login-001'),
(1669,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 23:00:26','/Login-001'),
(1670,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 23:02:34','/Login-001'),
(1671,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-25 23:03:33','/Login-001'),
(1672,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 23:05:35','/Login-001'),
(1673,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 23:08:13','/Login-001'),
(1674,25,'JASCRIPT','WL12','{SHA-1}SPOlzwcA+Zw+gRPbO5447uOYe+Y=','2022-07-25 23:08:37','/Login-001'),
(1675,25,'JASCRIPT','WL12','{SHA-1}U19sk1jyT1ZqRyMzGYzSA7Z5RTo=','2022-07-25 23:11:28','/Login-001'),
(1676,25,'JASCRIPT','WL12','{SHA-1}Bvx3M0QgjLSbEGgpFgqHUr2nqLU=','2022-07-25 23:12:40','/Login-001'),
(1677,25,'JASCRIPT','WL12','{SHA-1}Bvx3M0QgjLSbEGgpFgqHUr2nqLU=','2022-07-25 23:15:33','/Login-001'),
(1678,25,'JASCRIPT','WL12','{SHA-1}Bvx3M0QgjLSbEGgpFgqHUr2nqLU=','2022-07-25 23:18:01','/Login-001'),
(1679,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-07-25 23:20:46','/Login-001'),
(1680,25,'JASCRIPT','WL12','{SHA-1}Bvx3M0QgjLSbEGgpFgqHUr2nqLU=','2022-07-25 23:49:46','/Login-001'),
(1681,25,'JASCRIPT','WL12','{SHA-1}Bvx3M0QgjLSbEGgpFgqHUr2nqLU=','2022-07-26 00:13:09','/Login-001'),
(1682,25,'JASCRIPT','WL12','{SHA-1}Bvx3M0QgjLSbEGgpFgqHUr2nqLU=','2022-07-26 00:13:50','/Login-001'),
(1683,25,'JASCRIPT','WL12','{SHA-1}Bvx3M0QgjLSbEGgpFgqHUr2nqLU=','2022-07-26 00:28:03','/Login-001'),
(1684,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-07-26 09:33:16','/Login-001'),
(1685,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-26 09:35:05','/Login-001'),
(1686,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-26 09:44:14','/Login-001'),
(1687,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-26 09:45:17','/Login-001'),
(1688,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-26 15:16:06','/Login-001'),
(1689,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-26 15:44:15','/Login-001'),
(1690,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-26 15:58:57','/Login-001'),
(1691,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-26 16:25:08','/Login-001'),
(1692,20,'JASCRIPT','WL12','{SHA-1}7nAuxIj7eudN67w1vGiNdmZdyUU=','2022-07-26 16:30:34','/Login-001'),
(1693,29,'JASCRIPT','WL12','{SHA-1}R2a8FP+nyN52cu515nV7qHNbsRc=','2022-07-26 16:35:10','/Login-001'),
(1694,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-26 16:37:47','/Login-001'),
(1695,20,'JASCRIPT','WL12','{SHA-1}7nAuxIj7eudN67w1vGiNdmZdyUU=','2022-07-26 16:40:36','/Login-001'),
(1696,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-27 13:46:14','/Login-001'),
(1697,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-27 14:06:19','/Login-001'),
(1698,19,'JASCRIPT','WL12','{SHA-1}5KwhAbbpcWybIfBzdkOj9991P6U=','2022-07-27 16:39:09','/Login-001'),
(1699,27,'JASCRIPT','WL12','{SHA-1}lxpePwTKLIr5+lj05u2oD0YA1H8=','2022-07-27 16:54:05','/Login-001'),
(1700,27,'JASCRIPT','WL12','{SHA-1}lxpePwTKLIr5+lj05u2oD0YA1H8=','2022-07-27 16:54:51','/Login-001');
/*!40000 ALTER TABLE `token_servidor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `id_archivo` int DEFAULT NULL COMMENT 'Codigo de archivos que no tiene obligotariedad',
  `nick` varchar(128) DEFAULT NULL COMMENT 'Nick de Usuario',
  `nombre` varchar(128) NOT NULL COMMENT 'Nombre de Usuario',
  `apellido` varchar(128) NOT NULL COMMENT 'Apellido de Usuario',
  `usuario` varchar(128) NOT NULL COMMENT 'Usuario que realizo el cambio',
  `validador` varchar(512) NOT NULL COMMENT 'Campo de validacion para los registros',
  `usuario_fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de insercion del registro',
  `usuario_programa` varchar(256) NOT NULL COMMENT 'Programa usado para el cambio',
  `estado` varchar(8) DEFAULT NULL COMMENT 'Estado del listado A=Activo, I=Inactivo y X=Eliminado',
  `contador_ingreso` int DEFAULT NULL COMMENT 'Contador de intentos fallidos',
  `contador_fecha` datetime DEFAULT NULL COMMENT 'Fecha y hora del intentos fallidos',
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `usuario_nick_IDX` (`nick`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES
(13,NULL,'admin','Paul','Sanchez','root','92668751','2021-06-22 17:29:13','/Login-001','A',2,'2022-07-26 18:37:41'),
(15,NULL,'root','Principal','Usuario','root','3506402','2021-06-22 21:39:42','/Login-001','A',0,'2022-07-15 09:29:42'),
(18,NULL,'aerolinea','usuario','manifiesto','omar','979921403','2022-03-08 20:46:09','/Login-001','A',2,'2022-07-25 19:30:55'),
(25,NULL,'supervisor','Supervisor','Manifiesto','root','123','2022-03-23 11:10:29','/Login-001','A',0,'2022-06-23 14:39:30'),
(26,NULL,'jmartinez','Johanna','Martinez','admin','1938753242','2022-03-23 14:36:49','/Login-001','A',0,'2022-07-19 18:23:51'),
(27,NULL,'lhernandez','Luis','Hernandez','admin','123','2022-04-06 18:08:54','/Login-001','A',0,'2022-04-18 16:05:17'),
(28,NULL,'aerolinea2','Paul','Sanchez','admin','123','2022-04-07 19:12:42','/Login-001','A',0,'2022-06-04 20:16:57'),
(29,NULL,'cgaribello','Carlos Mauricio','Garibello Correa','admin','123','2022-04-18 15:31:01','/Login-001','A',0,'2022-07-27 16:39:09'),
(30,NULL,'hloaiza','Haidy','Loaiza','admin','123','2022-04-18 15:40:04','/Login-001','A',0,'2022-07-26 16:40:36'),
(31,NULL,'ovelez','Omar','Perez','cgaribello','-1005040125','2022-04-18 22:20:57','/Login-001','A',0,'2022-06-14 19:34:04'),
(32,NULL,'aerocivil','Aeronautica','Civil','supervisor','2069474610','2022-04-20 22:07:59','/Login-001','A',0,'2022-07-25 17:32:53'),
(33,NULL,'pgomez','Pedro','Gomez','admin','123','2022-04-21 18:37:24','/Login-001','A',1,'2022-06-07 01:31:18'),
(34,NULL,'truiz','Tania','Ruiz','ADMIN','123','2022-06-03 16:51:02','/Login-001','A',0,'2022-07-25 17:31:06'),
(35,NULL,'adiaz','Alexander','Diaz','supervisor','123','2022-06-09 14:25:36','/Login-001','A',0,'2022-07-26 00:28:03'),
(36,NULL,'ivera','ivan ','vera ','admin','100585735','2022-06-13 14:58:09','/Login-001','A',1,'2022-07-26 00:23:51'),
(37,NULL,'sjimenez','Sonia','Jimenez','admin','123','2022-06-13 14:57:44','/Login-001','A',0,'2022-07-27 16:54:51'),
(38,NULL,'msalinas','Marcela ','Salinas ','admin','123','2022-06-13 15:23:24','/Login-001','A',0,'2022-07-26 16:35:10'),
(39,NULL,'dpedreros','Diana ','Pedreros ','admin','123','2022-06-13 16:12:17','/Login-001','A',0,'2022-06-15 17:39:21'),
(40,NULL,'rodriguezm','miryan','rodríguez ','admin','123','2022-06-13 16:19:38','/Login-001','A',0,'2022-06-17 14:22:12'),
(41,NULL,'stovar','Sandra','Tovar','cgaribello','123','2022-06-15 12:39:01','/Login-001','A',0,'2022-07-25 22:24:15'),
(42,NULL,'eruiz','Elian','Ruiz','cgaribello','123','2022-07-25 13:59:55','/Administrativo-001','A',0,NULL),
(43,NULL,'cjami','Claudia','Jami','cgaribello','123','2022-07-26 15:23:48','/Administrativo-001','A',0,NULL),
(44,NULL,'grodriguez','Gerson Alfredo ','Rodriguez ','cgaribello','123','2022-07-26 15:48:47','/Administrativo-001','A',0,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `v_group_members`
--

DROP TABLE IF EXISTS `v_group_members`;
/*!50001 DROP VIEW IF EXISTS `v_group_members`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_group_members` (
  `NAME` tinyint NOT NULL,
  `MEMBER` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_groups`
--

DROP TABLE IF EXISTS `v_groups`;
/*!50001 DROP VIEW IF EXISTS `v_groups`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_groups` (
  `NAME` tinyint NOT NULL,
  `DESCRIPTION` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_menu`
--

DROP TABLE IF EXISTS `v_menu`;
/*!50001 DROP VIEW IF EXISTS `v_menu`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_menu` (
  `nick` tinyint NOT NULL,
  `id_menu` tinyint NOT NULL,
  `indice_menu` tinyint NOT NULL,
  `nombre_menu` tinyint NOT NULL,
  `task_flow` tinyint NOT NULL,
  `task_flow_informacion` tinyint NOT NULL,
  `tipo` tinyint NOT NULL,
  `indice_modulo` tinyint NOT NULL,
  `nombre_modulo` tinyint NOT NULL,
  `contexto` tinyint NOT NULL,
  `orden` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_menu_usuario`
--

DROP TABLE IF EXISTS `v_menu_usuario`;
/*!50001 DROP VIEW IF EXISTS `v_menu_usuario`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_menu_usuario` (
  `nick` tinyint NOT NULL,
  `id_menu` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v_users`
--

DROP TABLE IF EXISTS `v_users`;
/*!50001 DROP VIEW IF EXISTS `v_users`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `v_users` (
  `id_usuario` tinyint NOT NULL,
  `DESCRIPTION` tinyint NOT NULL,
  `NAME` tinyint NOT NULL,
  `PASSWORD` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'GS_001_00'
--

--
-- Dumping routines for database 'GS_001_00'
--
/*!50003 DROP FUNCTION IF EXISTS `permiso_menu_actualizar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`sic`@`%` FUNCTION `permiso_menu_actualizar`(
	pii_id_menu int, -- Id de menu
 	piv_nick varchar(128) -- Nick
) RETURNS int
    DETERMINISTIC
BEGIN
	--
	-- Variables
	DECLARE permiso INT;
	--
	-- Consulta del permiso
	SELECT		
		COUNT(p.actualizar = 'S' OR NULL) INTO permiso	
	FROM
		permiso p
	WHERE
		p.id_menu = pii_id_menu
		and p.id_rol in (
			select
				ru.id_rol
			from
				usuario u,
				rol_usuario ru
			WHERE
				u.id_usuario = ru.id_usuario
				and u.nick = piv_nick
			)
		group by p.id_menu;
	
	--
	-- Valida si el permiso esta activo
	if permiso > 0 then
		return(1);
	else
		return(0);
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `permiso_menu_borrar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`sic`@`%` FUNCTION `permiso_menu_borrar`(
 	pii_id_menu int, -- Id de menu
 	piv_nick varchar(128) -- Nick
) RETURNS int
    DETERMINISTIC
BEGIN
	--
	-- Variables
	DECLARE permiso INT;
	--
	-- Consulta del permiso
	SELECT		
		COUNT(p.borrar = 'S' OR NULL) INTO permiso	
	FROM
		permiso p
	WHERE
		p.id_menu = pii_id_menu
		and p.id_rol in (
			select
				ru.id_rol
			from
				usuario u,
				rol_usuario ru
			WHERE
				u.id_usuario = ru.id_usuario
				and u.nick = piv_nick
			)
		group by p.id_menu;
	
	--
	-- Valida si el permiso esta activo
	if permiso > 0 then
		return(1);
	else
		return(0);
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `permiso_menu_crear` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`sic`@`%` FUNCTION `permiso_menu_crear`(
 	pii_id_menu int, -- Id de menu
 	piv_nick varchar(128) -- Nick
) RETURNS int
    DETERMINISTIC
BEGIN
	--
	-- Variables
	DECLARE permiso INT;
	--
	-- Consulta del permiso
	SELECT		
		COUNT(p.crear = 'S' OR NULL) INTO permiso	
	FROM
		permiso p
	WHERE
		p.id_menu = pii_id_menu
		and p.id_rol in (
			select
				ru.id_rol
			from
				usuario u,
				rol_usuario ru
			WHERE
				u.id_usuario = ru.id_usuario
				and u.nick = piv_nick
			)
		group by p.id_menu;
	
	--
	-- Valida si el permiso esta activo
	if permiso > 0 then
		return(1);
	else
		return(0);
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `permiso_menu_ver_auditoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`sic`@`%` FUNCTION `permiso_menu_ver_auditoria`(
 	pii_id_menu int, -- Id de menu
 	piv_nick varchar(128) -- Nick
) RETURNS int
    DETERMINISTIC
BEGIN
	--
	-- Variables
	DECLARE permiso INT;
	--
	-- Consulta del permiso
	SELECT		
		COUNT(p.ver_auditoria = 'S' OR NULL) INTO permiso	
	FROM
		permiso p
	WHERE
		p.id_menu = pii_id_menu
		and p.id_rol in (
			select
				ru.id_rol
			from
				usuario u,
				rol_usuario ru
			WHERE
				u.id_usuario = ru.id_usuario
				and u.nick = piv_nick
			)
		group by p.id_menu;
	
	--
	-- Valida si el permiso esta activo
	if permiso > 0 then
		return(1);
	else
		return(0);
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `codigo_definido_usuario_bajar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`sic`@`%` PROCEDURE `codigo_definido_usuario_bajar`(
	IN pii_id_codigo_definido_usuario int,
	OUT poi_codigo_error int	
)
MainDeclare:BEGIN
	--
	-- Variables
	DECLARE pi_orden_original int;
	DECLARE pi_orden_destino int;
	DECLARE pi_id_codigo_definido_usuario_destino int default 0;
	DECLARE pi_codigo_error int;
	DECLARE pv_grupo varchar(128);
	--
	-- Declaracion de exception de salida
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  --
          -- Presentar Error    	  
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	--
    -- Inicio de transaccion
   	START TRANSACTION;
   
   	--
	-- CDU a subir
	SELECT orden, grupo into pi_orden_original, pv_grupo 
	FROM codigo_definido_usuario 
	WHERE id_codigo_definido_usuario = pii_id_codigo_definido_usuario;
	
	--
	-- CDU a destino
	select id_codigo_definido_usuario , orden into pi_id_codigo_definido_usuario_destino,  pi_orden_destino
	from codigo_definido_usuario
	where grupo = pv_grupo
	and orden = (
		select min(orden) 
		FROM codigo_definido_usuario 
		where grupo = pv_grupo
		and orden > pi_orden_original
		);

	--
	-- Si no hay datos sale del flujo.
	if pi_id_codigo_definido_usuario_destino = 0 then 
		ROLLBACK;
   		set poi_codigo_error = 0;
   		LEAVE MainDeclare;	
	end if;

	--
	-- Cambia el origen
	UPDATE codigo_definido_usuario
   	SET orden = pi_orden_destino
   	where id_codigo_definido_usuario = pii_id_codigo_definido_usuario;

   	--
	-- Cambia el destino	
   	UPDATE codigo_definido_usuario
   	SET orden = pi_orden_original
   	where id_codigo_definido_usuario = pi_id_codigo_definido_usuario_destino;
   
   	--
	-- Cambia los codigos reorganizados
   	CALL GS_001_00.codigo_definido_usuario_ordenar(pv_grupo,pi_codigo_error);  
   	if poi_codigo_error > 0 then
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
	--
    -- Commit transaccion y fin de transaccion
	COMMIT WORK;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `codigo_definido_usuario_extremos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`sic`@`%` PROCEDURE `codigo_definido_usuario_extremos`(
	IN pii_id_codigo_definido_usuario int,		 
	IN pii_extremo int, -- Se puede poner -1 o 1000 para los valores extremos.
	OUT poi_codigo_error int	
)
MainDeclare:BEGIN
	--
	-- Variables
	DECLARE pv_grupo varchar(128);
	DECLARE pi_codigo_error int;

	--
	-- Declaracion de exception de salida
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  --
          -- Presentar Error    	  
          SELECT poi_codigo_error AS MYSQL_ERROR;          
    	  ROLLBACK;
    END;
   
   	--
    -- Inicio de transaccion
   	START TRANSACTION;
   
   	--
	-- Carga de datos para el proceso.
	SELECT grupo into pv_grupo 
	FROM codigo_definido_usuario 
	WHERE id_codigo_definido_usuario = pii_id_codigo_definido_usuario;
	
    -- Ubica para
   	UPDATE codigo_definido_usuario
   	SET orden = pii_extremo
   	where id_codigo_definido_usuario = pii_id_codigo_definido_usuario;   	
   
   	--
	-- Cambia los codigos reorganizados
   	CALL codigo_definido_usuario_ordenar(pv_grupo,pi_codigo_error);
   	if poi_codigo_error > 0 then   		
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
   
	--
    -- Commit transaccion y fin de transaccion
	COMMIT WORK;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `codigo_definido_usuario_ordenar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`sic`@`%` PROCEDURE `codigo_definido_usuario_ordenar`(
	IN piv_grupo varchar(128),	
	OUT poi_codigo_error int	
)
BEGIN
	--
	-- Declaracion de cursor
	DECLARE cr_orden_destino int; 
	DECLARE cr_id_codigo_definido_usuario int; 
	DECLARE cr_orden_origen int;
	DECLARE cr_done boolean;
	DECLARE cr_orden cursor for
		SELECT @rowid:=@rowid+1 as orden_destino, id_codigo_definido_usuario, orden as orden_origen 
		FROM codigo_definido_usuario, (SELECT @rowid:=0) as init
		where grupo = piv_grupo
		ORDER BY orden;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET cr_done = TRUE;
	--
	-- Declaracion de exception de salida
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  --
          -- Presentar Error    	  
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	--
   	-- Recorre cursor
   	open cr_orden;
   	rows_loop:loop
   		fetch cr_orden into cr_orden_destino, cr_id_codigo_definido_usuario, cr_orden_origen;
   		--
   		-- Salida de emergencia
   		if cr_done then
   			leave rows_loop;
   		end if;
   		--
		-- Actualizacion de ordemaniento	
		UPDATE codigo_definido_usuario as cdu
		SET cdu.orden = cr_orden_destino 
		WHERE cdu.id_codigo_definido_usuario = cr_id_codigo_definido_usuario;   	
   	end loop;   
   	close cr_orden;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `codigo_definido_usuario_subir` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`sic`@`%` PROCEDURE `codigo_definido_usuario_subir`(
	IN pii_id_codigo_definido_usuario int,
	OUT poi_codigo_error int	
)
MainDeclare:BEGIN
	--
	-- Variables
	DECLARE pi_orden_original int;
	DECLARE pi_orden_destino int;
	DECLARE pi_id_codigo_definido_usuario_destino int default 0;
	DECLARE pi_codigo_error int;
	DECLARE pv_grupo varchar(128);
	--
	-- Declaracion de exception de salida
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  --
          -- Presentar Error    	  
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	--
    -- Inicio de transaccion
   	START TRANSACTION;
   
   	--
	-- CDU a subir
	SELECT orden, grupo into pi_orden_original, pv_grupo 
	FROM codigo_definido_usuario 
	WHERE id_codigo_definido_usuario = pii_id_codigo_definido_usuario;
	
	--
	-- CDU a destino
	select id_codigo_definido_usuario , orden into pi_id_codigo_definido_usuario_destino,  pi_orden_destino
	from codigo_definido_usuario
	where grupo = pv_grupo
	and orden = (
		select max(orden) 
		FROM codigo_definido_usuario 
		where grupo = pv_grupo
		and orden < pi_orden_original
		);

	--
	-- Si no hay datos sale del flujo.
	if pi_id_codigo_definido_usuario_destino = 0 then 
		ROLLBACK;
   		set poi_codigo_error = 0;
   		LEAVE MainDeclare;	
	end if;

	--
	-- Cambia el origen
	UPDATE codigo_definido_usuario
   	SET orden = pi_orden_destino
   	where id_codigo_definido_usuario = pii_id_codigo_definido_usuario;

   	--
	-- Cambia el destino	
   	UPDATE codigo_definido_usuario
   	SET orden = pi_orden_original
   	where id_codigo_definido_usuario = pi_id_codigo_definido_usuario_destino;
   
   	--
	-- Cambia los codigos reorganizados
   	CALL GS_001_00.codigo_definido_usuario_ordenar(pv_grupo,pi_codigo_error);  
   	if poi_codigo_error > 0 then
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
	--
    -- Commit transaccion y fin de transaccion
	COMMIT WORK;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `menu_bajar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`sic`@`%` PROCEDURE `menu_bajar`(
	IN pii_id_menu int,
	OUT poi_codigo_error int	
)
MainDeclare:BEGIN
	--
	-- Variables
	DECLARE pi_orden_original int;
	DECLARE pi_orden_destino int;
	DECLARE pi_id_menu_destino int default 0;
	DECLARE pi_codigo_error int;
	DECLARE pi_id_modulo varchar(128);
	--
	-- Declaracion de exception de salida
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  --
          -- Presentar Error    	  
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	--
    -- Inicio de transaccion
   	START TRANSACTION;
   
   	--
	-- CDU a subir
	SELECT orden, id_modulo into pi_orden_original, pi_id_modulo 
	FROM menu 
	WHERE id_menu = pii_id_menu;
	
	--
	-- CDU a destino
	select id_menu , orden into pi_id_menu_destino,  pi_orden_destino
	from menu
	where id_modulo = pi_id_modulo
	and orden = (
		select min(orden) 
		FROM menu 
		where id_modulo = pi_id_modulo
		and orden > pi_orden_original
		);

	--
	-- Si no hay datos sale del flujo.
	if pi_id_menu_destino = 0 then 
		ROLLBACK;
   		set poi_codigo_error = 0;
   		LEAVE MainDeclare;	
	end if;

	--
	-- Cambia el origen
	UPDATE menu
   	SET orden = pi_orden_destino
   	where id_menu = pii_id_menu;

   	--
	-- Cambia el destino	
   	UPDATE menu
   	SET orden = pi_orden_original
   	where id_menu = pi_id_menu_destino;
   
   	--
	-- Cambia los codigos reorganizados
   	CALL GS_001_00.menu_ordenar(pi_id_modulo,pi_codigo_error);  
   	if poi_codigo_error > 0 then
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
	--
    -- Commit transaccion y fin de transaccion
	COMMIT WORK;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `menu_extremos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`sic`@`%` PROCEDURE `menu_extremos`(
	IN pii_id_menu int,		 
	IN pii_extremo int, -- Se puede poner -1 o 1000 para los valores extremos.
	OUT poi_codigo_error int	
)
MainDeclare:BEGIN
	--
	-- Variables
	DECLARE pi_modulo varchar(128);
	DECLARE pi_codigo_error int;

	--
	-- Declaracion de exception de salida
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  --
          -- Presentar Error    	  
          SELECT poi_codigo_error AS MYSQL_ERROR;          
    	  ROLLBACK;
    END;
   
   	--
    -- Inicio de transaccion
   	START TRANSACTION;
   
   	--
	-- Carga de datos para el proceso.
	SELECT id_modulo into pi_modulo 
	FROM menu 
	WHERE id_menu = pii_id_menu;
	
    -- Ubica para
   	UPDATE menu
   	SET orden = pii_extremo
   	where id_menu = pii_id_menu;   	
   
   	--
	-- Cambia los codigos reorganizados
   	CALL menu_ordenar(pi_modulo,pi_codigo_error);
   	if poi_codigo_error > 0 then   		
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
   
	--
    -- Commit transaccion y fin de transaccion
	COMMIT WORK;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `menu_ordenar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`sic`@`%` PROCEDURE `menu_ordenar`(
	IN pii_id_modulo int,	
	OUT poi_codigo_error int	
)
BEGIN
	--
	-- Declaracion de cursor
	DECLARE cr_orden_destino int; 
	DECLARE cr_id_menu int; 
	DECLARE cr_orden_origen int;
	DECLARE cr_done boolean;
	DECLARE cr_orden cursor for
		SELECT @rowid:=@rowid+1 as orden_destino, id_menu, orden as orden_origen 
		FROM menu, (SELECT @rowid:=0) as init
		where id_modulo = pii_id_modulo
		ORDER BY orden;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET cr_done = TRUE;
	--
	-- Declaracion de exception de salida
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  --
          -- Presentar Error    	  
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	--
   	-- Recorre cursor
   	open cr_orden;
   	rows_loop:loop
   		fetch cr_orden into cr_orden_destino, cr_id_menu, cr_orden_origen;
   		--
   		-- Salida de emergencia
   		if cr_done then
   			leave rows_loop;
   		end if;
   		--
		-- Actualizacion de ordemaniento	
		UPDATE menu as mn
		SET mn.orden = cr_orden_destino 
		WHERE mn.id_menu = cr_id_menu;   	
   	end loop;   
   	close cr_orden;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `menu_subir` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`sic`@`%` PROCEDURE `menu_subir`(
	IN pii_id_menu int,
	OUT poi_codigo_error int	
)
MainDeclare:BEGIN
	--
	-- Variables
	DECLARE pi_orden_original int;
	DECLARE pi_orden_destino int;
	DECLARE pi_id_menu_destino int default 0;
	DECLARE pi_codigo_error int;
	DECLARE pi_modulo int;
	--
	-- Declaracion de exception de salida
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          GET CURRENT DIAGNOSTICS CONDITION 1 poi_codigo_error = MYSQL_ERRNO;
    	  --
          -- Presentar Error    	  
          SELECT poi_codigo_error AS MYSQL_ERROR;
    	  ROLLBACK;
    END;
   
   	--
    -- Inicio de transaccion
   	START TRANSACTION;
   
   	--
	-- CDU a subir
	SELECT orden, id_modulo into pi_orden_original, pi_modulo 
	FROM menu 
	WHERE id_menu = pii_id_menu;
	
	--
	-- CDU a destino
	select id_menu, orden into pi_id_menu_destino, pi_orden_destino
	from menu
	where id_modulo = pi_modulo
	and orden = (
		select max(orden) 
		FROM menu 
		where id_modulo = pi_modulo
		and orden < pi_orden_original
		);

	--
	-- Si no hay datos sale del flujo.
	if pi_id_menu_destino = 0 then 
		ROLLBACK;
   		set poi_codigo_error = 0;
   		LEAVE MainDeclare;	
	end if;

	--
	-- Cambia el origen
	UPDATE menu
   	SET orden = pi_orden_destino
   	where id_menu = pii_id_menu;

   	--
	-- Cambia el destino	
   	UPDATE menu
   	SET orden = pi_orden_original
   	where id_menu = pi_id_menu_destino;
   
   	--
	-- Cambia los codigos reorganizados
   	CALL GS_001_00.menu_ordenar(pi_modulo,pi_codigo_error);  
   	if poi_codigo_error > 0 then
   		ROLLBACK;
   		set poi_codigo_error = pi_codigo_error;
   		LEAVE MainDeclare;   
   	end if;
	--
    -- Commit transaccion y fin de transaccion
	COMMIT WORK;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `v_group_members`
--

/*!50001 DROP TABLE IF EXISTS `v_group_members`*/;
/*!50001 DROP VIEW IF EXISTS `v_group_members`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`sic`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_group_members` AS select `r`.`tipo` AS `NAME`,`u`.`nick` AS `MEMBER` from ((`rol` `r` join `rol_usuario` `ru`) join `usuario` `u`) where ((`ru`.`id_usuario` = `u`.`id_usuario`) and (`ru`.`id_rol` = `r`.`id_rol`) and (`u`.`estado` = 'A')) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_groups`
--

/*!50001 DROP TABLE IF EXISTS `v_groups`*/;
/*!50001 DROP VIEW IF EXISTS `v_groups`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`sic`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_groups` AS select `rol`.`tipo` AS `NAME`,`rol`.`nombre` AS `DESCRIPTION` from `rol` where (`rol`.`estado` = 'A') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_menu`
--

/*!50001 DROP TABLE IF EXISTS `v_menu`*/;
/*!50001 DROP VIEW IF EXISTS `v_menu`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`sic`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_menu` AS select `vmu`.`nick` AS `nick`,`m`.`id_menu` AS `id_menu`,`m`.`indice` AS `indice_menu`,`m`.`nombre` AS `nombre_menu`,`m`.`task_flow` AS `task_flow`,`m`.`task_flow` AS `task_flow_informacion`,`m`.`tipo` AS `tipo`,`md`.`indice` AS `indice_modulo`,`md`.`nombre` AS `nombre_modulo`,`md`.`contexto` AS `contexto`,`m`.`orden` AS `orden` from ((`modulo` `md` join `menu` `m`) join `v_menu_usuario` `vmu`) where ((`vmu`.`id_menu` = `m`.`id_menu`) and (`m`.`id_modulo` = `md`.`id_modulo`) and (`m`.`estado` = 'A') and (`md`.`estado` = 'A')) order by `m`.`orden` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_menu_usuario`
--

/*!50001 DROP TABLE IF EXISTS `v_menu_usuario`*/;
/*!50001 DROP VIEW IF EXISTS `v_menu_usuario`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`sic`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_menu_usuario` AS select distinct `u`.`nick` AS `nick`,`p`.`id_menu` AS `id_menu` from ((((`rol_usuario` `ru` join `rol` `r`) join `permiso` `p`) join `usuario` `u`) join `token` `t`) where ((`u`.`id_usuario` = `ru`.`id_usuario`) and (`ru`.`id_rol` = `r`.`id_rol`) and (`r`.`id_rol` = `p`.`id_rol`) and (`r`.`estado` = 'A') and (`u`.`estado` = 'A') and (`u`.`id_usuario` = `t`.`id_usuario`) and (`t`.`estado` = 'C') and (`p`.`id_menu` = (select `p`.`valor_numero_01` from (`parametro` `p` join `modulo` `m`) where ((`m`.`indice` = 'LG_001_00') and (`m`.`id_modulo` = `p`.`id_modulo`) and (`p`.`indice` = '004'))))) union all select distinct `u`.`nick` AS `nick`,`p`.`id_menu` AS `id_menu` from ((((`rol_usuario` `ru` join `rol` `r`) join `permiso` `p`) join `usuario` `u`) join `token` `t`) where ((`u`.`id_usuario` = `ru`.`id_usuario`) and (`ru`.`id_rol` = `r`.`id_rol`) and (`r`.`id_rol` = `p`.`id_rol`) and (`r`.`estado` = 'A') and (`u`.`estado` = 'A') and (`u`.`id_usuario` = `t`.`id_usuario`) and (`t`.`estado` = 'A')) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_users`
--

/*!50001 DROP TABLE IF EXISTS `v_users`*/;
/*!50001 DROP VIEW IF EXISTS `v_users`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`sic`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `v_users` AS select `u`.`id_usuario` AS `id_usuario`,concat(`u`.`nombre`,' ',`u`.`apellido`) AS `DESCRIPTION`,`u`.`nick` AS `NAME`,(select `t`.`token` from `token` `t` where ((`t`.`id_usuario` = `u`.`id_usuario`) and (`t`.`tipo` = 'C')) limit 1) AS `PASSWORD` from `usuario` `u` where (`u`.`estado` = 'A') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-02 22:27:06
