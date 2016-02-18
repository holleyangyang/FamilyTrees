-- Create table
create table SYS_CONTROLLER
(
  CONTROLLER_ID   VARCHAR2(10) not null,
  CONTROLLER_NAME VARCHAR2(200) not null,
  CONTROLLER_DESC VARCHAR2(200),
  REMARK          VARCHAR2(200),
  IS_USE          VARCHAR2(2) default '是'
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
comment on column SYS_CONTROLLER.IS_USE
  is '是否在用';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_CONTROLLER
  add constraint PK_SYS_CONTROLLER primary key (CONTROLLER_ID)
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
alter table SYS_CONTROLLER
  add constraint UK_SYS_CONTROLLER unique (CONTROLLER_NAME)
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
