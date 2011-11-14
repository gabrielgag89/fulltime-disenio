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

/*Data for the table `cama` */

insert  into `cama`(`oidcama`,`numero_cama`,`oidhabitacion`,`oidestado_cama`) values ('b20ccb2d-ec12-441f-9e00-82ca17eab7d6',3,'f74fef5d-9a14-4f11-adfd-1473601119f8','6f21d411-b27c-495c-964c-0ec6e177d9dd'),('bb30deea-9509-4d99-8640-de820bc49c06',5,'f014ecc3-0d7d-4cf5-a21e-068bf32df091','6f21d411-b27c-495c-964c-0ec6e177d9dd'),('c7ea026b-c063-4681-a9a1-6b0f0fd4cbc5',1,'61336f09-dc0c-45f7-b271-ce41ede431b0','bbb664d0-8148-4589-be68-8f333ceb1826'),('d7005bc4-500e-4104-84cb-8af8e8f8c133',2,'61336f09-dc0c-45f7-b271-ce41ede431b0','bbb664d0-8148-4589-be68-8f333ceb1826'),('e04154f9-88ac-4824-9759-1bf354625d50',4,'f74fef5d-9a14-4f11-adfd-1473601119f8','bbb664d0-8148-4589-be68-8f333ceb1826');

/*Data for the table `convenio` */

insert  into `convenio`(`oidconvenio`,`fecha_inicio`,`fecha_fin`,`oidplan`,`oidprestacion`,`oidcoseguro`) values ('25776786-bb91-44e2-a7e8-3ccdf9c81f4d','2010-20-03','2012-20-03','d2f64d1d-59f8-46b8-b56c-2847c0d47107','2ea9a442-8309-4b15-8600-2f89ad28f471','70aa8f21-528e-4ef6-99b8-2b553e6afbc2'),('2e916f45-a72c-4c4f-9001-44bdd40f4804','2010-01-01','2011-31-12','aa17b277-60e9-45d3-b909-537f7754cb51','4821103d-5b08-496f-822e-014dfc16b950','1c48dd3a-5d12-4575-99ef-2c1aafc92f1a'),('7ac498aa-b63e-4b5c-8daf-38d197dcd8aa','2010-10-05','2011-15-12','9b3ee0ac-3d71-48cb-99b2-3d5c5568ddfa','09b0a617-7924-448e-8bc1-8a9fbe186279','7e3f668b-9a8a-401b-8bd6-e363b09041d9');

/*Data for the table `coseguro` */

insert  into `coseguro`(`oidcoseguro`,`codigo_coseguro`,`porcentaje`) values ('1c48dd3a-5d12-4575-99ef-2c1aafc92f1a',1,0.2),('70aa8f21-528e-4ef6-99b8-2b553e6afbc2',2,0.25),('7e3f668b-9a8a-401b-8bd6-e363b09041d9',5,0.3),('88906a40-22dc-4327-b2a3-8f576af1aba0',4,0.15),('bc653ab1-f2ec-4282-a6d3-de5343d16b00',3,0.2);

/*Data for the table `costo_prestacion` */

insert  into `costo_prestacion`(`oidcosto_prestacion`,`fecha_inicio`,`fecha_fin`,`monto`,`oidprestacion`) values ('3efc1521-753e-4b0c-8ca2-ca89593f0df7','2011-01-10','2011-11-06',398.5,'2ea9a442-8309-4b15-8600-2f89ad28f471'),('7a05efd6-392f-4e38-b52a-05c9d790da43','2011-01-08','2011-12-06',465,'09b0a617-7924-448e-8bc1-8a9fbe186279'),('94cc9d4a-9e27-47b0-822e-6648d7564318','2011-01-01','2011-12-06',440.5,'e2d33617-687f-466b-b1d7-0a7ac9d1fedf'),('e20fc1bc-28a7-436b-81e1-79149591f08c','2011-11-10','2011-6-8',98.5,'4821103d-5b08-496f-822e-014dfc16b950');

/*Data for the table `costo_servicio` */

insert  into `costo_servicio`(`oidcosto_servicio`,`fecha_inicio`,`fecha_fin`,`monto`,`oidservicio_especial`) values ('26f09abf-b9e7-419a-b466-fa533931aaa0','2012-12-26','2012-12-31',55,'16292845-dbc6-4393-ae9d-13f6eb55fea0'),('301778a7-b8c4-4592-b1f2-2725eb9dbbd1','2011-01-15','2011-11-12',80,'72d72728-dc4f-4160-9f3c-e14c4e55aa64'),('5568d6b4-c1ab-4d9a-bd56-84ce1f354b2d','2012-01-11','2012-11-21',95,'72d72728-dc4f-4160-9f3c-e14c4e55aa64'),('6d22350f-126a-4815-b64b-a7617eb8a1d3','2011-11-10','2011-1-12',150,'94e6ebf4-3ff8-4e53-8c22-f52f771b44d8');

