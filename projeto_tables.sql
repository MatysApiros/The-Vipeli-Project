create table books(
	book_id numeric(65),
	title varchar(100),
    subgenre numeric(10),
    numeracao numeric(10),
    avaliacao numeric(1,1),
    
    constraint pk_books primary key(book_id)
);

alter table books add(
	genre_id numeric(10)
);

alter table books add(
	constraint fk_genres
    foreign key(genre_id)
    references genres(genre_id)
);

alter table books add(
	type_id numeric(10)
);

alter table books add(
	constraint fk_books_types
    foreign key(type_id)
    references books_types(type_id)
);

create table genres(
	genre_id numeric(10),
    genre varchar(10),
    read_flag numeric(65),
    
    constraint pk_genres primary key(genre_id)
);

create table books_types(
	type_id numeric(10),
    description varchar(10),
    
    constraint pk_books_types primary key(type_id)
);

create table books_and_genres(
	book_id numeric(65) references books(book_id),
    genre_id numeric(10) references genres(genre_id)
);

alter table books_and_genres add constraint pk_books_and_genres primary key(book_id,genre_id);

/*
ALTER TABLE PRODXCATEG ADD CONSTRAINT PK_PRODUTOSXCATEGORIAS PRIMARY KEY (CODIGO, COD_PRODUTO);
*/