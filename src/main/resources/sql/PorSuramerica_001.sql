CREATE TABLE post (
  id int(11) NOT NULL AUTO_INCREMENT,
  origen varchar(45) NOT NULL,
  destino varchar(45) NOT NULL,
  descripcion varchar(45) DEFAULT NULL,
  imagen varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
