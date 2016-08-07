package com.function.zidian.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.common.util.ExtHelper;
import com.function.zidian.dao.CodeDao;
import com.function.zidian.service.CodeService;

@Service("zidian_Service")
public class CodeServiceImpl implements CodeService {
	
	@Autowired
	@Qualifier("zidian_Dao")
	public CodeDao codeDao;
	
	@Override
	public String getList(Map<String,String> map) {
		 List<Map<String,String>> list =codeDao.getList(map);
		 // JsonUtil.writeJSON(request, response, map);
		  String str=ExtHelper.transListToString(list);
		return str;
	}

	

}
