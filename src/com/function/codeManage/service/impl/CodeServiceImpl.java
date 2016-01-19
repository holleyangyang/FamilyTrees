package com.function.codeManage.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.common.util.ExtHelper;
import com.function.codeManage.dao.CodeDao;
import com.function.sysfunction.service.SysFunctionService;
import com.mysql.jdbc.StringUtils;

@Service("codeManage_Service")
public class CodeServiceImpl implements SysFunctionService {
	
	@Autowired
	@Qualifier("codeManage_Dao")
	public CodeDao codeDao;
	
	@Override
	public String getList(Map<String,String> map) {
		 List<Map<String,String>> list =codeDao.getList(map);
		 // JsonUtil.writeJSON(request, response, map);
		  String str=ExtHelper.transListToString(list);
		return str;
	}

	@Override
	public String getlistByParentId(Map<String, String> map) {
		// TODO Auto-generated method stub
		
		 List<Map<String,String>> list =codeDao.getlistByParentId(map);
		return  ExtHelper.transListToString(list);
	}

	@Override
	public void add(Map<String, String> map) {
		// TODO Auto-generated method stub
		codeDao.add(map);
	}

	@Override
	public String getMaxFunctionIdByPId(Map<String, String> map) {
		// TODO Auto-generated method stub
		String maxfuntionId=codeDao.getMaxFunctionIdByPId(map);
		if(StringUtils.isNullOrEmpty(maxfuntionId)){
			maxfuntionId = map.get("pId")+"1001";
		}else{
			String last4=maxfuntionId.substring(maxfuntionId.length()-4);
			String nextfuntionId=String.valueOf((Integer.parseInt(last4)+1));
			maxfuntionId=map.get("pId")+nextfuntionId;
		}
		return maxfuntionId;
	}
	
 

	@Override
	public void update(Map<String, String> map) {
		// TODO Auto-generated method stub
		codeDao.update(map);
	}

}
