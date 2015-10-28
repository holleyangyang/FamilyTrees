package com.yy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yy.dao.FamilyTreeDao;
import com.yy.entity.FamilyTree;
import com.yy.service.FamilyTreeService;
import com.yy.util.ExtHelper;

@Service
public class FamilyTreeServiceImpl implements FamilyTreeService{
	@Autowired
    @Qualifier("familyTreeDao")
	private  FamilyTreeDao familyTreeDao;

	 
	/**
	 * 添加菜单
	 */
	public boolean addFunNode(String id, String name, String url, String pId,String isOpen) {
		System.out.println("a="+name);
		 FamilyTree familyTree=new FamilyTree();
		 familyTree.setId(id);
		 familyTree.setName(name);
		 familyTree.setUrl(url);
		 familyTree.setOpen(isOpen);
		 familyTree.setpId(pId);
		 
		 
		 familyTreeDao.addFunTree(familyTree);
		return true;
	}

	/**
	 * 
	 * 删除菜单
	 */
	public boolean delFunNode(String id) {
		
		boolean sign=familyTreeDao.delNodeById(id);
		return sign;
	}

	/**
	 * 
	 * 取得分页菜单信息
	 */
	public List getFunTree(String title, String start, String limit) {
		
		List nodeList=familyTreeDao.getNodes(title, start, limit);
		
		return nodeList;
	}

	
	/**
	 * 根据ID来查询菜单
	 */
	public Object getNodeById(String id) {
		FamilyTree fTree=new FamilyTree();
		fTree=familyTreeDao.getNodeById(id).get(0);
		return fTree;
	}

	
	/**
	 * 查询所有菜单信息
	 */
	public String queryFunTree() {
		 List<FamilyTree> tlist=familyTreeDao.getAllNode();
		String jsonString=ExtHelper.listToJson(tlist);
		System.out.println("jsonString..."+jsonString);
		return jsonString;
	}

	
	/**
	 * 更新菜单信息
	 */
	public boolean updateFunNode(String sid, String id, String text, String url,String leaf) {
		FamilyTree fTree=new FamilyTree();
		fTree.setId(id);
	 
		
		boolean sign=familyTreeDao.updateNode(fTree, sid);
		
		return sign;
	}

	@Override
	public String getNodeByParentId(String Pid) {
		// TODO Auto-generated method stub
		List list =familyTreeDao.getNodeByParentId(Pid);
		String jsonString=ExtHelper.listToJson(list);
		return jsonString;
	}
 

	 
	 
	
}