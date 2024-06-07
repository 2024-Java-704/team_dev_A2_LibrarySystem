CREATE TABLE categories
(
   id SERIAL PRIMARY KEY,
   categories_num TEXT,
   categories_name TEXT
);
CREATE TABLE book
(
   id SERIAL PRIMARY KEY,
   category_id INTEGER,
   title TEXT,
   hurigana TEXT,
   author TEXT,
   publisher TEXT,
   pub_year DATE,
   reg_day DATE,
   library_id INTEGER,
   condition_id INTEGER,
   cnt INTEGER,
   img TEXT
);
CREATE TABLE library
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   address TEXT,
   tel TEXT
);
CREATE TABLE status
(
   id SERIAL PRIMARY KEY,
   name TEXT
);
CREATE TABLE condition
(
   id SERIAL PRIMARY KEY,
   name TEXT
);
CREATE TABLE user
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   email TEXT,
   address TEXT,
   tel TEXT,
   password TEXT
);
CREATE TABLE library_staff
(
   id SERIAL PRIMARY KEY,
   library_id INTEGER,
   name TEXT,
   email TEXT,
   password TEXT
);
CREATE TABLE library_manager
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   email TEXT,
   password TEXT
);
CREATE TABLE lending
(
   id SERIAL PRIMARY KEY,
   user_id INTEGER,
   book_id INTEGER,
   lend_date DATE,
   limit_date DATE,
   returned_date DATE,
   reservation_id INTEGER,
   staff_id INTEGER
);
CREATE TABLE reservation
(
   id SERIAL PRIMARY KEY,
   user_id INTEGER,
   book_id INTEGER,
   reservation_date DATE,
   scheduled_date DATE,
   reservation_library_id INTEGER,
   status_id INTEGER
);