/*Data for the table `detalle_ficha` */

insert  into `detalle_ficha`(`oiddetalle_ficha`,`oidficha_internacion`,`oidservicio_especial`) values ('2a6b2018-37ed-4c1c-8cad-5c40ca614447','e05cdfcd-0db4-4f06-b601-343d2903810a','94e6ebf4-3ff8-4e53-8c22-f52f771b44d8'),('2ae50428-9afb-400f-9c24-104d94d9b5bd','37c9d93e-15c2-4152-bf48-be8e0025734a','1f4393c4-3fdd-4d07-915f-d70fa8cea023'),('35aee673-1e1b-439b-9b00-c6630d62e46d','37c9d93e-15c2-4152-bf48-be8e0025734a','72d72728-dc4f-4160-9f3c-e14c4e55aa64'),('cfb41eda-5d50-4ac8-aa22-83bc84acd515','e05cdfcd-0db4-4f06-b601-343d2903810a','16292845-dbc6-4393-ae9d-13f6eb55fea0'),('d51b7a5b-810d-469f-9031-de9630889b29','37c9d93e-15c2-4152-bf48-be8e0025734a','94e6ebf4-3ff8-4e53-8c22-f52f771b44d8');

/*Data for the table `estado_cama` */

insert  into `estado_cama`(`oidestado_cama`,`nombre_estado_cama`) values ('6f21d411-b27c-495c-964c-0ec6e177d9dd','Ocupada'),('bbb664d0-8148-4589-be68-8f333ceb1826','Disponible');

/*Data for the table `estado_factura_cliente` */

insert  into `estado_factura_cliente`(`oidestado_factura_cliente`,`nombre_estado_factura_cliente`) values ('0d046148-9172-4274-a6f4-2a35c32ddb97','emitida'),('19388d8d-a9c8-4e44-895d-66a47329cc67','pagada');

/*Data for the table `estado_ficha_internacion` */

insert  into `estado_ficha_internacion`(`oidestado_ficha_internacion`,`nombre_estado_ficha_internacion`) values ('7fff7879-7808-4ac4-8e48-56e1fe3f4da5','facturada'),('af48fee7-69f6-4d85-9f19-57e54a8997a4','creada');

/*Data for the table `factura_cliente` */

insert  into `factura_cliente`(`oidfactura_cliente`,`numero_factura_cliente`,`fecha`,`oidestado_factura_cliente`,`oidficha_internacion`) values ('33dd1998-3c4a-43b1-b5cf-b7472e6e5cce',3,'2011-09-17','19388d8d-a9c8-4e44-895d-66a47329cc67','27d63055-766b-43ae-9711-8a350a5bfdfb'),('445a5a16-edd1-4d83-966a-b54549f32f77',1,'2010-10-10','19388d8d-a9c8-4e44-895d-66a47329cc67','56105120-4fd0-4cbd-9281-58137f205dbd'),('79a6da2e-8ada-4a87-9863-64e440278d2a',4,'2011-10-22','19388d8d-a9c8-4e44-895d-66a47329cc67','37c9d93e-15c2-4152-bf48-be8e0025734a'),('be1a60d0-95e9-414c-bce8-ea27d94a2ce7',5,'2012-10-10','19388d8d-a9c8-4e44-895d-66a47329cc67','34f25a67-e562-48a1-b944-4083ac622f57'),('c68d97c1-de44-459c-b073-13e383424a14',2,'2010-11-10','19388d8d-a9c8-4e44-895d-66a47329cc67','e05cdfcd-0db4-4f06-b601-343d2903810a');

/*Data for the table `ficha_internacion` */

