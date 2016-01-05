package com.function.buzhou.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.util.ExtHelper;
import com.common.util.StringUtil;
import com.function.buzhou.dao.BuZhouDao;
import com.function.buzhou.service.BuZhouService;
@Service
public class BuzhouServiceImpl implements BuZhouService {
	
	@Autowired
	public BuZhouDao buZhouDao;
	
	@Override
	public String getList(Map<String,String> map) {
		 List list =buZhouDao.getList(map);
		 // JsonUtil.writeJSON(request, response, map);
		  String str=ExtHelper.transListToString(list);
		return str;
	}

	@Override
	public String add(Map<String, String> map) {
		// TODO Auto-generated method stub
		buZhouDao.add(map);
		return null;
	}
	@Override
	public int getCountByFunctionId(Map<String, String> map) {
		// TODO Auto-generated method stub
		int count =0;
		String str=buZhouDao.getMaxIdByFunctionId(map);
		if(StringUtil.isNullOrBlank(str)){
			count=0;
		}
		return count;
	}

	@Override
	public void delete(Map<String, String> map) {
		// TODO Auto-generated method stub
		buZhouDao.delete(map);
	}
	
}
