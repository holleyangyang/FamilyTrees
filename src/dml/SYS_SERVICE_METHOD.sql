-- Create table
create table SYS_SERVICE_METHOD
(
  SERVICE_METHOD_ID   VARCHAR2(10) not null,
  SERVICE_ID          VARCHAR2(10) not null,
  SERVICE_METHOD_NAME VARCHAR2(50) not null,
  SERVICE_METHOD_DESC VARCHAR2(500),
  REMARK              VARCHAR2(500),
  IS_USE              VARCHAR2(2) default '是' not null
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
alter table SYS_SERVICE_METHOD
  add constraint PK_SYS_SERVICE_METHOD primary key (SERVICE_METHOD_ID)
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
alter table SYS_SERVICE_METHOD
  add constraint FK_SYS_SERVICE_METHOD foreign key (SERVICE_ID)
  references SYS_SERVICE (SERVICE_ID) on delete cascade
  deferrable initially deferred;
