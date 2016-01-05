package com.function.sysfunction.view;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.util.JsonUtil;
import com.function.sysfunction.service.impl.SysFunctionServiceImpl;


@Controller
public class SysFunctionController {
	
	@Autowired
	SysFunctionServiceImpl sysFunction;
	/**
	 * 获取功能列表
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/sysfunction/list")
	public void test1(HttpServletRequest request,
			HttpServletResponse response){
	 
			Map<String,String> map= new HashMap();
			//map.put("functionId", "101");
			
			String str=sysFunction.getList(map);
			JsonUtil.printJsonListString(request,response,str);
   }
	
	public void finalize() throws Throwable{
		super.finalize(); 
	}
	 
}
