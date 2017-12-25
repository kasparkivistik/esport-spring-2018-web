ALTER TABLE TicketTypes CHANGE baseCost cost DECIMAL(15,2) NOT NULL;
ALTER TABLE TicketTypes ADD availableFrom DATETIME NULL;
ALTER TABLE TicketTypes ADD availableUntil DATETIME NULL;
ALTER TABLE TicketTypes ADD parentTicketTypeId INT NULL;
ALTER TABLE TicketTypes
  ADD CONSTRAINT TicketTypes_TicketTypes_id_fk
FOREIGN KEY (parentTicketTypeId) REFERENCES TicketTypes (id);