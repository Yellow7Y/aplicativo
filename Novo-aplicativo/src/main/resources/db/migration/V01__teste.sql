CREATE TABLE categoria (
codigo BIGINT(120) PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(20) NOT NULL
) ENGINE=Inn0DB DEFAULT CHARSET=utf8;

INSERT INTO categoria (nome) values ('Tarefa');
INSERT INTO categoria (nome) values ('Grupo');