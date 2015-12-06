package com.yy.dao;


import java.util.List;




import com.yy.entity.FamilyTree;

import org.mybatis.spring.annotation.Mapper;
import org.springframework.stereotype.Service;
 
@Service
@Mapper("familyTreeDao")
public interface FamilyTreeDao {
	
	public List<FamilyTree> getAllNode();
	public List<FamilyTree> getNodeById(String id);
	public List getNodes(String title,String start,String limit);
	public boolean addFunTree(FamilyTree nodes);
	public boolean updateNode(FamilyTree node,String sid);
	public boolean delNodeById(String id);
	public boolean delNodeBParentyId(String pId);
	public List<FamilyTree> getNodeByParentId(String pId);

}
