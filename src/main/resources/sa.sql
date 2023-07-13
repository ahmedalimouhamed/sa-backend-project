CREATE TABLE client(
    id integer primary key not null AUTO_INCREMENT,
    email varchar(50) UNIQUE
);

CREATE TABLE sentiment(
    id integer primary key not null AUTO_INCREMENT,
    texte varchar(50),
    type varchar(10),
    client_id integer,
    CONSTRAINT client_fk FOREIGN KEY (client_id) REFERENCES client(id)
);