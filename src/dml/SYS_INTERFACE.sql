-- Create table
create table SYS_INTERFACE
(
  INTERFACE_ID    VARCHAR2(10) not null,
  INTERFACE_NAME  VARCHAR2(100),
  XT_NAME         VARCHAR2(100),
  INTERFACE_TYPE  VARCHAR2(100),
  INSERTFACE_DESC VARCHAR2(100)
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
alter table SYS_INTERFACE
  add constraint PK_SYS_INTERFACE primary key (INTERFACE_ID)
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
alter table SYS_INTERFACE
  add constraint UK_SYS_INTERFACE unique (INTERFACE_NAME, XT_NAME)
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
