package com.function.questionResolveList.service;

import java.util.List;
import java.util.Map;

public interface CodeService {
   public List<Map<String,String>> getList(Map<String,String> map);
   public void insert(Map<String,String> map);
   public int getMaxQuestionId(Map<String,String> map);
}
