
/*
     OBRA SOCIAL
*/
INSERT INTO `clinica`.`obra_social`(`oidobra_social`,`codigo_os`,`nombre_os`) VALUES ( '1dd4ee3c-0eaa-4edf-8b54-ba1f1acb20d7','1','Asistir'), 
( 'e5cdfe8c-cc87-40a1-b4ae-90ac3b4d1978','2','Osep'), 
( 'cdb134ae-b06a-48d2-83df-992dfedf1bbb','3','Salud Social'), 
( '1d727d58-0f26-49a8-b676-47242c6aaefd','4','Osde');

/*
     PLAN
*/

insert into `clinica`.`plan`(`oidplan`,`codigo_plan`,`descripcion`,`oidobra_social`) values ( 'aa17b277-60e9-45d3-b909-537f7754cb51','18','Platino','1dd4ee3c-0eaa-4edf-8b54-ba1f1acb20d7'),
( '9b3ee0ac-3d71-48cb-99b2-3d5c5568ddfa','19','PMO','cdb134ae-b06a-48d2-83df-992dfedf1bbb'),
( 'd2f64d1d-59f8-46b8-b56c-2847c0d47107','20','Oro','1d727d58-0f26-49a8-b676-47242c6aaefd');

/*
     PACIENTE
*/

insert into `clinica`.`paciente`(`oidpaciente`,`numero_paciente`,`nombre_paciente`,`dni`,`domicilio`,`telefono`,`oidplan`) values ( '3d23d5f0-f813-4e97-973e-34d5eebc5c6f','14','Susana Gomez','12175770','Mitre 200 Cdad Mza','156554782','9b3ee0ac-3d71-48cb-99b2-3d5c5568ddfa'),
( 'e4d99be8-5b91-4bba-94b7-1bce78531b7d','11','Armando Guevara','16255966','Ruta 50 Rodeo del medio Gllén Mza','4185236','aa17b277-60e9-45d3-b909-537f7754cb51'),
( '633a6544-d13f-410a-b50c-c6a42b41389d','12','Victor Moreno','24257978','Guatemala 2510 San José Gllén Mza','4781524','aa17b277-60e9-45d3-b909-537f7754cb51'),
( 'd8c68653-6bcf-4c57-8453-c9bdc8a6a10d','13','Mariano Bernal','30155780','Alpes 1450 Dorrego Gllén Mza','156895478','9b3ee0ac-3d71-48cb-99b2-3d5c5568ddfa'),
( '80c77567-960d-44c0-af0b-436c3a704bba','15','Lucía Castro','29561278','San Martin 145 Godoy Cruz Mza','154126897','9b3ee0ac-3d71-48cb-99b2-3d5c5568ddfa');

/*	

	RECIBO: NECESITA DATOS FACTURA CLIENTE CARGADOS

*/

insert into `clinica`.`recibo`(`oidrecibo`,`numero_recibo`,`fecha`,`oidfactura_cliente`) values ( '54caa72d-748d-44e7-8bf9-c8598df00ac8','1','17-09-2011','33dd1998-3c4a-43b1-b5cf-b7472e6e5cce'),
( '51a66f9a-b62f-466a-825f-a489f0ba6f2b','2','2010-10-10','445a5a16-edd1-4d83-966a-b54549f32f77'),
( '5aa9711d-f3c1-4a6d-b83b-611cd2771828','3','2010-11-10','c68d97c1-de44-459c-b073-13e383424a14'),
( '56d72f4e-2e5a-4006-a57c-7f5d92daf71d','4','2011-22-10','79a6da2e-8ada-4a87-9863-64e440278d2a'),
( 'a0e6aec6-2af9-4df5-9a5c-305cc74c7f97','5','2012-10-10','be1a60d0-95e9-414c-bce8-ea27d94a2ce7');

/*	
//	PRESTACION: NECESITA DATOS TIPO PRESTACION CARGADOS
*/

