create table books(
	book_id int(11) auto_increment,
	title varchar(100) not null,	
    numeracao decimal(10,0) not null,
    avaliacao numeric(4,2),
    read_flag decimal(10,0),
    type_id int(10),
    
    constraint pk_books primary key(book_id)
);

create table genres(
	genre_id int(10) auto_increment,
    genre varchar(50),
    
    constraint pk_genres primary key(genre_id)
);

create table books_types(
	type_id int(10) auto_increment,
    description varchar(50),
    
    constraint pk_books_types primary key(type_id)
);

create table books_and_genres(
	book_id numeric(65) references books(book_id),
    genre_id numeric(10) references genres(genre_id),
    
    constraint pk_books_and_genres primary key(book_id,genre_id)
);

alter table books add constraint fk_books_types foreign key (type_id) references books_types(type_id);
