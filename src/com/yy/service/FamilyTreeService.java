package com.yy.service;

import java.util.HashMap;
import java.util.List;

@SuppressWarnings("unchecked")
public interface FamilyTreeService {
	public String queryFunTree();
	public boolean addFunNode(String id, String name, String url, String pId,String isOpen);
	public boolean delFunNode(String id);
	public boolean updateFunNode(String id, String name, String url, String pId,String isOpen);
	public List getFunTree(String title,String start,String limit);
	public Object getNodeById(String id);
	public String getNodeByParentId(String Pid);
	
}
