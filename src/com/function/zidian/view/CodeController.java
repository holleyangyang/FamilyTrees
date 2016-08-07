package com.function.zidian.view;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.util.JsonUtil;
import com.function.zidian.service.impl.CodeServiceImpl;

@RequestMapping(value="/zidian")
@Controller("zidian_Controller")
public class CodeController {
	
	@Autowired
	@Qualifier("zidian_Service")
	private CodeServiceImpl codeService;
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
	@RequestMapping(value = "/list",method=RequestMethod.POST)
	public void list(HttpServletRequest request,
			HttpServletResponse response){
	 
			Map<String,String> map= new HashMap<String, String>();
			//map.put("functionId", "101");
			
			String str=codeService.getList(map);
			JsonUtil.printJsonListString(request,response,str);
   }
	
	 
}



