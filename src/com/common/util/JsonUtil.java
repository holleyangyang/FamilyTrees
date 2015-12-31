package com.common.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 
 * @author 
 * 
 */
public class JsonUtil {
	 public static final String RET_CODE="ret_code";
	 public static final String RET_CODE_SUCCESS="000";
	 public static final String RET_MSG="ret_message";
	 public static final String RET_MSG_SUCCESS="success";
	 private static Logger logger = Logger.getLogger( JsonUtil.class );
     
	 
	 public static void printJsonListString(HttpServletRequest request,
				HttpServletResponse response,String jsonstr){
			try {
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				out = response.getWriter();
				out.write(jsonstr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 /**
     * @param response
     * @param returnMap
     * @throws IOException
     */
    public static JSONArray  writeJSON_Array(HttpServletResponse response, Object returnMap)  {
    	setResponseAttributes(response);
        JSONArray json = JSONArray.fromObject(returnMap);
        PrintWriter out;
		try {
			out = response.getWriter();
			out.write(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return json;
     }
    /**
     * @param response
     * @param returnMap
     * @throws IOException
     */
    public static JSONObject  writeJSON_Object(HttpServletResponse response, Object returnMap){
    	setResponseAttributes(response);
        JSONObject json = JSONObject.fromObject(returnMap);
        PrintWriter out;
		try {
			out = response.getWriter();
		    out.write(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return json;
     }
    
    public static JSONObject  writeJSON_Object(HttpServletRequest request,HttpServletResponse response, Object returnMap){
    	setResponseAttributes(request,response);
        JSONObject json = JSONObject.fromObject(returnMap);
        PrintWriter out;
		try {
			out = response.getWriter();
		    out.write(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return json;
     }
  
    public static JSONObject  writeJSON_Object2(HttpServletRequest request,HttpServletResponse response, Object returnMap){
    	setResponseAttributesforGBK(request,response);
        JSONObject json = JSONObject.fromObject(returnMap);
        PrintWriter out;
		try {
			out = response.getWriter();
		    out.write(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return json;
     }
    
	/**
     * @param response
     * @param returnMap
     * @throws IOException
     */
    public static void  writeJSON(HttpServletResponse response, Map returnMap) {
    	setResponseAttributes(response);
        JSONObject json = new JSONObject();
        try{
        	PrintWriter out = response.getWriter();
        	json.putAll(returnMap);
        	out = response.getWriter();
        	out.write(json.toString());
        }catch(IOException e){
        	e.printStackTrace();
        }
    }
    public static void  writeJSON(HttpServletRequest request,HttpServletResponse response, Map returnMap) {
    	setResponseAttributes(request,response);
        JSONObject json = new JSONObject();
        try{
        	PrintWriter out = response.getWriter();
        	json.putAll(returnMap);
        	out = response.getWriter();
        	out.write(json.toString());
        }catch(IOException e){
        	e.printStackTrace();
        }
    }
    public static void  writeJSON(HttpServletRequest request,HttpServletResponse response, String jsonString) {
    	setResponseAttributes(request,response);
       
        try{
        	PrintWriter out = response.getWriter();
        	 
        	out = response.getWriter();
        	out.write(jsonString);
        }catch(IOException e){
        	e.printStackTrace();
        }
    }
    /**
     * @param request
     * @return
     * @throws Exception
     */

    public static Object getRequestParametersValue (
			HttpServletRequest request,Object dto) throws Exception {
		request.getParameterMap();

		Enumeration pNames = request.getParameterNames();
		Map map = new HashMap();
		while (pNames.hasMoreElements()) {
			String name = (String) pNames.nextElement();
			String value = request.getParameter(name);
			value = URLDecoder.decode(value, "utf-8");
			map.put(name, value);
		}
		//logger.info("==>input parameters:"+map);
			if(map!=null)
				BeanUtils.populate(dto, map);
		return dto;
	}
    /**
     * @param returnMap
     * @return
     */
    public static String getJsonString(HttpServletResponse response, Map returnMap){
    	response.setContentType("text/html;charset=UTF-8");
    	JSONObject json = new JSONObject();
        json.putAll(returnMap);
        return json.toString();  
    }
    /**
     * @param response
     */
    private static void setResponseAttributes(HttpServletResponse response){
    	String trustURLStr=gettrustURLStr("ebank.system.trustURL");     //��ȡ������
//    	String trustURLStr="*";     //����
    	System.out.println(trustURLStr);
    	response.addHeader("Access-Control-Allow-Origin", trustURLStr);
    	response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Credentials","true");
    }
    public static String gettrustURLStr(String configName){ 
        ResourceBundle ms = null;
        String str="";
        try{
            if (ms == null)
               ms = PropertyResourceBundle.getBundle("sys");
            str = ms.getString(configName).trim();
        }catch(Exception e){
            e.printStackTrace();
        }
        return str;
     }
    private static void checkAndSetTrustURL(HttpServletRequest request,HttpServletResponse response){
    	boolean ret=false;
    	String requestURI= (String)request.getHeader("referer");
    	String trustURLStr=gettrustURLStr("ebank.system.trustURL");     
    	System.out.println(trustURLStr);
    	String[] trustURLStrArray=trustURLStr.split(",");
    	for(int i=0;i<trustURLStrArray.length;i++)
    	{
    		if(StringUtil.isNullOrBlank(requestURI)){
    			break;
    		}
    		if(requestURI.indexOf(trustURLStrArray[i])!=-1){
    			response.addHeader("Access-Control-Allow-Origin",trustURLStrArray[i]);
    			ret=true;break;
    		}
    	}
    	if(ret==false)
    		response.addHeader("Access-Control-Allow-Origin",gettrustURLStr("ebank.system.trustURL"));
    }
    public static void setResponseAttributes(HttpServletRequest request,HttpServletResponse response){
    	response.setContentType("text/html;charset=UTF-8");
        checkAndSetTrustURL(request,response);
        response.setHeader("Access-Control-Allow-Credentials","true");

    }
    public static void setResponseAttributesforGBK(HttpServletRequest request,HttpServletResponse response){
    	response.setContentType("text/html;charset=gbk");
        checkAndSetTrustURL(request,response);
        response.setHeader("Access-Control-Allow-Credentials","true");

    }
 

    public static void writeResponseJsonRet(HttpServletRequest request,HttpServletResponse response,String ret_Code,String ret_message){
    	Map model=new HashMap();
    	model.put(RET_CODE, ret_Code);
    	model.put(RET_MSG, ret_message);
    	JSONObject json=writeJSON_Object(request,response, model);
    	if(json!=null)
    		logger.info("partyNO:"+request.getRemoteUser()+"\t request urI:"+request.getRequestURI()+"\t return json ret==>"+json.toString());  	
    }
 

 
}
