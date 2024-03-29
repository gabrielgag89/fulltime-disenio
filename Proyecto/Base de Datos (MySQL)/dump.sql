﻿/*
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

/*Data for the table `cama` */

insert  into `cama`(`oidcama`,`numero_cama`,`oidhabitacion`,`oidestado_cama`) values ('1601',1,'61336f09-dc0c-45f7-b271-ce41ede431b0','1702'),('1602',2,'61336f09-dc0c-45f7-b271-ce41ede431b0','1702'),('1603',3,'f74fef5d-9a14-4f11-adfd-1473601119f8','1702'),('1604',4,'f74fef5d-9a14-4f11-adfd-1473601119f8','1702'),('1605',5,'f014ecc3-0d7d-4cf5-a21e-068bf32df091','1702'),('1606',6,'f014ecc3-0d7d-4cf5-a21e-068bf32df091','1702'),('1607',7,'da4aa1f8-76f5-4214-9c65-4637906c3180','1701'),('b20ccb2d-ec12-441f-9e00-82ca17eab7d6',8,'f74fef5d-9a14-4f11-adfd-1473601119f8','1702'),('bb30deea-9509-4d99-8640-de820bc49c06',9,'f014ecc3-0d7d-4cf5-a21e-068bf32df091','1702'),('c7ea026b-c063-4681-a9a1-6b0f0fd4cbc5',10,'61336f09-dc0c-45f7-b271-ce41ede431b0','1702'),('d7005bc4-500e-4104-84cb-8af8e8f8c133',11,'61336f09-dc0c-45f7-b271-ce41ede431b0','1702'),('e04154f9-88ac-4824-9759-1bf354625d50',13,'f74fef5d-9a14-4f11-adfd-1473601119f8','1702');

/*Data for the table `convenio` */

insert  into `convenio`(`oidconvenio`,`fecha_inicio`,`fecha_fin`,`oidplan`,`oidprestacion`,`oidcoseguro`) values ('7001','2010-01-01','2012-12-16','6001','2001','8001'),('7ac498aa-b63e-4b5c-8daf-38d197dcd8aa','2010-10-05','2011-12-31','9b3ee0ac-3d71-48cb-99b2-3d5c5568ddfa','09b0a617-7924-448e-8bc1-8a9fbe186279','bc653ab1-f2ec-4282-a6d3-de5343d16b00'),('aa353201-f256-40d3-b20d-8a6ce7d61b83','2010-01-01','2012-12-16','9b3ee0ac-3d71-48cb-99b2-3d5c5568ddfa','e901fc38-e0bc-4500-93bd-ff6a33f52f08','456gds65-q9z4-h4d4-h7g1-oiu4b34tssg5');

/*Data for the table `coseguro` */

insert  into `coseguro`(`oidcoseguro`,`codigo_coseguro`,`porcentaje`) values ('1c48dd3a-5d12-4575-99ef-2c1aafc92f1a',7,0.2),('456gds65-q9z4-h4d4-h7g1-oiu4b34tssg5',6,0.5),('70aa8f21-528e-4ef6-99b8-2b553e6afbc2',2,0.25),('7e3f668b-9a8a-401b-8bd6-e363b09041d9',5,0.3),('8001',1,0.2),('88906a40-22dc-4327-b2a3-8f576af1aba0',4,0.15),('bc653ab1-f2ec-4282-a6d3-de5343d16b00',3,0.2);

/*Data for the table `costo_prestacion` */

