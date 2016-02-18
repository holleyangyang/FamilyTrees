-- Create table
create table SYS_FUNCTION
(
  FUNCTION_ID      VARCHAR2(50) not null,
  FUNCTION_NAME    VARCHAR2(50) not null,
  FUNCTION_DESC    VARCHAR2(500) not null,
  PARENT_ID        VARCHAR2(50) not null,
  REMARK           VARCHAR2(500),
  IS_DELETED       VARCHAR2(10) default '是' not null,
  CREATE_TIME      VARCHAR2(50),
  LAST_UPDATE_TIME VARCHAR2(50),
  IS_OPEN          VARCHAR2(10) default 0
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
comment on table SYS_FUNCTION
  is '系统功能';
-- Add comments to the columns 
comment on column SYS_FUNCTION.FUNCTION_ID
  is '功能编号';
comment on column SYS_FUNCTION.FUNCTION_NAME
  is '功能名称';
comment on column SYS_FUNCTION.FUNCTION_DESC
  is '功能描述';
comment on column SYS_FUNCTION.PARENT_ID
  is '父功能';
comment on column SYS_FUNCTION.REMARK
  is '备注';
comment on column SYS_FUNCTION.IS_DELETED
  is '是否在用';
comment on column SYS_FUNCTION.CREATE_TIME
  is '创建时间';
comment on column SYS_FUNCTION.LAST_UPDATE_TIME
  is '最后一次修改时间';
comment on column SYS_FUNCTION.IS_OPEN
  is '是否打开';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_FUNCTION
  add constraint PK_SYSFUNCTION_ID primary key (FUNCTION_ID)
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