insert into `clinica`.`prestacion`(`oidprestacion`,`codigo_prestacion`,`descripcion`,`oidtipo_prestacion`) values ( '4821103d-5b08-496f-822e-014dfc16b950','1','Prestacion 1','cd2ef33f-1374-47e0-a52f-bfbd20ba1fff'),
( '2ea9a442-8309-4b15-8600-2f89ad28f471','2','Prestacion 2','cd2ef33f-1374-47e0-a52f-bfbd20ba1fff'),
( 'e2d33617-687f-466b-b1d7-0a7ac9d1fedf','3','Prestacion 3','a872eb3d-ee7c-4f85-817d-f2f15466e38a'),
( '09b0a617-7924-448e-8bc1-8a9fbe186279','4','Prestacion 4','6df7f190-37ca-4758-ba62-6edfd516f30d');

/*	
//	COSTO PRESTACION: NECESITA PRESTACIONES CARGADAS
*/

insert into `clinica`.`costo_prestacion`(`oidcosto_prestacion`,`fecha_inicio`,`fecha_fin`,`monto`,`oidprestacion`) values ( 'e20fc1bc-28a7-436b-81e1-79149591f08c','2011-11-10','2011-6-8','98.5','4821103d-5b08-496f-822e-014dfc16b950'),
( '3efc1521-753e-4b0c-8ca2-ca89593f0df7','2011-01-10','2011-11-06','398.5','2ea9a442-8309-4b15-8600-2f89ad28f471'),
( '94cc9d4a-9e27-47b0-822e-6648d7564318','2011-01-01','2011-12-06','440.5','e2d33617-687f-466b-b1d7-0a7ac9d1fedf'),
( '7a05efd6-392f-4e38-b52a-05c9d790da43','2011-01-08','2011-12-06','465.0','09b0a617-7924-448e-8bc1-8a9fbe186279');


/*//CRISTIAN
	SECTOR
*/

INSERT INTO `clinica`.`sector`(`oidsector`,`codigo_sector`,`descripcion_sector`,`numero_piso`) VALUES ( '8709775c-1a62-426a-b826-8dcade143718','1','Sector 1','1'),
( '14d37ac9-d357-4294-a173-081cb76ceaf0','2','Sector 2','2'),
( 'e13c6d44-1092-4434-951e-e6a98a162122','3','Sector 3','1'),
( '1f9b2ef6-4478-418a-8a03-2a7406f26c90','4','Sector 4','3');

/*
	SERVICIO ESPECIAL
*/ 

INSERT INTO `clinica`.`servicio_especial`(`oidservicio_especial`,`codigo_servicio_especial`,`nombre_servicio_especial`) VALUES ( '94e6ebf4-3ff8-4e53-8c22-f52f771b44d8','1','Servicio especial 1'),
( '72d72728-dc4f-4160-9f3c-e14c4e55aa64','2','Servicio especial 2'),
( '1f4393c4-3fdd-4d07-915f-d70fa8cea023','3','Servicio especial 3'),
( '16292845-dbc6-4393-ae9d-13f6eb55fea0','4','Servicio especial 4');

/*
	COSTO SERVICIO	
*/

INSERT INTO `clinica`.`costo_servicio`(`oidcosto_servicio`,`fecha_inicio`,`fecha_fin`,`monto`,`oidservicio_especial`) VALUES ( '6d22350f-126a-4815-b64b-a7617eb8a1d3','2011-11-10','2011-1-12','150','94e6ebf4-3ff8-4e53-8c22-f52f771b44d8'), 
( '301778a7-b8c4-4592-b1f2-2725eb9dbbd1','2011-01-15','2011-11-12','80','72d72728-dc4f-4160-9f3c-e14c4e55aa64'),
( '5568d6b4-c1ab-4d9a-bd56-84ce1f354b2d','2012-01-11','2012-11-21','95','72d72728-dc4f-4160-9f3c-e14c4e55aa64'),
( '26f09abf-b9e7-419a-b466-fa533931aaa0','2012-12-26','2012-12-31','55','16292845-dbc6-4393-ae9d-13f6eb55fea0');





