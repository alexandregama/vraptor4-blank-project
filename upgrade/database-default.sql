delete from place_to_live;
delete from place_to_rental;
delete from user;

# USERS
insert into user (first_name, last_name, email, password, gender, birthday, city_id, photo, smoker, place_type, accepts_perfil_suggestion)
values ("Alexandre", "Gama", "alexandre@gmail.com", "123456", "M", "1986/06/25", (select id from city where name = "São Paulo" limit 1), "alexandre.jpeg", "N", "NEEDS", "Y");

insert into user (first_name, last_name, email, password, gender, birthday, city_id, photo, smoker, place_type, accepts_perfil_suggestion)
values ("Carla", "Souza", "carla@gmail.com", "123456", "F", "1987/07/25", (select id from city where name = "São Paulo" limit 1), "carla.jpg", "N", "NEEDS", "Y");

insert into user (first_name, last_name, email, password, gender, birthday, city_id, photo, smoker, place_type, accepts_perfil_suggestion)
values ("Ronery", "Souza", "ronery.souza@gmail.com", "123456", "M", "1987/03/07", (select id from city where name = "Rio de Janeiro" limit 1), "ronery.jpeg", "S", "NEEDS", "Y");

insert into user (first_name, last_name, email, password, gender, birthday, city_id, photo, smoker, place_type, accepts_perfil_suggestion)
values ("Nicole", "Maia", "nicole@gmail.com", "123456", "F", "1989/01/13", (select id from city where name = "Rio de Janeiro" limit 1), "nicole.jpg", "S", "NEEDS", "Y");

# USER HAS SPACE
insert into user (first_name, last_name, email, password, gender, birthday, city_id, photo, smoker, place_type, accepts_perfil_suggestion)
values ("Mônica", "Cristina", "monica@gmail.com", "123456", "F", "1991/11/23", (select id from city where name = "São Paulo" limit 1), "monica.jpg", "N", "HAS", "Y");

insert into user (first_name, last_name, email, password, gender, birthday, city_id, photo, smoker, place_type, accepts_perfil_suggestion)
values ("Fabrício", "Souza", "fabricio@gmail.com", "123456", "M", "1993/11/23", (select id from city where name = "São Paulo" limit 1), "fabricio.jpeg", "N", "HAS", "Y");

insert into user (first_name, last_name, email, password, gender, birthday, city_id, photo, smoker, place_type, accepts_perfil_suggestion)
values ("Priscila", "Silva", "priscila@gmail.com", "123456", "F", "1988/10/21", (select id from city where name = "Rio de Janeiro" limit 1), "priscila.jpg", "S", "HAS", "Y");

insert into user (first_name, last_name, email, password, gender, birthday, city_id, photo, smoker, place_type, accepts_perfil_suggestion)
values ("Maria", "Santana", "maria@gmail.com", "123456", "F", "1991/09/19", (select id from city where name = "Rio de Janeiro" limit 1), "maria.jpg", "N", "HAS", "Y");

insert into user (first_name, last_name, email, password, gender, birthday, city_id, photo, smoker, place_type, accepts_perfil_suggestion)
values ("Paola", "Prateado", "paola@gmail.com", "123456", "F", "1995/10/26", (select id from city where name = "São Paulo" limit 1), "paola.jpeg", "N", "HAS", "Y");

# ROOM
insert into place_to_rental (user_id, price, price_type, short_description, description, city_id, main_picture, neighborhood)
values ((select id from user where email = "monica@gmail.com"), 400, "MONTH", "Dividindo apartamento perto da Av Paulista",  "Long description", (select id from city where name = "São Paulo" limit 1), "quarto1.jpeg", "Jardins");

insert into place_to_rental (user_id, price, price_type, short_description, description, city_id, main_picture, neighborhood)
values ((select id from user where email = "fabricio@gmail.com"), 880, "MONTH", "Ótimo apartamento perto do centro",  "Long description", (select id from city where name = "São Paulo" limit 1), "quarto2.jpg", "Boa Vista");

insert into place_to_rental (user_id, price, price_type, short_description, description, city_id, main_picture, neighborhood)
values ((select id from user where email = "priscila@gmail.com"), 880, "WEEK", "Incrível quarto com sacada para o mar",  "Long description", (select id from city where name = "Rio de Janeiro" limit 1), "quarto3.jpg", "Interlagos");

insert into place_to_rental (user_id, price, price_type, short_description, description, city_id, main_picture, neighborhood)
values ((select id from user where email = "maria@gmail.com"), 1200, "MONTH", "Acesso fácil para o Jabaquara e metrô",  "Long description", (select id from city where name = "São Paulo" limit 1), "quarto2.jpg", "Vila Isa");

insert into place_to_rental (user_id, price, price_type, short_description, description, city_id, main_picture, neighborhood)
values ((select id from user where email = "paola@gmail.com"), 960, "MONTH", "Quarto com acesso a shoppings e metrêos",  "Long description", (select id from city where name = "Rio de Janeiro" limit 1), "quarto1.jpeg", "Butantã");

# PLACE TO LIVE
insert into place_to_live (city_id, user_id)
values ((select id from city where name = "São Paulo" limit 1), (select id from user where email = "alexandre@gmail.com"));

insert into place_to_live (city_id, user_id)
values ((select id from city where name = "Rio de Janeiro" limit 1), (select id from user where email = "carla@gmail.com"));

insert into place_to_live (city_id, user_id)
values ((select id from city where name = "São Paulo" limit 1), (select id from user where email = "ronery@gmail.com"));

insert into place_to_live (city_id, user_id)
values ((select id from city where name = "São Paulo" limit 1), (select id from user where email = "nicole@gmail.com"));
