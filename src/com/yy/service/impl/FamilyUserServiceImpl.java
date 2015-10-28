package com.yy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yy.dao.FamilyUserDao;
import com.yy.entity.FamilyUser;
import com.yy.service.FamilyUserService;
import com.yy.util.ExtHelper;
@Service
public class FamilyUserServiceImpl implements FamilyUserService {
	@Autowired
    @Qualifier("familyUserDao")
	private  FamilyUserDao familyUserDao;
	@Override
	public String getUserByTreeId(String treeId) {
		// TODO Auto-generated method stub
		
		List list =familyUserDao.getUserByTreeId(treeId);
		String jsonString=ExtHelper.listToJson(list);
		return jsonString;
	}

}
