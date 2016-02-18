-- Create table
create table SYS_SAO_METHOD_INTERFACE
(
  SAO_METHOD_INTERFACE_ID VARCHAR2(10) not null,
  SAO_METHOD_ID           VARCHAR2(10) not null,
  SAO_ID                  VARCHAR2(10) not null,
  INTERFACE_ID            VARCHAR2(10),
  FLOW_SERVICE_SAO_ID     VARCHAR2(10) default 1 not null
)
tablespace EBANKDATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_SAO_METHOD_INTERFACE
  add constraint PK_SYS_SAO_METHOD_INTERFACE primary key (SAO_METHOD_INTERFACE_ID)
  using index 
  tablespace EBANKDATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
