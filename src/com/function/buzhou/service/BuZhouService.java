package com.function.buzhou.service;

import java.util.Map;

public interface BuZhouService {
   public String getList(Map<String,String> map);
   public String add(Map<String,String> map);
	public int getCountByFunctionId(Map<String, String> map) ;
	public void delete(Map<String,String> map);
}
