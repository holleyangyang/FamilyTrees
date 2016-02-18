-- Create table
create table SYS_SERVICE
(
  SERVICE_ID   VARCHAR2(10) not null,
  SERVICE_NAME VARCHAR2(100),
  SERVICE_DESC VARCHAR2(100),
  REMARK       VARCHAR2(100),
  IS_USE       VARCHAR2(2) default '是'
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
-- Add comments to the columns 
comment on column SYS_SERVICE.IS_USE
  is '是否在用';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_SERVICE
  add constraint PK_SYS_SERVICE primary key (SERVICE_ID)
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
