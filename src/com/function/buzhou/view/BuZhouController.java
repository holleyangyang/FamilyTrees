package com.function.buzhou.view;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;







import com.common.util.JsonUtil;
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
	Logger logger =Logger.getLogger(this.getClass());
 
	@RequestMapping(value = "/buzhou/list/{functionId}",method=RequestMethod.POST)
	public void list(@PathVariable("functionId") String functionId,HttpServletRequest request,
			HttpServletResponse response){
			Map<String,String> map= new HashMap<String, String>();
			map.put("functionId", functionId);

			String str=buzhou.getList(map);
			
			logger.info("str:"+str);
			JsonUtil.printJsonListString(request,response,str);
   }
	/**
	 * 添加步骤信息
	 * @param functionId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/buzhou/add/{functionId}",method=RequestMethod.POST)
	public void add(@PathVariable("functionId") String functionId,HttpServletRequest request,
			HttpServletResponse response){
 		String name=request.getParameter("name");
		String remark=request.getParameter("remark");
		
		
		Map<String,String> map= new HashMap<String, String>();
		map.put("functionId", functionId);
		int functionIdCount=buzhou.getCountByFunctionId(map);
		
		map.put("id",new Integer(functionIdCount+1).toString());
		map.put("name", name);
		map.put("remark", remark);
	
		buzhou.add(map);
	}
	/**
	 * 删除步骤信息
	 * @param functionId
	 * @param id
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/buzhou/delete/{functionId}/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("functionId") String functionId,@PathVariable("id") String id,HttpServletRequest request,
			HttpServletResponse response){
			Map<String,String> map= new HashMap<String, String>();
			map.put("functionId", functionId);
			map.put("id", id);
		    buzhou.delete(map);
   }
}
