package com.function.questionResolveList.dao;

import java.util.List;
import java.util.Map;





import javax.annotation.Resource;

import org.mybatis.spring.annotation.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
@Resource
@Qualifier("questionResolveList_Dao")
@Mapper
public interface CodeDao {
  public List<Map<String,String>> getList(Map<String,String> map);
}
