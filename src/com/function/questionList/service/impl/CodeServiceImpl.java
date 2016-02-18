package com.function.questionList.service.impl;

import java.util.List;
import java.util.Map;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.common.util.ExtHelper;
import com.function.questionList.dao.CodeDao;
import com.function.questionList.service.CodeService;
@Service("questionList_Service")
public class CodeServiceImpl implements CodeService {
	 
	@Autowired
	@Qualifier(value="questionList_Dao")
	private  CodeDao codeDao;
	
	
	@Override
	public String getList(Map<String,String> map) {
		 List<Map<String,String>> list =codeDao.getList(map);
		 // JsonUtil.writeJSON(request, response, map);
		  String str=ExtHelper.transListToString(list);
		return str;
	}
	public static void main(String[] args) {
		
	}
	@Override
	public void add(Map<String, String> map) {
		// TODO Auto-generated method stub
		 codeDao.add(map);
	}
	@Override
	public int getMaxQuestionId(Map<String, String> map) {
		// TODO Auto-generated method stub
		return codeDao.getMaxQuestionId(map);
	}
}
