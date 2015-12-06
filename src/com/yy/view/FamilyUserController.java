package com.yy.view;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yy.service.FamilyUserService;
import com.yy.util.ExtHelper;
import com.yy.entity.FamilyTree;
import com.yy.entity.FamilyUser;

@RequestMapping(value = "/FamilyUser")
@Controller
public class FamilyUserController {
	@Autowired
	private FamilyUserService familyUserService;

	/**
	 * 
	 * 根据id来查询信息
	 * 
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/queryFamilyUserById")
	public void queryFamilyUserById(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
			
		String time=(String) request.getSession().getAttribute("yangyang");
		System.out.println(time);
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=UTF-8");
			String treeId = request.getParameter("treeId");
            
			String page = request.getParameter("page");
			String rows =request.getParameter("rows");
			//System.out.println("rows==="+rows);
			int currtpage = Integer.valueOf(page);
			int pageSize =Integer.valueOf(rows);
			int startPage = (currtpage-1)*pageSize;
			int endPage= currtpage*pageSize;
			
			Map map =new HashMap<String,Object>();
			map.put("treeId", treeId);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			//System.out.println("startPage="+startPage);
			//System.out.println("startPage="+endPage);
			String res = this.familyUserService.getUserByTreeId(map);
			//System.out.println("res----------"+res);
			
			int count = this.familyUserService.getUserCountByTreeId(map);

			res="{\"total\":"+count+",\"rows\":"+res+"}";
			try {
				response.getWriter().write(res);
			} catch (IOException e) {
				e.printStackTrace();
			}
 

	}
}
