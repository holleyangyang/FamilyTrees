package com.function.sysfunction.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.Mapper;
@Resource
@Mapper
public interface SysFunctionDao {
  public List<Map<String,String>> getList(Map<String,String> map);
  public List<Map<String,String>> getlistByParentId(Map<String,String> map);
  public void add(Map<String,String> map);
  public String getMaxFunctionIdByPId(Map<String,String> map);
  public void update(Map<String,String> map);
}
