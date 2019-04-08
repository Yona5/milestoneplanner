CREATE TABLE IF NOT EXISTS milestone (
  id int AUTO_INCREMENT PRIMARY KEY,
  milestone VARCHAR(255), --remove this one after the rest of code is updated
  msName VARCHAR(255),
  description VARCHAR(255),
  dueDate DATE,
  completionDate DATE
);