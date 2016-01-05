package com.function.sysfunction.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.Mapper;
@Resource
@Mapper
public interface SysFunctionDao {
  public List<Map<String,String>> getList(Map<String,String> map);
}
