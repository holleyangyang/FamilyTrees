package com.function.flowController.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.common.util.ExtHelper;
import com.function.flowController.dao.CodeDao;
@Service("flowController_Service")
public class CodeServiceImpl implements com.function.flowController.service.CodeService {
	 
	@Autowired
	@Qualifier(value="flowController_Dao")
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
