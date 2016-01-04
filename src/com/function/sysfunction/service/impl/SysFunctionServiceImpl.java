package com.function.sysfunction.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;




import com.function.sysfunction.dao.SysFunctionDao;
import com.function.sysfunction.service.SysFunctionService;
import com.yy.util.ExtHelper;
@Service
public class SysFunctionServiceImpl implements SysFunctionService {
	
	@Autowired
	public SysFunctionDao sysFunctionDao;
	
	@Override
	public String getList(Map<String,String> map) {
		 List list =sysFunctionDao.getList(map);
		 // JsonUtil.writeJSON(request, response, map);
		  String str=ExtHelper.transListToString(list);
		return str;
	}

}
