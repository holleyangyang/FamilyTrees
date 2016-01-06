package com.function.sysfunction.view;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
 


import org.springframework.web.bind.annotation.RequestMethod;

import com.common.util.JsonUtil;
import com.common.util.StringUtil;
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
    /**
     * 
     * @param request
     * @param response
     */
	@RequestMapping(value = "/sysfunction/list")
	public void list(HttpServletRequest request,
			HttpServletResponse response){
	 
			Map<String,String> map= new HashMap<String, String>();
			//map.put("functionId", "101");
			
			String str=sysFunction.getList(map);
			JsonUtil.printJsonListString(request,response,str);
   }
    /**
     * 
     * @param parentFunctionId
     * @param request
     * @param response
     */
	@RequestMapping(value = "/sysfunction/listbypid/{parentFunctionId}", method=RequestMethod.POST)
	public void getlistByParentId(@PathVariable("parentFunctionId") String parentFunctionId,HttpServletRequest request,
			HttpServletResponse response){
	        
		
			if(StringUtil.isNullOrBlank(parentFunctionId)){
				parentFunctionId="-1";
			}
		
			Map<String,String> map= new HashMap<String, String>();
			map.put("parentFunctionId", parentFunctionId);
			
			String str=sysFunction.getlistByParentId(map);
			JsonUtil.printJsonListString(request,response,str);
   }
}
