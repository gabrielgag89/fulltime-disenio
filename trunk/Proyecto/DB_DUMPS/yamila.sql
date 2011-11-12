/*COSEGURO*/

INSERT INTO 'clinica'.'coseguro'('oidcoseguro','codigo_coseguro','porcentaje') VALUES ( '1c48dd3a-5d12-4575-99ef-2c1aafc92f1a','001','0.20'), 
( '70aa8f21-528e-4ef6-99b8-2b553e6afbc2','002','0.25'), 
( 'bc653ab1-f2ec-4282-a6d3-de5343d16b00','003','0.20'), 
( '88906a40-22dc-4327-b2a3-8f576af1aba0','004','0.15')
( '7e3f668b-9a8a-401b-8bd6-e363b09041d9','005','0.30');


/*ESTADO_FACTURA_CLIENTE*/


INSERT INTO 'clinica'.'estado_factura_cliente'('oidestado_factura_cliente','nombre_estado_factura_cliente') VALUES ( '0d046148-9172-4274-a6f4-2a35c32ddb97','pendiente'), 
( '19388d8d-a9c8-4e44-895d-66a47329cc67','pagada');



/*ESTADO_FICHA_INTERNACION*/


INSERT INTO 'clinica'.'estado_factura_cliente_internacion'('oidestado_ficha_internacion','nombre_estado_ficha_internacion') VALUES ( 'af48fee7-69f6-4d85-9f19-57e54a8997a4','creada');



/*CONVENIO*/



INSERT INTO 'clinica'.'convenio'('oidconvenio','fecha_inicio','fecha_fin','oidplan','oidprestacion','oidcoseguro' ) VALUES
( '2e916f45-a72c-4c4f-9001-44bdd40f4804','01-01-2010','31-12-2011','aa17b277-60e9-45d3-b909-537f7754cb51','4821103d-5b08-496f-822e-014dfc16b950','1c48dd3a-5d12-4575-99ef-2c1aafc92f1a'), 
( '7ac498aa-b63e-4b5c-8daf-38d197dcd8aa','10-05-2010','15-12-2011','9b3ee0ac-3d71-48cb-99b2-3d5c5568ddfa','3efc1521-753e-4b0c-8ca2-ca89593f0df7','bc653ab1-f2ec-4282-a6d3-de5343d16b00'), 
( '25776786-bb91-44e2-a7e8-3ccdf9c81f4d','20-03-20010','20-03-2012','d2f64d1d-59f8-46b8-b56c-2847c0d47107','70aa8f21-528e-4ef6-99b8-2b553e6afbc2');