package com.yy.view;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
	 
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=UTF-8");
			String treeId = request.getParameter("treeId");

			
			String res = this.familyUserService.getUserByTreeId(treeId);
			System.out.println("res----------"+res);
			try {
				response.getWriter().write(res);
			} catch (IOException e) {
				e.printStackTrace();
			}
 

	}
}
