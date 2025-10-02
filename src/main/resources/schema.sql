/*
create table if not exists Taco_Order (
id identity,
delivery_Name varchar(50) not null,
delivery_Street varchar(50) not null,
delivery_City varchar(50) not null,
delivery_State varchar(2) not null,
delivery_Zip varchar(10) not null,
cc_number varchar(16) not null,
cc_expiration varchar(5) not null,
cc_cvv varchar(3) not null,
placed_at timestamp not null
);
*/
CREATE TABLE IF NOT EXISTS taco_order (
    id BIGSERIAL PRIMARY KEY,
    delivery_name VARCHAR(50) NOT NULL,
    delivery_street VARCHAR(50) NOT NULL,
    delivery_city VARCHAR(50) NOT NULL,
    delivery_state VARCHAR(2) NOT NULL,
    delivery_zip VARCHAR(10) NOT NULL,
    cc_number VARCHAR(19) NOT NULL,
    cc_expiration VARCHAR(5) NOT NULL,
    cc_cvv VARCHAR(3) NOT NULL,
    placed_at TIMESTAMP NOT NULL
);

/*

create table if not exists Taco (
id identity,
name varchar(50) not null,
taco_order bigint not null,
taco_order_key bigint not null,
created_at timestamp not null
);
*/

create table if not exists Taco (
id  BIGSERIAL PRIMARY KEY,
name varchar(50) not null,
taco_order bigint not null,
taco_order_key bigint not null,
created_at timestamp not null
);



create table if not exists Ingredient_Ref (
ingredient varchar(4) not null,
taco bigint not null,
taco_key bigint not null
);


create table if not exists Ingredient (
id varchar(4) not null PRIMARY KEY,
name varchar(25) not null,
type varchar(10) not null
);
-- alter table Taco           add foreign key (taco_order) references Taco_Order(id);
-- alter table Ingredient_Ref add foreign key (ingredient) references Ingredient(id);

/*
ALTER TABLE taco
  ADD CONSTRAINT fk_taco_order
  FOREIGN KEY (taco_order)
  REFERENCES taco_order(id);
*/
/*
ALTER TABLE ingredient_ref
  ADD CONSTRAINT fk_ingredient_ref_ingredient
  FOREIGN KEY (ingredient)
  REFERENCES ingredient(id);
*/