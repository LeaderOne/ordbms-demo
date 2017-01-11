CREATE OR REPLACE TYPE tools_typ AS (
  tool_id BIGINT,
  tool_name VARCHAR(32),
  tool_brand VARCHAR(32)
);

CREATE TABLE tools OF tools_typ ( PRIMARY KEY(tool_id) );

CREATE TABLE tool_owner (
  owner_id VARCHAR(256),
  owner_first_name VARCHAR(256),
  owner_last_name VARCHAR(256)
);

CREATE TABLE owner_tools (
  owner_id VARCHAR(256) REFERENCES tool_owner(owner_id),
  tool_id NUMBER REFERENCES tools(tool_id),
  PRIMARY KEY (owner_id, tool_id)
);

CREATE OR REPLACE TYPE saw_typ UNDER tools_typ AS (
  kerf DECIMAL(10,2),
  abrasive BOOLEAN
);

CREATE TABLE saw OF saw_typ UNDER tools INHERIT SELECT PRIVILEGES;

CREATE OR REPLACE TYPE circular_saw_typ UNDER tools AS (
  blade_diameter DECIMAL(10,4)
);

CREATE TABLE circular_saw OF circular_saw_typ UNDER saw INHERIT SELECT PRIVILEGES;

CREATE OR REPLACE TYPE drill_typ UNDER tools AS (
  capacity DECIMAL(10,4)
);

CREATE TABLE drill OF drill_typ UNDER tools INHERIT SELECT PRIVILEGES;

CREATE OR REPLACE TYPE power_drill_typ UNDER tools AS (
  bit_size_min DECIMAL(10,4),
  bit_size_max DECIMAL(10,4)
);

CREATE TABLE power_drill OF power_drill_typ UNDER drill INHERIT SELECT PRIVILEGES;

CREATE OR REPLACE TYPE ladder_typ UNDER tools_typ AS (
  ladder_length DECIMAL(10,4)
);

CREATE TABLE ladder OF ladder_typ UNDER tools INHERIT SELECT PRIVILEGES;

