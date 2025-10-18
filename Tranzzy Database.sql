CREATE DATABASE IF NOT EXISTS project;
USE project;
drop table users;
    DROP TABLE tours;
    drop table parcels;
CREATE TABLE IF NOT EXISTS users(
	user_id INT PRIMARY KEY AUTO_INCREMENT Not null,
    name VARCHAR(30) NOT NULL,
    password VARCHAR(20) NOT NULL
    );
    USE project;
DROP TABLE IF EXISTS tours;
CREATE TABLE IF NOT EXISTS tours(
	name VARCHAR(30),
	user_id INT ,
    seats INT,
    tour_id INT PRIMARY KEY AUTO_INCREMENT,
	pickUp VARCHAR(30) NOT NULL,
    destination VARCHAR(30),
    hasAC BOOLEAN DEFAULT FALSE,
    vehicle VARCHAR(20),
    fare DOUBLE ,
    
    foreign key (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE
    );
    DROP TABLE parcels;
    use project;
CREATE TABLE IF NOT EXISTS parcels(
	senderName VARCHAR(30) NOT NULL,
    receiverName VARCHAR(30) NOT NULL,
    senderNo VARCHAR(11) NOT NULL,
    receiverNo VARCHAR(11) NOT NULL,
	parcel_id INT PRIMARY KEY AUTO_INCREMeNT,
    user_id INT,
    weight DOUBLE NOT NULL,
    senderLocation VARCHAR(30),
    receiverLocation VARCHAR(30),
    fragile BOOLEAN default false,
    cashOnDelivery boolean default false,
    urgent boolean default false,
    charges double ,
    
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE

    );