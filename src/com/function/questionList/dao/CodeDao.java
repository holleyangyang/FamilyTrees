package com.function.questionList.dao;

import java.util.List;
import java.util.Map;





import javax.annotation.Resource;

import org.mybatis.spring.annotation.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
@Resource
@Qualifier("questionList_Dao")
@Mapper
public interface CodeDao {
  public List<Map<String,String>> getList(Map<String,String> map);
  public void add(Map<String,String> map);
  public int getMaxQuestionId(Map<String,String> map);
}
