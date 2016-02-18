-- Create table
create table SYS_QUESTION_LIST
(
  QUESTION_ID   VARCHAR2(10) not null,
  QUESTION_DESC VARCHAR2(500) not null,
  QUESTION_TYPE VARCHAR2(100) not null,
  IS_RESOLVE    VARCHAR2(2) default '否' not null,
  REMARK        VARCHAR2(500)
);
-- Add comments to the table 
comment on table SYS_QUESTION_LIST
  is '问题列表';
-- Add comments to the columns 
comment on column SYS_QUESTION_LIST.QUESTION_ID
  is '问题编号';
comment on column SYS_QUESTION_LIST.QUESTION_DESC
  is '问题描述';
comment on column SYS_QUESTION_LIST.QUESTION_TYPE
  is '问题类别';
comment on column SYS_QUESTION_LIST.IS_RESOLVE
  is '是否解决  ';
comment on column SYS_QUESTION_LIST.REMARK
  is '备注';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_QUESTION_LIST
  add constraint PK_SYS_QUESTION_LIST primary key (QUESTION_ID)
;
