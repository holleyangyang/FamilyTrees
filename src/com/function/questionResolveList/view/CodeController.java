package com.function.questionResolveList.view;

import java.util.HashMap;
import java.util.List;
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
import com.function.questionResolveList.service.impl.CodeServiceImpl;
@RequestMapping(value="/questionResolveList")
@Controller("questionResolveList_Controller")
public class CodeController {
	Logger logger =Logger.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("questionResolveList_Service")
	private CodeServiceImpl questionResolveListService;
	/**
	 * 获取功能对应步骤列表
	 * @param functionId
	 * @param request
	 */
	@RequestMapping(value = "/list/{questionResolveId}",method=RequestMethod.POST)
	public void list(@PathVariable("questionResolveId") String questionResolveId,HttpServletRequest request,
			HttpServletResponse response){
		if(StringUtil.isNullOrBlank(questionResolveId)){
			return ;
			}
		Map<String,String> map= new HashMap<String, String>();
		map.put("questionResolveId", questionResolveId);
		List<Map<String,String>> strMap=questionResolveListService.getList(map);
	     
		Map map1=new HashMap(); 
	     map1.put("test", strMap);
		JsonUtil.writeJSON(request,response,map1);
   }
	@RequestMapping(value = "/add",method=RequestMethod.POST)
	public void add(HttpServletRequest request,
			HttpServletResponse response){
		System.out.println("123333333333");
		Map<String,String> map= new HashMap<String, String>();
		int questionResolverListId = questionResolveListService.getMaxQuestionId(map);
		String nextQuestionResolveListId=StringUtil.fullNumberByLength(""+(questionResolverListId+1));
		String questionResolveListDesc=request.getParameter("questionResolveListDesc");
		String remark=request.getParameter("remark");
		String questionResolveListSeqe=request.getParameter("questionResolveListSeqe");
		String questionResolveId = request.getParameter("questionResolveId");
		map.put("questionResolveListId", nextQuestionResolveListId);
		map.put("questionResolveId", questionResolveId);
		map.put("questionResolveListDesc", questionResolveListDesc);
		map.put("questionResolveListSeqe", questionResolveListSeqe);
 		map.put("remark", remark);
		
 		questionResolveListService.insert(map);
		
		Map<String, String> returnMap=new HashMap<String, String>();
		returnMap.put("retCode", "000");
		returnMap.put("retMsg", "success");
		
		
		JsonUtil.writeJSON(response, returnMap); 
   }
	
	
}
