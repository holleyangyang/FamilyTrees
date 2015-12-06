package com.yy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yy.dao.XtInterfaceDao;
import com.yy.entity.XtInterface;
import com.yy.service.XtInterfaceService;
import com.yy.util.ExtHelper;
@Service
public class XtInterfaceServicesImpl implements XtInterfaceService {
	@Autowired
    @Qualifier("XtInterfaceDao")
	private  XtInterfaceDao XtInterfaceDao;
	@Override
	public String getAllList(Map<String,String> map) {
		// TODO Auto-generated method stub
		List <XtInterface>  list=XtInterfaceDao.getAllList(map);
		String jsonString=ExtHelper.listToJson(list);
		System.out.println("qqqqjsonString..."+jsonString);
		return jsonString;
		
	}

}
