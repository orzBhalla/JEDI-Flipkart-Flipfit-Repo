-- Use the FlipFit_Database
USE FlipFit_Database;

-- GymOwner Table Data Insertion
INSERT INTO GymOwner (ownerName, ownerEmail, password, phoneNo, nationalId, GST, PAN, verificationStatus)
VALUES
    ('John Doe', 'john.doe@example.com', 'password123', '9876543210', 'NID001122334', 'GSTIN012345678', 'PANPL1234C', 'verified'),
    ('Jane Smith', 'jane.smith@example.com', 'password456', '9123456780', 'NID009876543', 'GSTIN876543210', 'PANPL4321B', 'unverified'),
    ('Michael Brown', 'michael.brown@example.com', 'password789', '9234567890', 'NID001234567', 'GSTIN098765432', 'PANPL5678D', 'verified');

-- Gym Table Data Insertion
INSERT INTO Gym (gymName, gymAddress, location, ownerId, Status)
VALUES
    ('FitFlex Gym', '123 Fitness Street, New York', 'New York', 1, 'verified'),
    ('PowerHouse Gym', '456 Strength Avenue, Los Angeles', 'Los Angeles', 2, 'unverified'),
    ('BeFit Gym', '789 Wellness Blvd, Chicago', 'Chicago', 3, 'verified');

-- Slots Table Data Insertion
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
    ('Alice Johnson', '9988776655', '123 Elm Street, New York', 'New York', 'alice.johnson@example.com', 'alicepassword'),
    ('Bob Williams', '9876543210', '456 Oak Avenue, Los Angeles', 'Los Angeles', 'bob.williams@example.com', 'bobpassword'),
    ('Charlie Davis', '9123456789', '789 Pine Road, Chicago', 'Chicago', 'charlie.davis@example.com', 'charliepassword');

-- Bookings Table Data Insertion
INSERT INTO Bookings (userId, bookingStatus, time, slotId, gymId)
VALUES
    (1, 0, 6, 1, 1), -- Alice booked the slot at Gym 1, pending
    (2, 1, 9, 2, 1), -- Bob confirmed booking for the slot at Gym 1
    (3, 2, 11, 3, 2), -- Charlie cancelled the AM slot at Gym 2
    (1, 1, 14, 4, 3), -- Alice confirmed booking for the slot at Gym 3
    (2, 0, 18, 5, 2); -- Bob pending booking for the slot at Gym 2
