CREATE TABLE tools (
  tool_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  tool_type_code NUMBER PRIMARY KEY REFERENCES tool_type(tool_type_code),
  tool_name VARCHAR2(32),
  tool_brand VARCHAR2(32)
);

CREATE TABLE tool_owner (
  owner_id VARCHAR2(256) PRIMARY KEY,
  owner_first_name VARCHAR2(256),
  owner_last_name VARCHAR2(256)
);

CREATE TABLE tool_type (
  tool_type_code NUMBER PRIMARY KEY
);

CREATE TABLE tool_type_txt (
  tool_type_code NUMBER PRIMARY KEY REFERENCES tool_type(tool_type_code),
  language_code CHAR(3),
  tool_type_desc VARCHAR(32)
);

CREATE TABLE owner_tools (
  owner_id VARCHAR2(256) REFERENCES tool_owner(owner_id),
  tool_id NUMBER REFERENCES tools(tool_id),
  PRIMARY KEY (owner_id, tool_id)
);

CREATE TABLE saw (
  tool_id NUMBER PRIMARY KEY REFERENCES tools(tool_id),
  kerf DECIMAL(10,2),
  abrasive BOOLEAN
);

CREATE TABLE circular_saw (
  tool_id NUMBER PRIMARY KEY REFERENCES saw(tool_id),
  blade_diameter DECIMAL(10,4)
);

CREATE TABLE drill (
  tool_id NUMBER PRIMARY KEY REFERENCES tools(tool_id),
  capacity DECIMAL(10,4)
);

CREATE TABLE power_drill (
  tool_id NUMBER PRIMARY KEY REFERENCES drill(tool_id),
  bit_size_min DECIMAL(10,4),
  bit_size_max DECIMAL(10,4)
);

CREATE TABLE ladder (
  tool_id NUMBER PRIMARY KEY REFERENCES tools(tool_id),
  ladder_length DECIMAL(10,4)
);