package com.function.questionResolve.dao;

import java.util.List;
import java.util.Map;






import javax.annotation.Resource;

import org.mybatis.spring.annotation.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
@Resource
@Qualifier("questionResolve_Dao")
@Mapper
public interface CodeDao {
  public List<Map<String,String>> getList(Map<String,String> map);
  public void insert(Map<String,String> map);
  public int getMaxQuestionId(Map<String,String> map);

}