insert  into `costo_prestacion`(`oidcosto_prestacion`,`fecha_inicio`,`fecha_fin`,`monto`,`oidprestacion`) values ('28f8d5a6-a05b-4b67-ba53-c00d0d0db840','2011-01-01','2012-12-16',150.5,'888c36c2-694d-46a2-aba3-5ece6faaabfb'),('3001','2011-11-10','2012-06-08',100,'2001'),('3efc1521-753e-4b0c-8ca2-ca89593f0df7','2011-01-10','2011-12-06',398.5,'2ea9a442-8309-4b15-8600-2f89ad28f471'),('524d1fde-2018-4a9c-a2f4-ebe6e685f102','2011-01-01','2012-12-16',270,'e901fc38-e0bc-4500-93bd-ff6a33f52f08'),('7a05efd6-392f-4e38-b52a-05c9d790da43','2011-01-08','2011-12-06',465,'09b0a617-7924-448e-8bc1-8a9fbe186279'),('e20fc1bc-28a7-436b-81e1-79149591f08c','2011-11-10','2012-06-08',98.5,'4821103d-5b08-496f-822e-014dfc16b950');

/*Data for the table `costo_servicio` */

insert  into `costo_servicio`(`oidcosto_servicio`,`fecha_inicio`,`fecha_fin`,`monto`,`oidservicio_especial`) values ('1401','2010-01-01','2012-12-31',50,'1301'),('26f09abf-b9e7-419a-b466-fa533931aaa0','2010-01-01','2012-12-31',55,'16292845-dbc6-4393-ae9d-13f6eb55fea0'),('301778a7-b8c4-4592-b1f2-2725eb9dbbd1','2010-01-01','2012-12-31',80,'72d72728-dc4f-4160-9f3c-e14c4e55aa64'),('6d22350f-126a-4815-b64b-a7617eb8a1d3','2010-01-01','2012-12-31',150,'94e6ebf4-3ff8-4e53-8c22-f52f771b44d8');

/*Data for the table `detalle_ficha` */

insert  into `detalle_ficha`(`oiddetalle_ficha`,`cantidad`,`oidficha_internacion`,`oidservicio_especial`) values ('1201',3,'1004','1301'),('1202',3,'1005','1301'),('1203',3,'1006','1301'),('2a6b2018-37ed-4c1c-8cad-5c40ca614447',3,'e05cdfcd-0db4-4f06-b601-343d2903810a','94e6ebf4-3ff8-4e53-8c22-f52f771b44d8'),('cfb41eda-5d50-4ac8-aa22-83bc84acd515',1,'e05cdfcd-0db4-4f06-b601-343d2903810a','16292845-dbc6-4393-ae9d-13f6eb55fea0');

/*Data for the table `estado_cama` */

insert  into `estado_cama`(`oidestado_cama`,`nombre_estado_cama`) values ('1701','Disponible'),('1702','Ocupada');

/*Data for the table `estado_factura_paciente` */

insert  into `estado_factura_paciente`(`oidestado_factura_paciente`,`nombre_estado_factura_paciente`) values ('1101','Emitida'),('1102','Pagada');

/*Data for the table `estado_ficha_internacion` */

insert  into `estado_ficha_internacion`(`oidestado_ficha_internacion`,`nombre_estado_ficha_internacion`) values ('4001','Creada'),('4002','Facturada');

/*Data for the table `factura_paciente` */

insert  into `factura_paciente`(`oidfactura_paciente`,`numero_factura_paciente`,`fecha`,`monto`,`oidestado_factura_paciente`,`oidficha_internacion`) values ('9001',7,'2011-11-25',100,'1101','1007'),('9002',8,'2011-11-25',100,'1102','1008');

/*Data for the table `ficha_internacion` */

insert  into `ficha_internacion`(`oidficha_internacion`,`numero_ficha_internacion`,`fecha`,`oidprestacion`,`oidestado_ficha_internacion`,`oidcama`,`oidpaciente`) values ('1001',1,'2011-11-10','2001','4001','1601','5001'),('1002',2,'2011-11-10','2001','4001','1602','5002'),('1003',3,'2011-11-10','2001','4001','1603','5003'),('1004',4,'2011-11-10','2001','4001','1604','5001'),('1005',5,'2011-11-10','2001','4001','1605','5002'),('1006',6,'2011-11-10','2001','4001','1606','5003'),('1007',7,'2011-11-10','2001','4002','1607','5003'),('1008',8,'2011-11-10','2001','4002','1607','5003'),('e05cdfcd-0db4-4f06-b601-343d2903810a',9,'2011-11-10','2ea9a442-8309-4b15-8600-2f89ad28f471','4001','bb30deea-9509-4d99-8640-de820bc49c06','e4d99be8-5b91-4bba-94b7-1bce78531b7d');

