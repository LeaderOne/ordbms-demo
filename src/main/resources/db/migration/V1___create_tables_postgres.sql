--CREATE DATABASE tool_share;
CREATE USER tool_user WITH PASSWORD 'tool_user';

CREATE TABLE tools (
  tool_id SERIAL8 PRIMARY KEY,
  tool_name TEXT,
  tool_brand TEXT
);

ALTER TABLE tools OWNER TO tool_user;

CREATE TABLE tool_rentals (
  rental_price DECIMAL(10,2)
);

ALTER TABLE tool_rentals OWNER TO tool_user;

CREATE TABLE tool_owner (
  owner_id TEXT PRIMARY KEY,
  owner_first_name TEXT,
  owner_last_name TEXT
);

ALTER TABLE tool_owner OWNER TO tool_user;

CREATE TABLE owner_tools (
  owner_id TEXT REFERENCES tool_owner(owner_id),
  tool_id BIGINT REFERENCES tools(tool_id),
  PRIMARY KEY (owner_id, tool_id)
);

ALTER TABLE owner_tools OWNER TO tool_user;

CREATE TABLE saw (
  kerf DECIMAL(10,2),
  abrasive BOOLEAN,
  PRIMARY KEY (tool_id)
) INHERITS (tools);

ALTER TABLE saw OWNER TO tool_user;

CREATE TABLE circular_saw (
  blade_diameter DECIMAL(10,4),
  PRIMARY KEY (tool_id)
) INHERITS(saw, tool_rentals);

ALTER TABLE circular_saw OWNER TO tool_user;

CREATE TABLE drill (
  capacity DECIMAL(10,4),
  PRIMARY KEY (tool_id)
) INHERITS (tools);

ALTER TABLE drill OWNER TO tool_user;

CREATE TABLE power_drill (
  bit_size_min DECIMAL(10,4),
  bit_size_max DECIMAL(10,4),
  PRIMARY KEY (tool_id)
) INHERITS (tools, tool_rentals);

ALTER TABLE power_drill OWNER TO tool_user;

CREATE TABLE ladder (
  ladder_length DECIMAL(10,4),
  PRIMARY KEY (tool_id)
) INHERITS (tools);

ALTER TABLE ladder OWNER TO tool_user;