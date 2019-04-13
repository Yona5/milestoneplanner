CREATE TABLE IF NOT EXISTS project (
  id int AUTO_INCREMENT PRIMARY KEY,
  pName VARCHAR(255),
  description VARCHAR(255),
  foreign key (id) references users(id)
);