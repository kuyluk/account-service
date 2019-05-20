drop table if exists accounts;

create table accounts(

  id int not null AUTO_INCREMENT,
  first_name varchar(100) not null,
  second_name varchar(100) not null,
  account_number varchar(10) not null,

  PRIMARY KEY ( ID )
);