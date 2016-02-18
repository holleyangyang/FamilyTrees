-- Create table
create table SYS_FLOW_CONTROLLER_ACTION
(
  FLOW_CONTROOLER_ACTION_ID VARCHAR2(10) not null,
  CONTROLLER_ID             VARCHAR2(10) not null,
  CONTROLLER_METHOD_ID      VARCHAR2(10) not null,
  ACTION_ID                 VARCHAR2(10) not null
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
alter table SYS_FLOW_CONTROLLER_ACTION
  add constraint PK_FLOW_CONTROOLER_ACTION_ID primary key (FLOW_CONTROOLER_ACTION_ID)
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
