CREATE TABLE IF NOT EXISTS milestone (
  id int AUTO_INCREMENT PRIMARY KEY,
  msName VARCHAR(255),
  description VARCHAR(255),
  dueDate DATE,
  completionDate DATE
);