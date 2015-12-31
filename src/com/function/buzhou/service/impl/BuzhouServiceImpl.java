package com.function.buzhou.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.function.buzhou.dao.BuZhouDao;
import com.function.buzhou.service.BuZhouService;
import com.yy.util.ExtHelper;
@Service
public class BuzhouServiceImpl implements BuZhouService {
	@Autowired
	BuZhouDao buZhouDao;
	@Override
	public String getList(Map<String,String> map) {
		 List list =buZhouDao.getList(map);
		 // JsonUtil.writeJSON(request, response, map);
		  String str=ExtHelper.transListToString(list);
		return str;
	}

}
