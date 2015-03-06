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
insert into user (first_name, last_name, birthday, city_id, photo, smoker) values ("Alexandre", "Gama", "1986/06/25", 1, "homem.jpeg", "N");
insert into user (first_name, last_name, birthday, city_id, photo, smoker) values ("Carla", "Souza", "1987/07/25", 1, "menina.jpg", "N");
insert into user (first_name, last_name, birthday, city_id, photo, smoker) values ("Ronery", "Souza", "1987/03/07", 1, "outro-cara.jpeg", "S");
insert into user (first_name, last_name, birthday, city_id, photo, smoker) values ("Nicole", "Maia", "1989/01/13", 2, "priscila.jpg", "S");

# USER HAS SPACE
insert into user (first_name, last_name, birthday, city_id, photo, smoker) values ("Mônica", "Cristina", "1991/11/23", 2, "monica.jpg", "N");
insert into user (first_name, last_name, birthday, city_id, photo, smoker) values ("Fabrício", "Souza", "1993/11/23", 2, "fabricio.jpeg", "N");
insert into user (first_name, last_name, birthday, city_id, photo, smoker) values ("Priscila", "Silva", "1988/10/21", 2, "priscila.jpg", "S");
insert into user (first_name, last_name, birthday, city_id, photo, smoker) values ("Maria", "Santana", "1991/09/19", 2, "maria.jpg", "N");
insert into user (first_name, last_name, birthday, city_id, photo, smoker) values ("Paola", "Prateado", "1995/10/26", 2, "paola.jpeg", "N");

# ROOM
insert into place_to_rental (user_id, price, price_type, short_description, description, city_id, main_picture, neighborhood) values (6, 400, "MONTH", "Dividindo apartamento perto da Av Paulista",  "Long description", 1, "quarto1.jpeg", "Jardins");
insert into place_to_rental (user_id, price, price_type, short_description, description, city_id, main_picture, neighborhood) values (7, 880, "MONTH", "Ótimo apartamento perto do centro",  "Long description", 2, "quarto2.jpg", "Boa Vista");
insert into place_to_rental (user_id, price, price_type, short_description, description, city_id, main_picture, neighborhood) values (8, 880, "WEEK", "Incrível quarto com sacada para o mar",  "Long description", 1, "quarto3.jpg", "Interlagos");
insert into place_to_rental (user_id, price, price_type, short_description, description, city_id, main_picture, neighborhood) values (9, 1200, "MONTH", "Acesso fácil para o Jabaquara e metrô",  "Long description", 1, "quarto2.jpg", "Vila Isa");
insert into place_to_rental (user_id, price, price_type, short_description, description, city_id, main_picture, neighborhood) values (5, 960, "MONTH", "Quarto com acesso a shoppings e metrêos",  "Long description", 2, "quarto1.jpeg", "Butantã");

# PLACE TO LIVE
insert into place_to_live (neighborhood, city_id, user_id) values ("Boa Vista", 1, 1);
insert into place_to_live (neighborhood, city_id, user_id) values ("Interlagos", 2, 2);
insert into place_to_live (neighborhood, city_id, user_id) values ("Cerqueira Cézar", 1, 3);
insert into place_to_live (neighborhood, city_id, user_id) values ("Vila Isa", 1, 4);
insert into place_to_live (neighborhood, city_id, user_id) values ("Bela Vista", 1, 5);
