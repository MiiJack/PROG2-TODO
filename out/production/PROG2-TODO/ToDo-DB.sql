DROP DATABASE tododb;
CREATE DATABASE tododb;
\c tododb
CREATE TABLE todo (
  id serial PRIMARY KEY,
  title VARCHAR(200) NOT NULL,
  description text,
  deadline TIMESTAMP CHECK (deadline >= CURRENT_TIMESTAMP),
  priority int CHECK (priority >0 AND priority <=10),
  done boolean DEFAULT false
);
