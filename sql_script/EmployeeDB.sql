create table employee (
                          employee_id serial primary key,
                          employee_name varchar(50) not null,
                          employee_salary float not null,
                          employee_age int not null,
                          employee_city varchar(50) not null
);