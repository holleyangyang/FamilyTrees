package com.guanxiwang.zidian.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

@Resource
@Qualifier("zidian_Dao")
@Mapper
public interface CodeDao {
	  public List<Map<String,String>> getList(Map<String,String> map);

}
