-- Create table
create table SYS_DAO_METHOD
(
  DAO_METHOD_ID   VARCHAR2(10) not null,
  DAO_ID          VARCHAR2(10) not null,
  DAO_METHOD_NAME VARCHAR2(100),
  DAO_METHOD_DESC VARCHAR2(1000),
  REMARK          VARCHAR2(1000),
  IS_USE          VARCHAR2(2) default '是'
)
tablespace EBANKDATA
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the columns 
comment on column SYS_DAO_METHOD.IS_USE
  is '是否在用';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_DAO_METHOD
  add constraint PK_SYS_DAO_METHOD primary key (DAO_METHOD_ID)
  using index 
  tablespace EBANKDATA
  pctfree 10
  initrans 2
  maxtrans 255;
alter table SYS_DAO_METHOD
  add constraint FK_SYS_DAO_METHOD foreign key (DAO_ID)
  references SYS_DAO (DAO_ID) on delete cascade
  deferrable initially deferred;
