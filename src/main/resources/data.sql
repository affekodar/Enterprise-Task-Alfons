INSERT INTO addresses (street, postal_code, city)
VALUES ('Ekogatan 12', '12345', 'Stockholm'),
       ('Lundagatan 8', '54321', 'Göteborg'),
       ('Skogsvägen 4', '67890', 'Malmö'),
       ('Kyrkogatan 2', '98765', 'Uppsala'),
       ('Sjövägen 6', '13579', 'Linköping');


INSERT INTO members (first_name, last_name, address_id, email, phone, date_of_birth)
VALUES ('Alfons', 'Lindberg', 1, 'alfons@best.com', '0707763997', '1998-10-26'),
       ('Emma', 'Andersson', 2, 'emma@example.com', '0731234567', '1995-08-15'),
       ('Oscar', 'Johansson', 3, 'oscar@example.com', '0729876543', '1997-04-20'),
       ('Ida', 'Svensson', 1, 'ida@example.com', '0765554433', '1993-11-30'),
       ('Erik', 'Nilsson', 3, 'erik@example.com', '0701112223', '1999-02-10');