/*Data for the table `habitacion` */

insert  into `habitacion`(`oidhabitacion`,`numero_habitacion`,`oidsector`,`oidtipo_habitacion`) values ('61336f09-dc0c-45f7-b271-ce41ede431b0',1,'8709775c-1a62-426a-b826-8dcade143718','0f770e39-b317-4406-96f7-1bfde02ea537'),('da4aa1f8-76f5-4214-9c65-4637906c3180',4,'1f9b2ef6-4478-418a-8a03-2a7406f26c90','89fee1ef-a5ed-4963-bb6b-b80f08f885dd'),('f014ecc3-0d7d-4cf5-a21e-068bf32df091',3,'e13c6d44-1092-4434-951e-e6a98a162122','c2768c57-a66b-448d-87ad-d52ffba4a95c'),('f74fef5d-9a14-4f11-adfd-1473601119f8',2,'14d37ac9-d357-4294-a173-081cb76ceaf0','c3b8f327-1efc-4da1-89da-93f6896cbdbf');

/*Data for the table `obra_social` */

insert  into `obra_social`(`oidobra_social`,`codigo_os`,`nombre_os`) values ('1d727d58-0f26-49a8-b676-47242c6aaefd',4,'Osde'),('1dd4ee3c-0eaa-4edf-8b54-ba1f1acb20d7',1,'Asistir'),('cdb134ae-b06a-48d2-83df-992dfedf1bbb',3,'Salud Social'),('e5cdfe8c-cc87-40a1-b4ae-90ac3b4d1978',2,'Osep');

/*Data for the table `paciente` */

insert  into `paciente`(`oidpaciente`,`numero_paciente`,`nombre_paciente`,`dni`,`domicilio`,`telefono`,`oidplan`) values ('5001',1,'Susana Gomez',12175770,'Mitre 200 Cdad Mza','156554782','6001'),('5002',2,'Victor Moreno',24257978,'Guatemala 2510 San José Gllén Mza','4781524','6002'),('5003',3,'Lucía Castro',29561278,'San Martín 145 Godoy Cruz Mza','154126897',NULL),('d8c68653-6bcf-4c57-8453-c9bdc8a6a10d',13,'Mariano Bernal',30155780,'Alpes 1450 Dorrego Gllén Mza','156895478','9b3ee0ac-3d71-48cb-99b2-3d5c5568ddfa'),('e4d99be8-5b91-4bba-94b7-1bce78531b7d',11,'Armando Guevara',16255966,'Ruta 50 Rodeo del medio Gllén Mza','4185236','6001');

/*Data for the table `plan` */

insert  into `plan`(`oidplan`,`codigo_plan`,`descripcion`,`oidobra_social`) values ('6001',1,'Platino','1dd4ee3c-0eaa-4edf-8b54-ba1f1acb20d7'),('6002',2,'Oro','1d727d58-0f26-49a8-b676-47242c6aaefd'),('9b3ee0ac-3d71-48cb-99b2-3d5c5568ddfa',19,'PMO','cdb134ae-b06a-48d2-83df-992dfedf1bbb');

/*Data for the table `prestacion` */

