-- Create table
create table SYS_QUESTION_RESOLVE
(
  QUESTION_RESOLVE_ID   VARCHAR2(10) not null,
  QUESTION_ID           VARCHAR2(10) not null,
  QUESTION_DESC         VARCHAR2(500) not null,
  QUESTION_TYPE         VARCHAR2(10) not null,
  QUESTION_RESOLVE_DESC VARCHAR2(500),
  REMARK                VARCHAR2(500),
  IS_RESOLVE            VARCHAR2(2) default '否' not null
)
;
-- Add comments to the table 
comment on table SYS_QUESTION_RESOLVE
  is '问题解决方案';
-- Add comments to the columns 
comment on column SYS_QUESTION_RESOLVE.QUESTION_RESOLVE_ID
  is '问题编号';
comment on column SYS_QUESTION_RESOLVE.QUESTION_ID
  is '问题编号';
comment on column SYS_QUESTION_RESOLVE.QUESTION_DESC
  is '问题描述';
comment on column SYS_QUESTION_RESOLVE.QUESTION_TYPE
  is '问题类别';
comment on column SYS_QUESTION_RESOLVE.QUESTION_RESOLVE_DESC
  is '解决问题简述';
comment on column SYS_QUESTION_RESOLVE.REMARK
  is '备注';
comment on column SYS_QUESTION_RESOLVE.IS_RESOLVE
  is '是否解决  ';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_QUESTION_RESOLVE
  add constraint PK_SYS_QUESTION_RESOLVE primary key (QUESTION_RESOLVE_ID)
 ;
alter table SYS_QUESTION_RESOLVE
  add constraint FK_SYS_QUESTION_RESOLVE foreign key (QUESTION_ID)
  references SYS_QUESTION_LIST (QUESTION_ID);
