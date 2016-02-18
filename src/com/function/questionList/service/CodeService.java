package com.function.questionList.service;

import java.util.Map;

public interface CodeService {
   public String getList(Map<String,String> map);
   public void add(Map<String,String> map);
   public int getMaxQuestionId(Map<String,String> map);

}
