use petowners;
insert into breeds values(1,'yellow lab');
insert into breeds values(2,'poodle');
insert into breeds values(3,'black lab');
insert into breeds values (4, 'beagle');
insert into breeds values (5, 'bulldog');
insert into breeds values (6, 'golden retriever');
insert into breeds values (7, 'husky');
insert into breeds values (8, 'chihuahua');

select * from breeds;
insert into cities values ("NEW YORK",10012);
insert into cities values ("LOS ANGELES",90001);
insert into cities values ("MIAMI",33101);
insert into cities values ('CHICAGO', 60601);
insert into cities values ('HOUSTON', 77001);
insert into cities values ('PHOENIX', 85001);
insert into cities values ('PHILADELPHIA', 19019);
insert into cities values ('SAN ANTONIO', 78201);

select * from cities;
insert into owners values (1,10012,'DAVID',111111);
insert into owners values (2,90001,'REBECCA',222222);
insert into owners values (3,33101,'JORDAN',3333333);
insert into owners values (4, 60601, 'MICHAEL', 444444);
insert into owners values (5, 77001, 'SARAH', 555555);
insert into owners values (6, 85001, 'LINDA', 666666);
insert into owners values (7, 19019, 'JAMES', 777777);
insert into owners values (8, 78201, 'PATRICIA', 888888);

select * from owners;
insert into pets values (1,'HUNTER',1);
insert into pets values (2,'MICHAEL',2);
insert into pets values (3,'BEAR',3);
insert into pets values (4, 'MAX', 4);
insert into pets values (5, 'ROCKY', 5);
insert into pets values (6, 'BELLA', 6);
insert into pets values (7, 'LUNA', 7);
insert into pets values (8, 'DAISY', 8);
select * from pets;
insert into ownerpet values (1,1);
insert into ownerpet values (1,2);
insert into ownerpet values (2,3);
insert into ownerpet values (2, 4);
insert into ownerpet values (4, 5);
insert into ownerpet values (6, 6);
insert into ownerpet values (6, 7);
insert into ownerpet values (7, 8);

select * from ownerpet;
#1.query to find all petnames
select petname from pets;
#2.query to find petnames with its breed
select p.petname ,b.breedname from pets p join breeds b on p.breedno=b.breedno ;
#3.query to find all pets and their respective owners names
select o.ownername,p.petname from pets p join ownerpet op on p.petid=op.petid join owners o on op.ownerid = o.ownerid;
#4.query to find petname from by using ownername
select o.ownername,p.petname from pets p join ownerpet op on p.petid=op.petid join owners o on op.ownerid = o.ownerid where o.ownername='DAVID';
#5.query to find owner by using petname
select o.ownername,p.petname from pets p join ownerpet op on p.petid=op.petid join owners o on op.ownerid = o.ownerid where p.petname='MAX';
#6.query to find petname by using breedname
select p.petname ,b.breedname from pets p join breeds b on p.breedno=b.breedno where b.breedname='husky';
#7.query to find owner from which city and their petnames
select c.city, o.ownername, p.petname from owners o join cities c on o.postalcode = c.postalcode join ownerpet op ON o.ownerid = op.ownerid join pets p on op.petid = p.petid;
#8.query to find total no of pets from each city
select c.city, count(p.petid) AS total_pets from cities c join owners o on c.postalcode = o.postalcode join ownerpet op on o.ownerid = op.ownerid join pets p on op.petid = p.petid group by c.city;
#9.query to find owners with their respective city
select c.city, o.ownername from owners o join cities c on o.postalcode = c.postalcode join ownerpet op ON o.ownerid = op.ownerid ;
#10.query to find owner with more than 1 pet.
select o.ownername, count(op.petid) AS num_pets from owners o join ownerpet op on o.ownerid = op.ownerid group by o.ownername having count(op.petid) > 1;
#11.query to print all columns of all tables
select  o.ownername,o.phoneno,op.ownerid,p.petname,p.petid,c.city,c.postalcode,b.breedname,b.breedno from owners o left join cities c on c.postalcode=o.postalcode  left join ownerpet op on o.ownerid = op.ownerid  left join pets p on p.petid=op.petid left join breeds b on  b.breedno=p.breedno;








