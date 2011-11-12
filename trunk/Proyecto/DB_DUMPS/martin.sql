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

DROP TABLE IF EXISTS `ficha_internacion`;

CREATE TABLE `ficha_internacion` (
  `oidficha_internacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `numero_ficha_internacion` int(11) NOT NULL,
  `fecha` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `oidprestacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `oidestado_ficha_internacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `oidcama` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `oidpaciente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `oidfactura_os` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
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

insert  into `ficha_internacion`(`oidficha_internacion`,`numero_ficha_internacion`,`fecha`,`oidprestacion`,`oidestado_ficha_internacion`,`oidcama`,`oidpaciente`,`oidfactura_os`) values ('56105120-4fd0-4cbd-9281-58137f205dbd',1,'10-11-2011','4821103d-5b08-496f-822e-014dfc16b950','af48fee7-69f6-4d85-9f19-57e54a8997a4','b20ccb2d-ec12-441f-9e00-82ca17eab7d6','3d23d5f0-f813-4e97-973e-34d5eebc5c6f','n6wsny5u-ngzh-6az4-myt7-jnystsi865g4');
insert  into `ficha_internacion`(`oidficha_internacion`,`numero_ficha_internacion`,`fecha`,`oidprestacion`,`oidestado_ficha_internacion`,`oidcama`,`oidpaciente`,`oidfactura_os`) values ('e05cdfcd-0db4-4f06-b601-343d2903810a',2,'10-11-2011','2ea9a442-8309-4b15-8600-2f89ad28f471','7fff7879-7808-4ac4-8e48-56e1fe3f4da5','bb30deea-9509-4d99-8640-de820bc49c06','e4d99be8-5b91-4bba-94b7-1bce78531b7d','uyre7666-7why-7wh5-uw56-iutjry6eee68');
insert  into `ficha_internacion`(`oidficha_internacion`,`numero_ficha_internacion`,`fecha`,`oidprestacion`,`oidestado_ficha_internacion`,`oidcama`,`oidpaciente`,`oidfactura_os`) values ('27d63055-766b-43ae-9711-8a350a5bfdfb',3,'11-11-2011','e2d33617-687f-466b-b1d7-0a7ac9d1fedf','af48fee7-69f6-4d85-9f19-57e54a8997a4','c7ea026b-c063-4681-a9a1-6b0f0fd4cbc5','633a6544-d13f-410a-b50c-c6a42b41389d','6uwww5wg-63hs-bdrr-rr7j-shu66665hww6');
insert  into `ficha_internacion`(`oidficha_internacion`,`numero_ficha_internacion`,`fecha`,`oidprestacion`,`oidestado_ficha_internacion`,`oidcama`,`oidpaciente`,`oidfactura_os`) values ('37c9d93e-15c2-4152-bf48-be8e0025734a',4,'12-11-2011','e2d33617-687f-466b-b1d7-0a7ac9d1fedf','7fff7879-7808-4ac4-8e48-56e1fe3f4da5','c7ea026b-c063-4681-a9a1-6b0f0fd4cbc5','d8c68653-6bcf-4c57-8453-c9bdc8a6a10d','pittr612-4aaa-t466-5yt3-jy54223hty76');
insert  into `ficha_internacion`(`oidficha_internacion`,`numero_ficha_internacion`,`fecha`,`oidprestacion`,`oidestado_ficha_internacion`,`oidcama`,`oidpaciente`,`oidfactura_os`) values ('34f25a67-e562-48a1-b944-4083ac622f57',5,'12-11-2011','09b0a617-7924-448e-8bc1-8a9fbe186279','7fff7879-7808-4ac4-8e48-56e1fe3f4da5','d7005bc4-500e-4104-84cb-8af8e8f8c133','80c77567-960d-44c0-af0b-436c3a704bba','mtfs6ydn-888h-sh79-uesu-9u7t48mosr9s');

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

insert  into `detalle_ficha`(`oiddetalle_ficha`,`oidficha_internacion`,`oidservicio_especial`) values ('2a6b2018-37ed-4c1c-8cad-5c40ca614447','e05cdfcd-0db4-4f06-b601-343d2903810a','94e6ebf4-3ff8-4e53-8c22-f52f771b44d8');
insert  into `detalle_ficha`(`oiddetalle_ficha`,`oidficha_internacion`,`oidservicio_especial`) values ('cfb41eda-5d50-4ac8-aa22-83bc84acd515','e05cdfcd-0db4-4f06-b601-343d2903810a','16292845-dbc6-4393-ae9d-13f6eb55fea0');
insert  into `detalle_ficha`(`oiddetalle_ficha`,`oidficha_internacion`,`oidservicio_especial`) values ('d51b7a5b-810d-469f-9031-de9630889b29','37c9d93e-15c2-4152-bf48-be8e0025734a','94e6ebf4-3ff8-4e53-8c22-f52f771b44d8');
insert  into `detalle_ficha`(`oiddetalle_ficha`,`oidficha_internacion`,`oidservicio_especial`) values ('35aee673-1e1b-439b-9b00-c6630d62e46d','37c9d93e-15c2-4152-bf48-be8e0025734a','72d72728-dc4f-4160-9f3c-e14c4e55aa64');
insert  into `detalle_ficha`(`oiddetalle_ficha`,`oidficha_internacion`,`oidservicio_especial`) values ('2ae50428-9afb-400f-9c24-104d94d9b5bd','37c9d93e-15c2-4152-bf48-be8e0025734a','1f4393c4-3fdd-4d07-915f-d70fa8cea023');