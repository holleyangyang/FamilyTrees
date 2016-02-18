package com.function.flowController.view;

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
import com.function.flowController.service.impl.CodeServiceImpl;
@RequestMapping(value="/flow")
@Controller("flowController_Controller")
public class CodeController {
	Logger logger =Logger.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("flowController_Service")
	private CodeServiceImpl flowControllerService;
	/**
	 * 获取功能对应步骤列表
	 * @param functionId
	 * @param request
	 */
	@RequestMapping(value = "/list/{functionId}",method=RequestMethod.POST)
	public void list(@PathVariable("functionId") String functionId,HttpServletRequest request,
			HttpServletResponse response){
		if(StringUtil.isNullOrBlank(functionId)){
			return ;
			}
		Map<String,String> map= new HashMap<String, String>();
		map.put("functionId", functionId);
		String str=flowControllerService.getList(map);
		logger.info("str:"+str);
		JsonUtil.printJsonListString(request,response,str);
   }
	
}
