package com.yy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yy.dao.FamilyUserDao;
import com.yy.service.FamilyUserService;
import com.yy.util.ExtHelper;
@Service
public class FamilyUserServiceImpl implements FamilyUserService {
	@Autowired
    @Qualifier("familyUserDao")
	private  FamilyUserDao familyUserDao;
	@Override
	public String getUserByTreeId(Map map) {
		// TODO Auto-generated method stub
		
		List list =familyUserDao.getUserByTreeId(map);
		String jsonString=ExtHelper.listToJson(list);
		return jsonString;
	}
	@Override
	public int getUserCountByTreeId(Map map) {
		// TODO Auto-generated method stub
		int count =familyUserDao.getUserCountByTreeId(map);
		return count;
	}

}