insert  into `ficha_internacion`(`oidficha_internacion`,`numero_ficha_internacion`,`fecha`,`oidprestacion`,`oidestado_ficha_internacion`,`oidcama`,`oidpaciente`,`oidfactura_os`) values ('27d63055-766b-43ae-9711-8a350a5bfdfb',3,'2011-11-11','e2d33617-687f-466b-b1d7-0a7ac9d1fedf','af48fee7-69f6-4d85-9f19-57e54a8997a4','c7ea026b-c063-4681-a9a1-6b0f0fd4cbc5','633a6544-d13f-410a-b50c-c6a42b41389d',NULL),('34f25a67-e562-48a1-b944-4083ac622f57',5,'2011-11-12','09b0a617-7924-448e-8bc1-8a9fbe186279','7fff7879-7808-4ac4-8e48-56e1fe3f4da5','d7005bc4-500e-4104-84cb-8af8e8f8c133','80c77567-960d-44c0-af0b-436c3a704bba',NULL),('37c9d93e-15c2-4152-bf48-be8e0025734a',4,'2011-11-12','e2d33617-687f-466b-b1d7-0a7ac9d1fedf','7fff7879-7808-4ac4-8e48-56e1fe3f4da5','c7ea026b-c063-4681-a9a1-6b0f0fd4cbc5','d8c68653-6bcf-4c57-8453-c9bdc8a6a10d',NULL),('56105120-4fd0-4cbd-9281-58137f205dbd',1,'2011-11-10','4821103d-5b08-496f-822e-014dfc16b950','af48fee7-69f6-4d85-9f19-57e54a8997a4','b20ccb2d-ec12-441f-9e00-82ca17eab7d6','3d23d5f0-f813-4e97-973e-34d5eebc5c6f',NULL),('e05cdfcd-0db4-4f06-b601-343d2903810a',2,'2011-11-10','2ea9a442-8309-4b15-8600-2f89ad28f471','7fff7879-7808-4ac4-8e48-56e1fe3f4da5','bb30deea-9509-4d99-8640-de820bc49c06','e4d99be8-5b91-4bba-94b7-1bce78531b7d',NULL);

/*Data for the table `habitacion` */

insert  into `habitacion`(`oidhabitacion`,`numero_habitacion`,`oidsector`,`oidtipo_habitacion`) values ('61336f09-dc0c-45f7-b271-ce41ede431b0',1,'8709775c-1a62-426a-b826-8dcade143718','0f770e39-b317-4406-96f7-1bfde02ea537'),('da4aa1f8-76f5-4214-9c65-4637906c3180',4,'1f9b2ef6-4478-418a-8a03-2a7406f26c90','89fee1ef-a5ed-4963-bb6b-b80f08f885dd'),('f014ecc3-0d7d-4cf5-a21e-068bf32df091',3,'e13c6d44-1092-4434-951e-e6a98a162122','c2768c57-a66b-448d-87ad-d52ffba4a95c'),('f74fef5d-9a14-4f11-adfd-1473601119f8',2,'14d37ac9-d357-4294-a173-081cb76ceaf0','c3b8f327-1efc-4da1-89da-93f6896cbdbf');

/*Data for the table `obra_social` */

insert  into `obra_social`(`oidobra_social`,`codigo_os`,`nombre_os`) values ('1d727d58-0f26-49a8-b676-47242c6aaefd',4,'Osde'),('1dd4ee3c-0eaa-4edf-8b54-ba1f1acb20d7',1,'Asistir'),('cdb134ae-b06a-48d2-83df-992dfedf1bbb',3,'Salud Social'),('e5cdfe8c-cc87-40a1-b4ae-90ac3b4d1978',2,'Osep');

/*Data for the table `paciente` */

insert  into `paciente`(`oidpaciente`,`numero_paciente`,`nombre_paciente`,`dni`,`domicilio`,`telefono`,`oidplan`) values ('3d23d5f0-f813-4e97-973e-34d5eebc5c6f',14,'Susana Gomez',12175770,'Mitre 200 Cdad Mza','156554782','9b3ee0ac-3d71-48cb-99b2-3d5c5568ddfa'),('633a6544-d13f-410a-b50c-c6a42b41389d',12,'Victor Moreno',24257978,'Guatemala 2510 San José Gllén Mza','4781524','aa17b277-60e9-45d3-b909-537f7754cb51'),('80c77567-960d-44c0-af0b-436c3a704bba',15,'Lucía Castro',29561278,'San Martin 145 Godoy Cruz Mza','154126897','9b3ee0ac-3d71-48cb-99b2-3d5c5568ddfa'),('d8c68653-6bcf-4c57-8453-c9bdc8a6a10d',13,'Mariano Bernal',30155780,'Alpes 1450 Dorrego Gllén Mza','156895478','9b3ee0ac-3d71-48cb-99b2-3d5c5568ddfa'),('e4d99be8-5b91-4bba-94b7-1bce78531b7d',11,'Armando Guevara',16255966,'Ruta 50 Rodeo del medio Gllén Mza','4185236','aa17b277-60e9-45d3-b909-537f7754cb51');

/*Data for the table `plan` */

insert  into `plan`(`oidplan`,`codigo_plan`,`descripcion`,`oidobra_social`) values ('9b3ee0ac-3d71-48cb-99b2-3d5c5568ddfa',19,'PMO','cdb134ae-b06a-48d2-83df-992dfedf1bbb'),('aa17b277-60e9-45d3-b909-537f7754cb51',18,'Platino','1dd4ee3c-0eaa-4edf-8b54-ba1f1acb20d7'),('d2f64d1d-59f8-46b8-b56c-2847c0d47107',20,'Oro','1d727d58-0f26-49a8-b676-47242c6aaefd');

