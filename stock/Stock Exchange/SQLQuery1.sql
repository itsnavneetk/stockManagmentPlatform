create database stock 
use stock 

create table login (ID int identity(1,1) primary key , userN varchar(10), password varchar(20)  );
create table stockT (sID int identity(1,1) primary key, name varchar(10), c_name varchar(20), disc varchar(30));
create table portfolio(u_ID int identity(1,1) primary key, ID int, sID int, p_price numeric(4,3), dop date, qty int, 
foreign key (ID) references login(ID),
foreign key (sID) references stockT(sID) );
create table userDetails (ID int, name varchar(10), phonen int, email varchar(20), balance numeric(6,3), bankD varchar(20), 
foreign key (ID) references login(ID) );
