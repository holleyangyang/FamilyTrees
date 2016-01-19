package com.function.flowControllerActionServiceSao.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.common.util.ExtHelper;
import com.function.flowControllerActionServiceSao.dao.CodeDao;
import com.function.flowControllerActionServiceSao.service.CodeService;
@Service("flowControllerActionServiceSao_Service")
public class CodeServiceImpl implements CodeService {
	
	@Autowired
	@Qualifier("flowControllerActionServiceSao_Dao")
	private CodeDao codeDao;
	
	@Override
	public String getList(Map<String,String> map) {
		 List<Map<String,String>> list =codeDao.getList(map);
		 // JsonUtil.writeJSON(request, response, map);
		  String str=ExtHelper.transListToString(list);
		return str;
	}
}
