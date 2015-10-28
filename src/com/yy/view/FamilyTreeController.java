package com.yy.view;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

 



import com.yy.service.FamilyTreeService;
import com.yy.util.ExtHelper;
import com.yy.util.StringUtil;
import com.yy.entity.FamilyTree;
@RequestMapping(value = "/FamilyTree")
@Controller
public class FamilyTreeController {
@Autowired
private FamilyTreeService familyTreeService;
	
	/**
	 * 
	 * 新增菜单
	 * @param request
	 * @param response纯纯粹粹
	 * @throws IOException 
	 */
	@RequestMapping(value = "/addFunTree" ,method=RequestMethod.POST)
    public void addFunTreeNote(HttpServletRequest request, HttpServletResponse response) throws IOException{
	//	request.setCharacterEncoding("GBK"); 
		
			String name =request.getParameter("name");
			 name=java.net.URLDecoder.decode(name,"utf8");
			 System.out.println(name);
			String id =request.getParameter("id");
			 
			String pId = request.getParameter("pId");
			String url = request.getParameter("url");
			String open = request.getParameter("open");
			this.familyTreeService.addFunNode(id, name, url, pId,open);

    }
	
	/**
	 * 
	 * 查询所有菜单
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value = "/queryFunTree")
	public void queryFunTree(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		 response.setCharacterEncoding("UTF-8");  
		String res = this.familyTreeService.queryFunTree();
		System.out.println("res----------"+res);
		try {
			response.getWriter().write(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 return;
	}
	
 
	/**
	 * 
	 * 根据id来查询信息
	 * @param request
	 * @param response
	 */	 
		@RequestMapping(value = "/queryFunTreeById")
		public void queryNodeById(HttpServletRequest request, HttpServletResponse response){
			try {
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/json;charset=UTF-8");
			    String  id = request.getParameter("id");
			    
			    if(StringUtil.isNullOrBlank(id)){
			    	String res = this.familyTreeService.queryFunTree();
					System.out.println("res----------"+res);
					try {
						response.getWriter().write(res);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				
			    }else{
			    FamilyTree tree=(FamilyTree) this.familyTreeService.getNodeById(id);
				String json = null;
				if(tree != null){  
					json = "{success:true,data:"+ExtHelper.getJsonFromBean(tree)+"}";
				}else{
					json = "{success:false}";
				}
				response.getWriter().write(json);
			    
			    }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    
		}
		/**
		 * 
		 * 根据id来查询信息
		 * @param request
		 * @param response
		 */	 
			@RequestMapping(value = "/queryFunTreeByParentId")
			public void queryNodeByParentId(HttpServletRequest request, HttpServletResponse response){
				 response.setCharacterEncoding("UTF-8");  
				 String id=request.getParameter("id");
				 
				 if(StringUtil.isNullOrBlank(id)){
				    	String res = this.familyTreeService.queryFunTree();
						System.out.println("res----------"+res);
						try {
							response.getWriter().write(res);
						} catch (IOException e) {
							e.printStackTrace();
						}
				 }else{
				 
					String res = this.familyTreeService.getNodeByParentId(id);
					System.out.println("res----------"+res);
					try {
						response.getWriter().write(res);
					} catch (IOException e) {
						e.printStackTrace();
					}

				 }
			}
	/**
	 * 
	 * 删除所选择的菜单
	 * @param request
	 * @param response
	 */	 
		@RequestMapping(value = "/deleteTreeById")
		public void deleteTreeById(HttpServletRequest request, HttpServletResponse response){
			try {
				request.setCharacterEncoding("UTF-8");
			    String  id = request.getParameter("id");
				String[] arr = id.split(",");
				boolean isSuccess=false;
				for(int i=0;i<arr.length;i++){
				 isSuccess = this.familyTreeService.delFunNode(arr[i]);
				}
				response.getWriter().write("{success:"+isSuccess+"}");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		/**
		 * 
		 * 修改所选择的菜单
		 * @param request
		 * @param response
		 */	 
			@RequestMapping(value = "/updateTreeById")
			public void updateTreeById(HttpServletRequest request, HttpServletResponse response){
				try {
					request.setCharacterEncoding("UTF-8");
					String sid = request.getParameter("sid");
					String id = request.getParameter("id");
					String text = request.getParameter("text");
					String leaf = request.getParameter("leaf");
					String url = request.getParameter("url");
					boolean sign=this.familyTreeService.updateFunNode(sid, id, text, url,leaf);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
	
}
