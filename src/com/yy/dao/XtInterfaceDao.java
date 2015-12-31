package com.yy.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.Mapper;
import org.springframework.stereotype.Service;

import com.yy.entity.XtInterface;

 @Service
@Mapper("XtInterfaceDao")
public interface XtInterfaceDao {
	public List<XtInterface> getAllList(Map<String,String> map);
}
