CREATE SCHEMA `sysventa`; 
USE sysventa; 
CREATE TABLE `usuario` ( 
  `idusuario` int NOT NULL AUTO_INCREMENT, 
  `usuario` varchar(50) NOT NULL, 
  `clave` varchar(50) NOT NULL, 
  `nombreApellido` varchar(50) NOT NULL, 
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `sysventa`.`usuario` (`idusuario`, `usuario`, `clave`, `nombreApellido`) VALUES ('1', 'jperezgil', '123456', 'Juan Carlos Perez Gil');
SELECT * FROM sysventa.usuario;