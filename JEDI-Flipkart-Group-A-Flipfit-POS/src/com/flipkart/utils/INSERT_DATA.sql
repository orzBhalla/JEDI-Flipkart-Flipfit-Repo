-- Use the FlipFit_Database
USE FlipFit_Database;

-- GymOwner Table Data Insertion
INSERT INTO GymOwner (ownerName, ownerEmail, password, phoneNo, nationalId, GST, PAN, verificationStatus)
VALUES
    ('Rajesh Kumar', 'rajesh.kumar@example.com', 'password123', '9876543210', 'NID001122334', 'GSTIN012345678', 'PANPL1234C', 'verified'),
    ('Priya Sharma', 'priya.sharma@example.com', 'password456', '9123456780', 'NID009876543', 'GSTIN876543210', 'PANPL4321B', 'unverified'),
    ('Vikram Reddy', 'vikram.reddy@example.com', 'password789', '9234567890', 'NID001234567', 'GSTIN098765432', 'PANPL5678D', 'verified');

-- Gym Table Data Insertion
INSERT INTO Gym (gymName, gymAddress, location, ownerId, Status)
VALUES
    ('FlexZone Gym', '123 Fitness Road, Koramangala, Bengaluru', 'Bengaluru', 1, 'verified'),
    ('IronCore Gym', '456 Strength Park, Whitefield, Bengaluru', 'Bengaluru', 2, 'unverified'),
    ('FitNation Gym', '789 Wellness Lane, Indiranagar, Bengaluru', 'Bengaluru', 3, 'verified');

-- Slots Table Data Insertion (Keeping Slot Numbers the Same)
INSERT INTO Slots (startTime, seatCount, gymId)
VALUES
    (6, 20, 1), -- 20 seats, Gym 1
    (9, 15, 1), -- 15 seats, Gym 1
    (11, 10, 2), -- 10 seats, Gym 2
    (14, 25, 3), -- 25 seats, Gym 3
    (18, 30, 2); -- 30 seats, Gym 2

-- User Table Data Insertion
INSERT INTO User (userName, phoneNumber, address, location, email, password)
VALUES
    ('Aarav Singh', '9988776655', '123 Elm Street, Koramangala, Bengaluru', 'Bengaluru', 'aarav.singh@example.com', 'aaravpassword'),
    ('Isha Patel', '9876543210', '456 Oak Avenue, Whitefield, Bengaluru', 'Bengaluru', 'isha.patel@example.com', 'ishapassword'),
    ('Siddharth Desai', '9123456789', '789 Pine Road, Indiranagar, Bengaluru', 'Bengaluru', 'siddharth.desai@example.com', 'siddharthpassword');

-- Bookings Table Data Insertion
INSERT INTO Bookings (userId, bookingStatus, time, slotId, gymId)
VALUES
    (1, 0, 6, 1, 1), -- Aarav booked the slot at Gym 1, pending
    (2, 1, 9, 2, 1), -- Isha confirmed booking for the slot at Gym 1
    (3, 2, 11, 3, 2), -- Siddharth cancelled the AM slot at Gym 2
    (1, 1, 14, 4, 3), -- Aarav confirmed booking for the slot at Gym 3
    (2, 0, 18, 5, 2); -- Isha pending booking for the slot at Gym 2
