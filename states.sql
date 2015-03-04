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
insert into user (first_name, last_name, birthday, city_id) values ("Alexandre", "Gama", "1986/06/25", 1);
insert into user (first_name, last_name, birthday, city_id) values ("Fernando", "Gama", "1987/07/25", 1);
insert into user (first_name, last_name, birthday, city_id) values ("Ronery", "Souza", "1987/03/07", 1);
insert into user (first_name, last_name, birthday, city_id) values ("Gustavo", "Maia", "1990/02/05", 2);
insert into user (first_name, last_name, birthday, city_id) values ("Nicole", "Maia", "1989/01/13", 2);
