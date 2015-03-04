# STATE
insert into state (`name`, `abbreviation`) values ('São Paulo', 'SP');
insert into state (`name`, `abbreviation`) values ('Rio de Janeiro', 'RJ');

# CITY
insert into city (name, state_id) values ('São Paulo', 1);
insert into city (name, state_id) values ('Campinas', 1);
insert into city (name, state_id) values ('Riacho Grande', 1);
insert into city (name, state_id) values ('São Bernardo', 1);

insert into city (name, state_id) values ('Rio de Janeiro', 2);
insert into city (name, state_id) values ('Duque de Caxias', 2);
insert into city (name, state_id) values ('Niteróis', 2);

# USERS
insert into user (first_name, last_name, birthday, city_id, photo) values ("Alexandre", "Gama", "1986/06/25", 1, "homem.jpeg");
insert into user (first_name, last_name, birthday, city_id, photo) values ("Carla", "Souza", "1987/07/25", 1, "menina.jpg");
insert into user (first_name, last_name, birthday, city_id, photo) values ("Ronery", "Souza", "1987/03/07", 1, "outro-cara.jpeg");
insert into user (first_name, last_name, birthday, city_id, photo) values ("Nicole", "Maia", "1989/01/13", 2, "outro-cara.jpeg");

# USER HAS SPACE
insert into user (first_name, last_name, birthday, city_id, photo) values ("Mônica", "Cristina", "1991/11/23", 2, "monica.jpg");
insert into user (first_name, last_name, birthday, city_id, photo) values ("Fabrício", "Souza", "1993/11/23", 2, "fabricio.jpeg");
insert into user (first_name, last_name, birthday, city_id, photo) values ("Priscila", "Silva", "1988/10/21", 2, "priscila.jpg");
insert into user (first_name, last_name, birthday, city_id, photo) values ("Maria", "Santana", "1991/09/19", 2, "maria.jpg");
insert into user (first_name, last_name, birthday, city_id, photo) values ("Paola", "Prateado", "1995/10/26", 2, "paola.jpeg");
