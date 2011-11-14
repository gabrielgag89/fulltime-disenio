/*
SQLyog Ultimate v9.02 
MySQL - 5.1.54-1ubuntu4 : Database - clinica
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

/*Data for the table `estado_cama` */

insert  into `estado_cama`(`oidestado_cama`,`nombre_estado_cama`) values ('6f21d411-b27c-495c-964c-0ec6e177d9dd','Ocupada'),('bbb664d0-8148-4589-be68-8f333ceb1826','Disponible');

/*Data for the table `habitacion` */

insert  into `habitacion`(`oidhabitacion`,`numero_habitacion`,`oidsector`,`oidtipo_habitacion`) values ('5a36848d-e67f-49cb-ae28-d90e10fdd506',4,'1f9b2ef6-4478-418a-8a03-2a7406f26c90','89fee1ef-a5ed-4963-bb6b-b80f08f885dd'),('61336f09-dc0c-45f7-b271-ce41ede431b0',1,'8709775c-1a62-426a-b826-8dcade143718','0f770e39-b317-4406-96f7-1bfde02ea537'),('da4aa1f8-76f5-4214-9c65-4637906c3180',5,'f55b5177-2434-4f7c-b52e-c614fcde7f85','faf93d7a-6b6a-4fe1-a85e-8385669493f8'),('f014ecc3-0d7d-4cf5-a21e-068bf32df091',3,'e13c6d44-1092-4434-951e-e6a98a162122','c2768c57-a66b-448d-87ad-d52ffba4a95c'),('f74fef5d-9a14-4f11-adfd-1473601119f8',2,'14d37ac9-d357-4294-a173-081cb76ceaf0','c3b8f327-1efc-4da1-89da-93f6896cbdbf');

/*Data for the table `factura_cliente` */

insert  into `factura_cliente`(`oidfactura_cliente`,`numero_factura_cliente`,`fecha`,`oidestado_factura_cliente`,`oidficha_internacion`) 
values ('33dd1998-3c4a-43b1-b5cf-b7472e6e5cce',3,'2011-09-17','19388d8d-a9c8-4e44-895d-66a47329cc67','27d63055-766b-43ae-9711-8a350a5bfdfb'),
('445a5a16-edd1-4d83-966a-b54549f32f77',1,'2010-10-10','19388d8d-a9c8-4e44-895d-66a47329cc67','56105120-4fd0-4cbd-9281-58137f205dbd'),
('79a6da2e-8ada-4a87-9863-64e440278d2a',4,'2011-10-22','19388d8d-a9c8-4e44-895d-66a47329cc67','37c9d93e-15c2-4152-bf48-be8e0025734a'),
('be1a60d0-95e9-414c-bce8-ea27d94a2ce7',5,'2012-10-10','19388d8d-a9c8-4e44-895d-66a47329cc67','34f25a67-e562-48a1-b944-4083ac622f57'),
('c68d97c1-de44-459c-b073-13e383424a14',2,'2010-11-10','19388d8d-a9c8-4e44-895d-66a47329cc67','e05cdfcd-0db4-4f06-b601-343d2903810a');


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
