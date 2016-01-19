package com.function.codeManage.service;

import java.util.Map;

public interface CodeService {
   public String getList(Map<String,String> map);
   public String getlistByParentId(Map<String,String> map);
   public void add(Map<String,String> map);
   public String getMaxFunctionIdByPId(Map<String,String> map);
   public void update(Map<String,String> map);

}
