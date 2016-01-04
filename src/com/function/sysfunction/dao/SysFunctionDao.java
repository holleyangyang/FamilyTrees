package com.function.sysfunction.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.Mapper;
import org.springframework.stereotype.Repository;
@Resource
@Mapper
public interface SysFunctionDao {
  public List getList(Map<String,String> map);
}
