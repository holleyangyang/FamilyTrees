package com.yy.view;

import java.io.IOException;
 

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yy.service.impl.XtInterfaceServicesImpl;
 

@RequestMapping(value = "/XtInterface")
@Controller
public class XtInterfaceController {
	@Autowired
	private XtInterfaceServicesImpl XtInterfaceService;

	@RequestMapping(value = "/queryList")
	public void queryFunTree(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		 response.setCharacterEncoding("UTF-8");  
		 Map<String,String> map=new HashMap<String,String>();
		String functionname=request.getParameter("functionname");
		map.put("functionname", functionname);
		String res = this.XtInterfaceService.getAllList(map);
		System.out.println("res----------"+res);
		try {
			
			response.getWriter().write(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 return;
	} 
}
