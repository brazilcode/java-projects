DROP TABLE alerta IF EXISTS;

CREATE TABLE alerta (
  id         INTEGER IDENTITY PRIMARY KEY,
  titulo 	 VARCHAR(100),
  conteudo   VARCHAR(300),
  dataInicio DATE,
  dataFim    DATE
);
CREATE INDEX alerta_titulo ON alerta (titulo);