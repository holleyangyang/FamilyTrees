-- Create table
create table SYS_DAO
(
  DAO_ID   VARCHAR2(10) not null,
  DAO_NAME VARCHAR2(100),
  DAO_DESC VARCHAR2(100),
  REMARK   VARCHAR2(500),
  IS_USE   VARCHAR2(2) default '是'
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
comment on column SYS_DAO.IS_USE
  is '是否在用';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_DAO
  add constraint PK_SYS_DAO primary key (DAO_ID)
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
