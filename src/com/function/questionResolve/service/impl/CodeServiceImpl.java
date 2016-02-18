package com.function.questionResolve.service.impl;

import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.common.util.ExtHelper;
import com.function.questionResolve.dao.CodeDao;
import com.function.questionResolve.service.CodeService;
@Service("questionResolve_Service")
public class CodeServiceImpl implements CodeService {
	 
	@Autowired
	@Qualifier(value="questionResolve_Dao")
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
}
