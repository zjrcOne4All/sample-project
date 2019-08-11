CREATE TABLE BI_ORDER_TABLE(
  ddid    NUMBER(10) not null primary key,
  hzid    NUMBER(10) ,
  yyid    CHAR(6),
  yypbid  VARCHAR2(10),
  czsj    DATE,
  yyrq    CHAR(8),
  yysj    CHAR(4),
  yyxh    INTEGER,
  sxwbz   CHAR(1),
  qhmm    CHAR(8),
  ddzt    NUMBER(1),
  hisjg   CHAR(8),
  qhzt    NUMBER(1),
  qhsj    DATE,
  jzsj    DATE,
  yzsj    DATE,
  ffsj    DATE,
  qysj    DATE,
  fwsid   VARCHAR2(4),
  czygh   VARCHAR2(16),
  hyid    NUMBER(10),
  ksid    NUMBER(10),
  hispbid NUMBER(10),
  pbid    NUMBER(10),
  ysid    NUMBER(10),
  xqj     CHAR(1),
  yyqd    NVARCHAR2(1) default 0,
  hisfhsj DATE,
  jfcl    VARCHAR2(2) default 0
);

/**
 * push推送用户订单信息表
 */
CREATE TABLE PUSH_ORDER(
  id    NUMBER(10) not null primary key,
  hospitalId    CHAR(6) not null,
  deptId    NUMBER(10) not null,
  docId    NUMBER(10),
  patientIdCard  VARCHAR2(20) not null,
  patientBirth  VARCHAR2(10),
  patientMobileSection  VARCHAR2(10),
  orderTime  VARCHAR2(10) not null,
  patientSex    CHAR(2) not null,
);