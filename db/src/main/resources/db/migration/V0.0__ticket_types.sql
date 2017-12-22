CREATE TABLE TicketTypes
(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  amountAvailable INT NOT NULL,
  baseCost DECIMAL(15, 2) NOT NULL
);
CREATE UNIQUE INDEX TicketTypes_name_uindex ON TicketTypes (name);

CREATE TABLE Tickets
(
  id INT PRIMARY KEY AUTO_INCREMENT,
  typeId INT NOT NULL,
  ownerEmail VARCHAR(255) NOT NULL,
  ownerSteamId VARCHAR(255),
  status VARCHAR(255) NOT NULL,
  dateCreated DATETIME NOT NULL DEFAULT NOW(),
  CONSTRAINT Tickets_TicketTypes_id_fk FOREIGN KEY (typeId) REFERENCES TicketTypes (id)
);