/*Data for the table `prestacion` */

insert  into `prestacion`(`oidprestacion`,`codigo_prestacion`,`descripcion`,`oidtipo_prestacion`) values ('09b0a617-7924-448e-8bc1-8a9fbe186279',4,'Prestacion 4','6df7f190-37ca-4758-ba62-6edfd516f30d'),('2ea9a442-8309-4b15-8600-2f89ad28f471',2,'Prestacion 2','cd2ef33f-1374-47e0-a52f-bfbd20ba1fff'),('4821103d-5b08-496f-822e-014dfc16b950',1,'Prestacion 1','cd2ef33f-1374-47e0-a52f-bfbd20ba1fff'),('e2d33617-687f-466b-b1d7-0a7ac9d1fedf',3,'Prestacion 3','a872eb3d-ee7c-4f85-817d-f2f15466e38a');

/*Data for the table `recibo` */

insert  into `recibo`(`oidrecibo`,`numero_recibo`,`fecha`,`oidfactura_cliente`) values ('51a66f9a-b62f-466a-825f-a489f0ba6f2b',1,'2010-10-10','445a5a16-edd1-4d83-966a-b54549f32f77'),('54caa72d-748d-44e7-8bf9-c8598df00ac8',3,'2011-09-17','33dd1998-3c4a-43b1-b5cf-b7472e6e5cce'),('56d72f4e-2e5a-4006-a57c-7f5d92daf71d',4,'2011-10-22','79a6da2e-8ada-4a87-9863-64e440278d2a'),('5aa9711d-f3c1-4a6d-b83b-611cd2771828',2,'2010-11-10','c68d97c1-de44-459c-b073-13e383424a14'),('a0e6aec6-2af9-4df5-9a5c-305cc74c7f97',5,'2012-10-10','be1a60d0-95e9-414c-bce8-ea27d94a2ce7');

/*Data for the table `sector` */

insert  into `sector`(`oidsector`,`codigo_sector`,`descripcion_sector`,`numero_piso`) values ('14d37ac9-d357-4294-a173-081cb76ceaf0',2,'Sector 2',2),('1f9b2ef6-4478-418a-8a03-2a7406f26c90',4,'Sector 4',3),('8709775c-1a62-426a-b826-8dcade143718',1,'Sector 1',1),('e13c6d44-1092-4434-951e-e6a98a162122',3,'Sector 3',1);

/*Data for the table `servicio_especial` */

insert  into `servicio_especial`(`oidservicio_especial`,`codigo_servicio_especial`,`nombre_servicio_especial`) values ('16292845-dbc6-4393-ae9d-13f6eb55fea0',4,'Servicio especial 4'),('1f4393c4-3fdd-4d07-915f-d70fa8cea023',3,'Servicio especial 3'),('72d72728-dc4f-4160-9f3c-e14c4e55aa64',2,'Servicio especial 2'),('94e6ebf4-3ff8-4e53-8c22-f52f771b44d8',1,'Servicio especial 1');

/*Data for the table `tipo_habitacion` */

insert  into `tipo_habitacion`(`oidtipo_habitacion`,`codigo_tipo_habitacion`,`nombre_tipo_habitacion`) values ('0f770e39-b317-4406-96f7-1bfde02ea537',11,'Roja'),('89fee1ef-a5ed-4963-bb6b-b80f08f885dd',44,'Azul'),('c2768c57-a66b-448d-87ad-d52ffba4a95c',33,'Rosa'),('c3b8f327-1efc-4da1-89da-93f6896cbdbf',22,'Naranja'),('faf93d7a-6b6a-4fe1-a85e-8385669493f8',55,'Amarilla');

/*Data for the table `tipo_prestacion` */

insert  into `tipo_prestacion`(`oidtipo_prestacion`,`codigo_tipo_prestacion`,`nombre_tipo_prestacion`,`oidtipo_habitacion`) values ('4ad4d1ac-7e94-478f-a55b-54438dafb019',40,'Flebologia','89fee1ef-a5ed-4963-bb6b-b80f08f885dd'),('6df7f190-37ca-4758-ba62-6edfd516f30d',30,'Infertilidad','c2768c57-a66b-448d-87ad-d52ffba4a95c'),('8e7148c4-6ab5-42cf-b576-3a0a91474e37',50,'Nefrologia','faf93d7a-6b6a-4fe1-a85e-8385669493f8'),('a872eb3d-ee7c-4f85-817d-f2f15466e38a',20,'Endocrinologia','c3b8f327-1efc-4da1-89da-93f6896cbdbf'),('cd2ef33f-1374-47e0-a52f-bfbd20ba1fff',10,'Cardiologia','0f770e39-b317-4406-96f7-1bfde02ea537');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
