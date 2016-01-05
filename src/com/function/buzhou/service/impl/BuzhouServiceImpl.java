package com.function.buzhou.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.util.ExtHelper;
import com.function.buzhou.dao.BuZhouDao;
import com.function.buzhou.service.BuZhouService;
@Service
public class BuzhouServiceImpl implements BuZhouService {
	
	@Autowired
	public BuZhouDao BuZhouDao;
	
	@Override
	public String getList(Map<String,String> map) {
		 List list =BuZhouDao.getList(map);
		 // JsonUtil.writeJSON(request, response, map);
		  String str=ExtHelper.transListToString(list);
		return str;
	}

}
