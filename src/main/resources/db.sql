DROP DATABASE IF EXISTS contact
CREATE DATABASE IF NOT EXISTS contact DEFAULT CHARACTER SET utf8;
USE contact;
CREATE TABLE CONTACTS
  (
     id          INT PRIMARY KEY AUTO_INCREMENT,
     name        VARCHAR(30),
     surname     VARCHAR(30),
     login        VARCHAR(15),
     email        VARCHAR(30),
     phone_number int
  );
  
  

  SELECT * from contact.contacts;
  
  
	LOAD DATA INFILE 'In.csv' REPLACE INTO TABLE `CONTACTS`
	FIELDS TERMINATED BY ','
	ENCLOSED BY '"'
	ESCAPED BY '\\'
	LINES TERMINATED BY '\r\n';