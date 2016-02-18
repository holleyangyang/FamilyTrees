-- Create table
create table SYS_CDTS
(
  CDTS_ID   VARCHAR2(10) not null,
  CDTS_NAME VARCHAR2(100),
  CDTS_DESC VARCHAR2(100),
  REMARK    VARCHAR2(1000),
  IS_USE    VARCHAR2(2) default '是'
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
comment on column SYS_CDTS.IS_USE
  is '是否在用';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_CDTS
  add constraint PK_SYS_CDTS primary key (CDTS_ID)
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
alter table SYS_CDTS
  add constraint UK_SYS_CDTS unique (CDTS_NAME)
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
