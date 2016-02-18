-- Create table
create table SYS_CONTROLLER_METHOD
(
  CONTROLLER_METHOD_ID   VARCHAR2(10) not null,
  DO                     VARCHAR2(100),
  CONTROLLER_ID          VARCHAR2(10) not null,
  CONTROLLER_METHOD_NAME VARCHAR2(200) not null,
  CONTROLLER_METHOD_DESC VARCHAR2(200) not null,
  REMARK                 VARCHAR2(200),
  IS_USE                 VARCHAR2(2) default '是',
  CHANNEL                VARCHAR2(2)
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
comment on column SYS_CONTROLLER_METHOD.DO
  is '.do地址';
comment on column SYS_CONTROLLER_METHOD.IS_USE
  is '是否在用';
comment on column SYS_CONTROLLER_METHOD.CHANNEL
  is '1,天下通、2.PC、3.一帐通App、4.任意门、5.口袋银行、微信';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_CONTROLLER_METHOD
  add constraint PK_SYS_CONTROLLER_METHOD primary key (CONTROLLER_METHOD_ID)
  disable;
alter table SYS_CONTROLLER_METHOD
  add constraint UK_CONTROLLER_ID unique (DO, CONTROLLER_METHOD_NAME, CONTROLLER_ID)
  deferrable initially deferred
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
alter table SYS_CONTROLLER_METHOD
  add constraint FK_CONTROLLER_ID foreign key (CONTROLLER_ID)
  references SYS_CONTROLLER (CONTROLLER_ID) on delete cascade
  deferrable initially deferred;
