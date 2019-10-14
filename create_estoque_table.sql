CREATE TABLE IF NOT EXISTS Categorias(
	id_cat INT  NOT NULL AUTO_INCREMENT,
	nome_cat VARCHAR(255),
    PRIMARY KEY(id_cat)
);
CREATE TABLE IF NOT EXISTS Produtos(
	id INT NOT NULL AUTO_INCREMENT,
	cod_barras INT,
	nome VARCHAR(255),
	quantidade INT,
	descricao VARCHAR(255),
	categoria INT,
	PRIMARY KEY(id),
	FOREIGN KEY(categoria) REFERENCES Categorias(id_cat)
	    ON UPDATE CASCADE ON DELETE RESTRICT
);


