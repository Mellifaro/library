DELETE FROM BOOKS;
DELETE FROM AUTHORS;

INSERT INTO AUTHORS(NAME)
VALUES   ('Jack London'),
         ('Mark Twain');

INSERT INTO BOOKS(TITLE, AUTHOR_ID)
VALUES  ('The God of His Fathers', 1),
        ('Children of the Frost', 1),
        ('Roughing It', 2),
        ('The Gilded Age', 2);

