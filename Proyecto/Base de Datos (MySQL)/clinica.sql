/*
SQLyog Ultimate v9.02 
MySQL - 5.5.17 : Database - clinica
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`clinica` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `clinica`;

/*Table structure for table `cama` */

DROP TABLE IF EXISTS `cama`;

CREATE TABLE `cama` (
  `oidcama` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `numero_cama` int(11) NOT NULL,
  `oidhabitacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `oidestado_cama` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidcama`),
  KEY `fk_cama_habitacion1` (`oidhabitacion`),
  KEY `fk_cama_estado_cama1` (`oidestado_cama`),
  CONSTRAINT `fk_cama_estado_cama1` FOREIGN KEY (`oidestado_cama`) REFERENCES `estado_cama` (`oidestado_cama`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cama_habitacion1` FOREIGN KEY (`oidhabitacion`) REFERENCES `habitacion` (`oidhabitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `convenio` */

DROP TABLE IF EXISTS `convenio`;

CREATE TABLE `convenio` (
  `oidconvenio` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `fecha_inicio` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `fecha_fin` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `oidplan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `oidprestacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `oidcoseguro` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidconvenio`),
  KEY `fk_convenio_plan1` (`oidplan`),
  KEY `fk_convenio_prestacion1` (`oidprestacion`),
  KEY `fk_convenio_coseguro1` (`oidcoseguro`),
  CONSTRAINT `fk_convenio_coseguro1` FOREIGN KEY (`oidcoseguro`) REFERENCES `coseguro` (`oidcoseguro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_convenio_plan1` FOREIGN KEY (`oidplan`) REFERENCES `plan` (`oidplan`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_convenio_prestacion1` FOREIGN KEY (`oidprestacion`) REFERENCES `prestacion` (`oidprestacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `coseguro` */

DROP TABLE IF EXISTS `coseguro`;

CREATE TABLE `coseguro` (
  `oidcoseguro` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `codigo_coseguro` int(11) NOT NULL,
  `porcentaje` double NOT NULL,
  PRIMARY KEY (`oidcoseguro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `costo_prestacion` */

DROP TABLE IF EXISTS `costo_prestacion`;

CREATE TABLE `costo_prestacion` (
  `oidcosto_prestacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `fecha_inicio` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `fecha_fin` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `monto` double NOT NULL,
  `oidprestacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidcosto_prestacion`),
  KEY `fk_costo_prestacion_prestacion1` (`oidprestacion`),
  CONSTRAINT `fk_costo_prestacion_prestacion1` FOREIGN KEY (`oidprestacion`) REFERENCES `prestacion` (`oidprestacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `costo_servicio` */

DROP TABLE IF EXISTS `costo_servicio`;

CREATE TABLE `costo_servicio` (
  `oidcosto_servicio` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `fecha_inicio` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `fecha_fin` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `monto` double NOT NULL,
  `oidservicio_especial` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidcosto_servicio`),
  KEY `fk_costo_servicio_servicio_especial1` (`oidservicio_especial`),
  CONSTRAINT `fk_costo_servicio_servicio_especial1` FOREIGN KEY (`oidservicio_especial`) REFERENCES `servicio_especial` (`oidservicio_especial`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `detalle_ficha` */

DROP TABLE IF EXISTS `detalle_ficha`;

CREATE TABLE `detalle_ficha` (
  `oiddetalle_ficha` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `oidficha_internacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `oidservicio_especial` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oiddetalle_ficha`),
  KEY `fk_detalle_ficha_ficha_internacion1` (`oidficha_internacion`),
  KEY `fk_detalle_ficha_servicio_especial1` (`oidservicio_especial`),
  CONSTRAINT `fk_detalle_ficha_ficha_internacion1` FOREIGN KEY (`oidficha_internacion`) REFERENCES `ficha_internacion` (`oidficha_internacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_ficha_servicio_especial1` FOREIGN KEY (`oidservicio_especial`) REFERENCES `servicio_especial` (`oidservicio_especial`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `estado_cama` */

DROP TABLE IF EXISTS `estado_cama`;

CREATE TABLE `estado_cama` (
  `oidestado_cama` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nombre_estado_cama` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidestado_cama`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `estado_factura_cliente` */

DROP TABLE IF EXISTS `estado_factura_cliente`;

CREATE TABLE `estado_factura_cliente` (
  `oidestado_factura_cliente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nombre_estado_factura_cliente` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidestado_factura_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `estado_ficha_internacion` */

DROP TABLE IF EXISTS `estado_ficha_internacion`;

CREATE TABLE `estado_ficha_internacion` (
  `oidestado_ficha_internacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nombre_estado_ficha_internacion` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidestado_ficha_internacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `factura_cliente` */

DROP TABLE IF EXISTS `factura_cliente`;

CREATE TABLE `factura_cliente` (
  `oidfactura_cliente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `numero_factura_cliente` int(11) NOT NULL,
  `fecha` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `oidestado_factura_cliente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `oidficha_internacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidfactura_cliente`),
  KEY `fk_factura_cliente_estado_factura_cliente1` (`oidestado_factura_cliente`),
  KEY `fk_factura_cliente_ficha_internacion1` (`oidficha_internacion`),
  CONSTRAINT `fk_factura_cliente_estado_factura_cliente1` FOREIGN KEY (`oidestado_factura_cliente`) REFERENCES `estado_factura_cliente` (`oidestado_factura_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_factura_cliente_ficha_internacion1` FOREIGN KEY (`oidficha_internacion`) REFERENCES `ficha_internacion` (`oidficha_internacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `ficha_internacion` */

DROP TABLE IF EXISTS `ficha_internacion`;

CREATE TABLE `ficha_internacion` (
  `oidficha_internacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `numero_ficha_internacion` int(11) NOT NULL,
  `fecha` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `oidprestacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `oidestado_ficha_internacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `oidcama` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `oidpaciente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `oidfactura_os` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`oidficha_internacion`),
  KEY `fk_ficha_internacion_prestacion1` (`oidprestacion`),
  KEY `fk_ficha_internacion_estado_ficha_internacion1` (`oidestado_ficha_internacion`),
  KEY `fk_ficha_internacion_cama1` (`oidcama`),
  KEY `fk_ficha_internacion_paciente1` (`oidpaciente`),
  KEY `fk_ficha_internacion_factura_os1` (`oidfactura_os`),
  CONSTRAINT `fk_ficha_internacion_prestacion1` FOREIGN KEY (`oidprestacion`) REFERENCES `prestacion` (`oidprestacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ficha_internacion_estado_ficha_internacion1` FOREIGN KEY (`oidestado_ficha_internacion`) REFERENCES `estado_ficha_internacion` (`oidestado_ficha_internacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ficha_internacion_cama1` FOREIGN KEY (`oidcama`) REFERENCES `cama` (`oidcama`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ficha_internacion_paciente1` FOREIGN KEY (`oidpaciente`) REFERENCES `paciente` (`oidpaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ficha_internacion_factura_os1` FOREIGN KEY (`oidfactura_os`) REFERENCES `factura_os` (`oidfactura_os`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `habitacion` */

DROP TABLE IF EXISTS `habitacion`;

CREATE TABLE `habitacion` (
  `oidhabitacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `numero_habitacion` int(11) NOT NULL,
  `oidsector` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `oidtipo_habitacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidhabitacion`),
  KEY `fk_habitacion_sector1` (`oidsector`),
  KEY `fk_habitacion_tipo_habitacion1` (`oidtipo_habitacion`),
  CONSTRAINT `fk_habitacion_sector1` FOREIGN KEY (`oidsector`) REFERENCES `sector` (`oidsector`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_habitacion_tipo_habitacion1` FOREIGN KEY (`oidtipo_habitacion`) REFERENCES `tipo_habitacion` (`oidtipo_habitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `obra_social` */

DROP TABLE IF EXISTS `obra_social`;

CREATE TABLE `obra_social` (
  `oidobra_social` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `codigo_os` int(11) NOT NULL,
  `nombre_os` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidobra_social`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `paciente` */

DROP TABLE IF EXISTS `paciente`;

CREATE TABLE `paciente` (
  `oidpaciente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `numero_paciente` int(11) NOT NULL,
  `nombre_paciente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dni` int(11) NOT NULL,
  `domicilio` varchar(70) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefono` mediumtext COLLATE utf8_unicode_ci,
  `oidplan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidpaciente`),
  KEY `fk_paciente_plan1` (`oidplan`),
  CONSTRAINT `fk_paciente_plan1` FOREIGN KEY (`oidplan`) REFERENCES `plan` (`oidplan`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `plan` */

DROP TABLE IF EXISTS `plan`;

CREATE TABLE `plan` (
  `oidplan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `codigo_plan` int(11) NOT NULL,
  `descripcion` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `oidobra_social` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidplan`),
  KEY `fk_plan_obra_social1` (`oidobra_social`),
  CONSTRAINT `fk_plan_obra_social1` FOREIGN KEY (`oidobra_social`) REFERENCES `obra_social` (`oidobra_social`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `prestacion` */

DROP TABLE IF EXISTS `prestacion`;

CREATE TABLE `prestacion` (
  `oidprestacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `codigo_prestacion` int(11) NOT NULL,
  `descripcion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `oidtipo_prestacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidprestacion`),
  KEY `fk_prestacion_tipo_prestacion1` (`oidtipo_prestacion`),
  CONSTRAINT `fk_prestacion_tipo_prestacion1` FOREIGN KEY (`oidtipo_prestacion`) REFERENCES `tipo_prestacion` (`oidtipo_prestacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `recibo` */

DROP TABLE IF EXISTS `recibo`;

CREATE TABLE `recibo` (
  `oidrecibo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `numero_recibo` int(11) NOT NULL,
  `fecha` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `oidfactura_cliente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidrecibo`),
  KEY `fk_recibo_factura_cliente1` (`oidfactura_cliente`),
  CONSTRAINT `fk_recibo_factura_cliente1` FOREIGN KEY (`oidfactura_cliente`) REFERENCES `factura_cliente` (`oidfactura_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `sector` */

DROP TABLE IF EXISTS `sector`;

CREATE TABLE `sector` (
  `oidsector` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `codigo_sector` int(11) NOT NULL,
  `descripcion_sector` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `numero_piso` int(11) NOT NULL,
  PRIMARY KEY (`oidsector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `servicio_especial` */

DROP TABLE IF EXISTS `servicio_especial`;

CREATE TABLE `servicio_especial` (
  `oidservicio_especial` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `codigo_servicio_especial` int(11) NOT NULL,
  `nombre_servicio_especial` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidservicio_especial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `tipo_habitacion` */

DROP TABLE IF EXISTS `tipo_habitacion`;

CREATE TABLE `tipo_habitacion` (
  `oidtipo_habitacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `codigo_tipo_habitacion` int(11) NOT NULL,
  `nombre_tipo_habitacion` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidtipo_habitacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `tipo_prestacion` */

DROP TABLE IF EXISTS `tipo_prestacion`;

CREATE TABLE `tipo_prestacion` (
  `oidtipo_prestacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `codigo_tipo_prestacion` int(11) NOT NULL,
  `nombre_tipo_prestacion` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `oidtipo_habitacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidtipo_prestacion`),
  KEY `fk_tipo_prestacion_tipo_habitacion1` (`oidtipo_habitacion`),
  CONSTRAINT `fk_tipo_prestacion_tipo_habitacion1` FOREIGN KEY (`oidtipo_habitacion`) REFERENCES `tipo_habitacion` (`oidtipo_habitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
