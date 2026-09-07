create table tbl_user (
	id bigint auto_increment primary key,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	nationality varchar(255) not null,
	occupation varchar(255) not null,
	known_for varchar(255) not null,
	email varchar(255) not null,
	phone varchar(255) not null
);