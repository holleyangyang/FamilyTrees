package com.function.questionResolve.service;

import java.util.Map;

public interface CodeService {
   public String getList(Map<String,String> map);
   public void insert(Map<String,String> map);
   public int getMaxQuestionId(Map<String,String> map);

}
