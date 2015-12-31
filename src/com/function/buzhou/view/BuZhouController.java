package com.function.buzhou.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.util.JsonUtil;
import com.function.buzhou.service.impl.BuzhouServiceImpl;
import com.yy.util.ExtHelper;

@Controller
public class BuZhouController {
	
	@Autowired
	BuzhouServiceImpl buzhou;
	
	@RequestMapping(value = "/buzhou/list")
	public void test1(HttpServletRequest request,
			HttpServletResponse response){
	 
			Map<String,String> map= new HashMap();
			map.put("functionId", "101");
			
			String str=buzhou.getList(map);
			JsonUtil.printJsonListString(request,response,str);
		 
	 
   }
	
	public void finalize() throws Throwable{
		super.finalize(); 
	}
	 
}
