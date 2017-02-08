select * from city;
select * from state;
select max(streetId),cityId from street group by cityId;

insert into street(streetName,cityId) values('Rajpur Road', 1);
insert into street(streetName,cityId) values('Motdhak', 3);
insert into street(streetName,cityId) values('Sahastradhara Rd', 1);