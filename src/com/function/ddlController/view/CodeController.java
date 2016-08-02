package com.function.ddlController.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.util.JsonUtil;
import com.common.util.MysqlDemo;
import com.common.util.StringUtil;
@RequestMapping(value="/ddl")
@Controller("ddl_Controller")
public class CodeController {
	Logger logger =Logger.getLogger(this.getClass());
	
	 
	/**
	 * 获取功能对应步骤列表
	 * @param functionId
	 * @param request
	 */
	@RequestMapping(value = "/insterDDL",method=RequestMethod.POST)
	public void list(HttpServletRequest request,
			HttpServletResponse response){
		String sql =request.getParameter("sql");
		if(StringUtil.isNullOrBlank(sql)){
			return ;
			}
		 
		int result =-2;
		try {
			result = MysqlDemo.createDDL(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	     String  str = "{result:"+result+"}";
		 
		JsonUtil.printJsonListString(request,response,str);
   }
	
}
