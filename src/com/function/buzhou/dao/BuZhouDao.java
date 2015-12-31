package com.function.buzhou.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.Mapper;
@Mapper("buzhou")
public interface BuZhouDao {
  public List getList(Map<String,String> map);
}
