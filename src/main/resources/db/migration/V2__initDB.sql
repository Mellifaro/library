DROP TABLE IF EXISTS books CASCADE;
DROP TABLE IF EXISTS authors CASCADE;

CREATE TABLE authors (
  id            INTEGER PRIMARY KEY AUTO_INCREMENT,
  name          VARCHAR UNIQUE
);

CREATE TABLE books (
  id            INTEGER PRIMARY KEY AUTO_INCREMENT,
  title          VARCHAR NOT NULL,
  author_id     INTEGER,
  FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE
);