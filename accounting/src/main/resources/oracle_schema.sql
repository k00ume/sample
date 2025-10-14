CREATE TABLE users (
    username VARCHAR2(50) PRIMARY KEY,
    password VARCHAR2(100) NOT NULL
);

CREATE TABLE transactions (
    id NUMBER PRIMARY KEY,
    date DATE NOT NULL,
    category VARCHAR2(100),
    amount NUMBER(10,2),
    description VARCHAR2(255)
);

CREATE SEQUENCE transactions_seq START WITH 1 INCREMENT BY 1;

INSERT INTO users (username, password) VALUES ('admin', 'admin');
