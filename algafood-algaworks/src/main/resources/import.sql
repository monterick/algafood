INSERT INTO cozinha(id, nome) VALUES(1, 'Indiana');
INSERT INTO cozinha(id, nome) VALUES(2, 'Asiatica');

INSERT INTO restaurante(id, nome, taxa_frete, cozinha_id) VALUES(1, 'Caseirinho', 5.8, 1);
INSERT INTO restaurante(id, nome, taxa_frete, cozinha_id) VALUES(2, 'delivery', 4.2, 2);

INSERT INTO estado(id, nome) VALUES(1, 'São Paulo');
INSERT INTO estado(id, nome) VALUES(2, 'Paraná');

INSERT INTO cidade(id, nome, estado_id) VALUES(1, 'Piracicaba', 1);
INSERT INTO cidade(id, nome, estado_id) VALUES(2, 'Colorado', 2 );
INSERT INTO cidade(id, nome, estado_id) VALUES(3, 'Maringá', 2);