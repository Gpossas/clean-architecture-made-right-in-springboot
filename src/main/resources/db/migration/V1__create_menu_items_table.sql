create table menu_items(
    id UUID default gen_random_uuid() primary key,
    name varchar(30) not null,
    price numeric(6, 2) not null,
    description text
);