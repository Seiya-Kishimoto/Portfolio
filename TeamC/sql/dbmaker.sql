create database booksanta;

CREATE TABLE bookdata (
ISBN CHAR(13) ,
STORAGE VARCHAR(100) NOT NULL,
TITLE VARCHAR(100) NOT NULL,
WRITER VARCHAR(100) NOT NULL,
PUBLISHER VARCHAR(100) NOT NULL,
KEYWORD VARCHAR(100) NOT NULL,
GENERATION VARCHAR(100) NOT NULL,
CATEGORY VARCHAR(100) NOT NULL, 
GENRE VARCHAR(100) NOT NULL,
COUNT INT NOT NULL,
PRIMARY KEY(ISBN, STORAGE)
);

CREATE TABLE address (
NAME VARCHAR(100) PRIMARY KEY, 
PREF VARCHAR(100) NOT NULL, 
ADDR VARCHAR(100), 
TYPE VARCHAR(100) NOT NULL, 
PASS VARCHAR(100) NOT NULL 
);

CREATE TABLE ordr(
ID INT PRIMARY KEY AUTO_INCREMENT,
TITLE VARCHAR(100) NOT NULL, 
STORAGE VARCHAR(100) NOT NULL, 
NEARESTSTRG VARCHAR(100) NOT NULL, 
DESTINATION VARCHAR(100) NOT NULL 
);