insert  into `prestacion`(`oidprestacion`,`codigo_prestacion`,`descripcion`,`oidtipo_prestacion`) values ('09b0a617-7924-448e-8bc1-8a9fbe186279',34,'Internación','4ad4d1ac-7e94-478f-a55b-54438dafb019'),('2001',1,'Cardiología','4ad4d1ac-7e94-478f-a55b-54438dafb019'),('2ea9a442-8309-4b15-8600-2f89ad28f471',25,'Prótesis','4ad4d1ac-7e94-478f-a55b-54438dafb019'),('4821103d-5b08-496f-822e-014dfc16b950',11,'Hemograma','a872eb3d-ee7c-4f85-817d-f2f15466e38a'),('888c36c2-694d-46a2-aba3-5ece6faaabfb',17,'Eco Doppler central y Periférico','4ad4d1ac-7e94-478f-a55b-54438dafb019'),('e901fc38-e0bc-4500-93bd-ff6a33f52f08',56,'Psiquiatría','cd2ef33f-1374-47e0-a52f-bfbd20ba1fff');

/*Data for the table `recibo` */

insert  into `recibo`(`oidrecibo`,`numero_recibo`,`fecha`,`oidfactura_paciente`) values ('1501',8,'2011-11-25','9002');

/*Data for the table `sector` */

insert  into `sector`(`oidsector`,`codigo_sector`,`descripcion_sector`,`numero_piso`) values ('14d37ac9-d357-4294-a173-081cb76ceaf0',4,'Inmunodeprimidos',4),('1f9b2ef6-4478-418a-8a03-2a7406f26c90',3,'Quimioterapia',1),('8709775c-1a62-426a-b826-8dcade143718',2,'Ambulatorio',2),('e13c6d44-1092-4434-951e-e6a98a162122',3,'Consultorio',1),('f55b5177-2434-4f7c-b52e-c614fcde7f85',1,'Internación',1);

/*Data for the table `servicio_especial` */

insert  into `servicio_especial`(`oidservicio_especial`,`codigo_servicio_especial`,`nombre_servicio_especial`) values ('1301',1,'Almuerzo'),('16292845-dbc6-4393-ae9d-13f6eb55fea0',1,'Desayuno'),('72d72728-dc4f-4160-9f3c-e14c4e55aa64',3,'Mediatarde'),('94e6ebf4-3ff8-4e53-8c22-f52f771b44d8',4,'Cena');

/*Data for the table `tipo_habitacion` */

insert  into `tipo_habitacion`(`oidtipo_habitacion`,`codigo_tipo_habitacion`,`nombre_tipo_habitacion`) values ('0f770e39-b317-4406-96f7-1bfde02ea537',11,'Roja'),('89fee1ef-a5ed-4963-bb6b-b80f08f885dd',44,'Azul'),('c2768c57-a66b-448d-87ad-d52ffba4a95c',33,'Rosa'),('c3b8f327-1efc-4da1-89da-93f6896cbdbf',22,'Naranja'),('faf93d7a-6b6a-4fe1-a85e-8385669493f8',55,'Amarilla');

/*Data for the table `tipo_prestacion` */

insert  into `tipo_prestacion`(`oidtipo_prestacion`,`codigo_tipo_prestacion`,`nombre_tipo_prestacion`,`oidtipo_habitacion`) values ('4ad4d1ac-7e94-478f-a55b-54438dafb019',40,'Médica','89fee1ef-a5ed-4963-bb6b-b80f08f885dd'),('6df7f190-37ca-4758-ba62-6edfd516f30d',30,'Farmacéutica','c2768c57-a66b-448d-87ad-d52ffba4a95c'),('8e7148c4-6ab5-42cf-b576-3a0a91474e37',50,'Odontológica','faf93d7a-6b6a-4fe1-a85e-8385669493f8'),('a872eb3d-ee7c-4f85-817d-f2f15466e38a',20,'Bioquímica','c3b8f327-1efc-4da1-89da-93f6896cbdbf'),('cd2ef33f-1374-47e0-a52f-bfbd20ba1fff',10,'Salud Mental','0f770e39-b317-4406-96f7-1bfde02ea537');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
