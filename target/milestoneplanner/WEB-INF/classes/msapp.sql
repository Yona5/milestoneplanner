CREATE TABLE IF NOT EXISTS usertable (
  fName VARCHAR(255),
  lName VARCHAR(255),
  email VARCHAR(255) PRIMARY KEY,
  password VARCHAR(255)
  );

CREATE TABLE IF NOT EXISTS project (
  id int AUTO_INCREMENT PRIMARY KEY,
  pName VARCHAR(255),
  description VARCHAR(255),
--   foreign key (email) references usertable(email)
  );


CREATE TABLE IF NOT EXISTS milestone (
  id int AUTO_INCREMENT PRIMARY KEY,
  msName VARCHAR(255),
  description VARCHAR(255),
  dueDate DATE,
  completionDate DATE,
  email VARCHAR(255),
--   foreign key (email) references usertable(email)
);

