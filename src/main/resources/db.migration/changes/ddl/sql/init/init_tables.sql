create table roles(
id uuid primary key,
role varchar
);

create table users(
id uuid primary key,
name varchar,
surname varchar,
email varchar,
password varchar
);

create table user_to_role(
user_id uuid not null,
role_id uuid not null,
primary key(user_id, role_id),
constraint FK_roles foreign key (role_id) references roles(id),
constraint FK_users foreign key (user_id) references users(id)

);


create table threads(
id uuid primary key,
user_id uuid,
thread_name varchar,
first_text varchar,
constraint fk_threads foreign key(user_id) references users(id)
);

create table replies(
id uuid primary key,
thread_id uuid,
replie_text varchar,
constraint fk_replies foreign key(thread_id) references threads(id)
);