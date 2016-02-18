-- Create table
create table SYS_BUZHOU
(
  ID          VARCHAR2(20) not null,
  NAME        VARCHAR2(500) not null,
  REMARK      VARCHAR2(4000),
  FUNCTION_ID VARCHAR2(20) not null
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
-- Add comments to the table 
comment on table SYS_BUZHOU
  is '功能步骤表';
-- Add comments to the columns 
comment on column SYS_BUZHOU.ID
  is '步骤编号';
comment on column SYS_BUZHOU.NAME
  is '步骤描述';
comment on column SYS_BUZHOU.REMARK
  is '备注';
comment on column SYS_BUZHOU.FUNCTION_ID
  is '所属功能';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_BUZHOU
  add constraint PK_SYS_BUZHOU primary key (ID, FUNCTION_ID)
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
