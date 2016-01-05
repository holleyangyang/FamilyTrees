package com.function.buzhou.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.function.buzhou.service.impl.BuzhouServiceImpl;
 
@Controller
public class BuZhouController {
	
	@Autowired
	BuzhouServiceImpl buzhou;

	/**
	 * 获取功能对应步骤列表
	 * @param functionId
	 * @param request
	 * @param response
	 */
 
	@RequestMapping(value = "/buzhou/list/{functionId}",method=RequestMethod.POST)
	public void test1(@PathVariable("functionId") String functionId,HttpServletRequest request,

			HttpServletResponse response){
			Map<String,String> map= new HashMap();
			map.put("functionId", functionId);

			String str=buzhou.getList(map);
			JsonUtil.printJsonListString(request,response,str);
   }
}
