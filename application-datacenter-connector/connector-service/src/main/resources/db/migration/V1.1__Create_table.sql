DROP TABLE IF EXISTS PUSH_DATA_TABLE;
CREATE TABLE PUSH_DATA_TABLE(
  ddid    NUMBER(10) not null primary key,
  hzid    NUMBER(10),
  yyid    CHAR(6),
  ksid    NUMBER(10),
  ysid    NUMBER(10),
  czsj    DATE
);