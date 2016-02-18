package com.function.questionList.view;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.util.JsonUtil;
import com.common.util.StringUtil;
import com.function.questionList.service.impl.CodeServiceImpl;
@RequestMapping(value="/questionList")
@Controller("questionList_Controller")
public class CodeController {
	Logger logger =Logger.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("questionList_Service")
	private CodeServiceImpl questionListService;
	/**
	 * 获取功能对应步骤列表
	 * @param functionId
	 * @param request
	 */
	@RequestMapping(value = "/list",method=RequestMethod.POST)
	public void list(HttpServletRequest request,
			HttpServletResponse response){
		
		Map<String,String> map= new HashMap<String, String>();
		String questionId=request.getParameter("questionId");
		map.put("questionId", questionId);
		String str=questionListService.getList(map);
		logger.info("str:"+str);
		JsonUtil.printJsonListString(request,response,str);
   }
	@RequestMapping(value = "/add",method=RequestMethod.PUT)
	public void add(HttpServletRequest request,
			HttpServletResponse response){
		
		Map<String,String> map= new HashMap<String, String>();
		int questionId = questionListService.getMaxQuestionId(map);
		String nextQuestionId=StringUtil.fullNumberByLength(""+(questionId+1));
		map.put("questionId", nextQuestionId);
		
		   String questionDesc=request.getParameter("questionDesc");
		   String questionType=request.getParameter("questionType");
		   String remark=request.getParameter("remark");
		
		map.put("questionDesc", questionDesc);
		map.put("questionType", questionType);
		map.put("remark", remark);
		
		questionListService.add(map);
		
		Map<String, String> returnMap=new HashMap<String, String>();
		returnMap.put("retCode", "000");
		returnMap.put("retMsg", "success");
		
		
		JsonUtil.writeJSON(response, returnMap); 
   }
}
