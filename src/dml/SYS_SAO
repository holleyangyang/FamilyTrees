-- Create table
create table SYS_SAO
(
  SAO_ID   VARCHAR2(10) not null,
  SAO_NAME VARCHAR2(100),
  SAO_DESC VARCHAR2(1000),
  REMARK   VARCHAR2(1000),
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
comment on column SYS_SAO.IS_USE
  is '是否在用';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_SAO
  add constraint PK_SYS_SAO primary key (SAO_ID)
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
alter table SYS_SAO
  add constraint UK_SYS_SAO unique (SAO_NAME)
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
