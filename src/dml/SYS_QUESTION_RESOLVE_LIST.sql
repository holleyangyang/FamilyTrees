-- Create table
create table SYS_QUESTION_RESOLVE_LIST
(
  QUESTION_RESOLVE_LIST_ID VARCHAR2(10) not null,
  QUESTION_RESOLVE_ID      VARCHAR2(10),
  QUESTION_RESOLVE_DESC    VARCHAR2(500),
  QUESTION_RESOLVE_SEQE    NUMBER default 1,
  REMARK                   VARCHAR2(500)
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
comment on table SYS_QUESTION_RESOLVE_LIST
  is '问题解决列表';
-- Add comments to the columns 
comment on column SYS_QUESTION_RESOLVE_LIST.QUESTION_RESOLVE_LIST_ID
  is '问题编号';
comment on column SYS_QUESTION_RESOLVE_LIST.QUESTION_RESOLVE_ID
  is '问题编号';
comment on column SYS_QUESTION_RESOLVE_LIST.QUESTION_RESOLVE_DESC
  is '解决问题描述';
comment on column SYS_QUESTION_RESOLVE_LIST.QUESTION_RESOLVE_SEQE
  is '解决问题描述';
comment on column SYS_QUESTION_RESOLVE_LIST.REMARK
  is '备注';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_QUESTION_RESOLVE_LIST
  add constraint PK_SYS_QUESTION_RESOLVE_LIST primary key (QUESTION_RESOLVE_LIST_ID)
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
alter table SYS_QUESTION_RESOLVE_LIST
  add constraint FK_SYS_QUESTION_RESOLVE_LIST foreign key (QUESTION_RESOLVE_ID)
  references SYS_QUESTION_RESOLVE (QUESTION_RESOLVE_ID);
