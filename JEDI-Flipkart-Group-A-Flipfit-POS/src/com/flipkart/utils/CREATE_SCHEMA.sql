CREATE DATABASE FlipFit_Database;

USE FlipFit_Database;

CREATE TABLE GymOwner (
    ownerId INT PRIMARY KEY AUTO_INCREMENT,
    ownerName VARCHAR(255),
    ownerEmail VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phoneNo VARCHAR(20),
    nationalId VARCHAR(50) NOT NULL,
    GST VARCHAR(50) NOT NULL,
    PAN VARCHAR(50) NOT NULL,
    verificationStatus VARCHAR(50) DEFAULT 'unverified'
);

CREATE TABLE Gym (
    gymId INT PRIMARY KEY AUTO_INCREMENT,
    gymName VARCHAR(255),
    gymAddress VARCHAR(255),
    location VARCHAR(255) NOT NULL,
    ownerId INT NOT NULL,
    Status VARCHAR(50) DEFAULT 'unverified',
    FOREIGN KEY (ownerId) REFERENCES GymOwner(ownerId)
);

CREATE TABLE Slots (
    slotsId INT PRIMARY KEY AUTO_INCREMENT,
    startTime INT NOT NULL,
    seatCount INT NOT NULL CHECK (seatCount >= 0),
    gymId INT NOT NULL,
    FOREIGN KEY (gymId) REFERENCES Gym(gymId),
    UNIQUE (gymId, startTime)
);

CREATE TABLE User (
    userId INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(255),
    phoneNumber VARCHAR(20),
    address VARCHAR(255),
    location VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE Bookings (
    bookingId INT PRIMARY KEY AUTO_INCREMENT,
    userId INT NOT NULL,
    bookingStatus INT DEFAULT 0 CHECK (bookingStatus IN (0, 1, 2)),
    time INT NOT NULL,
    slotId INT NOT NULL,
    gymId INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES User(userId),
    FOREIGN KEY (slotId) REFERENCES Slots(slotsId),
    FOREIGN KEY (gymId) REFERENCES Gym(gymId)
);