
 insert into estados (sigla, nome) Values('AC','Acre');
 insert into estados (sigla, nome) Values('AL','Alagoas');
 insert into estados (sigla, nome) Values('AM','Amazonas');
 insert into estados (sigla, nome) Values('AP','Amapá');
 insert into estados (sigla, nome) Values('BA','Bahia');
 insert into estados (sigla, nome) Values('CE','Ceará');
 insert into estados (sigla, nome) Values('DF','Distrito Federal');
 insert into estados (sigla, nome) Values('ES','Espírito Santo');
 insert into estados (sigla, nome) Values('GO','Goiás');
 insert into estados (sigla, nome) Values('MA','Maranhão');
 insert into estados (sigla, nome) Values('MG','Minas Gerais');
 insert into estados (sigla, nome) Values('MS','Mato Grosso do Sul');
 insert into estados (sigla, nome) Values('MT','Mato Grosso');
 insert into estados (sigla, nome) Values('PA','Pará');
 insert into estados (sigla, nome) Values('PB','Paraíba');
 insert into estados (sigla, nome) Values('PE','Pernambuco');
 insert into estados (sigla, nome) Values('PI','Piauí');
 insert into estados (sigla, nome) Values('PR','Paraná');
 insert into estados (sigla, nome) Values('RJ','Rio de Janeiro');
 insert into estados (sigla, nome) Values('RN','Rio Grande do Norte');
 insert into estados (sigla, nome) Values('RO','Rondônia');
 insert into estados (sigla, nome) Values('RR','Roraima');
 insert into estados (sigla, nome) Values('RS','Rio Grande do Sul');
 insert into estados (sigla, nome) Values('SC','Santa Catarina');
 insert into estados (sigla, nome) Values('SE','Sergipe');
 insert into estados (sigla, nome) Values('SP','São Paulo');
 insert into estados (sigla, nome) Values('TO','Tocantins');

INSERT INTO cidades(nome, estado_id) VALUES ('São Paulo', 26);
INSERT INTO cidades(nome, estado_id) VALUES ('Curitiba', 18);
INSERT INTO cidades(nome, estado_id) VALUES ('Pato Branco', 18);
INSERT INTO cidades(nome, estado_id) VALUES ('Rio de Janeiro', 19);
INSERT INTO cidades(nome, estado_id) VALUES ('Jundiaí', 26);
INSERT INTO cidades(nome, estado_id) VALUES ('Maringá', 18);

INSERT INTO usuarios(bairro, cpf, email, nome, numero, rua, telefone, cidade_id) VALUES ('Centro', '888.888.888-88', 'admin@admin.com', 'Admin', '42', 'rua1', '(46)32254-8523', 1);
INSERT INTO usuarios(bairro, cpf, email, nome, numero, rua, telefone, cidade_id) VALUES ('Centro', '888.888.888-88', 'mateus_tonial@hotmail.com', 'Matheus', '42', 'rua1', '(46)32254-8523',  1);
