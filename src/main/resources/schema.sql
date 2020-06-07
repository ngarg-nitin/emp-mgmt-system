CREATE SEQUENCE IF NOT EXISTS dept_sequence START WITH 1 increment by 50;
CREATE SEQUENCE IF NOT EXISTS emp_sequence START WITH 1 increment by 50;
CREATE TABLE IF NOT EXISTS api_token(token_value varchar(255) PRIMARY KEY);
CREATE TABLE IF NOT EXISTS department(id bigint PRIMARY KEY, name varchar(255));
CREATE TABLE IF NOT EXISTS employee(id bigint PRIMARY KEY, first_name varchar(255), last_name varchar(255), department_id bigint ,
FOREIGN KEY (department_id) REFERENCES department(id));