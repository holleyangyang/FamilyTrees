package com.function.sysfunction.view;



import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
 


import org.springframework.web.bind.annotation.RequestMethod;

import com.common.util.DateUtil;
import com.common.util.JsonUtil;
import com.common.util.StringUtil;
import com.function.sysfunction.service.impl.SysFunctionServiceImpl;

@Controller("sysfunction_Controller")
public class SysFunctionController {
	
	@Autowired
	@Qualifier("sysfunction_Service")
	private SysFunctionServiceImpl sysFunctionService;
	
	 @Value("#{propertyConfigurer['userPageSize']}")
	 private String userPageSize; 
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
	@RequestMapping(value = "/sysfunction/list",method=RequestMethod.POST)
	public void list(HttpServletRequest request,
			HttpServletResponse response){
	 System.out.println("userPageSize="+userPageSize);
			Map<String,String> map= new HashMap<String, String>();
			//map.put("functionId", "101");
			
			String str=sysFunctionService.getList(map);
			JsonUtil.printJsonListString(request,response,str);
   }
    /**
     * 
     * @param parentFunctionId
     * @param request
     * @param response
     * consumes="application/json"
     */
	@RequestMapping(value = "/sysfunction/listbypid/{parentFunctionId}", method=RequestMethod.POST)
	public void getlistByParentId(@PathVariable("parentFunctionId") String parentFunctionId,HttpServletRequest request,
			HttpServletResponse response){
	        
		
			if(StringUtil.isNullOrBlank(parentFunctionId)){
				parentFunctionId="-1";
			}
		
			Map<String,String> map= new HashMap<String, String>();
			map.put("parentFunctionId", parentFunctionId);
			
			String str=sysFunctionService.getlistByParentId(map);
			JsonUtil.printJsonListString(request,response,str);
   }
	@RequestMapping(value = "/sysfunction/add/{parentFunctionId}", method=RequestMethod.POST)
	public void add(@PathVariable("parentFunctionId") String parentFunctionId,HttpServletRequest request,
			HttpServletResponse response){
			   
			   String pId=parentFunctionId;
			   String name=request.getParameter("name");
			   String desc=request.getParameter("desc");
 			   String remark=request.getParameter("remark");
			   String createTime =DateUtil.getSqlDate().toString();
				Map<String,String> map= new HashMap<String, String>();
				
				map.put("name", name);
				map.put("desc", desc);
				map.put("pId", pId);
				map.put("remark", remark);
				map.put("createTime", createTime);
				String id=sysFunctionService.getMaxFunctionIdByPId(map);
				map.put("id", id);
				sysFunctionService.add(map);

	}
	@RequestMapping(value = "/sysfunction/update/{id}", method=RequestMethod.PUT)
	public void update(@PathVariable("id") String id,HttpServletRequest request,
			HttpServletResponse response){
			   
			 
			   String name=request.getParameter("name");
			   String desc=request.getParameter("desc");
 			   String remark=request.getParameter("remark");
			   String createTime =DateUtil.getSqlDate().toString();
				Map<String,String> map= new HashMap<String, String>();
				
				map.put("name", name);
				map.put("desc", desc);
				map.put("remark", remark);
				map.put("updateTime", createTime);
 				map.put("id", id);
				sysFunctionService.update(map);

	}
}



