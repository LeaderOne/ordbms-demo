CREATE TABLE tools (
  tool_id SERIAL8 PRIMARY KEY,
  tool_name TEXT,
  tool_brand TEXT
);

CREATE TABLE tool_rentals (
  rental_price DECIMAL(10,2)
);

CREATE TABLE tool_owner (
  owner_id TEXT PRIMARY KEY,
  owner_first_name TEXT,
  owner_last_name TEXT
);

CREATE TABLE owner_tools (
  owner_id TEXT REFERENCES tool_owner(owner_id),
  tool_id BIGINT REFERENCES tools(tool_id),
  PRIMARY KEY (owner_id, tool_id)
);

CREATE TABLE saw (
  kerf DECIMAL(10,2),
  abrasive BOOLEAN,
  PRIMARY KEY (tool_id)
) INHERITS (tools);

CREATE TABLE circular_saw (
  blade_diameter DECIMAL(10,4),
  PRIMARY KEY (tool_id)
) INHERITS(saw, tool_rentals);

CREATE TABLE drill (
  capacity DECIMAL(10,4),
  PRIMARY KEY (tool_id)
) INHERITS (tools);

CREATE TABLE power_drill (
  bit_size_min DECIMAL(10,4),
  bit_size_max DECIMAL(10,4),
  PRIMARY KEY (tool_id)
) INHERITS (tools, tool_rentals);

CREATE TABLE ladder (
  ladder_length DECIMAL(10,4),
  PRIMARY KEY (tool_id)
) INHERITS (tools);