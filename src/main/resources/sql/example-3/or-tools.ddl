CREATE OR REPLACE TYPE tools_typ AS OBJECT (
  tool_id NUMBER,
  tool_name VARCHAR2(32),
  tool_brand VARCHAR2(32)
);

CREATE TABLE tools OF tools_typ (
  tool_id PRIMARY KEY
);

CREATE TABLE tool_owner (
  owner_id VARCHAR2(256),
  owner_first_name VARCHAR2(256),
  owner_last_name VARCHAR2(256)
);

CREATE TABLE owner_tools (
  owner_id VARCHAR2(256) REFERENCES tool_owner(owner_id),
  tool_id NUMBER REFERENCES tools(tool_id),
  PRIMARY KEY (owner_id, tool_id)
);

CREATE OR REPLACE TYPE saw_typ UNDER tools_typ (
  kerf DECIMAL(10,2),
  abrasive BOOLEAN
);

CREATE OR REPLACE TYPE circular_saw_typ UNDER tools (
  blade_diameter DECIMAL(10,4)
);

CREATE OR REPLACE TYPE drill_typ UNDER tools (
  capacity DECIMAL(10,4)
);

CREATE OR REPLACE TYPE power_drill_typ UNDER tools (
  bit_size_min DECIMAL(10,4),
  bit_size_max DECIMAL(10,4)
);

CREATE OR REPLACE TYPE ladder_typ UNDER tools (
  ladder_length DECIMAL(10,4)
);

