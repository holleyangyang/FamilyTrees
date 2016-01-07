package com.function.sysfunction.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.util.ExtHelper;
import com.function.sysfunction.dao.SysFunctionDao;
import com.function.sysfunction.service.SysFunctionService;
import com.mysql.jdbc.StringUtils;

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

	@Override
	public void add(Map<String, String> map) {
		// TODO Auto-generated method stub
		sysFunctionDao.add(map);
	}

	@Override
	public String getMaxFunctionIdByPId(Map<String, String> map) {
		// TODO Auto-generated method stub
		String maxfuntionId=sysFunctionDao.getMaxFunctionIdByPId(map);
		if(StringUtils.isNullOrEmpty(maxfuntionId)){
			maxfuntionId = map.get("pId")+"1001";
		}else{
			maxfuntionId=String.valueOf((Integer.parseInt(maxfuntionId.substring(map.get("pId").length()))+1));
		}
		return maxfuntionId;
	}
	
	public static void main(String[] args) {
		String id="1001100110011002";
		String pId ="100110011001"; 
		System.out.println();
	}

	@Override
	public void update(Map<String, String> map) {
		// TODO Auto-generated method stub
		sysFunctionDao.update(map);
	}

}
