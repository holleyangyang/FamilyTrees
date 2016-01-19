package com.function.flowControllerAction.view;

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
import com.function.flowControllerAction.service.impl.CodeServiceImpl;
@RequestMapping(value="/flowControllerAction")
@Controller("flowControllerAction_Controller")
public class CodeController {
	Logger logger =Logger.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("flowControllerAction_Service")
	private CodeServiceImpl codeService;
	/**
	 * 获取功能对应步骤列表
	 * @param functionId
	 * @param request
	 */
	@RequestMapping(value = "/list/{controllerMethodId}",method=RequestMethod.POST)
	public void list(@PathVariable("controllerMethodId") String controllerMethodId,HttpServletRequest request,
			HttpServletResponse response){
		Map<String,String> map= new HashMap<String, String>();
		map.put("controllerMethodId", controllerMethodId);
		String str=codeService.getList(map);
		logger.info("str:"+str);
		JsonUtil.printJsonListString(request,response,str);
   }
	
}
