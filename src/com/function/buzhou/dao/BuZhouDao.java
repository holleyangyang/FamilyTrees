package com.function.buzhou.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.Mapper;
@Resource
@Mapper
public interface BuZhouDao {
  public List<Map<String,String>> getList(Map<String,String> map);
  public void add(Map<String,String> map);
  public void delete(Map<String,String> map);
  public String getMaxIdByFunctionId(Map<String,String> map);
}
