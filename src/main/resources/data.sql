insert into city (name) values ('Erzurum'), ('Trabzon'), ('İstanbul'), ('Ankara'), ('Adana'), ('İzmir'), ('Gaziantep'), ('Elazığ'), ('Şanlıurfa'), ('Zonguldak'), ('Erzincan'), ('Kırklareli')

insert into Guide (name, surname, experience, gender) values ('Osman',  'Durdağ',    1,  0), ('Fatma',  'Deneyimli', 15, 1), ('Mehmet', 'Acemi',     1,  0), ('Ayşe',   'Becerikli', 3,  1), ('Veli',   'Kaygılı',   4,  0), ('Merve',  'Uzman',     7,  1), ('Ali',    'Umutlu',    1,  0)


insert into Tour (name, date, price, route, guide_id) values ('Okul Gezisi', CURRENT_DATE(), 150.00, '5,1,7', (select id from Guide where id = 1))
insert into Tour (name, date, price, route, guide_id) values ('İş Gezisi', '2020-02-15 15:00:00', 1500.00, '1,2,4', (select id from Guide where id = 4))
insert into Tour (name, date, price, route, guide_id) values ('Keşif Gezisi', '2020-03-10 12:30:00', 7500.99, '3,9,11', (select id from Guide where id = 3))
