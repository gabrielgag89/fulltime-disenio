USE `clinica`;

DROP TABLE IF EXISTS `tipo_habitacion`;

CREATE TABLE `tipo_habitacion` (
  `oidtipo_habitacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `codigo_tipo_habitacion` int(11) NOT NULL,
  `nombre_tipo_habitacion` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`oidtipo_habitacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

insert  into `tipo_habitacion`(`oidtipo_habitacion`,`codigo_tipo_habitacion`,`nombre_tipo_habitacion`) values ('0f770e39-b317-4406-96f7-1bfde02ea537',11,'Roja');
insert  into `tipo_habitacion`(`oidtipo_habitacion`,`codigo_tipo_habitacion`,`nombre_tipo_habitacion`) values ('89fee1ef-a5ed-4963-bb6b-b80f08f885dd',44,'Azul');
insert  into `tipo_habitacion`(`oidtipo_habitacion`,`codigo_tipo_habitacion`,`nombre_tipo_habitacion`) values ('c2768c57-a66b-448d-87ad-d52ffba4a95c',33,'Rosa');
insert  into `tipo_habitacion`(`oidtipo_habitacion`,`codigo_tipo_habitacion`,`nombre_tipo_habitacion`) values ('c3b8f327-1efc-4da1-89da-93f6896cbdbf',22,'Naranja');
insert  into `tipo_habitacion`(`oidtipo_habitacion`,`codigo_tipo_habitacion`,`nombre_tipo_habitacion`) values ('faf93d7a-6b6a-4fe1-a85e-8385669493f8',55,'Amarilla');

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

insert  into `tipo_prestacion`(`oidtipo_prestacion`,`codigo_tipo_prestacion`,`nombre_tipo_prestacion`,`oidtipo_habitacion`) values ('4ad4d1ac-7e94-478f-a55b-54438dafb019',40,'Flebologia','89fee1ef-a5ed-4963-bb6b-b80f08f885dd');
insert  into `tipo_prestacion`(`oidtipo_prestacion`,`codigo_tipo_prestacion`,`nombre_tipo_prestacion`,`oidtipo_habitacion`) values ('6df7f190-37ca-4758-ba62-6edfd516f30d',30,'Infertilidad','c2768c57-a66b-448d-87ad-d52ffba4a95c');
insert  into `tipo_prestacion`(`oidtipo_prestacion`,`codigo_tipo_prestacion`,`nombre_tipo_prestacion`,`oidtipo_habitacion`) values ('8e7148c4-6ab5-42cf-b576-3a0a91474e37',50,'Nefrologia','faf93d7a-6b6a-4fe1-a85e-8385669493f8');
insert  into `tipo_prestacion`(`oidtipo_prestacion`,`codigo_tipo_prestacion`,`nombre_tipo_prestacion`,`oidtipo_habitacion`) values ('a872eb3d-ee7c-4f85-817d-f2f15466e38a',20,'Endocrinologia','c3b8f327-1efc-4da1-89da-93f6896cbdbf');
insert  into `tipo_prestacion`(`oidtipo_prestacion`,`codigo_tipo_prestacion`,`nombre_tipo_prestacion`,`oidtipo_habitacion`) values ('cd2ef33f-1374-47e0-a52f-bfbd20ba1fff',10,'Cardiologia','0f770e39-b317-4406-96f7-1bfde02ea537');
