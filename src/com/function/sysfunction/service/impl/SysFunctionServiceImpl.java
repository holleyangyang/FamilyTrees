package com.function.sysfunction.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.util.ExtHelper;
import com.function.sysfunction.dao.SysFunctionDao;
import com.function.sysfunction.service.SysFunctionService;

@Service
public class SysFunctionServiceImpl implements SysFunctionService {
	
	@Autowired
	public SysFunctionDao sysFunctionDao;
	
	@Override
	public String getList(Map<String,String> map) {
		 List<Map<String,String>> list =sysFunctionDao.getList(map);
		 // JsonUtil.writeJSON(request, response, map);
		  String str=ExtHelper.transListToString(list);
		return str;
	}

	@Override
	public String getlistByParentId(Map<String, String> map) {
		// TODO Auto-generated method stub
		
		 List<Map<String,String>> list =sysFunctionDao.getlistByParentId(map);
		return  ExtHelper.transListToString(list);
	}

}
