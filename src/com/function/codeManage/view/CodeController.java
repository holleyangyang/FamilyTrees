package com.function.codeManage.view;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.util.DateUtil;
import com.common.util.JsonUtil;
import com.common.util.StringUtil;
import com.function.codeManage.service.impl.CodeServiceImpl;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

@RequestMapping(value="/codeManage")
@Controller("codeManage_Controller")
public class CodeController {
	
	@Autowired
	@Qualifier("codeManage_Service")
	private CodeServiceImpl codeService;
	/**
	 * 获取功能列表
	 * @param request
	 * @param response
	 */
    /**
     * 
     * @param request
     * @param response
     */
	@RequestMapping(value = "/list",method=RequestMethod.POST)
	public void list(HttpServletRequest request,
			HttpServletResponse response){
	 
			Map<String,String> map= new HashMap<String, String>();
			//map.put("functionId", "101");
			
			String str=codeService.getList(map);
			JsonUtil.printJsonListString(request,response,str);
   }
	
	@RequestMapping(value="/test")
	public void test(HttpServletRequest request,HttpServletResponse response){
		
		String text = "http://www.baidu.com";
		int width = 300;
		int height = 300;
		// 二维码的图片格式
		String format = "gif";
		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		 
			try {
				BitMatrix bitMatrix = new MultiFormatWriter().encode(text,
						BarcodeFormat.QR_CODE, width, height);
 
OutputStream  out = response.getOutputStream();
com.demo.java生成二维码.writeToStream(bitMatrix,format,out);
			} catch (WriterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		System.out.println("test");
	}
    /**
     * 
     * @param parentFunctionId
     * @param request
     * @param response
     * consumes="application/json"
     */
	@RequestMapping(value = "/listbypid/{parentFunctionId}", method=RequestMethod.POST)
	public void getlistByParentId(@PathVariable("parentFunctionId") String parentFunctionId,HttpServletRequest request,
			HttpServletResponse response){
	        
		
			if(StringUtil.isNullOrBlank(parentFunctionId)){
				parentFunctionId="-1";
			}
		
			Map<String,String> map= new HashMap<String, String>();
			map.put("parentFunctionId", parentFunctionId);
			
			String str=codeService.getlistByParentId(map);
			JsonUtil.printJsonListString(request,response,str);
   }
	@RequestMapping(value = "/add/{parentFunctionId}", method=RequestMethod.POST)
	public void add(@PathVariable("parentFunctionId") String parentFunctionId,HttpServletRequest request,
			HttpServletResponse response){
			   
			   String pId=parentFunctionId;
			   String name=request.getParameter("name");
			   String desc=request.getParameter("desc");
 			   String remark=request.getParameter("remark");
			   String createTime =DateUtil.getSqlDate().toString();
				Map<String,String> map= new HashMap<String, String>();
				
				map.put("name", name);
				map.put("desc", desc);
				map.put("pId", pId);
				map.put("remark", remark);
				map.put("createTime", createTime);
				String id=codeService.getMaxFunctionIdByPId(map);
				map.put("id", id);
				codeService.add(map);

	}
	@RequestMapping(value = "/update/{id}", method=RequestMethod.PUT)
	public void update(@PathVariable("id") String id,HttpServletRequest request,
			HttpServletResponse response){
			   
			 
			   String name=request.getParameter("name");
			   String desc=request.getParameter("desc");
 			   String remark=request.getParameter("remark");
			   String createTime =DateUtil.getSqlDate().toString();
				Map<String,String> map= new HashMap<String, String>();
				
				map.put("name", name);
				map.put("desc", desc);
				map.put("remark", remark);
				map.put("updateTime", createTime);
 				map.put("id", id);
 				codeService.update(map);

	}
}



